package chat;

import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;

public class MultiServerThread implements Runnable {
	private Socket socket; // 소켓
	private MultiServer ms; // 멀티 서버
	private ObjectInputStream ois; // 입력
	private ObjectOutputStream oos; // 출력
	private ResultSet rs;

	public MultiServerThread(MultiServer ms) {
		this.ms = ms;
	}

	public synchronized void run() { // 실행 내용
		boolean isStop = false; // 실행 가능하지 확인
		try {
			socket = ms.getSocket(); // 소켓 받기
			ois = new ObjectInputStream(socket.getInputStream()); // input stream 생성
			oos = new ObjectOutputStream(socket.getOutputStream()); // output stream 생성
			String message = null; // 메시지 생성
			while (!isStop) {
				message = (String) ois.readObject(); // 객체 읽고 문자 저장
				String[] str = message.split("#"); // #으로 ID와 문장 나누기

				if (str[1].equals("exit")) { // 문장이 exit면 종료
					DB.executeUpdate("UPDATE users SET last_login=CURRENT_TIMESTAMP WHERE user_id='"+ str[0] + "'");
					broadCasting(message); // 메시지를 모두에게 전송
					isStop = true;
				} else if (str[1].equals("start")) {
					ms.addUser(str[0]);
					broadCasting(message); // 메시지를 모두에게 전송
//					DB.executeUpdate("UPDATE users SET last_login=CURRENT_TIMESTAMP WHERE user_id='"+ str[0] + "'");
				} else if (str[1].equals("/n")) {
					DB.executeUpdate("INSERT INTO notice " + "(user_id, notice_msg) " + "VALUES ('" + str[0] + "', '"
							+ str[2] + "')");
					broadCasting(message); // 메시지를 모두에게 전송
				} else if (str[1].equals("list")) {
					for (int i = 0; i < ms.getUserList().size(); i++) {
						message += "#" + ms.getUserList().get(i);
					}
					int target = ms.getUserList().indexOf(str[0]); // 메시지를 보낼 타겟번호
					ms.getList().get(target).send(message);
				} else if (str[1].equals("/w")) {
					whisper(str);
				} else if (str[1].equals("/k")) {
					kick(str);
				} else {
					String user_id = getUserIDfromNickname(str[0]);
					DB.executeUpdate("INSERT INTO chat_log " + "(user_id, chat_msg, chat_time) " + 
				"VALUES ('" + user_id + "', '"+ str[1] + "' , current_timestamp)");
					broadCasting(message); // 메시지를 모두에게 전송
				}
			}
			ms.getUserList().remove(message.split("#")[0]);
			ms.getList().remove(this); // list에서 이 객체를 제거
			System.out.println(socket.getInetAddress() + "정상적으로 종료하셨습니다");
			System.out.println("list size : " + ms.getList().size());
		} catch (

		Exception e) {
			ms.getList().remove(this); // list에서 이 객체를 제거
			System.out.println(socket.getInetAddress() + "비정상적으로 종료하셨습니다");
			System.out.println("list size : " + ms.getList().size());
		}
	}

	private void whisper(String[] str) {
		String user_id = getUserIDfromNickname(str[0]); // 송신자 아이디 찾기
		String receive_id = getUserIDfromNickname(str[2]); // 수신자 아이디 찾기
		try {
			int target = ms.getUserList().indexOf(str[2]); // 귓속말을 받을 타겟번호
			ms.getList().get(target).send(str[0] + "#" + "[귓속말] " + str[3]); // 송신할 메시지
			target = ms.getUserList().indexOf(str[0]);
			ms.getList().get(target).send(str[0] + "#" + "[귓속말] " + str[3]); // 송신할 메시지
			DB.executeUpdate("INSERT INTO chat_log " + "(user_id, chat_msg, receive_id, chat_time) "
					+ "VALUES ('" + user_id	+ "', '" + str[3] + "', '" + receive_id + "', current_timestamp)");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void kick(String[] str) {
		String user_id = getUserIDfromNickname(str[2]); // 수신자 아이디 찾기
		try {
			if (str[0].equals("admin")) {
				int target = ms.getUserList().indexOf(str[2]);
				broadCasting(str[0] + "#" + str[2] + "가 강퇴되었습니다.");
				ms.getList().get(target).send(str[0] + "#kick#" + str[2]);
				System.out.println(
						"UPDATE users " + "SET kick_count = kick_count + 1 " + "WHERE user_id = '" + user_id + "'");
				DB.executeUpdate(
						"UPDATE users " + "SET kick_count = kick_count + 1 " + "WHERE user_id = '" + user_id + "'");
			} else {
				int target = ms.getUserList().indexOf(str[0]);
				ms.getList().get(target).send(str[0] + "#강퇴권한이 없습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getUserIDfromNickname(String nickname) {
		String user_id = new String();
		try {
			rs = DB.getResultSet("SELECT user_id " + "FROM users " + "WHERE nickname = '" + nickname + "'" + "");
			while (rs.next()) {
				user_id = rs.getString("user_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user_id;
	}

	public void broadCasting(String message) throws IOException { // 모두에게 메시지 보내기
		for (MultiServerThread ct : ms.getList()) {
			ct.send(message);
		}
	}

	public void send(String message) throws IOException { // 메시지 보내기
		oos.writeObject(message);
	}
}

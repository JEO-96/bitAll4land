package day8;

import java.net.*;
import java.io.*;

public class MultiServerThread implements Runnable {
	private Socket socket; // 소켓
	private MultiServer ms; // 멀티 서버
	private ObjectInputStream ois; // 입력
	private ObjectOutputStream oos; // 출력

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
					broadCasting(message); // 메시지를 모두에게 전송
					isStop = true;
				} else if (str[1].equals("start")) {
					ms.addUser(str[0]);
					broadCasting(message); // 메시지를 모두에게 전송
				} else if (str[1].equals("list")) {
					for (int i = 0; i < ms.getUserList().size(); i++) {
						message += "#" + ms.getUserList().get(i);
					}
					int target = ms.getUserList().indexOf(str[0]); // 메시지를 보낼 타겟번호
					ms.getList().get(target).send(message);
				} else if (str[1].equals("/w")) {
					int target = ms.getUserList().indexOf(str[2]); // 메시지를 보낼 타겟번호
					ms.getList().get(target).send(str[0] + "#" + "[귓속말] " + str[3]);
				} else if (str[1].equals("/k")) {
					if (0 == ms.getUserList().indexOf(str[0]) && !str[0].equals(str[2])) {
            		int target = ms.getUserList().indexOf(str[2]);
                	ms.getList().get(target).send(str[0] + "#kick#" + str[2]);
                	} else {
                		int target = ms.getUserList().indexOf(str[0]);
                        ms.getList().get(target).send(str[0] + "#강퇴권한이 없습니다.");
                	}

                	
				}

				else {
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

	public void broadCasting(String message) throws IOException { // 모두에게 메시지 보내기
		for (MultiServerThread ct : ms.getList()) {
			ct.send(message);
		}
	}

	public void send(String message) throws IOException { // 메시지 보내기
		oos.writeObject(message);
	}
}

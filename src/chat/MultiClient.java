package chat;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;

public class MultiClient implements ActionListener {
	private Socket socket; // 신호를 송수신 할 수 있게 해주는 소켓
	private ObjectInputStream ois; // 신호를 받는 객체
	private ObjectOutputStream oos; // 신호를 전달하는 객체
	private JFrame jframe; // 프레임
	
	private JTextField jtf; // 채팅 문구 입력
	private JTextArea jta; // 채팅 내용 띄우기
	private JLabel userID_Label, iP_Label, noticeLabel, noticeContentsLabel; // 유저 ID, IP, "공지", 공지문구
	private JPanel jp1, jp2, jp3, jp4, jp5, jp6; // South, North, South(버튼), Center, jp4.North
	private String ip; // ip 주소
	private String id; // 사용자 id
	private JButton inputBtn, emoticonBtn, clearBtn, userListBtn, noticeResigtrationBtn, adminBtn; // 입력, 이모티콘, 공지등록, 초기화, 유저목록,

	// 공지등록

	public MultiClient(String argIp, String argId) {
		ip = argIp;
		id = argId;
		jframe = new JFrame("Multi Chatting");
		jtf = new JTextField(30);
		jta = new JTextArea("", 30, 40);
		userID_Label = new JLabel("Usage ID : [[ " + id + "]]");
		iP_Label = new JLabel("IP : " + ip);
		noticeLabel = new JLabel("공지");
		noticeContentsLabel = new JLabel("");
		inputBtn = new JButton("입력");
		emoticonBtn = new JButton("😊");
		clearBtn = new JButton("Clear");
		userListBtn = new JButton("사용자목록");
		noticeResigtrationBtn = new JButton("공지등록");
		adminBtn = new JButton("관리자");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		userID_Label.setBackground(Color.yellow);
		iP_Label.setBackground(Color.green);
		jta.setBackground(Color.white);

		jp1.setLayout(new BorderLayout());
		jp2.setLayout(new BorderLayout());

		jp1.add(jp3, BorderLayout.WEST);
		jp1.add(inputBtn, BorderLayout.EAST);

		jp3.add(emoticonBtn, BorderLayout.WEST);
		jp3.add(clearBtn, BorderLayout.WEST);

		jp1.add(jtf, BorderLayout.CENTER);
		jp2.add(userID_Label, BorderLayout.WEST);
		jp2.add(iP_Label, BorderLayout.CENTER);
		jp2.add(jp6, BorderLayout.EAST);
		jp6.setLayout(new BorderLayout());
		jp6.add(userListBtn, BorderLayout.EAST);
		jp6.add(adminBtn, BorderLayout.WEST);

		jp5.setLayout(new BorderLayout());
		jp5.add(noticeLabel, BorderLayout.WEST);
		jp5.add(noticeContentsLabel, BorderLayout.CENTER);
		jp5.add(noticeResigtrationBtn, BorderLayout.EAST);

		jframe.add(jp1, BorderLayout.SOUTH);
		jframe.add(jp2, BorderLayout.NORTH);
		jframe.add(jp4, BorderLayout.CENTER);
		jp2.add(jp5, BorderLayout.SOUTH);
		JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jp4.add(jsp, BorderLayout.CENTER);
		
		adminBtn.addActionListener(this);
		jtf.addActionListener(this);
		inputBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		emoticonBtn.addActionListener(this);
		noticeResigtrationBtn.addActionListener(this);
		userListBtn.addActionListener(this);

		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					oos.writeObject(id + "#exit");
				} catch (IOException ee) {
					ee.printStackTrace();
				}
				System.exit(0);
			}

			public void windowOpened(WindowEvent e) {
				jtf.requestFocus();
			}
		});
		if (!id.equals("admin"))
			adminBtn.setVisible(false);
		setNotice();
		jta.setEditable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		jframe.pack();
		jframe.setLocation((screenWidth - jframe.getWidth()) / 2, (screenHeight - jframe.getHeight()) / 2);
		jframe.setResizable(false);
		jframe.setVisible(true);
	}
	
	public void setNotice() {
		try {
			ResultSet rs = DB.getResultSet("SELECT * FROM notice ORDER BY notice_id DESC LIMIT 1");
			while(rs.next()) {
				noticeContentsLabel.setText(rs.getString("user_id") + " : " + rs.getString("notice_msg")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ActionListener 함수들 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf.getText();
		if (obj == jtf) { // 이벤트를 받은 객체가 JTextField인 경우
			jTextFieldAction(msg);
		} else if (obj == inputBtn) { // 이벤트를 받은 객체가 입력 버튼인 경우
			inputBtnAction(msg);
		} else if (obj == clearBtn) { // 채팅 모두 지우기
			jta.setText("");
		} else if (obj == emoticonBtn) { // 이모티콘 버튼
			imojiBtnAction(this);
		} else if (obj == noticeResigtrationBtn) { // 공지사항 등록 버튼
			noticeBtnAction();
		} else if (obj == userListBtn) { // 유저 리스트 버튼
			userListBtnAction();
		} else if (obj == adminBtn) {
				new AdminWindow(this);
		}
	}

	public void userListBtnAction() {
		sendMessage("list");
	}

	public void sendMessage(String msg) { // 메시지를 보내는 기능
		if (msg == null || msg.length() == 0) {
			JOptionPane.showMessageDialog(jframe, "글을쓰세요", "경고", JOptionPane.WARNING_MESSAGE);
		}
		else {
			try {
				oos.writeObject(id + "#" + msg); // 메시지 전달
			} catch (IOException ee) {
				ee.printStackTrace();
			}
			jtf.setText("");
		}
	}

	public void jTextFieldAction(String msg) { // 텍스트필드의 입력을 감지하면 메시지 전송
		sendMessage(msg);
	}

	public void inputBtnAction(String msg) { // 입력 버튼의 클릭을 감지하면 메시지 전송
		sendMessage(msg);
	}

	public void imojiBtnAction(MultiClient chat) {
		new Emoji(chat);
	}

	public void noticeBtnAction() {
		new Notice(this);
	}

	public void exit() {
		try {
			oos.writeObject(id + "#exit");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

	public void start() {
		sendMessage("start");
	}

	public JLabel getNoticeContentsLabel() {
		return noticeContentsLabel;
	}

	public void init() throws IOException {
		socket = new Socket(ip, 5000);
		System.out.println("connected...");
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		MultiClientThread ct = new MultiClientThread(this);
		Thread t = new Thread(ct);
		t.start();
		start();
	}

//    public static void main(String args[]) throws IOException {
//    	Scanner sc = new Scanner(System.in);
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        System.out.println("user name input :");
//        String name = sc.next();
//        MultiClient cc = new MultiClient("127.0.0.1",name);
//        cc.init();
//    }
	public ObjectInputStream getOis() {
		return ois;
	}

	public JTextArea getJta() {
		return jta;
	}

	public String getId() {
		return id;
	}

	public JTextField getJtf() {
		return jtf;
	}

	public void setJtf(String text) {
		jtf.setText(text);
	}

	public JFrame getJframe() {
		return jframe;
	}
	
	public ObjectOutputStream getOos() {
		return oos;
	}
}

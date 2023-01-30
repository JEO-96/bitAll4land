package chat;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;


public class Notice extends JFrame implements ActionListener {
	private JTextField jtf;
	private JButton jbt;
	private JPanel jp;
	private MultiClient mc;
	
	
	public Notice(MultiClient mc) {
		this.mc = mc;
		setTitle("공지 변경");
		
		jtf = new JTextField(20);
		jbt = new JButton("공지 등록");
		jp = new JPanel();
		
		jp.setLayout(new BorderLayout());
		jp.add(jtf, BorderLayout.CENTER);
		jp.add(jbt, BorderLayout.EAST);
		add(jp);
		jbt.addActionListener(this);
		jtf.addActionListener(this);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		pack();
		setSize(400, 80);
		setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf.getText();
		if (obj == jtf) {
			jTextFieldAction(jtf.getText());
		} else if (obj == jbt) {
			jTextFieldAction(jtf.getText());
		}
	}
	public void jTextFieldAction(String msg) {	// 텍스트필드의 입력을 감지하면 메시지 전송
		sendMessage(msg);
	}
	public void sendMessage(String msg) {	// 메시지를 보내는 기능
		if (msg == null || msg.length() == 0) {
			JOptionPane.showMessageDialog(this, "글을쓰세요", "경고", JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				mc.getOos().writeObject(mc.getId() + "#/n#" + msg); // 메시지 전달
			} catch (IOException ee) {
				ee.printStackTrace();
			}
			jtf.setText("");	// 텍스트 필드 초기화
		}
		setVisible(false);
	}
}

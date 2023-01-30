package chat;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;
import java.sql.ResultSet;

import javax.swing.*;


public class AdminWindow extends JFrame implements ActionListener{
	JPanel jp;
	JButton userListBtn, chatLogBtn;
	MultiClient mc;
	public AdminWindow(MultiClient mc) {
		setTitle("관리자 창");
		userListBtn = new JButton("사용자 목록");
		chatLogBtn = new JButton("채팅 기록 확인");
		this.mc = mc; 
		
		setLayout(new GridLayout(0,1,20,20));
		add(userListBtn);
		add(chatLogBtn);
		
		userListBtn.addActionListener(this);
		chatLogBtn.addActionListener(this);
		setSize(300, 200);
		setLocation(mc.getJframe().getX() - getWidth() - 5, mc.getJframe().getY());
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == userListBtn) {
			new UserListWindow(mc);
			dispose();
		} else if (obj == chatLogBtn) {
			new ChatLogWindow(mc);
			dispose();
		}
	}

}

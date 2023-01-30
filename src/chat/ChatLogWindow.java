package chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class ChatLogWindow extends JFrame implements ActionListener{
	JTextField textField;
	JButton btn;
	JTextArea textArea;
	JPanel northPanel, centerPanel;
	JLabel label;
	MultiClient mc;
	
	public ChatLogWindow(MultiClient mc) {
		setTitle("사용자 채팅 기록");
		this.mc = mc;
		textField = new JTextField();
		textArea = new JTextArea();
		northPanel = new JPanel();
		centerPanel = new JPanel();
		btn = new JButton("검색");
		label = new JLabel("닉네임: ");
		textArea = new JTextArea("", 30, 40);
		
		textArea.setEditable(false);
		setLayout(new BorderLayout());
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		northPanel.setLayout(new BorderLayout());
		northPanel.add(textField, BorderLayout.CENTER);
		northPanel.add(btn, BorderLayout.EAST);
		northPanel.add(label, BorderLayout.WEST);
		
		btn.addActionListener(this);
		textField.addActionListener(this);
		
		JScrollPane jsp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		centerPanel.add(jsp, BorderLayout.CENTER);
		
		setSize(500, 600);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn || obj == textField) {
			textArea.setText("");
			String nickname = textField.getText();
			ResultSet rs = DB.getResultSet("select distinct * from chat_log "
					+ "join users "
					+ "on users.user_id = chat_log.user_id "
					+ "where users.nickname like '%"+ nickname +"%'");
							// + "ORDER BY chat_time");
			try {
				while(rs.next()) {
					textArea.append(rs.getString("nickname") + " : " + rs.getString("chat_msg") + " "
					+ rs.getString("chat_time").substring(0, 16)+
					System.getProperty("line.separator"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}

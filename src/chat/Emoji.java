package chat;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import java.util.ArrayList;

public class Emoji extends JFrame implements ActionListener {

	final int PointColor = 0xD9E5FF;
	private JPanel pEmoji;
	private JPanel pTitle;
	private JLabel lblTitle;
	private ArrayList<JButton> arrBtnEmoji;

	private MultiClient chat;

	public Emoji(MultiClient chat) {

		arrBtnEmoji = new ArrayList<>();

		this.chat = chat;

		setTitle("EMOJI");
		setSize(400, 300);

		addTitle();
		add(pTitle, BorderLayout.NORTH);

		// 이모티콘 추가
		addGridEmoji();
		JScrollPane jsp = new JScrollPane(pEmoji, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(jsp, BorderLayout.CENTER);

//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫을 때 종료
//      setLocationRelativeTo(null); // 화면 중앙에 출력
		
		setLocation(chat.getJframe().getLocation().x - getWidth() - 5, chat.getJframe().getLocation().y);
		setResizable(false); // 크기 고정
		setVisible(true);
	}

	private void addTitle() {

		pTitle = new JPanel();
		pTitle.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblTitle = new JLabel("| 이모티콘 목록");
		lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		pTitle.add(lblTitle);

	}

	private void addGridEmoji() {
		ResultSet rs = DB.getResultSet("SELECT emoji_text FROM emoji");
		try {
			while (rs.next()) {
				arrBtnEmoji.add(new JButton(rs.getString("emoji_text")));
			}
			int height = arrBtnEmoji.size() / 3 + 1;
			pEmoji = new JPanel();
			pEmoji.setLayout(new GridLayout(height, 3, 20, 20));
			pEmoji.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			pEmoji.setBackground(Color.white);
			for (int i = 0; i < arrBtnEmoji.size(); i++) {
				btnStyle(arrBtnEmoji.get(i));
				pEmoji.add(arrBtnEmoji.get(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void btnStyle(JButton btn) {
		btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		for (int i = 0; i < arrBtnEmoji.size(); i++) {
			if (obj == arrBtnEmoji.get(i)) {
				chat.setJtf(chat.getJtf().getText() + arrBtnEmoji.get(i).getText());
			}
		}
	}
}

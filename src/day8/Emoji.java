package day8;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.ArrayList;

public class Emoji extends JFrame implements ActionListener {

	final int PointColor = 0xD9E5FF;
	final int BGCOLOR = 0x001054;
	private JPanel pEmoji;
	private JButton btnEmoji1;
	private JButton btnEmoji2;
	private JButton btnEmoji3;
	private JButton btnEmoji4;
	private JButton btnEmoji5;
	private JButton btnEmoji6;
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
		add(pEmoji, BorderLayout.CENTER);

//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫을 때 종료
//      setLocationRelativeTo(null); // 화면 중앙에 출력
		setLocation(350, 500);
		setResizable(false); // 크기 고정
		setVisible(true);
	}

	private void addTitle() {

		pTitle = new JPanel();
		pTitle.setLayout(new FlowLayout(FlowLayout.LEFT));
		pTitle.setBackground(new Color(BGCOLOR));
		lblTitle = new JLabel("| 이모티콘 목록");
		lblTitle.setForeground(Color.white);
		lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		pTitle.add(lblTitle);

	}

	private void addGridEmoji() {
		pEmoji = new JPanel();
		pEmoji.setLayout(new GridLayout(3, 3, 20, 20));
		pEmoji.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		pEmoji.setBackground(Color.white);

		btnEmoji1 = new JButton("(❁´◡`❁)");
		btnStyle(btnEmoji1);
		pEmoji.add(btnEmoji1);

		btnEmoji2 = new JButton("(●'◡'●)");
		btnStyle(btnEmoji2);
		pEmoji.add(btnEmoji2);

		btnEmoji3 = new JButton("╰(*°▽°*)╯");
		btnStyle(btnEmoji3);
		pEmoji.add(btnEmoji3);

		btnEmoji4 = new JButton("ヾ(•ω•`)o");
		btnStyle(btnEmoji4);
		pEmoji.add(btnEmoji4);

		btnEmoji5 = new JButton("(ಥ_ಥ)");
		btnStyle(btnEmoji5);
		pEmoji.add(btnEmoji5);

		btnEmoji6 = new JButton("(⊙_⊙;)");
		btnStyle(btnEmoji6);
		pEmoji.add(btnEmoji6);

	}

	public void btnStyle(JButton btn) {
		btn.setBackground(Color.white);
		btn.addActionListener(this);
		arrBtnEmoji.add(btn); // arraylist에 버튼 추가
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnEmoji1) {
			chat.setJtf(chat.getJtf().getText() + "(❁´◡`❁)"); 
		} else if (obj == btnEmoji2) {
			chat.setJtf(chat.getJtf().getText() + "(●'◡'●)");
		} else if (obj == btnEmoji3) {
			chat.setJtf(chat.getJtf().getText() + "╰(*°▽°*)╯");
		} else if (obj == btnEmoji4) {
			chat.setJtf(chat.getJtf().getText() + "ヾ(•ω•`)o");
		} else if (obj == btnEmoji5) {
			chat.setJtf(chat.getJtf().getText() + "(ಥ_ಥ)");
		} else if (obj == btnEmoji6) {
			chat.setJtf(chat.getJtf().getText() + "(⊙_⊙;)");
		}
	}

}

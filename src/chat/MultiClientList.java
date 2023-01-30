package chat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MultiClientList extends JFrame implements ActionListener, ListSelectionListener {

	JPanel jp, jp2;
	JList uList;
	JButton whisperBtn, kickBtn;
	Vector<String> userListVector = new Vector<String>();
	MultiClient mc;
	private String reciveUser;

	public MultiClientList(MultiClient mc, String strUserList) {
		setTitle("이용자 목록");
		this.mc = mc;
		jp = new JPanel();
		jp2 = new JPanel();
		whisperBtn = new JButton("귓속말");
		kickBtn = new JButton("강퇴하기");
		jp.setLayout(new BorderLayout());
		jp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		String[] userList = strUserList.split("#");
		for (int i = 2; i < userList.length; i++) {
			userListVector.add(userList[i]);
		}

		uList = new JList<>(userListVector);
		uList.setFont(new Font("맑은고딕", Font.PLAIN, 14));

		JScrollPane jsp = new JScrollPane(uList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		jp.add(jsp, BorderLayout.CENTER);
		jp.add(jp2, BorderLayout.SOUTH);
		jp2.add(whisperBtn);
		jp2.add(kickBtn);
		add(jp);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		pack();
		setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);

		uList.addListSelectionListener(this);
		whisperBtn.addActionListener(this);
		kickBtn.addActionListener(this);
		
		setSize(400, 400);
		setResizable(false);
		setVisible(true);
	}

	public class UserDisp {
		JLabel userName;
		JButton button = new JButton("귓속말");

		public UserDisp(String userName) {
			this.userName = new JLabel(userName);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == whisperBtn) {

			if (reciveUser.equals("")) {
				JOptionPane.showMessageDialog(this, "귓속말 상대를 선택하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			} else {
				mc.setJtf("/w#" + reciveUser + "#");
				setVisible(false);
			}

		} else if (obj == kickBtn) {
			mc.setJtf("/k#" + reciveUser);
			setVisible(false);
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (!e.getValueIsAdjusting()) { // 이거 없으면 mouse 눌릴때, 뗄때 각각 한번씩 호출되서 총 두번 호출

			reciveUser = uList.getSelectedValue().toString(); // 보내는 사람 저장

		}
	}

}

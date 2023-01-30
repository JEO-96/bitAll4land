package chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class SignUp extends JFrame implements ActionListener {
	private JLabel idLable, nicknameLable, pw1Lable, pw2Lable;
	private JTextField idTextField, nicknameTextField;
	private JPasswordField pw1TextField, pw2TextField;
	private JButton idCheckBtn, nickNameCheckBtn, signUpBtn;
	private JPanel jpn1, jpn2, jpn3, jpn4;
	private boolean idCheick = false, nicknameCheick = false;

	public SignUp() {
		DB.init();
		idLable = new JLabel("　　　ID : ");
		nicknameLable = new JLabel("　닉네임 : ");
		pw1Lable = new JLabel("　　 PW : ");
		pw2Lable = new JLabel("PW 확인 : ");
		jpn1 = new JPanel();
		jpn2 = new JPanel();
		jpn3 = new JPanel();
		jpn4 = new JPanel();

		idTextField = new JTextField(20);
		nicknameTextField = new JTextField(20);
		pw1TextField = new JPasswordField(20);
		
		pw2TextField = new JPasswordField(20);
		idCheckBtn = new JButton("중복확인");
		nickNameCheckBtn = new JButton("닉네임 중복확인");
		signUpBtn = new JButton("회원 가입");

		actionListener();
		setLayout();
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		pack();
		setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
		setSize(400, 200);
		setResizable(false);
		setVisible(true);
	}

	private void setLayout() {
		setLayout(new GridLayout(5, 1, 3, 3));
		add(jpn1);
		add(jpn2);
		add(jpn3);
		add(jpn4);
		add(signUpBtn);
		jpn1.setLayout(new BorderLayout());
		jpn1.add(idLable, BorderLayout.WEST);
		jpn1.add(idTextField, BorderLayout.CENTER);
		jpn1.add(idCheckBtn, BorderLayout.EAST);

		jpn2.setLayout(new BorderLayout());
		jpn2.add(nicknameLable, BorderLayout.WEST);
		jpn2.add(nicknameTextField, BorderLayout.CENTER);
		jpn2.add(nickNameCheckBtn, BorderLayout.EAST);

		jpn3.setLayout(new BorderLayout());
		jpn3.add(pw1Lable, BorderLayout.WEST);
		jpn3.add(pw1TextField, BorderLayout.CENTER);

		jpn4.setLayout(new BorderLayout());
		jpn4.add(pw2Lable, BorderLayout.WEST);
		jpn4.add(pw2TextField, BorderLayout.CENTER);
		

	}

	private void actionListener() {
		idCheckBtn.addActionListener(this);
		nickNameCheckBtn.addActionListener(this);
		signUpBtn.addActionListener(this);
	}

	private void idCheckBtnAction() {
		String idText = idTextField.getText();
		ResultSet rs;
		try {
			rs = DB.stmt.executeQuery("SELECT count(user_id) " + "FROM users " + "WHERE user_id = '" + idText + "';");
			while (rs.next()) {
				if (rs.getInt("count") > 0) {
					JOptionPane.showMessageDialog(this, "아이디가 존재합니다", "경고", JOptionPane.WARNING_MESSAGE);
				} else { // 아이디 중복 아님
					JOptionPane.showMessageDialog(this, "사용할 수 있는 아이디입니다", "경고", JOptionPane.WARNING_MESSAGE);
					idCheick = true;	// 아이디 중복 확인
					idTextField.setEditable(false);	// 아이디 수정 불가
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void nickNameCheckBtnAction() {
		String nicknameText = nicknameTextField.getText();
		ResultSet rs;
		try {
			rs = DB.stmt.executeQuery("SELECT count(nickname) " + "FROM users " + "WHERE nickname = '" + nicknameText + "';");
			while (rs.next()) {
				if (rs.getInt("count") > 0) {
					JOptionPane.showMessageDialog(this, "닉네임이 존재합니다", "경고", JOptionPane.WARNING_MESSAGE);
				} else { // 아이디 중복 아님
					JOptionPane.showMessageDialog(this, "사용할 수 있는 닉네임입니다", "경고", JOptionPane.WARNING_MESSAGE);
					nicknameCheick = true;	//	닉네임 중복 확인
					nicknameTextField.setEditable(false);	// 닉네임 수정 불가
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	private void signUpBtnAction() {
		if (!idCheick) {
			JOptionPane.showMessageDialog(this, "아이디 중복체크 하시오", "경고", JOptionPane.WARNING_MESSAGE);
		} else if (!nicknameCheick) {
			JOptionPane.showMessageDialog(this, "닉네임 중복체크 하시오", "경고", JOptionPane.WARNING_MESSAGE);
		} else if (!pw1TextField.getText().equals(pw2TextField.getText())) {
			JOptionPane.showMessageDialog(this, "비밀번호가 다릅니다", "경고", JOptionPane.WARNING_MESSAGE);
		} else {
			DB.executeUpdate("INSERT INTO users ("
					+ " user_id, nickname, pw,"
					+ " last_login)"
					+ "VALUES('" + idTextField.getText() + "', '"
					+ nicknameTextField.getText() + "', '"
					+ pw1TextField.getText() + "', "
					+ "CURRENT_TIMESTAMP)");
			JOptionPane.showMessageDialog(this, "아이디가 생성되었습니다", "알람", JOptionPane.INFORMATION_MESSAGE);
			new MultiClientLogin();
			dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == idCheckBtn) {
			idCheckBtnAction();
		} else if (obj == nickNameCheckBtn) {
			nickNameCheckBtnAction();
		} else if (obj == signUpBtn) {
			signUpBtnAction();
		}
	}

	public static void main(String[] args) {
		new SignUp();
	}

}

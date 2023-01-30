package chat;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class MultiClientLogin extends JFrame implements ActionListener {

	private JTextField idTextField, pwTextField;
	private JLabel idLabel, pwLabel;
	private JPanel idPanel, pwPanel, buttonPanel;
	private JButton loginBtn, signUpBtn;	// 로그인 버튼
	private String name;
	private boolean check;
	
	public MultiClientLogin() {
		DB.init();
		setTitle("로그인");
		idTextField = new JTextField(20);
		pwTextField = new JPasswordField(20);
		idLabel = new JLabel("ID　:　");
		pwLabel = new JLabel("PW :　");
		idPanel = new JPanel();
		pwPanel = new JPanel();
		buttonPanel = new JPanel();
		loginBtn = new JButton("로그인");
		signUpBtn = new JButton("회원가입");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
        pack();
        
        
//        idTextField.setPreferredSize(new Dimension(10, 50));
        
        setLayout(new GridLayout(3, 1, 0, 0));
        
        idPanel.setLayout(new BorderLayout());
        pwPanel.setLayout(new BorderLayout());
        
        idPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        pwPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        
        idPanel.add(idLabel, BorderLayout.WEST);
        idPanel.add(idTextField, BorderLayout.CENTER);
        
        pwPanel.add(pwLabel, BorderLayout.WEST);
        pwPanel.add(pwTextField, BorderLayout.CENTER);
        
        
        
        buttonPanel.add(loginBtn, BorderLayout.WEST);
        buttonPanel.add(signUpBtn, BorderLayout.EAST);
        
        add(idPanel, BorderLayout.NORTH);
        add(pwPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        actionListner();
        

        setSize(400, 180);
        
        setLocation(
                (screenWidth - getWidth()) / 2,
                (screenHeight - getHeight()) / 2);
        setResizable(false);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	private void actionListner() {
		loginBtn.addActionListener(this);
		signUpBtn.addActionListener(this);
        idTextField.addActionListener(this);
        pwTextField.addActionListener(this);
	}
	
	private void loginBtnAction() {	// 로그인 버튼 액션
		check = false;
		
		String idText = idTextField.getText();
		String pwText = pwTextField.getText();
		String nic="";
		
		try {
			ResultSet rs = DB.getResultSet("SELECT * FROM users WHERE user_id = '" 
					+ idText + "' AND pw = '" + pwText 
					+ "'");
			while (rs.next()) {
				nic = rs.getString("nickname");
				check = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(check == true) {
					MultiClient cc = new MultiClient("127.0.0.1", nic);
		try {
			cc.init();
			dispose();	// 창 지우기
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		} else {
			JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 확인하세요", "경고", JOptionPane.WARNING_MESSAGE);
		}

	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == loginBtn || obj == idTextField || obj == pwTextField) {
			loginBtnAction();
		} else if(obj == signUpBtn) {
			new SignUp();
			dispose();
		}
        
	}
	
	public String getName() {
		return name;
	}
	public static void main(String[] args) {
		
		new MultiClientLogin();
	}
}

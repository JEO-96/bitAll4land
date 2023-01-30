package day8;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class MultiClientLogin extends JFrame implements ActionListener {

	private JTextField jtf;
	private JLabel jlb1, jlb2;
	private JPanel jp;
	private JButton enterBtn;	// 입장 버튼
	private String name;
	
	public MultiClientLogin() {
		setTitle("Login");
		jtf = new JTextField(20);
		jlb1 = new JLabel("ID: ");
		jlb2 = new JLabel("아이디를 입력하시오");
		jp = new JPanel();
		enterBtn = new JButton("입장");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
        pack();
        add(jp);
        jp.setLayout(new BorderLayout());
        jp.add(jlb2, BorderLayout.NORTH);
        jp.add(jlb1, BorderLayout.WEST);
        jp.add(jtf, BorderLayout.CENTER);
        jp.add(enterBtn, BorderLayout.EAST);
        
        
        enterBtn.addActionListener(this);
        jtf.addActionListener(this);
        setSize(400, 80);
        
        setLocation(
                (screenWidth - getWidth()) / 2,
                (screenHeight - getHeight()) / 2);
        setResizable(false);
        setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
        String msg = jtf.getText();
        String name = msg;
        MultiClient cc = new MultiClient("127.0.0.1",name);
        try {
			cc.init();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        setVisible(false);
	}
	
	public String getName() {
		return name;
	}
	public static void main(String[] args) {
		new MultiClientLogin();
	}
}

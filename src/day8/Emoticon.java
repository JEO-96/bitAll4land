package day8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Emoticon extends JFrame implements ActionListener {
	private JButton jbt1, jbt2, jbt3, jbt4, jbt5, jbt6;
	private MultiClient mc;
	private JPanel emoticon;

	public Emoticon(MultiClient mc) {
		setTitle("이모티콘");
		this.mc = mc;

		jbt1 = new JButton("(●'◡'●)");
		jbt2 = new JButton("(┬┬﹏┬┬)");
		jbt3 = new JButton("༼ つ ◕_◕ ༽つ");
		jbt4 = new JButton("(☞ﾟヮﾟ)☞");
		jbt5 = new JButton("☜(ﾟヮﾟ☜)");
		jbt6 = new JButton("(T_T)");

//		add(jbt1);
//		add(jbt2);
//		add(jbt3);
//		add(jbt4);
//		add(jbt5);
//		add(jbt6);
		addGridButton();
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		pack();
		setSize(400, 300);
		setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
		setResizable(false);
		setVisible(true);
	}
	public void addGridButton() {
		setLayout(new GridLayout(0, 3));
		emoticon.setLayout(new GridLayout(3, 3, 20, 20));
		emoticon.setBorder(BorderFactory.createEmptyBorder(20, 20, 20,20));
		emoticon.setBackground(Color.WHITE);
		
		emoticon.add(jbt1);
		emoticon.add(jbt2);
		emoticon.add(jbt3);
		emoticon.add(jbt4);
		emoticon.add(jbt5);
		emoticon.add(jbt6);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbt1) {
			mc.setJtf(mc.getJtf().getText() + "(●'◡'●)");
		} else if (obj == jbt2) {
			mc.setJtf(mc.getJtf().getText() + "(┬┬﹏┬┬)");
		} else if (obj == jbt3) {
			mc.setJtf(mc.getJtf().getText() + "༼ つ ◕_◕ ༽つ");
		} else if (obj == jbt4) {
			mc.setJtf(mc.getJtf().getText() + "(☞ﾟヮﾟ)☞");
		} else if (obj == jbt5) {
			mc.setJtf(mc.getJtf().getText() + "☜(ﾟヮﾟ☜)");
		} else if (obj == jbt6) {
			mc.setJtf(mc.getJtf().getText() + "(T_T)");
		}
	}


}

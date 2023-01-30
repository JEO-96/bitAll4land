package awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ActionEventEx extends Frame implements ActionListener, WindowListener {
	Panel p;
	Button input, exit;
	TextArea ta;

	public ActionEventEx() {
		super("ActionEvent Test");

		p = new Panel();

		input = new Button("1");
		exit = new Button("2");
		ta = new TextArea();

		input.addActionListener(this);
		exit.addActionListener(this);
		addWindowListener(this);

		p.add(input);
		p.add(exit);

		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		setBounds(300, 300, 300, 200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String name;
		name=ae.getActionCommand();
		
		if(name.equals("1"))
			ta.append("append1. \n");
		else
		{
			ta.append("append2.\n");
			try {
				Thread.sleep(2000);
			} catch(Exception e) {}
			
			System.exit(0);
		}
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new ActionEventEx();
	}

	

}

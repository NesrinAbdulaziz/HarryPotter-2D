package harrypotter.view;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import harrypotter.controller.ControllerStart;


@SuppressWarnings("serial")
public class StartPageView extends JFrame {
	private JButton b1;
	private JLabel l1;
	private JButton b12;
	private ControllerStart cont;

	String path="";
	public StartPageView(ControllerStart cont) {
		//setSize(1650, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		java.awt.Image image = toolkit.getImage(path+"harry_potter_wand_cursorfx_by_luna_daisy.png");
		Cursor a = toolkit.createCustomCursor(image, new java.awt.Point (0,0), "");
		this.setCursor (a);
		JLabel background = new JLabel(new ImageIcon("C:\\Users\\Computer\\Downloads\\colorful design.png"));
		add(background);
		JLabel logo= new JLabel(new ImageIcon(path+"3602728ff0b74d9f0d1a39db804cda42.png"));
		logo.setBounds(450, 150, 500, 200);
		background.add(logo);
		ImageIcon bb= new ImageIcon(path+"The_Leaving_Feast_-_B4C37M1.png");
		Image b = bb.getImage();
		Image newb  = ((Image) b).getScaledInstance(1650, 1080, java.awt.Image.SCALE_SMOOTH);
	    bb = new ImageIcon(newb);
		background.setIcon(bb);
		b1 = new JButton(new ImageIcon(path+"3f87d1b1e47b9b2f21077c17011d400d.png"));
		b1.addActionListener(cont);
		b1.setSize(50, 50);
		b1.setBounds(605, 450, 150, 70);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setForeground(Color.white);
		b1.setFocusPainted(false);
		background.add(b1);
		b12 = new JButton(new ImageIcon(path+"ba2150e785737b0e1878f9e04f3eb074.png"));
		b12.setSize(50, 50);
		b12.setBounds(605, 550, 150, 70);
		b12.addActionListener(cont);
		b12.setContentAreaFilled(false);
		b12.setBorderPainted(false);
		b12.setForeground(Color.white);
		b12.setFocusPainted(false);
		background.add(b12);
		

	}

	public JButton getB1() {
		return b1;
	}

	public void setB1(JButton b1) {
		this.b1 = b1;
	}

	public JLabel getL1() {
		return l1;
	}

	public void setL1(JLabel l1) {
		this.l1 = l1;
	}

	public JButton getB12() {
		return b12;
	}

	public void setB12(JButton b12) {
		this.b12 = b12;
	}

	public ControllerStart getCont() {
		return cont;
	}

	public void setCont(ControllerStart cont) {
		this.cont = cont;
	}



}

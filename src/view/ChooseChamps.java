
package harrypotter.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import harrypotter.controller.ControllerChoose;
@SuppressWarnings("serial")
public class ChooseChamps extends JFrame {
	private ArrayList<JButton> ch1;
	private ArrayList<JButton> ch2;
	private ArrayList<JButton> ch3;
	private ArrayList<JButton> ch4;

	String path="";
	private ArrayList<JButton> spellsB;

	public ArrayList<JButton> getCh1() {
		return ch1;
	}

	public void setCh1(ArrayList<JButton> ch1) {
		this.ch1 = ch1;
	}

	public ArrayList<JButton> getCh2() {
		return ch2;
	}

	public void setCh2(ArrayList<JButton> ch2) {
		this.ch2 = ch2;
	}

	public ArrayList<JButton> getCh3() {
		return ch3;
	}

	public void setCh3(ArrayList<JButton> ch3) {
		this.ch3 = ch3;
	}

	public ArrayList<JButton> getCh4() {
		return ch4;
	}

	public void setCh4(ArrayList<JButton> ch4) {
		this.ch4 = ch4;
	}

	public JTextField getName1() {
		return name1;
	}

	public void setName1(JTextField name1) {
		this.name1 = name1;
	}

	public JTextField getName2() {
		return name2;
	}

	public void setName2(JTextField name2) {
		this.name2 = name2;
	}

	public JTextField getName3() {
		return name3;
	}

	public void setName3(JTextField name3) {
		this.name3 = name3;
	}

	public JTextField getName4() {
		return name4;
	}

	public void setName4(JTextField name4) {
		this.name4 = name4;
	}

	public JButton getNxt() {
		return nxt;
	}

	public void setNxt(JButton nxt) {
		this.nxt = nxt;
	}

	private JTextField name1;
	private JTextField name2;
	private JTextField name3;
	private JTextField name4;
	private JButton nxt;
	private JButton exit;

	public ChooseChamps(ControllerChoose cc) {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1650, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		ImageIcon bb = new ImageIcon(path + "The_Leaving_Feast_-_B4C37M1.png");
		Image b = bb.getImage();
		Image newb = ((Image) b).getScaledInstance(1650, 1080, java.awt.Image.SCALE_SMOOTH);
		bb = new ImageIcon(newb);
		JLabel back = new JLabel(bb);
		add(back);
		JLabel logo = new JLabel(new ImageIcon(path + "49843289843ea249473bbbd4e6d253bd_1.png"));
		logo.setBounds(-160, -90, 1650, 300);
		back.add(logo);
		JPanel jp = new JPanel(new GridLayout(6, 4));
		back.add(jp);
		name1 = new JTextField("Name");
		name1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		name1.setForeground(new Color(0xC9A32C));
		name1.setOpaque(false);
		name1.addActionListener(cc);
		name2 = new JTextField("Name");
		name2.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		name2.setForeground(new Color(0xC9A32C));
		name2.setOpaque(false);
		name2.addActionListener(cc);
		name3 = new JTextField("Name");
		name3.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		name3.setForeground(new Color(0xC9A32C));
		name3.setOpaque(false);
		name3.addActionListener(cc);
		name4 = new JTextField("Name");
		name4.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		name4.setForeground(new Color(0xC9A32C));
		name4.setOpaque(false);
		name4.addActionListener(cc);
		JPanel f = new JPanel(new BorderLayout());
		JLabel ff = new JLabel(new ImageIcon(path + "d3c492ba7e4a0a7f274f223460cbb479_1.png"));
		ff.setOpaque(false);
		f.add(ff, BorderLayout.CENTER);
		f.add(name1, BorderLayout.AFTER_LAST_LINE);
		f.setOpaque(false);
		jp.add(f);
		JPanel f1 = new JPanel(new BorderLayout());
		JLabel ff1 = new JLabel(new ImageIcon(path + "f8d70ac95033006826fba33e74f1a373_1.png"));
		ff1.setOpaque(false);
		f1.add(ff1, BorderLayout.CENTER);
		f1.add(name2, BorderLayout.AFTER_LAST_LINE);
		f1.setOpaque(false);
		jp.add(f1);
		JPanel f2 = new JPanel(new BorderLayout());
		JLabel ff2 = new JLabel(new ImageIcon(path + "18052830_1083539261751019_436416607_n.png"));
		ff2.setOpaque(false);
		f2.add(ff2, BorderLayout.CENTER);
		f2.add(name3, BorderLayout.AFTER_LAST_LINE);
		f2.setOpaque(false);
		jp.add(f2);
		JPanel f3 = new JPanel(new BorderLayout());
		JLabel ff3 = new JLabel(new ImageIcon(path + "ddef56fc22428a417b0497b984cf9728_1.png"));
		ff3.setOpaque(false);
		f3.add(ff3, BorderLayout.CENTER);
		f3.add(name4, BorderLayout.AFTER_LAST_LINE);
		f3.setOpaque(false);
		jp.add(f3);
		ch1 = new ArrayList<>();
		ch2 = new ArrayList<>();
		ch3 = new ArrayList<>();
		ch4 = new ArrayList<>();
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		java.awt.Image image = toolkit.getImage(path + "harry_potter_wand_cursorfx_by_luna_daisy.png");
		Cursor a = toolkit.createCustomCursor(image, new java.awt.Point(0, 0), "");
		this.setCursor(a);
		ImageIcon gg = new ImageIcon(path + "gryffindor.png");
		Image g = gg.getImage();
		Image newG = ((Image) g).getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH);
		gg = new ImageIcon(newG);
		ImageIcon hh = new ImageIcon(path + "hufflepuff.png");
		Image h = hh.getImage();
		Image newh = ((Image) h).getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH);
		hh = new ImageIcon(newh);
		ImageIcon rr = new ImageIcon(path + "ravenclaw.png");
		Image r = rr.getImage();
		Image newr = ((Image) r).getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH);
		rr = new ImageIcon(newr);
		ImageIcon ss = new ImageIcon(path + "slytherin.png");
		Image s = ss.getImage();
		Image news = ((Image) s).getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH);
		ss = new ImageIcon(news);
		ImageIcon [] arr = {gg,hh,rr,ss};
		for (int i = 0; i < 4; i++) {
			ImageIcon c = arr[i];
			ch1.add(new JButton(c));
			ch1.get(i).setContentAreaFilled(false);
			ch1.get(i).setBorderPainted(false);
			ch1.get(i).setFocusPainted(false);
			ch1.get(i).setOpaque(false);
			ch2.add(new JButton(c));
			ch2.get(i).setContentAreaFilled(false);
			ch2.get(i).setBorderPainted(false);
			ch2.get(i).setFocusPainted(false);
			ch3.add(new JButton(c));
			ch3.get(i).setContentAreaFilled(false);
			ch3.get(i).setBorderPainted(false);
			ch3.get(i).setFocusPainted(false);
			ch4.add(new JButton(c));
			ch4.get(i).setContentAreaFilled(false);
			ch4.get(i).setBorderPainted(false);
			ch4.get(i).setFocusPainted(false);
			jp.add(ch1.get(i));
			ch1.get(i).addActionListener(cc);
			jp.add(ch2.get(i));
			ch2.get(i).addActionListener(cc);
			jp.add(ch3.get(i));
			ch3.get(i).addActionListener(cc);
			jp.add(ch4.get(i));
			ch4.get(i).addActionListener(cc);

		}
		spellsB = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			JButton b1 = new JButton(new ImageIcon(path + "56492491206d4af266e0881a14a030b0_1.png"));
			b1.setEnabled(false);
			b1.setContentAreaFilled(false);
			b1.setBorderPainted(false);
			b1.addActionListener(cc);
			b1.setFocusPainted(false);
			spellsB.add(b1);
			jp.add(b1);
		}

		nxt = new JButton(new ImageIcon(path + "9d89b6d76b1aedbd5b40df81d02093.png"));
		exit = new JButton(new ImageIcon(path + "exit.png"));

		exit.addActionListener(cc);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setOpaque(false);
		exit.setBounds(0, 690, 70, 100);

		nxt.setEnabled(false);
		nxt.addActionListener(cc);
		nxt.setContentAreaFilled(false);
		nxt.setBorderPainted(false);
		nxt.setFocusPainted(false);
		nxt.setOpaque(false);
		nxt.setBounds(1290, 690, 70, 100);
		back.add(exit);
		back.add(nxt);
		jp.setBounds(0, 90, 1365, 650);
		jp.setOpaque(false);

		revalidate();
		repaint();

	}


	public ArrayList<JButton> getSpellsB() {
		return spellsB;
	}

	public void setSpellsB(ArrayList<JButton> spellsB) {
		this.spellsB = spellsB;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}
}

package harrypotter.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import harrypotter.controller.FirstTaskCont;
import harrypotter.model.character.Wizard;

@SuppressWarnings("serial")
public class FirstTaskView extends JFrame {

	public JLabel photo1;
	public JLabel photo2;
	public JLabel photo3;
	public JLabel photo4;
	public ArrayList<JLabel>txt = new ArrayList<>();
	public JProgressBar getIp1() {
		return ip1;
	}

	public void setIp1(JProgressBar ip1) {
		this.ip1 = ip1;
	}

	public JProgressBar getIp2() {
		return ip2;
	}

	public void setIp2(JProgressBar ip2) {
		this.ip2 = ip2;
	}

	public JProgressBar getIp3() {
		return ip3;
	}

	public void setIp3(JProgressBar ip3) {
		this.ip3 = ip3;
	}

	public JProgressBar getIp4() {
		return ip4;
	}

	public void setIp4(JProgressBar ip4) {
		this.ip4 = ip4;
	}

	public JProgressBar getHp1() {
		return hp1;
	}

	public void setHp1(JProgressBar hp1) {
		this.hp1 = hp1;
	}

	public JProgressBar getHp2() {
		return hp2;
	}

	public void setHp2(JProgressBar hp2) {
		this.hp2 = hp2;
	}

	public JProgressBar getHp3() {
		return hp3;
	}

	public void setHp3(JProgressBar hp3) {
		this.hp3 = hp3;
	}

	public JProgressBar getHp4() {
		return hp4;
	}

	public void setHp4(JProgressBar hp4) {
		this.hp4 = hp4;
	}

	public JButton getUp() {
		return up;
	}

	public void setUp(JButton up) {
		this.up = up;
	}

	public JButton getDown() {
		return down;
	}

	public void setDown(JButton down) {
		this.down = down;
	}

	public JButton getLeft() {
		return left;
	}

	public void setLeft(JButton left) {
		this.left = left;
	}

	public JButton getRight() {
		return right;
	}

	public void setRight(JButton right) {
		this.right = right;
	}

	private JLabel background;
	private JLabel east;
	private JLabel west;
	private JLabel status;
	private JLabel pg;
	private JLabel champ1;
	private JLabel champ2;
	private JLabel champ3;
	private JLabel champ4;
	private JLabel cchamp;
	private JProgressBar ip1;
	private JProgressBar ip2;
	private JProgressBar ip3;
	private JProgressBar ip4;
	private JProgressBar hp1;
	private JProgressBar hp2;
	private JProgressBar hp3;
	private JProgressBar hp4;
	private JLabel buttons;
	private JButton spells;
	private JButton trait;
	private JButton potions;
	private ArrayList<JLabel> cells;

	private JLabel Info;
	private JLabel arrows;
	private JButton up;
	private JButton down;
	private JButton left;
	private JButton right;

	public JLabel infoTxt;
	public JLabel infoPic;
	public String path="";
	private JButton exit;

	@SuppressWarnings("static-access")
	public FirstTaskView(FirstTaskCont cont) {

		setSize(1650, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		background = new JLabel(new ImageIcon(path + "bg olfat.jpg"));
		east = new JLabel();
		west = new JLabel();
		status = new JLabel();
		pg = new JLabel();
		champ1 = new JLabel();
		champ2 = new JLabel();
		champ3 = new JLabel();
		champ4 = new JLabel();
		cchamp = new JLabel();
		exit = new JButton(new ImageIcon(path + "exit.png"));

		exit.addActionListener(cont);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setOpaque(false);
		exit.setBounds(0, 710, 70, 100);
		cchamp.setLayout(new GridLayout(1, 2));
		Info = new JLabel(new ImageIcon(path+"scrolll.png"));
		cchamp.add(Info);
		arrows = new JLabel();
		arrows.setLayout(new GridLayout(3, 1));
		up = new JButton(new ImageIcon(path + "up.png"));
		up.setContentAreaFilled(false);
		up.setBorderPainted(false);
		up.addActionListener(cont);
		arrows.add(up);
		JLabel lr = new JLabel();
		lr.setLayout(new GridLayout(1, 2));
		arrows.add(lr);
		left = new JButton(new ImageIcon(path + "left.png"));
		left.addActionListener(cont);
		left.setContentAreaFilled(false);
		left.setBorderPainted(false);
		lr.add(left);
		right = new JButton(new ImageIcon(path + "right.png"));
		right.addActionListener(cont);
		right.setContentAreaFilled(false);
		right.setBorderPainted(false);
		lr.add(right);
		down = new JButton(new ImageIcon(path + "down.png"));
		down.addActionListener(cont);
		down.setContentAreaFilled(false);
		down.setBorderPainted(false);
		arrows.add(down);
		buttons = new JLabel();
		cchamp.add(arrows);
		spells = new JButton(new ImageIcon(path + "rsz_1imageedit_52_5213659349.gif"));
		trait = new JButton(new ImageIcon(path + "rsz_imageedit_54_8622516755.png"));
		potions = new JButton(new ImageIcon(path + "rsz_imageedit_31_9916266214.gif"));
		cells = new ArrayList<>();
		ImageIcon c = new ImageIcon(path+"sch1.png");
		infoPic = new JLabel();
		infoPic.setBounds(20, 40, c.getIconWidth(),c.getIconHeight());
		Info.add(infoPic);
		infoTxt = new JLabel();
		infoTxt.setLayout(new GridLayout(7, 1));
		infoTxt.setBounds(70, 30, 300,90);
		Info.add(infoTxt);
		for(int i=0; i<7; i++)
		{
			txt.add(new JLabel());
			infoTxt.add(txt.get(i));
		}
		spells.setContentAreaFilled(false);
		trait.setContentAreaFilled(false);
		potions.setContentAreaFilled(false);
		spells.setBorderPainted(false);
		trait.setBorderPainted(false);
		potions.setBorderPainted(false);
		spells.addActionListener(cont);
		trait.addActionListener(cont);
		potions.addActionListener(cont);
		add(background);
		west.setBounds(-140, this.getY(), getWidth() / 4, getHeight() - 312);
		west.setLayout(new GridLayout(2, 1));
		west.add(champ1);
		west.add(champ3);
		buttons.setLayout(new GridLayout(1, 3));
		buttons.add(spells);
		buttons.add(potions);
		buttons.add(trait);
		east.setBounds(-140 + (getWidth() / 4) * 3, getY(), getWidth() / 4, getHeight() - 312);
		east.setLayout(new GridLayout(2, 1));
		east.add(champ2);
		east.add(champ4);
		status.setBounds(-140 + (this.getWidth() / 4), -200 + (this.getHeight() / 4) * 3, (this.getWidth() / 2), 158);
		status.setLayout(new GridLayout(1, 2));
		status.add(cchamp);
		status.add(buttons);
		pg.setBounds(-130 + (this.getWidth() / 4), this.getY(), (this.getWidth() / 2), getHeight() - 470);
		pg.setLayout(new GridLayout(10, 10));
		for (int i = 0; i < 100; i++) {
			JLabel j = new JLabel();
			pg.add(j);
			cells.add(j);
		}
		JLabel j1 = new JLabel();
		j1.setText(((Wizard) (cont.getChamps().get(0))).getName());
		j1.setFont(j1.getFont().deriveFont(32.0f));
		j1.setBounds(champ1.BOTTOM + 140, champ1.BOTTOM, 200, 50);
		j1.setForeground(new Color(0xC9A32C));
		champ1.add(j1);
		JLabel j2 = new JLabel();
		j2.setText(((Wizard) (cont.getChamps().get(1))).getName());
		j2.setFont(j2.getFont().deriveFont(32.0f));
		j2.setBounds(champ2.BOTTOM, champ2.BOTTOM, 200, 50);
		j2.setForeground(new Color(0xC9A32C));
		champ2.add(j2);
		JLabel j3 = new JLabel();
		j3.setText(((Wizard) (cont.getChamps().get(2))).getName());
		j3.setFont(j3.getFont().deriveFont(32.0f));
		j3.setBounds(champ3.BOTTOM + 140, champ1.BOTTOM, 200, 50);
		j3.setForeground(new Color(0xC9A32C));
		champ3.add(j3);
		JLabel j4 = new JLabel();
		j4.setText(((Wizard) (cont.getChamps().get(3))).getName());
		j4.setFont(j4.getFont().deriveFont(32.0f));
		j4.setBounds(champ4.BOTTOM, champ1.BOTTOM, 200, 50);
		j4.setForeground(new Color(0xC9A32C));
		champ4.add(j4);

		photo1 = new JLabel(new ImageIcon(path + "ch1.png"));
		photo1.setBounds(champ1.BOTTOM+40 + 140, champ1.BOTTOM + 50, photo1.getIcon().getIconWidth(),
				photo1.getIcon().getIconHeight());
		champ1.add(photo1);
		photo1.add(new JLabel(new ImageIcon("winner1.png")));

		photo2 = new JLabel(new ImageIcon(path + "ch2.png"));
		photo2.setBounds(champ2.BOTTOM+40, champ2.BOTTOM + 50, photo1.getIcon().getIconWidth(),
				photo1.getIcon().getIconHeight());
		champ2.add(photo2);
		photo3 = new JLabel(new ImageIcon(path + "ch3.png"));
		photo3.setBounds(champ1.BOTTOM+40 + 140, champ1.BOTTOM + 50, photo1.getIcon().getIconWidth(),
				photo1.getIcon().getIconHeight());
		champ3.add(photo3);
		photo4 = new JLabel(new ImageIcon(path + "ch4.png"));
		photo4.setBounds(champ2.BOTTOM+40, champ2.BOTTOM + 50, photo1.getIcon().getIconWidth(),
				photo1.getIcon().getIconHeight());
		champ4.add(photo4);
		background.add(east);
		background.add(west);
		background.add(pg);
		background.add(status);
		background.add(exit);

	}

	public JLabel getBackGround1(){
		return background;
	}


	public JLabel getEast() {
		return east;
	}

	public void setEast(JLabel east) {
		this.east = east;
	}

	public JLabel getWest() {
		return west;
	}

	public void setWest(JLabel west) {
		this.west = west;
	}

	public JLabel getStatus() {
		return status;
	}

	public void setStatus(JLabel status) {
		this.status = status;
	}

	public JLabel getPg() {
		return pg;
	}

	public void setPg(JLabel pg) {
		this.pg = pg;
	}

	public JLabel getChamp1() {
		return champ1;
	}

	public void setChamp1(JLabel champ1) {
		this.champ1 = champ1;
	}

	public JLabel getChamp2() {
		return champ2;
	}

	public void setChamp2(JLabel champ2) {
		this.champ2 = champ2;
	}

	public JLabel getChamp3() {
		return champ3;
	}

	public void setChamp3(JLabel champ3) {
		this.champ3 = champ3;
	}

	public JLabel getChamp4() {
		return champ4;
	}

	public void setChamp4(JLabel champ4) {
		this.champ4 = champ4;
	}

	public JLabel getCchamp() {
		return cchamp;
	}

	public void setCchamp(JLabel cchamp) {
		this.cchamp = cchamp;
	}

	public JLabel getButtons() {
		return buttons;
	}

	public void setButtons(JLabel buttons) {
		this.buttons = buttons;
	}

	public JButton getTrait() {
		return trait;
	}

	public void setTrait(JButton trait) {
		this.trait = trait;
	}

	public JButton getPotions() {
		return potions;
	}

	public void setPotions(JButton potions) {
		this.potions = potions;
	}

	public ArrayList<JLabel> getCells() {
		return cells;
	}

	public void setCells(ArrayList<JLabel> cells) {
		this.cells = cells;
	}

	@SuppressWarnings("static-access")
	public void addHp1(JProgressBar jpH) {
		hp1 = jpH;
		jpH.setBounds(champ1.BOTTOM + 135, champ1.BOTTOM + 310, 270, 20);
		champ1.add(hp1);

	}

	@SuppressWarnings("static-access")
	public void addHp2(JProgressBar jpH) {
		hp2 = jpH;
		jpH.setBounds(champ2.BOTTOM, champ2.BOTTOM + 310, 270, 20);
		champ2.add(hp2);
	}

	@SuppressWarnings("static-access")
	public void addHp3(JProgressBar jpH) {
		hp3 = jpH;
		jpH.setBounds(champ1.BOTTOM + 135, champ1.BOTTOM + 310, 270, 20);
		champ3.add(hp3);

	}

	@SuppressWarnings("static-access")
	public void addHp4(JProgressBar jpH) {
		hp4 = jpH;
		jpH.setBounds(champ2.BOTTOM, champ2.BOTTOM + 310, 270, 20);
		champ4.add(hp4);
	}

	@SuppressWarnings("static-access")
	public void addIp1(JProgressBar jpH) {
		ip1 = jpH;
		jpH.setBounds(champ1.BOTTOM + 135, champ1.BOTTOM + 330, 270, 20);
		champ1.add(ip1);

	}

	public JLabel getPhoto1() {
		return photo1;
	}

	public JLabel getPhoto2() {
		return photo2;
	}

	public JLabel getPhoto3() {
		return photo3;
	}

	public JLabel getPhoto4() {
		return photo4;
	}


	public ArrayList<JLabel> getTxt() {
		return txt;
	}



	public JLabel getInfo() {
		return Info;
	}

	public JLabel getArrows() {
		return arrows;
	}

	public JLabel getInfoTxt() {
		return infoTxt;
	}

	public JLabel getInfoPic() {
		return infoPic;
	}

	public String getPath() {
		return path;
	}

	public JButton getExit() {
		return exit;
	}

	@SuppressWarnings("static-access")
	public void addIp2(JProgressBar jpH) {
		ip2 = jpH;
		jpH.setBounds(champ4.BOTTOM, champ4.BOTTOM + 330, 270, 20);
		champ2.add(ip2);
	}

	@SuppressWarnings("static-access")
	public void addIp3(JProgressBar jpH) {
		ip3 = jpH;
		jpH.setBounds(champ1.BOTTOM + 135, champ1.BOTTOM + 330, 270, 20);
		champ3.add(ip3);

	}

	@SuppressWarnings("static-access")
	public void addIp4(JProgressBar jpH) {
		ip4 = jpH;
		jpH.setBounds(champ4.BOTTOM, champ4.BOTTOM + 330, 270, 20);
		champ4.add(ip4);
	}

	public JButton getSpells() {
		return spells;
	}

	public void setSpells(JButton spells) {
		this.spells = spells;
	}



}

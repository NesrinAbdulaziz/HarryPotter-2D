package harrypotter.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import harrypotter.controller.ControllerChoose;
import harrypotter.model.magic.DamagingSpell;
import harrypotter.model.magic.HealingSpell;
import harrypotter.model.magic.RelocatingSpell;
import harrypotter.model.magic.Spell;

@SuppressWarnings("serial")
public class SpellsView extends JFrame implements ActionListener {
	JLabel chooseG;
	JButton source;
	private ArrayList<Spell> spells;
	private ArrayList<JButton> bts;
	private JButton done;
	private JButton add;
	private ArrayList<Spell> cs;
	private JLabel left;
	private JLabel right;
	private JButton curr;
	private JLabel txtBG;
	private ArrayList<JButton> choose = new ArrayList<>();
	private ControllerChoose cC;
	private JLabel name;
	private JLabel info;
	String path = "\media\";

	public ArrayList<Spell> getSpells() {
		return spells;
	}

	public void setSpells(ArrayList<Spell> spells) {
		this.spells = spells;
	}

	public ArrayList<JButton> getBts() {
		return bts;
	}

	public void setBts(ArrayList<JButton> bts) {
		this.bts = bts;
	}

	public JButton getDone() {
		return done;
	}

	public void setDone(JButton done) {
		this.done = done;
	}

	public JButton getAdd() {
		return add;
	}

	public void setAdd(JButton add) {
		this.add = add;
	}

	public ArrayList<Spell> getCs() {
		return cs;
	}

	public void setCs(ArrayList<Spell> cs) {
		this.cs = cs;
	}

	public JLabel getLeft() {
		return left;
	}

	public void setLeft(JLabel left) {
		this.left = left;
	}

	public JLabel getRight() {
		return right;
	}

	public void setRight(JLabel right) {
		this.right = right;
	}

	public JButton getCurr() {
		return curr;
	}

	public void setCurr(JButton curr) {
		this.curr = curr;
	}

	public JLabel getTxtBG() {
		return txtBG;
	}

	public void setTxtBG(JLabel txtBG) {
		this.txtBG = txtBG;
	}

	public ArrayList<JButton> getChoose() {
		return choose;
	}

	public void setChoose(ArrayList<JButton> choose) {
		this.choose = choose;
	}

	public SpellsView(ControllerChoose cc, JButton j) {
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		java.awt.Image image = toolkit.getImage( "harry_potter_wand_cursorfx_by_luna_daisy.png");
		Cursor a = toolkit.createCustomCursor(image, new java.awt.Point(0, 0), "");
		this.setCursor(a);
		cC = cc;
		source = j;
		setLocationRelativeTo(null);
		this.setResizable(false);
		setUndecorated(true);
		setSize(1067, 600);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		JLabel Main = new JLabel(new ImageIcon(path + "qztaz77.jpg"));
		cs = new ArrayList<>();
		spells = cc.getTour().getSpells();
		bts = new ArrayList<>();
		left = new JLabel();
		right = new JLabel();
		right.setBounds(600, 0, 467, 600);
		// left.setBackground(Color.black);
		/// left.setOpaque(true);
		left.setBounds(0, 0, 600, 600);
		JLabel dmg = new JLabel(new ImageIcon(path + "c473af59cd0f6fa2d3d276133d87338b.png"));
		dmg.setBounds(-10, 0, 300, 75);
		left.add(dmg);
		Main.add(left);
		JLabel dmgG = new JLabel();
		dmgG.setLayout(new GridLayout(2, 6));
		dmgG.setBounds(-10, 70, 600, 100);
		for (int i = 0; i < 11; i++) {
			Spell s = spells.get(i);
			JButton b1 = new JButton(new ImageIcon(path + "" + s.getName() + ".png"));
			b1.addActionListener(this);
			bts.add(b1);
			b1.setContentAreaFilled(false);
			b1.setBorderPainted(false);
			dmgG.add(b1);

		}
		left.add(dmgG);
		add(Main);
		JLabel hlg = new JLabel(new ImageIcon(path + "872780ac6e77ae801cd918169fad112c.png"));
		hlg.setBounds(-30, 170, 300, 75);
		left.add(hlg);
		JLabel hlgG = new JLabel();
		hlgG.setLayout(new GridLayout(1, 6));
		hlgG.setBounds(-10, 240, 600, 50);
		for (int i = 11; i < 17; i++) {
			Spell s = spells.get(i);
			JButton b1 = new JButton(new ImageIcon(path + "" + s.getName() + ".png"));
			b1.addActionListener(this);
			bts.add(b1);
			b1.setContentAreaFilled(false);
			b1.setBorderPainted(false);
			hlgG.add(b1);
		}
		left.add(hlgG);
		JLabel rlc = new JLabel(new ImageIcon(path + "5fdb355b6e70f7295f41138da4cf08a3.png"));
		rlc.setBounds(-10, 290, 300, 75);
		left.add(rlc);
		JLabel rlcG = new JLabel();
		rlcG.setLayout(new GridLayout(1, 6));
		rlcG.setBounds(-10, 360, 600, 50);
		for (int i = 17; i < 21; i++) {
			Spell s = spells.get(i);
			JButton b1 = new JButton(new ImageIcon(path + "" + s.getName() + ".png"));
			b1.addActionListener(this);
			bts.add(b1);
			b1.setContentAreaFilled(false);
			b1.setBorderPainted(false);
			rlcG.add(b1);
		}
		rlcG.add(new JLabel());
		rlcG.add(new JLabel());
		left.add(rlcG);
		txtBG = new JLabel(new ImageIcon(path + "rsz_old_papyrus_decorative_png_clipart_image.png"));
		txtBG.setBounds(0, 50, 460, 270);
		right.add(txtBG);
		add = new JButton(new ImageIcon(path + "bd024fbb9eaf245a0cdff9ddb97b78b7.png"));
		add.setBounds(185, 360, 100, 50);
		add.setEnabled(false);
		add.addActionListener(this);
		add.setContentAreaFilled(false);
		add.setBorderPainted(false);
		done = new JButton(new ImageIcon(path + "bf8700428cdd9c0a81f80b775f8b3346.png"));
		done.setEnabled(false);
		done.setBounds(185, 420, 100, 50);
		done.addActionListener(this);
		done.setContentAreaFilled(false);
		done.setBorderPainted(false);
		right.add(done);
		right.add(add);
		JLabel chs = new JLabel(new ImageIcon(path + "chosen.png"));
		chs.setBounds(-25, 410, 300, 75);
		left.add(chs);
		chooseG = new JLabel();
		chooseG.setLayout(new GridLayout(1, 6));
		chooseG.setBounds(-10, 480, 600, 50);
		for (int i = 0; i < 3; i++) {
			JButton b1 = new JButton();
			b1.setContentAreaFilled(false);
			b1.setBorderPainted(false);
			b1.addActionListener(this);
			choose.add(b1);
			chooseG.add(b1);
		}
		left.add(chooseG);
		Main.add(right);
		name = new JLabel();
		info = new JLabel();
		name.setBounds(120, 20, 400, 50);
		info.setBounds(120, 30, 400, 200);
		txtBG.add(name);
		txtBG.add(info);
		revalidate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton j = (JButton) e.getSource();
		if (bts.contains(j)) {
			Spell s = spells.get(bts.indexOf(j));
			name.setIcon(new ImageIcon(path + "" + s.getName() + "1.png"));
			info.setIcon(new ImageIcon(path + "" + s.getName() + "2.png"));
			name.setBounds(120, 40, (name.getIcon()).getIconWidth(), (name.getIcon()).getIconHeight());
			info.setBounds(120, 90, (info.getIcon()).getIconWidth(), (info.getIcon()).getIconHeight());

			curr = j;
			if (cs.size() < 3)
				add.setEnabled(true);
			revalidate();
			repaint();
		} else if (j == add) {
			Spell s = spells.get(bts.indexOf(curr));
			if (s instanceof DamagingSpell)
				cs.add(new DamagingSpell((DamagingSpell) s));
			else if (s instanceof HealingSpell)
				cs.add(new HealingSpell((HealingSpell) s));
			else
				cs.add(new RelocatingSpell((RelocatingSpell) s));

			curr.setEnabled(false);
			choose.get(cs.size() - 1).setIcon((ImageIcon) curr.getIcon());
			if (cs.size() == 3) {
				done.setEnabled(true);
			}
			add.setEnabled(false);
			name.setIcon(null);
			info.setIcon(null);

			revalidate();
			repaint();
		} else if (j == done) {
			cC.doneSpells(cs, source);
			dispose();
		} else if (choose.contains(j)) {
			chooseG.remove(j);
			chooseG.add(j);
			j.setIcon(null);
			Spell s = cs.get(choose.indexOf(j));
			int idx = 0;
			for (Spell ss : spells) {
				if (ss.getName() == s.getName()) {
					idx = spells.indexOf(ss);
					break;
				}
			}
			cs.remove(choose.indexOf(j));

			j.setIcon(null);
			choose.remove(j);
			choose.add(j);

			bts.get(idx).setEnabled(true);
			if (done.isEnabled()) {
				done.setEnabled(false);

			}
			revalidate();
			repaint();
		}
	}

}

package harrypotter.view;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import harrypotter.controller.FirstTaskCont;
import harrypotter.model.character.Wizard;
import harrypotter.model.magic.Collectible;
import harrypotter.model.magic.Potion;

public class choosePotions extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private String path = "";
	private ArrayList<JButton> pB;
	private JButton use;
	private JButton cancel;
	private FirstTaskCont cont;
	private ArrayList<Collectible> p;
	private Potion used;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public choosePotions(FirstTaskCont cont, Wizard w) {
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		java.awt.Image image = toolkit.getImage( "harry_potter_wand_cursorfx_by_luna_daisy.png");
		Cursor a = toolkit.createCustomCursor(image, new java.awt.Point(0, 0), "");
		this.setCursor(a);

		this.cont = cont;
		this.setResizable(false);
		setUndecorated(true);
		setSize(800, 200);
		setLocationRelativeTo(null);
		pB = new ArrayList();
		use = new JButton();
		cancel = new JButton();
		use.setEnabled(false);
		use.setFocusPainted(false);
		use.setContentAreaFilled(false);
		use.setBorderPainted(false);
		cancel.setContentAreaFilled(false);
		cancel.setFocusPainted(false);
		cancel.setBorderPainted(false);
		cancel.addActionListener(this);
		use.addActionListener(this);
		cancel.setIcon(new ImageIcon(path + "cancel.png"));
		use.setIcon(new ImageIcon(path + "use.png"));
		JLabel background = new JLabel();
		background.setLayout(new GridLayout(2, 1));
		JLabel potions = new JLabel();
		potions.setLayout(new GridLayout(1, 10));
		if (w != null) {
			p = w.getInventory();
			setSize(p.size() * 100, 200);
			for (int i = 0; i < p.size(); i++) {

				pB.add(new JButton(new ImageIcon(path + p.get(i).getName() + ".png")));
				pB.get(i).setContentAreaFilled(false);
				pB.get(i).setBorderPainted(false);
				pB.get(i).addActionListener(this);
				pB.get(i).setFocusPainted(false);
			}
			ImageIcon bb = new ImageIcon(path + "potions.jpg");
			Image b = bb.getImage();

			Image newb = ((Image) b).getScaledInstance(p.size() * 150, 200, java.awt.Image.SCALE_SMOOTH);
			background.setIcon(new ImageIcon(newb));
		}
//		for (int i = 0; i < 10; i++) {
//
//			pB.add(new JButton(new ImageIcon(path +"cardboard.jpg")));
//			pB.get(i).setContentAreaFilled(false);
//			pB.get(i).setBorderPainted(false);
//			pB.get(i).addActionListener(this);
//			pB.get(i).setFocusPainted(false);
//		}
		setSize(p.size() * 135, 200);
		setLocationRelativeTo(null);

		for (int i = 0; i < pB.size(); i++)
			potions.add(pB.get(i));

		JLabel o = new JLabel();
		o.setLayout(new GridLayout(1, 2));
		o.add(use);
		o.add(cancel);

		background.add(potions);
		background.add(o);

		add(background);
		setVisible(true);

	}

//	 public static void main(String [] args){
//	 new choosePotions(null,new GryffindorWizard("Olfa"));
//	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton j = (JButton) e.getSource();
			if (j == cancel)
				this.dispose();
			else if (j == use)
				upotion(j);

			else if (pB.contains(j))
				apotion(j);
		}

	}

	public void upotion(JButton j) {
		cont.getTask().usePotion(used);
		cont.updateCur();
		pB.remove(j);
		this.dispose();



	}

	private void apotion(JButton j) {
		int x = pB.indexOf(j);
		if (x >= 0 && x < p.size())
			used = (Potion) p.get(x);

		{
			for (int i = 0; i < pB.size(); i++) {
				if (i != x)
					pB.get(i).setEnabled(!pB.get(i).isEnabled());
			}
			use.setEnabled(!use.isEnabled());
		}
	}
}

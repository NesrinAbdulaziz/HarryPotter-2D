package harrypotter.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import harrypotter.controller.FirstTaskCont;
import harrypotter.exceptions.InCooldownException;
import harrypotter.exceptions.InvalidTargetCellException;
import harrypotter.exceptions.NotEnoughIPException;
import harrypotter.exceptions.OutOfBordersException;
import harrypotter.exceptions.OutOfRangeException;
import harrypotter.model.character.Wizard;
import harrypotter.model.magic.DamagingSpell;
import harrypotter.model.magic.HealingSpell;
import harrypotter.model.magic.RelocatingSpell;
import harrypotter.model.magic.Spell;
import harrypotter.model.world.Direction;

public class chooseSpells extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton spell1;
	private JButton spell2;
	private JButton spell3;
	private JButton use;
	private JButton cancel;
	@SuppressWarnings("rawtypes")
	private JComboBox on;
	@SuppressWarnings("rawtypes")
	private JComboBox to;
	private JTextField rn;
	private String path="";
	private FirstTaskCont cont;
	private ArrayList<Spell> s;
	private Wizard w;
	public Spell used;
	private Direction d;
	private Direction r;
	private int ran;
	private JLabel rest;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public chooseSpells(FirstTaskCont cont, Wizard w) {
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		java.awt.Image image = toolkit.getImage( "harry_potter_wand_cursorfx_by_luna_daisy.png");
		Cursor a = toolkit.createCustomCursor(image, new java.awt.Point(0, 0), "");
		this.setCursor(a);

		if (w != null) {
			s = w.getSpells();
			this.w = w;
		}
	
		this.cont= cont;
		rn = new JTextField("Range");
		spell1 = new JButton();
		spell2 = new JButton();
		spell3 = new JButton();
		use = new JButton();
		cancel = new JButton();

		spell1.addActionListener(this);
		spell2.addActionListener(this);
		spell3.addActionListener(this);
		use.addActionListener(this);
		cancel.addActionListener(this);
		this.setResizable(false);
		setUndecorated(true);
		setSize(600, 300);
		setLocationRelativeTo(null);
		
		
	//	String x = "Choose wanted direction";
		Vector<Direction> comboBoxItems = new Vector<Direction>();
		// comboBoxItems.add("Choose wanted direction");
		comboBoxItems.add(Direction.FORWARD);
		comboBoxItems.add(Direction.BACKWARD);
		comboBoxItems.add(Direction.LEFT);
		comboBoxItems.add(Direction.RIGHT);
		DefaultComboBoxModel<Direction> model = new DefaultComboBoxModel<Direction>(comboBoxItems);
		on = new JComboBox(model);
		on.setEditable(false);
		on.addActionListener(this);
		model = new DefaultComboBoxModel(comboBoxItems);
		to = new JComboBox(model);
		to.addActionListener(this);
		JLabel background = new JLabel(new ImageIcon(path + "3602728ff0b74d9f0d1a39db804cda42.png"));
		background.setLayout(new GridLayout(1, 2));
		JLabel spells = new JLabel();
		rest = new JLabel();
		JLabel onl = new JLabel();

		JLabel tol = new JLabel();

		spell1.setContentAreaFilled(false);
		
		
		spell1.setBorderPainted(false);
		spell1.setFocusPainted(false);
		spell2.setContentAreaFilled(false);
		spell2.setBorderPainted(false);
		spell2.setFocusPainted(false);
		spell3.setContentAreaFilled(false);
		spell3.setBorderPainted(false);
		spell3.setFocusPainted(false);
		use.setContentAreaFilled(false);
		cancel.setContentAreaFilled(false);
		use.setFocusPainted(false);
		use.setBorderPainted(false);
		cancel.setFocusPainted(false);
		cancel.setBorderPainted(false);
		// spell1.setBorderPainted(false);
		// spell2.setBorderPainted(false);
		// spell3.setBorderPainted(false);
		// use.setBorderPainted(false);
		// cancel.setBorderPainted(false);
		if (w != null && w.getSpells() != null && !(w.getSpells().size() < 3)) {
			Spell s = w.getSpells().get(0);
			spell1.setIcon(new ImageIcon(path + s.getName() + "1.png"));
			s = w.getSpells().get(1);
			spell2.setIcon(new ImageIcon(path + s.getName() + "1.png"));
			s = w.getSpells().get(2);
			spell3.setIcon(new ImageIcon(path + s.getName() + "1.png"));
		}

		use.setEnabled(false);
		on.setEnabled(false);
		to.setEnabled(false);
		rn.setEnabled(false);
		rn.setOpaque(false);

		use.setIcon(new ImageIcon(path+"use.png"));
		cancel.setIcon(new ImageIcon(path+"cancel.png"));
		rn.addActionListener(this);
		onl.setLayout(new BorderLayout());
		tol.setLayout(new BorderLayout());

		// name1.setSize(onl.getWidth(),2);
		// name2.setSize(tol.getWidth(), 2);

		spells.setLayout(new GridLayout(3, 1));
		spells.add(spell1);
		spells.add(spell2);
		spells.add(spell3);
		on.setSize(onl.getWidth(), 5);
		to.setSize(tol.getWidth(), 5);

		on.setMaximumRowCount(4);
		to.setMaximumRowCount(4);

		// onl.add(name1,BorderLayout.PAGE_START);
		onl.add(on, BorderLayout.PAGE_START);
		// tol.add(name2,BorderLayout.PAGE_START);
		tol.add(to, BorderLayout.PAGE_START);
		tol.add(rn, BorderLayout.AFTER_LAST_LINE);
		rest.setLayout(new GridLayout(2, 2));
		rest.add(onl);
		rest.add(tol);
		rest.add(use);
		rest.add(cancel);
		background.add(spells);
		background.add(rest);
		background.setIcon(new ImageIcon(path + "qztaz77.jpg"));
	
		add(background);

		setVisible(true);
	}
	public void aSpell1(Wizard w) {
		if (w != null)
			used = w.getSpells().get(0);
		if (spell2.isEnabled() && spell3.isEnabled()) {
			spell2.setEnabled(false);
			spell3.setEnabled(false);
		
			rest.setIcon(new ImageIcon(path+s.get(0).getName()+"2.png"));

			if (used instanceof DamagingSpell) {
				on.setEnabled(true);

			}
			if (used instanceof RelocatingSpell) {
				on.setEnabled(true);
				to.setEnabled(true);
				rn.setEnabled(true);
			}
			else
			{
				use.setEnabled(true);
			}
		} else {
			rest.setIcon(new ImageIcon());
			spell2.setEnabled(true);
			spell3.setEnabled(true);
			use.setEnabled(false);
			on.setEnabled(false);
			to.setEnabled(false);
			rn.setEnabled(false);
		}

	}

	public void aSpell2(Wizard w) {
		if (w != null)
			used = w.getSpells().get(1);
		if (spell1.isEnabled() && spell3.isEnabled()) {
			rest.setIcon(new ImageIcon(path+s.get(1).getName()+"2.png"));
			spell1.setEnabled(false);
			spell3.setEnabled(false);
			
			if (used instanceof DamagingSpell) {
				
				on.setEnabled(true);
			}
			if (used instanceof RelocatingSpell) {
				on.setEnabled(true);
				to.setEnabled(true);
				rn.setEnabled(true);
			}
			else
			{
				use.setEnabled(true);
			}
		} else {
			rest.setIcon(new ImageIcon());
			spell1.setEnabled(true);
			spell3.setEnabled(true);
			use.setEnabled(false);
			on.setEnabled(false);
			to.setEnabled(false);
			rn.setEnabled(false);
		}

	}

	public void aSpell3(Wizard w) {
		if (w != null)
			used = w.getSpells().get(2);
		if (spell2.isEnabled() && spell1.isEnabled()) {
	
			rest.setIcon(new ImageIcon(path+s.get(2).getName()+"2.png"));
			spell2.setEnabled(false);
			spell1.setEnabled(false);

			if (used instanceof DamagingSpell) {
				
				on.setEnabled(true);
			}
			if (used instanceof RelocatingSpell) {
				
				on.setEnabled(true);
				to.setEnabled(true);
				rn.setEnabled(true);
				
			}
			else
			{
				
				use.setEnabled(true);
			}
		} else {
			rest.setIcon(new ImageIcon());
			spell2.setEnabled(true);
			spell1.setEnabled(true);
			use.setEnabled(false);
			on.setEnabled(false);
			to.setEnabled(false);
			rn.setEnabled(false);
		}

	}

	public void useSpell() {
		if (used instanceof HealingSpell)
			try {
				
				cont.getTask().castHealingSpell((HealingSpell) used);
				
			} catch (InCooldownException | NotEnoughIPException | IOException e) {
			
				JOptionPane.showMessageDialog(null, e.getMessage(),"no no",JOptionPane.INFORMATION_MESSAGE);
			}
		else if (used instanceof DamagingSpell)
			try {
				cont.getTask().castDamagingSpell((DamagingSpell) used, d);
				
			} catch (InCooldownException | NotEnoughIPException | OutOfBordersException | InvalidTargetCellException
					| IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"no no",JOptionPane.INFORMATION_MESSAGE);
			}
		else
			try {
				cont.getTask().castRelocatingSpell((RelocatingSpell) used, d, r, ran);
				
			} catch (InCooldownException | NotEnoughIPException | OutOfBordersException | InvalidTargetCellException
					| OutOfRangeException | IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"no no",JOptionPane.INFORMATION_MESSAGE);
			}
		this.dispose();

	
	}

	public void setPerDir(JComboBox<Direction> j) {
		d = (Direction) j.getSelectedItem();

	}

	public void setTarDir(JComboBox<Direction> j) {
		r = (Direction) j.getSelectedItem();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton j = (JButton) e.getSource();
			if (j == spell1)
				aSpell1(w);
			else if (j == spell2)
			
				aSpell2(w);
			
			else if (j == spell3)
				aSpell3(w);
			else if (j == use)
				useSpell();
			else
				this.dispose();
		}
		else
		if (e.getSource() instanceof JComboBox) {
			@SuppressWarnings("unchecked")
			JComboBox<Direction> j = (JComboBox<Direction>) e.getSource();
			if (j == on)
			{
				if((r!=null&!rn.getText().equals("Range")&&ran!=0)||!to.isEnabled())
				{
					use.setVisible(true);
					use.setEnabled(true);
				}

				setPerDir(j);
			}
			else
				if(j==to)
			{
				if(d!=null&!rn.getText().equals("Range")&ran!=0)
				{
					use.setVisible(true);
					use.setEnabled(true);
				}
				use.setEnabled(true);
				setTarDir(j);
			}
				
		}
		else
		{
			
			try{
				ran=(Integer.parseInt(rn.getText()));
				if(d!=null&&r!=null)
				{
					use.setVisible(true);
					use.setEnabled(true);
				}
			}
			catch (Exception E) {
				JOptionPane.showMessageDialog(null, "Please write a proper number","Invalid range",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}

	}

}

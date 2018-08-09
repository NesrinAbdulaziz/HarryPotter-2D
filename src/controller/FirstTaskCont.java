package harrypotter.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import harrypotter.exceptions.InCooldownException;
import harrypotter.exceptions.InvalidTargetCellException;
import harrypotter.exceptions.OutOfBordersException;
import harrypotter.model.character.Champion;
import harrypotter.model.character.GryffindorWizard;
import harrypotter.model.character.HufflepuffWizard;
import harrypotter.model.character.RavenclawWizard;
import harrypotter.model.character.SlytherinWizard;
import harrypotter.model.character.Wizard;
import harrypotter.model.tournament.FirstTask;
import harrypotter.model.tournament.SecondTask;
import harrypotter.model.tournament.Task;
import harrypotter.model.tournament.ThirdTask;
import harrypotter.model.tournament.Tournament;
import harrypotter.model.world.Cell;
import harrypotter.model.world.ChampionCell;
import harrypotter.model.world.CollectibleCell;
import harrypotter.model.world.CupCell;
import harrypotter.model.world.Direction;
import harrypotter.model.world.EmptyCell;
import harrypotter.model.world.Merperson;
import harrypotter.model.world.ObstacleCell;
import harrypotter.model.world.TreasureCell;
import harrypotter.model.world.WallCell;
import harrypotter.view.FirstTaskView;
import harrypotter.view.Turn;
import harrypotter.view.choosePotions;
import harrypotter.view.chooseSpells;

public class FirstTaskCont extends Controller implements ActionListener {

	private FirstTaskView view;
	private Task task;
	private ArrayList<Champion> champs;
	String path = "";
	private Tournament tour;
	private JProgressBar jpH;
	private JProgressBar jpI;
	public File move;
	public Clip mv;
	public AudioInputStream mov ;
	File Dragon = new File(path + "Sound_Effects_-_Dragons_clip.wav");
	Clip dr=AudioSystem.getClip();
	AudioInputStream dra = AudioSystem.getAudioInputStream(Dragon);
	File MerAtt = new File(path + "MerAtt.wav");
	Clip Ma=AudioSystem.getClip();
	AudioInputStream Maa = AudioSystem.getAudioInputStream(MerAtt);
	File Dead = new File(path + "myboy.wav");
	Clip d=AudioSystem.getClip();
	AudioInputStream de = AudioSystem.getAudioInputStream(Dead);
	File w = new File(path + "My_Son_clip.wav");
	Clip win=AudioSystem.getClip();
	AudioInputStream ww = AudioSystem.getAudioInputStream(w);

	public FirstTaskCont(JFrame f, Tournament tour) throws IOException, LineUnavailableException, UnsupportedAudioFileException {

		this.tour = tour;
		champs = tour.getChampions();

		view = new FirstTaskView(this);
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		java.awt.Image image = toolkit.getImage(path + "harry_potter_wand_cursorfx_by_luna_daisy.png");
		Cursor a = toolkit.createCustomCursor(image, new java.awt.Point(0, 0), "");
		view.setCursor(a);

		move = new File(path + "Woosh_and_Swoosh_Sound_Effect_clip.wav");
		mv=AudioSystem.getClip();

		mov = AudioSystem.getAudioInputStream(move);
		mv.open(mov);
		File start = new File(path + "good3.wav");
		Clip st=AudioSystem.getClip();
		AudioInputStream str = AudioSystem.getAudioInputStream(start);
		st.open(str);
		st.loop(Clip.LOOP_CONTINUOUSLY);
		dr.open(dra);
		d.open(de);
		win.open(ww);
		Ma.open(Maa);
		for (int i = 0; i < 4; i++) {
			jpH = new JProgressBar(0, ((Wizard) (champs.get(i))).getDefaultHp());
			jpI = new JProgressBar(0, ((Wizard) (champs.get(i))).getDefaultIp());
			jpH.setValue(jpH.getMaximum());
			jpH.setStringPainted(true);
			jpI.setValue(jpI.getMaximum());
			jpH.setString("HP: "+jpH.getValue());
			jpH.setForeground(new Color(0x851713));
			jpI.setForeground(new Color(0xC9A32C));
			jpI.setStringPainted(true);
			jpI.setString("IP: "+jpI.getValue());

			ImageIcon c;
			Wizard w = (Wizard) champs.get(i);
			if (w instanceof GryffindorWizard)
				c = new ImageIcon("gryffindor.png");
			else if ((Wizard) champs.get(i) instanceof HufflepuffWizard)
				c = new ImageIcon("hufflepuff.png");
			else if ((Wizard) champs.get(i) instanceof SlytherinWizard)
				c = new ImageIcon("slytherin.png");
			else
				c = new ImageIcon("ravenclaw.png");
			Image b = c.getImage();
			Image newb = ((Image) b).getScaledInstance(70, 90, java.awt.Image.SCALE_SMOOTH);
			c = new ImageIcon(newb);
			JLabel logo = new JLabel(c);
			if (w.no == 0) {
				logo.setBounds(320, 0, c.getIconWidth(), c.getIconHeight());
				view.getChamp1().add(logo);
				view.addHp1(jpH);
				view.addIp1(jpI);
			}
			if (w.no == 1) {
				logo.setBounds(190, 0, c.getIconWidth(), c.getIconHeight());
				view.getChamp2().add(logo);
				view.addHp2(jpH);
				view.addIp2(jpI);
			}
			if (w.no == 2) {
				logo.setBounds(320, 0, c.getIconWidth(), c.getIconHeight());
				view.getChamp3().add(logo);
				view.addHp3(jpH);
				view.addIp3(jpI);
			}
			if (w.no == 3) {
				logo.setBounds(190, 0, c.getIconWidth(), c.getIconHeight());
				view.getChamp4().add(logo);
				view.addHp4(jpH);
				view.addIp4(jpI);
			}

		}

		try {
			tour.beginTournament();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		task = tour.getFirstTask();
		task.cont = this;
		//tour.onFinishingFirstTask(tour.getChampions());
		//tour.onFinishingSecondTask(tour.getChampions());
		Cell[][] map = task.getMap();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				ImageIcon c;
				;
				if (map[i][j] instanceof ChampionCell)
					c = new ImageIcon(
							view.path + "sch" + (((Wizard) ((ChampionCell) map[i][j]).getChamp()).no + 1) + ".png");
				else if (map[i][j] instanceof ObstacleCell) {

					c = new ImageIcon(view.path + "rsz_obst.png");
					JButton L = new JButton();
					L.setSize(64, 64);
					L.setToolTipText(((ObstacleCell) map[i][j]).getObstacle().getHp() + " HP");
					L.setContentAreaFilled(false);
					L.setBorderPainted(false);
					L.setFocusPainted(false);
					L.addActionListener(this);
					L.setEnabled(true);
					L.setVisible(true);
					view.getCells().get(j + 10 * i).add(L, BorderLayout.CENTER);
				} else if (map[i][j] instanceof CollectibleCell) {
					view.getCells().get(j + 10 * i).setVisible(false);
					c = new ImageIcon(view.path + "potionsmall2.png");
				} else
					c = new ImageIcon();
				view.getCells().get(j + 10 * i).setIcon(c);
			}
			view.getCells().get(4 + 10 * 4).setIcon(new ImageIcon(view.path + "egg.png"));
		}
		updateCur();
		Timer t = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		t.setRepeats(false);
		t.start();
		view.setVisible(true);
	}

	public void move(Point from, Point to) {
		if (((to.x != 4 | to.y != 4) && (task instanceof FirstTask)) | task instanceof SecondTask
				| task instanceof ThirdTask)
			view.getCells().get(to.y + to.x * 10).setIcon(view.getCells().get(from.y + from.x * 10).getIcon());
		Component[] c = view.getCells().get(from.y + from.x * 10).getComponents();
		view.getCells().get(from.y + from.x * 10).removeAll();
		view.getCells().get(from.y + from.x * 10).setIcon(new ImageIcon());
		if ((to.x != 4 | to.y != 4)
				&& (task instanceof FirstTask) | task instanceof SecondTask | task instanceof ThirdTask)
			for (Component cc : c)
				view.getCells().get(to.y + to.x * 10).add(cc);
		view.revalidate();
		view.repaint();

	}

	public void champWonSecond(Wizard w, Point from) {

		view.getCells().get(w.getLocation().x * 10 + w.getLocation().y).setVisible(true);

		Timer t = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCells().get(w.getLocation().x * 10 + w.getLocation().y)
						.setIcon(view.getCells().get(from.y + from.x * 10).getIcon());
				view.getCells().get(from.y + from.x * 10).setIcon(new ImageIcon());
				new Turn("winner.png", null, null);
				view.repaint();
				view.revalidate();
			}
		});
		t.setRepeats(false);
		t.start();

		t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCells().get(w.getLocation().x * 10 + w.getLocation().y).setIcon(null);
				view.getCells().get(from.y + from.x * 10).setIcon(new ImageIcon());
				view.repaint();
				view.revalidate();
			}
		});
		t.setRepeats(false);
		t.start();

	}

	public FirstTaskView getView() {
		return view;
	}

	public void setView(FirstTaskView view) {
		this.view = view;
	}

	public ArrayList<Champion> getChamps() {
		return champs;
	}

	public void setChamps(ArrayList<Champion> champs) {
		this.champs = champs;
	}

	public void moveF() throws LineUnavailableException, UnsupportedAudioFileException {
		movements(0);

	}

	public void moveB() throws LineUnavailableException, UnsupportedAudioFileException {
		movements(1);
	}

	public void moveR() throws LineUnavailableException, UnsupportedAudioFileException {
		movements(3);
	}

	public void moveL() throws LineUnavailableException, UnsupportedAudioFileException {
		movements(2);

	}

	public void champAffected(Champion c) {
		Timer t = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Wizard w = (Wizard) c;
				JProgressBar hp = null;
				JProgressBar ip = null;
				switch (w.no) {
				case 0:
					hp = view.getHp1();
					ip = view.getIp1();
					break;
				case 1:
					hp = view.getHp2();
					ip = view.getIp2();
					break;
				case 2:
					hp = view.getHp3();
					ip = view.getIp3();
					break;
				case 3:
					hp = view.getHp4();
					ip = view.getIp4();
					break;
				}
				int i = hp.getValue();
				for (; i <= w.getHp(); i += 1) {
					hp.setValue(i);
				}
				for (; i >= w.getHp(); i -= 1) {
					hp.setValue(i);
				}
				i = ip.getValue();
				for (; i <= w.getIp(); i += 1)
				{
					ip.setValue(i);
				}

				for (; i >= w.getIp(); i -= 1)
				{
					ip.setValue(i);
				}
				hp.setString("HP: "+w.getHp());
				ip.setString("IP: "+w.getIp());
			}
		});
		t.setRepeats(false);
		t.start();

	}

	public void movements(int a) throws LineUnavailableException, UnsupportedAudioFileException {
		Champion c = task.getCurrentChamp();
		mv.start();
		mv.setMicrosecondPosition(0);
		try {
			switch (a) {
			case 0:
				task.moveForward();
				break;
			case 1:
				task.moveBackward();
				break;
			case 2:
				task.moveLeft();
				break;
			case 3:
				task.moveRight();
				break;
			}
			if (c == task.getCurrentChamp())
				view.txt.get(6).setText(task.getAllowedMoves() + " move(s) remaining");

		} catch (OutOfBordersException | InvalidTargetCellException | IOException e) {

			JOptionPane.showMessageDialog(null, e.getMessage(), "WHOA, DUDE!", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void checkTrait(Wizard w) {

		String[] t;
		if (task instanceof FirstTask)
			t = new String[] { "Gryffindor trait: you can make two moves, default coolDown = 4",
					"Hufflepuff trait: dragon won't fire, default coolDown = 3",
					"Slytherin trait: you can traverse 2 cells or jump over an obstacle or champion, default coolDown = 6",
					"Ravenclaw trait: you will see where the dragon fires, default coolDown = 5" };
		else if (task instanceof SecondTask)
			t = new String[] { "Gryffindor trait: you can make two moves, default coolDown = 4",
					"Hufflepuff trait: Merpeople won't attack, default coolDown = 6",
					"Slytherin trait: you can traverse 2 cells, default coolDown = 4",
					"Ravenclaw trait: Follow the arrows to reach your treasure, default coolDown = 7" };
		else
			t = new String[] { "Gryffindor trait: you can make two moves, default coolDown = 4",
					"Hufflepuff trait: you will be affected by only half of the damage, default coolDown = 0",
					"Slytherin trait: you can traverse 2 cells or jump over an obstacle or champion or traverse through a wall, default coolDown = 10",
					"Ravenclaw trait: Follow the arrows to reach the cup, default coolDown = 7" };

		String msg = null;
		if (w instanceof GryffindorWizard) {
			msg = t[0];
		} else if (w instanceof HufflepuffWizard) {
			msg = t[1];
		} else if (w instanceof RavenclawWizard) {
			msg = t[3];
		} else
			msg = t[2];

		int n = JOptionPane.showConfirmDialog(null, msg + '\n' + "Want to activate your trait?");
		if (n == JOptionPane.OK_OPTION)
			if (w instanceof GryffindorWizard) {
				try {

					((GryffindorWizard) w).useTrait();
				} catch (InCooldownException e) {
					JOptionPane.showMessageDialog(view, e.getMessage());
				}
			} else if (w instanceof HufflepuffWizard) {
				try {
					((HufflepuffWizard) w).useTrait();
				} catch (InCooldownException e) {
					JOptionPane.showMessageDialog(view, e.getMessage());
				}
			} else if (w instanceof RavenclawWizard) {
				try {
					((RavenclawWizard) w).useTrait();
				} catch (InCooldownException e) {
					JOptionPane.showMessageDialog(view, e.getMessage());
				}
			} else if (w instanceof SlytherinWizard) {

				try {

					int o = JOptionPane.showOptionDialog(null, "Where do you want to go?", "use trait",
							JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Direction.values(),
							Direction.values()[0]);
					if (o != JOptionPane.CLOSED_OPTION) {
						((SlytherinWizard) w).setTraitDirection(Direction.values()[o]);
						((SlytherinWizard) w).useTrait();
					}
				} catch (OutOfBordersException | InvalidTargetCellException | IOException e) {

					JOptionPane.showMessageDialog(view, e.getMessage());
				}

				catch (InCooldownException e) {
					JOptionPane.showMessageDialog(view, e.getMessage());
				}
			}

	}

	@Override
	public void showPotion(Point p) {
		Wizard w = (Wizard) task.getCurrentChamp();
		view.getCells().get(p.y + p.x * 10).setVisible(true);
		view.getPotions().setToolTipText("Potions: " + w.getInventory().size());

	}

	public void chooseSpells(Wizard w) {
		new chooseSpells(this, w);

	}

	public void choosePotions(Wizard w) {

		new choosePotions(this, w);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Wizard w = (Wizard) task.getCurrentChamp();
		JButton j = (JButton) e.getSource();
		if (j == view.getUp())
			try {
				moveF();
			} catch (LineUnavailableException | UnsupportedAudioFileException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		else if (j == view.getDown())
			try {
				moveB();
			} catch (LineUnavailableException | UnsupportedAudioFileException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		else if (j == view.getLeft())
			try {
				moveL();
			} catch (LineUnavailableException | UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (j == view.getRight())
			try {
				moveR();
			} catch (LineUnavailableException | UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (j == view.getTrait())
			checkTrait(w);
		else if (j == view.getSpells()) {
			chooseSpells(w);
		} else if (j == view.getPotions()) {
			if (w.getInventory().size() != 0)
				choosePotions(w);
			else
				JOptionPane.showMessageDialog(null, "You don't have any potions,collect some more !!");
		} else if (j == view.getExit())
			System.exit(0);

	}

	public void fire(Point p) {
		dr.start();
		dr.setMicrosecondPosition(0);
		ImageIcon bb = new ImageIcon(view.path + "torch.png");
		Image b = bb.getImage();
		Image newb = ((Image) b).getScaledInstance(view.getCells().get(0).getWidth(),
				view.getCells().get(0).getHeight(), java.awt.Image.SCALE_SMOOTH);
		bb = new ImageIcon(newb);
		JLabel lb = new JLabel(bb);
		lb.setSize(view.getCells().get(0).getSize());

		Timer t = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getCells().get(p.y + p.x * 10).isVisible())
					view.getCells().get(p.y + p.x * 10).add(lb);
				else {
					view.getCells().get(p.y + p.x * 10).setIcon(null);
					view.getCells().get(p.y + p.x * 10).add(lb);
					view.getCells().get(p.y + p.x * 10).setVisible(true);
				}

				view.repaint();
				view.revalidate();
			}
		});
		t.setRepeats(false);
		t.start();
		t = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCells().get(p.y + p.x * 10).remove(lb);
				if (task.getMap()[p.x][p.y] instanceof CollectibleCell) {
					view.getCells().get(p.y + p.x * 10).setVisible(false);
					view.getCells().get(p.y + p.x * 10).setIcon(new ImageIcon(view.path + "potionsmall2.png"));
				}
				view.repaint();
				view.revalidate();
			}
		});
		t.setRepeats(false);
		t.start();

	}

	@Override
	public void endTurn(String name) {
		Timer t = new Timer(1500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Turn("90085df533339dbd1c2cdc357e6483a6.png", "8bcea2223f06001afdf86ab90d3eaf3e.png", null);
				updateCur();
			}
		});
		t.setRepeats(false);
		t.start();

	}

	@Override
	public void updateobs(Point target) {
		Cell c = task.getMap()[target.x][target.y];
		if (c instanceof EmptyCell) {
			view.getCells().get(target.x * 10 + target.y).setIcon(new ImageIcon());
			view.getCells().get(target.x * 10 + target.y).removeAll();
		} else {
			Component[] comp = view.getCells().get(target.x * 10 + target.y).getComponents();
			for (Component cc : comp) {
				if (cc instanceof JButton)
					((JButton) cc).setToolTipText(((ObstacleCell) c).getObstacle().getHp() + "HP");
			}
		}

	}

	@Override
	public void updateCur() {
		champAffected(task.getCurrentChamp());
		Wizard w = (Wizard) task.getCurrentChamp();
		view.infoPic.setIcon(new ImageIcon(view.path + "sch" + (w.no + 1) + ".png"));
		String h = "";
		if (w instanceof HufflepuffWizard)
			h = "Hufflepuff Wizard";
		else if (w instanceof GryffindorWizard)
			h = "Gryffindor Wizard";
		else if (w instanceof SlytherinWizard)
			h = "Slytherin Wizard";
		else
			h = "Ravenclaw Wizard";
		String[] x = { "Current Champion:", w.getName(), h, w.getHp() + " HP", w.getIp() + " IP",
				"Trait Activated: " + task.isTraitActivated(), task.getAllowedMoves() + " move(s) remaining" };
		for (int j = 0; j < view.txt.size() && j < x.length; j++) {
			view.txt.get(j).setText(x[j]);

		}
		view.getPotions().setToolTipText("Potions: " + w.getInventory().size());
		view.getTrait().setToolTipText("Trait: " + w.getTraitCooldown() + " cooldown");
		view.getSpells().setToolTipText("spells: 3");
	}

	@Override
	public void showMarked(ArrayList<Point> c) {
		Timer t = null;
		if (c.size() > 0) {
			JLabel b = new JLabel(new ImageIcon(view.path + "mark.png"));
			b.setSize(view.getCells().get(0).getSize());
			Point p = c.get(0);
			t = new Timer(500, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (view.getCells().get(p.y + p.x * 10).isVisible())
						view.getCells().get(p.y + p.x * 10).add(b);
					else {
						view.getCells().get(p.y + p.x * 10).setIcon(null);
						view.getCells().get(p.y + p.x * 10).add(b);
						view.getCells().get(p.y + p.x * 10).setVisible(true);
					}
					view.repaint();
					view.revalidate();
				}
			});
			t.setRepeats(false);
			t.start();
			t = new Timer(1000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					view.getCells().get(p.y + p.x * 10).remove(b);
					if (task.getMap()[p.x][p.y] instanceof CollectibleCell) {
						view.getCells().get(p.y + p.x * 10).setVisible(false);
						view.getCells().get(p.y + p.x * 10).setIcon(new ImageIcon(view.path + "potionsmall2.png"));
					}
					view.repaint();
					view.revalidate();
				}
			});
			t.setRepeats(false);
			t.start();
		}
		if (c.size() > 1) {
			JLabel b = new JLabel(new ImageIcon(view.path + "mark.png"));
			b.setSize(view.getCells().get(0).getSize());
			Point p = c.get(1);
			t = new Timer(500, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (view.getCells().get(p.y + p.x * 10).isVisible())
						view.getCells().get(p.y + p.x * 10).add(b);
					else {
						view.getCells().get(p.y + p.x * 10).setIcon(null);
						view.getCells().get(p.y + p.x * 10).add(b);
						view.getCells().get(p.y + p.x * 10).setVisible(true);
					}
					view.repaint();
					view.revalidate();
				}
			});
			t.setRepeats(false);
			t.start();
			t = new Timer(1000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					view.getCells().get(p.y + p.x * 10).remove(b);
					if (task.getMap()[p.x][p.y] instanceof CollectibleCell) {
						view.getCells().get(p.y + p.x * 10).setVisible(false);
						view.getCells().get(p.y + p.x * 10).setIcon(new ImageIcon(view.path + "potionsmall2.png"));
					}
					view.repaint();
					view.revalidate();
				}
			});
			t.setRepeats(false);
			t.start();
		}

	}

	@Override
	public void startSecond(ArrayList<Champion> winners) {
		// new taskOver(winners);
		task = tour.getSecondTask();
		task.cont = this;

		view.getHp1().setForeground(new Color(0x10098F));
		view.getHp2().setForeground(new Color(0x10098F));
		view.getHp3().setForeground(new Color(0x10098F));
		view.getHp4().setForeground(new Color(0x10098F));
		view.getIp1().setForeground(new Color(0x038F86));
		view.getIp2().setForeground(new Color(0x038F86));
		view.getIp3().setForeground(new Color(0x038F86));
		view.getIp4().setForeground(new Color(0x038F86));

		view.getBackGround1().setIcon(new ImageIcon(view.path + "bg olfat 2.jpg"));
		boolean[] alive = new boolean[4];
		for (int i = 0; i < winners.size(); i++) {
			alive[((Wizard) winners.get(i)).no] = true;
			champAffected(winners.get(i));
		}
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				view.getCells().get(j + i * 10).removeAll();
				view.getCells().get(j + i * 10).setVisible(true);
				Cell c = task.getMap()[i][j];
				if (c instanceof ChampionCell)
					view.getCells().get(j + 10 * i).setIcon(new ImageIcon(
							view.path + "sch" + (((Wizard) ((ChampionCell) c).getChamp()).no + 1) + ".png"));
				else if (c instanceof ObstacleCell) {
					ImageIcon bb = new ImageIcon(view.path + "mermaid.gif");
					Image b = bb.getImage();
					Image newb = ((Image) b).getScaledInstance(view.getCells().get(0).getWidth(),
							view.getCells().get(0).getHeight(), java.awt.Image.SCALE_SMOOTH);
					bb = new ImageIcon(newb);
					view.getCells().get(j + 10 * i).setIcon(bb);
					JButton L = new JButton();
					L.setSize(64, 64);
					L.setToolTipText(((ObstacleCell) c).getObstacle().getHp() + " HP, "
							+ ((Merperson) ((ObstacleCell) c).getObstacle()).getDamage() + "Damage");
					L.setContentAreaFilled(false);
					L.setBorderPainted(false);
					L.setFocusPainted(false);
					L.addActionListener(this);
					L.setEnabled(true);
					L.setVisible(true);
					view.getCells().get(j + 10 * i).add(L, BorderLayout.CENTER);
				} else if (c instanceof CollectibleCell) {
					view.getCells().get(j + 10 * i).setVisible(false);
					view.getCells().get(j + 10 * i).setIcon(new ImageIcon(view.path + "potionsmall2.png"));
				} else if (c instanceof TreasureCell) {
					view.getCells().get(j + 10 * i).setVisible(false);
					view.getCells().get(j + 10 * i).setIcon(new ImageIcon(view.path + "treasure.png"));
				} else

					view.getCells().get(j + 10 * i).setIcon(new ImageIcon());
			}
		updateCur();
	}

	public void startThird(ArrayList<Champion> winners) {

		task = tour.getThirdTask();
		task.cont = this;
		champs = task.getChampions();
		view.getHp1().setForeground(new Color(0x0A5703));
		view.getHp2().setForeground(new Color(0x0A5703));
		view.getHp3().setForeground(new Color(0x0A5703));
		view.getHp4().setForeground(new Color(0x0A5703));
		view.getIp1().setForeground(new Color(0xE8A515));
		view.getIp2().setForeground(new Color(0xE8A515));
		view.getIp3().setForeground(new Color(0xE8A515));
		view.getIp4().setForeground(new Color(0xE8A515));
		view.getBackGround1().setIcon(new ImageIcon(view.path + "bg olfat 3.jpg"));
		for (int i = 0; i < winners.size(); i++) {
			champAffected(winners.get(i));
		}
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				view.getCells().get(j + i * 10).removeAll();
				view.getCells().get(j + i * 10).setVisible(true);
				Cell c = task.getMap()[i][j];
				if (c instanceof ChampionCell)
					view.getCells().get(j + 10 * i).setIcon(new ImageIcon(
							view.path + "sch" + (((Wizard) ((ChampionCell) c).getChamp()).no + 1) + ".png"));
				else if (c instanceof ObstacleCell) {
					ImageIcon bb = new ImageIcon(view.path + "obs.png");
					view.getCells().get(j + 10 * i).setIcon(bb);
					JButton L = new JButton();
					L.setSize(64, 64);
					L.setToolTipText(((ObstacleCell) c).getObstacle().getHp() + " HP");
					L.setContentAreaFilled(false);
					L.setBorderPainted(false);
					L.setFocusPainted(false);
					L.addActionListener(this);
					L.setEnabled(true);
					L.setVisible(true);
					view.getCells().get(j + 10 * i).add(L, BorderLayout.CENTER);
				} else if (c instanceof WallCell) {
					ImageIcon bb = new ImageIcon("grass.jpg");
					Image b = bb.getImage();
					Image newb = ((Image) b).getScaledInstance(85, 64, java.awt.Image.SCALE_SMOOTH);
					bb = new ImageIcon(newb);
					view.getCells().get(j + 10 * i).setIcon(bb);
				} else if (c instanceof CupCell) {
					view.getCells().get(j + 10 * i).setVisible(false);
					view.getCells().get(j + 10 * i).setIcon(new ImageIcon(view.path + "cup.png"));
				} else if (c instanceof CollectibleCell) {
					view.getCells().get(j + 10 * i).setVisible(false);
					view.getCells().get(j + 10 * i).setIcon(new ImageIcon("potionsmall2.png"));
				} else

					view.getCells().get(j + 10 * i).setIcon(new ImageIcon());
			}
		updateCur();
	}

	@Override
	public void gameOver() {
		Timer t = new Timer(2500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e1) {
				new Turn("gameover.png", null, null);

			}
		});
		t.setRepeats(false);
		t.start();

		t = new Timer(4000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e1) {

					System.exit(0);

			}
		});
		t.setRepeats(false);
		t.start();

	}

	public Task getTask() {
		return task;
	}

	@Override
	public void updatemer(Point target) {
		Cell c = task.getMap()[target.x][target.y];
		if (c instanceof EmptyCell) {
			view.getCells().get(target.x * 10 + target.y).setIcon(new ImageIcon());
			view.getCells().get(target.x * 10 + target.y).removeAll();
		} else {
			Component[] comp = view.getCells().get(target.x * 10 + target.y).getComponents();
			for (Component cc : comp) {
				if (cc instanceof JButton)
					((JButton) cc).setToolTipText(((ObstacleCell) c).getObstacle().getHp() + "HP, "
							+ ((Merperson) ((ObstacleCell) c).getObstacle()).getDamage() + "Damage");
			}
		}

	}

	@Override
	public void ChampWonSecond(Wizard current, Point l) {
		Point p = current.getLocation();
		view.getCells().get(p.y + p.x * 10).setVisible(true);
		Timer t = new Timer(1550, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				view.getCells().get(p.y + p.x * 10).setIcon(view.getCells().get(l.y + l.x * 10).getIcon());
				view.getCells().get(l.y + l.x * 10).setIcon(null);

				view.repaint();
				view.revalidate();
			}
		});
		t.setRepeats(false);
		t.start();
		new Turn("winner.png", null, null);
		t = new Timer(3100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCells().get(p.y + p.x * 10).setIcon(null);
				view.repaint();
				view.revalidate();
			}
		});
		t.setRepeats(false);
		t.start();
		win.start();
		win.setMicrosecondPosition(0);

	}

	@Override
	public void encounter(int i) {
		Ma.start();
		Ma.setMicrosecondPosition(0);
		Point p = ((Wizard) task.getCurrentChamp()).getLocation();
		//ImageIcon bb = new ImageIcon(view.path + "spear.png");
		// Image b = bb.getImage();
		// Image newb = ((Image)
		// b).getScaledInstance(view.getCells().get(0).getWidth(),
		// view.getCells().get(0).getHeight(), java.awt.Image.SCALE_SMOOTH);
		// bb = new ImageIcon(newb);
		JLabel lb = new JLabel("  "+i+"");
		lb.setForeground(Color.red);
		lb.setSize(view.getCells().get(0).getSize());
		Timer t = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getCells().get(p.y + p.x * 10).isVisible())
					view.getCells().get(p.y + p.x * 10).add(lb);
				else {
					view.getCells().get(p.y + p.x * 10).setIcon(null);
					view.getCells().get(p.y + p.x * 10).add(lb);
					view.getCells().get(p.y + p.x * 10).setVisible(true);
				}

				view.repaint();
				view.revalidate();
			}
		});
		t.setRepeats(false);
		t.start();
		t = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCells().get(p.y + p.x * 10).remove(lb);
				if (task.getMap()[p.x][p.y] instanceof CollectibleCell) {
					view.getCells().get(p.y + p.x * 10).setVisible(false);
					view.getCells().get(p.y + p.x * 10).setIcon(new ImageIcon(view.path + "potionsmall2.png"));
				}
				view.repaint();
				view.revalidate();
			}
		});
		t.setRepeats(false);
		t.start();

	}

	public void ChampDied(Wizard w) {
		d.start();
		d.setMicrosecondPosition(0);
		view.getCells().get(w.getLocation().y + w.getLocation().x * 10).setIcon(null);
		new Turn("died.png", null, null);
	}

	public void ChampWon(Wizard w) {
		win.start();
		win.setMicrosecondPosition(0);
		new Turn("winner.png", null, null);
	}
}

package harrypotter.controller;

import harrypotter.model.character.Champion;
import harrypotter.model.character.GryffindorWizard;
import harrypotter.model.character.HufflepuffWizard;
import harrypotter.model.character.RavenclawWizard;
import harrypotter.model.character.SlytherinWizard;
import harrypotter.model.character.Wizard;
import harrypotter.model.magic.Spell;
import harrypotter.model.tournament.Tournament;
import harrypotter.view.ChooseChamps;
import harrypotter.view.SpellsView;
import harrypotter.view.StartPageView;

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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ControllerChoose implements ActionListener {

	private JFrame dis;
	private Tournament tour;
	private String[] names;
	ChooseChamps frame;
	private Wizard[] players;
	String path="";
	public File nxt = new File(path + "as from this moment.wav");
	Clip clip;
	Clip clip1;
	Clip clip2;
	Clip clip3;
	Clip clipNxt;
	AudioInputStream next;
	StartPageView st;
	ControllerStart cs;


	public ControllerChoose(JFrame s, ControllerStart cs)
			throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		clip = AudioSystem.getClip();
		clip1 = AudioSystem.getClip();
		clip2 = AudioSystem.getClip();
		clip3 = AudioSystem.getClip();
		clipNxt = AudioSystem.getClip();

		next = AudioSystem.getAudioInputStream(nxt);
		dis = s;
		players = new Wizard[4];
		names = new String[4];
		frame = new ChooseChamps(this);
		this.cs = cs;
		try {
			tour = new Tournament();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public Tournament getTour() {
		return tour;
	}

	public void setTour(Tournament tour) {
		this.tour = tour;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public ChooseChamps getFrame() {
		return frame;
	}

	public void setFrame(ChooseChamps frame) {
		this.frame = frame;
	}

	public Wizard[] getPlayers() {
		return players;
	}

	public void setPlayers(Wizard[] players) {
		this.players = players;
	}

	public void chooseFirst(JButton j) throws LineUnavailableException, IOException, UnsupportedAudioFileException {

		if (players[0] == null) {
			if (names[0] == null) {
				JOptionPane.showMessageDialog(null, "Enter your name first");
				return;
			}
			for (JButton jb : frame.getCh1())
				if (jb != j) {
					jb.setEnabled(false);
					jb.setVisible(false);
				}

			int i = frame.getCh1().indexOf(j);
			if (clip.isOpen())
				clip.close();

			if (i == 0) {
				players[0] = new GryffindorWizard(names[0]);
				clip.open(AudioSystem.getAudioInputStream(new File(path + "Lion_roar_sound_effect_1_clip.wav")));

				clip.start();
				;
			} else if (i == 1) {
				players[0] = new HufflepuffWizard(names[0]);
				clip.open(AudioSystem.getAudioInputStream(new File(path + "Badger_Sound_Effects_clip_1_.wav")));
				clip.start();
			} else if (i == 2) {
				players[0] = new RavenclawWizard(names[0]);
				clip.open(AudioSystem.getAudioInputStream(new File(path + "Eagle_Sound_Effect_clip.wav")));
				clip.start();
			} else {
				players[0] = new SlytherinWizard(names[0]);
				clip.open(AudioSystem.getAudioInputStream(new File(path + "Snake_hiss_sound_effect_clip.wav")));
				clip.start();
			}
			frame.getSpellsB().get(0).setEnabled(true);

		} else {
			for (JButton jb : frame.getCh1()) {
				jb.setEnabled(true);
				jb.setVisible(true);
			}
			players[0] = null;
			frame.getNxt().setEnabled(false);
			frame.getSpellsB().get(0).setEnabled(false);

		}

		// for(Wizard w :players){
		// if(w==null)
		// return;
		// }
		// frame.getNxt().setEnabled(true);

	}

	public void chooseSecond(JButton j) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		if (players[1] == null) {
			if (names[1] == null) {
				JOptionPane.showMessageDialog(null, "Enter your name first");
				return;
			}
			for (JButton jb : frame.getCh2())

				if (jb != j) {
					jb.setEnabled(false);
					jb.setVisible(false);
				}
			if (clip1.isOpen())
				clip1.close();

			int i = frame.getCh2().indexOf(j);
			if (i == 0) {
				players[1] = new GryffindorWizard(names[1]);
				clip1.open(AudioSystem.getAudioInputStream(new File(path + "Lion_roar_sound_effect_1_clip.wav")));
				clip1.start();
			} else if (i == 1) {
				players[1] = new HufflepuffWizard(names[1]);
				clip1.open(AudioSystem.getAudioInputStream(new File(path + "Badger_Sound_Effects_clip_1_.wav")));
				clip1.start();
			} else if (i == 2) {
				players[1] = new RavenclawWizard(names[1]);
				clip1.open(AudioSystem.getAudioInputStream(new File(path + "Eagle_Sound_Effect_clip.wav")));

				clip1.start();
			} else {
				players[1] = new SlytherinWizard(names[1]);
				clip1.open(AudioSystem.getAudioInputStream(new File(path + "Snake_hiss_sound_effect_clip.wav")));
				clip1.start();
			}
			frame.getSpellsB().get(1).setEnabled(true);

		} else {
			for (JButton jb : frame.getCh2()) {
				jb.setEnabled(true);
				jb.setVisible(true);
			}
			players[1] = null;
			frame.getNxt().setEnabled(false);
			frame.getSpellsB().get(1).setEnabled(false);

		}

	}

	public void chooseThird(JButton j) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		if (players[2] == null) {
			if (names[2] == null) {
				JOptionPane.showMessageDialog(null, "Enter your name first");
				return;
			}
			for (JButton jb : frame.getCh3())

				if (jb != j) {
					jb.setEnabled(false);
					jb.setVisible(false);
				}

			int i = frame.getCh3().indexOf(j);
			if (clip2.isOpen())
				clip2.close();

			if (i == 0) {
				players[2] = new GryffindorWizard(names[2]);
				clip2.open(AudioSystem.getAudioInputStream(new File(path + "Lion_roar_sound_effect_1_clip.wav")));
				;
				clip2.start();
			} else if (i == 1) {
				players[2] = new HufflepuffWizard(names[2]);
				clip2.open(AudioSystem.getAudioInputStream(new File(path + "Badger_Sound_Effects_clip_1_.wav")));
				clip2.start();
			} else if (i == 2) {
				players[2] = new RavenclawWizard(names[2]);
				clip2.open(AudioSystem.getAudioInputStream(new File(path + "Eagle_Sound_Effect_clip.wav")));
				clip2.start();
			} else {
				players[2] = new SlytherinWizard(names[2]);
				clip2.open(AudioSystem.getAudioInputStream(new File(path + "Snake_hiss_sound_effect_clip.wav")));
				clip2.start();
			}
			frame.getSpellsB().get(2).setEnabled(true);
		} else {
			for (JButton jb : frame.getCh3()) {
				jb.setEnabled(true);
				jb.setVisible(true);
			}
			players[2] = null;
			frame.getNxt().setEnabled(false);
			frame.getSpellsB().get(2).setEnabled(false);
		}

	}

	public void chooseFourth(JButton j) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		if (players[3] == null) {
			if (names[3] == null) {
				JOptionPane.showMessageDialog(null, "Enter your name first");
				return;
			}
			for (JButton jb : frame.getCh4())
				if (jb != j) {
					jb.setEnabled(false);
					jb.setVisible(false);
				}

			int i = frame.getCh4().indexOf(j);
			if (clip3.isOpen())
				clip3.close();

			if (i == 0) {
				players[3] = new GryffindorWizard(names[3]);
				clip3.open(AudioSystem.getAudioInputStream(new File(path + "Lion_roar_sound_effect_1_clip.wav")));
				;
				clip3.start();
			} else if (i == 1) {
				players[3] = new HufflepuffWizard(names[3]);
				clip3.open(AudioSystem.getAudioInputStream(new File(path + "Badger_Sound_Effects_clip_1_.wav")));
				clip3.start();
			} else if (i == 2) {
				players[3] = new RavenclawWizard(names[3]);
				clip3.open(AudioSystem.getAudioInputStream(new File(path + "Eagle_Sound_Effect_clip.wav")));
				clip3.start();
			} else {
				players[3] = new SlytherinWizard(names[3]);
				clip3.open(AudioSystem.getAudioInputStream(new File(path + "Snake_hiss_sound_effect_clip.wav")));
				clip3.start();
			}
			frame.getSpellsB().get(3).setEnabled(true);

		} else {
			for (JButton jb : frame.getCh4()) {
				jb.setEnabled(true);
				jb.setVisible(true);
			}
			players[3] = null;
			frame.getNxt().setEnabled(false);
			frame.getSpellsB().get(3).setEnabled(false);

		}

	}

	public void nextView() throws IOException {
		int i = 0;
		for (Wizard w : players) {
			w.no = i++;
			tour.addChampion((Champion) w);
		}
		try {
			new FirstTaskCont(frame, tour);
		} catch (LineUnavailableException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void activate(int i) {
		ArrayList<JButton> ch;
		if (i == 0)
			ch = frame.getCh1();
		else if (i == 1)
			ch = frame.getCh2();
		else if (i == 2)
			ch = frame.getCh3();
		else
			ch = frame.getCh4();
		for (JButton j : ch) {
			j.setEnabled(true);
		}
	}

	public void chooseSpell(JButton j) {

		if (tour == null)
			try {
				tour = new Tournament();
			} catch (IOException e) {

				e.printStackTrace();
			}
		SpellsView sv = new SpellsView(this, j);
		sv.setVisible(true);

	}

	public void doneSpells(ArrayList<Spell> s, JButton j) {
		players[frame.getSpellsB().indexOf(j)].setSpells(s);
		for (Wizard z : players) {
			if (z == null || z.getSpells() == null||z.getSpells().isEmpty())
				return;
		}
		frame.getNxt().setEnabled(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton j = (JButton) e.getSource();
			if (j == frame.getNxt()) {
				if (cs != null)
					cs.clip1.close();
				try {
					clipNxt.open(next);
				} catch (LineUnavailableException | IOException e1) {
					e1.printStackTrace();
				}
				clipNxt.start();
				try {
					nextView();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(j == frame.getExit()){
				System.exit(0);
			}
			else if (frame.getCh1().contains(j)) {
				try {
					chooseFirst(j);
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (frame.getCh2().contains(j)) {
				try {
					chooseSecond(j);
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (frame.getCh3().contains(j)) {
				try {
					chooseThird(j);
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (frame.getCh4().contains(j)) {
				try {
					chooseFourth(j);
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else
				chooseSpell(j);

		} else {
			if (dis != null) {
				dis.dispose();
				dis = null;
			}
			JTextField jt = (JTextField) e.getSource();
			if (jt == frame.getName1()) {
				names[0] = jt.getText();
				activate(0);
				frame.getName1().setEditable(false);
			}
			if (jt == frame.getName2()) {
				names[1] = jt.getText();
				activate(1);
				frame.getName2().setEditable(false);
			}
			if (jt == frame.getName3()) {
				names[2] = jt.getText();
				activate(2);
				frame.getName3().setEditable(false);
			}
			if (jt == frame.getName4()) {
				names[3] = jt.getText();
				activate(3);
				frame.getName4().setEditable(false);
			}

		}

	}
}

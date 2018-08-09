
package harrypotter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.Timer;

import harrypotter.view.StartPageView;

public class ControllerStart implements ActionListener {

	private ControllerChoose cc;
	private StartPageView s;
	String path="";
	public File click = new File(path + "Harry_Potter-_The_Quidditch_World_Cup_clip.wav");
	Clip clip = AudioSystem.getClip();
	AudioInputStream ais = AudioSystem.getAudioInputStream(click);
	public File start = new File(path + "Harry_Potter.wav");
	Clip clip1 = AudioSystem.getClip();
	public AudioInputStream st = AudioSystem.getAudioInputStream(start);

	public ControllerStart() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		s = new StartPageView(this);
		cc = new ControllerChoose(s, this);
		s.setVisible(true);
		clip1.open(st);
		clip1.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void exit() {
		// s.dispose();
		System.exit(0);

	}

	public void start() {
		cc.getFrame().setVisible(true);
		Timer t = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s.dispose();
			}
		});
		t.setRepeats(false);
		t.start();
	}

	public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		new ControllerStart();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton j = (JButton) e.getSource();
		if (j == s.getB1()) {
			try {
				clip.open(ais);
			} catch (LineUnavailableException | IOException e1) {
				e1.printStackTrace();
			}
			clip.start();
			start();
		}
		if (j == s.getB12())
			exit();
	}
}

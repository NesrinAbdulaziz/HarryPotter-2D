package harrypotter.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import harrypotter.model.character.Champion;
import harrypotter.model.character.Wizard;

public class winners {
	FirstTaskView view;
	JFrame jf;

	File w = new File("Win.wav");
	Clip win=AudioSystem.getClip();
	AudioInputStream ww = AudioSystem.getAudioInputStream(w);
	@SuppressWarnings("static-access")
	public winners(ArrayList<Champion> winners, int i)  throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		jf = new JFrame();
		win.open(ww);
		win.start();
		win.setMicrosecondPosition(0);
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		java.awt.Image image = toolkit.getImage("harry_potter_wand_cursorfx_by_luna_daisy.png");
		Cursor a = toolkit.createCustomCursor(image, new java.awt.Point(0, 0), "");
		jf.setCursor(a);
		jf.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.setUndecorated(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setLayout(new BorderLayout());
		JLabel jp = new JLabel();
		jp.setSize(jf.getWidth(), jf.getHeight());
		ImageIcon bb = new ImageIcon("winn.jpg");
		jp.setIcon(bb);
		JLabel lb = new JLabel();
		if (i != 3)
			lb.setIcon((new ImageIcon("Wi.png")));
		else
			lb.setIcon(new ImageIcon("trueChamp.png"));
		lb.setSize(jf.getWidth(), 150);
		JLabel lb2 = new JLabel();
		lb2.setLayout(new GridLayout(1, 4));
		lb2.setBounds(100 * (4 - winners.size()) + 50, 100, jf.getWidth(), jf.getHeight() - 200);
		for (Champion c : winners) {
			JLabel champ = new JLabel();
			Wizard w = (Wizard) c;
			switch (w.no) {
			case 0:
				champ.setIcon(new ImageIcon("ch" + (w.no + 1) + ".png"));
				champ.setSize(champ.getIcon().getIconWidth(), champ.getIcon().getIconHeight());
				lb2.add(champ);
				break;
			case 1:
				champ.setIcon(new ImageIcon("ch" + (w.no + 1) + ".png"));
				champ.setSize(champ.getIcon().getIconWidth(), champ.getIcon().getIconHeight());
				lb2.add(champ);
				break;
			case 2:
				champ.setIcon(new ImageIcon("ch" + (w.no + 1) + ".png"));
				champ.setSize(champ.getIcon().getIconWidth(), champ.getIcon().getIconHeight());
				lb2.add(champ);
				break;
			case 3:
				champ.setIcon(new ImageIcon("ch" + (w.no + 1) + ".png"));
				champ.setSize(champ.getIcon().getIconWidth(), champ.getIcon().getIconHeight());
				lb2.add(champ);
				break;
			}
		}

		jp.add(lb);
		jp.add(lb2);
		jf.add(jp);
		jf.repaint();
		jf.revalidate();
		jf.setVisible(true);
		Timer t = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp.removeAll();
				jf.dispose();
			}
		});
		t.setRepeats(false);
		t.start();

	}
}

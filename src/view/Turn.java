package harrypotter.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import harrypotter.controller.FirstTaskCont;

public class Turn {

	public Turn(String x, String y,FirstTaskCont cont) {
		JFrame jf = new JFrame();
		jf.setResizable(false);
		jf.setUndecorated(true);
		jf.setSize(800, 300);
		jf.setLocationRelativeTo(null);
		JLabel bg = new JLabel(new ImageIcon());
		bg.setOpaque(false);
		bg.setLayout(new GridLayout(1, 1));
		jf.add(bg);
		JLabel txt = new JLabel(new ImageIcon( x));
		jf.setBackground(new Color(0, 0, 0, 0));
		bg.add(txt);
		jf.setVisible(true);
		jf.revalidate();
		jf.repaint();
		Timer t;
//		if(x==null&&y==null){
//			t = new Timer(1400, new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					new winners(cont);
//				}
//			});
//			t.setRepeats(false);
//			t.start();
//
//			t = new Timer(4400, new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					jf.dispose();
//				}
//			});
//			t.setRepeats(false);
//			t.start();
//		}
		if (y != null) {
			t = new Timer(1400, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					txt.setIcon(new ImageIcon( y));
				}
			});
			t.setRepeats(false);
			t.start();
		}
		int count = y == null ? 1400 : 2800;
		t = new Timer(count, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
			}
		});
		t.setRepeats(false);
		t.start();
	}

}

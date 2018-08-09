package harrypotter.controller;

import java.awt.Point;
import java.util.ArrayList;

import harrypotter.model.character.Champion;
import harrypotter.model.character.Wizard;

public abstract class Controller {

	public abstract void ChampDied(Wizard c);
	public abstract void showPotion(Point  p);
	public abstract void ChampWon(Wizard c) ;
	public abstract void champAffected(Champion c);
	public void fire(Point p){
		
	}
	
	public abstract void gameOver();

	public abstract void endTurn(String name);

	public abstract void move(Point target, Point point);

	public abstract void updateobs(Point target);
	public abstract void updateCur();
	public void showMarked(ArrayList<Point> c) {
		// TODO Auto-generated method stub
		
	}
	public abstract void startSecond(ArrayList<Champion>winners);
	public abstract void startThird(ArrayList<Champion>winners);
	public abstract void updatemer(Point target);
	public abstract void ChampWonSecond(Wizard current, Point location);
	public void encounter(int i) {
		// TODO Auto-generated method stub
		
	}
}

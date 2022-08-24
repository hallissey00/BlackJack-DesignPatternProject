package GUI;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import TwentyOneGame.GamePlay;

import GUI.ActionButtonListener;
import GUI.GameText;
import GUI.Table;


public class TwentyOneUI extends JFrame implements Observer {
	private GamePlay play;
	private JPanel Panel;
	private Table table;
	private GameText gameText;
	private JPanel actionbuttonlistener;
	

	public TwentyOneUI(GamePlay play) {
		this.play = play;
		Panel = new JPanel(new BorderLayout());
		table = new Table(this.play);
		gameText = new GameText();
		actionbuttonlistener = new ActionButtonListener(this.play, gameText, Panel);
		
		//GOT help for the action button listener on wcschools for where line and border layout be display
		Panel.add(table, BorderLayout.CENTER);
		Panel.add(actionbuttonlistener, BorderLayout.PAGE_END);
		Panel.add(gameText, BorderLayout.LINE_END);
		
		//showing the title for the game
		//
		this.setTitle("Twenty One");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setting the size of the panel when you run the game
		this.setSize(1500, 900);
		this.setContentPane(Panel);
		this.setVisible(true);
	}
	
	public JPanel getRootPanel() {
		return this.Panel;
	} public GameText getGameLogPanel() {
		return this.gameText;
	}
	//we use repaint the method is an asynchronous method of applet class
	@Override
	public void update(Observable o, Object arg) {
		if(arg == "repaint")
		   this.Panel.repaint();
		//using reset game log to restart the game 
		else if(arg == "reset game log")
			// goes back to the reset point
			this.gameText.reset();
		           else {
			this.gameText.log(arg);
		}
	}
}

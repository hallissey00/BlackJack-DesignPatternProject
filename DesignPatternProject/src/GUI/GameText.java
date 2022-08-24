package GUI;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GameText extends JScrollPane {
	private JTextArea Jtext;
	//adding game text to the game
	public GameText() {
		//when the game starts text welcopme will apear 
		Jtext= new JTextArea("Welcome to the game TWENTY ONE!\nWHEN UR READY TO PLAY PRESS DEAL!\n");
		Jtext.setColumns(30);
		Jtext.setEditable(false);
		this.setViewportView(Jtext);
		
	}
	
	public void log(Object arg) {
		Jtext.append(arg+"\n");
	}
	// when you play again text goodluck appear
	public void reset() {
		Jtext.setText("Ready to Play Again, GOOD LUCK!\nPress the deal button to play!\n");
	}
}



package GUI;

//importing bJbutton,Panel action event and listener
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import TwentyOneGame.GamePlay;
import GUI.GameText;


public class ActionButtonListener extends JPanel{

	  ///adding private state to the classes
	private GamePlay play;
	private GameText gameText;
	private JPanel Panel; //adding panel class for the buttons
	
	//adding a putting to the game
	private JButton dealButton; //deals out the cards
	private JButton hitButton; //this means you hit to get another card 
	private JButton stayButton; //this means you stay with the card you have 
	private JButton resetButton; //this button reset the game meaning you get to start again
	
	public ActionButtonListener(GamePlay play, GameText gameText, JPanel Panel) { //adding a action Button/Listener
		this.play = play; //adding it to the Gameplay Class
		this.gameText = gameText;
		this.Panel = Panel; 
		
		//adding the buttons with the name
		dealButton = new JButton("Deal"); //deal button
		hitButton = new JButton("Hit");//hit button
		stayButton = new JButton("Stay");//stay button
	    resetButton = new JButton("Start Again");////reset button
	    
	    //adding action listeners which I doubled checked online how to add deal,hit,stay and reset action listeners to help me
		dealButton.addActionListener(new DealActionListener());
		hitButton.addActionListener(new HitActionListener());
		stayButton.addActionListener(new StayActionListener());
		resetButton.addActionListener(new ResetActionListener());
		
		//adding buttons
		this.add(dealButton);
		this.add(hitButton);
		this.add(stayButton);
		this.add(resetButton);
	}
	 // i now adding private classes for the deal,hit,stay and reset action listners
	
	
	//Deal private class will aloud the player action event to click button
	//if the player got black it will display
	//will display let player know when its dealers turn
	      private class DealActionListener implements ActionListener {
		   public void actionPerformed(ActionEvent ev) {
			play.getCurrentState().startGame();
			if(play.player.hasBlackJack()) {
				gameText.log("!!!!PLAYER GOT BLACKJACK!!!!");
				gameText.log("Dealers Go!!!!");
				play.getCurrentState().endPlayerTurn();
			 }  else {
				gameText.log("Players turn to GO!!!!");
			}
			    Panel.repaint();
		}
	}

	      //This class displays that the player hit
	 private class HitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			if(play.getCurrentState().equals(play.getGamePlayerState())) {
				gameText.log("The Player decide to HIT!!");
				play.drawCardAndGiveToPlayer();
				Panel.repaint();
			}
		}
	}
	
	 // stay event that aloud the player to stay and not hit
	 private class StayActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			if(play.getCurrentState().equals(play.getGamePlayerState())) {
				gameText.log("The Player choose to STAY!!");
				gameText.log("The Dealer's Turn");
				play.getCurrentState().endPlayerTurn();
				Panel.repaint();
			}	
		}	
	}
	//reset the game startiing over again
	private class ResetActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			play.getCurrentState().resetGame();
			Panel.repaint();
		}
	}
}

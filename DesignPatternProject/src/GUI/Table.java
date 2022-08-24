package GUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;


import TwentyOneGame.GamePlay;
import GUI.CardImage;


public class Table extends JPanel {
	private GamePlay play;
	private CardImage dealerCards;
	private CardImage playerCards;
	
	public Table(GamePlay play) {
		this.play = play;
	 //seting the layout for the cards on the panel 
		this.setLayout(new GridLayout(2,4)); //grid layout for the cards
		dealerCards = new CardImage(this.play.getDealersCards());
		playerCards = new CardImage(this.play.getPlayersCards());
		
		//setting background color that i got from set background
		dealerCards.setBackground(new Color(1, 30, 50));
		playerCards.setBackground(new Color(1, 30, 50));

		
		this.add(dealerCards);
		this.add(playerCards);	
	}
}

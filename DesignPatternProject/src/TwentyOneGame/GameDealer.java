package TwentyOneGame;

import TwentyOneGame.DeckOfCards;
import TwentyOneGame.GamePlayer;

public class GameDealer extends GamePlayer {
//this be the class for the dealer 
	//extends the player class
	public GameDealer() {
		super();
	}
	
	public void flipCardsFaceUp() {
		for(DeckOfCards d : cardsInHand) {
			d.flipCardFaceUp();
		}
	}
}

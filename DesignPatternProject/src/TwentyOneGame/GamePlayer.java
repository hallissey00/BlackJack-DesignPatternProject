package TwentyOneGame;

import java.util.ArrayList;

import TwentyOneGame.DeckOfCards;

public class GamePlayer {

protected ArrayList<DeckOfCards> cardsInHand;
	//using array for the cards
	public GamePlayer() {
		cardsInHand = new ArrayList<DeckOfCards>();
	}
	//displaying the card on screen
	public void addCardToHand(DeckOfCards d) {
		cardsInHand.add(d);
	}
	
	public void removeCardsFromHand() {
		cardsInHand.clear();
	}
	
	//value if card is a ace
	public int getHandValue() {
		int numberOfAce = 0;
		
		int handValue = 0;
		//this is card code which will add 
		//the name of the card first letter or number it will repsoned to the picl
		//example if lands on Khearts it be +10 and displays king of hearts 
		for(DeckOfCards d : cardsInHand) {
			//the ace will be different than the rest
			if(d.getCardCode().contains("A")) numberOfAce++;
			else if(d.getCardCode().contains("2")) handValue += 2;
			else if(d.getCardCode().contains("3")) handValue += 3;
			else if(d.getCardCode().contains("4")) handValue += 4;
			else if(d.getCardCode().contains("5")) handValue += 5;
			else if(d.getCardCode().contains("6")) handValue += 6;
			else if(d.getCardCode().contains("7")) handValue += 7;
			else if(d.getCardCode().contains("8")) handValue += 8;
			else if(d.getCardCode().contains("9")) handValue += 9;
			else if(d.getCardCode().contains("0")) handValue += 10;
			else if(d.getCardCode().contains("J")) handValue += 10;
			else if(d.getCardCode().contains("Q")) handValue += 10;
			else if(d.getCardCode().contains("K")) handValue += 10;
		}
		
		// adding ace in hand to total value after calurlating  all others.
		for(int i = 0; i < numberOfAce; i++) {
			//if first cards gets age value should be worth 11 not 10
			if(handValue + 11 > 21) {
				//but if you hit and get ace it wont be 11 it be 1
				//if confused i wrote down the rule in the word doc for blackjack
				handValue += 1;
			} else {
				handValue += 11;
			}
		}
		
		return handValue;
	}
	
	public boolean hasBustedHand() {
		if(getHandValue() > 21)
			return true;
		else
			return false;
	}
	//when player has blackjack
	public boolean hasBlackJack() {
		if(getHandValue() == 21) 
			return true;
		else return false;
	}
	
	public ArrayList<DeckOfCards> getCards() {
		return cardsInHand;
	}
	
	//displaying players hand
	public void displayCardsInHand() {
		for(DeckOfCards d : cardsInHand) {
			System.out.print(d+ ", ");
		}
		System.out.println("");
	}
}

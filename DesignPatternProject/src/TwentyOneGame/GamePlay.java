package TwentyOneGame;

import java.util.ArrayList;
import java.util.Observable;

public class GamePlay extends Observable {
	
	private GamePlayState roundbeginsState;
	private GamePlayState gameplayerState;
	private GamePlayState gamedealerState;
	private GamePlayState roundoverState;
	private GamePlayState currentState;
	
	public GamePlayer player;
	public GameDealer dealer;
	private TestSingleton singleton;
	
	//this is the class we us allot of the state classes
	//this class will be the main part of the game rules
	public GamePlay() {
		roundbeginsState = new RoundBeginsState(this);
		gameplayerState = new GamePlayerState(this);
		gamedealerState = new GameDealerState(this);
		roundoverState = new RoundOverState(this);
		currentState = roundbeginsState;
		
		player = new GamePlayer();
		dealer = new GameDealer();
		singleton = TestSingleton.getInstance();
	}
	
	public void setState(GamePlayState newState) {
		currentState = newState;
	}
	
	public GamePlayState getCurrentState() {
		return currentState;
	}
	//start  state will be playing the game when start button clciked
	public GamePlayState getStartState() {
		return this.roundbeginsState;
	}
	
	public GamePlayState getGamePlayerState() {
		return this.gameplayerState;
	}
	//dealer turn state occurs when its dealers turn to go
	public GamePlayState getDealerTurnState() {
		return this.gamedealerState;
	}
	//get round end state occurs when rounds over 
	public GamePlayState getRoundEndState() {
		return this.roundoverState;
	}
	
	//sending log message, log message  is a text string with an abundance of contextual information
	public void sendGameLogUpdate(String logMessage) {
		setChanged();
		notifyObservers(logMessage);
	}
	
	public void sendUIRepaintUpdate() {
		setChanged();
		notifyObservers("repaint");
	}
	
	//send log message to restart the game
	public void sendGameLogResetUpdate() {
		setChanged();
		notifyObservers("reset game log");
	}
	
	//we send"log" update messages to show what happen in the game 
	//using thread class run()
	public void run() {
		boolean running = true;
		while(running) {
			//if player goes over 21 he goes bust
		if(currentState.equals(gameplayerState)) {
			if(player.hasBustedHand()) {
				sendGameLogUpdate("Player has gone Busted!\n"+getWinner());
				currentState.endRound();
			}
				//if player has black which be ace with king or jace or queen he has won
			 if(player.hasBlackJack()) {
			 sendGameLogUpdate("Player has 21!\n"+getWinner());
			 currentState.endRound();
			}
		}
			//show if dealer has won, lost or stays and waiting for player to go
			if(currentState.equals(gamedealerState)) {
				if(dealerShouldEndTurn()) {
					//if dealer gets blackjack
					if(dealer.hasBlackJack()) {
						sendGameLogUpdate("Dealer has got Blackjack!\n"+getWinner());
						//if dealer has gone bust over 21
					} else if(dealer.hasBustedHand()) {
						sendGameLogUpdate("Dealer ha gone Busted!\n"+getWinner());
						//the dealer decides to stay if he gets under 21
					} else {
						sendGameLogUpdate("Dealer decides to STAY!!!!\n"+getWinner());
					}
					currentState.endRound();
					
				}
				
				//reacts when dealer hits
				if(!dealerShouldEndTurn()) {
					sendGameLogUpdate("Dealer Hits!");
					drawCardAndGiveToDealer(false);
					//when the dealer gets 21
					if(dealer.hasBlackJack()) {
						sendGameLogUpdate("!!!!!!Dealer has 21!!!!!\n"+getWinner());
						currentState.endRound();
					}
					//if dealer gone over 21
					if(dealer.hasBustedHand()) {
						sendGameLogUpdate("Dealer Busts!\n"+getWinner());
						currentState.endRound();
					}
				}
			}
			//using thread sleep cause it causes the current thread to suspend execution for a specified time
			//how long it takes for the dealer to respond
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			sendUIRepaintUpdate();
		}
	}
	//adding flipcardsfaceup if player busts before the dealers cards are flip.
	
	public void reset() {
		shuffleDeck();
		player.removeCardsFromHand();
		dealer.flipCardsFaceUp(); 
		dealer.removeCardsFromHand();
	}
	//dealing the cards to player and dealer
	public void dealCards() {
		for(int i = 0; i < 2; i++) {
			drawCardAndGiveToPlayer();
			if(i == 0) {
				drawCardAndGiveToDealer(true);
			} else {
				drawCardAndGiveToDealer(false);
			}
		}
	}
	//using a single thing to represent the deck and using hasNext
	public void drawCardAndGiveToDealer(boolean faceDown) {
		if(singleton.hasNext()) {
			DeckOfCards c = singleton.next();
			if(faceDown)
				c.flipCardFaceDown();
			dealer.addCardToHand(c);
		}
	}
	
	public void drawCardAndGiveToPlayer() {
		if(singleton.hasNext()) {
			DeckOfCards c = singleton.next();
			player.addCardToHand(c);
		}
	}
	//singleton shuffle the cards
	public void shuffleDeck() {
		this.singleton.shuffle();
	}
	//using an array list for memory of deck of cards
	//getting cards for player and dealers
	public ArrayList<DeckOfCards> getPlayersCards() {
		return player.getCards();
	}
	
	public ArrayList<DeckOfCards> getDealersCards() {
		return dealer.getCards();
	}
	//used to website to help me with this
	//its when delear response by using boolean when delaer has black, bust
	public boolean dealerShouldEndTurn() {
		if(dealer.hasBlackJack() || dealer.hasBustedHand() || ((dealer.getHandValue() >= 17) && (dealer.getHandValue() >= player.getHandValue()))){
			return true;
		}
		return false;
	}

	public void flipDealerCardsFaceUp() {
		dealer.flipCardsFaceUp();
	}
	//text comes up when response to action event when round is over by certain event
	public String getWinner() {
		if(player.hasBustedHand() && !dealer.hasBustedHand()) {
			return "Dealer Wins!\nPress Start Again to play again!";
		}
		else if(!player.hasBustedHand() && dealer.hasBustedHand()) {
			return "Player Wins!\nPress Start Again to play again!";
		}
		else if(player.getHandValue() > dealer.getHandValue()) {
			return "Player Wins!\nPress Start Again to play again!";
		}
		else if(player.getHandValue() < dealer.getHandValue()) {
			return "Dealer Wins!\nPress Start Again to play again!";
		} else {
			return "It's a tie!\nPress Start Again to play again!";
		}
	}
}
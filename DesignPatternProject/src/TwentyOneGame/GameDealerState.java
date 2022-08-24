package TwentyOneGame;

import TwentyOneGame.GamePlay;
import TwentyOneGame.GamePlayState;

public class GameDealerState implements GamePlayState {
//using game state for Dealerturn to hit, start game, end round or reset
	//state pattern for the  Dealer
	//the claases that are states the dealer state will react to 
	
	private GamePlay play;
	
	public GameDealerState(GamePlay play) {
		this.play = play;
	}
	
	@Override
	public void startGame() {
		return;
		
	}

	@Override
	public void endPlayerTurn() {
		return;
		
	}

	@Override
	public void endRound() {
		play.setState(play.getRoundEndState());
	}

	@Override
	public void resetGame() {
		return;
	}

}

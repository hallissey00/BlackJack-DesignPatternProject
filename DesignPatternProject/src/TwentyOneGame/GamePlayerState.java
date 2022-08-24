package TwentyOneGame;

public class GamePlayerState implements GamePlayState {
//state class which will conect to the the game play state
	//player will respond to the rules to the game play class
	private GamePlay play;
	
	public GamePlayerState(GamePlay play) {
		this.play = play;
	}
	
	@Override
	public void startGame() {
		return;
	}

	@Override
	public void endPlayerTurn() {
		play.flipDealerCardsFaceUp();
		play.setState(play.getDealerTurnState());
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
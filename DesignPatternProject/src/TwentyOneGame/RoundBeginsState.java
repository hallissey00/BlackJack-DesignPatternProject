package TwentyOneGame;

public class RoundBeginsState implements GamePlayState {

	//related as our round over state
	private GamePlay play;
	
	public RoundBeginsState(GamePlay play) {
		this.play = play;
	}
	//displaying the cards after the game is has started 
	@Override
	public void startGame() {
		play.dealCards();
		play.setState(play.getGamePlayerState());
	}

	@Override
	public void endPlayerTurn() {
		return;
	}

	@Override
	public void endRound() {
		return;
		
	}

	@Override
	public void resetGame() {
		return;
	}

}
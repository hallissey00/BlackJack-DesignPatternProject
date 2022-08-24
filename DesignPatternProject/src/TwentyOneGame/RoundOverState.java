package TwentyOneGame;


//this state is when round is over 
//when round over player should be able to start game again
public class RoundOverState implements GamePlayState {

	private GamePlay play;
	
	public RoundOverState(GamePlay play) {
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
		return;
	}

	
	//sending log reset message to reset the game and using start state to start the game again
	//start state will be connected to class which we will have round that will start
	@Override
	public void resetGame() {
		play.reset();
		play.sendGameLogResetUpdate();
		play.setState(play.getStartState());
	}


}
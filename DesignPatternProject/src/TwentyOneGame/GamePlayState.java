package TwentyOneGame;
//using state to allow object alter its behavior
//allows different behaviours based its internal state
//state pattern allows context to change its behavour
public interface GamePlayState {
//will respond with other classes to the game, player turn to go, round over and to reset the game
	public void startGame();
	public void endPlayerTurn();
	public void endRound();
	public void resetGame();
}

package TwentyOneGame;

import GUI.TwentyOneUI;

public class TwentyOne {
//connecting to the UI Twenty one
	//connecting to the gamplay class 
	//runs the game
	public static void main(String[] args) {
		GamePlay play = new GamePlay();
		TwentyOneUI twentyoneUI = new TwentyOneUI(play);
		play.addObserver(twentyoneUI);
		play.run();
	}
}
package TwentyOneGame;

public class DeckOfCards {
	//getting string for card name and when cards facedown 
	private String cardName;
	private boolean faceDown;
	
	public DeckOfCards(String cardName) {
		this.cardName = cardName;
	}
	//we be using a card code 0-9 to responed when it lads on a card
	//the card code will be on the player class which is gameplayer
	public String getCardCode() {
		return cardName;
	}
	//this is the code we access the assets folder which will have the deck of cards
	//reference for deck of cards was from google images
	public String getImagePath() {
		//accessing the assets folder
		String ImagePath = "assets/cardsimg/";
		//if cards face down which be dealers card 
		//joker image be there which be a face down card
		if(faceDown) {
			return ImagePath + "joker.png";
		} else {
			//we will be having the card name in the test singleton class
			return ImagePath + cardName + ".png";
		}
	}
	
	public boolean isFaceDown() {
		return faceDown;
	}
	
	public void flipCardFaceDown() {
		faceDown = true;
	}
	
	public void flipCardFaceUp() {
		faceDown = false;
	}
	
	@Override
	public String toString() {
		return cardName + " Face down: " + faceDown;
	}
}

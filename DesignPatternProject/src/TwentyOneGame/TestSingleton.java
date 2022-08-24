package TwentyOneGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


//singleton makes use of a private constructor
//using singleton for global point to access it
//impliments iterator to access aggregates
//Itator relieves the aggregate of supporting opperations of transvering data
public class TestSingleton implements Iterator<DeckOfCards> {
	
	
	//we use it to store the names of the assets folder images
	final static String[] cardName = {
			"AClubs", "ADimonds", "AHearts", "ASpades",
			"2Clubs", "2Dimonds", "2Hearts", "2Spades",
			"3Clubs", "3Dimonds", "3Hearts", "3Spades",
			"4Clubs", "4Dimonds", "4Hearts", "4Spades",
			"5Clubs", "5Dimonds", "5Hearts", "5Spades",
			"6Clubs", "6Dimonds", "6Hearts", "6Spades",
			"7Clubs", "7Dimonds", "7Hearts", "7Spades",
			"8Clubs", "8Dimonds", "8Hearts", "8Spades",
			"9Clubs", "9Dimonds", "9Hearts", "9Spades",
			"0Clubs", "0Dimonds", "0Hearts", "0Spades",
			"JClubs", "JDimonds", "JHearts", "JSpades",
			"QClubs", "QDimonds", "QHearts", "QSpades",
			"KClubs", "KDimonds", "KHearts", "KSpades",
	};
	
	private final int totalCards = 52;
	private int iteratorPosition = 0;
	private ArrayList<DeckOfCards> deck;
	//using uniqueinstance for static variable to hold our in instance 
	//constructor decalred private
	private static TestSingleton uniqueInstance;
	
	private TestSingleton() {
		deck = new ArrayList<DeckOfCards>();
		
		
		for(String c : cardName) {
			deck.add(new DeckOfCards(c));
		}

		this.shuffle();
		
	}
	//getinstance method way to instantiate the class to return instance of class
	public static TestSingleton getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new TestSingleton();
		}
		
		return uniqueInstance;
	}
	
	
	public void shuffle() {
		Collections.shuffle(deck);
		iteratorPosition = 0;
	}

	@Override
	public boolean hasNext() {
		if(iteratorPosition < totalCards)
			return true;
		else
			return false;
	}

	@Override
	public DeckOfCards next() {
		DeckOfCards d = deck.get(iteratorPosition);
		iteratorPosition++;
		
		return d;
	}
}
package GUI;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import TwentyOneGame.DeckOfCards;


public class CardImage extends JPanel {
	
	//getting width and height of what the cards will be
	private int imageWidth = 150;
	private int imageHeight = 200;
	private ArrayList<DeckOfCards> deck; //getting array list of the cards
	
	public CardImage(ArrayList<DeckOfCards> deck) {
		this.deck = deck;
	}
	
	//adding paint component for the background/panel
	//adding the size 
	//we add buffered image is subclass of Image class. It is used to handle and manipulate the image data
	//we have IMAGE IO which is a superclass
	//we have IOException its Base class for character conversion exceptions.
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		try {
			for(int i = 0; i < deck.size(); i++) {
				BufferedImage cardImage =
						ImageIO.read(new File(deck.get(i).getImagePath()));
				gr.drawImage(cardImage, ((imageWidth+3)*i), 40, imageWidth, imageHeight, this);
			}
		} catch(IOException ex) {
			System.out.println(ex);
		}
	}
}

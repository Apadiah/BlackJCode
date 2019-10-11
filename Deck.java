package codes;

import java.util.Random;

public class Deck {
	private Card[] mi_Cards;
	private int cardNum;
	
	public Deck() {
		this(1,  false);
	}
	
	public Deck(int numDecks ,boolean shuffled) {
		this.cardNum = numDecks*52;
		this.mi_Cards = new Card[this.cardNum];
		int c= 0;
		for( int dc = 0; dc<numDecks;dc++) {
			
			
			for( int st = 0;st<4;st++) {
				
				for (int n = 1;n<=13;n++) {
					
					this.mi_Cards[c]= new Card(Suit.values()[st],n);
					c++;
				}
			}
		}
		
		if(shuffled) {
			this.shuffled();
		}
		
		
	}
public void shuffled() {

	Random rng = new Random();
	Card temp ;
	int j ;
	
	for (int i = 0; i<this.cardNum;i++) {
		j = rng.nextInt(this.cardNum);
		
		temp = this.mi_Cards[i];
		this.mi_Cards[i]=this.mi_Cards[j];
		this.mi_Cards[j]=temp;
		
		
	}
}
public Card Distribute_nextCard()
{
	Card top = this.mi_Cards[0];
	
	for (int c = 1; c<this.cardNum;c++)
	{
		this.mi_Cards[c-1]= this.mi_Cards[c];
		
	}
	this.mi_Cards[this.cardNum-1]= null;
	this.cardNum--;
	
	
	return top;
	

}

public void  printDeck(int numToDisplay)
{
	for(int c = 0; c<numToDisplay;c++) {
		System.out.printf("% 3d/%d %s\n", c+1 ,this.cardNum,this.mi_Cards[c].toString());
		
	}
	
	System.out.printf("\t\t[%d other ]\n",this.cardNum-numToDisplay);
	
	
}
}


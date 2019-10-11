package codes;

public class Player
{


	
	private String name ;
	
	private Card[] hand = new Card [10];
	
	private int num_Cards;
	
	public Player(String theName)
	{
		this.name = theName;
		this.VoidHand();
		
	}
	
	public boolean choice(String answer) {
		
		if (answer  == "competitor" ) {
			System.out.println("Competitor mode ");
		}return true;
		
		
		
	}
	
	public void VoidHand()
	{
		for (int c = 0; c<10 ;c++ )
		{
			this.hand[c]=null;
			
		}
		this.num_Cards=0;
		
	}

	public void appendCard( Card ACard)		
	{
	if(this.num_Cards ==10 ) 		
	{
		System.err.printf("%s's hand already has 10 cards : cannot add another\n",this.name);
		//System.exit(1);
		
			}else {
	
	this.hand[this.num_Cards]=ACard;
	this.num_Cards ++;
	//return (this.SumOfHand()<= 21);
			}
	
	}
	
	public int SumOfHand()	
	{
		int handSum= 0;
		int cardNum;
		int numAces = 0;
		
		for (int c= 0 ; c<this.num_Cards;c++)
		{
			cardNum = this.hand[c].getting_Number();
			if ((cardNum == 1)) 
			{
				numAces++;
				handSum+=11;
			}
			else if(cardNum > 10)
			{
				handSum +=10;}else
				{
				handSum+=cardNum;
			
				
				
				}
			}
		
		while( handSum >21 && numAces > 0)
		{
			handSum-=10;
			numAces--;
			
		}
		return handSum;
		
	}
	
	public void DisplayHand(boolean showFirstCard)
	{
		System.out.printf("%s cards;\n", this.name);
		for(int c = 0;c<this.num_Cards;c++)
		{
			if (c==0 && !showFirstCard) {
				System.out.println("[hidden]");
				
			}
			else
			{
				System.out.printf("%s\n",this.hand[c].toString());
			}
		}
	
	}
	

	
}
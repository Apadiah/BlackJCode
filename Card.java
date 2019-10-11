package codes;

public class Card
{
	private Suit miSuit;
	private int miNumber;
	
public Card(Suit ASuit ,int aNum)
{
	this.miSuit =  ASuit;
	
	
	if (aNum >=1 && aNum <= 13)
	
	{
	this.miNumber = aNum;}
	else {
		System.err.println(aNum +" is not an accepted card number ");
	System.exit(1);}
	}
	





public int getting_Number()

{
	return miNumber;
}

public String toString()

{
	String numStr = "Error";
	
	switch (this.miNumber)
	
	{
	case 2 :
		numStr= "two";
		break;
		
	case 3:
		numStr = "Three";
		break;
	case 4:
		numStr = "Four";
		break;
	case 5:
		numStr = "Five";
		break;
	case 6 :
		numStr ="Six";
		break;
	case 7:
		numStr="Seven";
		break;
	case 8:
		numStr = "Eight";
		break ;
	case 9:
		numStr= "Nine";
		break;
	case 10:
		numStr = "Ten";
		break;
	case 11 :
		numStr = "Jack";
		break;
	case 12:
		numStr = "Queen";
		break;
	case 13:
		numStr = "King";
		break;
	case 1:
		numStr = "Ace";
		break;
	} return numStr + " of "+ miSuit.toString();

}}

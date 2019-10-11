package codes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gui extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int aW= (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int aH= (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	

		
	
	
	Font fontButton = new Font("Times new Roman",Font.PLAIN,30);
	//color
	Color colorBackground = new Color(226,173,26);
	Color colorButton = new Color(201,46,201);
	//buttons
	JButton bHit = new JButton();
	JButton bstay = new JButton();
	JButton bno = new JButton();
	JButton byes = new JButton();
	
	
	//card grid position and dimensions 
	int gridX =50;
	int gridY = 50;
	int gridW= 900;
	int gridH = 400;
	
	//totals and hitstay grid positioning  and dimensions 
	int hsX = gridX + gridW + 50;
	int hsY = gridY;
	int hsw=250;
	int hsh= 400;
	
	//play more 
	int pmX = hsX;
	int pmY = hsY +hsh+50;
	int pmH =200;
	int pmW = hsw;
	
	
	Player mySelf;
	
	Player player;
	boolean myselfDone;
	Deck actualDeck;
	boolean dealerDone;
	String ans;
	public void Hit() {
		
		if (!this.myselfDone || !this.dealerDone)
			
		{
			if(!this.myselfDone)
			
			{
				
				
				
				//System.out.println("\n");
				
				
				
			
					//System.out.println("____________");
					this.mySelf.appendCard(this.actualDeck.Distribute_nextCard());// check if the new sum is over 21
					if(this.mySelf.SumOfHand()>21) {System.out.println("BUST !!!!!!!!!!! YOU HAVE LOST THE GAME !");
					System.out.println("Your Cards were : ");
					this.myselfDone=true; }
					this.mySelf.DisplayHand(true);
			
					
				
					
				}
			this.myselfDone = true;
			return;
						}
		else {
			System.out.println("Game OVer ------ The Dealer Has Won the Game  !!!");
		}
		}
		
	
	
	
	public void Stay() {
	
		if(!this.dealerDone)
		{
			if(this.player.SumOfHand() <17)
			
			{
				this.player.appendCard(this.actualDeck.Distribute_nextCard());
				if(this.player.SumOfHand()>21) { JOptionPane.showMessageDialog(bHit, "dealer bust");dealerDone=true;}
				this.player.DisplayHand(false);}
			else
			{
				System.out.println("The Dealer stays");
				this.dealerDone = true;
				return;
				
			}
			}
	}
	

	
	
public Gui() {
	this.setSize(aW+6,aH+29);
	this.setTitle("Black JAcks");
	this.setVisible(true);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Board board = new Board();
	this.setContentPane(board);
	
	this.setLayout(null);
	ActHit aHit = new ActHit();
	bHit.addActionListener(aHit);
	bHit.setBounds(hsX+55, hsY+40, 120, 80);
	
	bHit.setBackground(colorButton);
	board.add(bHit);
	bHit.setText("HIT");
	bHit.setFont(fontButton);
	//button stuff
	
	ActStay astay = new ActStay();
	bstay.addActionListener(astay);
	bstay.setBounds(hsX+55, hsY+280, 120, 80);
	
	bstay.setBackground(colorButton);
	board.add(bstay);
	bstay.setText("STAY");
	bstay.setFont(fontButton);
	
	

	
	byes.setBackground(colorButton);
	board.add(byes);
	byes.setText("YES");
	byes.setFont(fontButton);
	


	bno.setBackground(colorButton);
	board.add(bno);
	bno.setText("NO");
	bno.setFont(fontButton);
	System.out.println(" Welcome to BlackJack !!!!");

	 this.actualDeck = new Deck (1,true);
	
	//String theName = scan.nextLine();
	 this.mySelf = new Player("Player 1");
	System.out.println();
	 this.player = new Player("Dealer");
	
	
	this.mySelf.appendCard(this.actualDeck.Distribute_nextCard());
	this.player.appendCard(this.actualDeck.Distribute_nextCard());
	
	
	
	
	this.mySelf.appendCard(this.actualDeck.Distribute_nextCard());
	this.player.appendCard(this.actualDeck.Distribute_nextCard());
	
	
	
	
	
	System.out.println(" CARDS ARE DEALT :");
	System.out.println("_______________");
	mySelf.DisplayHand(true);
	player.DisplayHand(false);
	System.out.println("\n");
	
	 this.myselfDone= false;
	 this.dealerDone= false;
	
}
	//Scanner scan = new Scanner(System.in);
	



public class Board extends JPanel{
	
 



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		g.setColor(colorBackground);
		g.fillRect(0, 0, aW, aH);
		g.setColor(colorBackground);
		
		
		//tmporary
		g.setColor(Color.black);
		g.drawRect(gridX,gridY,gridW,gridH);
		
		g.drawRect(gridX, gridY+gridH+50, gridW, 500);
		
		//totals and hit stay messages and buttons grid
		
		g.drawRect(hsX, hsY,hsw, hsh);
		
	
		
		g.setFont(fontButton);
		//g.drawString(this., gridW+80, gridX+90);
	
        BufferedImage cardImg = null;
       String filepath = "JPEG\\10C.png";
        try {
            cardImg = ImageIO.read(new File(filepath));
        } catch (IOException e) {
        }
        g.drawImage(cardImg,hsX,hsY,96,7,this);

    
		
	
}}

public class ActHit implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//System.out.println("you just clicked the Hit Button");
		
		
		
		Hit();
		
		
	}
}
	
	
	
	public class ActStay implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("you just clicked the Stay Button");
			Stay();
		}}
		
		
		
		
	
public static void main(String[] args) {		
	Gui gui = new Gui();

}}


			
	
			
		


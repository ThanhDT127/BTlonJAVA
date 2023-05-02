package Menu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class ShopMenu extends Menu{
	public int Pig,Cow,Chicken, land = 23, price = 1;
	public int PseedTomato,PseedPotato,PseedCorn,PseedCarrot;
	public int Ppig,Pcow,PChicken;
	public int PfoodPig,PfootCow,PfoodChiken;
	public BufferedImage iland;
	public ShopMenu(GamePanel gp){
		this.gp=gp;

		try {
			IChicken = ImageIO.read(getClass().getResourceAsStream("/itemmenu/chicken.png"));
			ICow = ImageIO.read(getClass().getResourceAsStream("/itemmenu/cow.png"));
			IPig = ImageIO.read(getClass().getResourceAsStream("/itemmenu/pig.png"));
			IfoodPig = ImageIO.read(getClass().getResourceAsStream("/itemmenu/foodpig.png"));
			IfoodChicken = ImageIO.read(getClass().getResourceAsStream("/itemmenu/foodchicken.png"));
			IfoodCow = ImageIO.read(getClass().getResourceAsStream("/itemmenu/foodcow.png"));
			IseedCarrot = ImageIO.read(getClass().getResourceAsStream("/itemmenu/seedcarrot.png"));
			IseedTomato = ImageIO.read(getClass().getResourceAsStream("/itemmenu/seedtomato.png"));
			IseedPotato = ImageIO.read(getClass().getResourceAsStream("/itemmenu/seedpotato.png"));
			IseedCorn = ImageIO.read(getClass().getResourceAsStream("/itemmenu/seedcorn.png"));
			iland = ImageIO.read(getClass().getResourceAsStream("/tiles/land.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		setprice();
	}
	
	public void setprice() {
		PseedCarrot=25;
		PseedCorn=15;
		PseedPotato=30;
		PseedTomato=20;
		PfoodPig=1;
		PfootCow=2;
		PfoodChiken=1;
		Ppig=400;
		Pcow=1500;
		PChicken=120;
		
	}
	
	public void draw(Graphics2D g2) {

		MnX = gp.tileSize*5;
		MnY=0;
		width = gp.tileSize*6;
		height = gp.tileSize*4;
		

		slotXstart = MnX+24;
		slotYstart = MnY+24;
		

		
		cursorX = slotXstart + ( slotCol*gp.tileSize );
		cursorY = slotYstart + ( slotRow *gp.tileSize );
		CursorWidth = gp.tileSize;
		CursorHeight = gp.tileSize;
		
		//set Font
		Font f = new Font("Arial",Font.BOLD,14);
		g2.setFont(f);

		
		ifX = gp.tileSize*5;;
		ifY = gp.tileSize*4;
		ifWidth = gp.tileSize*6;
		ifHeight = gp.tileSize*2;
		

		c = new Color(0, 0, 0, 200);
		g2.setColor(c);
		g2.fillRoundRect(MnX, MnY,width, height, 35, 35);
		g2.fillRoundRect(ifX, ifY, ifWidth, ifHeight, 35, 35);
		c= Color.WHITE;
		g2.setColor(c);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(MnX+5, MnY+5, width-10, height-10, 20, 20);
		

		g2.setStroke(new BasicStroke(2));
		g2.drawRoundRect(cursorX, cursorY, CursorWidth, CursorHeight, 10, 10);
		
		
			
		g2.drawImage(ICow, slotXstart+12 , slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
		g2.drawImage(IPig, slotXstart+12+gp.tileSize , slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
		g2.drawImage(IChicken, slotXstart+12+gp.tileSize*2 , slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
		g2.drawImage(IfoodCow, slotXstart+12+gp.tileSize*3 , slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
		g2.drawImage(IfoodPig, slotXstart+12+gp.tileSize*4 , slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
		g2.drawImage(IfoodChicken, slotXstart+12 , slotYstart+12+gp.tileSize, gp.tileSize/2, gp.tileSize/2, null);
		g2.drawImage(IseedPotato, slotXstart+12+gp.tileSize , slotYstart+12+gp.tileSize, gp.tileSize/2, gp.tileSize/2, null);
		g2.drawImage(IseedTomato, slotXstart+12+gp.tileSize*2 , slotYstart+12+gp.tileSize, gp.tileSize/2, gp.tileSize/2, null);
		g2.drawImage(IseedCarrot, slotXstart+12+gp.tileSize*3 , slotYstart+12+gp.tileSize, gp.tileSize/2, gp.tileSize/2, null);
		g2.drawImage(IseedCorn, slotXstart+12+gp.tileSize*4 , slotYstart+12+gp.tileSize, gp.tileSize/2, gp.tileSize/2, null);
		g2.drawImage(iland, slotXstart+12, slotYstart+12+gp.tileSize*2, gp.tileSize/2, gp.tileSize/2, null );
		
		
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(ifX+5, ifY+5, ifWidth-10, ifHeight-10, 20, 20);
		
		
		if(checkEnter==true) {
			c = Color.yellow;
			g2.setColor(c);
			g2.drawRoundRect(cursorX, cursorY,CursorWidth, CursorHeight, 10, 10);

			if( slotCol == 0 && slotRow == 0 && gp.houseMenu.coin >= 1500) {
				g2.drawString("Mua 1 con bo voi gia: "+Pcow+" ?", ifX+gp.tileSize, ifY+gp.tileSize);
			}
			if(slotCol == 0 && slotRow == 0 && gp.houseMenu.coin < 1500 ){
				g2.drawString("Khong du: "+Pcow+" tien !", ifX+gp.tileSize, ifY+gp.tileSize);
			}
			if( slotCol == 1 && slotRow == 0 && gp.houseMenu.coin >=400) {
				g2.drawString("Mua 1 con heo voi gia: "+Ppig+" ?", ifX+gp.tileSize, ifY+gp.tileSize);
			}
			if(slotCol == 1 && slotRow == 0 && gp.houseMenu.coin < 400 ){
				g2.drawString("Khong du: "+Ppig+" tien !", ifX+gp.tileSize, ifY+gp.tileSize);
			}
			if( slotCol == 2 && slotRow == 0 && gp.houseMenu.coin >= 120) {
				g2.drawString("Mua 1 ga voi gia: "+PChicken+" ?", ifX+gp.tileSize, ifY+gp.tileSize);
			}
			if(slotCol == 2 && slotRow == 0 && gp.houseMenu.coin < 120 ){
				g2.drawString("Khong du: "+PChicken+"tien !", ifX+gp.tileSize, ifY+gp.tileSize);
			}
			if( slotCol == 3 && slotRow == 0 ) {
				g2.drawString("Mua 1 thuc an bo voi gia: "+PfootCow+" ?", ifX+gp.tileSize, ifY+gp.tileSize);
			}
			if( slotCol == 4 && slotRow == 0 ) {
				g2.drawString("Mua 1 thuc an lon voi gia: "+PfoodPig+" ?", ifX+gp.tileSize, ifY+gp.tileSize);
			}
			// hang 2
			if( slotCol == 0 && slotRow == 1 ) {
				g2.drawString("Mua 1 thuc an ga voi gia: "+PfoodChiken+" ?", ifX+gp.tileSize, ifY+gp.tileSize);
			}
			if( slotCol == 1 && slotRow == 1 ) {
				g2.drawString("Mua 1 hat giong khoai tay voi gia: "+PseedPotato+" ?", ifX+gp.tileSize-20, ifY+gp.tileSize);
			}
			if( slotCol == 2 && slotRow == 1 ) {
				g2.drawString("Mua 1 hat giong ca chua voi gia: "+PseedTomato+" ?", ifX+gp.tileSize-20, ifY+gp.tileSize);
			}
			if( slotCol == 3 && slotRow == 1 ) {
				g2.drawString("Mua 1 hat giong carrot voi gia: "+PseedCarrot+" ?", ifX+gp.tileSize-20, ifY+gp.tileSize);
			}
			if( slotCol == 4 && slotRow == 1 ) {
				g2.drawString("Mua 1 hat giong ngo voi gia: "+PseedCorn+" ?", ifX+gp.tileSize-20, ifY+gp.tileSize);
			}
			if( slotCol == 0 && slotRow == 2 ) {
				if( gp.houseMenu.coin > gp.shopMenu.price*5000)
				g2.drawString("Mo o dat voi gia : "+ gp.shopMenu.price*5000+" ?", ifX+gp.tileSize-20, ifY+gp.tileSize);
				else g2.drawString("Khong du tien!", ifX+gp.tileSize-20, ifY+gp.tileSize);
			}
		}
	}
	
}

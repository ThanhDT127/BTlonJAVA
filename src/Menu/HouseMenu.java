package Menu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class HouseMenu extends Menu{
	public int coin = 1000000;
	public int tomato, potato, corn, carrot;
	public int Ptomato=40, Ppotato=50, Pcorn=90, Pcarrot=75;
	public BufferedImage itomato, ipotato, icorn, icarrot, icoin;
	public HouseMenu(GamePanel gp) {
		this.gp = gp;
		tomato = 2;
		potato = 2;
		corn = 2;
		carrot = 2;
		SeedCarrot =2;
		SeedTomato =2;
		SeedCorn =2;
		SeedPotato =2;
		FoodPig = 10000;
		FoodChicken =10000;
		FoodCow =10000;
		try {
			itomato = ImageIO.read(getClass().getResourceAsStream("/fruit/tomato.png"));
			ipotato = ImageIO.read(getClass().getResourceAsStream("/fruit/potato.png"));
			icorn = ImageIO.read(getClass().getResourceAsStream("/fruit/corn.png"));
			icarrot = ImageIO.read(getClass().getResourceAsStream("/fruit/carrot.png"));
			
			IfoodPig = ImageIO.read(getClass().getResourceAsStream("/itemmenu/foodpig.png"));
			IfoodChicken = ImageIO.read(getClass().getResourceAsStream("/itemmenu/foodchicken.png"));
			IfoodCow = ImageIO.read(getClass().getResourceAsStream("/itemmenu/foodcow.png"));
			IseedCarrot = ImageIO.read(getClass().getResourceAsStream("/itemmenu/seedcarrot.png"));
			IseedTomato = ImageIO.read(getClass().getResourceAsStream("/itemmenu/seedtomato.png"));
			IseedPotato = ImageIO.read(getClass().getResourceAsStream("/itemmenu/seedpotato.png"));
			IseedCorn = ImageIO.read(getClass().getResourceAsStream("/itemmenu/seedcorn.png"));
			icoin = ImageIO.read(getClass().getResourceAsStream("/person/coin.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) {
			// SET MENU
			MnX = gp.tileSize*5;
			MnY = 0;
			width = gp.tileSize*6;
			height = gp.tileSize*4;
			
			// SET SLOT
			slotXstart = MnX +24;
			slotYstart = MnY +24;

			
			// SET CURSOR
			cursorX = slotXstart + ( slotCol*gp.tileSize );
			cursorY = slotYstart + ( slotRow *gp.tileSize );
			CursorWidth = gp.tileSize;
			CursorHeight = gp.tileSize;
			
			// SET FONT
			Font f = new Font("Arial", Font.BOLD, 14);
			g2.setFont(f);
			
			// SET INFORMATION
			ifX = gp.tileSize*5;;
			ifY = gp.tileSize*4;
			ifWidth = gp.tileSize*6;
			ifHeight = gp.tileSize*2;
			
			// DRAW MENU
			c = new Color(0, 0, 0, 200);
			g2.setColor(c);
			g2.fillRoundRect(MnX, MnY,width, height, 35, 35);
			g2.fillRoundRect(ifX, ifY, ifWidth, ifHeight, 35, 35);
			c = Color.white;
			g2.setColor(c);
			g2.setStroke(new BasicStroke(3));
			g2.drawRoundRect(MnX+5, MnY+5, width-10, height-10, 20, 20);
			// DRAW CURSOR
			g2.setStroke(new BasicStroke(2));
			g2.drawRoundRect(cursorX, cursorY, CursorWidth, CursorHeight, 10, 10);
			
			// DRAW FRUIT
			if( tomato > 0) {
				g2.drawImage(itomato, slotXstart+12 , slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
				g2.drawString(tomato+"", slotXstart, slotYstart+41);
			}
			if( potato > 0) {
				g2.drawImage(ipotato, slotXstart+12+gp.tileSize , slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
				g2.drawString(potato+"", slotXstart+gp.tileSize, slotYstart+41);
			}
			if( carrot > 0) {
				g2.drawImage(icarrot, slotXstart+12+gp.tileSize*2 , slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
				g2.drawString(carrot+"", slotXstart+gp.tileSize*2, slotYstart+41);
			}
			if( corn > 0) {
				g2.drawImage(icorn, slotXstart+12+gp.tileSize*3 , slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
				g2.drawString(corn+"", slotXstart+gp.tileSize*3, slotYstart+41);
			}
			// DRAW SEED AND FOOD
			if( SeedTomato > 0) {
				g2.drawImage(IseedTomato, slotXstart+12 , slotYstart+12+gp.tileSize, gp.tileSize/2, gp.tileSize/2, null);
				g2.drawString(SeedTomato+"", slotXstart, slotYstart+41+gp.tileSize);
			}
			if( SeedPotato > 0) {
				g2.drawImage(IseedPotato, slotXstart+12+gp.tileSize , slotYstart+12+gp.tileSize, gp.tileSize/2, gp.tileSize/2, null);
				g2.drawString(SeedPotato+"", slotXstart+gp.tileSize, slotYstart+41+gp.tileSize);
			}
			if( SeedCorn > 0) {
				g2.drawImage(IseedCorn, slotXstart+12+gp.tileSize*2 , slotYstart+12+gp.tileSize, gp.tileSize/2, gp.tileSize/2, null);
				g2.drawString(SeedCorn+"", slotXstart+gp.tileSize*2, slotYstart+41+gp.tileSize);
			}
			if( SeedCarrot > 0) {
				g2.drawImage(IseedCarrot, slotXstart+12+gp.tileSize*3 , slotYstart+12+gp.tileSize, gp.tileSize/2, gp.tileSize/2, null);
				g2.drawString(SeedCarrot+"", slotXstart+gp.tileSize*3, slotYstart+41+gp.tileSize);
			}
			if(FoodPig > 0) {
				g2.drawImage(IfoodPig, slotXstart+12 , slotYstart+12+gp.tileSize*2, gp.tileSize/2, gp.tileSize/2, null);
				g2.drawString(FoodPig+"", slotXstart, slotYstart+41+gp.tileSize*2);
			}
			if(FoodCow> 0){
				g2.drawImage(IfoodCow, slotXstart+12+gp.tileSize , slotYstart+12+gp.tileSize*2, gp.tileSize/2, gp.tileSize/2, null);
				g2.drawString(FoodCow+"", slotXstart+gp.tileSize, slotYstart+41+gp.tileSize*2);
			}
			if(FoodChicken > 0) {
				g2.drawImage(IfoodPig, slotXstart+12+gp.tileSize*2 , slotYstart+12+gp.tileSize*2, gp.tileSize/2, gp.tileSize/2, null);
				g2.drawString(FoodChicken+"", slotXstart+gp.tileSize*2, slotYstart+41+gp.tileSize*2);
			}
			
			// DRAW IF STRING
			g2.setStroke(new BasicStroke(3));
			g2.drawRoundRect(ifX+5, ifY+5, ifWidth-10, ifHeight-10, 20, 20);
			g2.drawImage(icoin, ifX+gp.tileSize, ifY+gp.tileSize, gp.tileSize/2, gp.tileSize/2, null);
			g2.drawString("= "+coin, ifX+gp.tileSize*2-16, ifY+gp.tileSize+18);
			if( checkEnter == true) {
				c = Color.yellow;
				g2.setColor(c);
				g2.drawRoundRect(cursorX, cursorY, CursorWidth, CursorHeight, 10, 10);
				if( slotCol == 0 && slotRow == 0&& tomato > 0) {
					g2.drawString("Ban muon ban 1 voi gia: "+Ptomato+" ko?", ifX+gp.tileSize, ifY+gp.tileSize/2);
				}
				if( slotCol == 1 && slotRow == 0 && potato > 0) {
					g2.drawString("Ban muon ban 1 voi gia: "+Ppotato+" ko?", ifX+gp.tileSize, ifY+gp.tileSize/2);
				}
				if( slotCol == 2 && slotRow == 0 && carrot > 0) {
					g2.drawString("Ban muon ban 1 voi gia: "+Pcarrot+" ko?", ifX+gp.tileSize, ifY+gp.tileSize/2);
				}
				if( slotCol == 3 && slotRow == 0 && corn > 0) {
					g2.drawString("Ban muon ban 1 voi gia: "+Pcorn+" ko?", ifX+gp.tileSize, ifY+gp.tileSize/2);
				}
				if( slotCol == 0 && slotRow == 1 && SeedTomato > 0) {
					g2.drawString("Hat giong ca chua", ifX+gp.tileSize, ifY+gp.tileSize/2);
				}
				if( slotCol == 1 && slotRow == 1 && SeedPotato > 0) {
					g2.drawString("Hat giong khoai tay", ifX+gp.tileSize, ifY+gp.tileSize/2);
				}
				if( slotCol == 2 && slotRow == 1 && SeedCorn > 0) {
					g2.drawString("Hat giong ngo", ifX+gp.tileSize, ifY+gp.tileSize/2);
				}
				if( slotCol == 3 && slotRow == 1 && SeedCarrot > 0) {
					g2.drawString("Hat giong ca rot", ifX+gp.tileSize, ifY+gp.tileSize/2);
				}
				if( slotCol == 0 && slotRow == 2 && FoodPig > 0) {
					g2.drawString("Thuc an cho heo", ifX+gp.tileSize, ifY+gp.tileSize/2);
				}
				if( slotCol == 1 && slotRow == 2 && FoodCow > 0) {
					g2.drawString("Thuc an cho bo", ifX+gp.tileSize, ifY+gp.tileSize/2);
				}
				if( slotCol == 2 && slotRow == 2 && FoodChicken > 0) {
					g2.drawString("Thuc an cho ga", ifX+gp.tileSize, ifY+gp.tileSize/2);
				}
			}
		}
}

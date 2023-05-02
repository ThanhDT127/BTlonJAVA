package Menu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class TrayMenu extends Menu {
	public int foodPig;
	public int foodCow;
	public int foodChicken;
	public BufferedImage pig, cow, chicken;
	public TrayMenu(GamePanel gp) {
		this.gp = gp;
		foodChicken = 1000;
		foodCow = 1000;
		foodPig = 1000;
		try {
			pig = ImageIO.read(getClass().getResourceAsStream("/itemmenu/foodpig.png"));
			cow = ImageIO.read(getClass().getResourceAsStream("/itemmenu/foodcow.png"));
			chicken = ImageIO.read(getClass().getResourceAsStream("/itemmenu/foodchicken.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) {
		// SET MENU
		MnX = gp.tileSize*5;
		MnY = gp.tileSize;
		width = gp.tileSize * 6;
		height = gp.tileSize *2;
		// SET SLOT
		slotXstart = MnX + 24;
		slotYstart = MnY + 24;
		
		// SET CURSOR
		cursorX = slotXstart + ( slotCol*gp.tileSize );
		cursorY = slotYstart + ( slotRow *gp.tileSize );
		CursorWidth = gp.tileSize;
		CursorHeight = gp.tileSize;
		
		// SET MENU IF
		ifX = gp.tileSize*5;
		ifY = gp.tileSize *3;
		ifWidth = gp.tileSize*6;
		ifHeight = gp.tileSize*2;
		c = new Color(0, 0, 0, 200);
		g2.setColor(c);
		g2.fillRoundRect(MnX, MnY, width, height, 35, 35);
		g2.fillRoundRect(ifX, ifY, ifWidth, ifHeight, 35, 35);
		c = Color.white;
		g2.setColor(c);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(MnX+5, MnY + 5, width-10, height-10, 25, 25);
		g2.drawRoundRect(ifX+5, ifY+5, ifWidth-10, ifHeight-10, 25, 25);
		// DRAW CURSOR
		g2.setStroke(new BasicStroke(2));
		g2.drawRoundRect(cursorX, cursorY, CursorWidth, CursorHeight, 10, 10);
		// DRAW INFORMATION
		g2.setColor(Color.yellow);
		g2.setFont(new Font("Arial", Font.BOLD, 12));
		if( foodPig > 0) {
//			gp.collisionChecker.checkEntity(null);
			g2.drawImage(pig, slotXstart, slotYstart, CursorWidth, CursorHeight, null);
			g2.drawString(foodPig+"", slotXstart, slotYstart+41);
		}
		if ( foodCow > 0) {
			g2.drawImage(cow, slotXstart+gp.tileSize, slotYstart, CursorWidth, CursorHeight, null);
			g2.drawString(foodCow+"", slotXstart+gp.tileSize, slotYstart+41);
		}
		if ( foodChicken > 0) {
			g2.drawImage(chicken, slotXstart+gp.tileSize*2, slotYstart, CursorWidth, CursorHeight, null);
			g2.drawString(foodChicken+"", slotXstart+gp.tileSize*2, slotYstart+41);
		}
		
		if( checkEnter == true) {
			c = Color.yellow;
			g2.setColor(c);
			g2.drawRoundRect(cursorX, cursorY, CursorWidth, CursorHeight, 10, 10);
			if( slotCol == 0 && gp.houseMenu.FoodPig >= 10000) {
				g2.drawString("Bo 10000 thuc an?", ifX+gp.tileSize, ifY+gp.tileSize);
			}
			else if( slotCol == 0 && gp.houseMenu.FoodPig < 10000 ) g2.drawString("Khong du 10000 thuc an??", ifX+gp.tileSize, ifY+gp.tileSize);
			if( slotCol == 1 && gp.houseMenu.FoodCow >= 10000) {
				g2.drawString("Bo 10000 thuc an?", ifX+gp.tileSize, ifY+gp.tileSize);
			}
			else if( slotCol == 1 && gp.houseMenu.FoodCow < 10000) g2.drawString("Khong du 10000 thuc an??", ifX+gp.tileSize, ifY+gp.tileSize);
			if( slotCol == 2  && gp.houseMenu.FoodChicken >= 10000 ) {
				g2.drawString("Bo 10000 thuc an?", ifX+gp.tileSize, ifY+gp.tileSize);
			}
			else if( slotCol == 2 && gp.houseMenu.FoodChicken < 10000) g2.drawString("Khong du 10000 thuc an??", ifX+gp.tileSize, ifY+gp.tileSize);
		}
	}
}

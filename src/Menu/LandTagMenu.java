package Menu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class LandTagMenu extends Menu{
	public BufferedImage tomato, potato, corn, carrot;
	public int checkTree = -1;
	public LandTagMenu(GamePanel gp) {
		this.gp = gp;
		try {
			tomato = ImageIO.read(getClass().getResourceAsStream("/itemmenu/seedtomato.png"));
			potato = ImageIO.read(getClass().getResourceAsStream("/itemmenu/seedpotato.png"));
			corn = ImageIO.read(getClass().getResourceAsStream("/itemmenu/seedcorn.png"));
			carrot = ImageIO.read(getClass().getResourceAsStream("/itemmenu/seedcarrot.png"));
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
		height = gp.tileSize*2;
		
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
		
		// DRAW MENU
		c = new Color(0, 0, 0, 200);
		g2.setColor(c);
		g2.fillRoundRect(MnX, MnY,width, height, 35, 35);
		c = Color.white;
		g2.setColor(c);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(MnX+5, MnY+5, width-10, height-10, 20, 20);
		// DRAW CURSOR
		g2.setStroke(new BasicStroke(2));
		g2.drawRoundRect(cursorX, cursorY, CursorWidth, CursorHeight, 10, 10);	
		if( gp.houseMenu.SeedTomato > 0) {
			g2.drawImage(tomato, slotXstart+12, slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
			g2.drawString(gp.houseMenu.SeedTomato+"", slotXstart+36, slotYstart+41);
		}
		if( gp.houseMenu.SeedPotato > 0) {
			g2.drawImage(potato, slotXstart+12+gp.tileSize, slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
			g2.drawString(gp.houseMenu.SeedPotato+"", slotXstart+36+gp.tileSize, slotYstart+41);
		}
		if( gp.houseMenu.SeedCorn > 0) {
			g2.drawImage(corn, slotXstart+12+(gp.tileSize*2), slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
			g2.drawString(gp.houseMenu.SeedCorn+"", slotXstart+36+(gp.tileSize*2), slotYstart+41);
		}
		if( gp.houseMenu.SeedCarrot > 0) {
			g2.drawImage(carrot, slotXstart+12+(gp.tileSize*3), slotYstart+12, gp.tileSize/2, gp.tileSize/2, null);
			g2.drawString(gp.houseMenu.SeedCarrot+"", slotXstart+36+(gp.tileSize*3), slotYstart+41);
		}
		if( checkEnter == true) {
			c = Color.yellow;
			g2.setColor(c);
			g2.drawRoundRect(cursorX, cursorY, CursorWidth, CursorHeight, 10, 10);
		}
	}
}

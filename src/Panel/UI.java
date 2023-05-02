package Panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UI {
	public GamePanel gp;
	public boolean checkUI = true;
	public int UIrow = 0;
	public BufferedImage image, button;
	public UI(GamePanel gp) {
		this.gp = gp;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/menu.png"));
			button = ImageIO.read(getClass().getResourceAsStream("/tiles/button.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		int cursorY = gp.tileSize*6-10+(UIrow*gp.tileSize);
		g2.setColor( new Color(43, 148, 53) );
		g2.drawImage(image, 0, 0, gp.screenWidth, gp.screenHeight, null);
		g2.setColor(new Color(0, 0, 0, 20));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		g2.setFont(new Font("Calibri", Font.BOLD, 32));
		g2.setColor(new Color(255, 255, 0 ));
		g2.drawString("MINI FARM", gp.tileSize*6+14, gp.tileSize*4+28);
		
		// DRAW CURSOR
		g2.drawImage(button,gp.tileSize*6+14, cursorY , gp.tileSize*3 , gp.tileSize, null);
		// DRAW STRING
		g2.setColor(new Color(64, 64, 64 ));
		g2.setFont(new Font("Calibri", Font.BOLD, 18));
		g2.drawString("NEW GAME", gp.tileSize*6+40, gp.tileSize*6+24);
		g2.drawString("CONTINUE", gp.tileSize*6+42, gp.tileSize*7+24);
		g2.drawString("SAVE GAME", gp.tileSize*6+36, gp.tileSize*8+24);
		g2.drawString("LOAD GAME", gp.tileSize*6+36, gp.tileSize*9+24);
		
	}
}

package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.crypto.BadPaddingException;
import javax.imageio.ImageIO;

import Panel.GamePanel;

public class house extends object{
	public house() {
		solidArea = new Rectangle(0,0, 48*4, 48*4);
		name = "house";
		collision = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/House/house.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2, GamePanel panel) {
		int screenX = worldX - panel.player.worldX + panel.player.screenX;
		int screenY = worldY - panel.player.worldY + panel.player.screenY;
		g2.drawImage(image, screenX, screenY, panel.tileSize*4,panel.tileSize*4,null);
	}
}

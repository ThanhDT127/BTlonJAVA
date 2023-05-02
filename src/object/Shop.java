package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.crypto.BadPaddingException;
import javax.imageio.ImageIO;

import Panel.GamePanel;

public class Shop extends object{
	public Shop() {
		solidArea = new Rectangle(0,0, 48*4, 48*4);
		name = "shop";
		collision = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/House/store.png"));
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
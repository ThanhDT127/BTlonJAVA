package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class fruit_tomato extends object{
	public fruit_tomato() {
		price = 40;
		solidArea= new Rectangle(0,0, 48,48);
		name = "tomato";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/fruit/tomato.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	public void draw(Graphics2D g2, GamePanel panel) {
		int screenX = worldX - panel.player.worldX + panel.player.screenX;
		int screenY = worldY - panel.player.worldY + panel.player.screenY;
		g2.drawImage(image, screenX+12, screenY+12, panel.tileSize/2, panel.tileSize/2, null);
	}
	
}

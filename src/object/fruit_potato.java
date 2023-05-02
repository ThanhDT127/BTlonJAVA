package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class fruit_potato extends object{
	public fruit_potato(){
		name= "potato";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/fruit/potato.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		solidArea = new Rectangle(0, 0, 48, 48);
		collision = true;
	}
	@Override
	public void draw(Graphics2D g2, GamePanel panel) {
		int screenX = worldX - panel.player.worldX + panel.player.screenX;
		int screenY = worldY - panel.player.worldY + panel.player.screenY;
		g2.drawImage(image, screenX+12, screenY+12, panel.tileSize/2, panel.tileSize/2, null);
	}
}

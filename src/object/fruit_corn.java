package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class fruit_corn extends object {
	public fruit_corn() {
		price = 30;
		solidArea = new Rectangle(0, 0, 48, 48);
		name = "corn";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/fruit/corn.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		collision = true;
	}
	@Override
	public void draw(Graphics2D g2, GamePanel panel) {
		int screenX = worldX - panel.player.worldX + panel.player.screenX;
		int screenY = worldY - panel.player.worldY + panel.player.screenY;
		g2.drawImage(image, screenX+12, screenY+12, panel.tileSize/2, panel.tileSize/2, null);
	}
}

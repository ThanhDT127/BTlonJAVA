package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class LandTag extends object {
	public LandTag() {
		name = "landtag";
		solidArea = new Rectangle(0, 0, 48, 48);
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/object/nametag.png"));
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
		if( worldX + panel.tileSize > panel.player.worldX - panel.player.screenX &&
			worldX - panel.tileSize< panel.player.worldX + panel.player.screenX &&
			worldY + panel.tileSize > panel.player.worldY - panel.player.screenY &&
			worldY - panel.tileSize< panel.player.worldY+ panel.player.screenY ) {
			g2.drawImage(image, screenX, screenY, panel.tileSize, panel.tileSize, null);
		}
	}
}

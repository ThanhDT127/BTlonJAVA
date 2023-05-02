package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class Tray extends object{
		public Tray() {
			name = "tray";
			solidArea = new Rectangle(0, 0, 96, 48);
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/pig/khay.png"));
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
			g2.drawImage(image, screenX, screenY, panel.tileSize*2, panel.tileSize, null);
		}
}

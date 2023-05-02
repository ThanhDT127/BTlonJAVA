package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class gate extends object {
	public BufferedImage closegate, opengate;
	public gate() {
		name = "gate";
		solidArea = new Rectangle(0, 0, 96, 48);
		try {
			closegate = ImageIO.read(getClass().getResourceAsStream("/house/closegate.png"));
			opengate = ImageIO.read(getClass().getResourceAsStream("/house/opengate.png"));
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
		if( panel.player.checkgate == false) {
			collision= true;
			g2.drawImage(closegate, screenX, screenY, panel.tileSize, panel.tileSize,null);
			g2.drawImage(closegate, screenX+panel.tileSize, screenY, panel.tileSize, panel.tileSize,null);
		}
		else{
			collision=false;
			g2.drawImage(opengate, screenX, screenY, panel.tileSize/4, panel.tileSize,null);
			g2.drawImage(opengate, screenX+panel.tileSize*2, screenY, panel.tileSize/4, panel.tileSize,null);
		}
	}
}

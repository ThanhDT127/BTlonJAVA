package object;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class Land extends object{
	public BufferedImage tomato[] , potato[], corn[], carrot[], watering1, watering2, image1, image2;
	public Land() {
		tomato = new BufferedImage[4];
		potato = new BufferedImage[4];
		corn = new BufferedImage[4];
		carrot = new BufferedImage[4];
		name = "land";
		solidArea = new Rectangle(18, 18, 10, 10);
		solidAreaDefaultX = 8;
		solidAreaDefaultY = 16;
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/tiles/land.jpg"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/tiles/key.png"));
			tomato[0] = ImageIO.read(getClass().getResourceAsStream("/tree/tomato1.png"));
			tomato[1] = ImageIO.read(getClass().getResourceAsStream("/tree/tomato2.png"));
			tomato[2] = ImageIO.read(getClass().getResourceAsStream("/tree/tomato3.png"));
			tomato[3] = ImageIO.read(getClass().getResourceAsStream("/tree/tomato4.png"));
			
			potato[0] = ImageIO.read(getClass().getResourceAsStream("/tree/potato1.png"));
			potato[1] = ImageIO.read(getClass().getResourceAsStream("/tree/potato2.png"));
			potato[2] = ImageIO.read(getClass().getResourceAsStream("/tree/potato3.png"));
			potato[3] = ImageIO.read(getClass().getResourceAsStream("/tree/potato4.png"));
			
			corn[0] = ImageIO.read(getClass().getResourceAsStream("/tree/corn1.png"));
			corn[1] = ImageIO.read(getClass().getResourceAsStream("/tree/corn2.png"));
			corn[2] = ImageIO.read(getClass().getResourceAsStream("/tree/corn3.png"));
			corn[3] = ImageIO.read(getClass().getResourceAsStream("/tree/corn4.png"));
			
			carrot[0] = ImageIO.read(getClass().getResourceAsStream("/tree/carrot1.png"));
			carrot[1] = ImageIO.read(getClass().getResourceAsStream("/tree/carrot2.png"));
			carrot[2] = ImageIO.read(getClass().getResourceAsStream("/tree/carrot3.png"));
			carrot[3] = ImageIO.read(getClass().getResourceAsStream("/tree/carrot4.png"));
			
			watering1 = ImageIO.read(getClass().getResourceAsStream("/tree/watering1.png"));
			watering2 = ImageIO.read(getClass().getResourceAsStream("/tree/watering2.png"));
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
			worldY - panel.tileSize< panel.player.worldY+ panel.player.screenY) {
			g2.drawImage(image1, screenX, screenY, panel.tileSize, panel.tileSize, null);
			// DRAW TOMATO TREE
			if( this.landKey == true) {
				g2.drawImage(image2, screenX, screenY, panel.tileSize, panel.tileSize, null);
			}
			else if( time1 > 0 ) {
					g2.drawImage(tomato[0], screenX, screenY, panel.tileSize, panel.tileSize, null);
					if( System.currentTimeMillis() - time1 > 60000*5 )
					g2.drawImage(tomato[1], screenX, screenY, panel.tileSize, panel.tileSize, null);
					if( System.currentTimeMillis() - time1 > 60000*4 )
					g2.drawImage(tomato[2], screenX, screenY, panel.tileSize, panel.tileSize, null);
					if( System.currentTimeMillis() - time1 > 90000*3 ) {
						g2.drawImage(tomato[3], screenX, screenY, panel.tileSize, panel.tileSize, null);
						collision = true;
						checkRipen = true;
					}
				
			}
			else if( time2 > 0 ) {
				g2.drawImage(potato[0], screenX, screenY, panel.tileSize, panel.tileSize, null);
				if( System.currentTimeMillis() - time2 > 60000/5 )
				g2.drawImage(potato[1], screenX, screenY, panel.tileSize, panel.tileSize, null);
				if( System.currentTimeMillis() - time2 > 60000/4 )
				g2.drawImage(potato[2], screenX, screenY, panel.tileSize, panel.tileSize, null);
				if( System.currentTimeMillis() - time2 > 90000/3 ) {
					g2.drawImage(potato[3], screenX, screenY, panel.tileSize, panel.tileSize, null);
					collision = true;
					checkRipen = true;
				}
				
			}
			else if( time3 > 0 ) {
				g2.drawImage(corn[0], screenX, screenY, panel.tileSize, panel.tileSize, null);
				if( System.currentTimeMillis() - time3 > 60000/5 )
				g2.drawImage(corn[1], screenX, screenY, panel.tileSize, panel.tileSize, null);
				if( System.currentTimeMillis() - time3 > 60000/4 )
				g2.drawImage(corn[2], screenX, screenY, panel.tileSize, panel.tileSize, null);
				if( System.currentTimeMillis() - time3 > 90000/3 ) {
					g2.drawImage(corn[3], screenX, screenY, panel.tileSize, panel.tileSize, null);
					collision = true;
					checkRipen = true;
				}
				
			}
			else if( time4 > 0) {
				g2.drawImage(carrot[0], screenX, screenY, panel.tileSize, panel.tileSize, null);
				if( System.currentTimeMillis() - time4 > 60000/5 )
				g2.drawImage(carrot[1], screenX, screenY, panel.tileSize, panel.tileSize, null);
				if( System.currentTimeMillis() - time4 > 60000/4 )
				g2.drawImage(carrot[2], screenX, screenY, panel.tileSize, panel.tileSize, null);
				if( System.currentTimeMillis() - time4 > 90000/3 ) {
					g2.drawImage(carrot[3], screenX, screenY, panel.tileSize, panel.tileSize, null);
					collision = true;
					checkRipen = true;
				}
			}
		}
	}
}

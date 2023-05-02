package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class butterfly extends entity{
	public int x;
	public GamePanel gp;
	public butterfly(GamePanel gp, int z) {
		this.gp = gp;
		name = "butterfly";
		direction = "up";
		this.speed = 1;
		solidArea = new Rectangle(12, 12, 24, 24);
		solidAreaDefaultX =12;
		solidAreaDefaultY =12;
		try {
			if(z == 1) {
				up1 = ImageIO.read(getClass().getResourceAsStream("/butterfly/butterfly1.png"));
				up2 = ImageIO.read(getClass().getResourceAsStream("/butterfly/butterfly2.png"));
				up3 = ImageIO.read(getClass().getResourceAsStream("/butterfly/butterfly3.png"));
				up4 = ImageIO.read(getClass().getResourceAsStream("/butterfly/butterfly4.png"));
			}
			else if( z ==2) {
				up1 = ImageIO.read(getClass().getResourceAsStream("/butterfly/butterfly5.png"));
				up2 = ImageIO.read(getClass().getResourceAsStream("/butterfly/butterfly6.png"));
				up3 = ImageIO.read(getClass().getResourceAsStream("/butterfly/butterfly7.png"));
				up4 = ImageIO.read(getClass().getResourceAsStream("/butterfly/butterfly8.png"));
			}
			else if( z ==3) {
				up1 = ImageIO.read(getClass().getResourceAsStream("/butterfly/butterfly9.png"));
				up2 = ImageIO.read(getClass().getResourceAsStream("/butterfly/butterfly10.png"));
				up3 = ImageIO.read(getClass().getResourceAsStream("/butterfly/butterfly11.png"));
				up4 = ImageIO.read(getClass().getResourceAsStream("/butterfly/butterfly12.png"));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void update() {
		collisionOn = false;
		setAction();
		gp.collisionChecker.checkTile(this);
		if( collisionOn == false) {
			switch(direction) {
			case "up":
				this.worldY -= this.speed;
				break;
			case "down":
				this.worldY += this.speed;
				break;
			case "left":
				this.worldX -= this.speed;
				break;
			case "right":
				this.worldX += this.speed;
				break;
			}
		}
		
		this.spriteCount++;
		if( spriteCount > 12) {
			if( this.spriteNum ==1) this.spriteNum=2;
			else if( this.spriteNum ==2 ) this.spriteNum=1;
			this.spriteCount=0;
		}
	}
	public void setAction() {
		x++;
		Random random = new Random();
		int i = random.nextInt(100);
		if( x == 100) {
			if( i <= 25) {
				direction = "up";
			}
			if( i > 25 && i <=50) {
				direction = "down";
			}
			if( i > 50 && i <=75) {
				direction = "right";
			}
			if( i > 75 && i <=100) {
				direction = "left";
			}
			x = 0;
		}
	}
	@Override
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if( spriteNum == 1) image = up1;
			else if( spriteNum ==2) image = up2;
			break;
		case "down":
			if( spriteNum ==1 ) image = up3;
			else if( spriteNum==2) image = up4;
			break;
		case "left":
			if( spriteNum ==1 ) image = up3;
			else if( spriteNum==2) image = up4;
			break;
		case "right":
			if( spriteNum ==1 ) image = up1;
			else if( spriteNum==2) image = up2;
			break;
		}
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		if( worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
				worldY + gp.tileSize < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		}
	}
}

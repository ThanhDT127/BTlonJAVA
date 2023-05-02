package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Panel.GamePanel;

public class cow extends entity {
	public int x;
	public GamePanel gp;
	public cow(GamePanel gp) {
		this.gp = gp;
		setDefaultValues();
		getImages();
	}
	public void setDefaultValues() {
		this.speed =1;
		this.direction = "down";
		name = "cow";
		solidArea = new Rectangle(12, 12, 72, 72);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}
	public void getImages() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/cow/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/cow/up2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/cow/up3.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/cow/up4.png"));
			
			down1 = ImageIO.read(getClass().getResourceAsStream("/cow/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/cow/down2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/cow/down3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/cow/down4.png"));
			
			right1 = ImageIO.read(getClass().getResourceAsStream("/cow/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/cow/right2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/cow/right3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/cow/right4.png"));
			
			left1 = ImageIO.read(getClass().getResourceAsStream("/cow/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/cow/left2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/cow/left3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/cow/left4.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update() {
		collisionOn = false;
		setAction();
		gp.collisionChecker.checkTile(this);
		gp.collisionChecker.checkObject(this);
		if( collisionOn == false) {
			switch(direction) {
			case "up":
				worldY -= speed;
				break;
			case "down":
				worldY += speed;
				break;
			case "left":
				worldX -= speed;
				break;
			case "right":
				worldX += speed;
				break;
			}		
		}
		
		spriteCount++;
		if( spriteCount > 12) {
			if( spriteNum ==1) spriteNum=2;
			else if( spriteNum == 2) spriteNum=3;
			else if ( spriteNum==3) spriteNum=4;
			else if( spriteNum==4) spriteNum=1;
			spriteCount=0;
		}
	}
	public void setAction() {
		x++;
		Random random = new Random();
		int i= random.nextInt(100);
		if( x == 120) {
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
			case "up":{
				if( this.spriteNum == 1)
				image = up1;
				if( this.spriteNum == 2)
				image = up2;
				if( this.spriteNum == 3)
				image = up3;
				if( this.spriteNum == 4)
				image = up4;
				break;
			}
			case "down":{
				if(this.spriteNum==1)
				image = down1;
				if(this.spriteNum==2)
				image = down2;
				if(this.spriteNum==3)
				image = down3;
				if(this.spriteNum==4)
				image = down4;
				break;
			}
			case "left":{
				if(this.spriteNum ==1)
				image = left1;
				if(this.spriteNum ==2)
				image = left2;
				if(this.spriteNum ==3)
				image = left3;
				if(this.spriteNum ==4)
				image = left4;
				break;
			}
			case "right":{
				if(this.spriteNum ==1)
				image = right1;
				if(this.spriteNum ==2)
				image = right2;
				if(this.spriteNum ==3)
				image = right3;
				if(this.spriteNum ==4)
				image = right4;
				break;
			}
		}
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		if( worldX + gp.tileSize*3 > gp.player.worldX - gp.player.screenX &&
			worldX - gp.tileSize*3 < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize*3 > gp.player.worldY - gp.player.screenY &&
			worldY + gp.tileSize*3 < gp.player.worldY + gp.player.screenY) {
			g2.drawImage(image, screenX, screenY, gp.tileSize*3,gp.tileSize*3,null);
		}
	}
}

package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Key_Handler.keyHandler;
import Menu.TrayMenu;
import Panel.GamePanel;

public class pig extends entity {
	public int x;
	public GamePanel gp;
	public pig(GamePanel panel) {
		this.gp = panel;
		setDefaultValues();
		getImages();
	}
	public void setDefaultValues() {
		name = "pig";
		this.speed = 1;
		this.direction = "up";
		this.solidArea = new Rectangle(36 ,36, 24, 24);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}
	public void getImages() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/pig/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/pig/up2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/pig/up3.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/pig/up4.png"));
			
			down1 = ImageIO.read(getClass().getResourceAsStream("/pig/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/pig/down2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/pig/down3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/pig/down4.png"));
			
			right1 = ImageIO.read(getClass().getResourceAsStream("/pig/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/pig/right2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/pig/right3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/pig/right4.png"));
			
			left1 = ImageIO.read(getClass().getResourceAsStream("/pig/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/pig/left2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/pig/left3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/pig/left4.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update() {
		collisionOn = false;
		setAction();
		gp.collisionChecker.checkTile(this);
		int objIndex = gp.collisionChecker.checkObject(this);
		checkTray(objIndex);
		if( collisionOn == false) {
			switch( direction) {
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
			else if( this.spriteNum ==2 ) this.spriteNum=3;
			else if( this.spriteNum==3 ) this.spriteNum =4;
			else if( this.spriteNum==4 ) this.spriteNum =1;
			this.spriteCount =0;
		}
	}
	// CHECK TRAY
	public void checkTray(int i) {
		if( i != 999) {
			if( gp.object[i].name == "tray" && gp.object[i].collision == true) {
				if( food < 1000 && gp.trayMenu.foodPig > 0) {
					food++;
					gp.trayMenu.foodPig--;
				}
				System.out.println(food+" "+ gp.trayMenu.foodPig);
			}
		}
	}
	
	public void setAction() {
		x++;
		Random random = new Random();
		int i = random.nextInt(100);
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
			if( food < 10000) {
				g2.drawImage(image, screenX, screenY, gp.tileSize*2,gp.tileSize*2,null);
			}
			else {
				g2.drawImage(image, screenX, screenY, gp.tileSize*3,gp.tileSize*3,null);
				solidArea.x = 12;
				solidArea.y = 12;
				solidArea.width = 60;
				solidArea.height = 60;
			}
		}
	}
}

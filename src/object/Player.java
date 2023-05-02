package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Key_Handler.keyHandler;
import Panel.GamePanel;

public class Player extends entity{
	public int spriteCount;
	public int spriteNum;
	public GamePanel gp;
	public keyHandler keyh;
	public int screenX, screenY;
	public boolean checkgate = false;
	
	public Player(GamePanel gp, keyHandler keyh) {
		this.gp = gp;
		this.keyh = keyh;
		this.solidArea = new Rectangle(8, 16, 32, 32);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		this.setDefaultValues();
		this.getPlayerImages();
	}
	
	public void setDefaultValues() {
		this.spriteCount = 0;
		this.spriteNum =1;
		this.screenX = gp.screenWidth/2 - (gp.tileSize/2);
		this.screenY = gp.screenHeight/2 - (gp.tileSize/2);
		this.worldX = gp.tileSize*24;
		this.worldY = gp.tileSize*17;
		this.speed = 4;
		this.direction = "up";
	}
	public void getPlayerImages() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/person/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/person/up2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/person/up3.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/person/up4.png"));
			
			down1 = ImageIO.read(getClass().getResourceAsStream("/person/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/person/down2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/person/down3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/person/down4.png"));
			
			right1 = ImageIO.read(getClass().getResourceAsStream("/person/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/person/right2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/person/right3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/person/right4.png"));
			
			left1 = ImageIO.read(getClass().getResourceAsStream("/person/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/person/left2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/person/left3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/person/left4.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(this.keyh.up == true || this.keyh.down ==true|| 
				this.keyh.left == true|| this.keyh.right == true) {
			if( this.keyh.up) {
				direction = "up";
			}
			if( this.keyh.down) {
				direction = "down";		
			}	 
			if( this.keyh.left) {
				direction = "left";		
			}
			if( this.keyh.right) {
				direction = "right";	
			}
			
			collisionOn = false;
			gp.collisionChecker.checkTile(this);
			int objIndex = gp.collisionChecker.checkObject(this);
			gp.collisionChecker.checkEntity(this);
			Menu(objIndex);
			setTree(objIndex);
			getTree(objIndex);
			
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
				this.spriteCount = 0;
				}
			}
			
	}
	// TRONG CAY
	public void setTree(int i) {
		if( i != 999) {
			if( gp.object[i].name == "land" && gp.object[i].collision == true && gp.object[i].checkRipen == false  && gp.object[i].landKey == false) {
					if( gp.landTagMenu.checkTree == 0 && gp.houseMenu.SeedTomato > 0) {
					gp.houseMenu.SeedTomato--;
					gp.object[i].time1 = System.currentTimeMillis();
					gp.object[i].collision = false;
					gp.object[i].checkTree = 0;
					
					}
					if( gp.landTagMenu.checkTree == 1 && gp.houseMenu.SeedPotato > 0) {
						gp.houseMenu.SeedPotato--;
						gp.object[i].time2 = System.currentTimeMillis();
						gp.object[i].collision = false;
						gp.object[i].checkTree =1;
						
					}
					if( gp.landTagMenu.checkTree == 2 && gp.houseMenu.SeedCorn > 0 ) {
						gp.houseMenu.SeedCorn--;
						gp.object[i].time3 = System.currentTimeMillis();
						gp.object[i].collision = false;
						gp.object[i].checkTree =2;
						
					}
					if( gp.landTagMenu.checkTree == 3 && gp.houseMenu.SeedCarrot > 0  ) {
						gp.houseMenu.SeedCarrot--;
						gp.object[i].time4 = System.currentTimeMillis();
						gp.object[i].collision = false;
						gp.object[i].checkTree =3;
						
					}
			}
		}
	}
	
	// THU HOACH
	public void getTree(int i) {
		if( i != 999) {
			if( gp.object[i].name == "land" && gp.object[i].collision == true ) {
				if( gp.object[i].checkTree == 0 && gp.object[i].checkRipen == true ) {
					gp.houseMenu.tomato++;
					gp.object[i].time1 = 0;
					gp.object[i].checkRipen = false;
				}
				else if( gp.object[i].checkTree == 1 && gp.object[i].checkRipen == true ) {
					gp.houseMenu.potato++;
					gp.object[i].time2 = 0;
					gp.object[i].checkRipen = false;
				}
				else if( gp.object[i].checkTree == 2 && gp.object[i].checkRipen == true ) {
					gp.houseMenu.corn++;
					gp.object[i].time3 = 0;
					gp.object[i].checkRipen = false;
				}
				else if( gp.object[i].checkTree == 3 && gp.object[i].checkRipen == true ) {
					gp.houseMenu.carrot++;
					gp.object[i].time4 = 0;
					gp.object[i].checkRipen = false;
				}
			}
		}
	}
	// HIEN MENU
	public void Menu(int i) {
		if( i != 999 && gp.object[i] != null) {
			if( gp.object[i].name == "house" && gp.object[i].collision == true) {
				gp.houseMenu.check = true;
			}
			if( gp.object[i].name == "tray" && gp.object[i].collision == true) {
				gp.trayMenu.check = true;
			}
			if( gp.object[i].name == "landtag" && gp.object[i].collision == true) {
				gp.landTagMenu.check = true;
			}
			if( gp.object[i].name =="gate" && gp.object[i].collision == true) {
				checkgate = true;
			}
			if( gp.object[i].name =="shop" && gp.object[i].collision == true) {
				gp.shopMenu.check = true;
			}
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
		g2.setColor(Color.yellow);
		g2.setFont(new Font("arial", Font.BOLD, 18));
		g2.drawString(gp.houseMenu.coin+"", gp.tileSize, gp.tileSize);
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}

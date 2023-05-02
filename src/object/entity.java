package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Menu.TrayMenu;
import Panel.GamePanel;

public class entity {
	public int food=0;
	public long time1, time2, time3;
	public int worldX, worldY;	
	public int speed;
	public BufferedImage up1, up2, up3, up4 , down1,down2, down3, down4,  right1, right2, right3, right4, left1, left2, left3, left4;
	public String direction;
	public int spriteCount=0;
	public int spriteNum=1;
	public boolean collisionOn = false;
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public String name;
	public boolean check = false;
	public void draw(Graphics2D g2) {
		
	}
	public void update() {
		
	}
}

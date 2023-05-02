package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Panel.GamePanel;

public class object {
	public int price;
	public boolean landKey = false;
	public BufferedImage image;
	public String name;
	public int worldX, worldY;
	public boolean collision = false;
	public Rectangle solidArea;
	public int solidAreaDefaultX=0, solidAreaDefaultY=0;
	public long time1=0, time2=0, time3=0, time4=0;
	public boolean checkRipen = false;
	public int checkTree = -1;
	public void draw(Graphics2D g2, GamePanel panel) {
		
	}
}

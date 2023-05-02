package Menu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import Panel.GamePanel;

public class AnimalMenu extends Menu {
	public int pig, cow, chicken;
	public AnimalMenu(GamePanel gp) {
		this.gp = gp;
		pig = 1200;
		cow = 4000;
		chicken = 500;
	}
	public void draw(Graphics2D g2) {
		// SET MENU
		MnX = gp.tileSize*6;
		MnY = gp.tileSize;
		width = gp.tileSize*4;
		height = gp.tileSize;
		c = new Color(0,0, 0, 200);
		g2.setColor(c);
		g2.fillRoundRect(MnX, MnY, width, height, 35, 35);
		c = Color.white;
		g2.setColor(c);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(MnX+5, MnY+5, width-10, height-10, 25, 25);
		c = Color.yellow;
		g2.setColor(c);
		for( int i=0; i<gp.entity.length; i++) {
			if( gp.entity[i] != null) {
				if( gp.entity[i].name == "pig" && gp.entity[i].check == true) {
					if(gp.entity[i].food >= 10000) g2.drawString("Ban muon ban 1 voi gia "+pig+" ko?", MnX+15, MnY+24);
					else g2.drawString("Chua du lon de ban!", MnX+15, MnY+24);
				}
				
				else if( gp.entity[i].name == "cow" && gp.entity[i].check == true) 
					g2.drawString("Ban muon ban 1 voi gia "+cow+" ko?", MnX+15, MnY+24);
				else if( gp.entity[i].name == "chicken" && gp.entity[i].check == true) 
					g2.drawString("Ban muon ban 1 voi gia "+chicken+" ko?", MnX+15, MnY+24);
			}
		}
	}
}

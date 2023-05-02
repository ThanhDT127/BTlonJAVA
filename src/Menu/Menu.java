package Menu;

import java.awt.Color;
import java.awt.image.BufferedImage;

import Panel.GamePanel;

public class Menu {
	public boolean check = false;
	public Color c;
	public GamePanel gp;
	public int MnX, MnY, width, height;
	public int slotRow=0, slotCol=0;
	public int cursorX, cursorY, CursorWidth, CursorHeight;
	public int slotXstart, slotYstart;
	public int ifX, ifY, ifWidth, ifHeight;
	public boolean checkEnter = false;
	public BufferedImage IseedTomato,IseedPotato,IseedCorn,IseedCarrot;
	public BufferedImage IPig, ICow,IChicken;
	public BufferedImage IfoodPig,IfoodCow,IfoodChicken;
	public int SeedTomato,SeedPotato,SeedCorn,SeedCarrot;
	public int FoodPig,FoodCow,FoodChicken;
}

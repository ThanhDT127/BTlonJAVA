package Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Key_Handler.keyHandler;
import Menu.AnimalMenu;
import Menu.HouseMenu;
import Menu.LandTagMenu;
import Menu.ShopMenu;
import Menu.TrayMenu;
import database.JDBCUtil;
import map.tileManager;
import object.Player;
import object.entity;
import object.object;

public class GamePanel extends JPanel implements Runnable{
	public Sound sound = new Sound();
	// SCREEN SETTING
	public int tileSize = 48;
	public final int maxSizeCol = 16;
	public final int maxSizeRow = 12;
	public final int screenWidth = tileSize * maxSizeCol;
	public final int screenHeight = tileSize * maxSizeRow;
	
	// WORLD SETTING
	public final int maxWorldCol = 54;
	public final int maxWorldRow = 28;
	
	public UI ui = new UI(this);
	public Thread thread;
	public keyHandler keyHandler = new keyHandler(this);
	public collisionChecker collisionChecker = new collisionChecker(this);
	public AssetSetter assetSetter = new AssetSetter(this);
	
	// SET OBJECT
	public Player player;
	public tileManager tileManager;
	public object object[];
	public entity entity[];
	public int pigQuantity = 0, cowQuantity= 0, chickenQuantity=0;
	
	// MENU
	public HouseMenu houseMenu;
	public AnimalMenu animalMenu;
	public TrayMenu trayMenu;
	public LandTagMenu landTagMenu;
	public ShopMenu shopMenu;
	
	// FPS
	public int FPS = 60;
	
	// DATABASE
	public JDBCUtil jdbcUtil;
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); 
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);	
	}
	public void setupGame() {
		
		// SET OBJECT
		player = new Player(this, keyHandler);
		tileManager = new tileManager(this);
		object = new object[100];
		entity = new entity[20];
		pigQuantity = 0;
		cowQuantity=0;
		chickenQuantity=0;
		
		//SET MENU
		houseMenu = new HouseMenu(this);
		animalMenu = new AnimalMenu(this);;
		trayMenu = new TrayMenu(this);
		landTagMenu = new LandTagMenu(this);
		shopMenu = new ShopMenu(this);
		
		jdbcUtil = new JDBCUtil(this);
		
		assetSetter.setObject();
		assetSetter.setEntity();
	}
	public void startThread() {
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while( thread != null) {
			
			this.update();
			
			this.repaint();

			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/ 1000000;
				
				if( remainingTime < 0) {
					remainingTime =0;
				}
				thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void update() {
		player.update();
		for( int i=0; i< entity.length; i++) {
			if( entity[i] != null) entity[i].update();
		}
	}
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		if( ui.checkUI == false) {
			tileManager.draw(g2); 
			for( int i=0; i< object.length; i++){
				if( object[i] != null) {
					object[i].draw(g2, this);
				}	
			}
			for( int i=0; i< entity.length; i++) {
				if( entity[i] != null) {
					entity[i].draw(g2);
				}
			}
			if( houseMenu.check== true) {
				houseMenu.draw(g2);
			}
			if( animalMenu.check == true ) {
				animalMenu.draw(g2);
			}
			if( trayMenu.check == true ) {
				trayMenu.draw(g2);
			}
			if( landTagMenu.check == true) {
				landTagMenu.draw(g2);
			}
			if( shopMenu.check == true ) {
				shopMenu.draw(g2);
			}
			player.draw(g2);
		}
		
		// MENU GAME
		else
		ui.draw(g2);
		g2.dispose();
	}
}

package map;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Panel.GamePanel;


public class tileManager {
	public GamePanel gpTile;
	public tiles[] tiles;
	public int map[][];
	static String line;
	
	public tileManager(GamePanel gpTile) {	
		this.gpTile = gpTile;
		tiles = new tiles[50];
		getTileImage();
		map = new int[gpTile.maxWorldRow][gpTile.maxWorldCol];
		this.loadMap();	
	}
	public void loadMap() {
				InputStream is = getClass().getResourceAsStream("/map_tile/map.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				for( int i=0; i< gpTile.maxWorldRow; i++){
					try {
						line = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				for( int j=0; j< gpTile.maxWorldCol; j++){
						String numbers[] = line.split("\t");
						int num = Integer.parseInt(numbers[j]);
						map[i][j] = num;
					}
				}
	}
	public void getTileImage() {
		try {
			tiles[0] = new tiles();
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			tiles[1] = new tiles();
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road.jpg"));
			tiles[2] = new tiles();
			tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tiles[3] = new tiles();
			tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/land_cow.png"));
			tiles[4] = new tiles();
			tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/fence_r.png"));
			tiles[4].collision = true;
			tiles[5] = new tiles();
			tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/fence_h.png"));
			tiles[5].collision = true;
			tiles[6] = new tiles();
			tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/fence_v.png"));
			tiles[6].collision = true;
			tiles[7] = new tiles();
			tiles[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_1.png"));
			tiles[7].collision = true;
			tiles[8] = new tiles();
			tiles[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_2.png"));
			tiles[8].collision = true;
			tiles[9] = new tiles();
			tiles[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_3.png"));
			tiles[9].collision = true;
			tiles[10] = new tiles();
			tiles[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_4.png"));
			tiles[10].collision = true;
			tiles[11] = new tiles();
			tiles[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_5.png"));
			tiles[11].collision = true;
			tiles[12] = new tiles();
			tiles[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_6.png"));
			tiles[12].collision = true;
			tiles[13] = new tiles();
			tiles[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_7.png"));
			tiles[13].collision = true;
			tiles[14] = new tiles();
			tiles[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_8.png"));
			tiles[14].collision = true;
			tiles[15] = new tiles();
			tiles[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/land_chicken.png"));
			tiles[16] = new tiles();
			tiles[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/land_pig.png"));
			tiles[17] = new tiles();
			tiles[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/land_1.jpg"));
			tiles[18] = new tiles();
			tiles[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/land_2.jpg"));
			tiles[19] = new tiles();
			tiles[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/land_3.jpg"));
			tiles[20] = new tiles();
			tiles[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/land_4.jpg"));
			tiles[21] = new tiles();
			tiles[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/land_5.jpg"));
			tiles[22] = new tiles();
			tiles[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/land_6.jpg"));
			tiles[23] = new tiles();
			tiles[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/land_7.jpg"));
			tiles[24] = new tiles();
			tiles[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/land_8.jpg"));
			tiles[25] = new tiles();
			tiles[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/land.jpg"));
			tiles[26] = new tiles();
			tiles[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/door_1.png"));
			tiles[27] = new tiles();
			tiles[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/door_2.png"));
			tiles[30] = new tiles();
			tiles[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw( Graphics2D g2) {
			for( int i=0; i< gpTile.maxWorldRow; i++)
			for( int j=0; j< gpTile.maxWorldCol; j++) {
			int worldX = j*gpTile.tileSize;
			int worldY = i*gpTile.tileSize;
			int screenX = worldX - gpTile.player.worldX + gpTile.player.screenX;
			int screenY = worldY - gpTile.player.worldY + gpTile.player.screenY;
			if( worldX + gpTile.tileSize > gpTile.player.worldX - gpTile.player.screenX &&
				worldX - gpTile.tileSize< gpTile.player.worldX + gpTile.player.screenX &&
				worldY + gpTile.tileSize > gpTile.player.worldY - gpTile.player.screenY &&
				worldY - gpTile.tileSize< gpTile.player.worldY+ gpTile.player.screenY ) {
				if( map[i][j] == 0)
					g2.drawImage(tiles[0].image, screenX, screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 1)			
					g2.drawImage(tiles[1].image, screenX, screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 2)	
					g2.drawImage(tiles[2].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 3)	
					g2.drawImage(tiles[3].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 4) {
					g2.drawImage(tiles[0].image, screenX, screenY, gpTile.tileSize, gpTile.tileSize, null);
					g2.drawImage(tiles[4].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				}
				if( map[i][j] == 5)	{
					g2.drawImage(tiles[0].image, screenX, screenY, gpTile.tileSize, gpTile.tileSize, null);
					g2.drawImage(tiles[5].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				}
				if( map[i][j] == 6)	{
					g2.drawImage(tiles[0].image, screenX, screenY, gpTile.tileSize, gpTile.tileSize, null);
					g2.drawImage(tiles[6].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				}
					
				if( map[i][j] == 7)	
					g2.drawImage(tiles[7].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 8)	
					g2.drawImage(tiles[8].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 9)	
					g2.drawImage(tiles[9].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 10)	
					g2.drawImage(tiles[10].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 11)	
					g2.drawImage(tiles[11].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 12)	
					g2.drawImage(tiles[12].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 13)	
					g2.drawImage(tiles[13].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 14)	
					g2.drawImage(tiles[14].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 15)	
					g2.drawImage(tiles[15].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 16)	
					g2.drawImage(tiles[16].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 17)	
					g2.drawImage(tiles[17].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 18)	
					g2.drawImage(tiles[18].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 19)	
					g2.drawImage(tiles[19].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 20)	
					g2.drawImage(tiles[20].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 21)	
					g2.drawImage(tiles[21].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 22)	
					g2.drawImage(tiles[22].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 23)	
					g2.drawImage(tiles[23].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 24)	
					g2.drawImage(tiles[24].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
//				if( map[i][j] == 25)	
//					g2.drawImage(tiles[25].image,screenX ,screenY, gpTile.tileSize, gpTile.tileSize, null);
				if( map[i][j] == 30) {
					g2.drawImage(tiles[0].image, screenX, screenY, gpTile.tileSize, gpTile.tileSize, null);
					g2.drawImage(tiles[30].image,screenX +12 ,screenY+12, gpTile.tileSize/2, gpTile.tileSize/2, null);
				}
			}			
		}
	}
}
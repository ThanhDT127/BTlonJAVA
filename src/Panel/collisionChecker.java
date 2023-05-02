package Panel;

import object.Player;
import object.entity;

public class collisionChecker {
	public GamePanel gp;
	public Player player;
	public collisionChecker(GamePanel panel) {
		this.gp = panel;
	}
	public void checkTile(entity player) {
		int playerLeftWorldX = player.worldX + player.solidArea.x;
		int playerRightWorldX = player.worldX + player.solidArea.x + player.solidArea.width;
		int playerTopWorldY = player.worldY + player.solidArea.y;
		int playerBottomWorldY = player.worldY + player.solidArea.y + player.solidArea.height;
		
		int playerLeftCol = playerLeftWorldX/gp.tileSize;
		int playerRightCol = playerRightWorldX/ gp.tileSize;
		int playerTopRow = playerTopWorldY / gp.tileSize;
		int playerBottomRow = playerBottomWorldY / gp.tileSize;
		
		
		int tileNum1, tileNum2;
		switch(player.direction) {
		case "up":
			playerTopRow = (playerTopWorldY - player.speed)/gp.tileSize;
			tileNum1 = gp.tileManager.map[playerTopRow][playerLeftCol];
			tileNum2 = gp.tileManager.map[playerTopRow][playerRightCol];
			if( gp.tileManager.tiles[tileNum1].collision == true || gp.tileManager.tiles[tileNum2].collision == true ) {
				player.collisionOn = true;
			}
			break;
		case "right":
			playerRightCol = (playerRightWorldX  + player.speed)/gp.tileSize;
			tileNum1 = gp.tileManager.map[playerTopRow][playerRightCol];
			tileNum2 = gp.tileManager.map[playerBottomRow][playerRightCol];
			if( gp.tileManager.tiles[tileNum1].collision == true ||  gp.tileManager.tiles[tileNum2].collision == true) {
				player.collisionOn = true;
			}
			break;
		case "down":
			playerBottomRow = (playerBottomWorldY  + player.speed)/gp.tileSize;
			tileNum1 = gp.tileManager.map[playerBottomRow][playerLeftCol];
			tileNum2 = gp.tileManager.map[playerBottomRow][playerRightCol];
			if( gp.tileManager.tiles[tileNum1].collision == true ||  gp.tileManager.tiles[tileNum2].collision == true) {
				player.collisionOn = true;
			}
			break;
		case "left":
			playerLeftCol = (playerLeftWorldX  + player.speed)/gp.tileSize;
			tileNum1 = gp.tileManager.map[playerTopRow][playerLeftCol];
			tileNum2 = gp.tileManager.map[playerBottomRow][playerLeftCol];
			if( gp.tileManager.tiles[tileNum1].collision == true ||  gp.tileManager.tiles[tileNum2].collision == true) {
				player.collisionOn = true;
			}
			break;
		}		
	}
	public int checkObject(entity player) {
		int index = 999;
		for( int i=0; i< gp.object.length; i++) {
			if( gp.object[i] != null) {
				player.solidArea.x = player.worldX + player.solidArea.x;
				player.solidArea.y = player.worldY + player.solidArea.y;
				gp.object[i].solidArea.x = gp.object[i].worldX + gp.object[i].solidArea.x;
				gp.object[i].solidArea.y = gp.object[i].worldY + gp.object[i].solidArea.y;
				switch( player.direction) {
				case "up":
					player.solidArea.y -= player.speed;
					if( player.solidArea.intersects( gp.object[i].solidArea)) {
						if( gp.object[i].collision == true ) {
							player.collisionOn = true;
							index = i;
						}
					}
					
					break;
				case "down":
					player.solidArea.y += player.speed;
					if( player.solidArea.intersects( gp.object[i].solidArea)) {
						if( gp.object[i].collision == true) {
							player.collisionOn = true;
							index = i;
						}
					}
					break;
				case "left":
					player.solidArea.x -= player.speed;
					if( player.solidArea.intersects( gp.object[i].solidArea)) {
						if( gp.object[i].collision == true) {
							player.collisionOn = true;
							index = i;
						}
					}
					break;
				case "right":
					player.solidArea.x += player.speed;
					if( player.solidArea.intersects( gp.object[i].solidArea)) {
						if( gp.object[i].collision == true) {
							player.collisionOn = true;
							index = i;
						}
					}
					break;
				}
			player.solidArea.x = player.solidAreaDefaultX;
			player.solidArea.y = player.solidAreaDefaultY;
			gp.object[i].solidArea.x = gp.object[i].solidAreaDefaultX;
			gp.object[i].solidArea.y = gp.object[i].solidAreaDefaultY;
			}	
		}
		return index;
	}
	public void checkEntity(Player player) {
		for( int i=0; i< 9; i++ ) {
			if( gp.entity[i] != null) {
				player.solidArea.x = player.worldX + player.solidArea.x;
				player.solidArea.y = player.worldY + player.solidArea.y;
				gp.entity[i].solidArea.x = gp.entity[i].worldX + gp.entity[i].solidArea.x;
				gp.entity[i].solidArea.y = gp.entity[i].worldY + gp.entity[i].solidArea.y;
				switch( player.direction) {
				case "up":
					player.solidArea.y -= player.speed;
					if( player.solidArea.intersects( gp.entity[i].solidArea)) {
						player.collisionOn = true;
						gp.entity[i].check = true;
						gp.animalMenu.check = true;
					}
					else gp.entity[i].check = false;
					break;
				case "down":
					player.solidArea.y += player.speed;
					if( player.solidArea.intersects( gp.entity[i].solidArea)) {
						player.collisionOn = true;
						gp.entity[i].check = true;
						gp.animalMenu.check = true;
					}
					else gp.entity[i].check = false;
					break;
				case "left":
					player.solidArea.x -= player.speed;
					if( player.solidArea.intersects( gp.entity[i].solidArea)) {
						player.collisionOn = true;
						gp.entity[i].check = true;
						gp.animalMenu.check = true;
					}
					else gp.entity[i].check = false;
					break;
				case "right":
					player.solidArea.x += player.speed;
					if( player.solidArea.intersects( gp.entity[i].solidArea)) {
						player.collisionOn = true;
						gp.entity[i].check = true;
						gp.animalMenu.check = true;
					}
					else gp.entity[i].check = false;
					break;
				}
				player.solidArea.x = player.solidAreaDefaultX;
				player.solidArea.y = player.solidAreaDefaultY;
				gp.entity[i].solidArea.x = gp.entity[i].solidAreaDefaultX;
				gp.entity[i].solidArea.y = gp.entity[i].solidAreaDefaultY;
			}	
		}
	}
}

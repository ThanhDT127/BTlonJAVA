package Panel;

import Menu.ShopMenu;
import object.Land;
import object.LandTag;
import object.Shop;
import object.Tray;
import object.butterfly;
import object.chicken;
import object.cow;
import object.fruit_tomato;
import object.gate;
import object.house;
import object.pig;

public class AssetSetter {
	public GamePanel gp;
	public AssetSetter(GamePanel panel) {
		gp = panel;
	}
	public void setObject() {
//		int j = 0;
//		for( int i=0; i<16; i++) {
//			if( j ==4 ) j =0;
//			if( i>= 0 && i<4) {
//					gp.object[i] = new fruit_tomato();
//					gp.object[i].worldX = (24+j)*gp.tileSize;
//					gp.object[i].worldY = 9*gp.tileSize;
//			}
//			if( i >= 4 && i<8) {
//					gp.object[i] = new fruit_potato();
//					gp.object[i].worldX = (24+j)*gp.tileSize;
//					gp.object[i].worldY = 10*gp.tileSize;
//				
//			}
//			if( i>=8 && i<12) {
//					gp.object[i] = new fruit_corn();
//					gp.object[i].worldX = (24+j)*gp.tileSize;
//					gp.object[i].worldY = 11*gp.tileSize;
//
//			}
//			if( i>=12 && i<16) {
//					gp.object[i] = new fruit_carrot();
//					gp.object[i].worldX = (24+j)*gp.tileSize;
//					gp.object[i].worldY = 12*gp.tileSize;
//			}
//			j++;
//		}

		
		// SET LAND
		int z = 0;		
		for( int i=0; i<7; i++) 
		for( int j=0; j<4; j++) {
			if( z < 28) {
				gp.object[z] = new Land();
				gp.object[z].worldX = gp.tileSize*(24+j);
				gp.object[z].worldY = gp.tileSize*(9+i);
				if( z < 24) {
					gp.object[z].landKey = true;
				}
				z++;
			}
		}
		gp.object[28] = new LandTag();
		gp.object[28].worldX = gp.tileSize*24;
		gp.object[28].worldY = gp.tileSize*16;
		
		gp.object[29] = new gate();
		gp.object[29].worldX = gp.tileSize*9;
		gp.object[29].worldY = gp.tileSize*14;
		
		gp.object[31] = new gate();
		gp.object[31].worldX = gp.tileSize*19;
		gp.object[31].worldY = gp.tileSize*14;

		gp.object[33] = new gate();
		gp.object[33].worldX = gp.tileSize*31;
		gp.object[33].worldY = gp.tileSize*14;
	
		gp.object[97] = new Shop();
		gp.object[97].worldX = gp.tileSize*42;
		gp.object[97].worldY = gp.tileSize*8;
		gp.object[98] = new Tray();
		gp.object[98].worldX = gp.tileSize*30;
		gp.object[98].worldY = gp.tileSize*8;
		gp.object[99]= new house();
		gp.object[99].worldX = 13*gp.tileSize;
		gp.object[99].worldY = 8*gp.tileSize;
	}
	public void setEntity() {
		for( int i=0; i<gp.pigQuantity; i++) {
			gp.entity[i] = new pig(gp);
			gp.entity[i].worldX = gp.tileSize*29;
			gp.entity[i].worldY = gp.tileSize*11;	
		}
		for( int i=3; i<gp.cowQuantity+3; i++) {
			gp.entity[i] = new cow(gp);
			gp.entity[i].worldX = gp.tileSize*8;
			gp.entity[i].worldY = gp.tileSize*8;
		}
		for( int i=6; i<gp.chickenQuantity+6; i++) {
			gp.entity[i] = new chicken(gp);
			gp.entity[i].worldX = gp.tileSize*18;
			gp.entity[i].worldY = gp.tileSize*8;	
		}
		gp.entity[9] = new butterfly(gp, 1);
		gp.entity[9].worldX = 11*gp.tileSize;
		gp.entity[9].worldY = 17*gp.tileSize;
		
		gp.entity[10] = new butterfly(gp, 2);
		gp.entity[10].worldX = 15*gp.tileSize;
		gp.entity[10].worldY = 17*gp.tileSize;
		
		gp.entity[11] = new butterfly(gp, 3);
		gp.entity[11].worldX = 40*gp.tileSize;
		gp.entity[11].worldY = 17*gp.tileSize;
		
		gp.entity[12] = new butterfly(gp, 3);
		gp.entity[12].worldX = 25*gp.tileSize;
		gp.entity[12].worldY = 13*gp.tileSize;
		
		gp.entity[13] = new butterfly(gp, 1);
		gp.entity[13].worldX = 21*gp.tileSize;
		gp.entity[13].worldY = 17*gp.tileSize;
	}
}

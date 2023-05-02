package Key_Handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Panel.GamePanel;
public class keyHandler implements KeyListener{
	public boolean up, down, left, right;
	public GamePanel gp;
	public keyHandler(GamePanel Panel) {
		this.gp = Panel;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if( gp.houseMenu.check == false &&
			gp.animalMenu.check == false &&
			gp.trayMenu.check == false &&
			gp.landTagMenu.check == false &&
			gp.shopMenu.check == false &&
			gp.ui.checkUI == false) {
			
			if( code == KeyEvent.VK_W) {
				up = true;
			}
			if( code == KeyEvent.VK_A) {
				left = true;
				if( gp.player.checkgate == true) gp.player.checkgate=false;
			}
			if( code == KeyEvent.VK_S) {
				down = true;
			}
			if( code == KeyEvent.VK_D) {
				right = true;
				if( gp.player.checkgate == true) gp.player.checkgate=false;
			}
			if( code == KeyEvent.VK_M) {
				gp.ui.checkUI = true;
			}
		}
		
		// CHECK UI
		if( gp.ui.checkUI == true) {
			if( code == KeyEvent.VK_W) {
				if( gp.ui.UIrow != 0)
				gp.ui.UIrow--;
			}
			if( code == KeyEvent.VK_S) {
				if( gp.ui.UIrow != 3)
				gp.ui.UIrow++;
			}
			if( code == KeyEvent.VK_ENTER ) {
				if( gp.ui.UIrow == 0) {
					gp.jdbcUtil.delete();
					gp.ui.checkUI = false;
				}
				if( gp.ui.UIrow ==2) {
					gp.jdbcUtil.delete();
					gp.jdbcUtil.update();
					gp.ui.checkUI = false;
				}
				if( gp.ui.UIrow ==3) {
					gp.jdbcUtil.getdata();
					gp.assetSetter.setEntity();
					gp.ui.checkUI = false;
				}
				if( gp.ui.UIrow == 1) {
					gp.ui.checkUI = false;
				}
			}
		}
				
			
		// CHECK HOUSE MENU
		if( gp.houseMenu.check == true){
				if(code == KeyEvent.VK_SPACE) {
					gp.sound.playSE(3);
				}
				if( code == KeyEvent.VK_C) {
				gp.sound.playSE(3);
				gp.houseMenu.check = false;
				}
				if( code == KeyEvent.VK_ENTER) {
					gp.sound.playSE(3);
					gp.houseMenu.checkEnter = true;
				}
				if( code == KeyEvent.VK_W) {
					gp.sound.playSE(2);
					if( gp.houseMenu.slotRow !=0 )
					gp.houseMenu.slotRow--;
					gp.houseMenu.checkEnter = false;
				}
				if( code == KeyEvent.VK_A) {
					gp.sound.playSE(2);
					if( gp.houseMenu.slotCol != 0)
					gp.houseMenu.slotCol--;
					gp.houseMenu.checkEnter = false;
				}
				if( code == KeyEvent.VK_S) {
					if(gp.houseMenu.slotRow != 2)
					gp.houseMenu.slotRow++;
					gp.houseMenu.checkEnter = false;
				}
				if( code == KeyEvent.VK_D) {
					gp.sound.playSE(2);
					if(gp.houseMenu.slotCol != 4)
					gp.houseMenu.slotCol++;
					gp.houseMenu.checkEnter = false;
				}
				if( code == KeyEvent.VK_Y) {
					gp.sound.playSE(3);
					if(gp.houseMenu.slotCol == 0 && gp.houseMenu.slotRow == 0 && gp.houseMenu.tomato > 0&& gp.houseMenu.checkEnter== true) {
						gp.houseMenu.tomato--;
						gp.houseMenu.coin +=40;
					}
					if(gp.houseMenu.slotCol == 1 && gp.houseMenu.slotRow == 0 && gp.houseMenu.potato > 0 && gp.houseMenu.checkEnter== true) {
						gp.houseMenu.potato--;
						gp.houseMenu.coin += 50;
					}
					if(gp.houseMenu.slotCol == 2 && gp.houseMenu.slotRow == 0 &&  gp.houseMenu.carrot > 0 && gp.houseMenu.checkEnter== true) {
						gp.houseMenu.carrot--;
						gp.houseMenu.coin += 75;
					}
					if(gp.houseMenu.slotCol == 3 && gp.houseMenu.slotRow == 0 && gp.houseMenu.corn > 0 && gp.houseMenu.checkEnter== true) {
						gp.houseMenu.corn--;
						gp.houseMenu.coin += 90;
					}
					}
					if( code == KeyEvent.VK_N) {
						gp.sound.playSE(3);
						gp.houseMenu.checkEnter = false;
					}
		}
		// CHECK SHOP MENU
		if( gp.shopMenu.check == true ) {
			if(code == KeyEvent.VK_SPACE) {
				gp.sound.playSE(3);
			}
			if( code == KeyEvent.VK_C) {
				gp.sound.playSE(3);
				gp.shopMenu.check = false;
			}
			if( code == KeyEvent.VK_ENTER) {
				gp.sound.playSE(3);
				gp.shopMenu.checkEnter = true;
			}
			if( code == KeyEvent.VK_W) {
				gp.sound.playSE(2);
				if( gp.shopMenu.slotRow !=0 )
				gp.shopMenu.slotRow--;
				gp.shopMenu.checkEnter = false;
			}
			if( code == KeyEvent.VK_A) {
				gp.sound.playSE(2);
				if( gp.shopMenu.slotCol != 0)
				gp.shopMenu.slotCol--;
				gp.shopMenu.checkEnter = false;
			}
			if( code == KeyEvent.VK_S) {
				gp.sound.playSE(2);
				if(gp.shopMenu.slotRow != 2)
				gp.shopMenu.slotRow++;
				gp.shopMenu.checkEnter = false;
			}
			if( code == KeyEvent.VK_D) {
				gp.sound.playSE(2);
				if(gp.shopMenu.slotCol != 4)
				gp.shopMenu.slotCol++;
				gp.shopMenu.checkEnter = false;
			}
			if( code == KeyEvent.VK_Y) {
				if( gp.shopMenu.slotCol == 0 && gp.shopMenu.slotRow == 0 && gp.shopMenu.checkEnter == true && gp.cowQuantity < 3 && gp.houseMenu.coin >= 1500) {
					gp.cowQuantity++;
					gp.houseMenu.coin -= 1500;
					gp.assetSetter.setEntity();
				}
				if( gp.shopMenu.slotCol == 1 && gp.shopMenu.slotRow == 0 && gp.shopMenu.checkEnter == true && gp.pigQuantity < 3 && gp.houseMenu.coin >= 400) {
					gp.pigQuantity++;
					gp.houseMenu.coin -= 400;
					gp.assetSetter.setEntity();
				}
				if( gp.shopMenu.slotCol == 2 && gp.shopMenu.slotRow == 0 && gp.shopMenu.checkEnter == true && gp.chickenQuantity < 3 && gp.houseMenu.coin >= 120) {
					gp.chickenQuantity++;
					gp.houseMenu.coin -= 120;
					gp.assetSetter.setEntity();
				}
				if( gp.shopMenu.slotCol == 3 && gp.shopMenu.slotRow == 0 && gp.shopMenu.checkEnter == true && gp.houseMenu.coin >= 2) {
					gp.houseMenu.FoodCow++;
					gp.houseMenu.coin -= 2;
					gp.assetSetter.setEntity();
				}
				if( gp.shopMenu.slotCol == 4 && gp.shopMenu.slotRow == 0 && gp.shopMenu.checkEnter == true && gp.houseMenu.coin >= 1) {
					gp.houseMenu.FoodPig++;
					gp.houseMenu.coin -= 1;
					gp.assetSetter.setEntity();
				}
				if( gp.shopMenu.slotCol == 0 && gp.shopMenu.slotRow == 1 && gp.shopMenu.checkEnter == true && gp.houseMenu.coin >= 1) {
					gp.houseMenu.FoodChicken++;
					gp.houseMenu.coin -= 1;
					gp.assetSetter.setEntity();
				}
				if( gp.shopMenu.slotCol == 1 && gp.shopMenu.slotRow == 1 && gp.shopMenu.checkEnter == true && gp.houseMenu.coin >= 30) {
					gp.houseMenu.SeedPotato++;
					gp.houseMenu.coin -= 30;
					gp.assetSetter.setEntity();
				}
				if( gp.shopMenu.slotCol == 2 && gp.shopMenu.slotRow == 1 && gp.shopMenu.checkEnter == true && gp.houseMenu.coin >= 20) {
					gp.houseMenu.SeedTomato++;
					gp.houseMenu.coin -= 20;
					gp.assetSetter.setEntity();
				}
				if( gp.shopMenu.slotCol == 3 && gp.shopMenu.slotRow == 1 && gp.shopMenu.checkEnter == true && gp.houseMenu.coin >= 25) {
					gp.houseMenu.SeedCarrot++;
					gp.houseMenu.coin -= 25;
					gp.assetSetter.setEntity();
				}
				if( gp.shopMenu.slotCol == 4 && gp.shopMenu.slotRow == 1 && gp.shopMenu.checkEnter == true && gp.houseMenu.coin >= 15) {
					gp.houseMenu.SeedCorn++;
					gp.houseMenu.coin -= 15;
					gp.assetSetter.setEntity();
				}

				if(gp.shopMenu.slotCol==0 && gp.shopMenu.slotRow==2 && gp.shopMenu.checkEnter == true && gp.houseMenu.coin >= gp.shopMenu.price*5000) {
					gp.object[gp.shopMenu.land].landKey = false;
					gp.houseMenu.coin -= gp.shopMenu.price*5000;
					gp.shopMenu.land--;
					gp.shopMenu.price++;	
				}
				
				gp.sound.playSE(3);
			}
			if( code == KeyEvent.VK_N) {
				gp.sound.playSE(3);
				gp.houseMenu.checkEnter = false;
			}
		}
		
		// CHECK ANIMAL
		if( gp.animalMenu.check == true ) {
			if(code == KeyEvent.VK_SPACE) {
				gp.sound.playSE(3);
			}
			if( code == KeyEvent.VK_Y) {
				gp.sound.playSE(3);
				for( int i=0; i< gp.entity.length; i++) {
					if( gp.entity[i]!= null) {
						if( gp.entity[i].check == true) {
						if( gp.entity[i].name =="cow") gp.houseMenu.coin += gp.animalMenu.cow;
						if( gp.entity[i].name =="pig") gp.houseMenu.coin += gp.animalMenu.pig;
						if( gp.entity[i].name =="chicken") gp.houseMenu.coin += gp.animalMenu.chicken;
						gp.entity[i] = null;
						gp.animalMenu.check = false;
						}
					}
				}
			}
			if( code == KeyEvent.VK_N) {
				gp.sound.playSE(3);
				gp.animalMenu.check = false;
			}
		}
		
		// CHECK TRAY
		if( gp.trayMenu.check == true ) {
			if(code == KeyEvent.VK_SPACE) {
				gp.sound.playSE(3);
			}
			if( code == KeyEvent.VK_A) {
				gp.sound.playSE(2);
				if( gp.trayMenu.slotCol != 0) {
					gp.trayMenu.slotCol--;
					gp.trayMenu.checkEnter = false;
				}
			}
			if( code == KeyEvent.VK_D) {
				gp.sound.playSE(2);
				if( gp.trayMenu.slotCol != 4) {
					
					gp.trayMenu.slotCol++;
					gp.trayMenu.checkEnter = false;
				}
			}
			if( code == KeyEvent.VK_C) {
				gp.sound.playSE(3);
				gp.trayMenu.check = false;
			}
			if( code == KeyEvent.VK_ENTER) {
				gp.sound.playSE(3);
				gp.trayMenu.checkEnter = true;
			}
			if( code == KeyEvent.VK_Y) {
				gp.sound.playSE(3);
				if (gp.trayMenu.slotCol == 0 && gp.houseMenu.FoodPig >= 10000) {
					gp.houseMenu.FoodPig -= 10000;
					gp.trayMenu.foodPig += 10000;
					gp.trayMenu.checkEnter = false;
				}	
				if (gp.trayMenu.slotCol == 1 && gp.houseMenu.FoodCow >= 10000) {
					gp.houseMenu.FoodCow -= 10000;
					gp.trayMenu.foodCow += 10000;
					gp.trayMenu.checkEnter = false;
				}
				if (gp.trayMenu.slotCol == 2 && gp.houseMenu.FoodChicken >= 10000) {
					gp.houseMenu.FoodChicken -= 10000;
					gp.trayMenu.foodChicken += 10000;
					gp.trayMenu.checkEnter = false;
				}
			}
			if( code == KeyEvent.VK_N) {
				gp.trayMenu.checkEnter = false;
			}
		}
		
		// CHECK LAND TAG
		if( gp.landTagMenu.check == true) {
			if(code == KeyEvent.VK_SPACE) {
				gp.sound.playSE(3);
			}
			if( code == KeyEvent.VK_C) {
				gp.sound.playSE(3);
				gp.landTagMenu.check = false;
			}
			if( code == KeyEvent.VK_A) {
				gp.sound.playSE(2);
				if( gp.landTagMenu.slotCol != 0)
				gp.landTagMenu.slotCol--;
				gp.landTagMenu.checkEnter = false;
			}
			if( code == KeyEvent.VK_D) {
				gp.sound.playSE(2);
				
				if(gp.landTagMenu.slotCol != 4)
				gp.landTagMenu.slotCol++;
				gp.landTagMenu.checkEnter = false;
			}
			if( code == KeyEvent.VK_ENTER) {
				gp.sound.playSE(3);
				gp.landTagMenu.checkEnter = true;
				if( gp.landTagMenu.slotCol == 0) {
					gp.landTagMenu.checkTree = 0;
				}
				if( gp.landTagMenu.slotCol == 1) {
					gp.landTagMenu.checkTree = 1;
				}
				if( gp.landTagMenu.slotCol == 2) {
					gp.landTagMenu.checkTree = 2;
				}
				if( gp.landTagMenu.slotCol == 3) {
					gp.landTagMenu.checkTree = 3;
				}
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if( code == KeyEvent.VK_W) {
			up = false;
		}
		if( code == KeyEvent.VK_A) {
			left = false;
		}
		if( code == KeyEvent.VK_S) {
			down = false;
		}
		if( code == KeyEvent.VK_D) {
			right = false;
		}
	}
}

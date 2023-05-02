package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Panel.GamePanel;

public class JDBCUtil {
	public GamePanel gp;
	public Connection con = null;

	public JDBCUtil(GamePanel gp) {
		this.gp = gp;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=FarmGame2D;user=sa;password=quang2003");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			// UPDATE HOUSE DATA
			PreparedStatement p = con.prepareStatement("INSERT INTO house (carrot, corn, potato, tomato, seedtomato, seedpotato, seedcorn, seedcarrot, coin, foodpig, foodcow, foodchicken) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,?);");
			p.setInt(1, gp.houseMenu.carrot);
			p.setInt(2, gp.houseMenu.corn);
			p.setInt(3, gp.houseMenu.potato);
			p.setInt(4, gp.houseMenu.tomato);
			p.setInt(5, gp.houseMenu.SeedTomato);
			p.setInt(6, gp.houseMenu.SeedPotato);
			p.setInt(7, gp.houseMenu.SeedCorn);
			p.setInt(8, gp.houseMenu.SeedCarrot);
			p.setInt(9, gp.houseMenu.coin);
			p.setInt(10, gp.houseMenu.FoodPig);
			p.setInt(11, gp.houseMenu.FoodCow);
			p.setInt(12, gp.houseMenu.FoodChicken);
			
			p.executeUpdate();
			
			// UPDATE TIME TREE DATA
			
			for( int i=0; i< 28; i++) {
			p = con.prepareStatement("INSERT INTO timetree (landkey, collision, checkripen, checktree, time1, time2, time3, time4) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
				p.setBoolean(1, gp.object[i].landKey);
				p.setBoolean(2, gp.object[i].collision);
				p.setBoolean(3, gp.object[i].checkRipen);
				p.setInt(4, gp.object[i].checkTree);
				p.setLong(5, gp.object[i].time1);
				p.setLong(6, gp.object[i].time2);
				p.setLong(7, gp.object[i].time3);
				p.setLong(8, gp.object[i].time4);
				p.executeUpdate();
			}
			
			
			
			// UPDATE LAND DATA
			p=con.prepareStatement("insert into land (seedcarrot,seedcorn,seedpotato,seedtomato,fertilizer) values (?,?,?,?,?)");
			p.setInt(1, gp.landTagMenu.SeedCarrot);
			p.setInt(2, gp.landTagMenu.SeedCorn);
			p.setInt(3, gp.landTagMenu.SeedPotato);
			p.setInt(4, gp.landTagMenu.SeedTomato);
			p.setInt(5, 0);
			p.executeUpdate();
			
			
			// UPDATE TRAY DATA
			p=con.prepareStatement("insert into tray (foodpig,foodcow,foodchicken) values (?,?,?)");
			p.setInt(1, gp.trayMenu.foodPig);
			p.setInt(2,  gp.trayMenu.foodCow);
			p.setInt(3,  gp.trayMenu.foodChicken);
			p.executeUpdate();
			
			// UPDATE ANIMAL DATA
			p = con.prepareStatement("insert into animal(pig, cow, chicken) values(?,?,?)");
			p.setInt(1, gp.pigQuantity);
			p.setInt(2, gp.cowQuantity);
			p.setInt(3, gp.chickenQuantity);
			p.executeUpdate();
			
			// UPDATE SHOP DATA
			p = con.prepareStatement("insert into shop(price, land) values(?,?)");
			p.setInt(1, gp.shopMenu.price);
			p.setInt(2, gp.shopMenu.land);
			p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete() {
		try {
			PreparedStatement p = con.prepareStatement("DELETE FROM house");
			p.executeUpdate();
			
			p = con.prepareStatement("delete from land");
			p.executeUpdate();
			
			p = con.prepareStatement("delete from tray");
			p.executeUpdate();
			
			p = con.prepareStatement("delete from animal");
			p.executeUpdate();
			
			p = con.prepareStatement("delete from timetree");
			p.executeUpdate();
			
			p = con.prepareStatement("delete from shop");
			p.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getdata() {
		try {
			// GET HOUSEDATA
			PreparedStatement p = con.prepareStatement("select * from house ");
			ResultSet rs = p.executeQuery();
			while( rs.next() ) {
				gp.houseMenu.carrot= rs.getInt("carrot");
				gp.houseMenu.potato= rs.getInt("potato");
				gp.houseMenu.tomato= rs.getInt("tomato");
				gp.houseMenu.corn= rs.getInt("corn");
				gp.houseMenu.SeedCarrot= rs.getInt("SeedCarrot");
				gp.houseMenu.SeedCorn= rs.getInt("SeedCorn");
				gp.houseMenu.SeedPotato= rs.getInt("SeedPotato");
				gp.houseMenu.SeedTomato= rs.getInt("SeedTomato");
				gp.houseMenu.FoodChicken= rs.getInt("FoodChicken");
				gp.houseMenu.FoodCow= rs.getInt("FoodCow");
				gp.houseMenu.FoodPig= rs.getInt("FoodPig");
				gp.houseMenu.coin= rs.getInt("coin");
			}
			
			// GET SEED DATA
				p = con.prepareStatement("select * from land");
				rs = p.executeQuery();
				while( rs.next()) {
					gp.landTagMenu.SeedCarrot= rs.getInt("seedcarrot");
					gp.landTagMenu.SeedPotato= rs.getInt("seedpotato");
					gp.landTagMenu.SeedTomato= rs.getInt("seedtomato");
					gp.landTagMenu.SeedCorn= rs.getInt("seedcorn");
				}
	
			// GET FOOD DATA
				p = con.prepareStatement("select * from tray");
				rs = p.executeQuery();
				while( rs.next() ) {
					gp.trayMenu.foodChicken= rs.getInt("foodchicken");
					gp.trayMenu.foodCow= rs.getInt("foodcow");
					gp.trayMenu.foodPig= rs.getInt("foodpig");
				}	
			
			
			// GET QUANTITY DATA
				p = con.prepareStatement("select * from animal");
				rs = p.executeQuery();
				while( rs.next() ) {
					gp.pigQuantity = rs.getInt("pig");
					gp.cowQuantity = rs.getInt("cow");
					gp.chickenQuantity = rs.getInt("chicken");
				}
				
				// GET TIME TREE
				int i=0;
				p = con.prepareStatement("select * from timetree");
				rs = p.executeQuery();
				while( rs.next() ) {
					gp.object[i].landKey = rs.getBoolean("landkey");
					gp.object[i].collision = rs.getBoolean("collision");
					gp.object[i].checkRipen = rs.getBoolean("checkripen");
					gp.object[i].checkTree = rs.getInt("checktree");
					gp.object[i].time1 = rs.getLong("time1");
					gp.object[i].time2 = rs.getLong("time2");
					gp.object[i].time3 = rs.getLong("time3");
					gp.object[i].time4 = rs.getLong("time4");
					i++;
				}
				
			// GET SHOP DATA
			p = con.prepareStatement("select * from shop");
			rs = p.executeQuery();
			while( rs.next() ) {
				gp.shopMenu.price = rs.getInt("price");
				gp.shopMenu.land = rs.getInt("land");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package lab8_comp;


import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArtistController {

	public void create(String name, String country) {
		Connection myConn = ConnectDB.getConnection();
		try {
			Statement myStmt = myConn.createStatement();
			 
			
			//deci e fix ca la tine scris, doar ca imi sublineaza asta
			//si din cazua asta nu pot sa rulez
			
			String s = "INSERT INTO artists (name,country) VALUES (" + "'" + name + "'" + "," + "'" + country + "'"+ ")";
			System.out.println(s);
			myStmt.executeUpdate(s);

		} catch (Exception ex) {
			Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void findByName(String name) {
		Connection myConn = (Connection) ConnectDB.getConnection();
		try {
			Statement myStmt = myConn.createStatement();
			String string = "SELECT * from artists";
			ResultSet result = myStmt.executeQuery(string);
			while (result.next()) {
				int code = result.getInt("id");
				String country = result.getString("country");
				System.out.println(code + ", " + country);
			}

		} catch (SQLException ex) {
			Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

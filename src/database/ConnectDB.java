package database;


import java.sql.*;

public class ConnectDB {

	static Connection myConn = null;
	 public ResultSet result;

	public static Connection getConnection() {
		if (myConn == null) {

			Statement myStmt = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/musicalbums3", "root",
						"stefan123");

				if (myConn != null)

				{
					System.out.println("connected succesfully");
				}
			} catch (Exception e) {
				System.out.println("not connected to the server");

			}
		}
		return myConn;
	}
	
	public ResultSet setResultSet(String query) { //will execute any query
        try {
            Statement stmt = myConn.createStatement();
            result = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
	
	public void doUpdate(String update) { //will execute updates
        try {
            Statement stmt = myConn.createStatement();
            stmt.executeUpdate(update);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public PreparedStatement createPreparedStatement(String string) {
        try {
            PreparedStatement preparedStatement = myConn.prepareStatement(string);
            return preparedStatement;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
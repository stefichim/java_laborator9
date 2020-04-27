package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;

public class ChartController {
   ConnectDB database;
    List<Integer> artists_id = new ArrayList<>();

    public ChartController(ConnectDB database) {
        this.database = database;
    }

    public void updateChart() throws SQLException, ClassNotFoundException {
        artists_id.removeAll(artists_id);
        try {
            ResultSet resultSet = database.setResultSet("(SELECT ID FROM ARTISTS) ");
            while (resultSet.next()) {
                artists_id.add(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        insertPopularity();
        System.out.println("Chart was updated");
    }	
    
//inseram o functie care "detine" popularitatea pentru a putea realiza chart-uri
    private void insertPopularity() {
        if (!artists_id.isEmpty()) {
            for (Integer id : artists_id) {
                try {
                    PreparedStatement pstmt = database.createPreparedStatement("INSERT INTO CHART(artist_id,popularity) " +
                            "VALUES(?,?)");
                    pstmt.setInt(1, id);
                    pstmt.setInt(2, id);
                    pstmt.setInt(3, id);
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    e.getStackTrace();
                }
            }
        }
    }

    public List<models.Artist> getChart() throws SQLException, ClassNotFoundException {
        List<models.Artist> artists = new ArrayList<models.Artist>();
        ResultSet resultSet = database.setResultSet("SELECT A.ID,A.NAME,A.COUNTRY,C.POPULARITATE FROM ARTISTS A,CHART C WHERE A.ID=C.ARTIST_ID ORDER BY C.POPULARITATE DESC ");
        while (resultSet.next()) {
            models.Artist artist = new models.Artist(resultSet.getString(2), resultSet.getString(3), database);
            artist.setId(resultSet.getInt(1));
            artist.setPopularitate(resultSet.getInt(4));
            artists.add(artist);
        }
        return artists;
    }
}
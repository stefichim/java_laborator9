package models;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllers.ChartController;
import database.ConnectDB;
public class Chart {

    private List<models.Artist> artistList = new ArrayList<>();
    public ConnectDB database;

    public Chart(ConnectDB database) {
        this.database = database;
    }

    public void printTop() {
        System.out.println("Top Artists in the chart:");
        int index = 0;
        for (models.Artist artist : artistList) {
            index++;
            System.out.println(index + ". " + artist.getNume() + " " + artist.getPopularitate());
        }
    }

    public void updateChartToLive() throws SQLException, ClassNotFoundException {
        ChartController chartController = new ChartController(database);
        chartController.updateChart();
        artistList.removeAll(artistList);
        artistList.addAll(chartController.getChart());
    }

    public List<models.Artist> getArtistList() {
        return artistList;
    }
}
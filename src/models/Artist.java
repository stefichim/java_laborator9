package models;

import java.sql.SQLException;

import database.ConnectDB;


public class Artist {

    public String nume;
    private int id;
    private String country;
    public int popularitate;
    public int id_identity;
	private ConnectDB database;
    
    public Artist(String name, String country, ConnectDB database) throws SQLException, ClassNotFoundException {
        this.nume = name;
        this.country = country;
        this.database=database;
    }
    
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPopularitate() {
		return popularitate;
	}
	public void setPopularitate(int popularitate) {
		this.popularitate = popularitate;
	}
	public int getId_identity() {
		return id_identity;
	}
	public void setId_identity(int id_identity) {
		this.id_identity = id_identity;
	}
    
    
}

package models;


import database.ConnectDB;

public class Album {
    public int id = 15;
    private String nume;
    private int artist_id;
    private int relase_year;
    private ConnectDB database;

    public Album(String nume, int year, int artist_id, ConnectDB database) {
        this.database=database;
        this.nume = nume;
        this.relase_year = year;
        this.artist_id = artist_id;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}

	public int getRelase_year() {
		return relase_year;
	}

	public void setRelase_year(int relase_year) {
		this.relase_year = relase_year;
	}

	public ConnectDB getDatabase() {
		return database;
	}

	public void setDatabase(ConnectDB database) {
		this.database = database;
	}


}


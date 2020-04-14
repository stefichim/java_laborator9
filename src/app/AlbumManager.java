package app;


import entity.Artist;
import repo.ArtistRepository;


public class AlbumManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Artist artistNew1=new Artist();
		Artist artistNew2=new Artist();
		Artist artistNew3=new Artist();
		
	    artistNew1.setName("Paul Adam");
	    artistNew1.setCountry("China");
	    
	    artistNew2.setName("Paul Adam");
	    artistNew2.setCountry("China");
	    
	    artistNew3.setName("Paul Adam");
	    artistNew3.setCountry("China");
	    
	    ArtistRepository artist1=new ArtistRepository();
	    ArtistRepository artist2=new ArtistRepository();
	    ArtistRepository artist3=new ArtistRepository();
	    
	    artist1.create(artistNew1);
	    artist2.create(artistNew2);
	    artist3.create(artistNew3);
	}

}

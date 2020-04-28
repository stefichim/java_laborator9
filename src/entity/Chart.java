package entity;

import javax.persistence.Column;

public class Chart {

	private int artistId;
	private int popularitate;

	@Column(name = "artistId")
	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	
	@Column(name = "popularitate")
	public int getPopularitate() {
		return popularitate;
	}

	public void setPopularitate(int popularitate) {
		this.popularitate = popularitate;
	}

	//generated hashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + artistId;
		result = prime * result + popularitate;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chart other = (Chart) obj;
		if (artistId != other.artistId)
			return false;
		if (popularitate != other.popularitate)
			return false;
		return true;
	}
	
	
	

}

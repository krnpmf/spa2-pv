package hash.pripremni.resenje;

import org.svetovid.io.SvetovidReader;

public class Lokacija extends InfoTip {
	private int lat_whole, lat_dec, lon_whole, lon_dec;

	public Lokacija() {
	}

	public Lokacija(int lat_whole, int lat_dec, int lon_whole, int lon_dec) {
		this.lat_whole = lat_whole;
		this.lat_dec = lat_dec;
		this.lon_whole = lon_whole;
		this.lon_dec = lon_dec;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;

		Lokacija l = (Lokacija) o;
		if (lat_whole != l.lat_whole)
			return false;
		if (lat_dec != l.lat_dec)
			return false;
		if (lon_whole != l.lon_whole)
			return false;
		if (lon_dec != l.lon_dec)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lat_whole;
		result = prime * result + lat_dec;
		result = prime * result + lon_whole;
		result = prime * result + lon_dec;
		return result;
	}

	@Override
	public Lokacija ucitaj(SvetovidReader read) {
		return new Lokacija(read.readInt(), read.readInt(), read.readInt(), read.readInt());
	}

	// pomocni metod za lakse testiranje
	public static void main(String[] args) {
		new TestHash(new Lokacija(), "res/", "l").run();
	}
}

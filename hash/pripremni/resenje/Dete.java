package hash.pripremni.resenje;

import java.util.Objects;
import org.svetovid.io.SvetovidReader;

public class Dete extends InfoTip {
	private String ime, prezime;
	private int uzrast;
	private boolean dobro;
	private Lokacija grad, kuca, dimnjak;

	public Dete() {
	}

	public Dete(String ime, String prezime, int uzrast, boolean dobro, Lokacija grad, Lokacija kuca, Lokacija dimnjak) {
		this.ime = ime;
		this.prezime = prezime;
		this.uzrast = uzrast;
		this.dobro = dobro;
		this.grad = grad;
		this.kuca = kuca;
		this.dimnjak = dimnjak;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Dete d = (Dete) obj;

		if (dobro != d.dobro) {
			return false;
		}
		if (uzrast != d.uzrast) {
			return false;
		}
		if (!Objects.equals(ime, d.ime)) {
			return false;
		}
		if (!Objects.equals(prezime, d.prezime)) {
			return false;
		}
		if (!Objects.equals(grad, d.grad)) {
			return false;
		}
		if (!Objects.equals(kuca, d.kuca)) {
			return false;
		}
		if (!Objects.equals(dimnjak, d.dimnjak)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		result = prime * result + uzrast;
		result = prime * result + (dobro ? 1231 : 1237);
		result = prime * result + ((grad == null) ? 0 : grad.hashCode());
		result = prime * result + ((kuca == null) ? 0 : kuca.hashCode());
		result = prime * result + ((dimnjak == null) ? 0 : dimnjak.hashCode());
		return result;
	}

	@Override
	public Dete ucitaj(SvetovidReader read) {
		Lokacija l = new Lokacija();
		String ime = read.readLine(), prezime = read.readLine();
		boolean dobro = read.readToken().equals("da") ? true : false;
		int uzrast = read.readInt();
		Lokacija grad = l.ucitaj(read), kuca = l.ucitaj(read), dimnjak = l.ucitaj(read);
		return new Dete(ime, prezime, uzrast, dobro, grad, kuca, dimnjak);
	}

	// pomocni metod za lakse testiranje
	public static void main(String[] args) {
		new TestHash(new Dete(), "res/", "d").run();
	}
}

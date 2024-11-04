package hash.prakticne_vezbe.resenje;

import java.util.Objects;
import org.svetovid.io.SvetovidReader;

public class Automobil extends InfoTip {
    private String naziv;
    private Boja karoserija, sediste, volan;

    public Automobil() {
    }

    public Automobil(String naziv, Boja karoserija, Boja sediste, Boja volan) {
        this.naziv = naziv;
        this.karoserija = karoserija;
        this.sediste = sediste;
        this.volan = volan;
    }

    @Override
    public Automobil ucitaj(SvetovidReader read) {
        Boja b = new Boja();
        String naziv = read.readLine();
        Boja karoserija = b.ucitaj(read);
        Boja sediste = b.ucitaj(read);
        Boja volan = b.ucitaj(read);
        read.readLine();
        return new Automobil(naziv, karoserija, sediste, volan);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Automobil a = (Automobil) o;

        if (!Objects.equals(naziv, a.naziv)) {
            return false;
        }
        if (!Objects.equals(karoserija, a.karoserija)) {
            return false;
        }
        if (!Objects.equals(sediste, a.sediste)) {
            return false;
        }
        if (!Objects.equals(volan, a.volan)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
        result = prime * result + ((karoserija == null) ? 0 : karoserija.hashCode());
        result = prime * result + ((sediste == null) ? 0 : sediste.hashCode());
        result = prime * result + ((volan == null) ? 0 : volan.hashCode());
        return result;
    }

    // pomocni metod za lakse testiranje
    public static void main(String[] args) {
        new TestHash(new Automobil(), "", "a").run();
    }

}

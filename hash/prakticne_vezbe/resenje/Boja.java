package hash.prakticne_vezbe.resenje;

import org.svetovid.io.SvetovidReader;

public class Boja extends InfoTip {
    private int r, g, b;

    public Boja() {
    }

    public Boja(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Boja boja = (Boja) o;
        if (r != boja.r)
            return false;
        if (g != boja.g)
            return false;
        if (b != boja.b)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + r;
        result = prime * result + g;
        result = prime * result + b;
        return result;
    }

    @Override
    public Boja ucitaj(SvetovidReader read) {
        return new Boja(
                read.readInt(),
                read.readInt(),
                read.readInt());
    }

    // pomocni metod za lakse testiranje
    public static void main(String[] args) {
        new TestHash(new Boja(), "", "boje").run();
    }
}

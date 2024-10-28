package sort.prakticne_vezbe.resenje.napredno;

public class Film implements Comparable<Film> {
  private int id;
  private String naziv;
  private String reditelj;

  public Film(int id, String naziv, String reditelj) {
    this.id = id;
    this.naziv = naziv;
    this.reditelj = reditelj;
  }

  public int getId() {
    return id;
  }

  public String getNaziv() {
    return naziv;
  }

  public String getReditelj() {
    return reditelj;
  }

  @Override
  public int compareTo(Film o) {
    /*
     * Ovde nismo morali da koristimo getter zato sto je metoda implementirana u
     * klasi film.
     * 
     * Da je metoda implementirana izvan klase film, ne bi mogli da pristupamo polju
     * direktno posto je private (vidljivo samo iz klase Film) vec bi morali da
     * koristimo getter.
     */

    return this.id - o.id;
  }
}

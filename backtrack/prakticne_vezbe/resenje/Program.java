package backtrack.prakticne_vezbe.resenje;

import java.util.ArrayList;
import java.util.Comparator;

import org.svetovid.Svetovid;
import org.svetovid.io.SvetovidReader;

public class Program {
  public static void main(String[] args) {
    String file = Svetovid.in.readToken("Unesite ime fajla:");

    if (!Svetovid.testIn(file)) {
      return;
    }

    PostojiPut pp = new PostojiPut(Svetovid.in(file));
    Svetovid.in(file).close();
    pp.pronadjiPut(0, 0);
    pp.ispisiPosecenost();

    NajboljiPut np = new NajboljiPut(Svetovid.in(file), NajboljiPut.NAJKRACI);
    np.pronadjiNajboljiPut(0, 0);
    System.out.println(np.getResenje());
    System.out.println(np.getResenje().getDuzina());
  }
}

class PostojiPut {
  private final int ZID = -11;
  private final int IZLAZ = -99;

  private int visina, sirina;

  private int[][] lavirint;
  private boolean[][] posecensot;

  public PostojiPut() {
  }

  public PostojiPut(SvetovidReader reader) {
    ucitajLavirint(reader);
  }

  public void ucitajLavirint(SvetovidReader reader) {
    sirina = reader.readInt();
    visina = reader.readInt();

    lavirint = new int[visina][sirina];
    posecensot = new boolean[visina][sirina];

    for (int i = 0; i < visina; i++) {
      for (int j = 0; j < sirina; j++) {
        lavirint[i][j] = reader.readInt();
        posecensot[i][j] = false;
      }
    }
  }

  public void ispisiLavirint() {
    for (int i = 0; i < visina; i++) {
      for (int j = 0; j < visina; j++) {
        Svetovid.out.printf("%5d", lavirint[i][j]);
      }
      Svetovid.out.println();
    }
  }

  public void ispisiPosecenost() {
    for (int i = 0; i < visina; i++) {
      for (int j = 0; j < visina; j++) {
        Svetovid.out.print(posecensot[i][j] ? " x" : "  ");
      }
      Svetovid.out.println();
    }
  }

  private boolean inMatrix(int x, int y) {
    return y >= 0 && y < visina && x >= 0 && x < sirina;
  }

  public boolean pronadjiPut(int x, int y) { // x je kolona a y je red
    if (!inMatrix(x, y))
      return false;

    if (posecensot[y][x])
      return false;

    if (lavirint[y][x] == ZID)
      return false;

    if (lavirint[y][x] == IZLAZ)
      return true;

    posecensot[y][x] = true;

    if (pronadjiPut(x + 1, y))
      return true;
    if (pronadjiPut(x - 1, y))
      return true;
    if (pronadjiPut(x, y + 1))
      return true;
    if (pronadjiPut(x, y - 1))
      return true;

    posecensot[y][x] = false;

    return false;
  }
}

class NajboljiPut {
  // singleton instance za komparatore
  public final static Comparator<Resenje> NAJKRACI = new PoredjenjeNajkraci();
  public final static Comparator<Resenje> NAJVREDNIJI = new PoredjenjeNajvredniji();

  private final int ZID = -11;
  private final int IZLAZ = -99;

  private int visina, sirina;

  private int[][] lavirint;

  private Resenje najboljeResenje, resenje;

  private Comparator<Resenje> comparator;

  public NajboljiPut(Comparator<Resenje> comparator) {
    najboljeResenje = null;
    resenje = new Resenje();
    this.comparator = comparator;
  }

  public NajboljiPut(SvetovidReader reader, Comparator<Resenje> comparator) {
    this(comparator);
    ucitajLavirint(reader);
  }

  public void ucitajLavirint(SvetovidReader reader) {
    sirina = reader.readInt();
    visina = reader.readInt();

    lavirint = new int[visina][sirina];

    for (int i = 0; i < visina; i++) {
      for (int j = 0; j < sirina; j++) {
        lavirint[i][j] = reader.readInt();
      }
    }
  }

  public void ispisiLavirint() {
    for (int i = 0; i < visina; i++) {
      for (int j = 0; j < visina; j++) {
        Svetovid.out.printf("%5d", lavirint[i][j]);
      }
      Svetovid.out.println();
    }
  }

  public Resenje getResenje() {
    return najboljeResenje;
  }

  private boolean inMatrix(int x, int y) {
    return y >= 0 && y < visina && x >= 0 && x < sirina;
  }

  public void pronadjiNajboljiPut(int x, int y) { // x je kolona a y je red
    if (!inMatrix(x, y))
      return;

    if (resenje.poseceno(x, y))
      return;

    if (lavirint[y][x] == ZID)
      return;

    if (lavirint[y][x] == IZLAZ) {
      if (najboljeResenje == null || comparator.compare(resenje, najboljeResenje) > 1) {
        najboljeResenje = new Resenje(resenje);
      }

      return;
    }

    resenje.dodaj(x, y, lavirint[y][x]);

    pronadjiNajboljiPut(x + 1, y);
    pronadjiNajboljiPut(x - 1, y);
    pronadjiNajboljiPut(x, y + 1);
    pronadjiNajboljiPut(x, y - 1);

    resenje.obrisi();

    return;
  }
}

class Resenje {
  private class Polje {
    private int x, y, vrednost;

    public Polje(int x, int y, int vrednost) {
      this.x = x;
      this.y = y;
      this.vrednost = vrednost;
    }

    @Override
    public String toString() {
      return "Polje [x=" + x + ", y=" + y + ", vrednost=" + vrednost + "]";
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + x;
      result = prime * result + y;
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
      Polje other = (Polje) obj;
      if (x != other.x)
        return false;
      if (y != other.y)
        return false;
      return true;
    }
  }

  private ArrayList<Polje> put;

  public Resenje() {
    put = new ArrayList<>();
  }

  public Resenje(Resenje resenje) {
    put = new ArrayList<>(resenje.put);
  }

  public void dodaj(int x, int y, int vrednost) {
    put.add(new Polje(x, y, vrednost));
  }

  public void obrisi() {
    put.remove(put.size() - 1);
  }

  public boolean poseceno(int x, int y) {
    return put.contains(new Polje(x, y, 0));
  }

  public int getUkupnaVrednost() {
    int vrednost = 0;

    for (Polje polje : put) {
      vrednost += polje.vrednost;
    }

    return vrednost;
  }

  public int getDuzina() {
    return put.size();
  }

  @Override
  public String toString() {
    return "Resenje [put=" + put + "]";
  }
}

class PoredjenjeNajkraci implements Comparator<Resenje> {
  @Override
  public int compare(Resenje o1, Resenje o2) {
    // o1 treba dabude "veci" od o2 ako je duzina puta kraca
    return -(o1.getDuzina() - o2.getDuzina());
  }
}

class PoredjenjeNajvredniji implements Comparator<Resenje> {
  @Override
  public int compare(Resenje o1, Resenje o2) {
    return o1.getUkupnaVrednost() - o2.getUkupnaVrednost();
  }
}

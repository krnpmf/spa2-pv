package backtrack.prakticne_vezbe.resenje;

import org.svetovid.Svetovid;
import org.svetovid.io.SvetovidReader;

public class Program {
  public static void main(String[] args) {
    String file = Svetovid.in.readToken("Unesite ime fajla:");

    if (!Svetovid.testIn(file)) {
      return;
    }

    PostojiPut pp = new PostojiPut(Svetovid.in(file));

    pp.pronadjiPut(0, 0);

    pp.ispisiPosecenost();
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

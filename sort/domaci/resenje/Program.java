package sort.domaci.resenje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Objects;

public class Program {
  public static void main(String[] args) {
    Racunar[] niz = ucitajRacunare("ulaz.txt");
    Sorter.sort(niz, new InsertionSort());
    ispisi("izlaz.txt", niz);
  }

  private static Racunar[] ucitajRacunare(String filename) {
    File file = new File(filename);
    Racunar[] niz = null;
    try (
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader reader = new BufferedReader(isr);) {
      int n = Integer.parseInt(reader.readLine());
      niz = new Racunar[n];
      for (int i = 0; i < n; i++) {
        Procesor procesor = Procesor.fromInputString(reader.readLine());
        Disk disk = Disk.fromInputString(reader.readLine());
        MaticnaPloca maticnaPloca = MaticnaPloca.fromInputString(reader.readLine());
        Memorija memorija = Memorija.fromInputString(reader.readLine());
        Kuciste kuciste = Kuciste.fromInputString(reader.readLine());
        niz[i] = new Racunar(procesor, disk, maticnaPloca, memorija, kuciste);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return niz;
  }

  private static void ispisi(String filename, OutputStringer[] niz) {
    File file = new File(filename);
    try (
        FileOutputStream fos = new FileOutputStream(file, true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter writer = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(writer);) {
      pw.println(niz.length);
      for (OutputStringer os : niz) {
        pw.println(os.toOutputString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

interface OutputStringer {
  public String toOutputString();
}

class Racunar implements Comparable<Racunar>, OutputStringer {
  private Procesor procesor;
  private Disk disk;
  private MaticnaPloca maticnaPloca;
  private Memorija memorija;
  private Kuciste kuciste;

  public Racunar(Procesor procesor, Disk disk, MaticnaPloca maticnaPloca, Memorija memorija, Kuciste kuciste) {
    this.procesor = procesor;
    this.disk = disk;
    this.maticnaPloca = maticnaPloca;
    this.memorija = memorija;
    this.kuciste = kuciste;
  }

  @Override
  public int compareTo(Racunar that) {
    int rezultat;

    rezultat = Objects.compare(this.procesor, that.procesor, Comparator.naturalOrder());
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = Objects.compare(this.disk, that.disk, Comparator.naturalOrder());
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = Objects.compare(this.maticnaPloca, that.maticnaPloca, Comparator.naturalOrder());
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = Objects.compare(this.memorija, that.memorija, Comparator.naturalOrder());
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = Objects.compare(this.kuciste, that.kuciste, Comparator.naturalOrder());
    if (rezultat != 0) {
      return rezultat;
    }

    return 0;
  }

  @Override
  public String toOutputString() {
    return String.format(
        "%s\n%s\n%s\n%s\n%s",
        this.procesor.toOutputString(),
        this.disk.toOutputString(),
        this.maticnaPloca.toOutputString(),
        this.memorija.toOutputString(),
        this.kuciste.toOutputString());
  }

  public Procesor getProcesor() {
    return procesor;
  }

  public Disk getDisk() {
    return disk;
  }

  public MaticnaPloca getMaticnaPloca() {
    return maticnaPloca;
  }

  public Memorija getMemorija() {
    return memorija;
  }

  public Kuciste getKuciste() {
    return kuciste;
  }
}

class Komponenta {
  protected int evidencioniBroj;

  public Komponenta(int evidencioniBroj) {
    this.evidencioniBroj = evidencioniBroj;
  }
}

class Procesor extends Komponenta implements Comparable<Procesor>, OutputStringer {
  private String model;
  private int l1;
  private int jezgra;
  private float brzina;
  private int godina;

  public Procesor(int evidencioniBroj, String model, int l1, int jezgra, float brzina, int godina) {
    super(evidencioniBroj);
    this.model = model;
    this.l1 = l1;
    this.jezgra = jezgra;
    this.brzina = brzina;
    this.godina = godina;
  }

  @Override
  public int compareTo(Procesor that) {
    int rezultat;

    rezultat = Objects.compare(this.model, that.model, String.CASE_INSENSITIVE_ORDER);
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = this.l1 - that.l1;
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = this.jezgra - that.jezgra;
    if (rezultat != 0) {
      return rezultat;
    }

    float floatRezultat = this.brzina - that.brzina;
    if (floatRezultat < 0)
      return -1;
    else if (floatRezultat > 0)
      return 1;

    rezultat = this.godina - that.godina;
    if (rezultat != 0) {
      return rezultat;
    }

    return 0;
  }

  @Override
  public String toOutputString() {
    return String.format(
        "%d %s %d %d %f %d",
        this.evidencioniBroj,
        this.model,
        this.l1,
        this.jezgra,
        this.brzina,
        this.godina);
  }

  public static Procesor fromInputString(String string) {
    String[] tokens = string.split(" ");
    return new Procesor(
        Integer.parseInt(tokens[0]),
        tokens[1],
        Integer.parseInt(tokens[2]),
        Integer.parseInt(tokens[3]),
        Float.parseFloat(tokens[4]),
        Integer.parseInt(tokens[5]));
  }
}

class Disk extends Komponenta implements Comparable<Disk>, OutputStringer {
  private String tip;
  private int prostor;
  private String konektor;

  public Disk(int evidencioniBroj, String tip, int prostor, String konektor) {
    super(evidencioniBroj);
    this.tip = tip;
    this.prostor = prostor;
    this.konektor = konektor;
  }

  @Override
  public int compareTo(Disk that) {
    int rezultat;

    rezultat = Objects.compare(this.tip, that.tip, String.CASE_INSENSITIVE_ORDER);
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = this.prostor - that.prostor;
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = Objects.compare(this.konektor, that.konektor, String.CASE_INSENSITIVE_ORDER);
    if (rezultat != 0) {
      return rezultat;
    }

    return 0;
  }

  @Override
  public String toOutputString() {
    return String.format(
        "%d %s %d %s",
        this.evidencioniBroj,
        this.tip,
        this.prostor,
        this.konektor);
  }

  public static Disk fromInputString(String string) {
    String[] tokens = string.split(" ");
    return new Disk(
        Integer.parseInt(tokens[0]),
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3]);
  }
}

class MaticnaPloca extends Komponenta implements Comparable<MaticnaPloca>, OutputStringer {
  private String proizvodjac;
  private int godina;

  public MaticnaPloca(int evidencioniBroj, String proizvodjac, int godina) {
    super(evidencioniBroj);
    this.proizvodjac = proizvodjac;
    this.godina = godina;
  }

  @Override
  public int compareTo(MaticnaPloca that) {
    int rezultat;

    rezultat = Objects.compare(this.proizvodjac, that.proizvodjac, String.CASE_INSENSITIVE_ORDER);
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = this.godina - that.godina;
    if (rezultat != 0) {
      return rezultat;
    }

    return 0;
  }

  @Override
  public String toOutputString() {
    return String.format(
        "%d %s %d",
        this.evidencioniBroj,
        this.proizvodjac,
        this.godina);
  }

  public static MaticnaPloca fromInputString(String string) {
    String[] tokens = string.split(" ");
    return new MaticnaPloca(
        Integer.parseInt(tokens[0]),
        tokens[1],
        Integer.parseInt(tokens[2]));
  }
}

class Memorija extends Komponenta implements Comparable<Memorija>, OutputStringer {
  private String proizvodjac;
  private int kolocina;
  private int brzina;
  private String tip;
  private int godina;

  public Memorija(int evidencioniBroj, String proizvodjac, int kolocina, int brzina, String tip, int godina) {
    super(evidencioniBroj);
    this.proizvodjac = proizvodjac;
    this.kolocina = kolocina;
    this.brzina = brzina;
    this.tip = tip;
    this.godina = godina;
  }

  @Override
  public int compareTo(Memorija that) {
    int rezultat;

    rezultat = Objects.compare(this.proizvodjac, that.proizvodjac, String.CASE_INSENSITIVE_ORDER);
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = this.kolocina - that.kolocina;
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = this.brzina - that.brzina;
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = Objects.compare(this.tip, that.tip, String.CASE_INSENSITIVE_ORDER);
    if (rezultat != 0) {
      return rezultat;
    }

    rezultat = this.godina - that.godina;
    if (rezultat != 0) {
      return rezultat;
    }

    return 0;
  }

  @Override
  public String toOutputString() {
    return String.format(
        "%d %s %d %d %s %d",
        this.evidencioniBroj,
        this.proizvodjac,
        this.kolocina,
        this.brzina,
        this.tip,
        this.godina);
  }

  public static Memorija fromInputString(String string) {
    String[] tokens = string.split(" ");
    return new Memorija(
        Integer.parseInt(tokens[0]),
        tokens[1],
        Integer.parseInt(tokens[2]),
        Integer.parseInt(tokens[3]),
        tokens[4],
        Integer.parseInt(tokens[5]));
  }
}

class Kuciste extends Komponenta implements Comparable<Kuciste>, OutputStringer {
  private String tip;

  public Kuciste(int evidencioniBroj, String tip) {
    super(evidencioniBroj);
    this.tip = tip;
  }

  @Override
  public int compareTo(Kuciste that) {
    int rezultat;

    rezultat = Objects.compare(this.tip, that.tip, String.CASE_INSENSITIVE_ORDER);
    if (rezultat != 0) {
      return rezultat;
    }

    return 0;
  }

  @Override
  public String toOutputString() {
    return String.format(
        "%d %s",
        this.evidencioniBroj,
        this.tip);
  }

  public static Kuciste fromInputString(String string) {
    String[] tokens = string.split(" ");
    return new Kuciste(
        Integer.parseInt(tokens[0]),
        tokens[1]);
  }
}

interface SortAlgorithm {
  public void sort(Object[] niz, Comparator<Object> c);
}

class InsertionSort implements SortAlgorithm {
  @Override
  public void sort(Object[] niz, Comparator<Object> c) {
    for (int i = 1; i < niz.length; i++) {
      Object temp = niz[i];
      int j = i - 1;
      while (j >= 0 && c.compare(niz[j], temp) > 0) {
        niz[j + 1] = niz[j];
        j--;
      }
      niz[j + 1] = temp;
    }
  }

}

class SelectionSort implements SortAlgorithm {
  @Override
  public void sort(Object[] niz, Comparator<Object> c) {
    for (int i = 0; i < niz.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < niz.length; j++) {
        if (c.compare(niz[j], niz[min]) < 0) {
          min = j;
        }
      }
      Object temp = niz[min];
      niz[min] = niz[i];
      niz[i] = temp;
    }
  }
}

class Sorter {
  @SuppressWarnings("unchecked")
  public static <T> void sort(Comparable<? super T>[] niz, SortAlgorithm sortAlgorithm) {
    sortAlgorithm.sort((Object[]) niz, (Comparator<Object>) Comparator.naturalOrder());
  }

  @SuppressWarnings("unchecked")
  public static <T> void sort(T[] niz, Comparator<T> comparator, SortAlgorithm sortAlgorithm) {
    sortAlgorithm.sort(niz, (Comparator<Object>) comparator);
  }
}

class ComposableComparator<T> implements Comparator<T> {
  private Comparator<T> c1, c2;

  public ComposableComparator(Comparator<T> c1, Comparator<T> c2) {
    this.c1 = c1;
    this.c2 = c2;
  }

  @Override
  public int compare(T o1, T o2) {
    int result = c1.compare(o1, o2);

    if (result == 0) {
      return c2.compare(o1, o2);
    }

    return result;
  }

}

class ComparatorRacunarProcesor implements Comparator<Racunar> {
  @Override
  public int compare(Racunar o1, Racunar o2) {
    return Objects.compare(o1.getProcesor(), o2.getProcesor(), Comparator.naturalOrder());
  }
}

class ComparatorRacunarDisk implements Comparator<Racunar> {
  @Override
  public int compare(Racunar o1, Racunar o2) {
    return Objects.compare(o1.getDisk(), o2.getDisk(), Comparator.naturalOrder());
  }
}

class ComparatorRacunarMaticnaPloca implements Comparator<Racunar> {
  @Override
  public int compare(Racunar o1, Racunar o2) {
    return Objects.compare(o1.getMaticnaPloca(), o2.getMaticnaPloca(), Comparator.naturalOrder());
  }
}

class ComparatorRacunarMemorija implements Comparator<Racunar> {
  @Override
  public int compare(Racunar o1, Racunar o2) {
    return Objects.compare(o1.getProcesor(), o2.getProcesor(), Comparator.naturalOrder());
  }
}

class ComparatorRacunarKuciste implements Comparator<Racunar> {
  @Override
  public int compare(Racunar o1, Racunar o2) {
    return Objects.compare(o1.getKuciste(), o2.getKuciste(), Comparator.naturalOrder());
  }
}

class ComparatorProcOpMemOpDiskRa extends ComposableComparator<Racunar> {
  public ComparatorProcOpMemOpDiskRa() {
    super(new ComparatorRacunarProcesor().reversed(),
        new ComposableComparator<Racunar>(new ComparatorRacunarMemorija().reversed(), new ComparatorRacunarDisk()));
  }
}

class ComparatorMatRaDiskOpKucOp extends ComposableComparator<Racunar> {
  public ComparatorMatRaDiskOpKucOp() {
    super(new ComparatorRacunarMaticnaPloca(), new ComposableComparator<Racunar>(new ComparatorRacunarDisk().reversed(),
        new ComparatorRacunarKuciste().reversed()));
  }
}

class ComparatorMemRaProcRaDiskOpMatOp extends ComposableComparator<Racunar> {
  public ComparatorMemRaProcRaDiskOpMatOp() {
    super(new ComposableComparator<Racunar>(new ComparatorRacunarMemorija(), new ComparatorRacunarProcesor()),
        new ComposableComparator<Racunar>(new ComparatorRacunarDisk().reversed(),
            new ComparatorRacunarMaticnaPloca().reversed()));
  }
}

package sort.prakticne_vezbe.resenje.napredno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.svetovid.Svetovid;
import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

public class UlazIzlaz {
  public static Film[] ucitaj(String fajl) {
    if (Svetovid.testIn(fajl) == false) {
      return null;
    }

    SvetovidReader in = Svetovid.in(fajl);

    int n = in.readInt();
    Film[] filmovi = new Film[n];

    for (int i = 0; i < n; i++) {
      int id = in.readInt();
      String naziv = in.readLine();
      String reditelj = in.readLine();
      filmovi[i] = new Film(id, naziv, reditelj);
    }

    in.close();

    return filmovi;
  }

  public static void ispisi(Film[] arr, String fajl) {
    if (Svetovid.testOut(fajl) == false) {
      System.out.println("Nije moguce ispisati u navedeni fajl!");
    }

    SvetovidWriter out = Svetovid.out(fajl);

    out.println(arr.length);

    for (Film f : arr) {
      out.println(f.getId());
      out.println(f.getNaziv());
      out.println(f.getReditelj());
    }

    out.close();
  }

  public static Film[] ucitajBufferedReader(String fajl) {
    File file = new File(fajl);

    Film[] filmovi = null;
    /*
     * Ako koristite ovaj metod za otvaranje stream-ova, ocekuje se od studenta
     * da u komentarima objasni kako taj metod radi i zasto moze da se koristi.
     */
    try (
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader reader = new BufferedReader(isr);) {

      int n = Integer.parseInt(reader.readLine());
      filmovi = new Film[n];

      for (int i = 0; i < n; i++) {
        int id = Integer.parseInt(reader.readLine());
        String naziv = reader.readLine().stripTrailing();
        String reditelj = reader.readLine().stripTrailing();
        filmovi[i] = new Film(id, naziv, reditelj);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return filmovi;
  }

  public static void ispisiBufferedWriter(Film[] arr, String fajl) {
    File file = new File(fajl);

    /*
     * Ako koristite ovaj metod za otvaranje stream-ova, ocekuje se od studenta
     * da u komentarima objasni kako taj metod radi i zasto moze da se koristi.
     */
    try (
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter writer = new BufferedWriter(osw);) {
      writer.write(Integer.toString(arr.length));
      writer.write("\n");

      for (Film f : arr) {
        writer.write(Integer.toString(f.getId()));
        writer.write("\n");
        writer.write(f.getNaziv());
        writer.write("\n");
        writer.write(f.getReditelj());
        writer.write("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Film[] ucitajPrinceton(String fajl) {
    In in = new In(fajl);
    if (!in.exists()) {
      return null;
    }

    int n = in.readInt();
    Film[] filmovi = new Film[n];

    for (int i = 0; i < n; i++) {
      int id = in.readInt();
      String naziv = in.readLine();
      String reditelj = in.readLine();
      filmovi[i] = new Film(id, naziv, reditelj);
    }

    in.close();

    return filmovi;
  }

  public static void ispisiPrinceton(Film[] arr, String fajl) {
    Out out = new Out(fajl);

    out.println(arr.length);
    for (Film f : arr) {
      out.println(f.getId());
      out.println(f.getNaziv());
      out.println(f.getReditelj());
    }

    out.close();
  }
}

package galerija;
import java.time.LocalDate;
import java.time.Month;

import eksponati.*;
import galerija.Galerija;

public class probaGalerije {
    public static void main(String[] args) {
        Galerija galerija = new Galerija(15);
        Skulptura kraljevicMarko = new Skulptura();
        kraljevicMarko.setAutor("ivan Mestrovic");
        kraljevicMarko.setNaziv("Kraljevic Marko");
        kraljevicMarko.setMaterijal(Materijal.BRONZA);
        kraljevicMarko.setDatumPrijema(LocalDate.of(2019, Month.DECEMBER, 17));
        kraljevicMarko.setCena(100000);
        System.out.println(kraljevicMarko);

        Slika iMiTrudimsja = new Slika();
        iMiTrudimsja.setAutor("nikolas roerich");
        iMiTrudimsja.setNaziv("And we Labor");
        iMiTrudimsja.setDatumPrijema(LocalDate.of(2020, Month.DECEMBER,17));
        iMiTrudimsja.setCena(98000);
        System.out.println(iMiTrudimsja);

        galerija.unesiEksponat(kraljevicMarko);
        galerija.unesiEksponat(iMiTrudimsja);

        galerija.uvediPopust(10);
        System.out.println(galerija);

        Skulptura[] niz = galerija.vratiNajskupljeSkulpture();

        System.out.println("NAJSKUPLJE SKULPTURE:");
        for (Skulptura skulptura : niz) {
            System.out.println(skulptura);            
        }

        




        
    }
    
}

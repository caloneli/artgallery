package galerija;

import java.time.LocalDate;

import eksponati.*;

public class Galerija {
    private Eksponat[] eksponati;

    public Galerija(int brEksponata) {
        if (brEksponata <= 0 || brEksponata > 1000)
            eksponati = new Eksponat[100];
        else
            eksponati = new Eksponat[brEksponata];
    }

    public void unesiEksponat(Eksponat e) {
        if (e == null) {
            System.out.println("Pokusali ste da unesete null!");
            return;
        } else {
            for (int i = 0; i < eksponati.length; i++) {
                if (eksponati[i] != null && eksponati[i].equals(e)) {
                    System.out.println("Eksponat: " + e.getNaziv() + " se vec nalazi u galeriji!");
                    return;
                }
            }
        }
        for (int i = 0; i < eksponati.length; i++) {
            if (eksponati[i] == null) {
                eksponati[i] = e;
                System.out.println("Uspesno ste uneli ekponat: " + e.getNaziv());
                return;
            }
        }
        System.out.println("Galerija je puna!");
    }

    public void uvediPopust(double popust) {
        int prethodnaGodina = LocalDate.now().getYear() - 1;
        for (Eksponat eksponat : eksponati) {
            if (eksponat != null && eksponat.getDatumPrijema().getYear() == prethodnaGodina) {
                double novaCena = eksponat.getCena() * (100 - popust) / 100;
                eksponat.setCena(novaCena);
            }
        }
    }

    public Skulptura[] vratiNajskupljeSkulpture() {
        Skulptura[] nizNajskupljih = new Skulptura[2];

        // PRVI PROLAZAK KROZ FOR
        int indeksMaksimuma = -1;
        for (int i = 0; i < eksponati.length; i++) {
            if (eksponati[i] != null && eksponati[i] instanceof Skulptura
                    && ((Skulptura) eksponati[i]).getMaterijal().equals(Materijal.BRONZA))
                if (indeksMaksimuma == -1 || eksponati[indeksMaksimuma].getCena() < eksponati[i].getCena())
                    indeksMaksimuma = i;
        }
        if (indeksMaksimuma != -1)
            nizNajskupljih[0] = (Skulptura) eksponati[indeksMaksimuma];
        else
            return nizNajskupljih; // Ne idi u drugu for petlju
                                   // jer nema skulptura od bronze

        // DRUGI PROLAZAK KROZ FOR, UZ MALU IZMENU
        int prethodniMaksimum = indeksMaksimuma;
        indeksMaksimuma = -1;
        for (int i = 0; i < eksponati.length; i++) {
            // Sada proveravamo i da li ta skulptura nije vec u nizu
            if (eksponati[i] != null && eksponati[i] instanceof Skulptura
                    && ((Skulptura) eksponati[i]).getMaterijal().equals(Materijal.BRONZA) && i != prethodniMaksimum)
                if (indeksMaksimuma == -1 || eksponati[indeksMaksimuma].getCena() < eksponati[i].getCena())
                    indeksMaksimuma = i;
        }
        if (indeksMaksimuma != -1)
            nizNajskupljih[1] = (Skulptura) eksponati[indeksMaksimuma];

        return nizNajskupljih;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Eksponat eksponat : eksponati) {
            if (eksponat != null)
                sb.append("\n\t " + eksponat);
        }
        return "Galerija { " + sb.toString() + "\n}";

    }
}

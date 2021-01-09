package eksponati;

import java.time.LocalDate;

public abstract class Eksponat {
    private String naziv;
    private String autor;
    private double cena;
    private LocalDate datumPrijema;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if (naziv.isEmpty() || naziv == null)
            System.out.println("greska, unesite naziv");
        else
            this.naziv = naziv;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor.isEmpty() || autor == null)
            System.out.println("unesite autora");
        else
            this.autor = autor;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public LocalDate getDatumPrijema() {
        return datumPrijema;
    }

    public void setDatumPrijema(LocalDate datumPrijema) {
        if (datumPrijema == null || datumPrijema.isAfter(LocalDate.now()))
            System.out.println("greska, pogresan datum");
        else
            this.datumPrijema = datumPrijema;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Eksponat))
            return false;
        
        Eksponat e = (Eksponat) obj;
        if(this.getNaziv().equals(e.getNaziv()) && this.getNaziv().equals(e.getNaziv()))
            return true;
        
        return false;
    }    

    @Override
    public String toString() {
        return "Naziv: "+ naziv +"\nAutor: "+ autor +"\nCena: "+ cena +"\nDatum prijema: "+ datumPrijema.toString();
    }

}
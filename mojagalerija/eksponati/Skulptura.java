package eksponati;

public class Skulptura extends Eksponat{
    private Materijal materijal;

    public Materijal getMaterijal() {
        return materijal;
    }

    public void setMaterijal(Materijal materijal) {
        this.materijal = materijal;
    }
    
    @Override
    public String toString() {
        
        return "SKULPTURA {\n\t" + super.toString() + "\n}";
    }

    
}

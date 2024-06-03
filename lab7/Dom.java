import java.time.LocalDate;
public final class Dom extends Nieruchomość{
    private int powierzchniaDzialki;
    public Dom(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, int powierzchnia, int cena, LocalDate data, int powierzchniaDzialki){
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, data);
        this.powierzchniaDzialki = powierzchniaDzialki;
    }
    public int getPowierzchniaDzialki(){
        return this.powierzchniaDzialki;
    }
    @Override
    public String toString(){
        return super.toString() + " powierzchnia dzialki: " + this.powierzchniaDzialki;
    }
}
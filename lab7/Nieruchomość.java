import java.time.LocalDate;
public abstract sealed class Nieruchomość permits Mieszkanie, Dom{
    protected String ulica;
    protected int numerDomu;
    protected String miejscowosc;
    protected String kodPocztowy;
    protected int powierzchnia;
    protected int cena;
    protected LocalDate data;
    public Nieruchomość(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, int powierzchnia, int cena, LocalDate data){
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.data = data;
    }   
    public String getUlica(){
        return this.ulica;
    }
    public int getNumerDomu(){
        return this.numerDomu;
    }
    public String getMiejscowosc(){
        return this.miejscowosc;
    }
    public String getKodPocztowy(){
        return this.kodPocztowy;
    }
    public int getPowierzchnia(){
        return this.powierzchnia;
    }
    public int getCena(){
        return this.cena;
    }
    public LocalDate getData(){
        return this.data;
    }
    @Override
    public String toString(){
        return "Ulica: " + this.ulica + " numer domu: " + this.numerDomu + " miejscowosc: " + this.miejscowosc + " kod pocztowy: " + this.kodPocztowy + " powierzchnia: " + this.powierzchnia + " cena: " + this.cena + " data: " + this.data;
    }
}
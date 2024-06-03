import java.time.LocalDate;

public final class Mieszkanie extends Nieruchomość{
    private int numerMieszkania;
    private int numerPietra;

    public Mieszkanie(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, int powierzchnia, int cena, LocalDate data, int numerMieszkania, int numerPietra){
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, data);
        this.numerMieszkania = numerMieszkania;
        this.numerPietra = numerPietra;
    }
    public int getNumerMieszkania(){
        return this.numerMieszkania;
    }
    public int getNumerPietra(){
        return this.numerPietra;
    }
    @Override
    public String toString(){
        return super.toString() + " numer mieszkania: " + this.numerMieszkania + " numer pietra: " + this.numerPietra;
    }
}
import java.util.ArrayList;
import java.util.function.Predicate;
import java.time.LocalDate;
public class ListaOfert{
    private ArrayList<Nieruchomość> oferty = new ArrayList<>();

    public void addOffer(Nieruchomość nieruchomość){
        oferty.add(nieruchomość);
    }

    public void addOffer(Mieszkanie mieszkanie){
        oferty.add(mieszkanie);
    }

    public void addExampleOffers(){
        for(int i = 0; i <5; i++){
            oferty.add(new Dom("ulica"+i, i+1, "miejscowosc"+i, "kod"+i, i+1, i+1, LocalDate.parse("2026-10-15"), i+1));
        }
        for(int i = 0; i <7; i++){
            oferty.add(new Mieszkanie("ulica"+i, i+1, "miejscowosc"+i, "kod"+i, i+1, i+1, LocalDate.parse("2026-10-15"), i+1, i+1));
        }
    }

    public ArrayList<Nieruchomość> filterBy(Predicate<Nieruchomość> predicate){
        ArrayList<Nieruchomość> wynik = new ArrayList<>();
        LocalDate data = LocalDate.now();
        for(Nieruchomość nieruchomość : oferty){
            if(predicate.test(nieruchomość) && (nieruchomość.getData().isAfter(data) || nieruchomość.getData().isEqual(data))){
                wynik.add(nieruchomość);
            }
        }
        return wynik;
    }
}
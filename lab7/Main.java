import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main{
    private static void printMenu(){
        System.out.println("0. Dodaj losowe oferty");
        System.out.println("1. Dodaj oferte sprzedazy domu");
        System.out.println("2. Dodaj oferte sprzedazy mieszkania");
        System.out.println("3. Wyswietl oferty sprzedazy domow");
        System.out.println("4. Wyświetl oferty sprzedazy mieszkan");
        System.out.println("5. Wyświetl oferty domow w danej miejscowosci o danej minimalnej powierzchni");
        System.out.println("6. Wyświetl oferty mieszkań w danej miejscowosci, nie droższych niż podana cena i od podanego pietra wzwyż");
        System.out.println("7. Wyjscie");
    }
    private static void case0(ListaOfert listaOfert){
        listaOfert.addExampleOffers();
    }
    private static void case1(ListaOfert listaOfert, Scanner scanner){
        System.out.println("Podaj ulice: ");
        String ulica = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Podaj numer domu: ");
        int numer_domu = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj miejscowosc: ");
        String miejscowosc = scanner.nextLine();
        System.out.println("Podaj kod pocztowy: ");
        String kod_pocztowy = scanner.nextLine();
        System.out.println("Podaj powierzchnie (liczba calkowita w m): ");
        int powierzchnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj cene (liczba całkowita): ");
        int cena = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj date (format yyyy-mm-dd): ");
        String data = scanner.nextLine();
        System.out.println("Podaj powierzchnie działki (liczba calkowita w m): ");
        int powierzchnia_dzialki = scanner.nextInt();
        scanner.nextLine();
        Dom dom = new Dom(ulica, numer_domu, miejscowosc, kod_pocztowy, powierzchnia, cena, LocalDate.parse(data), powierzchnia_dzialki);
        listaOfert.addOffer(dom);
    }
    private static void case2(ListaOfert listaOfert, Scanner scanner){
        System.out.println("Podaj ulice: ");
        String ulica = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Podaj numer domu: ");
        int numer_domu = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj miejscowosc: ");
        String miejscowosc = scanner.nextLine();
        System.out.println("Podaj kod pocztowy: ");
        String kod_pocztowy = scanner.nextLine();
        System.out.println("Podaj powierzchnie (liczba calkowita w m): ");
        int powierzchnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj cene (liczba całkowita): ");
        int cena = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj date (format yyyy-mm-dd): ");
        String data = scanner.nextLine();
        System.out.println("Podaj numer mieszkania: ");
        int numer_mieszkania = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj numer pietra: ");
        int numer_pietra = scanner.nextInt();
        scanner.nextLine();
        Mieszkanie mieszkanie = new Mieszkanie(ulica, numer_domu, miejscowosc, kod_pocztowy, powierzchnia, cena, LocalDate.parse(data), numer_mieszkania, numer_pietra);
        listaOfert.addOffer(mieszkanie);
    }
    private static void case3(ListaOfert listaOfert){
        ArrayList<Nieruchomość> oferty = listaOfert.filterBy( e -> e instanceof Dom);
        for (Nieruchomość oferta : oferty) {
            System.out.println("Oferta sprzedaży domow: " + oferta.toString());
        }
    }
    private static void case4(ListaOfert listaOfert){
        ArrayList<Nieruchomość> oferty = listaOfert.filterBy( e -> e instanceof Mieszkanie);
        for (Nieruchomość oferta : oferty) {
            System.out.println("Oferta sprzedaży mieszkań: " + oferta.toString());
        }
    }
    private static void case5(ListaOfert listaOfert, Scanner scanner){
        System.out.println("Podaj miejscowosc: ");
        String miejscowosc = scanner.next();
        System.out.println("Podaj minimalna powierzchnie (liczba calkowita w m): ");
        int powierzchnia = scanner.nextInt();
        ArrayList<Nieruchomość> oferty = listaOfert.filterBy( e -> e instanceof Dom && e.getMiejscowosc().equals(miejscowosc) && e.getPowierzchnia() >= powierzchnia);
        for (Nieruchomość oferta : oferty) {
            System.out.println("Oferta sprzedaży domow w miejscowosci " + miejscowosc + " o powierzchni co najmniej " + powierzchnia + " m: " + oferta.toString());
        }
    }
    private static void case6(ListaOfert listaOfert, Scanner scanner){
        System.out.println("Podaj miejscowosc: ");
        String miejscowosc = scanner.next();
        System.out.println("Podaj cene (liczba całkowita): ");
        int cena = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj numer pietra: ");
        int numer_pietra = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Nieruchomość> oferty = listaOfert.filterBy( e -> e instanceof Mieszkanie && e.getMiejscowosc().equals(miejscowosc) && e.getCena() <= cena && ((Mieszkanie) e).getNumerPietra() >= numer_pietra);
        for (Nieruchomość oferta : oferty) {
            System.out.println("Oferta sprzedaży mieszkań w miejscowosci " + miejscowosc + " nie droższych niż " + cena + " i od pietra " + numer_pietra + " wzwyż: " + oferta.toString());
        }
    }
    public static void main(String[] args){
        System.out.println("Program służy do dodawania ofert sprzedaży nieruchomości");
        Scanner scanner = new Scanner(System.in);
        ListaOfert listaOfert = new ListaOfert();
        boolean program = true;
        while(program){
            printMenu();
            int wybor = scanner.nextInt();
            switch(wybor) {
                case 0 -> { case0(listaOfert);}
                case 1 -> { case1(listaOfert, scanner);}
                case 2 -> { case2(listaOfert, scanner);}
                case 3 -> { case3(listaOfert);}
                case 4 -> { case4(listaOfert);}
                case 5 -> { case5(listaOfert, scanner);}
                case 6 -> { case6(listaOfert, scanner);}
                case 7 -> { program = false;}
            }
        }
    }
}
import java.util.Scanner;
import java.time.LocalTime;
import java.util.ArrayList;
public class Main{
    private static void printMenu(){
        System.out.println("1) Dodaj spotkanie na wybrany dzien");
        System.out.println("2) Dodaj zadanie lub spotkanie na wybrany dzien");
        System.out.println("3) Usuń spotkanie z wybranego dnia");
        System.out.println("4) Usuń zadanie z wybranego dnia");
        System.out.println("5) Wyświetl spotkania z danego dnia(lambda)");
        System.out.println("6) Wyświetl zadania z danego dnia(lambda)");
        System.out.println("7) Wyświetl spotkania z danego dnia o danym priorytecie (lambda)");
        System.out.println("8) Wyświetl zadania z danego dnia o danym statusie (lambda)");
        System.out.println("9) Wyświetl spotkania z danego dnia po danej godzinie (lambda)");
        System.out.println("10) Wyświetl zadania z danego dnia kończące się przed daną godziną (lambda)");
        System.out.println("11) Wygeneruj spotkanie na 7 dni");
        System.out.println("9) Wyjscie");
    }
    private static void case1(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj opis: ");
        String opis = scanner.nextLine();
        System.out.println("Podaj godzine rozpoczecia (format 00:00:00): ");
        String godzina_rozpoczecia = scanner.nextLine();
        System.out.println("Podaj godzine zakonczenia (format 00:00:00): ");
        String godzina_zakonczenia = scanner.nextLine();
        System.out.println("Podaj priorytet: ");
        String priorytet = scanner.nextLine();
        Spotkanie spotkanie = new Spotkanie(opis, LocalTime.parse(godzina_rozpoczecia), LocalTime.parse(godzina_zakonczenia), priorytet);
        kalendarz.addEvent(dzien, spotkanie);
    }
    private static void case2(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj opis: ");
        String opis = scanner.nextLine();
        System.out.println("Podaj godzine rozpoczecia (format 00:00:00): ");
        String godzina_rozpoczecia = scanner.nextLine();
        System.out.println("Podaj godzine zakonczenia (format 00:00:00): ");
        String godzina_zakonczenia = scanner.nextLine();
        System.out.println("Podaj status: ");
        String status = scanner.nextLine();
        Zadanie zadanie = new Zadanie(opis, LocalTime.parse(godzina_rozpoczecia), LocalTime.parse(godzina_zakonczenia), status);
        kalendarz.addEvent(dzien, zadanie);
    }

    private static void case3(Kalendarz kalendarz, Scanner scanner){
        String typ = "spotkanie";
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        ArrayList<Event> meetings = kalendarz.getWynik(dzien, e -> e == e );
        for (Event meeting : meetings) {
            System.out.println("Spotkanie z opisem " + meeting.toString());
        }
        System.out.println("Podaj numer spotkania od gory: ");
        int numer = scanner.nextInt();
        kalendarz.removeMeeting(dzien, numer, typ);
    }
    private static void case4(Kalendarz kalendarz, Scanner scanner){
        String typ = "zadanie";
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();        
        ArrayList<Event> meetings = kalendarz.getWynik(dzien, e -> e == e);
        for (Event meeting : meetings) {
            System.out.println("Spotkanie z opisem " + meeting.toString());
        }
        System.out.println("Podaj numer zadania od gory: ");
        int numer = scanner.nextInt();
        kalendarz.removeMeeting(dzien, numer, typ);
    }

    private static void case5(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Event> meetings = kalendarz.getWynik(dzien, e -> e instanceof Spotkanie);
        for (Event meeting : meetings) {
            System.out.println("Spotkanie z opisem " + meeting.toString());
        }
    }

    private static void case6(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Event> meetings = kalendarz.getWynik(dzien, e -> e instanceof Zadanie);
        for (Event meeting : meetings) {
            System.out.println("Zadanie z opisem " + meeting.toString());
        }
    }

    private static void case7(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj priorytet: ");
        String priorytet = scanner.nextLine();
        ArrayList<Event> meetings = kalendarz.getWynik(dzien, e -> e instanceof Spotkanie && ((Spotkanie) e).getSpotkaniePriority().equals(priorytet));
        for (Event meeting : meetings) {
            System.out.println("Spotkanie z opisem " + meeting.toString());
        }
    }

    private static void case8(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj status: ");
        String status = scanner.nextLine();
        ArrayList<Event> meetings = kalendarz.getWynik(dzien, e -> e instanceof Zadanie && ((Zadanie) e).getZadanieStatus().equals(status));
        for (Event meeting : meetings) {
            System.out.println("Zadanie z opisem " + meeting.toString());
        }
    }

    private static void case9(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj godzine (format 00:00:00): ");
        String godzina = scanner.nextLine();
        ArrayList<Event> meetings = kalendarz.getWynik(dzien, e -> e instanceof Spotkanie && e.getSpotkanieStart().compareTo(LocalTime.parse(godzina)) >= 0);
        for (Event meeting : meetings) {
            System.out.println("Spotkanie z opisem " + meeting.toString());
        }
    }

    private static void case10(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj godzine (format 00:00:00): ");
        String godzina = scanner.nextLine();
        ArrayList<Event> meetings = kalendarz.getWynik(dzien, e -> e instanceof Zadanie && e.getSpotkanieEnd().compareTo(LocalTime.parse(godzina)) <= 0);
        for (Event meeting : meetings) {
            System.out.println("Zadanie z opisem " + meeting.toString());
        }
    }
    public static void main(String[] args){
        System.out.println("Program służy do dodawania spotkan do kalendarza");
        Scanner scanner = new Scanner(System.in);
        Kalendarz kalendarz = new Kalendarz();
        boolean program = true;
        while(program){
            printMenu();
            int wybor = scanner.nextInt();
            switch(wybor) {
                case 1 -> { case1(kalendarz, scanner);}
                case 2 -> { case2(kalendarz, scanner);}
                case 3 -> { case3(kalendarz, scanner);}
                case 4 -> { case4(kalendarz, scanner);}
                case 5 -> { case5(kalendarz, scanner);}
                case 6 -> { case6(kalendarz, scanner);}
                case 7 -> { case7(kalendarz, scanner);}
                case 8 -> { case8(kalendarz, scanner);}
                case 9 -> { case9(kalendarz, scanner);}
                case 10 -> { case10(kalendarz, scanner);}
                case 11 -> { kalendarz.addSevenRandomMeetings();}
                case 12 -> { program = false;}
            }
        }
    }
} 
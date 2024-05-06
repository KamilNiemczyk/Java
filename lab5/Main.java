import java.util.Scanner;
import java.time.LocalTime;
import java.util.ArrayList;
public class Main{
    private static void printMenu(){
        System.out.println("1) Dodaj spotkanie na wybrany dzien");
        System.out.println("2) Usuń spotkanie z wybranego dnia");
        System.out.println("3) Wygeneruj spotkanie na 7 dni");
        System.out.println("4) Wyswietl spotkania z danego dnia(lambda)");
        System.out.println("5) Wyswietl spotkania z danego dnia o danym priorytecie (lambda)");
        System.out.println("6) Wyswietl spotkania z danego dnia po danej godzinie (lambda)");
        System.out.println("7) Wyswietl spotkania z danego dnia pomiedzy godzinami (lambda)");
        System.out.println("8) Wyswietl spotkania z danego dnia o danym priorytecie i po danej godzinie (lambda)");
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
        kalendarz.addMeeting(dzien, opis, LocalTime.parse(godzina_rozpoczecia), LocalTime.parse(godzina_zakonczenia), priorytet);
    }
    private static void case2(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        System.out.println("Podaj numer spotkania: ");
        int numer = scanner.nextInt();
        kalendarz.removeMeeting(dzien, numer);
    }
    private static void case3(Kalendarz kalendarz, Scanner scanner){
        kalendarz.addSevenRandomMeetings();
    }
    private static void case4(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Spotkanie> meetings = kalendarz.getWynik(dzien, e -> true);
        for (Spotkanie meeting : meetings) {
            System.out.println("Spotkanie z opisem " + meeting.getSpotkanieDescription() + " rozpoczyna sie o godzinie " + meeting.getSpotkanieStart() + " i konczy sie o godzinie " + meeting.getSpotkanieEnd() + " oraz ma priorytet " + meeting.getSpotkaniePriority());
        }
    }

    private static void case5(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj priorytet: ");
        String priorytet = scanner.nextLine();
        ArrayList<Spotkanie> meetings = kalendarz.getWynik(dzien, e -> e.getSpotkaniePriority().equals(priorytet));
        for (Spotkanie meeting : meetings) {
            System.out.println("Spotkanie z opisem " + meeting.getSpotkanieDescription() + " rozpoczyna sie o godzinie " + meeting.getSpotkanieStart() + " i konczy sie o godzinie " + meeting.getSpotkanieEnd() + " oraz ma priorytet " + meeting.getSpotkaniePriority());
        }
    }
    private static void case6(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj godzine (format 00:00:00): ");
        String godzina = scanner.nextLine();
        ArrayList<Spotkanie> meetings = kalendarz.getWynik(dzien, e -> e.getSpotkanieStart().compareTo(LocalTime.parse(godzina)) >= 0);
        for (Spotkanie meeting : meetings) {
            System.out.println("Spotkanie z opisem " + meeting.getSpotkanieDescription() + " rozpoczyna sie o godzinie " + meeting.getSpotkanieStart() + " i konczy sie o godzinie " + meeting.getSpotkanieEnd() + " oraz ma priorytet " + meeting.getSpotkaniePriority());
        }
    }
    
    private static void case7(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj godzine poczatkowa (format 00:00:00): ");
        String godzina1 = scanner.nextLine();
        System.out.println("Podaj godzine koncowa (format 00:00:00): ");
        String godzina2 = scanner.nextLine();
        ArrayList<Spotkanie> meetings = kalendarz.getWynik(dzien, e -> e.getSpotkanieStart().compareTo(LocalTime.parse(godzina1)) >= 0 && e.getSpotkanieEnd().compareTo(LocalTime.parse(godzina2)) <= 0);
        for (Spotkanie meeting : meetings) {
            System.out.println("Spotkanie z opisem " + meeting.getSpotkanieDescription() + " rozpoczyna sie o godzinie " + meeting.getSpotkanieStart() + " i konczy sie o godzinie " + meeting.getSpotkanieEnd() + " oraz ma priorytet " + meeting.getSpotkaniePriority());
        }
    }
    private static void case8(Kalendarz kalendarz, Scanner scanner){
        System.out.println("Podaj dzien: ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj priorytet: ");
        String priorytet = scanner.nextLine();
        System.out.println("Podaj godzine (format 00:00:00): ");
        String godzina = scanner.nextLine();
        ArrayList<Spotkanie> meetings = kalendarz.getWynik(dzien, e -> e.getSpotkaniePriority().equals(priorytet) && e.getSpotkanieStart().compareTo(LocalTime.parse(godzina)) >= 0);
        for (Spotkanie meeting : meetings) {
            System.out.println("Spotkanie z opisem " + meeting.getSpotkanieDescription() + " rozpoczyna sie o godzinie " + meeting.getSpotkanieStart() + " i konczy sie o godzinie " + meeting.getSpotkanieEnd() + " oraz ma priorytet " + meeting.getSpotkaniePriority());
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
                case 7 -> { case7(kalendarz,scanner);}
                case 8 -> { case8(kalendarz, scanner);}
                case 9 -> { program = false;}
            }
        }
    }
} 
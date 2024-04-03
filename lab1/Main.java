import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean program = true;
        while(program){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Suma z zakresu <a,b> - 1, Potęga 2^n - 2, Wyjście - 0");
            int wybor = scanner.nextInt();
            switch (wybor) {
                case 1 ->
                    {
                        System.out.println("Podaj od jakiej liczby: ");
                        int a = scanner.nextInt();
                        System.out.println("Podaj do jakiej liczby: ");
                        int b = scanner.nextInt();
                        System.out.println("Suma z zakresu <a,b> wynosi: " + Calculations.sum(a, b));
                    }
                case 2 ->
                    {
                        System.out.println("Podaj potege liczby 2 jaką chcesz oblcizyc: ");
                        int n = scanner.nextInt();
                        System.out.println("2 do " + n + " wynosi: " + Calculations.power(n));
                    }
                case 0 -> 
                    program = false;
            }
        }
    }
}

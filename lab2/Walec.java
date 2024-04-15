import java.util.Scanner;

public class Walec{
    private double r;
    private double h;

    public Walec(double r, double h){
        this.r = r;
        this.h = h;
    }

    public Walec(){
    }

    public void setR(double r){
        this.r = r;
    }

    public void setH(double h){
        this.h = h;
    }

    public double getR(){
        return r;
    }

    public double getH(){
        return h;
    }
    
    public double polePodstawy(){
        return Math.PI * Math.pow(r, 2);
    }
    
    public double poleBoczne(){
        return 2 * Math.PI * r * h;
    }

    public double polePowierzchni(){
        return 2 * polePodstawy() + poleBoczne();
    }

    public double objetosc(){
        return polePodstawy() * h;
    }

    public static void main(String[] args){
        Walec walec = new Walec();
        Scanner scanner = new Scanner(System.in);
        boolean program = true;
        System.out.println("Program oblicza właściwości walca na podstawie podanych danych");
        while(program){
            System.out.println("Podaj opcje:");
            System.out.println("Wyswietl wartosc zmiennej - 1");
            System.out.println("Ustaw wartosc zmiennej - 2");
            System.out.println("Pole podstawy - 3");
            System.out.println("Pole boczne - 4");
            System.out.println("Pole powierzchni - 5");
            System.out.println("Objetosc - 6");
            System.out.println("Wyjscie - 7");
            int wybor = scanner.nextInt();
            switch (wybor) {
                case 1 -> {
                    System.out.println("r = " + walec.getR());
                    System.out.println("h = " + walec.getH());
                }
                case 2 -> {
                    System.out.println("Podaj r: ");
                    walec.setR(scanner.nextDouble());
                    System.out.println("Podaj h: ");
                    walec.setH(scanner.nextDouble());
                }
                case 3 -> {
                    System.out.println("Pole podstawy wynosi: " + walec.polePodstawy());
                }
                case 4 -> {
                    System.out.println("Pole boczne wynosi: " + walec.poleBoczne());
                }
                case 5 -> {
                    System.out.println("Pole powierzchni wynosi: " + walec.polePowierzchni());
                }
                case 6 -> {
                    System.out.println("Objetosc wynosi: " + walec.objetosc());
                }
                case 7 -> {
                    program = false;
        }
    }
    }
}
}
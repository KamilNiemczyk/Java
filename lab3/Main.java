import java.util.Scanner;


public class Main{
    private static void printMenu(){
        System.out.println("1) Dodaj ocene");
        System.out.println("2) Wylicz srednia ocen");
        System.out.println("3) Znajdz najwieksza ocene");
        System.out.println("4) Znajdz najmniejsza ocene");
        System.out.println("5) Wyjscie");
    }
    private static void case1(GradeList gradeList, Scanner scanner){
        System.out.println("Podaj ocene zmiennoprzecinkowa:");
        gradeList.addGrade(scanner.nextDouble());
    }
    private static void case2(GradeList gradeList){
        System.out.println("Srednia ocen: ");
        System.out.println(gradeList.meanGrades());
    }
    private static void case3(GradeList gradeList){
        System.out.println("Najwieksza ocena: ");
        System.out.println(gradeList.maxGrade());
    }
    private static void case4(GradeList gradeList){
        System.out.println("Najmniejsza ocena: ");
        System.out.println(gradeList.minGrade());
    }
    public static void main(String[] args){
        GradeList gradeList = new GradeList();
        System.out.println("Program słuzy do dodawania ocen do listy i sprawdzania jej wlasciwosci");
        Scanner scanner = new Scanner(System.in);
        boolean program = true;
        while(program){
            printMenu();
            int wybor = scanner.nextInt();
            switch(wybor) {
                case 1 -> { case1(gradeList, scanner);}
                case 2 -> { case2(gradeList);}
                case 3 -> { case3(gradeList);}
                case 4 -> { case4(gradeList);}
                case 5 -> { program = false;}
            }
        }
    }
} 
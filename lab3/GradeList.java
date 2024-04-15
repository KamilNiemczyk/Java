import java.util.ArrayList;

public class GradeList{
    private ArrayList<Double> lista = new ArrayList<Double>();

    public void addGrade(double grade){
        lista.add(grade);
    }

    public String meanGrades(){
        if(lista.size() == 0){
            return "Brak wystarczającej ilości ocen";
        }else{
            double akum = lista.get(0);
            for(int i = 1; i<lista.size(); i++){
                akum += lista.get(i);
            }
            return String.valueOf(akum / lista.size());
        }
    }

    public String maxGrade(){
        if(lista.size() == 0){
            return "Nie ma żadnej oceny dodanej";
        }else{
            double akum = lista.get(0);
            for(double grade : lista){
                if(grade > akum){
                    akum = grade;
                }
            }
            return String.valueOf(akum);
        }    
    }

    public String minGrade(){
        if(lista.size() == 0){
            return "Nie ma żadnej oceny dodanej";
        }else{
            double akum = lista.get(0);
            for(double grade : lista){
                if(grade < akum){
                    akum = grade;
                }
            }
            return String.valueOf(akum);
        } 
    }
}
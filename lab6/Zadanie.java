import java.time.LocalTime;
public final class Zadanie extends Event{
    private String status;
    public Zadanie(String description, LocalTime startTime, LocalTime endTime, String status){
        super(description, startTime, endTime);
        if(status.equals("planowane") || status.equals("potwierdzone") || status.equals("realizowane") || status.equals("wykonane")){
            this.status = status;
        }else{
            this.status = "planowane";
        }
    }
    public String getZadanieStatus(){
        return this.status;
    }
    @Override
    public String toString(){
        return "Zadanie: "+this.description+" od "+this.startTime+" do "+this.endTime+" ze statusem "+this.status;
    }
}
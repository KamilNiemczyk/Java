import java.time.LocalTime;

public final class Spotkanie extends Event{
    private String priority;

    public Spotkanie(String description, LocalTime startTime, LocalTime endTime, String priority){
        super(description, startTime, endTime);
        if(priority.equals("normalny") || priority.equals("wysoki") || priority.equals("najwyzszy")){
            this.priority = priority;
        }else{
            this.priority = "normalny";
        }
    }
    public String getSpotkaniePriority(){
        return this.priority;
    }
    @Override
    public String toString(){
        return "Spotkanie: "+this.description+" od "+this.startTime+" do "+this.endTime+" z priorytetem "+this.priority;
    }
}
import java.time.LocalTime;

public class Spotkanie{
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priority;
    private static final LocalTime MIN_START = LocalTime.parse("07:00:00");

    public Spotkanie(String description, LocalTime startTime, LocalTime endTime, String priority){
        this.description = description;
        this.endTime = endTime;
        this.priority = priority;
        if(startTime.isBefore(MIN_START)){
            this.startTime = MIN_START;
        }else{
            this.startTime = startTime;
        }
        if(endTime.isBefore(startTime)){
            this.endTime = startTime;
        }else{
            this.endTime = endTime;
        }
        if(priority.equals("normalny") || priority.equals("wysoki") || priority.equals("najwyzszy")){
            this.priority = priority;
        }else{
            this.priority = "normalny";
        }
    }
    public String getSpotkanieDescription(){
        return this.description;
    }
    public LocalTime getSpotkanieStart(){
        return this.startTime;
    }
    public LocalTime getSpotkanieEnd(){
        return this.endTime;
    }
    public String getSpotkaniePriority(){
        return this.priority;
    }
}
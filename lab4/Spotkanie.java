import java.time.LocalTime;

public class Spotkanie{
    private String description;
    private LocalTime starttime;
    private LocalTime endtime;
    private String priority;
    private static final LocalTime min_start = LocalTime.parse("07:00:00");

    public Spotkanie(String description, LocalTime starttime, LocalTime endtime, String priority){
        this.description = description;
        this.endtime = endtime;
        this.priority = priority;
        if(starttime.isBefore(min_start)){
            this.starttime = min_start;
        }else{
            this.starttime = starttime;
        }
        if(endtime.isBefore(starttime)){
            this.endtime = starttime;
        }else{
            this.endtime = endtime;
        }
        if(priority.equals("normalny") || priority.equals("wysoki") || priority.equals("najwyższy")){
            this.priority = priority;
        }else{
            this.priority = "normalny";
        }
    }
    public String getSpotkanieDescription(){
        return this.description;
    }
    public LocalTime getSpotkanieStart(){
        return this.starttime;
    }
    public LocalTime getSpotkanieEnd(){
        return this.endtime;
    }
    public String getSpotkaniePriority(){
        return this.priority;
    }
}
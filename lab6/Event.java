import java.time.LocalTime;
public abstract sealed class Event permits Spotkanie, Zadanie{
    protected String description;
    protected LocalTime startTime;
    protected LocalTime endTime;

    public Event(String description, LocalTime startTime, LocalTime endTime){
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
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
}
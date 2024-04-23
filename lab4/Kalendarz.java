import java.time.LocalTime;
import java.util.ArrayList;
public class Kalendarz{
    private ArrayList<Spotkanie>[] tydzien = new ArrayList[7];

    public Kalendarz(){
        for(int i = 0; i < 7; i++){
            tydzien[i] = new ArrayList<Spotkanie>();
        }
    }
    
    public void addMeeting(int day, String description, LocalTime starttime, LocalTime endtime, String priority){
        tydzien[day-1].add(new Spotkanie(description, starttime, endtime, priority));
    }

    public void removeMeeting(int day, int index){
        tydzien[day-1].remove(index-1);
    }

    public ArrayList<Spotkanie> getAllMeetings(int day){
        return tydzien[day-1];
    }

    public ArrayList<Spotkanie> getAllMeetingsByPriority(int day, String priority){
        ArrayList<Spotkanie> meetings = tydzien[day-1];
        ArrayList<Spotkanie> result = new ArrayList<>();
        for(int i = 0; i < meetings.size(); i++){
            if(meetings.get(i).getSpotkaniePriority().equals(priority)){
                result.add(meetings.get(i));
            }
        }
        return result;
    }
    public ArrayList<Spotkanie> getAllMeetingsAfterTime(int day, LocalTime time){
        ArrayList<Spotkanie> meetings = tydzien[day-1];
        ArrayList<Spotkanie> result = new ArrayList<>();
        for(int i = 0; i < meetings.size(); i++){
            if(!meetings.get(i).getSpotkanieStart().isBefore(time)){
                result.add(meetings.get(i));
            }
        }
        return result;
    }

    public void addSevenRandomMeetings(){
        for(int i = 0; i < 7; i++){
            if(i%2 == 0){
                tydzien[i].add(new Spotkanie("Spotkanie "+(i+1), LocalTime.parse("09:00:00"), LocalTime.parse("12:00:00"), "normalny"));
            }else{
                tydzien[i].add(new Spotkanie("Spotkanie "+(i+1), LocalTime.parse("11:00:00"), LocalTime.parse("14:00:00"), "wysoki"));
            }
        }
        tydzien[0].add(new Spotkanie("Spotkanie 8", LocalTime.parse("07:00:00"), LocalTime.parse("10:00:00"), "najwyższy"));
        tydzien[0].add(new Spotkanie("Spotkanie 9", LocalTime.parse("18:00:00"), LocalTime.parse("20:00:00"), "normalny"));
    }
}
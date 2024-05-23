import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;
public class Kalendarz{
    private ArrayList<Event>[] tydzien = new ArrayList[7];

    public Kalendarz(){
        for(int i = 0; i < 7; i++){
            tydzien[i] = new ArrayList<Event>();
        }
    }
    
    public void addEvent(int day, Zadanie zadanie){
        tydzien[day-1].add(zadanie);
    }
    public void addEvent(int day, Spotkanie spotkanie){
        tydzien[day-1].add(spotkanie);
    }

    public void removeMeeting(int day, int index, String typ){
        if (typ.equals("spotkanie") && tydzien[day-1].get(index-1) instanceof Spotkanie)
            tydzien[day-1].remove(index-1);
        else if (typ.equals("zadanie") && tydzien[day-1].get(index-1) instanceof Zadanie)
            tydzien[day-1].remove(index-1);
        else
            System.out.println("Wybrany zły typ eventu!");
    }

    public void addSevenRandomMeetings(){
        for(int i = 0; i < 7; i++){
            if(i%2 == 0){
                tydzien[i].add(new Spotkanie("Event "+(i+1), LocalTime.parse("09:00:00"), LocalTime.parse("12:00:00"), "normalny"));
            }else{
                tydzien[i].add(new Spotkanie("Event "+(i+1), LocalTime.parse("11:00:00"), LocalTime.parse("14:00:00"), "wysoki"));
            }
        }
        tydzien[0].add(new Spotkanie("Event 8", LocalTime.parse("07:00:00"), LocalTime.parse("10:00:00"), "najwyzszy"));
        tydzien[0].add(new Spotkanie("Event 9", LocalTime.parse("18:00:00"), LocalTime.parse("20:00:00"), "normalny"));
    }

    public ArrayList<Event> getWynik (int dzien, Predicate<Event> predicate){
        ArrayList<Event> meetings = new ArrayList<>();
        for (Event meeting : tydzien[dzien-1]) {
            if(predicate.test(meeting)){
                meetings.add(meeting);
            }
        }
        return meetings;
    }
}
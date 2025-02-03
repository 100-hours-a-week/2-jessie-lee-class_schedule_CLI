import java.util.HashMap;
import java.util.Map;

public class TimetableManager {
    private Map<Day, Map<Integer, String>> timetable;

    public TimetableManager() {
        this.timetable = new HashMap<>();
        for (Day day : Day.values()) {
            this.timetable.put(day, new HashMap<>());
        }
    }

    public boolean isAvailable(Day day, int time, String childName) {
        return !this.timetable.get(day).containsKey(time);
    }

    public void addSchedule(Day day, int time, String childName) {
        this.timetable.get(day).put(time, childName);
    }

    public void printTimetable() {
        System.out.println("\n    MON    TUE    WED    THU    FRI");
        System.out.println("----------------------------------");
        for (int hour = 1; hour <= 5; hour++) {
            System.out.printf("%2d시 |", hour);
            for (Day day : Day.values()) {
                String name = timetable.get(day).getOrDefault(hour, "");
                System.out.printf(" %6s ", name);
            }
            System.out.println();
        }
    }
}

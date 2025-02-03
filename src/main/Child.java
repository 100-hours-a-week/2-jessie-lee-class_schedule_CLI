public class Child {
    private String name;
    private Day classDay;
    private byte classTime;

    Child(String name) {
        this.name = name;
    }

    public void addSchedule(Day day, byte time) {
        this.classDay = day;
        this.classTime = time;
    }

    public String getName() {
        return this.name;
    }
}

package model;

public class Child {
    private String name;
    private Day classDay;
    private int classTime;

    Child(String name) {
        this.name = name;
    }

    public void setSchedule(Day day, int time) {
        this.classDay = day;
        this.classTime = time;
    }

    public String getName() {
        return this.name;
    }
}

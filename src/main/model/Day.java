package model;

public enum Day {
    MON("월"), TUE("화"), WED("수"), THU("목"), FRI("금");

    private final String korean;

    Day(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }

    public static Day fromKorean(String korean) {
        for (Day day : values()) {
            if (day.korean.equals(korean)) {
                return day;
            }
        }
        throw new IllegalArgumentException("올바른 요일이 아닙니다: " + korean);
    }
}
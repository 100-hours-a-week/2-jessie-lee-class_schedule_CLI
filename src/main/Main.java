import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Parent> parents = new ArrayList<>();
        Timetable timetable = new Timetable();

        while(true){
            String parentName = inputView.getParentName();
            Parent parent = parents.stream()
                    .filter(p -> p.getName().equalsIgnoreCase(parentName))
                    .findFirst()
                    .orElse(null);


            if(parent == null) {
                String signinAnswer = inputView.askIfSign();
                if (signinAnswer.equalsIgnoreCase("y")) {
                    // 학부모 등록
                    parent = new Parent(parentName);
                    parents.add(parent);

                    // 자녀 등록
                    String[] childNames = inputView.getChildrenNames();
                    for (String childName : childNames) {
                        String childNameTrimmed = childName.trim();
                        parent.addChild(childNameTrimmed);
                    }
                } else {
                    // TODO : 다시 입력 받기
                    System.out.println("프로그램이 종료됩니다.");
                    break;
                }
            }

            timetable.printTimetable();

            String childName = inputView.getChildName();
            Child child = parent.getChildren().stream()
                    .filter(c -> c.getName().equalsIgnoreCase(childName))
                    .findFirst()
                    .orElse(null);

            if (child == null) {
               String signInChildAnswer = inputView.askIfChildSign();
                if (signInChildAnswer.equalsIgnoreCase("y")) {
                    parent.addChild(childName);
                    child = parent.getChildByName(childName);
                } else {
                    // TODO : 다시 입력 받기
                    System.out.println("프로그램이 종료됩니다.");
                    break;
                }
            }

            String[] scheduleInput = inputView.askDayTime();

            Day day = Day.fromKorean(scheduleInput[0]);
            int time = Integer.parseInt(scheduleInput[1].replace("시", ""));

            if (!timetable.isAvailable(day, time, child.getName())) {
                System.out.println("해당 시간에는 이미 등록된 학생이 있습니다. 다시 입력해주세요.");
                // TODO : 다시 입력받기
                continue;
            }else {
                timetable.addSchedule(day, time, child.getName());
                child.setSchedule(day, time);
            }

        }
        inputView.closeScanner();
    }
}
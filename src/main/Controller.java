import java.util.ArrayList;
import java.util.List;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    List<Parent> parents = new ArrayList<>();
    Timetable timetable = new Timetable();

    public Parent parentLogin() {
        String parentName = inputView.getParentName();
        Parent parent =  parents.stream()
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
                return parentLogin();
            }
        }

        return parent;
    }

    public void printWelcomeAndSchedule() {
        outputView.printWelcome();
        timetable.printTimetable();
    }

    public Child selectChild(Parent parent) {
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
                return selectChild(parent);
            }
        }

        return child;
    }

    public void inputSchedule(Child child) {
        String[] scheduleInput = inputView.askDayTime();
        Day day = Day.fromKorean(scheduleInput[0]);
        int time = Integer.parseInt(scheduleInput[1].replace("시", ""));

        if (timetable.isAvailable(day, time, child.getName())) {
            timetable.addSchedule(day, time, child.getName());
            child.setSchedule(day, time);
        }else {
            outputView.scheduleAlreadyFull();
            inputSchedule(child);
        }
    }

    public boolean askEnd() {
        timetable.printTimetable();
        String answer = inputView.askEndProgram();
        return answer.equalsIgnoreCase("y");
    }

    public void endProgram() {
        inputView.closeScanner();
    }


}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Parent> parents = new ArrayList<>();
        Timetable timetable = new Timetable();

        while(true){
            System.out.print("학부모 성함을 적어주세요: ");
            String parentName = scanner.nextLine().trim();
            Parent parent = (Parent) parents.stream()
                    .filter(p -> p.getName().equalsIgnoreCase(parentName))
                    .findFirst()
                    .orElse(null);


            if(parent == null) {
                System.out.print("현재 00학원의 회원이 아니십니다. 회원가입 하시겠습니까? (y/n): ");
                String signinAnswer = scanner.nextLine().trim();
                if (signinAnswer.equalsIgnoreCase("y")) {
                    // 학부모 등록
                    parent = new Parent(parentName);
                    parents.add(parent);

                    // 자녀 등록
                    System.out.print("학부모의 자녀로 등록할 아이(들)의 이름을 적어주세요. (ex. jiye, nix): ");
                    String[] childNames = scanner.nextLine().split(",");
                    for (String childName : childNames) {
                        String childNameTrimmed = childName.trim();
                        parent.addChild(childNameTrimmed);
                    }
                } else {
                    System.out.println("프로그램이 종료됩니다.");
                    break;
                }
            }

            timetable.printTimetable();

        }
        scanner.close();
    }
}
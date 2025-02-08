package view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private InputValidation validator;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.validator = new InputValidation();
    }

    public String getParentName() {
        System.out.print("학부모 성함을 적어주세요. (ex. jiye, dan): ");
        String input = scanner.nextLine().trim();
        if(!validator.isLessThan(input, 5)) {
            System.out.println("5자 이하만 가능합니다. (ex. lee)");
            getParentName();
        }
        return input;
    }

    public String askIfSign() {
        System.out.print("현재 00학원의 회원이 아니십니다. 회원가입 하시겠습니까? (y/n): ");
        return scanner.nextLine().trim();
    }

    public String[] getChildrenNames() {
        System.out.print("학부모의 자녀로 등록할 아이(들)의 이름을 적어주세요. (ex. jiye, nix): ");
        return scanner.nextLine().split(",");
    }

    public String getChildName() {
        System.out.print("시간표를 등록할 자녀의 이름을 입력해주세요: ");
        String input = scanner.nextLine().trim();
        if(!validator.isLessThan(input, 5)) {
            System.out.println("5자 이하만 가능합니다. (ex. lee)");
            getChildName();
        }
        return input;
    }

    public String askIfChildSign() {
        System.out.print("자녀가 등록되지 않았습니다. 등록하시겠습니까? (y/n): ");
        return scanner.nextLine().trim();
    }

    public String[] askDayTime() {
        System.out.print("원하시는 요일과 시간을 올바른 형식으로 입력해주세요 (ex. 월-3시): ");
        return scanner.nextLine().split("-");
    }

    public String askEndProgram() {
        System.out.print("프로그램을 종료하시겠습니까? (y/n): ");
        return scanner.nextLine().trim();
    }

    public void closeScanner() {
        scanner.close();
    }
}

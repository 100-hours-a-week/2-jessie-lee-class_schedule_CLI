import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getParentName() {
        System.out.print("학부모 성함을 적어주세요: ");
        return scanner.nextLine().trim();
    }

    public String askIfSign() {
        System.out.print("현재 00학원의 회원이 아니십니다. 회원가입 하시겠습니까? (y/n): ");
        return scanner.nextLine().trim();
    }

    public String[] getChildrenNames() {
        System.out.print("학부모의 자녀로 등록할 아이(들)의 이름을 적어주세요. (ex. jiye, nix): ");
        return scanner.nextLine().split(",");
    }

    public void closeScanner() {
        scanner.close();
    }
}

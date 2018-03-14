import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] getNamesOfPersons() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] namesOfPersons = scanner.nextLine().split(",");
        return InputViewUtils.checkNames(namesOfPersons);
    }

    public static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
    }
}

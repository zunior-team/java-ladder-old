package console;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputPersonNames(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scannerInput();
    }

    public static String inputLadderResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,) 로 구분하세요)");
        return scannerInput();
    }

    public static String inputLevel() {
        System.out.println("\n실행할 사다리의 난이도는 ?");
        return scannerInput();
    }

    public static String inputToShowingName(){
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scannerInput();
    }

    private static String scannerInput(){
        return SCANNER.nextLine()
                .trim();
    }
}

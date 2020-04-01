package ladder.view;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String COMMA = ",";
    private Scanner scanner = new Scanner(System.in);

    public List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. ( 이름은 쉼표(,)로 구분하세요 )");
        return Lists.newArrayList(split(inputLine().trim()));
    }

    public int inputMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    private String inputLine() {
        return scanner.nextLine();
    }

    private String[] split(String line) {
        return line.split(COMMA);
    }

}

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

    private String inputLine() {
        return scanner.nextLine();
    }

    private String[] split(String line) {
        return line.split(COMMA);
    }

    public String inputPlayerWhoWantResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return inputLine().trim();
    }

    public List<String> inputResults() {
        System.out.println("실행 결과를 입력하세요. ( 결과는 쉼표(,)로 구분하세요 )");
        return Lists.newArrayList(split(inputLine().trim()));
    }

    public String inputDifficulty() {
        System.out.println("실행할 사다리의 난이도는?");
        return inputLine().trim();
    }
}

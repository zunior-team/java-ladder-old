import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public class LadderInput {
    private static final Logger logger = LoggerFactory.getLogger(LadderInput.class);

    public static int peopleInput(String peopleInput){
        return Integer.parseInt(peopleInput);
    }

    public static int ladderInput(String ladderInput){
        return Integer.parseInt(ladderInput);
    }

    public void people(){
        logger.info("참여할 사람은 몇 명 인가요?");
    }

    public void height(){
        logger.info("최대 사다리 높이는 몇 개인가요?");
    }

    public String scannerInput() {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        return inputValue;
    }
}

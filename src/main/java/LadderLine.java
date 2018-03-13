import java.util.Random;

public class LadderLine {
    private String line;
    // 1. LadderLine 클래스는 ladderLine에 대한 정보를 가지고 있어야 한다.
    // 기존에는 LadderLine으로부터 line을 메서드 반환값으로 얻어오는 형태였다.
    // 2. width도 가지고 있을 필요가 없다. 오직 line에 대한 정보만 가지고 있으면 된다.

    LadderLine(int width) {
        this.line = this.getLine(width);
    }

    public String getLine() {
        return this.line;
    }

    private String getLine(int width) {
        StringBuilder line = new StringBuilder();
        String prevBridge = " ";
        int printCount = (width - 1) / 2;

        line.append(addPipe());
        for (int i = 0; i < printCount; i++) {
            // prevBridge 말고 더 이해가 잘 되는 이름 없나?
            prevBridge = addBridge(prevBridge);
            line.append(prevBridge);
            line.append(addPipe());
        }

        return line.toString();
    }

    public String addPipe() {
        return "|";
    }

    public String addBridge(String prevBridge) {
        if ((makeRandomValue() == 1) && prevBridge == " ") {
            return "-";
        }
        return " ";
    }

    public int makeRandomValue() {
        Random random = new Random();
        return random.nextInt(2);
    }
}

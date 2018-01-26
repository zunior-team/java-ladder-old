import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public static void printLadder(ArrayList<Line> lines) {
        for (Line line : lines) {
            printLayer(line);
            System.out.println();
        }
    }

    public static void printLayer(Line line){
        for(int i = 0; i < line.sizeLine(); i++){
            line.checkNext();
            printBar();
            check(line, i);
        }
    }

    public static void printBar() {
        System.out.print("|");
    }

    public static void check(Line line, int i) {
        System.out.print(line.result(i));
    }

    public static void printNames(List<String> names) {
        for (String name : names) {
            System.out.print(String.format("%5s", name));
        }
        System.out.println();
    }

}

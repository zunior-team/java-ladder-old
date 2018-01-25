import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [] args){
        Ladder ladder = new Ladder();
        LadderInput.people();
        String peopleInput = LadderInput.scannerInput();
        LadderInput.height();
        String ladderInput = LadderInput.scannerInput();
        List<String> names = LadderInput.peopleInput(peopleInput);
        int ladderHeight = LadderInput.ladderInput(ladderInput);

        ArrayList<Line> lines = ladder.createLines(names.size(), ladderHeight);
        ResultView.printNames(names);
        ResultView.printLadder(lines);
    }
}

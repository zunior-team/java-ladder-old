import java.util.ArrayList;
import java.util.Random;

class Ladder {
    public ArrayList<Line> createLines(int people, int height){
        ArrayList<Line> lines = new ArrayList<Line>();
        Random rnd = new Random();
        for(int j =0; j < height; j++){
            createLine(people, lines, rnd);
        }
        return lines;
    }

    private void createLine(int people, ArrayList<Line> lines, Random rnd) {
        Line line = new Line();
        for(int i = 0; i < people; i++){
            int randomNumber = rnd.nextInt(10);
            line.addTrueFalse(returnAdd(randomNumber));
        }
        lines.add(line);
    }

    private boolean returnAdd(int randomNumber) {
        if (randomNumber >= 6)
            return true;
        return false;
    }

}


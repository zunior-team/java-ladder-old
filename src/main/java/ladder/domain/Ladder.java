package ladder.domain;

public class Ladder {
    private Line line;

    public Ladder() {
        this.line = new Line();
    }

    // Add line
    public void makeLine(){
        this.line.addLine();
    }

    public Line getLine() {
        return this.line;
    }
}

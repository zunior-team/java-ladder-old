package model;

import ladder.Ladder;
import view.InputView;
import view.PrintView;

public class Main {
    public static void main(String[] args) {
        String[] name = InputView.humans();
        int height = InputView.height();
        Ladder ladder = new Ladder(height);
        ladder.makeLadders(name, height);
        PrintView.totalPrint(ladder, name);
    }
}

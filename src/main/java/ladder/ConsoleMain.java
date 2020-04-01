package ladder;

import ladder.view.InputView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        final List<String> names = inputView.inputNames();
        final int maxHeight = inputView.inputMaxHeight();
    }
}

package ladder;

public class LadderMain {
    public static void main(String[] args) {
        String[] names = InputView.nameCheck(InputView.inputName());
        String[] resultValue = InputView.resultLengthCheck(names, InputView.inputResult());
        int height = InputView.inputHeight();

        AllLine allLine = new AllLine(names.length, height);

        PrintView.valuePrint(names);
        allLine.ladderPrint();
        PrintView.valuePrint(resultValue);

        allLine.gameStart(resultValue);
        PrintView.isName(allLine.matchName(names), InputView.choicePerson());
    }
}

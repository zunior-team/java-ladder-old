package model.ladder;

public class Result {

    private String winnerPrice;
    private ResultType type;

    private enum ResultType{
        MONNEY, END;
    }

    public Result(String result) {
        validate(result);

        try{
            winnerPrice = Integer.parseInt(result);
        } catch(NumberFormatException) {

        }
        type = ResultType.getMyType(result);
    }

    private void validate() {

    }
}

package exception;

import exception.ladder.LadderGameException;

public class LadderCreateException extends LadderGameException {
    public LadderCreateException(String message) {
        super(message);
    }
}

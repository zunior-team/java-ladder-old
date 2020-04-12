package exception;

import exception.ladder.LadderGameException;

public class PlayersCreateException extends LadderGameException {
    public PlayersCreateException(String message) {
        super(message);
    }
}

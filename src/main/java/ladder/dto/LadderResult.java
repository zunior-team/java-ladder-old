package ladder.dto;

import java.util.Map;

public class LadderResult {
    private Map<String, String> prizeMatch;

    public LadderResult(Map<String, String> prizeMatch) {
        this.prizeMatch = prizeMatch;
    }

    public Map<String, String> getPrizeMatch() {
        return prizeMatch;
    }
}

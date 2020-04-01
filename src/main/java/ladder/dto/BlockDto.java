package ladder.dto;

import java.util.List;

public class BlockDto {
    private List<Boolean> polls;

    public BlockDto(List<Boolean> polls) {
        this.polls = polls;
    }

    public List<Boolean> getPolls() {
        return polls;
    }
}

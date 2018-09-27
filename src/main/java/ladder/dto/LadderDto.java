package ladder.dto;

import ladder.domain.Ladder;

import java.util.List;

public class LadderDto {
    private List<String> names;
    private List<Ladder> ladders;
    private List<String> results;

    public LadderDto(List<String> names, List<Ladder> ladders) {
        this.names = names;
        this.ladders = ladders;
    }

    public LadderDto(List<String> names, List<Ladder> ladders, List<String> results) {
        this.names = names;
        this.ladders = ladders;
        this.results = results;
    }

    public List<String> getNames() {
        return names;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public List<String> getResults() {
        return results;
    }

    public int getNamesSize(){
        return this.names.size();
    }
}

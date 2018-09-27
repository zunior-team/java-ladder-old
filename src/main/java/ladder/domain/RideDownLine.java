package ladder.domain;

import ladder.dto.LadderDto;

import java.util.ArrayList;
import java.util.List;

public class RideDownLine {
    private static final int ZERO = 0;

    private LadderDto ladderDto;

    public RideDownLine(LadderDto ladderDto) {
        this.ladderDto = ladderDto;
    }

    // return result index
    public int goRideDown(String name){
        return rideDownPersonResult(findNameIndex(name));
    }

    // return results index list
    public List<Integer> goRideDownEveryOne(){
        List<Integer> answers = new ArrayList<>();
        for (String name : this.ladderDto.getNames()) {
            answers.add(goRideDown(name));
        }
        return answers;
    }

    // find index from names
    public int findNameIndex(String name){
        return this.ladderDto.getNames().indexOf(name);
    }

    // calculate destination
    public int rideDownPersonResult(int location){
        List<Ladder> ladders = this.ladderDto.getLadders();
        int height = ZERO;
        while(height < ladders.size()){
            Line line = ladders.get(height).getLine();
            location = line.decideMove(location);
            height++;
        }
        return location;
    }
}

package com.zingoworks.laddergame.domain;

import com.zingoworks.laddergame.utilities.Utilities;

import java.util.ArrayList;

public class DestinationIndex {
    private int[] index;
    private ArrayList<StringBuilder> destination = new ArrayList<>();

    public DestinationIndex(Ladder ladder) {
        generateDefaultIndex(ladder);
        generateUpdatedIndex(ladder);
        generateDestination(ladder);
    }

    public ArrayList<StringBuilder> getDestination () {
        return this.destination;
    }

    private void generateDestination (Ladder ladder) {
        for (int i = 0; i < this.index.length; i++) {
            addDestinationInfo(ladder, this.index[i]);
        }
    }

    private void addDestinationInfo (Ladder ladder, int index) {
        this.destination.add(Utilities.convertLengthToDefault(ladder.getResult()).get(index));
    }

    private void generateDefaultIndex(Ladder ladder) {
        this.index = new int[ladder.getUser().size()];
        for (int i = 0; i < ladder.getUser().size(); i++) {
            this.index[i] = i;
        }
    }

    private void generateUpdatedIndex(Ladder ladder) {
        for (int i = 0; i < ladder.getLadderHeight(); i++) {
            updateIndexReapeatedly(ladder, i);
        }
    }

    private void updateIndexReapeatedly(Ladder ladder, int i) {
        for (int j = 0; j < ladder.getUser().size(); j++) {
            updateIndex(ladder.getLine().get(i), this.index[j], j);
        }
    }

    private void updateIndex(Line line, int mutableDestinationIndex, int defaultIndex) {
        if (updateFirst(line, mutableDestinationIndex, defaultIndex)) {
            return;
        }
        if (updateLast(line, mutableDestinationIndex, defaultIndex)) {
            return;
        }
        updateMiddle(line, mutableDestinationIndex, defaultIndex);
    }

    private boolean updateFirst(Line line, int mutableDestinationIndex, int defaultIndex) {
        if ((mutableDestinationIndex == 0) && (line.getRungExistence(0) == true)) {
            this.index[defaultIndex] += 1;
            return true;
        }

        if ((mutableDestinationIndex == 0) && (line.getRungExistence(0) == false)) {
            return true;
        }
        return false;
    }

    private boolean updateLast(Line line, int mutableDestinationIndex, int defaultIndex) {
        if ((mutableDestinationIndex == line.getLineLength()) && (line.getRungExistence(line.getLineLength() - 1) == true)) {
            this.index[defaultIndex] -= 1;
            return true;
        }

        if ((mutableDestinationIndex == line.getLineLength()) && (line.getRungExistence(line.getLineLength() - 1) == false)) {
            return true;
        }
        return false;
    }

    private void updateMiddle(Line line, int mutableDestinationIndex, int defaultIndex) {
        if (line.getRungExistence(mutableDestinationIndex - 1) == true) {
            this.index[defaultIndex] -= 1;
            return;
        }

        if (line.getRungExistence(mutableDestinationIndex) == true) {
            this.index[defaultIndex] += 1;
        }
    }
}

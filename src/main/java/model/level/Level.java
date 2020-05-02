package model.level;

import model.ladder.LadderStrategy;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Level {
    HIGH("상", LadderStrategy.newInstance(20, 0.7D)),
    MEDIUM("중", LadderStrategy.newInstance(20, 0.5D)),
    LOW("하", LadderStrategy.newInstance(20, 0.3D));

    private String level;
    private LadderStrategy ladderStrategy;

    Level(final String level,
          final LadderStrategy ladderStrategy){
        this.level = level;
        this.ladderStrategy = ladderStrategy;
    }

    public static Level getLevelByString(final String currentLevel){
        return Arrays.stream(Level.values())
                .filter(level -> level.eqLevel(currentLevel))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private boolean eqLevel(final String level){
        return this.level.equals(level);
    }

    public int getHeight(){
        return ladderStrategy.getHeight();
    }

    public boolean isLineGeneratable(){
        return this.ladderStrategy.isLineCreatable();
    }
}
package model.level;

import model.ladder.LadderStrategy;

import java.util.*;
import java.util.stream.Collectors;

public enum Level {
    HIGH("상", LadderStrategy.newInstance(Height.HIGH, Rate.HIGH)),
    MEDIUM("중", LadderStrategy.newInstance(Height.MEDIUM, Rate.MEDIUM)),
    LOW("하", LadderStrategy.newInstance(Height.LOW, Rate.LOW));

    private static final Map<String, Optional<Level>> LEVEL_SET = Collections.unmodifiableMap(
            Arrays.stream(Level.values())
            .collect(Collectors.toMap(Level::getLevel, Optional::of)));

    private String level;
    private LadderStrategy ladderStrategy;

    Level(final String level,
          final LadderStrategy ladderStrategy){
        this.level = level;
        this.ladderStrategy = ladderStrategy;
    }

    public static Level getLevelByString(final String currentLevel){
        return LEVEL_SET.get(currentLevel)
                .orElseThrow(() -> new NoSuchElementException(currentLevel + "에 해당하는 난이도는 없습니다."));
    }

    private String getLevel(){
        return level;
    }

    public int getHeight(){
        return ladderStrategy.getHeight();
    }

    public LadderStrategy getLadderStrategy(){
        return ladderStrategy;
    }

    public static class Height {
        public static final int HIGH = 20;
        public static final int MEDIUM = 10;
        public static final int LOW = 5;
    }

    public static class Rate {
        public static final double HIGH = 0.7D;
        public static final double MEDIUM = 0.5D;
        public static final double LOW = 0.3D;
    }
}

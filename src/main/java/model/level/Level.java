package model.level;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Level {
    HIGH("상", 20),
    MEDIUM("중", 10),
    LOW("하", 5);

    private String level;
    private Integer height;

    Level(final String level,
          final Integer height){
        this.level = level;
        this.height = height;
    }

    public static Level getLevelByString(final String currentLevel){
        return Arrays.stream(Level.values())
                .filter(level -> level.eqLevel(currentLevel))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public boolean eqLevel(final String level){
        return this.level.equals(level);
    }

    public int getHeight() {
        return height;
    }
}

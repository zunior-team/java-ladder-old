package ladder.init;

import java.util.Arrays;

public class LadderInitInfo {
    private static final int LOWEST_LIMIT = 1;
    private final int height;
    private final int width;

    public LadderInitInfo(final int height, final int width) {
        validateSize(height, width);

        this.height = height;
        this.width = width;
    }

    private void validateSize(int... sizes) {
        if(Arrays.stream(sizes)
                .anyMatch(size -> size < LOWEST_LIMIT)) {
            throw new IllegalArgumentException("Ladder size can't smaller than " + LOWEST_LIMIT);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

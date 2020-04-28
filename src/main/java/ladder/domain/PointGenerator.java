package ladder.domain;

import java.util.List;

@FunctionalInterface
public interface PointGenerator {
    List<Boolean> generate(int height);
}

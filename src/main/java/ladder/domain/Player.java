package ladder.domain;

import com.google.common.collect.Lists;
import spark.utils.StringUtils;

import java.util.List;
import java.util.Objects;

import static ladder.domain.ResultPlayer.ALL;

public class Player {

    private String name;
    private static List<String> reservedWords = Lists.newArrayList(ALL);

    public Player(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("name : " + name + " 은 비거나 NULL 값이 들어올 수 없습니다");
        }
        if (reservedWords.contains(name)) {
            throw new IllegalArgumentException("예약어 : " + name + " 은 사용할 수 없는 이름 입니다");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}

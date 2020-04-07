package ladder.domain;

import spark.utils.CollectionUtils;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Players {
    public static final int MINIMUM_PARTICIPANTS = 2;

    private List<Player> players;

    private Players(List<String> names) {
        if (CollectionUtils.isEmpty(names) || names.size() < MINIMUM_PARTICIPANTS) {
            throw new IllegalArgumentException("참여자 수는 최소 " + MINIMUM_PARTICIPANTS + "명 이상이어야 합니다.");
        }
        this.players = names.stream()
                .map(Player::new)
                .collect(toList());
    }

    public static Players of(List<String> names) {
        return new Players(names);
    }

    public int size() {
        return players.size();
    }

    public List<String> names() {
        return players.stream()
                .map(Player::getName)
                .collect(collectingAndThen(toList(),
                        Collections::unmodifiableList));
    }
}

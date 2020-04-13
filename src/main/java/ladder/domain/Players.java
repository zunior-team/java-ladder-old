package ladder.domain;

import spark.utils.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

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

    public Player findByName(String name) {
        Objects.requireNonNull(name, "참여자 이름은 null 일 수 없습니다.");
        return players.stream()
                .filter(player -> name.equals(player.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재 하지 않는 참여자 입니다."));
    }

    public int indexOf(Player player) {
        Objects.requireNonNull(player, "참여자는 null 일 수 없습니다.");
        return players.indexOf(player);
    }

    public Stream<Player> stream() {
        return this.players.stream();
    }
}

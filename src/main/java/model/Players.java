package model;

import exception.PlayersCreateException;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(final List<String> names){
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static Players create(final List<String> names) {
        validate(names);
        return new Players(names);
    }

    private static void validate(final List<String> names){
        if(names == null || names.size() == 0){
            throw new PlayersCreateException("플레이어를 생성하지 못합니다.");
        }
    }
}

package model.player;

import exception.PlayersCreateException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(final List<String> names){
        this.players = names.stream()
                .map(Player::create)
                .collect(Collectors.toList());
    }

    public static Players create(final List<String> names) {
        validate(names);
        return new Players(names);
    }

    private static void validate(final List<String> names){
        if(CollectionUtils.isEmpty(names)) {
            throw new PlayersCreateException("플레이어를 생성하지 못합니다.");
        }
    }

    public int getPlayerCount(){
        return this.players.size();
    }

    public List<String> toNames(){
        return Collections.unmodifiableList(
                players.stream()
                .map(Player::name)
                .collect(Collectors.toList()));
    }
}

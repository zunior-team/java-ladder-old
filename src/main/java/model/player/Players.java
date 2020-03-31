package model.player;

import exception.PlayersCreateException;

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
        if(names == null || names.size() == 0){
            throw new PlayersCreateException("플레이어를 생성하지 못합니다.");
        }
    }

    public int getPlayerCount(){
        return this.players.size();
    }

//    public int getMaxLengthName(){
//        return this.players.stream()
//                .mapToInt(Player::nameLength)
//                .max()
//                .orElseThrow(NoSuchElementException::new);
//    }
}

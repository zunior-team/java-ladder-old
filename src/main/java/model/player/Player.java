package model.player;

public class Player{

    private Name name;

    private Player(String name){
        this.name = new Name(name);
    }

    public static Player create(final String name){
        return new Player(name);
    }

    public String name(){
        return name.get();
    }

    public int nameLength() {
        return name.length();
    }
}

package model.player;

public class Name {
    private String name;

    public Name(String name){
        this.name = name;
    }

    public String get(){
        return name;
    }

    public int length(){
        return name.length();
    }
}

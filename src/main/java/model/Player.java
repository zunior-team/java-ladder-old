package model;

import pojo.Name;

public class Player {

    private Name name;

    Player(String name){
        this.name = new Name(name);
    }
}

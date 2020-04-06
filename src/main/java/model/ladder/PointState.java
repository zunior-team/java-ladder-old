package model.ladder;

public enum PointState {

    BAR("|"), DASH("-"), SPACE(" ");

    private String display;

    PointState(String display){
        this.display = display;
    }

    String display(){
        return display;
    }
}
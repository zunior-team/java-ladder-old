package model.moving;

public enum MovingType {
    LEFT((pos) -> (pos - 1)),
    RIGHT((pos) -> (pos + 1));

    Movement movement;

    MovingType(Movement movement){
        this.movement = movement;
    }

    public int move(int currentPos){
        return this.movement.move(currentPos);
    }
}

package lab1;

import lab1.strategies.MoveStrategy;

public class Hero {
    private double positionX;
    private double positionY;
    private MoveStrategy moveStrategy;

    public Hero() {
        this.positionX = 0;
        this.positionY = 0;
    }

    public Hero(double x, double y) {
        this.positionX = x;
        this.positionY = y;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move(double newX, double newY) {
        this.positionX = newX;
        this.positionY = newY;
        moveStrategy.move(newX, newY);
    }

    public void getPosition() {
        System.out.println("Current position is: (" + positionX + "; " + positionY + ")");
    }
}

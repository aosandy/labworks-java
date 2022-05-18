package lab1.strategies;

public class MoveFlying implements MoveStrategy {
    @Override
    public void move(double x, double y) {
        System.out.println("The hero flew to the point (" + x + "; " + y + ")");
    }
}

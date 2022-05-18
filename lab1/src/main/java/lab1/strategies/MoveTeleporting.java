package lab1.strategies;

public class MoveTeleporting implements MoveStrategy {
    @Override
    public void move(double x, double y) {
        System.out.println("The hero teleported to point (" + x + "; " + y + ")");
    }
}

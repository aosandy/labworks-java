package lab1.strategies;

public class MoveOnHorse implements MoveStrategy {
    @Override
    public void move(double x, double y) {
        System.out.println("The hero moved to point (" + x + "; " + y + ") on a horse");
    }
}

package lab1;

import lab1.strategies.MoveFlying;
import lab1.strategies.MoveOnFoot;
import lab1.strategies.MoveOnHorse;
import lab1.strategies.MoveTeleporting;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.getPosition();
        System.out.println();

        hero.setMoveStrategy(new MoveOnFoot());
        hero.move(5.0, 5.0);
        hero.getPosition();
        System.out.println();

        hero.setMoveStrategy(new MoveOnHorse());
        hero.move(6.4327, 7.777);
        hero.getPosition();
        System.out.println();

        hero.setMoveStrategy(new MoveFlying());
        hero.move(-90.0, 0.0);
        hero.getPosition();
        System.out.println();

        hero.setMoveStrategy(new MoveTeleporting());
        hero.move(5.5, 1.5);
        hero.getPosition();
    }
}

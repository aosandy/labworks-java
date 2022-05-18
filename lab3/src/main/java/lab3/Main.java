package lab3;

import lab3.arthropod_classification.Arthropods;
import lab3.arthropod_classification.HoneyBee;
import lab3.arthropod_classification.RedFireAnt;
import lab3.queue.Queue;
import lab3.queue.QueueOverflowException;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        Utils utils = new Utils();
        try {
            Queue<? extends Arthropods> queue1 = Utils.produce(20);
            Queue<? extends Arthropods> queue2 = Utils.produce(20);
            Queue<? super RedFireAnt> queueAnt = Utils.consume(RedFireAnt.class, queue1);
            Queue<? super HoneyBee> queueBee = Utils.consume(HoneyBee.class, queue2);
            System.out.println(queueAnt);
            System.out.println(queueBee);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | QueueOverflowException e) {
            e.printStackTrace();
        }
    }
}

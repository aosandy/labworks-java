package lab3;

import lab3.arthropod_classification.*;
import lab3.queue.Queue;
import lab3.queue.QueueOverflowException;

import java.lang.reflect.InvocationTargetException;

public class Utils {
    public static Queue<? extends Arthropods> produce(int n) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, QueueOverflowException {
        Queue<Arthropods> queue = new Queue<>(n);
        Class<? super RedFireAnt> className1 = RedFireAnt.class;
        Class<? super HoneyBee> className2 = HoneyBee.class;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                queue.add((Arthropods) className1.getConstructor().newInstance());
                className1 = className1.getSuperclass();
                if (className1 == Arthropods.class) {
                    className1 = RedFireAnt.class;
                }
            } else {
                queue.add((Arthropods) className2.getConstructor().newInstance());
                className2 = className2.getSuperclass();
                if (className2 == Arthropods.class) {
                    className2 = HoneyBee.class;
                }
            }
        }
        return queue;
    }

    public static <T> Queue<? super T> consume(Class<T> lowerBound, Queue<? extends Arthropods> queue) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Queue<? super T> lowerBoundQueue = new Queue<>(queue.getSize());
        T lowerBoundObject = lowerBound.getConstructor().newInstance();
        while (queue.getSize() != 0) {
            var object = queue.get();
            if (object.getClass().isInstance(lowerBoundObject)) {
                lowerBoundQueue.add((T)object);
            }
        }
        return lowerBoundQueue;
    }
}

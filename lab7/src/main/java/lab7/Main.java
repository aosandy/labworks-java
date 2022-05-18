package lab7;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong arguments number");
            return;
        }
        int N = Integer.parseInt(args[0]);

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        ExecutorService readers = Executors.newScheduledThreadPool(N, new ThreadFactory() {
            private int i = 1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Reader " + i++);
            }
        });

        ExecutorService writers = Executors.newScheduledThreadPool(N, new ThreadFactory() {
            private int i = 1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Writer " + i++);
            }
        });

        for (int i = 0; i < N; i ++) {
            writers.execute(() -> {
                try {
                    Thread.sleep(10000);
                    queue.put("Message from " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            readers.execute(() -> {
                try {
                    System.out.println("Receiver: " + Thread.currentThread().getName()+ " / Message: " + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        writers.shutdown();
        readers.shutdown();
    }
}

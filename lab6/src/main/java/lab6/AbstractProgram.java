package lab6;

import java.util.Random;

public class AbstractProgram implements Runnable {
    enum state {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR
    }

    private state programState;
    private final Object mutex;
    private int delay = 1000;

    public AbstractProgram(int delay) {
        this.programState = state.RUNNING;
        this.mutex = new Object();
        this.delay = delay;
    }

    Runnable stateChanger = new Runnable() {
        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                synchronized (mutex) {
                    try {
                        mutex.wait(delay);
                        System.out.println(programState);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    setProgramState(state.class.getEnumConstants()[random.nextInt(state.class.getEnumConstants().length)]);
                    try {
                        Thread.sleep(delay);
                        System.out.println(programState);
                        mutex.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    };

    public Object getMutex() {
        return this.mutex;
    }

    public state getProgramState() {
        return this.programState;
    }

    public synchronized void setProgramState(state programState) {
        this.programState = programState;
    }

    @Override
    public void run() {

        Thread stateChangerThread = new Thread(stateChanger);
        Thread.currentThread().setName("Abstract program");
        stateChangerThread.setDaemon(true);
        System.out.println("Starting program");
        System.out.println("Program state is " + programState);
        stateChangerThread.start();
    }
}

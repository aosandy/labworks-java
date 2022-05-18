package lab6;

public class Supervisor implements Runnable {
    private final AbstractProgram abstractProgram;

    public Supervisor(AbstractProgram abstractProgram) {
        this.abstractProgram = abstractProgram;
    }

    @Override
    public void run() {
            while (true) {
                synchronized (abstractProgram.getMutex()) {
                    try {
                        abstractProgram.getMutex().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (abstractProgram.getProgramState() == AbstractProgram.state.FATAL_ERROR) {
                        stopAbstractProgram();
                        break;
                    } else if (abstractProgram.getProgramState() == AbstractProgram.state.UNKNOWN ||
                            abstractProgram.getProgramState() == AbstractProgram.state.STOPPING) {
                        startAbstractProgram();
                    }
                    abstractProgram.getMutex().notify();
            }
        }
    }

    private void stopAbstractProgram() {
        System.out.println("Stop program");
        Thread.currentThread().interrupt();
    }

    private void startAbstractProgram() {
        System.out.println("Starting program");
        abstractProgram.setProgramState(AbstractProgram.state.RUNNING);
    }
}

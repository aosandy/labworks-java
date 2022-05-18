package lab6;

public class Main {
    public static void main(String[] args) {
        AbstractProgram abstractProgram = new AbstractProgram(5000);
        Supervisor supervisor = new Supervisor(abstractProgram);
        new Thread(abstractProgram).start();
        new Thread(supervisor).start();
    }
}

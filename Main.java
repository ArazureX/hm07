package AdHM7;

public class Main {
    public static void main(String[] args) {
        Barrack barrack = new Barrack();
        Mine mine = new Mine(1000);
        Manufacturing manufacturing = new Manufacturing(mine, barrack);
        new Logger(mine, manufacturing);
        manufacturing.startProcess();
    }
}

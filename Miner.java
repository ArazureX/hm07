package AdHM7;

public class Miner implements Runnable {
    private final String name;
    private final Mine mine;
    private int goldQuantity = 0;

    public Miner(Mine mine, String name) {
        this.mine = mine;
        this.name = name;
        new Thread(this).start();
    }

    public void showInfo() {
        System.out.printf("Worker %s mined %d gold\n", name, goldQuantity);
    }


    @Override
    public void run() {
        while (mine.getGoldQuantity() > Mine.QUANTITY_AT_A_TIME) {
            mine.reduceAmountOfGold();
            goldQuantity += Mine.QUANTITY_AT_A_TIME;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

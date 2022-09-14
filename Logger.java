package AdHM7;

public class Logger implements Runnable {
    private final Mine mine;
    private final Manufacturing manufacturing;

    public Logger(Mine mine, Manufacturing manufacturing) {
        this.mine = mine;
        this.manufacturing = manufacturing;
        new Thread(this).start();
    }


    @Override
    public void run() {
        while (mine.getGoldQuantity() > Mine.QUANTITY_AT_A_TIME) {
            try {
                Thread.sleep(1000);
                manufacturing.getMiners().forEach(Miner::showInfo);
                System.out.println("REST OF THE GOLD: " + mine.getGoldQuantity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

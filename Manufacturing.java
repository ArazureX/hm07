package AdHM7;

import java.util.ArrayList;
import java.util.List;

public class Manufacturing {
    private final Mine mine;
    private final List<Miner> miners = new ArrayList<>();
    private final Barrack barrack;

    public Manufacturing(Mine mine, Barrack barrack) {
        this.mine = mine;
        this.barrack = barrack;
    }

    public void startProcess() {
        miners.add(barrack.makeMiner(mine));
        miners.add(barrack.makeMiner(mine));
        miners.add(barrack.makeMiner(mine));

        addMooreMiner();
    }

    private synchronized void addMooreMiner() {
        while (mine.getGoldQuantity() > Mine.QUANTITY_AT_A_TIME) {
            try {
                Thread.sleep(10000);
                miners.add(barrack.makeMiner(mine));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public List<Miner> getMiners() {
        return miners;
    }
}

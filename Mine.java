package AdHM7;

public class Mine {
    private volatile int goldQuantity;
    static final int QUANTITY_AT_A_TIME = 3;

    public Mine(int goldQuantity) {
        this.goldQuantity = goldQuantity;
    }

    public synchronized int getGoldQuantity() {
        return goldQuantity;
    }

    public synchronized void reduceAmountOfGold() {
        goldQuantity -= Mine.QUANTITY_AT_A_TIME;
    }

}

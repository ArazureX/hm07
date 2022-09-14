package AdHM7;

import com.github.javafaker.Faker;

public class Barrack {
    private final Faker faker;

    public Barrack() {
        faker = new Faker();
    }

    public Miner makeMiner(Mine mine) {
        return new Miner(mine, faker.name().fullName());
    }

}

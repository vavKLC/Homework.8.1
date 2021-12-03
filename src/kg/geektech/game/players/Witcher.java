package kg.geektech.game.players;

import java.util.Arrays;

public class Witcher extends Hero {

    public Witcher(int health, int damage) {
        super(health, damage, SuperAbility.REINCARNATION);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (this.getHealth() > 0) {
                if (heroes[i].getHealth() <= 0 && this != heroes[i]) {
                    heroes[i].setHealth(100);
                    this.setHealth(0);
                    System.out.println("ведьмак вернул жизнь " + heroes[i].getClass().getSimpleName());
                }
            }
        }
    }
}

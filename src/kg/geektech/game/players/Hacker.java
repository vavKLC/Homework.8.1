package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Hacker extends Hero{
    private int steal;
    public Hacker(int health, int damage) {
        super(health, damage, SuperAbility.STEAL_HEALTH);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int stealHealth = RPG_Game.random.nextInt(50) + 1;
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0){
                steal = boss.getHealth() - stealHealth;
                heroes[i].setHealth(heroes[i].getHealth() + stealHealth);
                System.out.println("Hacker украл и добавил " + stealHealth + " " + heroes[i].getClass().getSimpleName());
                break;
            }
        }
    }
}

package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero {


    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.GET_STAN);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean stun = RPG_Game.random.nextBoolean();
        for (int i = 0; i < heroes.length; i++) {
            if (this.getHealth() > 0) {
                if (stun) {
                    boss.setDamage(boss.getDamage() - boss.getDamage());
                    System.out.println("Boss был оглушен");
                    break;
                } else {
                    boss.setDamage(50);
                }
            }
        }
    }
}

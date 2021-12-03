package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero {


    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.GET_STAN);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int stun = RPG_Game.random.nextInt(15);
        for (int i = 0; i < heroes.length; i++) {
            if (this.getHealth() > 0) {
                if (stun > 8) {
                    boss.setDamage(boss.getDamage() - boss.getDamage());
                    System.out.println("босс стан");
                    break;
                } else if (stun < 8){
                    boss.setDamage(50);
                }
            }
        }
    }
}

package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0){
                int doubleDamage = RPG_Game.random.nextInt(5) + 1 ;
                heroes[i].setDamage(heroes[i].getDamage() + doubleDamage);

            }
        }
    }
}

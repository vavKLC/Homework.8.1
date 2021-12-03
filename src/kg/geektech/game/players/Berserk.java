package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    public Berserk(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }
    private int dAR;

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (this.getHealth() > 0){
                int blockAndBoostD = RPG_Game.random.nextInt(5) + 1;
                dAR = boss.getDamage() / blockAndBoostD;
                boss.setHealth(boss.getHealth() - (this.getDamage() + dAR));
                System.out.println("Berserk dAR: " + dAR);
                break;
            }
        }
    }
}

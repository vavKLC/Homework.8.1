package kg.geektech.game.players;

public class Golem extends Hero {
    int damageAbsorbed;

    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.DAMAGE_ABSORPTION);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && this != heroes[i] && this.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage() * 2 / 6);
                damageAbsorbed = boss.getDamage() * 2 / 6;
                this.setHealth(this.getHealth () - boss.getDamage() - damageAbsorbed);
                System.out.println("Golem absorbed following damage: " + damageAbsorbed);
                break;
            }

        }
    }
}

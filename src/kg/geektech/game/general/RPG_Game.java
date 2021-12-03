package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(15000, 50);

        Warrior warrior = new Warrior(270, 20);
        Medic doc = new Medic(230, 5, 15);
        Magic magic = new Magic(260, 15);
        Berserk berserk = new Berserk(250, 10);
        Medic assistant = new Medic(280, 10, 5);
        Thor thor = new Thor(230,15);
        Witcher whitcher = new Witcher(300,0);
        Hacker hacker = new Hacker(150,2);
        Hero[] heroes = {warrior, doc, magic, berserk, assistant,thor,whitcher,hacker};

        printStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplyAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void heroesApplyAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("_________________");
        System.out.println("Boss health: " + boss.getHealth() + " (" + boss.getDamage() + ")");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() +
                    " health: " + heroes[i].getHealth() + " (" + heroes[i].getDamage() + ")");
        }
        System.out.println("_________________");
    }
}

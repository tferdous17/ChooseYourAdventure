package src.Main;

import src.NPC.Hog;
import src.NPC.Lowly_Bandit;
import src.NPC.NPC;
import src.NPC.Rogue_Guard;
import src.Player.Player;

import java.util.Random;
import java.util.Scanner;

public class Combat {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private void combatMenu(Player player, NPC npc) throws InterruptedException {
        System.out.println("You're in combat! What do you do?");
        System.out.println("\t1. Attack!");
        System.out.println("\t2. Block!");
        System.out.println("\t3. Escape!");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                attackSequence(player, npc);
            }
            case 2 -> {
                // placeholder
                block(player, npc);
            }
            case 3 -> {
//                periodicDots();
                System.out.println("With no hesitation, you quickly bolt in the opposite direction!\n");
            }
        }


    }



    public void npcEncounter(Player player) throws InterruptedException {
        int npcRandomSelection = random.nextInt(3)+1;
        if (player.getLevel() < 3) {
            NPC npc;
            switch (npcRandomSelection) {
                case 1 -> {
                    npc = new Hog();
                    System.out.println(npc);
                    combatMenu(player, npc);
                }
                case 2 -> {
                    npc = new Lowly_Bandit();
                    System.out.println(npc);
                    combatMenu(player, npc);
                }
                case 3 -> {
                    npc = new Rogue_Guard();
                    System.out.println(npc);
                    combatMenu(player, npc);
                }
            }
        }
    }

    private void block(Player player, NPC npc) throws InterruptedException {
        System.out.println("You decide to brace! (45% damage reduction)");
        // block 45% of the dmg
        if (npc.getHealth() > 0 && player.getHealth() > 0) {
            System.out.println("The " + npc.getNpcType() + " inflicts " + npc.attack() + " damage!"); // NPC attacks
            System.out.println(npc.getNpcType() + "'s current health: " + npc.getHealth());
            System.out.println("----PLAYER HP CHECK 1: " + player.getHealth());
            System.out.println("-------method 2.1 working (NPC ATTACKING)");
            if (player.getHealth() > 0) {
                System.out.println();
                int reducedDamage = (int) ((int) npc.attack() * 0.65);
                player.receiveDamage(reducedDamage); // player receives damage
                System.out.println("-------method 2.2 working (PLAYER RECEIVES DMG)");
                System.out.println("----PLAYER HP CHECK 2: " + player.getHealth());
                if (player.getHealth() != 0) {
                    combatMenu(player, npc);
                } else {
                    gameOver(player);
                }
            }
        }

    }

    private void attackSequence(Player player, NPC npc) throws InterruptedException { // fix method later. infinite loops as of now.


        if (player.getHealth() > 0) {
            System.out.println("Current health: " + player.getHealth());
            System.out.println("You decide to attack!");
            System.out.println("Before the " + npc.getNpcType() + " can even react!..");
            npc.receiveDamage(player.getInventory().getWeapon().attack()); // player attacks 1, npc receives damage
            System.out.println("-------method 1 working (PLAYER ATTACKING, NPC RECEIVING DMG");
            battleRewards(player, npc);
        } // else {
        //  gameOver();
        // }
        if (npc.getHealth() > 0 && player.getHealth() > 0) {
            System.out.println("The " + npc.getNpcType() + " retaliates and inflicts " + npc.attack() + " damage!"); // NPC attacks
            System.out.println(npc.getNpcType() + "'s current health: " + npc.getHealth());
            System.out.println("----PLAYER HP CHECK 1: " + player.getHealth());
            System.out.println("-------method 2.1 working (NPC ATTACKING)");
            if (player.getHealth() > 0) {
                player.receiveDamage(npc.attack()); // player receives damage
                System.out.println("-------method 2.2 working (PLAYER RECEIVES DMG)");
                System.out.println("----PLAYER HP CHECK 2: " + player.getHealth());
                if (player.getHealth() != 0) {
                    combatMenu(player, npc);
                } else {
                    gameOver(player);
                }
            }
        }
    }

    private void battleRewards(Player player, NPC npc) {
        if (npc.getHealth() <= 0) {
            System.out.println("You've defeated the " + npc.getNpcType() + "!");
            System.out.println("-------REWARDS-------");
            System.out.println("\t✦ XP: +" + npc.getXP());
            double gold = random.nextInt(34, 42);
            System.out.println("\t✦ Gold: " + gold + " G");
            System.out.println("-------method 3 working");

            player.increaseXP(npc.getXP());
            player.increaseGoldPouch(gold);
            player.increaseKills();

            System.out.println("\n..You live another day.. Will your luck soon give out?");
        }
    }

    private void gameOver(Player player) throws InterruptedException {
        System.out.println("Your adventure comes to a bloody end.. \nGAME OVER!");
        System.out.println("\n-------FINAL STATS-------");
        player.viewStats();

        System.out.println("\nPlay again? (YES | NO)");
        String choice1 = scanner.next();
        if (choice1.equalsIgnoreCase("yes")) {
            UserInterface ui = new UserInterface(scanner);
            ui.start();
        } else if (choice1.equalsIgnoreCase("no")) {
            System.out.println("\nThanks for playing.");
        }
    }
}

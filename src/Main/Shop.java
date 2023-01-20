package src.Main;

import src.Items.Armor.Black_Iron_Armor;
import src.Items.Armor.Iron_Pauldrons;
import src.Items.Armor.Steel_Armor;
import src.Items.Weapons.Durandal;
import src.Items.Weapons.Iron_Sword;
import src.Items.Weapons.Steel_Sword;
import src.Player.Player;

import java.util.Scanner;

public class Shop {

    private final Scanner scanner = new Scanner(System.in);
    private Player player;

    public void shop(Player player) {
        this.player = player;
        System.out.println("-------WELCOME TO THE ARCANA ITEM SHOP!-------");
        System.out.println("What would you like to view?");
        System.out.println("\t1. Weaponry");
        System.out.println("\t2. Armor");
        System.out.println("\nPress 0 to return.");
        int itemShopChoice = scanner.nextInt();
        if (itemShopChoice == 0) {
            System.out.println("Exiting shop..");
        } else if (itemShopChoice == 1) {
            shopWeaponry();
        } else if (itemShopChoice == 2) {
            shopArmor();
        } else {
            System.out.println("Invalid option.");
            shop(player);
        }
    }

    private void shopArmor() {
        System.out.println("-------ARMOR-------");
        System.out.println("\t1. Iron Pauldrons (100.0 G)" + "\t\tHP Buff: 50");
        System.out.println("\t2. Steel Armor (225.0 G)" + "\t\tHP Buff: 70");
        System.out.println("\t3. [ELITE] Black Iron Armor (800.0 G)" + "\t\tHP Buff: 185");

        System.out.println("Your current balance: " + player.getGoldPouch());

        System.out.println("\nWhich one would you like to buy? Else -> press 0 to return.");
        int armorChoice = scanner.nextInt();

        switch (armorChoice) {
            case 0 -> shop(player);
            case 1 -> {
                if (player.getGoldPouch() >= 100) {
                    player.increaseGoldPouch(-100);
                    Iron_Pauldrons ironPauldrons = new Iron_Pauldrons();
                    player.removeFromInventory(player.getInventory().getArmor());
                    player.addToInventory(ironPauldrons);
                } else {
                    System.out.println("Insufficient funds.");
                    shopWeaponry();
                }
            }
            case 2 -> {
                if (player.getGoldPouch() >= 225) {
                    player.increaseGoldPouch(-225);
                    Steel_Armor steelArmor = new Steel_Armor();
                    player.removeFromInventory(player.getInventory().getArmor());
                    player.addToInventory(steelArmor);
                } else {
                    System.out.println("Insufficient funds.");
                    shopWeaponry();
                }
            }
            case 3 -> {
                if (player.getGoldPouch() >= 800) {
                    player.increaseGoldPouch(-800);
                    Black_Iron_Armor blackIronArmor = new Black_Iron_Armor();
                    player.removeFromInventory(player.getInventory().getArmor());
                    player.addToInventory(blackIronArmor);
                } else {
                    System.out.println("Insufficient funds.");
                    shopWeaponry();
                }
            }
            default -> {
                System.out.println("Invalid choice. Try again.");
                shopArmor();
            }
        }
        player.getInventory().getArmor().hpBuff(player);
    }

    private void shopWeaponry() {
        System.out.println("-------WEAPONRY-------");
        System.out.println("\t1. Iron Sword (75.0 G)" + "\t\tDamage: 24-28");
        System.out.println("\t2. Steel Sword (150.0 G)" + "\t\tDamage: 31-35");
        System.out.println("\t3. [ELITE] Durandal (650.0 G)" + "\t\tDamage: 65-70");

        System.out.println("Your current balance: " + player.getGoldPouch());

        System.out.println("\nWhich one would you like to buy? Else - press 0 to return.");
        int weaponChoice = scanner.nextInt();

        switch (weaponChoice) {
            case 1 -> {
                if (player.getGoldPouch() >= 75) {
                    player.increaseGoldPouch(-75);
                    Iron_Sword ironSword = new Iron_Sword();
                    player.removeFromInventory(player.getInventory().getWeapon());
                    player.addToInventory(ironSword);
                } else {
                    System.out.println("Insufficient funds.");
                    shopWeaponry();
                }
            }
            case 2 -> {
                if (player.getGoldPouch() >= 150) {
                    player.increaseGoldPouch(-150);
                    Steel_Sword steelSword = new Steel_Sword();
                    player.removeFromInventory(player.getInventory().getWeapon());
                    player.addToInventory(steelSword);
                } else {
                    System.out.println("Insufficient funds.");
                    shopWeaponry();
                }
            }
            case 3 -> {
                if (player.getGoldPouch() >= 650) {
                    player.increaseGoldPouch(-650);
                    Durandal durandal = new Durandal();
                    player.removeFromInventory(player.getInventory().getWeapon());
                    player.addToInventory(durandal);
                } else {
                    System.out.println("Insufficient funds.");
                    shopWeaponry();
                }
            }
            default -> {
                System.out.println("Invalid choice. Try again.");
                shopWeaponry();
            }
        }
    }
}

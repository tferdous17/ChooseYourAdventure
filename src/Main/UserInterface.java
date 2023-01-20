package src.Main;

import src.Items.Armor.*;
import src.Items.Weapons.*;
import src.NPC.*;
import src.Player.*;

import java.util.Random;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private Player player;
    private Random random = new Random();
    private NPC npc;
    private final Combat combat = new Combat();


    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() throws InterruptedException {
        // intro
        System.out.println("...");
        System.out.println("You find yourself waking up in the middle of a grass field.. your head tingling with a sharp sensation and no recollection of how you ended up there.");
        System.out.println("Amidst the discomfort, you realize that your belongings are gone.. all but a small pouch filled with golden coins that gleam against the sunlight.");
        System.out.println("The only thought that comes to your mind is... why?");
        periodicDots();
        Thread.sleep(1000);
        System.out.println("\nStart your adventure? (YES | NO)");
        String choice = scanner.nextLine();

        introLoop:
        if (choice.equalsIgnoreCase("YES")) {
            periodicDots();

            System.out.println("Caught by surprise by the hastiness, I hesitantly blurt out my name* \n✤ You: 'My name is...' (enter your name)");
            String name = scanner.nextLine();
            player = new Player(name);
            Rusty_Sword sword = new Rusty_Sword();
            Leather_Armor armor = new Leather_Armor();
            player.addToInventory(sword);
            player.addToInventory(armor);
            player.getInventory().getArmor().hpBuff(player);

            System.out.println(sword.getDamage());

//            introduction();
            menu();
        }
    }

    private void introduction() throws InterruptedException {
        System.out.println("\n----------INTRODUCTION----------");
        System.out.println("You decide to gather what little strength you have left and get on your feet..");
        Thread.sleep(3000);
        System.out.println("..BUT! Out of the corner of your eye, you see an unfamiliar figure in the distance rapidly approaching you!");
        Thread.sleep(3000);
        System.out.println("As the figure approaches, you can start to make out its appearance.. \nAn older gentleman, with overgrown grey hairs sprawling from his chin down to his chest.");
        Thread.sleep(3000);
        System.out.println("His outfit is nothing short of 'odd', adorned with long robes and peculiar hat. His gait oozes a sense of urgency, or rather... excitement?");
        periodicDots(); //✥
        Thread.sleep(3000);
        System.out.println("\n❃ Unknown Figure: 'Oy! You there!' ");
        Thread.sleep(3000);
        System.out.println("I look across my shoulder, and back at him, confused.");
        Thread.sleep(3000);
        System.out.println("❃ Unknown Figure: 'Yes you! I've been waiting for you! Quick, tell me, what's your name? We have much to do!'");
        Thread.sleep(3000);
        System.out.println("Caught by surprise by the hastiness, I hesitantly blurt out my name* \n✤ You: 'My name is...' (enter your name)");

        String name = scanner.nextLine();
        player = new Player(name);

        Thread.sleep(2000);
        System.out.println("❃ Ambrose: 'Ah, yes, of course! " + player.getName() + "! Welcome to the world of Arcana! I'm Ambrose!'");
        Thread.sleep(3000);
        System.out.println("❃ Ambrose: 'I know you have plenty of questions, but there's no time! I'll explain later, but you have to go, NOW! Keep moving and don't look back!'");
        Thread.sleep(3000);
        System.out.println("..Without delay, Ambrose shoved a brown leather bag containing rusted equipment and slivers of food (albeit.. old) into my chest, and immediately pushed me off into the opposite direction.");
        player.addToInventory(new Rusty_Sword());
        player.addToInventory(new Leather_Armor());
        Thread.sleep(3000);
        periodicDots();
        System.out.println("\nYour adventure begins now... Choose wisely, and cautiously.");
        System.out.println();
    }

    private void periodicDots() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(100);
            System.out.print(".");
        }
    }

    private void menu() throws InterruptedException {
        if (player.getHealth() > 0) {
            System.out.println("\nWhat do you do?");
            System.out.println("\t1. Advance");
            System.out.println("\t2. Rest (Heals HP)");
            System.out.println("\t3. View inventory");
            System.out.println("\t4. View stats");
            System.out.println("\t5. Visit item shop");
            System.out.println("\t6. Retire (Game over)");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> { // direction
                    System.out.println("\nWhich direction?");
                    System.out.println("\t1. Forward");
                    System.out.println("\t2. Left");
                    System.out.println("\t3. Right");
                    int directionChoice = scanner.nextInt();

                    directionSwitch:
                    switch (directionChoice) {
                        case 1 -> {
                            System.out.println("You advance forward ever so steadily..");
                            player.advanceForward();
                            encounterPossibility(player);
                            System.out.println(player.getPosition());
                            menu();
                        }
                        case 2 -> {
                            System.out.println("You decide to take a sharp left to see what lies west..");
                            player.advanceLeft();
                            encounterPossibility(player);
                            System.out.println(player.getPosition());
                            menu();
                        }
                        case 3 -> {
                            System.out.println("You decide to take a chance going right to see what lies east..");
                            player.advanceRight();
                            encounterPossibility(player);
                            System.out.println(player.getPosition());
                            menu();
                        }
                        default -> System.out.println("Invalid direction.");
                    }
                }
                case 2 -> { // rest
                    System.out.println("You decide to rest temporarily as time passes..");
                    periodicDots();
                    player.resetHealth();
                    menu();
                }
                case 3 -> { // view inventory
                    player.viewInventory();
                    System.out.println("\nPress 1 to return.");
                    int returnChoice = scanner.nextInt();
                    if (returnChoice == 1) {
                        menu();
                    } else {
                        System.out.println("Invalid entry.");
                    }
                }
                case 4 -> { // view stats
                    System.out.println("----------STATS----------");
                    player.viewStats();
                    System.out.println("\nPress 1 to return.");
                    int returnChoice = scanner.nextInt();
                    if (returnChoice == 1) {
                        menu();
                    }
                }
                case 5 -> {
                    Shop shop = new Shop();
                    shop.shop(player);
                    menu();
                }
                case 6 -> { // retire
                    System.out.println("Your adventure comes to a quick end..");
                    break;
                }
                default -> {
                    System.out.println("Invalid selection. Try again.");
                    menu();
                }
            }
        }
    }

    private void encounterPossibility(Player player) throws InterruptedException {
        if (player.getStepCount() >= 3) { // if stepCount > 3, there's a 25% chance the player will encounter an NPC
            if (random.nextInt(4) + 1 == 2) {
                System.out.println("Oh no!");
                periodicDots();
                combat.npcEncounter(player);
            }
        }
    }






}

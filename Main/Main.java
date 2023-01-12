package Main;

import NPC.*;
import Player.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Venture into the world? (YES/NO)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Yes")) {
            System.out.println("Enter the name of your character!: ");
            String name = scanner.nextLine();
            Player player = new Player(name);
            player.advanceForward();
            player.advanceLeft();
            System.out.println(player.getPosition());

            NPC npc = new Lowly_Bandit();
            NPC npc2 = new Rogue_Guard();
            System.out.println(npc);
            System.out.println(npc2);

        }

    }
}

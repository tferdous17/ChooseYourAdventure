package src.Main;

import src.NPC.*;
import src.Player.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        UserInterface ui = new UserInterface(scanner);
        ui.start();

    }
}
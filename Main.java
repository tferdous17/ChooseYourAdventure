import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Venture into the world of Arcania? (YES/NO)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Yes")) {
            System.out.println("Enter the name of your character!: ");
            String name = scanner.nextLine();
            Player player = new Player(name);
            player.testing();
        }

    }
}

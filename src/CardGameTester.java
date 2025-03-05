import java.util.Scanner;

public class CardGameTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the CardGame Application!");
        System.out.println("----------------------------------");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        GameOf21 gameOf21 = new GameOf21(name);
        gameOf21.startGame();

        scanner.close();
    }
}

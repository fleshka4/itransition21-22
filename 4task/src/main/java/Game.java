import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;

public class Game {
    private final String[] args;

    public Game(String[] args) {
        this.args = args;
    }

    public void start() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String userChoice;
            final String INVALID_INPUT = "Invalid input";
            final Random random = new Random();
            while (true) {
                System.out.println("HMAC:\n" + SecureMaster.getHMACKey());
                System.out.println("Available moves:");
                for (int i = 0; i < args.length; i++) {
                    System.out.println(i + 1 + " - " + args[i]);
                }
                System.out.println("0 - exit\n? - help");
                System.out.print("Enter your move: ");

                userChoice = bufferedReader.readLine();

                if (Objects.equals(userChoice, "")) {
                    System.out.println(INVALID_INPUT);
                    continue;
                }
                if (userChoice.equals("?")) {
                    Table.getHelp(args);
                    continue;
                }

                final int choice;
                try {
                    choice = Integer.parseInt(userChoice);
                } catch (NumberFormatException e) {
                    System.out.println(INVALID_INPUT);
                    continue;
                }
                if ((choice < 0) || (choice > args.length)) {
                    System.out.println(INVALID_INPUT);
                    continue;
                }
                if (choice == 0) {
                    System.out.println("Exit...");
                    break;
                }

                final int move = random.nextInt(args.length);
                System.out.println("Your move: " + args[choice - 1]);
                System.out.println("Computer move: " + args[move]);

                final int result = (args.length + move + 1 - choice) % args.length;

                if (result == 0) {
                    System.out.println("Draw!");
                } else if (result % 2 == 0) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }

                System.out.println("HMAC:\n" + SecureMaster.getHMACKeyForMove(args[move]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

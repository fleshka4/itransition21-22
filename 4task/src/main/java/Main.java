import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Number of arguments must be >= 3");
            System.exit(1);
        } else if (args.length % 2 == 0) {
            System.err.println("Number of arguments must be odd");
            System.exit(1);
        } else if (Arrays.stream(args).anyMatch(s -> Collections.frequency(List.of(args), s) > 1)) {
            System.err.println("All arguments must be unique");
            System.exit(1);
        }
        final Game game = new Game(args);
        game.start();
    }
}

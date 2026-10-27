import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) { // Comprueba si le pasaron exactamente 1 argumento
            System.out.println("Usage: $(COMMAND) [PATTERN]");
            System.exit(-1);
        }

        GlobPattern pattern = new GlobPattern(args[0]);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) { // Lee linea por linea
            String line = scanner.nextLine();
            if (pattern.match(line)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
        scanner.close();
    }
}
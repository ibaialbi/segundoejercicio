import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int exitCode = runLogic(args); // Llamamos a la lógica
        if (exitCode != 0) {
            System.exit(exitCode); // Solo hacemos exit en el main real
        }
    }

    // Método que el Tester puede probar sin matar el programa
    public static int runLogic(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: $(COMMAND) [PATTERN]");
            return -1;
        }

        GlobPattern pattern = new GlobPattern(args[0]);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (pattern.match(line)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
        scanner.close();
        return 0;
    }
}
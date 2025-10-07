import java.util.Scanner;

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public double multiply(double a, double b) {
        return a * b;
    }
    public double divide(int a, int b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Division by zero is not allowed!");
            }
            return (double) a / b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}

class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Calculator calc = new Calculator();

    public void performAddition() {
        System.out.println("Choose type of addition:");
        System.out.println("1. Add two integers");
        System.out.println("2. Add two doubles");
        System.out.println("3. Add three integers");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter two integers: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println("Result: " + calc.add(a, b));
                break;
            case 2:
                System.out.print("Enter two double values: ");
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                System.out.println("Result: " + calc.add(x, y));
                break;
            case 3:
                System.out.print("Enter three integers: ");
                int p = scanner.nextInt();
                int q = scanner.nextInt();
                int r = scanner.nextInt();
                System.out.println("Result: " + calc.add(p, q, r));
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    public void performSubtraction() {
        System.out.print("Enter two integers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Result: " + calc.subtract(a, b));
    }

    public void performMultiplication() {
        System.out.print("Enter two double values: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.println("Result: " + calc.multiply(a, b));
    }

    public void performDivision() {
        System.out.print("Enter two integers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        double result = calc.divide(a, b);
        System.out.println("Result: " + result);
    }

    public void mainMenu() {
        int choice;
        do {
            System.out.println("\nWelcome to the Calculator Application!");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> performAddition();
                case 2 -> performSubtraction();
                case 3 -> performMultiplication();
                case 4 -> performDivision();
                case 5 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }
}

public class CalculatorApplication {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}
import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Simple Calculator");
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        String op = sc.next();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        double result = 0;

        switch(op) {
            case "+":
                result = add(a, b);
                break;
            case "-":
                result = subtract(a, b);
                break;
            case "*":
                result = multiply(a, b);
                break;
            case "/":
                result = divide(a, b);
                break;
            default:
                System.out.println("Invalid operator!");
                System.exit(0);
        }

        System.out.println("Result = " + result);
    }
}

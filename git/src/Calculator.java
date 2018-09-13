import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    static void printResult(double num1, double num2, double num3, String operation) {
        System.out.println("Result: " + num1 + " " + operation + " " + num2 + " = " + num3);
    }

    public static void main(String[] args) {
        double num1 = 0, num2 = 0, num3 = 0;
        String operation = "";
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter the first number: ");
            num1 = Double.parseDouble(read.readLine());
            System.out.println("Enter the operation (+, -, *, /, %, ^, min, max): ");
            operation = read.readLine();
            System.out.println("Enter the second number: ");
            num2 = Double.parseDouble(read.readLine());
        }
        catch (IOException ex) {
            System.out.println("IO exception");
            ex.printStackTrace();
        }
        catch (NumberFormatException ex){
            System.out.println("Can not convert this string to the double format");
            ex.printStackTrace();
        }

        switch (operation) {
            case "+": num3 = Operations.addition(num1, num2);
                printResult(num1, num2, num3, operation);
                break;
            case "-": num3 = Operations.subtraction(num1, num2);
                printResult(num1, num2, num3, operation);
                break;
            case "*": num3 = Operations.multiplication(num1, num2);
                printResult(num1, num2, num3, operation);
                break;
            case "/": num3 = Operations.division(num1, num2);
                printResult(num1, num2, num3, operation);
                break;
            case "%": num3 = Operations.remainder(num1, num2);
                printResult(num1, num2, num3, operation);
                break;
            case "^": num3 = Operations.exponentiation(num1, num2);
                printResult(num1, num2, num3, operation);
                break;
            case "min": num3 = Operations.minimum(num1, num2);
                printResult(num1, num2, num3, operation);
                break;
            case "max": num3 = Operations.maximum(num1, num2);
                printResult(num1, num2, num3, operation);
                break;
            default: System.out.println("Invalid operation");
        }
    }
}
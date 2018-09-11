import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) {
        double num1 = 0, num2 = 0, num3 = 0;
        String operation = "";
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter the first number: ");
            num1 = Double.parseDouble(read.readLine());
            System.out.println("Enter the second number: ");
            num2 = Double.parseDouble(read.readLine());
            System.out.println("Enter the operation (+, -, *, /): ");
            operation = read.readLine();
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
            case "+": num3 = num1 + num2;
                System.out.println("Result: " + num1 + " " + operation + " " + num2 + " = " + num3);
                break;
            case "-": num3 = num1 - num2;
                System.out.println("Result: " + num1 + " " + operation + " " + num2 + " = " + num3);
                break;
            case "*": num3 = num1 * num2;
                System.out.println("Result: " + num1 + " " + operation + " " + num2 + " = " + num3);
                break;
            case "/": num3 = num1 / num2;
                System.out.println("Result: " + num1 + " " + operation + " " + num2 + " = " + num3);
                break;
            default: System.out.println("Invalid operation");
        }
    }
}
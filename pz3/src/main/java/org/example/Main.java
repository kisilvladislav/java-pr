package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean calculationComplete = false;

        while (!calculationComplete) {
            try {
                System.out.println("Перше число:");
                double num1 = Double.parseDouble(scanner.nextLine());

                System.out.println("ВИБЕРИ ДІЮ (+, -, *, /):");
                String operation = scanner.nextLine();

                System.out.println("ДРУГЕ ЧИСЛО:");
                double num2 = Double.parseDouble(scanner.nextLine());

                double result = 0;
                switch (operation) {
                    case "+":
                        result = calculator.add(num1, num2);
                        break;
                    case "-":
                        result = calculator.subtract(num1, num2);
                        break;
                    case "*":
                        result = calculator.multiply(num1, num2);
                        break;
                    case "/":
                        try {
                            result = calculator.divide(num1, num2);
                        } catch (ArithmeticException e) {
                            System.out.println("ПОМИЛКА:( : " + e.getMessage());
                            continue;
                        }
                        break;
                    default:
                        throw new InvalidInputException("ПОМИЛКА:( : ЩОСЬ НЕ ТЕ...");
                }

                System.out.println("Результат: " + result);
                calculationComplete = true;

            } catch (NumberFormatException e) {
                System.out.println("ПОМИЛКА:( : ПРАВИЛЬНІ ЧИСЛА ВВОДЬ.");
            } catch (InvalidInputException e) {
                System.out.println("ПОМИЛКА:( : " + e.getMessage());
            } finally {
                System.out.println("СПРОБУЙ ЩЕ РАЗ ЯКЩО ПОМИЛИВСЯ).\n");
            }
        }

        scanner.close();
        System.out.println("ОБРОБКА ЗАВЕРШЕННА, ДЯКУЮ.");
    }
}
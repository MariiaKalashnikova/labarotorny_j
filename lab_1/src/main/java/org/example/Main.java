package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Уведіть рядок чисел, розділяючи їх комою або \\\\n, іншим своїм символом, не забувайте, як потрібно вводити власні роздільники:  ");
        StringCalculator num = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        String number = "";
        number = number + scanner.nextLine();
        System.out.println("\nСума: " + num.add(number));
        }
    }

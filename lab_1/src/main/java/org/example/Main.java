package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Уведіть рядок чисел, розділяючи їх комою, \\\\n або задайте його, наприклад \\\\\\\\;\\\\n, тут ; є роздільником: ");
        StringCalculator num = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        String number = "";
        number = number + scanner.nextLine();
        System.out.println(num.add(number));
        }
    }

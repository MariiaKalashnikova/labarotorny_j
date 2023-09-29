package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Уведіть рядок максимум з двох чисел, розділяючи їх комою: ");
        StringCalculator num = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        System.out.println(num.add(number));
        }
    }

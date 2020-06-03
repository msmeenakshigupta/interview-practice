package HackerRank;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * created by megupta on 4/23/19
 */
public class CurrencyFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();


        final NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        final NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        final NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        final NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        final String us = usFormat.format(payment);
        final String india = indiaFormat.format(payment);
        final String china = chinaFormat.format(payment);
        final String france = franceFormat.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}

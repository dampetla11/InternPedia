package Projects;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Currency {
    private String name;
    private double rate;

    public Currency(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public static double convert(double number, Currency c1, Currency c2) {
        double base = c1.rate;
        double dest = c2.rate;
        double result = (dest / base) * number;
        return result;
    }

    public static Map<Integer, Currency> currencies = new HashMap<>();

    static {
        currencies.put(0, new Currency("Rupees", 84.21));
        currencies.put(1, new Currency("CAD", 1.43));
        currencies.put(2, new Currency("AUS", 1.53));
        currencies.put(3, new Currency("Euro", 0.93));
        currencies.put(4, new Currency("Kuwaiti Dinar", 0.33));
        currencies.put(5, new Currency("USD", 1.00));
        currencies.put(6, new Currency("GBP", 0.82));
        currencies.put(7, new Currency("JPY", 134.21));
        currencies.put(8, new Currency("CNY", 6.93));
        // Add more currencies as needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available currencies:");
        for (Map.Entry<Integer, Currency> entry : currencies.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().name);
        }

        System.out.println("Enter the index of the source currency:");
        int sourceIndex = scanner.nextInt();

        System.out.println("Enter the index of the destination currency:");
        int destIndex = scanner.nextInt();

        System.out.println("Enter the amount to convert:");
        double amount = scanner.nextDouble();

        Currency c1 = currencies.get(sourceIndex);
        Currency c2 = currencies.get(destIndex);

        double convertedAmount = convert(amount, c1, c2);

        System.out.println("Converting " + amount + " " + c1.name + " to " + c2.name + ": " + convertedAmount);
    }
}
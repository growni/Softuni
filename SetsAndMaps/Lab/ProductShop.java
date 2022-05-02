package SetsAndMaps.Lab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        Map<String, Map<String, Double>> shopsInfo = new TreeMap<>();
        Map<String, Double> innerMap = new LinkedHashMap<>();
        while (!input[0].equals("Revision")) {
            String shop = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);

            shopsInfo.putIfAbsent(shop, new LinkedHashMap<>());
            innerMap = shopsInfo.get(shop);
            innerMap.putIfAbsent(product, price);
            System.out.println();

            input = scan.nextLine().split(", ");

        }
        for (var shop : shopsInfo.entrySet()) {

            System.out.printf("%s->%n", shop.getKey());
            for (Map.Entry<String, Double> product : shop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
            }
        }
    }
}

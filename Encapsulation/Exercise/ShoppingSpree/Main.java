package ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] peopleInput = scan.nextLine().split(";");
        Map<String, Person> peopleMap = new LinkedHashMap<>();
        for (String personInfo : peopleInput) {
            String personName = personInfo.split("=")[0];
            double personMoney = Double.parseDouble(personInfo.split("=")[1]);
            Person person = new Person(personName, personMoney);
            peopleMap.put(personName, person);
        }
        String[] productInput = scan.nextLine().split(";");
        Map<String, Product> productMap = new LinkedHashMap<>();
        for (String productInfo : productInput) {
            String productName = productInfo.split("=")[0];
            double productCost = Double.parseDouble(productInfo.split("=")[1]);
            Product product = new Product(productName, productCost);
            productMap.put(productName, product);
        }

        Map<String, List<String>> finalMap = new LinkedHashMap<>();
        String commands = scan.nextLine();
        while (!commands.equals("END")) {
            String personName = commands.split("\\s+")[0];
            String productName = commands.split("\\s+")[1];
            finalMap.putIfAbsent(personName, new ArrayList<>());
            try {
                peopleMap.get(personName).buyProduct(productMap.get(productName));
                finalMap.get(personName).add(productName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                commands = scan.nextLine();
                continue;
            }
            commands = scan.nextLine();
        }
            StringBuilder sb = new StringBuilder();
        for (var entry : finalMap.entrySet()) {
            sb.append(entry.getKey() + " - ");
            if(entry.getValue().isEmpty()) {
                sb.append("Nothing bought\n");
                continue;
            }
            sb.append(String.join(", ", entry.getValue()));
            sb.append("\n");
        }
        System.out.println(sb);
    }

}

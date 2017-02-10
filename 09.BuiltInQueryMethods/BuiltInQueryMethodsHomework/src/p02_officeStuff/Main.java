package p02_officeStuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Product>> productsByCompany = new HashMap<>();

        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = in.readLine().split("\\||\\s+\\-\\s+");
            String name = tokens[1];
            int amount = Integer.parseInt(tokens[2]);
            String productName = tokens[3];

            Product product = new Product(productName, amount);

            if (!productsByCompany.containsKey(name)) {
                productsByCompany.put(name, new ArrayList<>());
            }

            boolean hasFound = false;
            List<Product> currentProducts = productsByCompany.get(name);
            for (Product currentProduct : currentProducts) {
                if (currentProduct.getProductName().equals(productName)) {
                    currentProduct.setAmount(currentProduct.getAmount() + amount);
                    hasFound = true;
                    break;
                }
            }

            if (!hasFound) {
                currentProducts.add(product);
            }

            productsByCompany.put(name, currentProducts);
        }

        productsByCompany.entrySet().stream()
                .sorted((c1, c2) -> c1.getKey().compareTo(c2.getKey()))
                .forEach(c -> {
                    System.out.print(c.getKey() + ": ");

                    StringBuilder builder = new StringBuilder();
                    c.getValue().stream()
                            .forEach(p -> {
                                builder.append(p.getProductName() + "-" + p.getAmount() + ", ");
                            });

                    System.out.println(builder.delete(builder.length() - 2, builder.length()));
                });
    }

    public static class Product {
        private String productName;
        private int amount;

        public Product(String productName, int amount) {
            this.setProductName(productName);
            this.setAmount(amount);
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}



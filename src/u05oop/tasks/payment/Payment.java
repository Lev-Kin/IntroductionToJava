package u05oop.tasks.payment;

import java.util.HashMap;
import java.util.Map;

public class Payment {
    private Map<Product, Integer> productIntegerMap = new HashMap<>();

    public Map<Product, Integer> getProductIntegerMap() {
        return productIntegerMap;
    }

    public void setProductIntegerMap(Map<Product, Integer> productIntegerMap) {
        this.productIntegerMap = productIntegerMap;
    }

    public void purchaseMultipleTheAllGoods(Map<Product, Integer> productIntegerMap) {
        this.productIntegerMap.putAll(productIntegerMap);
    }

    public void purchaseMultipleTheSameGoods(Product product, int amount) {
        this.productIntegerMap.put(product, amount);
    }

    public double getTotalPayment() {
        return productIntegerMap.
                entrySet().
                stream().
                mapToDouble
                        (
                                productIntegerMap -> productIntegerMap.getKey().getPrice() *
                                        productIntegerMap.getValue()
                        ).
                sum();
    }

    public class Product {
        private String name;
        private double price;
        private double wight;

        public Product(String name, double price, double wight) {
            this.name = name;
            this.price = price;
            this.wight = wight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getWight() {
            return wight;
        }

        public void setWight(double wight) {
            this.wight = wight;
        }

        public void print() {
            System.out.printf("Tовар: %s цена %.2f вес %.2f\n", name, price, wight);
        }
    }
}

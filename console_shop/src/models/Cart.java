package models;


import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Кошик містить:\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        sb.append("Загальна вартість: ").append(getTotalPrice());
        return sb.toString();
    }

    public void clear() {
        products.clear();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}
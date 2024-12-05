import models.Cart;
import models.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Ноутбук Lenovo legion", 19999.99, "Для роботи та ігор");
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном");
        Product product3 = new Product(3, "Навушники", 2499.00, "Шумозаглушення");

        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Оформити замовлення");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання:");
                    int id = scanner.nextInt();
                    if (id == 1) cart.addProduct(product1);
                    else if (id == 2) cart.addProduct(product2);
                    else if (id == 3) cart.addProduct(product3);
                    else System.out.println("Товар не знайдено!");
                    break;
                case 3:
                    System.out.println(cart);
                    break;
                case 4:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній!");
                    } else {
                        System.out.println("Замовлення оформлено!");
                        System.out.println(cart);
                        cart.clear();
                    }
                    break;
                case 0:
                    System.out.println("Дякуємо за використання магазину!");
                    return;
                default:
                    System.out.println("Невідома команда, спробуйте ще раз.");
            }
        }
    }
}

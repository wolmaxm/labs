import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створення продуктів
        Product laptop = new Product("Laptop", 30000.0);
        Product phone = new Product("Phone", 10000.0);
        Product tablet = new Product("Tablet", 15000);

        // Створення магазинів
        InternetStore store1 = null;
        try {
            store1 = new InternetStore("Rozetka");
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка створення магазину: " + e.getMessage());
        }

        InternetStore store2 = null;
        try {
            store2 = new InternetStore("COMFY");
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка створення магазину: " + e.getMessage());
        }

        InternetStore store3 = null;
        try {
            store3 = new InternetStore("FOXTROT");
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка створення магазину: " + e.getMessage());
        }

        // Додавання продуктів до магазинів з обробкою винятків
        if (store1 != null) {
            try {
                store1.addProduct(laptop, 28000.0); // Успішно
                store1.addProduct(phone, 10000.0);  // Успішно
                store1.addProduct(tablet, 14000.0); // Успішно
            } catch (PriceAboveRecommendedException e) {
                System.err.println("Помилка при додаванні продукту: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Неправильний аргумент: " + e.getMessage());
            } finally {
                System.out.println("Спроба додати продукти до магазину '" + store1.getStoreName() + "' завершена.");
            }
        }

        if (store2 != null) {
            try {
                store2.addProduct(laptop, 31000.0); // Перевищує рекомендовану ціну
                store2.addProduct(phone, 9000.0);   // Успішно
                store2.addProduct(tablet, 13000.0); // Успішно
            } catch (PriceAboveRecommendedException e) {
                System.err.println("Помилка при додаванні продукту: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Неправильний аргумент: " + e.getMessage());
            } finally {
                System.out.println("Спроба додати продукти до магазину '" + store2.getStoreName() + "' завершена.");
            }
        }

        if (store3 != null) {
            try {
                store3.addProduct(laptop, 28000.0); // Успішно
                store3.addProduct(phone, 8000.0);   // Успішно
                store3.addProduct(tablet, 12000.0); // Успішно
            } catch (PriceAboveRecommendedException e) {
                System.err.println("Помилка при додаванні продукту: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Неправильний аргумент: " + e.getMessage());
            } finally {
                System.out.println("Спроба додати продукти до магазину '" + store3.getStoreName() + "' завершена.");
            }
        }

        // Створення списку магазинів
        InternetStoreList storeList = new InternetStoreList();
        try {
            storeList.addStore(store1);
            storeList.addStore(store2);
            storeList.addStore(store3);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка при додаванні магазину до списку: " + e.getMessage());
        }

        // Вивід списку магазинів та їхніх продуктів
        System.out.println("\nСписок магазинів та їхні товари:");
        storeList.showAllStores();
        System.out.println();

        // Пошук мінімальної ціни на продукт
        String searchProduct = "Phone";
        double minPrice = -1;
        try {
            minPrice = storeList.findMinimumPrice(searchProduct);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка при пошуку мінімальної ціни: " + e.getMessage());
        }

        if (minPrice != -1) {
            System.out.println("Мінімальна ціна на '" + searchProduct + "': " + minPrice);
        } else {
            System.out.println("Товар '" + searchProduct + "' не знайдено в жодному магазині.");
        }
        System.out.println();

        // Отримання магазинів з мінімальною ціною на продукт
        List<InternetStore> minPriceStores = new ArrayList<>();
        try {
            minPriceStores = storeList.getStoresWithMinimumPrice(searchProduct);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка при отриманні магазинів з мінімальною ціною: " + e.getMessage());
        }

        System.out.println("Магазини з мінімальною ціною на '" + searchProduct + "':");
        for (InternetStore store : minPriceStores) {
            System.out.println("  " + store.getStoreName());
        }
        System.out.println();

        // Перевірка, чи існує магазин, де всі товари дешевші за рекомендовані ціни
        boolean exists = storeList.hasStoreWithAllProductBelowRecommended();
        if (exists) {
            System.out.println("Є магазин, де всі товари дешевші за рекомендовані ціни виробника.");
        } else {
            System.out.println("Немає магазину, де всі товари дешевші за рекомендовані ціни виробника.");
        }

        // Додавання додаткового продукту з перевищенням рекомендованої ціни
        try {
            if (store1 != null) {
                store1.addProduct(new Product("Smartwatch", 5000.0), 6000.0); // Перевищує рекомендовану ціну
            }
        } catch (PriceAboveRecommendedException e) {
            System.err.println("Помилка при додаванні продукту: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Неправильний аргумент: " + e.getMessage());
        } finally {
            System.out.println("Спроба додати додатковий продукт завершена.");
        }

        // Демонстрація NullPointerException
        try {
            String str = null;
            System.out.println(str.length()); // Кине NullPointerException
        } catch (NullPointerException e) {
            System.err.println("Помилка: null об'єкт.");
        } finally {
            System.out.println("Перевірка NullPointerException завершена.");
        }

        // Демонстрація IllegalArgumentException
        try {
            throw new IllegalArgumentException("Неправильний аргумент вручну.");
        } catch (IllegalArgumentException e) {
            System.err.println("Виняток: " + e.getMessage());
        } finally {
            System.out.println("Перевірка IllegalArgumentException завершена.");
        }

        // Демонстрація ProductNotFoundException
        try {
            if (store1 != null) {
                store1.removeProduct("NonExistingProduct"); // Продукт не існує
            }
        } catch (ProductNotFoundException e) {
            System.err.println("Помилка при видаленні продукту: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Неправильний аргумент: " + e.getMessage());
        } finally {
            System.out.println("Спроба видалити неіснуючий продукт завершена.");
        }
    }
}

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 30000.0);
        Product phone = new Product("Phone", 10000);
        Product tablet = new Product("Tablet", 15000);

        InternetStore store1 = new InternetStore("Rozetka");
        store1.addProduct(laptop, 28000.0);
        store1.addProduct(phone, 10000.0);
        store1.addProduct(tablet, 14000.0);

        InternetStore store2 = new InternetStore("COMFY");
        store2.addProduct(laptop, 31000.0);
        store2.addProduct(phone, 9000.0);
        store2.addProduct(tablet, 13000.0);

        InternetStore store3 = new InternetStore("FOXTROT");
        store3.addProduct(laptop, 28000.0); // Рекомендована ціна
        store3.addProduct(phone, 8000.0); // Рекомендована ціна
        store3.addProduct(tablet, 12000.0); // Дорожчі

        InternetStoreList storeList = new InternetStoreList();
        storeList.addStore(store1);
        storeList.addStore(store2);
        storeList.addStore(store3);

        System.out.println("Список магазинів та їхні товари:");
        storeList.showAllStores();
        System.out.println();

        String searchProduct = "Phone";
        double minPrice = storeList.findMinimumPrice(searchProduct);
        if (minPrice != -1) {
            System.out.println("Мінімальна ціна на '" + searchProduct + "': " + minPrice);
        } else {
            System.out.println("Товар '" + searchProduct + "' не знайдено в жодному магазині.");
        }
        System.out.println();

        // Складання списку магазинів з мінімальною ціною на "Phone"
        Set<InternetStore> minPriceStores = storeList.getStoresWithMinimumPrice(searchProduct);
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
        System.out.println();

        // Додавання відгуків до магазинів
        storeList.addReview(store1, "Чудовий сервіс та швидка доставка.");
        storeList.addReview(store1, "Широкий вибір товарів.");
        storeList.addReview(store2, "Товари якісні, але ціни трохи високі.");
        storeList.addReview(store3, "Дуже задоволений покупкою.");

        // Виведення відгуків для кожного магазину
        for (InternetStore store : storeList.getStores()) {
            System.out.println("Відгуки для магазину " + store.getStoreName() + ":");
            List<String> reviews = storeList.getReviews(store);
            if (reviews.isEmpty()) {
                System.out.println("  Немає відгуків.");
            } else {
                for (String review : reviews) {
                    System.out.println("  - " + review);
                }
            }
            System.out.println();
        }
    }
}

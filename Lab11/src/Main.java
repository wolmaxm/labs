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

        InternetStoreSet storeSet = new InternetStoreSet();
        storeSet.addStore(store1);
        storeSet.addStore(store2);
        storeSet.addStore(store3);

        System.out.println("Список магазинів та їхні товари:");
        storeSet.showAllStores();
        System.out.println();

        String searchProduct = "Phone";
        double minPrice = storeSet.findMinimumPrice(searchProduct);
        if (minPrice != -1) {
            System.out.println("Мінімальна ціна на '" + searchProduct + "': " + minPrice);
        } else {
            System.out.println("Товар '" + searchProduct + "' не знайдено в жодному магазині.");
        }
        System.out.println();

        // Складання списку магазинів з мінімальною ціною на "Ноутбук"
        Set<InternetStore> minPriceStores = storeSet.getStoresWithMinimumPrice(searchProduct);
        System.out.println("Магазини з мінімальною ціною на '" + searchProduct + "':");
        for (InternetStore store : minPriceStores) {
            System.out.println("  " + store.getStoreName());
        }
        System.out.println();

        // Перевірка, чи існує магазин, де всі товари дешевші за рекомендовані ціни
        boolean exists = storeSet.hasStoreWithAllProductBelowRecommended();
        if (exists) {
            System.out.println("Є магазин, де всі товари дешевші за рекомендовані ціни виробника.");
        } else {
            System.out.println("Немає магазину, де всі товари дешевші за рекомендовані ціни виробника.");
        }
    }
}

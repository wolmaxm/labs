import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class InternetStoreList {
    private final Set<InternetStore> stores;
    private final Map<InternetStore, List<String>> storeReviews; // Нове поле для відгуків

    public InternetStoreList() {
        this.stores = new HashSet<>();
        this.storeReviews = new HashMap<>();
    }

    public void addStore(InternetStore store) {
        if (store == null) {
            throw new IllegalArgumentException("Store cannot be null");
        }
        stores.add(store);
        storeReviews.putIfAbsent(store, new ArrayList<>()); // Ініціалізація списку відгуків
    }

    public double findMinimumPrice(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        double minPrice = Double.MAX_VALUE;

        for (InternetStore store : stores) {
            for (Map.Entry<Product, Double> entry : store.getProductPrices().entrySet()) {
                if (entry.getKey().getProductName().equalsIgnoreCase(productName)) {
                    if (entry.getValue() < minPrice) {
                        minPrice = entry.getValue();
                    }
                }
            }
        }

        return minPrice == Double.MAX_VALUE ? -1 : minPrice;
    }

    public Set<InternetStore> getStoresWithMinimumPrice(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        Set<InternetStore> resultStores = new HashSet<>();
        double minPrice = findMinimumPrice(productName);

        if (minPrice == -1) {
            return resultStores;
        }

        for (InternetStore store : stores) {
            for (Map.Entry<Product, Double> entry : store.getProductPrices().entrySet()) {
                if (entry.getKey().getProductName().equalsIgnoreCase(productName) && entry.getValue() == minPrice) {
                    resultStores.add(store);
                    break;
                }
            }
        }
        return resultStores;
    }

    public boolean hasStoreWithAllProductBelowRecommended() {
        for (InternetStore store : stores) {
            boolean allBelow = true;
            for (Map.Entry<Product, Double> entry : store.getProductPrices().entrySet()) {
                if (entry.getValue() >= entry.getKey().getRecommendedProductPrice()) {
                    allBelow = false;
                    break;
                }
            }
            if (allBelow) {
                return true;
            }
        }
        return false;
    }

    public void showAllStores() {
        for (InternetStore store : stores) {
            System.out.println(store);
            for (Map.Entry<Product, Double> entry : store.getProductPrices().entrySet()) {
                System.out.println("  " + entry.getKey().getProductName() + ": " + entry.getValue());
            }
        }
    }

    public Set<InternetStore> getStores() {
        return Collections.unmodifiableSet(stores);
    }

    // Нова функціональність: Додавання відгуку до магазину
    public void addReview(InternetStore store, String review) {
        if (store == null || review == null || review.trim().isEmpty()) {
            throw new IllegalArgumentException("Store and review cannot be null or empty");
        }
        List<String> reviews = storeReviews.get(store);
        if (reviews != null) {
            reviews.add(review);
        } else {
            throw new IllegalArgumentException("Store does not exist in the list");
        }
    }

    // Нова функціональність: Отримання відгуків для магазину
    public List<String> getReviews(InternetStore store) {
        if (store == null) {
            throw new IllegalArgumentException("Store cannot be null");
        }
        return storeReviews.getOrDefault(store, Collections.emptyList());
    }
}

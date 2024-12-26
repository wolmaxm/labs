import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InternetStore {
    private final String storeName;
    private final Map<Product, Double> productPrices;

    public InternetStore(String storeName) {
        if (storeName == null || storeName.trim().isEmpty()) {
            throw new IllegalArgumentException("Store name cannot be null or empty");
        }
        this.storeName = storeName;
        this.productPrices = new HashMap<>();
    }

    public String getStoreName() {
        return storeName;
    }

    public void addProduct(Product product, double price) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        productPrices.put(product, price);
    }

    public Map<Product, Double> getProductPrices() {
        return productPrices;
    }

    @Override
    public String toString() {
        return "InternetStore {storeName=" + storeName + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InternetStore that = (InternetStore) o;

        return Objects.equals(storeName, that.storeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeName);
    }
}

public class Product {
    private String productName;
    private double recommendedProductPrice;

    public Product(String productName, double recommendedProductPrice) {
        this.productName = productName;
        this.recommendedProductPrice = recommendedProductPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getRecommendedProductPrice() {
        return recommendedProductPrice;
    }

    @Override
    public String toString() {
        return "Product [productName=" + productName + ", recommendedProductPrice= " + recommendedProductPrice + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return productName.hashCode();
    }
}

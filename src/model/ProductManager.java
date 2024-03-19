package model;

import java.util.*;

public class ProductManager implements  Productmanagement {
    private List<Product> products = new ArrayList<>();
    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void editProduct(String name, Product newProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                products.set(i, newProduct);
                break;
            }
        }

    }

    @Override
    public void deleteProduct(String name) {
        products.removeIf(product -> product.getName().equals(name));

    }

    @Override
    public List<Product> searchByName(String keyword) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public List<Product> searchByPriceRange(double minPrice, double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public List<Product> sortByPriceAscending() {
        List<Product> sortedProducts = new ArrayList<>(products);
        Collections.sort(sortedProducts, Comparator.comparingDouble(Product::getPrice));
        return sortedProducts;
    }

    @Override
    public List<Product> sortByPriceDescending() {
        List<Product> sortedProducts = sortByPriceAscending();
        Collections.reverse(sortedProducts);
        return sortedProducts;
    }

    @Override
    public List<Product> sortByQuantityDescending() {
        List<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort(Comparator.comparingInt(Product::getQuantity).reversed());
        return sortedProducts;
    }

    @Override
    public List<Product> searchByBrand(String brand) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getBrand().equalsIgnoreCase(brand)) {
                result.add(product);
            }
        }
        return result;
    }
}

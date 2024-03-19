package model;

import java.util.List;

public interface Productmanagement {
    void addProduct(Product product);

    void editProduct(String name, Product newProduct);

    void deleteProduct(String name);

    List<Product> searchByName(String keyword);

    List<Product> searchByPriceRange(double minPrice, double maxPrice);

    List<Product> sortByPriceAscending();

    List<Product> sortByPriceDescending();

    List<Product> sortByQuantityDescending();

    List<Product> searchByBrand(String brand);

}

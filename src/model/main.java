package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        // Tạo và thêm sản phẩm vào danh sách
        Product A = new Product("sp1", 500, 15, "a");
        Product B = new Product("sp2", 300, 20, "b");
        productManager.addProduct(A);
        productManager.addProduct(B);

        while (true) {
            System.out.println("---Menu---"
                    + "\n1. Xem danh sach"
                    + "\n2. Tim kiem  "
                    + "\n3. Sap xep theo gia tang dan"
                    + "\n4. Sap xep theo gia giam dan"
                    + "\n5. Sap xep theo so luong giam dan"
                    + "\n6. Tim theo hang "
                    + "\n7. Tim theo khoang gia "
                    + "\n8. Thoat "
            );
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                // Hiển thị danh sách sản phẩm
                List<Product> productList = productManager.sortByPriceAscending();
                displayList(productList);
            } else if (choice == 2) {
                // Thực hiện tìm kiếm
                System.out.println("Nhap tu khoa tim kiem :");
                Scanner scanner1 = new Scanner(System.in);
                String key = scanner1.nextLine();
                List<Product> searchResult = productManager.searchByName(key);
                if (searchResult.isEmpty()) {
                    System.out.println("Khong tim thay ket qua.");
                } else {
                    displayList(searchResult);
                }
            } else if (choice == 3) {
                // Sắp xếp theo giá tăng dần
                List<Product> productList = productManager.sortByPriceAscending();
                displayList(productList);
            } else if (choice == 4) {
                // Sắp xếp theo giá giảm dần
                List<Product> productList = productManager.sortByPriceDescending();
                displayList(productList);
            } else if (choice == 5) {
                // Sắp xếp theo số lượng giảm dần
                List<Product> productList = productManager.sortByQuantityDescending();
                displayList(productList);
            } else if (choice == 6) {
                // Tìm kiếm theo hãng
                System.out.println("Nhap ten hang: ");
                Scanner scanner2 = new Scanner(System.in);
                String brand = scanner2.nextLine();
                List<Product> brandSearchResult = productManager.searchByBrand(brand);
                if (brandSearchResult.isEmpty()) {
                    System.out.println("Khong tim thay ket qua.");
                } else {
                    displayList(brandSearchResult);
                }
            } else if (choice == 7) {
                // Tìm kiếm theo khoảng giá
                System.out.println("Nhap gia tri min: ");
                Scanner scanner3 = new Scanner(System.in);
                double minPrice = scanner3.nextDouble();
                System.out.println("Nhap gia tri max: ");
                double maxPrice = scanner3.nextDouble();
                List<Product> priceRangeSearchResult = productManager.searchByPriceRange(minPrice, maxPrice);
                if (priceRangeSearchResult.isEmpty()) {
                    System.out.println("Khong tim thay ket qua.");
                } else {
                    displayList(priceRangeSearchResult);
                }
            } else if (choice == 8) {
                System.out.println("Thoat chuong trinh.");
                System.exit(0);
            } else {
                System.out.println("Lua chon khong hop le.");
            }
        }
    }

    // Phương thức để hiển thị danh sách sản phẩm
    public static void displayList(List<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("Danh sach rong.");
        } else {
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }
}

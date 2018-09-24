package co.com.cedesistemas.features.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private ProductRepository productRepository = new ProductRepository();

    protected List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            products = productRepository.getAllProducts();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return products;
    }

    protected void addProduct(Product product) {
        try {
            productRepository.addProduct(product);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    protected void removeAction(Integer id) {
        try {
            productRepository.removeProduct(id);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    protected void updateAction(Product product) {
        try {
            productRepository.updateProduct(product);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    protected void readAction() {
        //products.add(new Product(7, "Chanclas", "Chanclas de goma", 50, 6600.0));
    }


}

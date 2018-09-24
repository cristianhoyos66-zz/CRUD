package co.com.cedesistemas.features.product;

import co.com.cedesistemas.shared.database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP-15-AX2005la on 23/09/2018.
 */
public class ProductRepository {

    protected void addProduct(Product product) throws SQLException {
        StringBuilder insStatement = new StringBuilder()
                .append("'" + product.getName() + "', ")
                .append("'" + product.getDescription() + "', ")
                .append(product.getQuantity() + ", ")
                .append(product.getPrice());
        String statement = "INSERT INTO tbl_product (name, description, quantity, price) VALUES ( " + insStatement.toString() + " )";
        try (PreparedStatement preparedStatement = DBConnect.getCon().prepareStatement(statement)) {
            preparedStatement.execute();
        }
    }

    protected List<Product> getAllProducts() throws SQLException {
        String statement = "SELECT * FROM tbl_product";
        List<Product> products;
        try (ResultSet rs = DBConnect.getCon().createStatement().executeQuery(statement)) {
            products = new ArrayList<>();
            while (rs.next()) {
                products.add(
                        new Product(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getInt("quantity"),
                                rs.getDouble("price")
                        )
                );
            }
        }
        return products;
    }

    protected void removeProduct(Integer id) throws SQLException {
        String statement = "DELETE FROM tbl_product WHERE id = " + id;
        try (PreparedStatement preparedStatement = DBConnect.getCon().prepareStatement(statement)) {
            preparedStatement.execute();
        }
    }

    protected void updateProduct(Product product) throws SQLException {
        StringBuilder statement = new StringBuilder()
                .append("UPDATE tbl_product SET ")
                .append("name = '" + product.getName() + "', ")
                .append("description = '" + product.getDescription() + "', ")
                .append("quantity = " + product.getQuantity() + ", ")
                .append("price = " + product.getPrice())
                .append(" WHERE id = " + product.getId());

        try (PreparedStatement preparedStatement = DBConnect.getCon().prepareStatement(statement.toString())) {
            preparedStatement.execute();
        }
    }

}

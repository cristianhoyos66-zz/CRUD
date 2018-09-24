package co.com.cedesistemas.features.product;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProductTableModel extends AbstractTableModel {

    private List<Product> products;
    private String[] columnNames = {
            "Id",
            "name",
            "description",
            "quantity",
            "price"
    };

    public ProductTableModel(List<Product> products) {
        this.products = products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return products.get(rowIndex).getId();
            case 1:
                return products.get(rowIndex).getName();
            case 2:
                return products.get(rowIndex).getDescription();
            case 3:
                return products.get(rowIndex).getQuantity();
            case 4:
                return products.get(rowIndex).getPrice();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}

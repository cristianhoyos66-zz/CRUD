package co.com.cedesistemas.features.product;

import co.com.cedesistemas.shared.GUI;
import co.com.cedesistemas.shared.GuiPreparator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by HP-15-AX2005la on 18/09/2018.
 */
public class ProductGUI extends GuiPreparator implements GUI {

    private JLabel lblId, lblName, lblDescription, lblQuantity, lblPrice;
    private JTextField txtId, txtName, txtDescription, txtQuantity, txtPrice;
    private JButton btnAdd, btnRemove, btnUpdate, btnRead;
    private JTable jTable;
    private ProductService productService = new ProductService();
    private ProductTableModel productTableModel = new ProductTableModel(productService.getAllProducts());

    public ProductGUI() {
        super("Productos", new Dimension(900, 900));
        createLabels();
        createTextFields();
        createButtons();
        createTable();
        extraConstraints();
        showFrame(true);
    }

    @Override
    public void createLabels() {
        lblName = (JLabel) addLabel(new Rectangle(200, 100, 100, 20), "Nombre: ");
        lblDescription = (JLabel) addLabel(new Rectangle(200, 150, 100, 20), "Description: ");
        lblQuantity = (JLabel) addLabel(new Rectangle(200, 200, 100, 20), "Quantity: ");
        lblPrice = (JLabel) addLabel(new Rectangle(200, 250, 100, 20), "Price: ");
    }

    @Override
    public void createTextFields() {
        txtName = (JTextField) addTextField(new Rectangle(350, 100, 200, 30), "");
        txtDescription = (JTextField) addTextField(new Rectangle(350, 150, 200, 30), "");
        txtQuantity = (JTextField) addTextField(new Rectangle(350, 200, 200, 30), "");
        txtPrice = (JTextField) addTextField(new Rectangle(350, 250, 200, 30), "");
    }

    @Override
    public void createButtons() {
        btnAdd = (JButton) addButton(new Rectangle(80, 400, 150, 30), "Agregar");
        btnRemove = (JButton) addButton(new Rectangle(280, 400, 150, 30), "Eliminar");
        btnUpdate = (JButton) addButton(new Rectangle(480, 400, 150, 30), "Actualizar");
        btnRead = (JButton) addButton(new Rectangle(680, 400, 150, 30), "Consultar");
        addActions();
    }

    private void addActions() {
        addAction();
        removeAction();
        updateAction();
        readAction();
    }

    private void addAction() {
        btnAdd.addActionListener(event -> {
            productService.addProduct(new Product(
                    txtName.getText(),
                    txtDescription.getText(),
                    Integer.valueOf(txtQuantity.getText()),
                    Double.valueOf(txtPrice.getText())
            ));
            productTableModel.setProducts(productService.getAllProducts());
            productTableModel.fireTableDataChanged();
        });
    }

    private void removeAction() {
        btnRemove.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Por favor digite el id del elemento a eliminar");
            productService.removeAction(Integer.valueOf(id));
            productTableModel.setProducts(productService.getAllProducts());
            productTableModel.fireTableDataChanged();
        });
    }

    private void updateAction() {
        btnUpdate.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Por favor digite el id del elemento a actualizar");
            productService.updateAction(new Product(
                    Integer.valueOf(id),
                    txtName.getText(),
                    txtDescription.getText(),
                    Integer.valueOf(txtQuantity.getText()),
                    Double.valueOf(txtPrice.getText())
            ));
            productTableModel.setProducts(productService.getAllProducts());
            productTableModel.fireTableDataChanged();
        });
    }

    private void readAction() {
        btnRead.addActionListener(e -> {

        });
    }

    private void createTable() {
        jTable = (JTable) addTable(productTableModel);
    }

    private void extraConstraints() {
        txtQuantity.addKeyListener(this);
    }
}

package co.com.cedesistemas.shared;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by HP-15-AX2005la on 18/09/2018.
 */
public class GuiPreparator implements KeyListener {

    private JFrame mainFrame;

    public GuiPreparator(String title, Dimension dimension) {
        prepareGui(title, dimension);
        addDefaultEventsToFrame();
    }

    private void prepareGui(String title, Dimension dimension) {
        mainFrame = new JFrame(title);
        mainFrame.setSize(dimension);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
    }

    private void addDefaultEventsToFrame() {
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    protected Component addTable(TableModel tableModel) {
        JTable table = new JTable(tableModel);
        mainFrame.getContentPane().add(instantiateTable(table));
        return table;
    }

    private JScrollPane instantiateTable(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 500, 875, 300);

        return scrollPane;
    }

    protected Component addLabel(Rectangle rectangle, String text) {
        return mainFrame.add(instantiateLabel(rectangle, text));
    }

    private JLabel instantiateLabel(Rectangle rectangle, String text) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(rectangle);
        lbl.setFont(new Font("Roboto", Font.BOLD, 15));
        //lbl.setBorder(new BevelBorder(BevelBorder.LOWERED));
        return lbl;
    }

    protected Component addTextField(Rectangle rectangle, String text) {
        return mainFrame.add(instantiateTextField(rectangle, text));
    }

    private JTextField instantiateTextField(Rectangle rectangle, String text) {
        JTextField txt = new JTextField(text);
        txt.setBounds(rectangle);
        txt.setFont(new Font("Roboto", Font.BOLD, 15));
        return txt;
    }

    protected Component addButton(Rectangle rectangle, String text) {
        return mainFrame.add(instantiateButton(rectangle, text));
    }

    private JButton instantiateButton(Rectangle rectangle, String text) {
        JButton btn = new JButton(text);
        btn.setBounds(rectangle);
        btn.setFont(new Font("Roboto", Font.BOLD, 15));
        return btn;
    }

    public void showFrame(Boolean show) {
        mainFrame.setVisible(show);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char enter = e.getKeyChar();
        if (!(Character.isDigit(enter))) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // this is empty as far as it doesn't need be used
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // this is empty as far as it doesn't need be used
    }
}

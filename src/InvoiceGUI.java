import javax.swing.*;
import java.awt.event.*;

public class InvoiceGUI extends JFrame {
    private JTextField nameField, addressField, productField, priceField, quantityField;
    private JTextArea outputArea;
    private Invoice invoice;

    public InvoiceGUI() {
        setTitle("Invoice Application");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setBounds(20, 20, 120, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 20, 200, 25);
        add(nameField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(20, 60, 120, 25);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(150, 60, 200, 25);
        add(addressField);

        JLabel productLabel = new JLabel("Product Name:");
        productLabel.setBounds(20, 100, 120, 25);
        add(productLabel);

        productField = new JTextField();
        productField.setBounds(150, 100, 200, 25);
        add(productField);

        JLabel priceLabel = new JLabel("Unit Price:");
        priceLabel.setBounds(20, 140, 120, 25);
        add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(150, 140, 200, 25);
        add(priceField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(20, 180, 120, 25);
        add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(150, 180, 200, 25);
        add(quantityField);

        JButton addButton = new JButton("Create Invoice");
        addButton.setBounds(150, 220, 150, 30);
        add(addButton);

        outputArea = new JTextArea();
        outputArea.setBounds(20, 270, 440, 150);
        add(outputArea);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Customer customer = new Customer(
                        nameField.getText(),
                        addressField.getText()
                );

                invoice = new Invoice(customer);

                Product product = new Product(
                        productField.getText(),
                        Double.parseDouble(priceField.getText())
                );

                LineItem item = new LineItem(
                        product,
                        Integer.parseInt(quantityField.getText())
                );

                invoice.addItem(item);

                outputArea.setText(invoice.generateInvoice());
            }
        });
    }

    public static void main(String[] args) {
        new InvoiceGUI().setVisible(true);
    }
}

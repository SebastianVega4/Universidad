package Interface;

import logic.LogicCustomer;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUICartPanel extends LogicCustomer {
    private final JPanel panel;

    public GUICartPanel(GUIstore guiStore) {
        panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("Resourses\\Icons\\Shopping.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, panel.getWidth(), panel.getHeight(), this);
            }
        };

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        ImageIcon imageLogo = new ImageIcon("Resourses\\Icons\\Logo.png");
        Image imageLog = imageLogo.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledImageLogo = new ImageIcon(imageLog);
        JLabel imgLog = new JLabel(scaledImageLogo);
        topPanel.add(imgLog, BorderLayout.WEST);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        GridBagConstraints gbcCart = new GridBagConstraints();
        gbcCart.insets = new Insets(10, 10, 10, 10);

        JLabel imagePro = new JLabel("Imagen");
        imagePro.setForeground(Color.WHITE);
        JLabel nameLabelTitle = new JLabel("Nombre");
        nameLabelTitle.setForeground(Color.WHITE);
        JLabel priceLabelTitle = new JLabel("Precio");
        priceLabelTitle.setForeground(Color.WHITE);
        JLabel numberLabel = new JLabel("Cantidad");
        numberLabel.setForeground(Color.WHITE);

        gbcCart.gridy++;
        gbcCart.gridx++;
        centerPanel.add(imagePro, gbcCart);
        gbcCart.gridx++;
        centerPanel.add(nameLabelTitle, gbcCart);
        gbcCart.gridx++;
        centerPanel.add(priceLabelTitle, gbcCart);
        gbcCart.gridx++;
        centerPanel.add(numberLabel, gbcCart);
        gbcCart.gridx++;

        ImageIcon eraseIcon = new ImageIcon("Resourses\\Icons\\eraseCar.png");
        Image eraseImage = eraseIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledEraseIcon = new ImageIcon(eraseImage);

        for (Product product : GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getShoppingCart().getProducts()) {
            ImageIcon imageProduct = new ImageIcon("Resourses\\Icons\\" + product.getId() + ".png");
            Image image = imageProduct.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon scaledImageProduct = new ImageIcon(image);
            JLabel imgProduct = new JLabel(scaledImageProduct);

            JLabel nameLabel = new JLabel(product.getNameProduct());
            nameLabel.setForeground(Color.WHITE);
            JLabel priceLabel = new JLabel("$" + product.getPrice());
            priceLabel.setForeground(Color.WHITE);
            JLabel purchased = new JLabel(String.valueOf(GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getShoppingCart().getPurchased(product)));
            purchased.setForeground(Color.WHITE);
            JButton removeButton = new JButton("Eliminar del Carrito", scaledEraseIcon);
            removeButton.setFont(new Font("Serif", Font.ITALIC, 12));
            removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            gbcCart.gridy++;
            gbcCart.gridx = 0;
            centerPanel.add(imgProduct, gbcCart);
            gbcCart.gridx++;
            centerPanel.add(nameLabel, gbcCart);
            gbcCart.gridx++;
            centerPanel.add(priceLabel, gbcCart);
            gbcCart.gridx++;
            centerPanel.add(purchased, gbcCart);
            gbcCart.gridx++;
            centerPanel.add(removeButton, gbcCart);

            removeButton.addActionListener(e -> {
                eraseProductCart(product);
                JOptionPane.showMessageDialog(guiStore.getFrame(), "Producto eliminado del carrito.");
                guiStore.showCartPanel();
            });
        }
        JLabel totalLabel = new JLabel("Total: $" + GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getShoppingCart().calcTotal());
        totalLabel.setForeground(Color.WHITE);
        gbcCart.gridy++;
        gbcCart.gridx = 3;
        centerPanel.add(totalLabel, gbcCart);

        ImageIcon clearIcon = new ImageIcon("Resourses\\Icons\\vaciarCar1.png");
        Image clearImage = clearIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledClaerIcon = new ImageIcon(clearImage);
        JButton clearButton = new JButton(" Vaciar  carrito \n  ", scaledClaerIcon);
        clearButton.setFont(new Font("Serif", Font.ITALIC, 12));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.black);
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gbcCart.gridy++;
        gbcCart.gridx = -1;
        centerPanel.add(clearButton, gbcCart);

        ImageIcon checkoutIcon = new ImageIcon("Resourses\\Icons\\checkout.png");
        Image checkoutImage = checkoutIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledCheckoutIcon = new ImageIcon(checkoutImage);
        JButton checkoutButton = new JButton("Realizar Pedido", scaledCheckoutIcon);
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setBackground(Color.black);
        checkoutButton.setFont(new Font("Serif", Font.ITALIC, 14));
        checkoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gbcCart.gridx = 4;
        centerPanel.add(checkoutButton, gbcCart);

        JPanel buttomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttomPanel.setOpaque(false);

        ImageIcon backIcon = new ImageIcon("Resourses\\Icons\\back.png");
        Image backImage = backIcon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon scaledBackIcon = new ImageIcon(backImage);
        JButton backButton = new JButton("Atrás", scaledBackIcon);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.black);
        backButton.setFont(new Font("Serif", Font.ITALIC, 11));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttomPanel.add(backButton);

        JPanel backgroundPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("Resourses\\Icons\\Shopping.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, backgroundImage.getIconWidth() + 500, backgroundImage.getIconHeight(), this);
            }
        };
        JScrollPane scrollPanel = new JScrollPane(backgroundPanel);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        backgroundPanel.add(centerPanel, BorderLayout.CENTER);

        panel.add(topPanel, BorderLayout.PAGE_START);
        panel.add(scrollPanel, BorderLayout.CENTER);
        panel.add(buttomPanel, BorderLayout.PAGE_END);

        clearButton.addActionListener(e -> {
            clearCart();
            guiStore.showCustomerMenuPanel();
        });

        checkoutButton.addActionListener(e -> {
            try {
                if (ifAdressIsNull()) {
                    makePurchase(JOptionPane.showInputDialog(guiStore.getFrame(), "Ingrese su dirección de envío:"));
                    if (!ifAdressIsNull()) {
                        JOptionPane.showMessageDialog(guiStore.getFrame(), getFacture());
                        clearCart();
                    }
                } else {
                    makePurchase();
                    JOptionPane.showMessageDialog(guiStore.getFrame(), getFacture());
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            guiStore.showCustomerMenuPanel();
        });

        backButton.addActionListener(e -> guiStore.showCustomerMenuPanel());
    }

    public JPanel getPanel() {
        return panel;
    }
}
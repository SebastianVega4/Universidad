package Interface;

import logic.LogicCustomer;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUICatalogPanel extends LogicCustomer {
    private final JPanel panel;

    public GUICatalogPanel(GUIstore guiStore) {
        panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("Resourses\\Icons\\Catal.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, panel.getWidth(), panel.getHeight(), this);
            }
        };

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        ImageIcon imageLogo = new ImageIcon("Resourses\\Icons\\Logo.png");
        Image imageL = imageLogo.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledImageLogo = new ImageIcon(imageL);
        JLabel imgLogo = new JLabel(scaledImageLogo);
        topPanel.add(imgLogo, BorderLayout.WEST);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        GridBagConstraints gbcProduct = new GridBagConstraints();
        gbcProduct.insets = new Insets(10, 10, 10, 10);


        JLabel imageProTitle = new JLabel("Imagen");
        imageProTitle.setForeground(Color.WHITE);
        JLabel nameLabelTitle = new JLabel("Nombre");
        nameLabelTitle.setForeground(Color.WHITE);
        JLabel descriptionLabelTitle = new JLabel("Descripción");
        descriptionLabelTitle.setForeground(Color.WHITE);
        JLabel priceLabelTitle = new JLabel("Precio");
        priceLabelTitle.setForeground(Color.WHITE);
        JLabel numberLabelTitle = new JLabel("Cantidad");
        numberLabelTitle.setForeground(Color.WHITE);

        gbcProduct.gridy++;
        gbcProduct.gridx++;
        centerPanel.add(imageProTitle, gbcProduct);
        gbcProduct.gridx++;
        centerPanel.add(nameLabelTitle, gbcProduct);
        gbcProduct.gridx++;
        centerPanel.add(descriptionLabelTitle, gbcProduct);
        gbcProduct.gridx++;
        centerPanel.add(priceLabelTitle, gbcProduct);
        gbcProduct.gridx++;
        centerPanel.add(numberLabelTitle, gbcProduct);

        ImageIcon addIcon = new ImageIcon("Resourses\\Icons\\add.png");
        Image addImage = addIcon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon scaledAddIcon = new ImageIcon(addImage);

        for (Product product : GUIstore.getInventory().getProducts()) {
            ImageIcon imageProduct = new ImageIcon("Resourses\\Icons\\" + product.getId() + ".png");
            Image image = imageProduct.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon scaledImageProduct = new ImageIcon(image);
            JLabel imgProduct = new JLabel(scaledImageProduct);

            JLabel nameLabel = new JLabel(product.getNameProduct());
            nameLabel.setForeground(Color.WHITE);
            nameLabel.setFont(new Font("Serif", Font.ITALIC, 12));
            JLabel descriptionLabel = new JLabel(product.getDescription());
            descriptionLabel.setForeground(Color.WHITE);
            descriptionLabel.setFont(new Font("Serif", Font.ITALIC, 12));
            JLabel priceLabel = new JLabel("$" + product.getPrice());
            priceLabel.setForeground(Color.WHITE);
            priceLabel.setFont(new Font("Serif", Font.ITALIC, 12));
            JSpinner buys = new JSpinner();
            JButton addButton = new JButton("Agregar al Carrito", scaledAddIcon);
            addButton.setFont(new Font("Serif", Font.ITALIC, 14));
            addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            gbcProduct.gridy++;
            gbcProduct.gridx = 0;
            centerPanel.add(imgProduct, gbcProduct);
            gbcProduct.gridx++;
            centerPanel.add(nameLabel, gbcProduct);
            gbcProduct.gridx++;
            centerPanel.add(descriptionLabel, gbcProduct);
            gbcProduct.gridx++;
            centerPanel.add(priceLabel, gbcProduct);
            gbcProduct.gridx++;
            centerPanel.add(buys, gbcProduct);
            gbcProduct.gridx++;
            centerPanel.add(addButton, gbcProduct);

            buys.addChangeListener(e -> addNumberPurchesed(product, (Integer) buys.getValue()));

            addButton.addActionListener(e -> {
                if ((Integer) buys.getValue() == 0)
                    JOptionPane.showMessageDialog(guiStore.getFrame(), "Ingrese alguna cantidad.");
                else if ((Integer) buys.getValue() < 0)
                    JOptionPane.showMessageDialog(guiStore.getFrame(), "No se pueden añadir al carrito cantidades negativas.");
                else if ((Integer) buys.getValue() > product.getStock())
                    JOptionPane.showMessageDialog(guiStore.getFrame(), "No hay suficiente Stock del Articulo: '" + product.getNameProduct());
                else if ((Integer) buys.getValue() > 0) {
                    JOptionPane.showMessageDialog(guiStore.getFrame(), (addPurchased(product)));
                }
            });

            imgProduct.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    Image image = imageProduct.getImage().getScaledInstance(130, 190, Image.SCALE_SMOOTH);
                    ImageIcon scaledImageProduct = new ImageIcon(image);
                    imgProduct.setIcon(scaledImageProduct);
                }
                public void mouseExited(MouseEvent evt) {
                    Image image = imageProduct.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    ImageIcon scaledImageProduct = new ImageIcon(image);
                    imgProduct.setIcon(scaledImageProduct);
                }
            });
        }

        JPanel buttomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttomPanel.setOpaque(false);

        ImageIcon backIcon = new ImageIcon("Resourses\\Icons\\back.png");
        Image backImage = backIcon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon scaledBackIcon = new ImageIcon(backImage);
        JButton backButton = new JButton("Atrás", scaledBackIcon);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.black);
        backButton.setFont(new Font("Serif", Font.ITALIC, 14));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttomPanel.add(backButton);


        JPanel backgroundPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("Resourses\\Icons\\Catal.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, backgroundImage.getIconWidth() + 500, backgroundImage.getIconHeight(), this);
            }
        };
        JScrollPane scrollPanel = new JScrollPane(backgroundPanel);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        backgroundPanel.add(centerPanel, BorderLayout.CENTER);

        panel.add(topPanel, BorderLayout.PAGE_START);
        panel.add(scrollPanel, BorderLayout.CENTER);
        panel.add(buttomPanel, BorderLayout.PAGE_END);

        backButton.addActionListener(e -> guiStore.showCustomerMenuPanel());
    }

    public JPanel getPanel() {
        return panel;
    }
}
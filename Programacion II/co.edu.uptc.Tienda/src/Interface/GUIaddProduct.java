package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import logic.LogicAdmin;
import persistence.ImageProducts;

public class GUIaddProduct extends JFrame implements ActionListener {

	private JPanel JPproduct, JPcontenido, JPbuttons, JPbackgroud;
	private JLabel JLname, JLdescription, JLprice, JLstock;
	private JTextArea JTname, JTdescription, JTprice;
	private JSpinner JSstock;
	private JButton JBsave, JBcancel, JBicono;
	private int index;
	private LogicAdmin LA;
	private ImageProducts ip;

	public GUIaddProduct() {
		LA = new LogicAdmin();
		ip = new ImageProducts();
		this.index = LA.newIndex();

		JPproduct = new JPanel();
		JPcontenido = new JPanel(new GridLayout(4, 2, 10, 10));
		JPbuttons = new JPanel(new GridLayout(1, 2, 40, 40));
		JPbackgroud = new JPanel();
		JLname = new JLabel("Nombre");
		JLdescription = new JLabel("Descripcion");
		JLprice = new JLabel("Precio Unitario");
		JLstock = new JLabel("Stock");
		JTname = new JTextArea();
		JTdescription = new JTextArea();
		JTprice = new JTextArea();
		JSstock = new JSpinner();
		JBicono = new JButton();
		JBsave = new JButton("Guardar");
		JBcancel = new JButton("Cancelar");

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(470, 400);
		setLocationRelativeTo(null);
		setTitle("Agregar producto");
		setResizable(false);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		initComponents();
	}

	private void initComponents() {
		JBicono.setBackground(Color.white);
		JBicono.setIcon(imageEscale(new ImageIcon("Resourses\\Icons\\agregarImagenProducto.png"), 100, 100));
		JBicono.addActionListener(this);

		JPproduct.setBackground(Color.white);
		JPproduct.add(JBicono);

		Font font = new Font("Arial", Font.BOLD, 20);

		JLname.setFont(font);
		JLdescription.setFont(font);
		JLprice.setFont(font);
		JLstock.setFont(font);

		JTname.setFont(font);
		JTdescription.setFont(font);
		JTprice.setFont(font);

		JSstock.setFont(font);

		Border borde = BorderFactory.createEmptyBorder(15, 15, 15, 15);
		JPcontenido.setBorder(borde);
		JPcontenido.setBackground(new Color(238, 144, 52, 95));

		JPcontenido.add(JLname);
		JPcontenido.add(JTname);
		JPcontenido.add(JLdescription);
		JPcontenido.add(JTdescription);
		JPcontenido.add(JLprice);
		JPcontenido.add(JTprice);
		JPcontenido.add(JLstock);
		JPcontenido.add(JSstock);

		font = new Font("Arial", Font.BOLD, 15);

		JBcancel.setFont(font);
		JBcancel.setBackground(Color.black);
		JBcancel.setForeground(Color.white);
		JBcancel.addActionListener(this);

		JBsave.setFont(font);
		JBsave.setBackground(new Color(246, 108, 9));
		JBsave.addActionListener(this);

		borde = BorderFactory.createEmptyBorder(20, 10, 0, 10);
		JPbuttons.setBorder(borde);
		JPbuttons.setBackground(Color.white);
		JPbuttons.add(JBcancel);
		JPbuttons.add(JBsave);

		borde = BorderFactory.createEmptyBorder(0, 10, 20, 10);
		JPbackgroud.setBackground(Color.white);
		JPbackgroud.setBorder(borde);
		JPbackgroud.setLayout(new BoxLayout(JPbackgroud, BoxLayout.Y_AXIS));

		JPbackgroud.add(JPproduct);
		JPbackgroud.add(JPcontenido);
		JPbackgroud.add(JPbuttons);

		add(JPbackgroud);

		setVisible(true);
	}

	private ImageIcon imageEscale(ImageIcon icon, int w, int h) {
		Image imagenO = icon.getImage();
		Image imagenEscalada = imagenO.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		ImageIcon logo = new ImageIcon(imagenEscalada);
		return logo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JButton) e.getSource() == JBcancel) {
			new GUIinventoryAdmi();
			LA.deleteImage();
			setVisible(false);
		} else if ((JButton) e.getSource() == JBsave) {
			if (JTname.getText().isEmpty() || JTdescription.getText().isEmpty() || JTprice.getText().isEmpty()
					|| JSstock.getValue().toString().equals("0")) {
				JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
			}else if((Integer)JSstock.getValue()<1) {
				JOptionPane.showMessageDialog(null, "Ingrese un stok mayor a 0");
			} else {
				try {
					Double.parseDouble(JTprice.getText());

					LA.addProduct(JTname.getText(), JTdescription.getText(), JTprice.getText(),
							JSstock.getValue().toString(), index);
					JOptionPane.showMessageDialog(null, "Producto añadido con éxito");

					new GUIinventoryAdmi();
					setVisible(false);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido en el campo de precio");
				}
			}
		} else if ((JButton) e.getSource() == JBicono) {

			if (ip.obtainImage(index)) {
				JBicono.setIcon(imageEscale(ip.getImagen(), 100, 100));
			} else {
				JOptionPane.showMessageDialog(null, "No se puede agregar la imagen seleccionada");
			}

		}

	}
}

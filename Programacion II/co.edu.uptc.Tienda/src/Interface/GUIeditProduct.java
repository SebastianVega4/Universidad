package Interface;

import logic.LogicAdmin;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUIeditProduct extends JFrame implements ActionListener {

	private JPanel JPproduct, JPcontenido, JPbuttons, JPbackgroud;
	private JLabel JLimagenP, JLname, JLdescription, JLprice, JLstock;
	private JTextArea JTname, JTdescription, JTprice;
	private JSpinner JSstock;
	private JButton JBsave, JBcancel;
	private int index;
	private LogicAdmin LA;

	public GUIeditProduct(ImageIcon imageProduct, String name, String description, String price, String stock,
			int indice) {
		LA = new LogicAdmin();
		this.index = indice;

		JPproduct = new JPanel();
		JPcontenido = new JPanel(new GridLayout(4, 2, 10, 10));
		JPbuttons = new JPanel(new GridLayout(1, 2, 40, 40));
		JPbackgroud = new JPanel();
		JLimagenP = new JLabel(imageEscale(imageProduct, 100, 100));
		JLname = new JLabel("Nombre");
		JLdescription = new JLabel("Descripcion");
		JLprice = new JLabel("Precio Unitario");
		JLstock = new JLabel("Stock");
		JTname = new JTextArea(name);
		JTdescription = new JTextArea(description);
		JTprice = new JTextArea(price);
		JSstock = new JSpinner();
		JSstock.setValue(Integer.parseInt(stock));
		JBsave = new JButton("Guardar");
		JBcancel = new JButton("Cancelar");

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(470, 400);
		setLocationRelativeTo(null);
		setTitle("Editar producto");
		setResizable(false);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		initComponents();
	}

	private void initComponents() {
		JPproduct.setBackground(Color.white);
		JPproduct.add(JLimagenP);

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

					LA.editProduct(JTname.getText(), JTdescription.getText(), JTprice.getText(),
							JSstock.getValue().toString(), index);

					JOptionPane.showMessageDialog(null, "Producto editado con éxito");
					new GUIinventoryAdmi();
					setVisible(false);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido en el campo de precio");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}
}

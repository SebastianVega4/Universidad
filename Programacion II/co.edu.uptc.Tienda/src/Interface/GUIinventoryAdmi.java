package Interface;

import logic.LogicAdmin;
import model.Product;
import persistence.ImageProducts;
import persistence.Inventory;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class GUIinventoryAdmi extends JFrame implements ActionListener, MouseListener {

	private JPanel JPheader, JPtitle, JPAreaInventario, JPbuttonsHeader, JPbuttonAdd;
	private JLabel JLtitle, JLlogo;
	private JButton JBaddProduct, JBback, JBcustomer;
	private JTable JTinventoryTable;
	private JScrollPane JSPTabla;
	private DefaultTableCellRenderer centerRenderer;
	private LogicAdmin lA;
	private ImageProducts ip;

	public GUIinventoryAdmi() {

		JPheader = new JPanel(new GridLayout(1, 3, 250, 250));
		JPtitle = new JPanel();
		JPbuttonsHeader = new JPanel();
		JPAreaInventario = new JPanel();
		JPbuttonAdd = new JPanel();
		JLtitle = new JLabel("Inventario");
		JBaddProduct = new JButton("Agregar Producto");
		JBback = new JButton();
		JBcustomer = new JButton();
		lA = new LogicAdmin();
		JTinventoryTable = new JTable();
		JSPTabla = new JScrollPane();
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		ip = new ImageProducts();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 700);
		setLocationRelativeTo(null);
		setTitle("Inventario");
		setResizable(false);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		initComponents();
	}

	private void initComponents()  {
		int w = 150;
		int h = 60;

		JLlogo = new JLabel(imageEscale(new ImageIcon("Resourses\\Icons\\Logo Ferreteria.png"), w, h));

		JBback.setBorder(new LineBorder(new Color(182, 212, 212), 10));
		JBback.setIcon(imageEscale(new ImageIcon("Resourses\\Icons\\regresar.jpg"), w / 4, h / 2));
		JBback.setBackground(new Color(182, 212, 212));
		JBback.addActionListener(this);

		JBcustomer.setBorder(new LineBorder(new Color(182, 212, 212), 10));
		JBcustomer.setIcon(imageEscale(new ImageIcon("Resourses\\Icons\\clientesM.jpg"), w / 3, h - 10));
		JBcustomer.setBackground(new Color(182, 212, 212));
		JBcustomer.addActionListener(this);

		JPbuttonsHeader.setBackground(new Color(182, 212, 212));
		JPbuttonsHeader.add(JBback);
		JPbuttonsHeader.add(JBcustomer);

		JPheader.setBackground(new Color(182, 212, 212));
		JPheader.add(JLlogo, BorderLayout.WEST);
		JPheader.add(JPbuttonsHeader, BorderLayout.EAST);

		Font font = new Font("Arial", Font.BOLD, 40);
		JLtitle.setFont(font);
		JPtitle.setBackground(Color.white);
		JPtitle.add(JLtitle, BorderLayout.CENTER);

		JSPTabla.setViewportView(JTinventoryTable);
		JSPTabla.setPreferredSize(new Dimension(650, 430));

		try {
			JTinventoryTable.setModel(modelTable());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JTinventoryTable.setRowHeight(60);
		JTinventoryTable.addMouseListener(this);

		JTableHeader header = JTinventoryTable.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 20));
		header.setBackground(new Color(246, 108, 9));
		header.setForeground(Color.black);

		JTinventoryTable.getColumnModel().getColumn(0).setCellRenderer(new JLabelTableCellRenderer());
		JTinventoryTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		JTinventoryTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		JTinventoryTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		JTinventoryTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		JTinventoryTable.getColumnModel().getColumn(5).setCellRenderer(new JLabelTableCellRenderer());

		TableColumnModel columnModel = JTinventoryTable.getColumnModel();
		columnModel.getColumn(5).setResizable(false);
		
		JTinventoryTable.getColumn("Stock").setPreferredWidth(45);
		JTinventoryTable.getColumn("Opciones").setPreferredWidth(80);

		font = new Font("Arial", Font.BOLD, 20);
		JBaddProduct.setFont(font);
		JBaddProduct.setBackground(Color.black);
		JBaddProduct.setForeground(Color.white);
		JBaddProduct.addActionListener(this);

		Border borde = BorderFactory.createEmptyBorder(0, 410, 20, 50);
		JPbuttonAdd.setBorder(borde);
		JPbuttonAdd.add(Box.createHorizontalGlue());
		JPbuttonAdd.setBackground(Color.white);
		JPbuttonAdd.add(JBaddProduct);

		JPAreaInventario.setBackground(Color.white);
		borde = BorderFactory.createEmptyBorder(10, 50, 20, 50);
		JPAreaInventario.setBorder(borde);

		JPAreaInventario.add(JPheader);
		JPAreaInventario.add(JPtitle);
		JPAreaInventario.add(JSPTabla);
		JPAreaInventario.add(JPbuttonAdd);

		add(JPAreaInventario);

		setVisible(true);
	}

	private ImageIcon imageEscale(ImageIcon icon, int w, int h) {
		Image imagenO = icon.getImage();
		Image imagenEscalada = imagenO.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		ImageIcon logo = new ImageIcon(imagenEscalada);
		return logo;
	}

	private TableModel modelTable() throws IOException {
		DefaultTableModel modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {// Este metodo es para evitar que el usuario edite las
																// celdas de la tabla
				return false;
			}
		};

		String[] encabezados = { "Producto", "Nombre", "Descripcion", "Precio U", "Stock", "Opciones" };
		modelo.setColumnIdentifiers(encabezados);

		Object[] fila;
		Inventory inv = new Inventory();
		for (Product pro : inv.getProducts()) {
			fila = new Object[6];
			fila[0] = imageEscale(new ImageIcon("Resourses\\Icons\\" + pro.getId() + ".png"), 50, 50);
			fila[1] = pro.getNameProduct();
			fila[2] = pro.getDescription();
			fila[3] = pro.getPrice();
			fila[4] = pro.getStock();
			fila[5] = imageEscale(new ImageIcon("Resourses\\Icons\\opciones.jfif"), 70, 30);

			modelo.addRow(fila);
		}
		return modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JButton) e.getSource() == JBback) {
			new GUImenuAdmin();
			setVisible(false);
			
		} else if ((JButton) e.getSource() == JBcustomer) {
			try {
				new GUIcustomerAdmi();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);
			
		} else if((JButton)e.getSource() == JBaddProduct) {
			new GUIaddProduct();
			setVisible(false);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int columna = JTinventoryTable.getColumnModel().getColumnIndexAtX(e.getX()); // Columna en la que se hizo cli
		int fila = e.getY() / JTinventoryTable.getRowHeight(); // Fila en la que se hizo clic
		if (columna == 5 && fila < JTinventoryTable.getRowCount()) {
			if (e.getX() >= 543 && e.getX() <= 566) {

				new GUIeditProduct((ImageIcon) JTinventoryTable.getValueAt(fila, 0),
						JTinventoryTable.getValueAt(fila, 1).toString(),
						JTinventoryTable.getValueAt(fila, 2).toString(),
						JTinventoryTable.getValueAt(fila, 3).toString(),
						JTinventoryTable.getValueAt(fila, 4).toString(), fila);
				setVisible(false);

			} else if (e.getX() >= 582 && e.getX() <= 602) {
				try {
					lA.deletteProduct(fila);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Producto eliminado");
				new GUIinventoryAdmi();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

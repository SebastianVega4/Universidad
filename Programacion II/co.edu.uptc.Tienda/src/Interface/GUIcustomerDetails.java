package Interface;

import model.Product;
import persistence.Bills;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUIcustomerDetails extends JFrame implements ActionListener{
	
	private JPanel JPtitle, JPtotal, JPbutton, JPbackground;
	private JLabel JLtitle, JLtotal;
	private JButton JBback;
	private JTable JTdetails;
	private JScrollPane JSPTabla;
	private DefaultTableCellRenderer centerRenderer;
	private String name;
	private double total = 0;
	
	public GUIcustomerDetails(String name) throws IOException {
		this.name = name;
		JPtitle = new JPanel();
		JPtotal = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPbutton = new JPanel();
		JPbackground = new JPanel();
		JLtitle = new JLabel(name);
		JLtotal = new JLabel();
		JBback = new JButton("Volver");
		JTdetails = new JTable();
		JSPTabla = new JScrollPane();
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		setSize(700, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setTitle("Detalles de ventas de " + name);
        initComponents();
	}

	private void initComponents() throws IOException {
		Font font = new Font("Arial", Font.BOLD, 40);
		JLtitle.setFont(font);
		JLtitle.setForeground(new Color(246, 108, 9));
		JPtitle.setBackground(Color.white);
		JPtitle.add(JLtitle, BorderLayout.CENTER);
		
		JSPTabla.setViewportView(JTdetails);
		JSPTabla.setPreferredSize(new Dimension(200, 300));
		
		JTdetails.setModel(modelTable());
		JTdetails.setRowHeight(30);
		
		JTableHeader header = JTdetails.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 20));
		header.setBackground(Color.black);
		header.setForeground(Color.white);
		
		JTdetails.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		JTdetails.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		JTdetails.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		JTdetails.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		
		font = new Font("Arial", Font.BOLD, 25);
		JLtotal.setFont(font);
		JLtotal.setText("Total: $ " + total);
		
		JPtotal.setBackground(Color.white);
		JPtotal.add(JLtotal);
		
		font = new Font("Arial", Font.BOLD, 20);
		JBback.setFont(font);
		JBback.setBackground(new Color(182, 212, 212));
		JBback.setPreferredSize(new Dimension(200, 40));
		JBback.addActionListener(this);
		
		JPbutton.setBackground(Color.white);
		JPbutton.add(JBback);
		
		Border borde = BorderFactory.createEmptyBorder(0, 70, 20, 70);
		JPbackground.setBorder(borde);
		JPbackground.setBackground(Color.white);
		JPbackground.setLayout(new BoxLayout(JPbackground, BoxLayout.Y_AXIS));
		
		JPbackground.add(JPtitle);
		JPbackground.add(JSPTabla);
		JPbackground.add(JPtotal);
		JPbackground.add(JPbutton);
		
		add(JPbackground);
		
		setVisible(true);
	}
	
	private TableModel modelTable() throws IOException {
		DefaultTableModel modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {//Este metodo es para evitar que el usuario edite las celdas de la tabla
				return false;
			}
		};
		
		String[] encabezados = {"Articulo", "Cantidad", "Precio U", "Subtotal"};
		modelo.setColumnIdentifiers(encabezados);
		
		Object[]fila;
		Bills b = new Bills(name);
		for(Product user: b.getProducts()) {
			fila = new Object[4];
			fila[0] = user.getNameProduct();
			fila[1] = user.getStock();
			fila[2] = user.getPrice();
			fila[3] = user.getStock() * user.getPrice();
			total += Double.parseDouble(fila[3].toString());
			modelo.addRow(fila);
		}
		return modelo;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource() == JBback) {
			setVisible(false);
			try {
				new GUIcustomerAdmi();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}

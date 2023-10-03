package Interface;

import model.User;
import persistence.Customers;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class GUIcustomerAdmi extends JFrame implements ActionListener, MouseListener{
	
	private JLabel JLtitle, JLlogo;
	private JButton JBback, JBinventary;
	private JTable JTableUsers;
	private JPanel JPheader, JPbuttons, JPtitle, JPbackground;
	private JScrollPane JSPTabla;
	private DefaultTableCellRenderer centerRenderer;
	
	public GUIcustomerAdmi() throws IOException{
		JLtitle = new JLabel("CLIENTES");
		JBback = new JButton();
		JBinventary = new JButton();
		JTableUsers = new JTable();
		JPheader = new JPanel(new GridLayout(1, 3, 250, 250));
		JPbuttons = new JPanel();
		JPtitle = new JPanel();
		JPbackground = new JPanel();
		JSPTabla = new JScrollPane();
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		setSize(700, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setTitle("Clientes");
        initComponents();
	}
	
	private void initComponents() throws IOException {
		int w = 150;
        int h = 60;
        
        JLlogo = new JLabel(imageEscale(new ImageIcon("Resourses\\Icons\\Logo Ferreteria.png"), w, h));
        
        JBback.setBorder(new LineBorder(new Color(182, 212, 212), 10));
        JBback.setIcon(imageEscale(new ImageIcon("Resourses\\Icons\\regresar.jpg"), w/4, h/2));
        JBback.setBackground(new Color(182, 212, 212));
        JBback.addActionListener(this);
        
        JBinventary.setBorder(new LineBorder(new Color(182, 212, 212), 10));
        JBinventary.setIcon(imageEscale(new ImageIcon("Resourses\\Icons\\inventarioM.jpg"), w/3, h-10));
        JBinventary.setBackground(new Color(182, 212, 212));
        JBinventary.addActionListener(this);
        
        JPbuttons.setBackground(new Color(182, 212, 212));
        JPbuttons.add(JBback);
        JPbuttons.add(JBinventary);
        
        JPheader.setBackground(new Color(182, 212, 212));
        JPheader.add(JLlogo, BorderLayout.WEST);
        JPheader.add(JPbuttons, BorderLayout.EAST);
        
        Font font = new Font("Arial", Font.BOLD, 40);
		JLtitle.setFont(font);
		JPtitle.setBackground(Color.white);
		JPtitle.add(JLtitle, BorderLayout.CENTER);
		
		JSPTabla.setViewportView(JTableUsers);
		JSPTabla.setPreferredSize(new Dimension(500, 380));
		
		JTableUsers.setModel(modelTable());
		JTableUsers.setRowHeight(30);
		JTableUsers.addMouseListener(this);
		
		JTableHeader header = JTableUsers.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 20));
		header.setBackground(new Color(246, 108, 9));
		header.setForeground(Color.black);
		
		JTableUsers.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		JTableUsers.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		JTableUsers.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		JTableUsers.getColumnModel().getColumn(3).setCellRenderer(new JLabelTableCellRenderer());
        
		Border borde = BorderFactory.createEmptyBorder(0, 20, 0, 20);
		JPbackground.setBorder(borde);
		JPbackground.setBackground(Color.white);
		
		JPbackground.add(JPheader);
		JPbackground.add(JPtitle);
		JPbackground.add(JSPTabla);
		
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
		
		String[] encabezados = {"Nombre", "email", "Direccion", "Detalles"};
		modelo.setColumnIdentifiers(encabezados);
		
		Object[]fila;
		ImageIcon icon = imageEscale(new ImageIcon("Resourses\\Icons\\Lupa.png"), 20, 20);
		Customers c = new Customers();
		for(User user: c.getUsers()) {
			fila = new Object[4];
			fila[0] = user.getName();
			fila[1] = user.getEmail();
			fila[2] = user.getAddress();
			fila[3] = icon;
			
			modelo.addRow(fila);
		}
		return modelo;
	}

	private ImageIcon imageEscale(ImageIcon icon, int w, int h){
        Image imagenO = icon.getImage();
        Image imagenEscalada = imagenO.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon logo = new ImageIcon(imagenEscalada);
        return logo;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource() == JBback) {
			new GUImenuAdmin();
			setVisible(false);
		}else if((JButton)e.getSource() == JBinventary) {
			new GUIinventoryAdmi();
			setVisible(false);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int columna = JTableUsers.getColumnModel().getColumnIndexAtX(e.getX()); // Columna en la que se hizo clic
	    int fila = e.getY() / JTableUsers.getRowHeight(); // Fila en la que se hizo clic
	    if (columna == 3 && fila < JTableUsers.getRowCount()) { 
	    	if(e.getX() >= 422 && e.getX() <= 443) {
	    		setVisible(false);
	    		try {
					new GUIcustomerDetails(JTableUsers.getValueAt(fila, 0).toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		
	    	}
	    }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

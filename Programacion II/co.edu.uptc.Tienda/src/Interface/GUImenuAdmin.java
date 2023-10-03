package Interface;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUImenuAdmin extends JFrame implements ActionListener{

    private JPanel JPheader, JPbuttons, JPbackground, JPbuttonlOGoUT;
    private JButton JBcustomer, JBinventory, JBlogOut;

    public GUImenuAdmin(){
        JPbuttons = new JPanel(new GridLayout(1, 2, 20, 20));
        JPheader = new JPanel(new GridLayout(1, 3, 100, 80));
        JPbackground = new JPanel();
        JPbuttonlOGoUT = new JPanel();
        JBcustomer = new JButton();
        JBinventory = new JButton();
        JBlogOut = new JButton();

        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setTitle("Menu Admi");
        initComponents();
    }

    private void initComponents() {
        int w = 150;
        int h = 85;
        
        JLabel imagen = new JLabel(imageEscale(new ImageIcon("Resourses\\Icons\\Logo Ferreteria.png"), w, h));
        
        JBlogOut.setBorder(new LineBorder(new Color(182, 212, 212), 2));
        JBlogOut.setIcon(imageEscale(new ImageIcon("Resourses\\Icons\\longOut.jpg"), w/2, h/2));
        JBlogOut.setBackground(new Color(182, 212, 212));
        JBlogOut.addActionListener(this);
        
        Border borde = BorderFactory.createEmptyBorder(25, 0, 25, 0);
        JPbuttonlOGoUT.setBorder(borde);
        JPbuttonlOGoUT.setBackground(new Color(182, 212, 212));
        
        JPbuttonlOGoUT.add(JBlogOut);
        
        JPheader.setBackground(new Color(182, 212, 212));
        JPheader.add(imagen, BorderLayout.WEST);
        JPheader.add(JPbuttonlOGoUT, BorderLayout.EAST);

        h = 220;
        w = 240;
        
        borde = BorderFactory.createEmptyBorder(20, 20, 30, 20);
        JPbuttons.setBackground(Color.white);
        JPbuttons.setBorder(borde);
        
        JBcustomer.setIcon(imageEscale(new ImageIcon("Resourses\\Icons\\clientes.jpg"), w, h));
        JBcustomer.setBackground(Color.white);
        JBcustomer.setBorder(null);
        JBcustomer.addActionListener(this);
        
        JBinventory.setIcon(imageEscale(new ImageIcon("Resourses\\Icons\\inventario.jpg"), w, h));
        JBinventory.setBackground(Color.white);
        JBinventory.setBorder(null);
        JBinventory.addActionListener(this);
        
        JPbuttons.add(JBcustomer);
        JPbuttons.add(JBinventory);

        borde = BorderFactory.createEmptyBorder(0, 20, 10, 30);
        JPbackground.setBorder(borde);
        JPbackground.setBackground(Color.white);

        JPbackground.setLayout(new BoxLayout(JPbackground, BoxLayout.Y_AXIS));
        JPbackground.add(JPheader);
        JPbackground.add(JPbuttons);

        add(JPbackground);
        setVisible(true);
    }
    
    private ImageIcon imageEscale(ImageIcon icon, int w, int h){
        Image imagenO = icon.getImage();
        Image imagenEscalada = imagenO.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon logo = new ImageIcon(imagenEscalada);
        return logo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((JButton)e.getSource() == JBlogOut){
        	GUIstore GUIstore;
			try {
				GUIstore = new GUIstore();
				GUIstore.getFrame().setVisible(true);
	            GUIstore.showLoginPanel();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            setVisible(false);
        }else if((JButton)e.getSource() == JBcustomer){
        	try {
				new GUIcustomerAdmi();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	setVisible(false);
        }else if((JButton)e.getSource() == JBinventory) {
        	new GUIinventoryAdmi();
        	setVisible(false);
        }
    }

}

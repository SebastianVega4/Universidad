package Interface;

import logic.LogicAdmin;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUIadmin extends JFrame implements ActionListener{
    private JPanel JPLogo;
    private JPanel JPAreaFormulario, JPfondo;
    private JLabel JLname , JLpassword;
    private JTextField JTname ;
    private JPasswordField JTpassword;
    private JButton JBloging, JBatras;

    public GUIadmin(){
        JPLogo = new JPanel();
        JPAreaFormulario = new JPanel();
        JPfondo = new JPanel();
        JLname = new JLabel("Usuario");
        JLpassword = new JLabel("Contrase�a");
        JTname = new JTextField();
        JTpassword = new JPasswordField();
        JBloging = new JButton("Login");
        JBatras = new JButton();

        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setTitle("Login Admi");
        initComponents();
    }

    private void initComponents() {
        JPLogo.setLayout(new GridLayout(1, 3, 100, 80));
        int w = 150;
        int h = 90;
        
        ImageIcon icon = new ImageIcon("Resourses\\Icons\\Logo Ferreteria.png");
        Image imagenO = icon.getImage();
        Image imagenEscalada = imagenO.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon logo = new ImageIcon(imagenEscalada);
        JLabel imagen = new JLabel(logo);

        JBatras.setBackground(Color.WHITE);
        JBatras.setBorder(new LineBorder(new Color(182, 212, 212), 2));
        ImageIcon iconB = new ImageIcon("Resourses\\Icons\\ATRAS.jpg");
        Image imagenOriginal = iconB.getImage();
        imagenOriginal = imagenOriginal.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        iconB = new ImageIcon(imagenOriginal);
        JBatras.setIcon(iconB);
        JBatras.addActionListener(this);

        JPLogo.setBackground(new Color(182, 212, 212));
        JPLogo.add(imagen, BorderLayout.WEST);
        JPLogo.add(JBatras, BorderLayout.EAST);

        GridLayout layout = new GridLayout(6, 1);
		layout.setHgap(10); // espacio horizontal entre columnas
		layout.setVgap(10); // espacio vertical entre filas
		
        JPAreaFormulario.setLayout(layout);
        JPAreaFormulario.setBackground(new Color(238, 144, 52,95));

        Font font = new Font("Fedoka One", Font.BOLD, 20);
        JLname.setFont(font);
        JLpassword.setFont(font);

        JBloging.setBackground(new Color(234, 67, 6));
        JBloging.setForeground(Color.black);
        JBloging.addActionListener(this);

        JPAreaFormulario.add(JLname);
        JPAreaFormulario.add(JTname);
        JPAreaFormulario.add(JLpassword);
        JPAreaFormulario.add(JTpassword);
        JPAreaFormulario.add(JBloging);

        Border borde = BorderFactory.createEmptyBorder(30, 100, 0, 100);
        JPAreaFormulario.setBorder(borde);

        borde = BorderFactory.createEmptyBorder(0, 100, 100, 100);
        JPfondo.setBackground(Color.WHITE);
        JPfondo.setBorder(borde);
        JPfondo.setLayout(new BoxLayout(JPfondo, BoxLayout.Y_AXIS));

        JPfondo.add(JPLogo);
        JPfondo.add(new JLabel("   "));
        JPfondo.add(JPAreaFormulario);

        add(JPfondo);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if((JButton)e.getSource() == JBatras){
        setVisible(false);
        GUIstore GUIstore;
		try {
			GUIstore = new GUIstore();
			GUIstore.getFrame().setVisible(true);
	        GUIstore.showLoginPanel();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }else if((JButton)e.getSource() == JBloging){
        if(JTname.getText().length() != 0 && JTpassword.getText().length() != 0){
            String user = JTname.getText();
            String password = JTpassword.getText();
            if(new LogicAdmin().adminlogin(user, password)){
                new GUImenuAdmin();
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Credenciales invalidas. Intentalo de nuevo");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Digite todo los datos ");
        }
    }
    
    }
    
}
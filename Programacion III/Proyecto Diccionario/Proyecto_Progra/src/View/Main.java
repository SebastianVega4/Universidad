package View;

import Model.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class Main extends JFrame implements ActionListener {

    private JLabel texto1;
    private JLabel texto2;
    private JLabel texto3;

    private JTextField caja1;
    private JTextField caja2;
    private JTextField caja3;

    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;



    private JScrollPane scrollPane;

    private javax.swing.JTextArea jtxaLista;

    private controller  control = new controller();



    public Main() {
        super();
        configurarVentana();
        inicializarComponentes();
    }

    private void llenarPanelLista() {
        this.jtxaLista.setText("");

            this.jtxaLista.append(control.listadototal());
        }

    private void llenarLisLetra(String str) {
        this.jtxaLista.setText("");

        this.jtxaLista.append("\nletra : "+ control.mayus(str) +"\n"+control.listadoLetra(str));
    }
    private void obtenerPalabra(String str) {
        this.jtxaLista.setText("");

        this.jtxaLista.append(control.consultar(str));
    }








    private void configurarVentana() {
        this.setTitle("Formulario personas");
        this.setSize(900, 620);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        // creamos los componentes
        texto1 = new JLabel();
        texto2 = new JLabel();
        texto3 = new JLabel();
        caja1 = new JTextField();
        caja2 = new JTextField();
        caja3 = new JTextField();
        boton1 = new JButton();
        boton2 = new JButton();
        boton3 = new JButton();
        boton4 = new JButton();
        boton5 = new JButton();
        jtxaLista = new JTextArea();
        scrollPane = new JScrollPane(jtxaLista);


        //jtxaLista.setBounds(30,30,400,520);
        scrollPane.setVisible(true);
        scrollPane.setBounds(30,30,400,520);
        texto1.setText("Palabra");
        texto1.setBounds(480, 50, 100, 25);
        caja1.setBounds(560, 50, 150, 25);
        boton1.setText("Agregar");
        boton1.setBounds(740, 50, 150, 30);
        boton1.addActionListener(this);

        texto2.setText("Significado");
        texto2.setBounds(480, 100, 100, 25);
        caja2.setBounds(560, 100, 150, 25);
        boton2.setText("Consultar");
        boton2.setBounds(740, 100, 150, 30);
        // boton2.addActionListener(this);

        texto3.setText("Traduccion");
        texto3.setBounds(480, 150, 100, 25);
        caja3.setBounds(560, 150, 150, 25);
        boton3.setText("Modificar");
        boton3.setBounds(740, 150, 150, 30);
        // boton3.addActionListener(this);
        boton4.setText("Eliminar");
        boton4.setBounds(740, 200, 150, 30);
        boton5.setText("Salir");
        boton5.setBounds(740, 250, 150, 30);

        // boton4.addActionListener(this);

        // boton5.addActionListener(this);

        // boton6.addActionListener(this);

        this.add(texto1);
        this.add(texto2);
        this.add(texto3);
        this.add(caja1);
        this.add(caja2);
        this.add(caja3);
        this.add(boton1);
        this.add(boton2);
        this.add(boton3);
        this.add(boton4);
        this.add(boton5);

        this.jtxaLista.setEditable(false);

        this.add(scrollPane, FlowLayout.CENTER);


        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(caja1.getText(), "") && !Objects.equals(caja2.getText(), "") && !Objects.equals(caja3.getText(), "")){
                    String palabra = caja1.getText();
                    String significado = caja2.getText();
                    String traduccion = caja3.getText();
                    JOptionPane.showMessageDialog(null,control.Agreggar(palabra,significado,traduccion));
                    caja1.setText("");
                    caja2.setText("");
                    caja3.setText("");
                    llenarPanelLista();
                }else {
                    JOptionPane.showMessageDialog(null,"Nigun campo debe estar vacio");
                }


            }

            public void JBT(java.awt.event.MouseEvent evt) {
                boton1.setBackground(new Color(321, 3123, 3123));
            }
        });
        boton3.addActionListener(new ActionListener() {
            int cont=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                cont++;


                    if (cont==1){
                        String palabra = JOptionPane.showInputDialog("digite la palabra que desea modificar");
                        if (!Objects.equals(palabra, ""))

                        { if (control.consultarExistencia(palabra)) {
                            caja1.setText(control.consultarPalab(palabra));
                            caja2.setText(control.consultarSignifica(palabra));
                            caja3.setText(control.consultarTraduc(palabra));
                            boton1.setVisible(false);
                            boton2.setVisible(false);
                            boton4.setVisible(false);
                            caja1.setEditable(false);
                            cont = cont + 1;
                        }else {
                            JOptionPane.showMessageDialog(null,"La palabra no existe");

                            cont=0;
                        }}else {
                            JOptionPane.showMessageDialog(null,"El campo no puede estar vacio");
                            cont=0;
                        }


                    }else {
                        if (!Objects.equals(caja1.getText(), "") && !Objects.equals(caja2.getText(), "") && !Objects.equals(caja3.getText(), "")) {
                            control.Modificar(caja1.getText(),caja2.getText(),caja3.getText());
                            caja1.setEditable(true);
                            caja1.setText("");
                            caja2.setText("");
                            caja3.setText("");
                            boton1.setVisible(true);
                            boton2.setVisible(true);
                            boton4.setVisible(true);
                            cont=0;

                    }else {
                            JOptionPane.showMessageDialog(null,"Ningun campo puede estar vacio");
                        }
                    }

                llenarPanelLista();

            }
        });
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = JOptionPane.showInputDialog("digite la palabra que desea eliminar");
                if (!Objects.equals(palabra, "")){
                    if (control.consultarExistencia(palabra)) {
                    control.Eliminar(palabra);
                        JOptionPane.showMessageDialog(null,"La palabra: "+palabra+" fue eliminada");
                }else {
                    JOptionPane.showMessageDialog(null,"La palabra no existe");



                }
                }else {
                    JOptionPane.showMessageDialog(null,"el campo no puede set vacio");
                }

                llenarPanelLista();
        }});
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        boton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int a=JOptionPane.showOptionDialog(null, "Eligue la opcion que desea", "Atencion",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        new Object[] { "Diccionario completo", "Listado por palabra" ,"palabra"}, "opcion");
                switch (a) {
                    case 0:
                        llenarPanelLista();
                    break;
                    case 1:
                        String palabra = JOptionPane.showInputDialog("digite la letra que desea consultar");
                        if (palabra.length()!=1){
                            JOptionPane.showMessageDialog(null,"Digite solo un caracter");
                        }else {

                            llenarLisLetra(palabra);
                        }

                        break;
                    case 2:
                        String palabra2 = JOptionPane.showInputDialog("digite la palabras que desea consultar");
                        if (palabra2.length()==0){
                            JOptionPane.showMessageDialog(null,"el valor no puede ser nulo");
                        }else {

                            obtenerPalabra(palabra2);
                        }
                        break;
                }


                }
        });
    }


    // @Override
    // public void actionPerformed(ActionEvent e) {

    // Listado_Personas list_p = new Listado_Personas();
    // boton1.setText(e.getActionCommand());
    // String nombre = caja1.getText();
    // String telefono = caja2.getText();
    // int edad = Integer.parseInt(caja3.getText());
    // Persona persona = new Persona(nombre, telefono, edad);
    // list_p.ingresar_usuario(persona);
    // JOptionPane.showMessageDialog(this, "el usuario : " + nombre + " ha sido
    // registrado");

    // boton2.setText(e.getActionCommand());
    // for (int i = 0; i < list_p.tamanho(); i++) {
    // list_p.msj(i);
    // }

    // }

    // public static void ingresar_persona(String nombre,String telefono,int
    // edad,Persona persona,Listado_Personas list_p){
    // }

    public static void main(String[] args) {
        Main V = new Main();
        V.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}

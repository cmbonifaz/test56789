
package dominio;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Componente extends JFrame{
    JPanel panel;
    JTextField texto;
    ArrayList<Producto> productos = new ArrayList<>();
    public Componente(){
        setBounds(10, 100, 500, 800);
        setTitle("Ventana Principal");
        setVisible(true);
        agregar();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void agregar(){
        paneles();
        etiquetas();
        botones();
        radioBotones();
        cajaTexto();
        listas();
        tablas();
    }
    
    public void paneles(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.ORANGE);
        this.add(panel);   
        //this.getCon;
        
    }
    
    public void etiquetas(){
        JLabel etiqueta = new JLabel();
        JLabel etiqueta2 = new JLabel();
        ImageIcon Rayo_McQueen = new ImageIcon("Rayo_McQueen.png");
        //JLabel etiqueta2 = new JLabel(new ImageIcon("Rayo_McQueen.png"));
        etiqueta2.setBounds(10, 50, 200, 100);
        //Sirve para acomodar la imagen de manera correcta
        etiqueta2.setIcon(new ImageIcon(Rayo_McQueen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH)));
        etiqueta.setText("Figuras");
        etiqueta.setBounds(10, 10, 50, 30);
        MouseListener escuchador = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showMessageDialog(null,"Click y suelto sobre el rayo");
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                 JOptionPane.showMessageDialog(null,"click en el rayo");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                 JOptionPane.showMessageDialog(null,"Click y suelto fuera del rayo");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(null,"Ingresando al rayo");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JOptionPane.showMessageDialog(null,"Saliendo del rayo");
            }
        };
        etiqueta2.addMouseListener(escuchador);
        panel.add(etiqueta);
        panel.add(etiqueta2);
        panel.repaint();
    }
    
    public void botones(){
        JButton boton1 = new JButton("Click");
        JButton boton2 = new JButton();
        ImageIcon Oso = new ImageIcon("Oso.jpg");
        boton2.setBounds(10, 220, 100, 60);
        boton2.setIcon(new ImageIcon(Oso.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        //boton1.setEnabled(false);
        boton1.setBounds(10, 160, 100, 50);
        boton1.setMnemonic('c');
        boton1.setForeground(Color.red);
        panel.add(boton1);
        panel.add(boton2);
        ActionListener escuchabtn1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==boton1){
                    texto.setText("Hola");
                }else if(e.getSource()==boton2){
                    texto.setText("Oso");
                }
            }
        };
        boton1.addActionListener(escuchabtn1);
        boton2.addActionListener(escuchabtn1);
        panel.repaint();
    }
    
    public void radioBotones(){
        JRadioButton botonop1 = new JRadioButton("Opcion 1");
        JRadioButton botonop2 = new JRadioButton("Opcion 2");
        JRadioButton botonop3 = new JRadioButton("Opcion 3");
        //Hablita o Deshabilita el boton
        botonop1.setEnabled(false);
        botonop1.setBounds(10, 300, 100, 30);
        botonop2.setBounds(10, 330, 100, 30);
        botonop3.setBounds(10, 360, 100, 30);
        botonop3.setBackground(Color.ORANGE);
        botonop2.setBackground(Color.ORANGE);
        botonop1.setBackground(Color.ORANGE);
        panel.add(botonop1);
        panel.add(botonop2);
        panel.add(botonop3);
        panel.repaint();
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(botonop1);
        grupo.add(botonop2);
        grupo.add(botonop3);
    }
    
    public void cajaTexto(){
        JTextField texto = new JTextField();
        JTextArea txtArea = new JTextArea();
        texto.setBounds(10, 400 , 150, 20);
        texto.setText("PUTO EL QUE LO LEA");
        txtArea.setBounds(10, 430, 200, 50);
        txtArea.append("Escriba: ");
        txtArea.setEditable(true);
        KeyListener escuchat = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(texto.getText().length()>=5){
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        texto.addKeyListener(escuchat);
        panel.add(texto);
        panel.add(txtArea);
        panel.repaint(); 
    }
    
    public void insertarObjetos(){
        productos.add(new Producto("Camisas",20.65));
        productos.add(new Producto("Pantalones",25.99));
        productos.add(new Producto("Camisetas",8.65));
    }
    
    //array de listas
    public void listas(){
        String [] ciudades = {"Quito", "Guayaquil", "Cuenca"};
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        insertarObjetos();
        modelo.addAll(productos);
        JComboBox listap = new JComboBox(modelo);
        JComboBox lista = new JComboBox(ciudades);
        lista.setSelectedItem("Cuenca");
        lista.setBounds(10, 490, 80, 30);
        listap.setBounds(10, 540, 100, 30);
        listap.setSelectedItem(productos.get(0));
        panel.add(lista);
        panel.add(listap);
        panel.repaint();
    }
    
    public void tablas(){
        DefaultTableModel modelot = new DefaultTableModel();
        DefaultTableModel modelop = new DefaultTableModel();
        modelot.addColumn("Nombres");
        modelot.addColumn("Ciudad");
        modelot.addColumn("Direccion");
        modelop.addColumn("Nombre P");
        modelop.addColumn("Precio P");
        String[] fila1 = {"Juan","Quito","El Recreo"};
        String[] fila2 = {"Francisco","Guayaquil","El Seguro"};
        modelot.addRow(fila1);
        modelot.addRow(fila2);
        JTable tabla = new JTable(modelot);
        tabla.setBounds(215, 10, 220, 200);
        panel.add(tabla);
        JScrollPane barra = new JScrollPane(tabla,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barra.setBounds(215, 10, 220, 200);
        panel.add(barra);
        Object [] p = null;
        for(int i=0;i<productos.size();i++){
            modelop.addRow(p);
            Producto p1 = productos.get(i);
            modelop.setValueAt(p1.getNombre(), i, 0);
            modelop.setValueAt(p1.getPrecio(), i, 1);
        }
        JTable tablap = new JTable(modelop);
        tablap.setBounds(215, 240, 150, 200);
        panel.add(tablap);
        JScrollPane barrap = new JScrollPane(tablap,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barra.setBounds(215, 240, 150, 200);
        panel.add(barrap);
        panel.repaint();
    }
}

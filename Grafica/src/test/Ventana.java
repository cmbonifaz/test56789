
package test;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana {
    public static void main(String[] args){
        JFrame ventana = new JFrame();
        JButton boton = new JButton("Puto el que lo lea");
        boton.setLocation(30, 30);
        ventana.setSize(1000,1000);
        //ventana.setLocation(100,100);
        //La ventana sale en el centro de la pantalla
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Mi ventana");
        ventana.setVisible(true);
        ventana.add(boton);
    }
    
}


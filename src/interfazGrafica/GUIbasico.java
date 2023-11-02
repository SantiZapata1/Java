package interfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIbasico {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Mi Aplicación");

        ventana.setSize(400, 300);  // Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cierra la aplicación al cerrar la ventana

        JLabel etiqueta = new JLabel("Hola, mundo!");
        JButton boton = new JButton("Haz clic");

        ventana.add(etiqueta);
        ventana.add(boton);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());  // Establecer un administrador de diseño de flujo
        panel.add(etiqueta);
        panel.add(boton);
        ventana.add(panel);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("¡Has hecho clic en el botón!");
            }
        });


        ventana.setVisible(true);


    }



}

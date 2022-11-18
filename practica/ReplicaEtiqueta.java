package javaSwing.practica;
//Referente al ejercicio "FormularioEtiqueta" de la Hoja 2

import javax.swing.*;

public class ReplicaEtiqueta extends JFrame{

    //Crear variable tipo JLabel
    JLabel etiquetita, etiquetita2;

    //Diseño Etiqueta en constructor
    public ReplicaEtiqueta(){
        setLayout(null);
        etiquetita = new JLabel("Esta es tu prueba :D");
        etiquetita.setBounds(100,25,200,25);
        add(etiquetita);
        etiquetita2 = new JLabel("Lo hiciste muy bien!");
        etiquetita2.setBounds(140,60,200,30);
        add(etiquetita2);
    }

    //Ventana
    public static void Ventana(){
        ReplicaEtiqueta contenedor = new ReplicaEtiqueta();
        contenedor.setBounds(0,0,450,700);
        contenedor.setVisible(true);
        contenedor.setResizable(false);
        contenedor.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Ventana();
    }
}

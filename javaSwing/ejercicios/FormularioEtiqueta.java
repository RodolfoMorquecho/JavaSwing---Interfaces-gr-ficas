package javaSwing.ejercicios;
//Hoja 2

import javax.swing.*;

public class FormularioEtiqueta extends JFrame{
    //Modificador de acceso "private" para evitar confusion con otras clases que contengan variables de tipo JLabel con mismo nombre del de esta clase
    private JLabel etiqueta1;  //Declaracion "etiqueta1" de tipo JLabel(JFrame)
    private JLabel etiqueta2;

    //Constructor
    public FormularioEtiqueta(){
        setLayout(null);  //Indica que se hara uso de coordenadas
        etiqueta1 = new JLabel("Interfaz gráfica");  //Inicializa "etiqueta1" con un mensaje
        etiqueta1.setBounds(10,20,300,30);  //Configuracion de tamaño/posicionamiento de "etiqueta1" en la interfaz gráfica
        add(etiqueta1);  //Agregar "tiqueta1" a la interfaz

        etiqueta2 = new JLabel("Versión 1.0");
        etiqueta2.setBounds(10,100,100,30);
        add(etiqueta2);
    }

    public static void main(String[] args){
        FormularioEtiqueta formularioEtq = new FormularioEtiqueta();
        formularioEtq.setBounds(0,0,300,200);
        formularioEtq.setVisible(true);
        formularioEtq.setResizable(false);
        formularioEtq.setLocationRelativeTo(null);
    }
}

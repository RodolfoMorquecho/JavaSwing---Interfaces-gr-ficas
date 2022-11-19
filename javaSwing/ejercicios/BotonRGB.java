package javaSwing.ejercicios;
//Hoja 10

import javax.swing.*;  //Libreria para obtener los componentes
import java.awt.*;  //Libreria para acceder a la clase "Color"
import java.awt.event.*;  //Libreria para acceder al metodo que dara funcionalidad al boton

public class BotonRGB extends JFrame implements ActionListener{
    private JLabel labelRojo, labelVerde, labelAzul;
    private JComboBox listaRojo, listaVerde, listaAzul;
    private JButton fijar;
    private JPanel panel;

    //Constructor
    public BotonRGB(){
        iniciarComponentes();  //Llamada de metodos
        seccionRojo();
        seccionVerde();
        seccionAzul();
        botonColor();
    }

    //Panel
    private void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    //Set Rojo
    private void seccionRojo(){
        //Etiqueta rojo
        labelRojo = new JLabel("Rojo");
        labelRojo.setBounds(15,15,100,25);
        panel.add(labelRojo);

        //Lista desplegable rojo
        listaRojo = new JComboBox();
        listaRojo.setBounds(130,20,50,20);
        for(int i=0;i<=255;i++){    //Recorrera los 255 pixeles que cubre las tonalidades del color rojo
            listaRojo.addItem(String.valueOf(i));  //Convertir a String el entero para poder integrarlo como parametro de item
        }
        panel.add(listaRojo);
    }

    //Set Verde
    private void seccionVerde(){
        //Etiqueta verde
        labelVerde = new JLabel("Verde");
        labelVerde.setBounds(15,50,100,25);
        panel.add(labelVerde);

        //Lista desplegable verde
        listaVerde = new JComboBox();
        listaVerde.setBounds(130,55,50,20);
        for(int i=0;i<=255;i++){
            listaVerde.addItem(String.valueOf(i));
        }
        panel.add(listaVerde);
    }

    //Set Azul
    private void seccionAzul(){
        //Etiqueta azul
        labelAzul = new JLabel("Azul");
        labelAzul.setBounds(15,85,100,25);
        panel.add(labelAzul);

        //Lista desplegable azul
        listaAzul = new JComboBox();
        listaAzul.setBounds(130,90,50,20);
        for(int i=0;i<=255;i++){
            listaAzul.addItem(String.valueOf(i));
        }
        panel.add(listaAzul);
    }

    //Boton para fijar color
    private void botonColor(){
        fijar = new JButton("Fijar Color");
        fijar.setBounds(50,145,100,30);
        panel.add(fijar);
        fijar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == fijar){  //Al presionar el boton "fijar" podremos ver el color descubierto, pintando al boton.
            //Para recuperar los datos de un ComboBox siempe debe de ser en tipo String
            String cad1 = listaRojo.getSelectedItem().toString();  //Extraer la opcion seleccionada y convertir a cadena(String)
            String cad2 = listaVerde.getSelectedItem().toString();
            String cad3 = listaAzul.getSelectedItem().toString();

            int rojo = Integer.parseInt(cad1);  //Convertir la cadena a numero entero para poder pasar como parametro a clase "Color"
            int verde = Integer.parseInt(cad2);
            int azul = Integer.parseInt(cad3);

            Color color1 = new Color(rojo,verde,azul);  //Creamos objeto de la clase "Color" pasando los parametros en las variables de tipo entero rojo,verde,azul
            fijar.setBackground(color1);    //Para ver el color obtenido, pasamos como parametro al objeto que creamos(color1) y pinara el boton de ese tono
        }
    }

    //Funcion principal
    public static void main(String[] args) {
        descubreColor();
    }

    //Metodo para llamar dentro de main y tener un mejor orden
    public static void descubreColor(){
        BotonRGB rgb = new BotonRGB();
        rgb.setBounds(0,0,215,250);
        rgb.setVisible(true);
        rgb.setResizable(false);
        rgb.setLocationRelativeTo(null);
        rgb.setTitle("RGB");
    }
}

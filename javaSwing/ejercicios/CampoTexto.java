package javaSwing.ejercicios;
//Hoja 5

import javax.swing.*;
import java.awt.event.*;

public class CampoTexto extends JFrame implements ActionListener{
    private JLabel etiqueta;
    private JButton boton,botonCerrar;
    private JTextField textoEnt;  //Variable/Componente de tipo TextField(Campo de texto)


    public CampoTexto(){
        setLayout(null);

        etiqueta = new JLabel("Nombre: ");
        etiqueta.setBounds(10,10,100,30);
        add(etiqueta);
        boton = new JButton("Aceptar");
        boton.setBounds(10,80,100,30);
        add(boton);
        boton.addActionListener(this);
        botonCerrar = new JButton("Cerrar");
        botonCerrar.setBounds(130,80,100,30);
        add(botonCerrar);
        botonCerrar.addActionListener(this);
        textoEnt = new JTextField();
        textoEnt.setBounds(120,18,150,20);
        add(textoEnt);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton){    //Boton "aceptar"
            String nombre = textoEnt.getText();  //Almacenar en variable nombre el texto obtenido del componente textoEnt
            setTitle(nombre);    //Establecer el titulo de ventana con lo cadena que contiene la var. nombre
        }
        else if(e.getSource() == botonCerrar){
            System.exit(0);
        }
    }

    public static void main(String[] args){
        CampoTexto textfield = new CampoTexto();
        textfield.setBounds(0,0,300,160);
        textfield.setVisible(true);
        textfield.setResizable(false);
        textfield.setLocationRelativeTo(null);
    }
}

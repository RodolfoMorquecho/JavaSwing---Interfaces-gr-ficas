package javaSwing.practica;
//Referente al ejercicio "CampoTexto" de la Hoja 5

import javax.swing.*;
import java.awt.event.*;

public class ValidacionCampoTexto extends JFrame implements ActionListener{
    private JLabel email1, email2, comprobar;
    private JButton boton, botonCierre;
    private JTextField campoTexto1, campoTexto2;

    public ValidacionCampoTexto(){
        setLayout(null);
        email1 = new JLabel("Ingresa correo: ");
        email1.setBounds(10,15,100,25);
        add(email1);
        email2 = new JLabel("Ingresa correo: ");
        email2.setBounds(10,50,100,25);
        add(email2);
        comprobar = new JLabel();
        comprobar.setBounds(100,80,120,25);
        add(comprobar);
        campoTexto1 = new JTextField();
        campoTexto1.setBounds(125,15,100,20);
        add(campoTexto1);
        campoTexto2 = new JTextField();
        campoTexto2.setBounds(125,50,100,20);
        add(campoTexto2);
        boton = new JButton("Verificar");
        boton.setBounds(40,120,90,25);
        add(boton);
        boton.addActionListener(this);
        botonCierre = new JButton("Cerrar");
        botonCierre.setBounds(160,120,90,25);
        add(botonCierre);
        botonCierre.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton){
            String resultado1 = campoTexto1.getText();
            String resultado2 = campoTexto2.getText();
            if(resultado1.equals(resultado2)){
                comprobar.setText("Es corecto");

            }
            else
                comprobar.setText("No son iguales");

        }

        else if(e.getSource() == botonCierre){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ventana();
    }

    public static void ventana(){
        ValidacionCampoTexto validacion1 = new ValidacionCampoTexto();
        validacion1.setBounds(0,0,300,200);
        validacion1.setVisible(true);
        validacion1.setResizable(false);
        validacion1.setLocationRelativeTo(null);
    }
}

package javaSwing.ejercicios;
//Hoja 4

import javax.swing.*;
import java.awt.event.*;

public class BotonEtiqueta extends JFrame implements ActionListener{
    private JButton boton1, boton2, boton3, btnCerrar;
    private JLabel etiqueta;
    private int i=0;    //Contador inicializado en 0 de forma global

    public BotonEtiqueta(){
        setLayout(null);
        etiqueta = new JLabel("Mezcla los numeros para obtener 10");  //Etiqueta de instrucciones
        etiqueta.setBounds(50,20,210,30);
        add(etiqueta);

        boton1 = new JButton("1");    //boton con valor de  1
        boton1.setBounds(15,110,80,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("2");    //boton con valor de  2
        boton2.setBounds(110,110,80,30);
        add(boton2);
        boton2.addActionListener(this);

        boton3 = new JButton("3");    //boton con valor de  3
        boton3.setBounds(205,110,80,30);
        add(boton3);
        boton3.addActionListener(this);

        btnCerrar = new JButton("Cerrar");    //boton para cerrar ventana
        btnCerrar.setBounds(110,150,80,30);
        btnCerrar.setVisible(false);    //El boton de cerrar no estara disponible hasta que se resuelva el juego
        add(btnCerrar);
        btnCerrar.addActionListener(this);  //Agregar metodo "ActionListener" al boton "cerrar"
    }

    //Funcionalidad de botones
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == boton1){
            etiqueta.setText("Has presionado el boton 1");  //Cambiara la etiqueta de instrucciones por este texto
            i += 1;                                         //Si se presiona este boton aumentara 1 al contador
            if(i == 10){                                    //Cuando el contador valga 10, obtendremos un texto que lo indica
                etiqueta.setText("Conseguiste una combinacion de 10");
                btnCerrar.setVisible(true);    //Ya que el objetivo se ha conseguido, tendremos acceso al boton "cerar" apra terminar
                i=0;    //En caso de seguir jugando, nnuestro contador se inicializa en 0
            }
        }
        if(e.getSource() == boton2){
            etiqueta.setText("Has presionado el boton 2");
            i += 2;
            if(i == 10){
                etiqueta.setText("Conseguiste una combinacion de 10");
                btnCerrar.setVisible(true);
                i=0;
            }
        }
        if(e.getSource() == boton3) {
            etiqueta.setText("Has presionado el boton 3");
            i += 3;
            if(i == 10){
                etiqueta.setText("Conseguiste una combinacion de 10");
                btnCerrar.setVisible(true);
                i=0;
            }
        }

        if(e.getSource() == btnCerrar){    //Se cierra y detiene el programa
            System.exit(0);
        }
    }

    public static void main(String[] args){
        BotonEtiqueta botonera = new BotonEtiqueta();
        botonera.setBounds(0,0,320,250);
        botonera.setVisible(true);
        botonera.setResizable(false);
        botonera.setLocationRelativeTo(null);
    }
}

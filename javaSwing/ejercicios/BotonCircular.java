package javaSwing.ejercicios;
//Hoja 14
//JRadioButton - a diferencia de los checkbox, estos solo se pueden seleccionar uno a la vez

import javax.swing.*;
import javax.swing.event.*;  //Se utiliza el mismo tipo de evento que un checkBox

public class BotonCircular extends JFrame implements ChangeListener {
    private JRadioButton radio1, radio2, radio3, btndefault;
    private ButtonGroup bg;
    private JPanel panel;

    //Constructor
    public BotonCircular(){
        iniciarComponentes();
        almacenBotones();
    }

    //Panel
    private void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    //Crear grupo donde se almacenan los botones
    private void almacenBotones(){
        //Boton uno
        bg = new ButtonGroup();
        radio1 = new JRadioButton("300x300");
        radio1.setBounds(15,15,100,30);
        panel.add(radio1);
        bg.add(radio1);
        radio1.addChangeListener(this);

        //Boton dos
        radio2 = new JRadioButton("500x300");
        radio2.setBounds(15,60,100,30);
        panel.add(radio2);
        bg.add(radio2);
        radio2.addChangeListener(this);

        //Boton tres
        radio3 = new JRadioButton("300x600");
        radio3.setBounds(15,105,100,30);
        panel.add(radio3);
        bg.add(radio3);
        radio3.addChangeListener(this);

        //Boton default: restaurar el valor inicial
        btndefault = new JRadioButton("Default");
        btndefault.setBounds(35,150,120,30);
        panel.add(btndefault);
        bg.add(btndefault);
        btndefault.addChangeListener(this);

        //Terminart programa
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void stateChanged(ChangeEvent e){
        //A diferencia de checkbox no se debe de comparar con un estado booleano, debido a que aqui solo puede estar seleccionado un boton a la vez
        if(radio1.isSelected()){
            setSize(300,300);
        }
        if(radio2.isSelected()){
            setSize(500,300);
        }
        if(radio3.isSelected()){
            setSize(300,500);
        }
        if(btndefault.isSelected()){
            setSize(200,270);
        }
    }

    public static void main(String[] args) {
        circulos();
    }

    private static void circulos(){
        BotonCircular bc = new BotonCircular();
        bc.setBounds(0,0,200,270);
        bc.setVisible(true);
        bc.setResizable(false);
        bc.setLocationRelativeTo(null);
    }

}

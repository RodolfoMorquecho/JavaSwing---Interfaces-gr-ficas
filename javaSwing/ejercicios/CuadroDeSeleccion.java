package javaSwing.ejercicios;
//Hoja 12

import javax.swing.*;  //Libreria que contiene el componente "CheckBox" que se utilizara
import javax.swing.event.*;  //Esta libreria contiene el evento que se necesita para ese componente, ahora no se necesita java.awt.event.*;

public class CuadroDeSeleccion extends JFrame implements ChangeListener{  //Para agregar un evento a un JCheckBox se hace uso de la clase ChengeListener
    //Declaracion de componentes
    private JCheckBox check1, check2, check3;
    private JPanel panel;

    public CuadroDeSeleccion(){
        iniciarComponentes();
        opcionesCheck();
    }

    private void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    //Seccion de componentes CheckBox
    private void opcionesCheck(){
        //Primer caja
        check1 = new JCheckBox("Ingles");
        check1.setBounds(10,10,100,25);
        panel.add(check1);
        check1.addChangeListener(this);  //Agregar evento al componente "check1" de la clae "ChangeListener"

        //Segunda caja
        check2 = new JCheckBox("Mandarin");
        check2.setBounds(10,50,100,25);
        panel.add(check2);
        check2.addChangeListener(this);

        //tercera caja
        check3 = new JCheckBox("Español");
        check3.setBounds(10,90,100,25);
        panel.add(check3);
        check3.addChangeListener(this);

        //Cierre de ventana y finalizacion de ejecucion
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        formCheck();
    }

    public static void formCheck(){
        CuadroDeSeleccion cuadro1 = new CuadroDeSeleccion();
        cuadro1.setBounds(0,0,400,250);
        cuadro1.setVisible(true);
        cuadro1.setResizable(false);
        cuadro1.setLocationRelativeTo(null);

    }

    public void stateChanged(ChangeEvent e){
        String cad = "";
        if(check1.isSelected()  == true){  //Cuando el CheckBox1 esta seleccionado y esa seleccion tiene la paloma, significa que su estado es "true"
            cad = cad +"Ingles-";  //La variable cadena esta vacia, en caso de que se umpla el condicional, se sumara asi misma y tambien la cadena "Ingles"
        }
        if(check2.isSelected() == true){
            cad = cad + "Mandarin-";
        }
        if(check3.isSelected() == true){
            cad = cad + "Español-";
        }
        setTitle(cad);  //La ventana tendra el titulo de lo que se almaceno en "cad" segun los CheckBox seleccionados, ya que nunca se limpia el titulo
    }
}

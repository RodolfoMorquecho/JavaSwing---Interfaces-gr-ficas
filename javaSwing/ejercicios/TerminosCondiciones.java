package javaSwing.ejercicios;
//Hoja 13

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminosCondiciones extends JFrame implements ActionListener, ChangeListener {
    //Declaracion de componentes
    private JLabel indicacion;
    private JCheckBox aceptar;
    private JButton enviar;
    private JPanel panel;

    public TerminosCondiciones(){
        iniciarComponentes();
        indicacionCheckBox();
        opcionCheck();
        continuar();
    }

    //Panel
    private void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    //Etiqueta
    private void indicacionCheckBox(){
        indicacion = new JLabel("Aceptar terminos y condiciones");
        indicacion.setBounds(15,15,300,25);
        panel.add(indicacion);
    }

    //CheckBox
    private void opcionCheck(){
        aceptar = new JCheckBox("Acepto");
        aceptar.setBounds(20,50,100,25);
        panel.add(aceptar);
        aceptar.addChangeListener(this);
    }

    //Boton "Continuar"
    private void continuar(){
        enviar = new JButton("Continual");
        enviar.setBounds(15,90,100,30);
        enviar.setEnabled(false);  //Poner el boton como no disponible por default
        panel.add(enviar);
        enviar.addActionListener(this);
    }

    //Evento CheckBox
    public void stateChanged(ChangeEvent e){
        if(aceptar.isSelected() == true){  //Si esta seleccionado, hara funcional al boton de "Continuar"
            enviar.setEnabled(true);
        }else{    //Si se quita la seleccion, hara que el boton no pueda tener interaccion con el usuario
            enviar.setEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e){
        System.exit(0);  //Cierra ventana
    }

    public static void main(String[] args){
        aceptarCondiciones();
    }

    private static void aceptarCondiciones(){
        TerminosCondiciones terminos = new TerminosCondiciones();
        terminos.setBounds(0,0,350,200);
        terminos.setVisible(true);
        terminos.setResizable(false);
        terminos.setLocationRelativeTo(null);
    }
}


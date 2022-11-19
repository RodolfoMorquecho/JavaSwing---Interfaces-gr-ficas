package javaSwing.practica;
//Referente al ejercicio "ListaDesplegable" de la Hoja 9
//Creacion de distintas listas desplegables para que el usuario seleccione, segun coresponde con su persona.

import javax.swing.*;
import java.awt.event.*;

public class SelectorDeOpciones extends JFrame implements ItemListener, ActionListener{  //Implementacion de eventos en botones y listas desplegables
    private JComboBox comboSexo, comboPais, comboEdad;
    private JLabel info, indicarN;
    private JTextField nombre;
    private JPanel panel;
    private JButton enviar;
    String tipo="", lugar="", anios="";

    //Constructor
    public SelectorDeOpciones(){
        iniciarComponentes();
        ingresarNombre();
        seleccionSexo();
        seleccionPais();
        seleccionEdad();
        informacionRecaudada();
        enviarFormulario();
    }

    //Panel
    private void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    //TextField(nombre) y Label
    private void ingresarNombre(){
        //Etiqueta indicadora
        indicarN = new JLabel("Nombre:");
        indicarN.setBounds(25,15,70,30);
        panel.add(indicarN);

        //Campo de Texto
        nombre = new JTextField();
        nombre.setBounds(95,18,150,25);
        panel.add(nombre);
    }

    //Lista desplegable de Seleccion de Sexo
    private void seleccionSexo(){
        String [] sexo = {"Masculino","Femenino"};  //Crear arreglo de objetos para pasarlo como parametro en el constructor de JComBox asignado a "comboSexo"
        comboSexo = new JComboBox(sexo);
        comboSexo.setBounds(25,65,100,20);
        panel.add(comboSexo);
        comboSexo.addItemListener(this);
    }

    //Lista desplegable de Seleccion de País
    private void seleccionPais(){

        String [] nacionalidad = {"México","Colombia","Peru","Panama","Brasil"};  //Arreglo de cadenas que se pondra como parametro en compoente "comboPais"
        comboPais = new JComboBox(nacionalidad);
        comboPais.setBounds(140,65,100,20);
        panel.add(comboPais);
        comboPais.addItemListener(this);
    }

    //Lista desplegable de Seleccion de Edad
    private void seleccionEdad(){
        comboEdad = new JComboBox();
        for(int i=15;i<=90;i++){    //Se agregaran items del 15 al 90 a la lista
            comboEdad.addItem(String.valueOf(i));  //Cada iteracion lo convertira a String para que lo pueda tomar como parametro
        }
        comboEdad.setBounds(250,65,100,20);
        panel.add(comboEdad);
        comboEdad.addItemListener(this);
    }

    private void enviarFormulario(){
        enviar = new JButton("Enviar");
        enviar.setBounds(140,120,80,25);
        panel.add(enviar);
        enviar.addActionListener(this);
    }

    //Etiqueta de mensaje resultante
    private void informacionRecaudada(){
        info = new JLabel();
        info.setBounds(20,170,380,60);
        panel.add(info);
    }


    public static void main(String[] args){
        Formulario();
    }

    private static void Formulario(){
        SelectorDeOpciones form = new SelectorDeOpciones();
        form.setVisible(true);
        form.setTitle("Información Personal");
        form.setBounds(0,0,400,500);
        form.setResizable(false);
        form.setLocationRelativeTo(null);
    }

    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == comboSexo){
            tipo = comboSexo.getSelectedItem().toString();  //Acceder al item seleccionado de la lista "ComboSexo" y convertir a String para que se almacene ne "tipo"
        }
        else if(e.getSource() == comboPais){
            lugar = comboPais.getSelectedItem().toString();
        }
        else if(e.getSource() == comboEdad){
            anios = comboEdad.getSelectedItem().toString();
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == enviar){
            info.setText("<html>Hola "+nombre.getText()+" sabemos que tu sexo es "+tipo+", <p> eres de "+lugar+" " +
                    " y tienes "+anios+" anios de edad <html>");
        }
    }
}

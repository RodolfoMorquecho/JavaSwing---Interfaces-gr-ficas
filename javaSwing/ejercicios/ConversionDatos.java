package javaSwing.ejercicios;
//Hoja 8

import javax.swing.*;
import java.awt.event.*;

public class ConversionDatos extends JFrame implements ActionListener{
    private JLabel label1, label2, label3;
    private JTextField textF1, textF2;
    private JButton btnSuma, btnCierre;

    public ConversionDatos(){
        //Etiquetas
        setLayout(null);
        label1 = new JLabel("Valor 1:");
        label1.setBounds(45,10,100, 20);
        add(label1);
        label2 = new JLabel("Valor 2:");
        label2.setBounds(45,40,100,20);
        add(label2);
        label3 = new JLabel("Resultado:");
        label3.setBounds(135,90,100,20);
        add(label3);
        //Campos de Texto
        textF1 = new JTextField();
        textF1.setBounds(125,10,100,20);
        add(textF1);
        textF2 = new JTextField();
        textF2.setBounds(125,40,100,20);
        add(textF2);
        //Botones
        btnSuma = new JButton("Sumar");
        btnSuma.setBounds(15,80,100,20);
        add(btnSuma);
        btnSuma.addActionListener(this);
        btnCierre = new JButton("Cerrar");
        btnCierre.setBounds(15,105,100,20);
        add(btnCierre);
        btnCierre.addActionListener(this);
    }

    //Funcionalidad
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnSuma){
            int valor1 = 0, valor2 = 0, resultado = 0;  //Inicializar variables en 0
            valor1 = Integer.parseInt(textF1.getText());  //Convertir la cadena de caracteres capturada en los TextField a enteros
            valor2 = Integer.parseInt(textF2.getText());
            resultado = valor1 + valor2;    //Sumar ya que estan convertidos en enteros
            label3.setText("Resultado: "+resultado);  //Establecer el resultado en la etiqueta "label3"
        }
        else if(e.getSource() == btnCierre){
            System.exit(0);
        }
    }

    public static void main(String[] args){
        ventana();
    }

    public static void ventana(){
        ConversionDatos convertidor = new ConversionDatos();
        convertidor.setTitle("Sumador");
        convertidor.setBounds(0,0,270,185);
        convertidor.setVisible(true);
        convertidor.setResizable(false);
        convertidor.setLocationRelativeTo(null);
    }
}

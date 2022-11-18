package javaSwing.practica;
//Referente al ejercicio "PanelDesplazamiento" de la Hoja 7
//Referente al ejercicio "AreaTexto" y "CampoTexto" de las Hojas 6 y 5

//Programa el cual tiene un campo para escribir una tarea y un boton para agregarla a una area mas grande, en la que podemos observar
//el orden(numero) en que fueron añadidas, tambien podemos bajar con un scroll en caso de que no se alcancen a visualizar todas.

import javax.swing.*;
import java.awt.event.*;

public class TransladarTarea extends JFrame implements ActionListener{
    private JTextField campoTxt;
    private JTextArea areaTxt;
    private JScrollPane scroll;
    private JButton btnAgregar, btnCierre;
    String texto = "", inicio = "";
    int i=1;

    public TransladarTarea(){
        setLayout(null);
        campoTxt = new JTextField();
        campoTxt.setBounds(15,15,120,20);
        add(campoTxt);
        areaTxt = new JTextArea();
        scroll = new JScrollPane(areaTxt);
        scroll.setBounds(15,45,300,300);
        add(scroll);
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(150,15,100,20);
        add(btnAgregar);
        btnAgregar.addActionListener(this);
        btnCierre = new JButton("Cerrar");
        btnCierre.setBounds(325,355,100,20);
        add(btnCierre);
        btnCierre.addActionListener(this);
    }

    //Funcionalidad - Transladar las tareas del textfiel al textarea
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnAgregar){
            texto += i +". "+campoTxt.getText() + "\n";  //Acumulamos el texto escrito en "campoTxt" concaternado con salto de linea y su número de linea
            areaTxt.setText(texto);  //Establecemos el texto anterior en "areaTxt"
            campoTxt.setText("");  //Limpiamos la casilla de "campoTxt" para añadir cosas nuevas
            i++;  //incrementar para asignar el numero de linea siguiente
        }
        else if(e.getSource() == btnCierre){
            System.exit(0);
        }
    }

    //Funcion principal
    public static void main(String[] arg){
        ventana();
    }

    public static void ventana(){
        TransladarTarea conversion = new TransladarTarea();
        conversion.setBounds(0,0,460,430);
        conversion.setVisible(true);
        conversion.setResizable(false);
        conversion.setLocationRelativeTo(null);
        conversion.setTitle("Tareas");
    }
}

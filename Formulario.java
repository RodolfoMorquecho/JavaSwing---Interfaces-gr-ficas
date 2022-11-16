package javaSwing.ejercicios;
//Hoja 1

import javax.swing.*;    //Importar los contenidos de la biblioteca swing

public class Formulario extends JFrame{  //Heredar contenido de biblioteca JFrame(proveniente de swing) a la clase Formulario
    public Formulario(){    //Constructor con acceso publico
        setLayout(null);  //Indicar al programa que se hara uso de coordenadas para la interfaz con el metodo Layout(JFrame),
    }                     // null para que no posicione la interfaz hasta que reciba instrucciones

    public static void main(String[] args) {  //Función principal
        Formulario formulario1 = new Formulario();  //Crear un onjeto de tipo Formulario
        formulario1.setBounds(0,0,400,550);  //Con el objeto accesar al metodo Bounds(JFrame) para cpnfigurar las coordenadas/tamaño de interfaz
        formulario1.setVisible(true);  //Mostrar la interfaz grafica con metodo Visible(JFrame)
        formulario1.setLocationRelativeTo(null);  //Centrar la interfaz siempre sin importar las coordenadas asignadas previas
        formulario1.setResizable(false);  //El usuario no tiene permimtido modificar el tamaño de la interfaz
    }
}

package javaSwing.ejercicios;
//Hoja 3
//Creacion de boton se divide en 2 partes: diseño y funcionalidad

import javax.swing.*;  //Biblioteca para usar componentes(diseño)
import java.awt.event.*;  //Biblioteca para usar eventos en componentes(funcionalidad)

//ActionListener pertenece a la biblioteca java.awt.event.*
//JFrame pertenece a la biblioteca javax.swing.*
//Implementar el metodo "ActionListener" en clase "FormularioBoton" que a su vez hereda de "JFrame"

public class FormularioBoton extends JFrame implements ActionListener{
    //Diseño de componente(Boton)
    JButton boton;  //Crear componente de variable tipo JButton

    //Constructor
    public FormularioBoton(){
        setLayout(null);
        boton = new JButton("Cerrar");  //Inicializar componente con el texto "cerrar"
        boton.setBounds(200,550,100,30);
        add(boton);
        boton.addActionListener(this);  //Agregar el evento/metodo "ActionListener" con parametro referenciado "this" al boton
    }
    
    //Funcionalidad de componente(evento en boton)
    
    //No se puede instanciar un objeto de "ActionListener" debido a que no esta implementado, por que es una interface y sus metodos son abstractos
    //Para instanciar un objeto de "ActionListener" implementamos todos sus metodos, que en este caso es solo 1 (actionPerformed)
    //Metodo getSource pertenece a la clase ActionEvent, ayuda a recuperar/obtener donde se genero u origino un evento
    public void actionPerformed(ActionEvent e){  //metodo que crea un espacio en memoria donde se alojara el evento(e), captura el evento
        if(e.getSource() == boton){  //compara si, el origen del evento obtenido es igual al componente que se espera
            System.exit(0);  //Cierra la interfaz gráfica cuando sa presiona el boton
        }
    }

    //Configuración de interfaz gráfica
    public static void main(String[] args) {
        FormularioBoton formulariobtn = new FormularioBoton();
        formulariobtn.setBounds(0,0,550,650);
        formulariobtn.setVisible(true);
        formulariobtn.setResizable(false);
        formulariobtn.setLocationRelativeTo(null);
    }
}

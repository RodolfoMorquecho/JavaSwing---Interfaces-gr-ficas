package javaSwing.ejercicios;
//Hoja 11

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BarraMenu extends JFrame implements ActionListener{  //La interface "ActionListener" es utilizado para botones y para menus(este caso)
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem [] menuItem;
    String[] colores = {"Rojo","Verde","Azul"};  //Arreglo con las 3 opciones disponibles

    public BarraMenu(){
        barraNavegacion();
        apartadoDeMenu();
        listaDeOpciones();
    }

    //Seccion Barra de Menu
    private void barraNavegacion(){
        setLayout(null);
        barraMenu = new JMenuBar();  //Reservar espacio para la barra
        setJMenuBar(barraMenu);  //Establece el objeto "barraMenu"
    }

    //Pestaña de la barra
    private void apartadoDeMenu(){
        menu = new JMenu("Opciones");
        barraMenu.add(menu);  //Agregamos la pestaña menu a la barra de navegacion "barraMenu"
    }

    private void listaDeOpciones(){
        //Opcion "Rojo ,Verde y Azul"
        menuItem = new JMenuItem[3];
        for(int i=0;i<colores.length;i++){    //Recorrer el array
            menuItem[i] = new JMenuItem(String.valueOf(colores[i]));  //Creacion de item y se asigna el string, segun la posicion de array en la que se ubique
            menu.add(menuItem[i]);    //Se añade cada item a la pestaña "menu"
            menuItem[i].addActionListener(this);    //Le aplicamos un "evento" a cada item
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Crear contenedor, el cual se adapte al tamaño de la interfaz. Por lo que el que cambiara de color sera el contenedor no la interfaz
        //Clase container pertenece a la libreria java.awt.*;
        Container fondo = this.getContentPane();  //Con this.getContentPane() se indica al programa que tome las dimensiones y caracteristicas de la interfaz
                                                  //Las guardara en fondo(Contenedor)

        for(int i=0;i<colores.length;i++){  //Ciclo que recorra el array completo, para comprobar todas las opciones
            if(e.getSource() == menuItem[i]){
                if(menuItem[i].getText()  == "Rojo"){  //Si el texto del item seleccionado es igual a la cadena "Rojo":
                    fondo.setBackground(new Color(255,0,0));  //Cambiara el contenedor "fondo" de color a rojo, debido a que el parametro red esta en 255
                }
                else if(menuItem[i].getText() == "Verde"){
                    fondo.setBackground(new Color(0,255,0));
                }
                else if(menuItem[i].getText() == "Azul"){
                    fondo.setBackground(new Color(0,0,255));
                }
            }
        }

    }

    public static void main(String[] args){
        menuBasico();
    }

    private static void menuBasico(){
        BarraMenu colorFondo = new BarraMenu();
        colorFondo.setVisible(true);
        colorFondo.setTitle("Ilumina tu fondo");
        colorFondo.setBounds(0,0,400,300);
        colorFondo.setResizable(false);
        colorFondo.setLocationRelativeTo(null);
    }


}

package javaSwing.practica;
//Referente al ejercicio "BarraMenu" de la Hoja 11
//Barra de navegador que contiene una pestaña "opciones" la cual a su vez contiene 2 menus, de donde cada una derivan 2 submenus o items


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Submenu extends JFrame implements ActionListener{
    //Declaracion de componentes
    private JMenuBar barraMenu;
    private JMenu menu1, menu2, menu3;
    private JMenuItem subMenu1, subMenu2, subMenu3, subMenu4;

    public Submenu(){
        barraNav();
        opcionesEnMenu();
        opcionesEnSubmenu();
    }

    //Barra Navegador
    private void barraNav(){
        setLayout(null);
        barraMenu = new JMenuBar();  //Instancia de objeto "barraMenu"
        setJMenuBar(barraMenu);  //Establecer el objeto en ***********************************************
    }

    private void opcionesEnMenu(){
        //Pestaña
        menu1 = new JMenu("Opciones");
        barraMenu.add(menu1);  //Agregar la pestaña "menu1" a la barra de nvegacion "barraMenu"

        //Opcion 1 de la pestaña
        menu2 = new JMenu("Tamaño de la ventana");
        menu1.add(menu2);  //Agregar el menu2 al menu1, se posiciona en forma de lista

        //Opcion 2 de la pestaña
        menu3 = new JMenu("Color de fondo");
        menu1.add(menu3);
    }

    private void opcionesEnSubmenu(){
        //Submenu1-2  de la Opcion1
        subMenu1 = new JMenuItem("400x300");  //Asignar el texto al submenu1, wue indica el cambio de medidas que adoptara la ventana
        menu2.add(subMenu1);
        subMenu1.addActionListener(this);  //Indicar que esta opcion si ejecutara un evento
        subMenu2 = new JMenuItem("350x600");
        menu2.add(subMenu2);
        subMenu2.addActionListener(this);

        //Submenu3-4 de la Opcion2
        subMenu3 = new JMenuItem("Rojo");
        menu3.add(subMenu3);
        subMenu3.addActionListener(this);
        subMenu4 = new JMenuItem("Azul");
        menu3.add(subMenu4);
        subMenu4.addActionListener(this);

        //Cierre de ventana y finalizacion de ejecucion
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == subMenu1){
            setSize(400,300);
        }
        else if(e.getSource() == subMenu2){
            setSize(350,600);
        }
        else if(e.getSource() == subMenu3){
            getContentPane().setBackground(new Color(255,0,0));  //Agregar color rojo a las dimensiones que tiene el Frame o ventana
        }
        else if(e.getSource() == subMenu4){
            getContentPane().setBackground(new Color(0,0,255));
        }
    }

    //Funcion principal
    public static void main(String[] args){
        configurarVentana();
    }

    //Metodo static
    public static void configurarVentana(){
        Submenu design = new Submenu();
        design.setBounds(0,0,600,500);
        design.setVisible(true);
        design.setResizable(false);
        design.setLocationRelativeTo(null);
    }
}

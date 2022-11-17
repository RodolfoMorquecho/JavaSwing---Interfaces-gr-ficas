package javaSwing.ejercicios;
//Hoja 9

import javax.swing.*;  //Biblioteca para uso de componentes
import java.awt.event.*;  //Biblioteca para el uso de eventos

public class ListaDesplegable extends JFrame implements ItemListener{  //ItemListener es similar a ActionListener, pero para Listas desplegables
    private JComboBox combo1;
    private JPanel panel;  //Crear componente de tipo JPanel de forma de atributo, nos ayuda ya que utilizaremos varios metodos donde estara implicito

    public ListaDesplegable(){  //Constructor
        iniciarComponentes();
        configLista();
    }

    private void iniciarComponentes(){
        //Panel
        panel = new JPanel();  //Instanciamos el objeto de tipo JPanel
        panel.setLayout(null);  //Desactivar diseño
        this.getContentPane().add(panel);  //this.getContentPane() es para referisrse a que se modificara el Frame(ventana), le indicamos que se agregara el panel
    }

    public void configLista(){
        combo1 = new JComboBox();  //Importante no ingresar parametro
        combo1.setBounds(10,10,140,20);
        panel.add(combo1);
        combo1.addItem("Lista de Compras");  //Se agregara este texto como opcion al desplegar la lista, para que se ponga de titulo
        combo1.addItem("Lista de Tareas");
        combo1.addItem("Recetario");
        combo1.addItem("Mi diario");
        combo1.addItemListener(this);
    }

    //Funcionalidad de la lista
    public void itemStateChanged(ItemEvent e){
        if(e.getSource() == combo1){  //Crear variable de tipo String dentro del metodo
            String seleccion = combo1.getSelectedItem().toString();  //Almacenar el item(palabra) seleccionado y convertirlo a Strig
            setTitle(seleccion);
        }
    }

    //Funcion principal
    public static void main(String[] args){
        establecerTitulo();
    }

    public static void establecerTitulo(){
        ListaDesplegable lista1 = new ListaDesplegable();
        lista1.setBounds(0,0,350,300);
        lista1.setVisible(true);
        lista1.setResizable(false);
        lista1.setLocationRelativeTo(null);
    }
}

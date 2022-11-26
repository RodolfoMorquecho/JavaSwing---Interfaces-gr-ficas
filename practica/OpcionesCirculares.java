package javaSwing.practica;
//Referente al ejercicio "BotonCircular" de la Hoja 14
//Creacion de distintos bloques de botones circulares para configurar la interfaz con un titulo o color diferente

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class OpcionesCirculares extends JFrame implements ChangeListener{
    private JRadioButton[] bloqueUno, bloqueDos;
    private ButtonGroup bg1, bg2;
    private JPanel panel;
    private JLabel label1, label2;
    String[] titulos = {"Ventana","Frame","Interfaz"};
    String[] colores = {"Rojo","Verde","Azul"};

    //Constructor
    public OpcionesCirculares(){
        iniciarComponentes();
        bloquesDeBotonesUno();
        indicacionUno();
        bloquesDeBotonesDos();
        indicacionDos();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //Panel
    private void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    //Opciones - Botones circulares 1
    private void bloquesDeBotonesUno(){
        int corX=25, corY=50, tamX=100, tamY=25;  //Valores de cordenadas y tamaños
        bg1 = new ButtonGroup();  //Crear grupo de botones para asignar todos aquellos que se creen dentro del array de JRadioButton

        bloqueUno = new JRadioButton[titulos.length];  //Reservamos el espacio del numero de botones que se utilizara
        for(int i=0;i< titulos.length;i++){  //Bucle para generar los botones correspondientes
            bloqueUno[i] = new JRadioButton(""+titulos[i]);  //Se crea el boton con el texto correspondiente del arreglo "titulos"
            bloqueUno[i].setBounds(corX,corY,tamX,tamY);
            panel.add(bloqueUno[i]);
            bg1.add(bloqueUno[i]);  //Se agrega el boton al grupo de botones uno
            bloqueUno[i].addChangeListener(this);
            corY += 35;  //Se recorren 35 pixeles en el eje y para cada nuevo boton
        }
    }

    //Indicacion para el grupo de botones 1
    private void indicacionUno(){
        label1 = new JLabel("Selecciona el titulo:");
        label1.setBounds(15,15,250,25);
        label1.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(label1);
    }

    //Opciones - Botones circulares 2
    private void bloquesDeBotonesDos(){
        int corX=25, corY=200, tamX=100, tamY=25;
        bg2 = new ButtonGroup();

        bloqueDos = new JRadioButton[colores.length];
        for(int i=0;i< colores.length;i++){
            bloqueDos[i] = new JRadioButton(String.valueOf(colores[i]));
            bloqueDos[i].setBounds(corX,corY,tamX,tamY);
            panel.add(bloqueDos[i]);
            bg2.add(bloqueDos[i]);
            bloqueDos[i].addChangeListener(this);
            corY += 35;
        }
    }

    //Indicacion para el grupo de botones 2
    private void indicacionDos(){
        label2 = new JLabel("Selecciona el color:");
        label2.setBounds(15,165,250,25);
        label2.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(label2);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //Condicional para bloque de botones Uno
        for(int i=0;i< titulos.length;i++){
            if(bloqueUno[i].isSelected()){
                String texto = bloqueUno[i].getText();
                setTitle(texto);
            }
        }

        //Condicional para bloque de botones Dos
        for(int i=0;i< colores.length;i++){
            if(bloqueDos[i].isSelected()){
                String tono = bloqueDos[i].getText();  //Conseguimos el texto del boton seleccionado y lo asignamos a la variable tipo string "tono"
                if(tono.equals("Rojo")){    //Si la cadena de tono es igual a "Rojo":
                    panel.setBackground(new Color(255,0,0));  //El panel se pinta de color rojo
                }
                if(tono.equals("Verde")){
                    panel.setBackground(new Color(0,255,0));
                }
                if(tono.equals("Azul")){
                    panel.setBackground(new Color(0,0,255));
                }
            }
        }
    }

    public static void main(String[] args) {
        formulario();
    }

    public static void formulario(){
        OpcionesCirculares oc = new OpcionesCirculares();
        oc.setBounds(0,0,550,450);
        oc.setVisible(true);
        oc.setResizable(false);
        oc.setLocationRelativeTo(null);
    }
}

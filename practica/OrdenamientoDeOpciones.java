package javaSwing.practica;
//Referente al ejercicio "CuadroDeSeleccion" de la Hoja 12
//Programa que presenta distintos generos de musica y el usuario debera de seleccionar 2 o mas

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class OrdenamientoDeOpciones extends JFrame implements ChangeListener {
    private JCheckBox[] cuadro;
    private JLabel[] etiqueta;
    private JLabel titulo1, titulo2;
    private JButton ascendente, descendente;
    private JPanel panel;
    String[] musica = {"Rock","Pop","Jazz","Metal","Electronica","Salsa","Funk"};

    //Rock:1950, Pop:1960, Jazz:1895, Metal:1961, Electronica:1963, Salsa:1970, Funk:1969

    public OrdenamientoDeOpciones(){
        iniciarComponentes();
        seleccionaGenero();
        titulos();
        mostrarGenero();
    }

    //Panel
    private void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    //Selecciona generos musicales
    private void seleccionaGenero(){
        int corX=30, corY=30, tamX=100, tamY=25;  //Valores para posicionar los checBox

        cuadro = new JCheckBox[musica.length];  //Reservamos el numero de generos encontrados en el arreglo "musica" para el arreglo "cuadro"
        for (int i=0;i< musica.length;i++){
            cuadro[i] = new JCheckBox(""+musica[i]);  //Asignara cada genero a un JCheckBox
            cuadro[i].setBounds(corX,corY,tamX,tamY);
            corY = corY + 35;    //Se aumentan 35 a la cordenada "y" para que en cada iteracion se dezplaze en ese eje
            panel.add(cuadro[i]);
            cuadro[i].addChangeListener(this);

        }
    }

    //Titulo previo a generos
    private void titulos(){
        //Primer titulo
        titulo1 = new JLabel("Elige tus generos musicales preferidos");
        titulo1.setFont(new Font("Serif", Font.PLAIN, 24));
        titulo1.setBounds(350,45,400,25);
        panel.add(titulo1);
    }


    //Generar etiquetas para mostrar los generos seleccionados
    private void mostrarGenero(){
        int corX=180, corY=100, tamX=100, tamY=25;
        etiqueta = new JLabel[musica.length];  //************************************* Cambiar el 7 de array
        for(int i=0;i<7;i++){
            etiqueta[i] = new JLabel();
            etiqueta[i].setBounds(corX,corY,tamX,tamY);
            etiqueta[i].setOpaque(true);
            etiqueta[i].setBackground(new Color(0,178,255));
            panel.add(etiqueta[i]);
            corX += 110;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int numEtiquetas = 0;
        for (int i=0;i< musica.length;i++){
            if(cuadro[i].isSelected() == true){  //Si el checkbox es seleccionado:
                String genero = cuadro[i].getText();  //Se acumulara el texto de ese checkbox en una variable tipo String
                etiqueta[numEtiquetas].setText(genero);  //Se establecera como texto en la etiqueta correspondiente, segun el numero de arreglo recorrido
            }
            else{
                etiqueta[numEtiquetas].setText("");  //Si el checkbox no esta seleccionado, limpiar la etiqueta
            }
            numEtiquetas++;  //Al terminar un ciclo del for, aumentamos el indicador del arreglo para ocupar el espacio de la siguiente etiqueta
        }
    }

    public static void main(String[] args) {
        formularioMusical();
    }

    private static void formularioMusical(){
        OrdenamientoDeOpciones melomano = new OrdenamientoDeOpciones();
        melomano.setBounds(0,0,1000,350);
        melomano.setVisible(true);
        melomano.setResizable(false);
        melomano.setLocationRelativeTo(null);
    }


}

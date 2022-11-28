package javaSwing.practica;
//Referente al ejercicio "BotonCircular" de la Hoja 14
//Creacion de tres bloques de preguntas, el cual muestra el numero de aciertos y cambios en la unterfaz, si se consigue el puntaje mas alto

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoPreguntas extends JFrame implements ChangeListener, ActionListener {
    private JRadioButton[] respuestas1, respuestas2, respuestas3;
    private ButtonGroup bg1, bg2, bg3;
    private JLabel pregunta1, pregunta2, pregunta3, resultado;
    private JButton boton1;
    private JPanel panel;
    private boolean res1 = false, res2 = false, res3 = false;;
    private int a=0, b=0, c=0, resulFinal=0;

    public JuegoPreguntas(){
        iniciarComponentes();
        preguntaUno();
        alternativasUno();
        preguntaDos();
        alternativasDos();
        preguntaTres();
        alternativasTres();
        aciertos();
        enviarResultado();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //Panel
    private void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    //Primer pregunta
    private void preguntaUno(){
        pregunta1 = new JLabel("¿Que color obtienes al combinar azul con rojo?");
        pregunta1.setBounds(20,15,400,30);
        pregunta1.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(pregunta1);
    }

    //Respuestas de la primer pregunta
    private void alternativasUno(){
        String[] opciones = {"Naranja","Amarillo","Morado"};
        int ejeY = 60;
        bg1 = new ButtonGroup();
        respuestas1 = new JRadioButton[opciones.length];  //Reservamos el espacio para el numero de botones que usaremos
        for(int i=0;i<opciones.length;i++){
            respuestas1[i] = new JRadioButton(String.valueOf(opciones[i]));  //Crear el componente con su respectivo texto del array "opciones"
            respuestas1[i].setBounds(25,ejeY,100,25);
            panel.add(respuestas1[i]);
            bg1.add(respuestas1[i]);
            respuestas1[i].addChangeListener(this);
            ejeY += 35;
        }
    }

    //Segunda preegunta
    private void preguntaDos(){
        pregunta2 = new JLabel("________  es una biblioteca grafica para Java");
        pregunta2.setBounds(25,180,400,30);
        pregunta2.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(pregunta2);
    }

    //Respuestas de la segunda pregunta
    private void alternativasDos(){
        String[] opciones = {"Xerces","Swing","Guava"};
        int ejeY = 225;
        bg2 = new ButtonGroup();
        respuestas2 = new JRadioButton[opciones.length];  //Reservamos el espacio para el numero de botones que usaremos
        for(int i=0;i<opciones.length;i++){
            respuestas2[i] = new JRadioButton(String.valueOf(opciones[i]));  //Crear el componente con su respectivo texto del array "opciones"
            respuestas2[i].setBounds(25,ejeY,100,25);
            panel.add(respuestas2[i]);
            bg2.add(respuestas2[i]);
            respuestas2[i].addChangeListener(this);
            ejeY += 35;
        }
    }

    //Tercera pregunta
    private void preguntaTres(){
        pregunta3 = new JLabel("¿Cuales son los resultados de 70x10 y 7x100?");
        pregunta3.setBounds(25,345,400,30);
        pregunta3.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(pregunta3);
    }

    //Respuestas de la tercera pregunta
    private void alternativasTres(){
        String[] opciones = {"700 y 700","6000 y 70","60 y 70"};
        int ejeY = 390;
        bg3 = new ButtonGroup();
        respuestas3 = new JRadioButton[opciones.length];  //Reservamos el espacio para el numero de botones que usaremos
        for(int i=0;i<opciones.length;i++){
            respuestas3[i] = new JRadioButton(String.valueOf(opciones[i]));  //Crear el componente con su respectivo texto del array "opciones"
            respuestas3[i].setBounds(25,ejeY,100,25);
            panel.add(respuestas3[i]);
            bg3.add(respuestas3[i]);
            respuestas3[i].addChangeListener(this);
            ejeY += 35;
        }
    }

    //Etiqueta del resultado
    private void aciertos(){
        resultado = new JLabel();
        resultado.setBounds(80,500,350,30);
        resultado.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(resultado);
    }

    //Boton para enviar resultado
    private void enviarResultado(){
        boton1 = new JButton("Enviar");
        boton1.setBounds(225,550,100,25);
        panel.add(boton1);
        boton1.addActionListener(this);
    }

    public void stateChanged(ChangeEvent e){
        if(respuestas1[2].isSelected()){  //Respuesta correcta de pregunta 1, esta ubicada en esta posicion del array
            res1 = true;  //Cambia a true la variable booleana, que esta inicializada en false
            a = 1;    //Cambia de 0 a 1 el valor de la variable "a", para poderse sumar con las otras respuestas correctas y poder imprimir el num. de aciertos
        }else{
            //En caso de que no se seleccione la respuesta correcta o se haya seleccionado y se cambie por otra opcion, mantiene o resetea a false
            res1 = false;
            if(a == 1){  //Si se cambia de opcion a una incorrecta, se debe restar ese acierto o de lo contrario, lo seguira tomando como correcto
                a = 0;
            }
        }
        if(respuestas2[1].isSelected()){
            res2 = true;
            b = 1;
        }else{
            res2 = false;
            if(b == 1){
                b = 0;
            }
        }
        if(respuestas3[0].isSelected()){
            res3 = true;
            c = 1;
        }else{
            res3 = false;
            if(c == 1){
                c = 0;
            }
        }

        resulFinal = a+b+c;  //Almacena todas las respuestas correctas
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            if(res1 == true && res2 == true && res3 == true){  //Si las tres preguntas son correctras:
                resultado.setText("¡Felicidades! Acertaste a todo");  //Envia mensaje de feliciddes
                panel.setBackground(new Color(255,0,255));  //Accion a la pregunta 1
                setTitle(respuestas2[1].getText());  //Accion a la pregunta 2
                setSize(700,700);  //Accion a la pregunta 3
            }
            else{  //En caso contrario, envia el numero de aciertos en el siguiente mensaje
                resultado.setText("Obtuviste "+resulFinal+" aciertos, Sigue intentandolo!");

                //Reseteamos todas las acciones que genero el tener los 3 aciertos
                panel.setBackground(new Color(240,240,240));  //Accion a la pregunta 1
                setTitle("");  //Accion a la pregunta 2
                setSize(550,650);  //Accion a la pregunta 3
            }
        }
    }
    public static void main(String[] args){
        preguntas();
    }

    private static void preguntas(){
        JuegoPreguntas jp = new JuegoPreguntas();
        jp.setBounds(0,0,550,650);
        jp.setVisible(true);
        jp.setResizable(false);
        jp.setLocationRelativeTo(null);
    }
}

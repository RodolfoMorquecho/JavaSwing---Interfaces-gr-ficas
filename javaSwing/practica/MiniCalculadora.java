package javaSwing.practica;
//Calculadora con la funcionalidad de las cuatro operaciones aritmeticas basicas, haciendo uso de componentes como: botones, etiquetas y panel.
//Implementacio de matriz en tablero de botones

import javax.swing.*;  //Contiene la libreria JFrame de donde se tomaran los componentes como botones, etiquetas, etc.
import java.awt.*;  //e utilizara para crear un objeto de tipo "Panel"
import java.awt.event.*;  //Contiene el metodo actionPerformed de la interface ActionLitener que se implementara para la funcionalidad ed botones


public class MiniCalculadora extends JFrame implements ActionListener{
    private JButton btnSum, btnRes, btnMul, btnDiv, btnAC, btnColor;  //Botones operaciones
    private JButton[][] matrizBtn;                                    //Matriz bootnes de 0 a 9, punto e igual
    private JLabel part1, part2, operacion, res, pantalla, igual;  //Etiquetas ubicadas dentro de la pantalla de calculadora
    int a=20, b=200, x=60, y=30;        //a=posicion x, b=posicion y, x=ancho de boton, y=alto de boton
    int col = 3, fil = 4, num = 0, difColor = 0;  //columnas y filas de la matriz, difColor contador para cambiar color de pantalla
    float n1 = 0, n2 = 0, resultado = 0;  //Almacenan todos los valores ingresador por usuario
    String texto = "", texto2 = "";  //Almacenan los numeros ingresados por usuario pero convertidos a string


    public MiniCalculadora(){    //Constructor
        iniciarComponentes();  //Llamada de metodo

    }

    public void iniciarComponentes(){  //metodo que contiene tod0 el diseño estructural de la calculadora
        //PANEL: se usara para plasmar el diseño sobre él
        Panel panel = new Panel();  //Creacion de panel
        panel.setLayout(null);  //Desactivando el diseño
        this.getContentPane().add(panel);  //this.getContentPane() es para referisrse a que se modificara el Frame(ventana), le indicamos que se agregara el panel

        //Botones operaciones
        btnMul = new JButton("x");    //Boton multiplicacion
        btnMul.setFont(new Font("Serif", Font.PLAIN, 22));  //Establece tipo y tamaño de fuente
        btnMul.setBounds(a+180,b-90,x,y);
        panel.add(btnMul);
        btnMul.addActionListener(this);
        btnDiv = new JButton("/");    //Boton division
        btnDiv.setFont(new Font("Serif", Font.PLAIN, 22));
        btnDiv.setBounds(a+180,b-60,x,y);
        panel.add(btnDiv);
        btnDiv.addActionListener(this);
        btnSum = new JButton("+");    //Boton suma
        btnSum.setFont(new Font("Serif", Font.PLAIN, 22));
        btnSum.setBounds(a+180,b-30,x,y);
        panel.add(btnSum);
        btnSum.addActionListener(this);
        btnRes = new JButton("-");    //Boton resta
        btnRes.setFont(new Font("Serif", Font.PLAIN, 22));
        btnRes.setBounds(a+180,b,x,y);
        panel.add(btnRes);
        btnRes.addActionListener(this);

        //Botones numeros, igual y punto
        matrizBtn = new JButton[fil][col];  //Se asigna el numero de filas y columnas de cada aray del boton(matriz en este caso)
        for(int i=0;i<fil;i++){    //Recorre el eje "y" de matriz
            for(int j=0;j<col;j++){    //Recorre el eje "x" de matriz

                if(i == 0 && j == 0){  //Si la posicion de cada array cumple con la condicion establecida al mismo tiempo,ejecutara lo siguiente
                    matrizBtn[i][j] = new JButton(".");  //Pintara como texto un "." en ese boton
                }
                else if(i == 0 && j == 2){  //Si la posicion de cada array cumple con la condicion establecida al mismo tiempo,ejecutara lo siguiente
                    matrizBtn[i][j] = new JButton("=");
                    matrizBtn[i][j].setFont(new Font("Serif", Font.PLAIN, 24));
                }
                else{  //En caso de que no cumpla las condiciones anteriores comenzara a asignar numeros a los botones hasta que recorra ambos for
                    matrizBtn[i][j] = new JButton( ""+num);  //El primer boton tendra valor 0, ya que el contador num esta inicilizado en cero
                    num += 1;    //antes de salir de este condicional, aumentamos el contador en 1 para la proxima vez que entremos se asigne eso al siguiente boton
                }
                matrizBtn[i][j].setBounds(a,b,x,y);  //Posicionamiento de boton
                panel.add(matrizBtn[i][j]);  //Se agregara cada boton al panel, que a su vez esta sobre la ventana
                matrizBtn[i][j].addActionListener(this);
                a += x;  //Modificacion de posicion "x" para el siguiente boton, hasta que recorra el for de toda la columna
            }
            a = a-180;  //Al terminar una columna se "reinicia" la posicion inicial del eje x, para conseguir una alineacion con el boton de abajo
            b = b-30;  //Al terminar una columna se resta el ancho de boton para posicionar la siguiente encima
        }

        //Pantalla
        part1 = new JLabel();  //Viualización del primer numero ingresado por usuario
        part1.setBounds(40,20,80,30);
        panel.add(part1);

        operacion = new JLabel();  //Visualización del signo de la operación ingresada
        operacion.setBounds(50,40,20,30);
        panel.add(operacion);

        part2 = new JLabel();  //Viualización del segundo numero ingresado por usuario
        part2.setBounds(40,60,80,30);
        panel.add(part2);

        igual = new JLabel();  //Viualización del igual al ejecutar operación
        igual.setBounds(130,45,20,30);
        igual.setFont(new Font("Serif", Font.PLAIN, 24));
        panel.add(igual);

        res = new JLabel();  //Viualización del resultado
        res.setBounds(150,45,100,30);
        res.setFont(new Font("Serif", Font.PLAIN, 24));
        panel.add(res);

        pantalla = new JLabel();  //Posicionamiento, ancho y largo de pantalla de calculadora
        pantalla.setBounds(20,20,240,70);
        pantalla.setOpaque(true);  //Establecemos que se pueda pintar el fondo de la etiqueta
        pantalla.setBackground(Color.cyan);
        panel.add(pantalla);

        //Botones para limpiar pantalla y cambiar color
        btnAC = new JButton("AC");  //Boton para borrar todas las operaciones de pantalla
        btnAC.setBounds(20,230,x,y);
        panel.add(btnAC);
        btnAC.addActionListener(this);

        btnColor = new JButton("Color");  //Boton para cambiar color de la pantalla de calculadora
        btnColor.setBounds(20+x,230,180,y);
        panel.add(btnColor);
        btnColor.addActionListener(this);
    }

    //Funcion principal
    public static void main(String[] args){
        //Se crea un objeto de tipo MiniCalculadora, el cual contiene en su constructor el metodo "iniciarComponentes" con toda la estructura y funcionalidad de la calculadora
        MiniCalculadora calculo = new MiniCalculadora();
        calculo.setBounds(0,0,300,320);
        calculo.setTitle("Calculadora");  //Titulo de la ventana
        calculo.setVisible(true);
        calculo.setResizable(false);
        calculo.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {  //Implementación de metodo actionPerformed de la interface ActionListener

        for(int i=0;i<fil;i++) {  //Recorrer todos los botnes de la matriz para comparar el evento en caso de que se haga click en alguno
            for(int j=0;j<col;j++) {  //La matriz contiene: {.,0,=,1,2,3,4,5,6,7,8,9}

                if(e.getSource() == matrizBtn[i][j]){  //Se comparara si el suceso procede de la acción sobre el mismo botón
                    //En caso de que la etiqueta "operacion" este vacia y que el operador "=" no sea ingresado, ejecutara lo siguiente:
                    if(operacion.getText().length() == 0 && matrizBtn[i][j].getText() != "="){
                        texto = texto + matrizBtn[i][j].getText();  //Se almacenara cada numero que cumpla la condicion anterior como texto
                        part1.setText(texto);  //Se imprimira la cadena texto en la etiqueta "part1"
                        n1 = Float.parseFloat(texto);  //Pasaremos de String a float la cadena texto, para poder realizar las operaciones aritmeticas
                    }
                    //En caso de no cumplir el condicional anterior "if":
                    //Si la etiquta de operacion ya tiene asignado un operador "y" la etiqueta donde se situa el primer numeroya contiene uno "y" la etiqueta del "igual" aun esta vacia:
                    else if(operacion.getText().length() != 0  && part1.getText().length() != 0  && igual.getText().length() == 0){
                        if(matrizBtn[i][j].getText() != "="){  //Mientras el boton de la matriz sea distinto a igual, podra ser agregado
                            texto2 = texto2 + matrizBtn[i][j].getText();  //Se almacenara cada numero que cumpla las condiciones anteriores como texto en la variable texto2
                            part2.setText(texto2);  //Se imprimira la cadena texto en la etiqueta "part2"
                            n2 = Float.parseFloat(texto2);  //Pasaremos de String a float la cadena texto2, para poder realizar las operaciones aritmeticas
                        }
                        else{
                            igual.setText("=");  //En caso contrario donde se ingrese el boton "=" dejara de acumular numeros en part2 y realizara la operacion
                            if(operacion.getText() == btnSum.getText()){  //Si en la etiqueta "operacion" se encuentra el mismo caracter que el que contiene el "btnSum":
                                resultado = n1 + n2;  //Se suman n1 y n2, se almacenan en la variable "resultado"
                            }
                            else if(operacion.getText() == btnMul.getText()){  //Si en la etiqueta "operacion" se encuentra el mismo caracter que el que contiene el "btnMul":
                                resultado = n1 * n2;  //Se multiplican n1 y n2, se almacenan en la variable "resultado"
                            }
                            else if(operacion.getText() == btnRes.getText()){  //Si en la etiqueta "operacion" se encuentra el mismo caracter que el que contiene el "btnRes":
                                resultado = n1 - n2;  //Se resta n1 menos n2, se almacenan en la variable "resultado"
                            }
                            else if(operacion.getText() == btnDiv.getText()){  //Si en la etiqueta "operacion" se encuentra el mismo caracter que el que contiene el "btnDiv":
                                resultado = n1 / n2;  //Se divide n1 entre n2, se almacenan en la variable "resultado"
                            }
                            //En caso de que el resultado sea entero, el programa devuelve un ".0" despues.
                            //La funcion "quitarCero" resuelve ese problema, se manda como parametro el resultado en flotante y lo devuelve en string
                            quitarCero(resultado);
                            res.setText(quitarCero(resultado));  //Se establece la cadena de resultado en la etiqueta "res" para mostrar en pantalla de calculadora el resultado final
                        }
                    }
                }

                //Botones fuera de la matriz:
                else if(e.getSource() == btnSum){  //Si se presiona el "btnSum", establece el simbolo "+" en la etiqueta "operacion"
                    operacion.setText("+");
                }
                else if(e.getSource() == btnRes){  //Si se presiona el "btnRes", establece el simbolo "-" en la etiqueta "operacion"
                    operacion.setText("-");
                }
                else if(e.getSource() == btnMul){  //Si se presiona el "btnMul", establece el simbolo "x" en la etiqueta "operacion"
                    operacion.setText("x");
                }
                else if(e.getSource() == btnDiv){  //Si se presiona el "btnDiv", establece el simbolo "/" en la etiqueta "operacion"
                    operacion.setText("/");
                }
                else if(e.getSource() == btnAC){  //Si se presiona el "btnAC", limpia todas las etiquetas y quedan vacias para comenzar de 0
                    part1.setText("");
                    part2.setText("");
                    operacion.setText("");
                    igual.setText("");
                    res.setText("");
                    texto = "";
                    texto2 = "";
                }

                //La pantalla de la calculadora viene de color cyan por default
                //EL contador "difColor" esta inicializado en 0 pereo toma el color cyan ya que esta preestablecido y aun no se ha presionado el "btnColor" ni una vez
                else if(e.getSource() == btnColor){
                    if(difColor == 0){
                        pantalla.setBackground(Color.MAGENTA);
                        difColor++;
                    }
                    else if(difColor == 1){  //El contador esta en 1, asi que tomara el color de la instruccion de este condicional
                        pantalla.setBackground(Color.ORANGE);
                        difColor++;  //Aumentara el contador en 2, para que al presionar el boton pase al siguiente color. asi sucesivamente
                    }
                    else if(difColor == 2){
                        pantalla.setBackground(Color.GREEN);
                        difColor++;
                    }
                    else if(difColor == 3){
                        pantalla.setBackground(Color.WHITE);
                        difColor++;
                    }
                    else if(difColor == 4){  //El contador esta en 4, pero ya no hay un color o condicional siguiente, así que se debe reinicia el contador en 0
                        pantalla.setBackground(Color.cyan);
                        difColor = 0;  //Se reinicia el contador para que tome la instruccion inicial y la pantalla se pinte magenta
                    }
                }
            }
        }
    }

    //Funcion para eliminar el ".0" despues de un numero entero
    public String quitarCero(float resultado){  //Funcion que regresa un String y recibe como parametro un flotante
        String retorno = "";
        retorno = Float.toString(resultado);  //En caso de que el condicional de abajo no se cumpla, solo se convierte en string
        if(resultado % 1 == 0){    //Si el resultado entre 1, no deja restantes:
            retorno = retorno.substring(0,retorno.length()-2);  //Se eliminan los ultimos 2 elementos de la cadena(".0") previamente convertida
        }
        return retorno;  //retorna lo que haya en la cadena "retorno" segun sea el caso
    }
}

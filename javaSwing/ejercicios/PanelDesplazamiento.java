package javaSwing.ejercicios;
//Hoja 7

import javax.swing.*;

public class PanelDesplazamiento extends JFrame {
    private JScrollPane desplazo;
    private JTextArea areaTexto;
    private JTextField campoTexto;

    public PanelDesplazamiento(){
        setLayout(null);
        areaTexto = new JTextArea();
        desplazo = new JScrollPane(areaTexto);
        desplazo.setBounds(15,40,300,400);
        add(desplazo);
        campoTexto = new JTextField();
        campoTexto.setBounds(15,10,120,20);
        add(campoTexto);
    }

    public static void main(String[] args){
        ventana();
    }

    public static void ventana(){
        PanelDesplazamiento pd = new PanelDesplazamiento();
        pd.setBounds(0,0,400,500);
        pd.setVisible(true);
        pd.setResizable(false);
        pd.setLocationRelativeTo(null);
    }

}


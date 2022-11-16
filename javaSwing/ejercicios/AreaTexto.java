package javaSwing.ejercicios;
//Hoja 6

import javax.swing.*;
import java.awt.event.*;

public class AreaTexto extends JFrame implements ActionListener{
    private JTextField campoTexto;
    private JTextArea areaTexto;
    private JButton btnCierre;

    public AreaTexto(){
        setLayout(null);
        campoTexto = new JTextField();
        campoTexto.setBounds(10,10,200,20);
        add(campoTexto);
        areaTexto = new JTextArea();
        areaTexto.setBounds(10,40,300,350);
        add(areaTexto);
        btnCierre = new JButton("Cerrar");
        btnCierre.setBounds(330,415,80,20);
        add(btnCierre);
        btnCierre.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnCierre){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ventana();
    }

    public static void ventana(){
        AreaTexto at = new AreaTexto();
        at.setBounds(0,0,450,500);
        at.setVisible(true);
        at.setResizable(false);
        at.setLocationRelativeTo(null);
    }
}

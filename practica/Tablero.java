package algoritmos.algtms;

import java.util.Scanner;

public class Tablero {
    public static void main(String[] args) {
        int num;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Tamaño de tablero: ");
        num = entrada.nextInt();
        for(int i=1;i<=num;i++){
            for(int j=1;j<=num;j++){
                if(j < i){
                    System.out.print("* ");
                }
                else if(j == i ){
                    System.out.print("  ");
                }
                else
                    System.out.print("# ");
            }
            System.out.println();
        }
    }
}

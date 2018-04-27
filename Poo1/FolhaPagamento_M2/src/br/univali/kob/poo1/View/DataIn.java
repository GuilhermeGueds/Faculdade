/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.View;

import java.util.Scanner;

/**
 * Classe Entrada de dados.
 *
 * @author Guilherme Guedes e Daniel Passos
 */
public class DataIn {

    /**
     * Arquivo para leitura diretamente do console (System.in).
     */
    private static Scanner in = new Scanner(System.in);

    /**
     * Lê uma linha do console.
     *
     * @param caption Texto que identifica o que está sendo solicitado (rótulo)
     * @return uma string com a linha lida
     */
    private static String readLine(String caption) {
	System.out.printf("%s ", caption);
	return in.nextLine();
    }

    /**
     * Lê uma string do console.
     *
     * @param caption Texto que identifica o que está sendo solicitado (rótulo)
     * @return uma string com a linha lida
     */
    public static String readlnString(String caption) {
        String name = readLine(caption);
        while(name.isEmpty() || name.equals(" ") || name.equals("  ") || name.equals("   ")  ){
            System.out.println(caption + " inválido, Digite novamente.");
            name = readLine(caption);
        }
        return name;
    }

    /**
     * Lê um int do console.
     *
     * @param caption Texto que identifica o que está sendo solicitado (rótulo)
     * @return um int a partir da conversão da linha lida
     */
    public static int readlnInt(String caption, int x, int y) {
        int z =  Integer.parseInt(readLine(caption));
        while(z < x || z>y){
           System.out.println("Opção Inválida.");
            z = z =  Integer.parseInt(readLine(caption));    
        }  
        return z;
    }

    /**
     * Aguarda até que um ENTER seja teclado no console.
     */
    public static void waitEnter() {
        readLine("pressione [ENTER] para continuar\n");
    }
}

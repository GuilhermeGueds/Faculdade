/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Main;

//import java.io.IOException;
import java.io.IOException;

/**
 * Sistema que calcula folha de pagamento de um funcionario
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class FolhaDePagamento {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SystemPayroll system = new SystemPayroll();
        system.run();
    }
}

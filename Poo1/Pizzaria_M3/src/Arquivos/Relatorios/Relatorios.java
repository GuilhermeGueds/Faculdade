/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Relatorios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe Abstrata Relatórios.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public abstract class  Relatorios {
    
    /**
     * Caminho que deve ser pecorrido.
     */
    //private String caminho;

    /**
     * Construtor para classe Relatórios.
     */
    public Relatorios() {
    
    }
    
    /**
     * Salvar o Arquivo.
     * @param caminho
     * @return 
     */
    public  boolean salvar(String caminho){
        try{
            FileWriter arquivo = new FileWriter(caminho);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            gravarArquivo.write(relatorio());
            gravarArquivo.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }  
    } 
    
    /**
     * @return relatorio.
     */
    public abstract String relatorio(); 
}

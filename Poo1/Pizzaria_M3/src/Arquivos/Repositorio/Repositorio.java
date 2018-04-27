/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Repositorio;

import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe Repositório.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public  class Repositorio implements Serializable{
    
    /**
     * Leitura do Arquivo.
     * @param caminho
     * @return 
     */
    public static String ler(String caminho){
        String conteudo = "";
        try{
            FileReader arquivo = new FileReader(caminho);
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha = "";
            try{
                linha = lerArquivo.readLine();
                while(linha!=null){
                    conteudo += linha ;
                    linha = lerArquivo.readLine();
                }
                arquivo.close();
            }catch(IOException ex){
                conteudo = "Erro: Não foi possivel ler o arquivo";
            }
                
        }catch(FileNotFoundException ex){
            conteudo =  "Erro: Arquivo não encontrado";
        }
        if (conteudo.contains("Erro")){
            return "";
        }else{
            return conteudo;
        }
    }
    
    /**
     * Escrever no Arquivo.
     * @param caminho
     * @param texto
     * @return 
     */
    public static boolean escrever(String caminho, String texto){
        try{
            FileWriter arquivo = new FileWriter(caminho);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            gravarArquivo.write(texto);
            gravarArquivo.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    } 
}
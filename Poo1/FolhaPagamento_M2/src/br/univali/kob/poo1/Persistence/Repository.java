/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Persistence;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositório genérico.
 *
 * @author Marcello Thiry
 *
 * @param <T> o tipo dos elementos manipulados pelo repositório
 */
public abstract class Repository<T> {

    private final String FILENAME;
    private List<T> ELEMENTS;
    // private final Validator VAL = new Validator();

    /**
     * @param fileName o nome do arquivo, no qual os elementos gerenciados pelo
     * repositório serão persistidos (inclui o caminho)
     *
     * @throws FileNotFoundException se o nome do arquivo não existir
     * @throws IOException se houver algum erro de leitura
     * @throws ClassNotFoundException se os objetos armazenados não forem do
     * tipo T
     */
    public Repository(String fileName) throws IOException, ClassNotFoundException {
        this.FILENAME = fileName;
        loadAll();
    }

    /**
     * Se o elemento já existe, ele será atualizado com o objeto passado. Caso
     * contrário, ele será incluído. Logo após a alteração, a lista é persistida
     * em um arquivo.
     *
     * @param element o elemento a ser armazenado
     *
     * @throws NullPointerException se o element for null
     * @throws FileNotFoundException se o nome do arquivo não existir
     * @throws IOException se houver algum erro de gravação
     */
    public void save(T element) throws IOException {
        int index = find(element);
        if (index >= 0) {
            ELEMENTS.set(index, element); // atualiza
        } else {
            ELEMENTS.add(element); // adiciona
        }
        saveAll();
    }

    /**
     * Exclui o primeiro elemento encontrado que atender aos critérios == ou
     * equals. Logo após a alteração, a lista é persistida em um arquivo.
     *
     * @param element o elemento a ser removido
     *
     * @throws NullPointerException se o elemento for null
     * @throws FileNotFoundException se o nome do arquivo não existir
     * @throws IOException se houver algum erro de gravação
     */
    public void delete(T element) throws IOException {
        //      VAL.notNull(element, "element");
        ELEMENTS.remove(element);
        saveAll();
    }

    /**
     * Verifica se primeiro elemento está na lista (critérios == ou equals).
     *
     * @param element o elemento a ser removido
     * @return true se o elemento está no repositório, caso contrário false
     *
     * @throws NullPointerException se o elemento for null
     */
    public boolean contains(T element) {
        //      VAL.notNull(element, "element");
        return ELEMENTS.contains(element);
    }

    /**
     * @return a lista com todos os elementos
     */
    public List<T> findAll() {
        return ELEMENTS;
    }
    
    public void clear() throws IOException {
        ELEMENTS.removeAll(ELEMENTS);
        saveAll();
    }

    /**
     * Encontra o primeiro elemento que atender aos critérios == ou equals.
     *
     * @param element o elemento a ser encontrado
     * @return -1 se não encontrou o elemento ou a posição do elemento na lista.
     *
     * @throws NullPointerException se o elemento for null
     */
    protected int find(T element) {
        //      VAL.notNull(element, "element");
        return ELEMENTS.indexOf(element);
    }

    /**
     * Carrega todos os objetos do arquivo para a memória.
     *
     * @throws FileNotFoundException se o nome do arquivo não existir
     * @throws IOException se houver algum erro de leitura
     * @throws ClassNotFoundException se o objeto que estiver armazenado no
     * arquivo não for da classe T
     */
    private void loadAll() throws IOException, ClassNotFoundException {
        // try with resources
        try (InputStream file = new FileInputStream(FILENAME);
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream(buffer);) {
            ELEMENTS = (List<T>) input.readObject();
        } catch (FileNotFoundException ex) {
            ELEMENTS = new ArrayList<>();
        }
    }

    /**
     * Grava todos os objetos da lista em um arquivo.
     *
     * @throws FileNotFoundException se o nome do arquivo não existir
     * @throws IOException se houver algum erro de gravação
     */
    private void saveAll() throws IOException {
        // try with resources
        try (OutputStream file = new FileOutputStream(FILENAME);
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);) {
            output.writeObject(ELEMENTS);
        }
    }
}

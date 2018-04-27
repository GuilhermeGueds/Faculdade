/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Entity;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe Departamento.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class Department implements Comparable<Department> {

    /**
     * Nome do departamento.
     */
    private String name;
    
    /**
     * Diretor do departamento.
     */    
    private Employee director;
    
    /**
     * Vetor de Funcionário.
     */    
    private ArrayList<Employee> employee = new ArrayList<>();

    /**
     * Construtor para classe Department.
     * @param name
     */
    public Department(String name) {
        this.name = name;
    }

    /**
     * @return nome do departamento.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name do departamento.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return do diretor do departamento.
     */
    public Employee getDirector() {
        return director;
    }

    /**
     * @param director do departamento.
     */
    public void setDirector(Employee director) {
        this.director = director;
    }

    /**
     * @param cont
     * @return do funcionário na posição cont.
     */
    public Employee getEmployee(int cont) {
        return employee.get(cont);
    }

    /**
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee.add(employee);
        OrderByName();
    }

    /**
     * Ordenação em ordem alfabética por nome.
     */
    public void OrderByName() {
        //  Collections.sort(employee);
    }

    /**
     * @return do funcionário.
     */
    public ArrayList<Employee> size() {
        return employee;
    }
    
    /**
     * @param otherName
     * @return redefinição para compareTo
     */
    @Override
    public int compareTo(Department otherName) {
        return this.name.compareTo(otherName.getName());
    }

    /**
     * @return uma string para representação de um objeto.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Nome do Departamento: " + name + AppConfig.NEW_LINE);
        output.append("Funcionarios: " + AppConfig.NEW_LINE);
        output.append(employee + AppConfig.NEW_LINE);
        output.append(AppConfig.NEW_LINE);
        return output.toString();
    }

    /**
     * @param obj
     * @return indica se algum outro objeto é "igual" a este.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Department other = (Department) obj;
        return true;
    }

    /**
     * @return um valor de código de hash para o objeto.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + Objects.hashCode(this.director);
        hash = 73 * hash + Objects.hashCode(this.employee);
        return hash;
    }
}

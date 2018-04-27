/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Entity;

import br.univali.kob.poo1.Entity.Controller.Validate;
import java.time.LocalDate;
import java.time.Period;
import java.io.Serializable;

/**
 * Classe Abstrata de Pessoa.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public abstract class Person implements Validate {

    /**
     * Próximo ID a ser utilizado.
     */
    private static int nextId =1;
   
    /**
     * ID único gerado automaticamente.
     */
    private int id ;

    /**
     * Nome da pessoa.
     */
    private String name;
    
    /**
     * CPF da pessoa.
     */
    private long cpf;
    
    /**
     * RG da pessoa.
     */
    private long rg;
    
    /**
     * Data de nascimento da pessoa.
     */
    private LocalDate dateOfBirth;
    
    /**
     * Email da pessoa.
     */
    private String email;
    
    /**
     * Construtor para classe Person.
     * 
     * @param name
     * @param cpf
     * @param rg
     * @param dateOfBirth
     * @param email
     */
    public Person(String name, long cpf, long rg, LocalDate dateOfBirth, String email) {
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.dateOfBirth = dateOfBirth;
        id = nextId++;
        this.email = email;
        validateName(name);
    }

    /**
     * Construtor para classe Person com formato String.
     * 
     * @param name
     * @param cpf
     * @param rg
     * @param dateOfBirth
     * @param email
     */
    public Person(String name,String cpf, String rg, String dateOfBirth,String email){
        this(name,Integer.valueOf(cpf), Integer.valueOf(rg),LocalDate.parse(dateOfBirth,AppConfig.DATE_FORMAT),email);
    }

    /**
     * @return próximo ID.
     */
    public  int getNextId(){
        return nextId;
    }
        
    /**
     * @return id.
     */
    public int getId(){
        return id;
    }    
    
    /**
     * @return nome da pessoa.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
         this.name = name;
         validateName(name);
    }

    /**
     * @return CPF da pessoa.
     */
    public long getCpf() {
        return cpf;
    }

    /**
     * @param cpf
     */
    public void setCpf(int cpf) {
        this.cpf = cpf;
        validateCpf(cpf);
    }

    /**
     * @return RG da pessoa.
     */
    public long getRg() {
        return rg;
    }

    /**
     * @param rg
     */
    public void setRg(int rg) {
        this.rg = rg;
        validateRg(rg);
    }
    
    /**
     * @return data de nascimento da pessoa.
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * @return email da pessoa.
     */
    public String getEmail(){
        return this.email;
    }
        
    /**
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     * @return idade da pessoa.
     */
    public int getAge(){
        Period period = Period.between(dateOfBirth,LocalDate.now());
        return period.getYears();
    }
    
    /**
     * Validação do Nome.
     */
    public void validateName(String argument){
            if (argument == null){
                throw new NullPointerException("nome não pode ser nulo");
            }
    }
    
    /**
     * Validação do CPF.
     */
    public void validateCpf(Integer argument){
            if (argument == null){
                throw new NullPointerException("cpf não pode ser nulo");
            }
    }
   
    /**
     * Validação do RG.
     */
    public void validateRg(Integer argument){
            if (argument == null){
                throw new NullPointerException("Rg não pode ser nulo");
            }
    }
  
    /**
     * @return uma string para representação de um objeto.
     */
    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("\n--------------------------------------" + AppConfig.NEW_LINE);
        output.append("Funcionario" + AppConfig.NEW_LINE + AppConfig.NEW_LINE);
        output.append("  Id: " + id + AppConfig.NEW_LINE);
        output.append("  Nome: " + name + AppConfig.NEW_LINE);
        output.append("  CPF: " + cpf + AppConfig.NEW_LINE);
        output.append("  RG: " + rg + AppConfig.NEW_LINE);
        output.append("  Email: " + email + AppConfig.NEW_LINE);
        output.append("  Data de Nascimento: " + 
                dateOfBirth.format(AppConfig.DATE_FORMAT) + AppConfig.NEW_LINE);
        output.append(appendToString());
        output.append("--------------------------------------" + AppConfig.NEW_LINE);
        output.append(AppConfig.NEW_LINE);
        return output.toString();
    }
    
    /**
     * @param obj
     * @return indica se algum outro objeto é "igual" a este.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Person person = (Person)obj;
        
        return id == person.id && 
                (name == person.name || name.equals(person.name)) &&
                (dateOfBirth == person.dateOfBirth || dateOfBirth.equals(person.dateOfBirth));
    }
    
    /**
     * @return um valor de código de hash para o objeto.
     */
    @Override
    public int hashCode(){
        return id ^ (name.hashCode()) ^ (dateOfBirth.hashCode());
    }

    /**
     * @return método para as subclasses chamar o toString().
     */
    protected abstract String appendToString(); 
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Persistence;

import br.univali.kob.poo1.Entity.AppConfig;
import br.univali.kob.poo1.Entity.Employee;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Classe Repositório de Funcionário.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class EmployeeRepository  extends Repository implements Report<String>{
   
    /**
     * Vetor de Funcionários.
     */      
    private ArrayList<Employee> employeeRepository  = new ArrayList<>();
    
    /**
     * Construtor para classe EmployeeRepository.
     * 
     * @param fileName
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public EmployeeRepository(String fileName) throws IOException, ClassNotFoundException {
        super(fileName);
    }
   
    /**
     * @return total da folha de pagamento.
     */
    public BigDecimal totalPayroll(){
        BigDecimal total = new BigDecimal(0);
            for(int i=0; i< employeeRepository.size(); i++){
                total = total.add(employeeRepository.get(i).getSalaryBase());
         } 
           return total;
    }
    
    /**
     * @return tamanho do repositório de funcionários.
     */
    public int size(){
        return employeeRepository.size();
    }

    /**
     * @return repositório.
     */
    public ArrayList<Employee> getRepository() {
        return employeeRepository;
    }
    
    /**
     * Salvar Funcionário.
     * @param employee
     * @throws IOException
     */
    public void save(Employee employee) throws IOException{
        employeeRepository.add(employee);
        Collections.sort(employeeRepository);
        clear();
        save(report());
    }
    
    /**
     * Deletar Funcionário.
     * @param name
     * @throws IOException  
     */ 
    public void delete(String name) throws IOException{
        int x =0;
        try{
            while(!employeeRepository.get(x).getName().equals(name)){
                x++;   
            }
            employeeRepository.remove(x);
            Collections.sort(employeeRepository);
            clear();
            save(report());
        }catch(java.lang.IndexOutOfBoundsException e){
            System.out.println("\nFuncionário não existe");    
        }      
    } 
    
    /**
     * Verifica se repositorio esta vazio
     * @return 
     */
    public boolean isEmpty(){
        return employeeRepository.isEmpty();
    }
    
    /**
     * @param cont
     * @return do funcionário na posição cont.
     */
    public Employee getEmployee(int cont){
        return employeeRepository.get(cont);
    }
    
    /**
     * @return do repositório de funcionários.
     */
    public ArrayList getAll(){
        return employeeRepository;
    }
    
    /**
     * @param name
     * @return repositório de funcionários encontrado pelo nome em uma posição.
     */
    public Employee findByName(String name){
        int x =0;
        try{
            while(!employeeRepository.get(x).getName().equals(name)){
                x++;    
            }
            return employeeRepository.get(x);
        }catch(java.lang.IndexOutOfBoundsException e){
            System.out.println("Funcionário não existe");
        }
        return null;
    }  
    
    /**
     * Limpar repositório de departamento.
     * @throws IOException
     */
    public void clearRepository() throws IOException{
        employeeRepository.removeAll(employeeRepository);
        clear();
    }

    /**
     * Verificar quem é o funcionário com maior salário.
     * @return betterPaid
     */
    public Employee betterPaid(){
        Employee betterPaid = this.getEmployee(0);
          int j =0;  
        for(int i =0; i< this.size()-1; i++){
           if(betterPaid.getSalaryBase().compareTo(this.getEmployee(i+1).getSalaryBase())<0){
              betterPaid = this.getEmployee(i+1);       
           } 
            
        } 
        return betterPaid;   
    }
    
    /**
     * @return uma string para representação de um objeto.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(AppConfig.NEW_LINE);
        output.append(AppConfig.NEW_LINE);
        output.append("\nRelatorios dos Funcionarios" + AppConfig.NEW_LINE);
        output.append(AppConfig.NEW_LINE);
        for(int i=0; i<employeeRepository.size(); i++){
            output.append("--------------------------------------------------" + AppConfig.NEW_LINE);
            output.append(AppConfig.NEW_LINE);
            output.append("  Nome: " + getEmployee(i).getName() + AppConfig.NEW_LINE);
            output.append("  Salario Base: " + getEmployee(i).getSalaryBase()+ AppConfig.NEW_LINE);
            output.append(AppConfig.NEW_LINE);
        }
        output.append("--------------------------------------------------" + AppConfig.NEW_LINE);
        output.append(AppConfig.NEW_LINE);
        output.append("  Total  da Folha de Pagamento: " + 
                this.totalPayroll().setScale(2, RoundingMode.CEILING)+ AppConfig.NEW_LINE);
        output.append(AppConfig.NEW_LINE);
        output.append("--------------------------------------------------" + AppConfig.NEW_LINE);
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
        final EmployeeRepository other = (EmployeeRepository) obj;
        if (!Objects.equals(this.employeeRepository, other.employeeRepository)) {
            return false;
        }
        return true;
    }

    /**
     * @return um valor de código de hash para o objeto.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.employeeRepository);
        return hash;
    }

    /**
     * @return relatório.
     */
    @Override
    public String report() {
        return this.toString();
    }
}

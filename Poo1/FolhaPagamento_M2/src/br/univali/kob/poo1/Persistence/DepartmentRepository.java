/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Persistence;

import br.univali.kob.poo1.Entity.AppConfig;
import br.univali.kob.poo1.Entity.Department;
import br.univali.kob.poo1.Entity.Controller.Storage;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;

/**
 * Classe Repositório de Departamento.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class DepartmentRepository extends Repository implements Report<String> {

    /**
     * Contador.
     */
    private static int count=0; 
    
    /**
     * Vetor de Departamento.
     */        
    private ArrayList<Department> departmentRepository = new ArrayList<>();
    
    /**
     * Vetor de Funcionário.
     */    
    //private ArrayList<Employee> arrayOfemployee;

    /**
     * Construtor para classe DepartmentRepository.
     * @param fileName
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public DepartmentRepository(String fileName) throws IOException, ClassNotFoundException {
        super(fileName);
    }
    
    /**
     * verifica se repositorio esta vazio
     * @return 
     */
   public boolean isEmpty(){
        return departmentRepository.isEmpty();
    }
   
    /**
     * @return tamanho do repositório de departamento.
     */
    public int size() {
        return departmentRepository.size();
    }

    /**
     * Salvar departamento.
     * @param department
     * @throws IOException
     */
    public void save(Department department) throws IOException {
        count++;
        departmentRepository.add(department);
        Collections.sort(departmentRepository);
      
    }

    /**
     * Remover departamento.
     * @param department
     * @throws IOException
     */
    public void remove(Department department) throws IOException {
        count--;
        departmentRepository.remove(department);
        Collections.sort(departmentRepository);
      
    }

    /**
     * @param count
     * @return do departamento na posição cont.
     */
    public Department getDepartment(int count) {
        return departmentRepository.get(count);
    }

    /**
     * @return do repositório de departamentos.
     */
    public ArrayList getAll() {
        return departmentRepository;
    }

    /**
     * @param name
     * @return repositório de departamento encontrado pelo nome em uma posição.
     */
    public Department findByName(String name) {
        int x = 0;
        try {
            while (!departmentRepository.get(x).getName().equals(name)) {
                x++;
            }
            return departmentRepository.get(x);
        } catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println("Departamento não existe");
        }
        return null;
    }

    /**
     * Limpar repositório de departamento.
     * @throws IOException
     */
    public void clearRepository() throws IOException {
        departmentRepository.removeAll(departmentRepository);
        clear();
    }

    /**
     * Inserir funcionário no departamento.
     * @param departmentRepository
     * @param employeeRepository
     */
    public void insertEmployeeOnDepartment(DepartmentRepository departmentRepository,
            EmployeeRepository employeeRepository) {
        for (int i = 0; i < employeeRepository.size(); i++) {
            count++;
            if (employeeRepository.getEmployee(i).getStorage() == Storage.MANAGEMENTER) {
                departmentRepository.getDepartment(0).setEmployee(employeeRepository.getEmployee(i));
            } else if (employeeRepository.getEmployee(i).getStorage() == Storage.PRODUCTION) {
                departmentRepository.getDepartment(1).setEmployee(employeeRepository.getEmployee(i));
            } else if (employeeRepository.getEmployee(i).getStorage() == Storage.DIRECTOR) {
                departmentRepository.getDepartment(2).setEmployee(employeeRepository.getEmployee(i));
            }
        }
    }
    
    /**
     * Remover funcionário do departamento.
     * @param departmentRepository
     * @param repository
     */
    public void removeEmployeeOnDepartment(DepartmentRepository departmentRepository, 
            EmployeeRepository repository) {
        count--;
        insertEmployeeOnDepartment(departmentRepository, repository);
    }
    
    /**
     * @return uma string para representação de um objeto.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(AppConfig.NEW_LINE);
        output.append(AppConfig.NEW_LINE);
        output.append("\nRelatorio dos Departamentos" + AppConfig.NEW_LINE);
        output.append(AppConfig.NEW_LINE);
        for (int i = 0; i < departmentRepository.size(); i++) {
            output.append("--------------------------------------------------" + AppConfig.NEW_LINE);
            output.append(AppConfig.NEW_LINE);
            output.append("  Departamento:  " + departmentRepository.get(i).getName() + AppConfig.NEW_LINE);
            output.append(AppConfig.NEW_LINE);
            output.append(departmentRepository.get(i).size().toString());
        }
        output.append("--------------------------------------------------" + AppConfig.NEW_LINE);
        output.append(AppConfig.NEW_LINE);
        output.append("Quantidade de Departamentos:  " + departmentRepository.size() + AppConfig.NEW_LINE);
        output.append("Quantidade de Funcionários:  " + count + AppConfig.NEW_LINE);
        output.append(AppConfig.NEW_LINE);
        output.append("--------------------------------------------------" + AppConfig.NEW_LINE);
        return output.toString();
    }

    /**
     * @return relatório.
     */
    @Override
    public String report() {
        return this.toString();
    }
}
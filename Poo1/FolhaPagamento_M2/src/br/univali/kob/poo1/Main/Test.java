/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Main;

import br.univali.kob.poo1.Entity.Company;
import br.univali.kob.poo1.Persistence.DepartmentRepository;
import br.univali.kob.poo1.Persistence.EmployeeRepository;
import br.univali.kob.poo1.Persistence.Payroll;
import br.univali.kob.poo1.Entity.Controller.Storage;
import br.univali.kob.poo1.Entity.Department;
import br.univali.kob.poo1.Entity.Director;
import br.univali.kob.poo1.Entity.Employee;
import java.io.IOException;

/**
 * Classe Test.
 *  Classe que inicia os Repositórios
 * @author Guilherme Guedes e Daniel Passos
 */
public class Test {

    public void test(EmployeeRepository paramEmployeeRepository, DepartmentRepository paramDepartmentRepository,Company paramCompany,Payroll paramPayroll) throws IOException, ClassNotFoundException {

        EmployeeRepository employeeRepository = paramEmployeeRepository;
        DepartmentRepository departmentRepository = paramDepartmentRepository;
        Company company = paramCompany;
        Payroll payroll = paramPayroll;

        
        Employee employee1 = new Director("Lanterna Verde", "91234567891", "9876543", "01/12/1916", "lanternaverde@gmail.com", "15/04/1994", "800", "Chefao", Storage.DIRECTOR, "03/12/2012", "180");
        Employee employee2 = new Director("Flash II", "12345678910", "8765432", "02/11/1918", "flash2@gmail.com", "14/03/1992", "5000", "Chefao", Storage.DIRECTOR, "06/12/2014", "160");
        Employee employee3 = new Director("Cacador de Marte", "23456789101", "7654321", "03/10/1920", "cacadordemarte@gmail.com", "14/03/1990", "1000", "Chefao", Storage.DIRECTOR, "09/12/2016", "140");
        Employee employee4 = new Employee("Aquaman", "34567891011", "6543210", "04/09/1922", "aquaman@gmail.com", "12/01/1988", "4500", "Heroi", Storage.MANAGEMENTER, "144");
        Employee employee5 = new Employee("Batman", "45678910111", "5432101", "05/08/1924", "batman@gmail.com", "11/02/1986", "20000", "Vilao", Storage.PRODUCTION, "146");
        Employee employee6 = new Employee("Superman", "56789101112", "4321013", "06/07/1926", "superman@gmail.com", "10/03/1984", "4000", "Heroi", Storage.MANAGEMENTER, "150");
        Employee employee7 = new Employee("Mulher Maravilha", "67891011121", "3210135", "07/06/1928", "mulhermaravilha@gmail.com", "09/04/1982", "1400", "Vilao", Storage.PRODUCTION, "152");
        Employee employee8 = new Employee("Arqueiro Verde", "78910111213", "2101357", "08/05/1930", "arqueiroverde@gmail.com", "08/05/1980", "3500", "Heroi", Storage.MANAGEMENTER, "156");
        Employee employee9 = new Employee("Elektron", "89101112131", "101357", "09/04/1932", "elektron@gmail.com", "07/06/1978", "1600", "Vilão", Storage.PRODUCTION, "160");
        Employee employee10 = new Employee("Gaviao Negro", "91011121314", "9753111", "10/03/1934", "gaviaonegro@gmail.com", "06/07/1976", "3000", "Heroi", Storage.MANAGEMENTER, "164");
        Employee employee11 = new Employee("Canario Negro", "10111213141", "8642024", "11/02/1936", "canarionegro@gmail.com", "05/08/1974", "1800", "Vilao", Storage.PRODUCTION, "168");
        Employee employee12 = new Employee("Mulher-Gaviao", "10111213141", "6931269", "12/01/1938", "mulhergaviao@gmail.com", "04/09/1972", "2500", "Participante", Storage.FREELANCER, "142");
        Employee employee13 = new Employee("Arqueiro verde", "11121314151", "4812162", "14/03/1940", "arqueiroverde@gmail.com", "03/10/1970", "2000", "Participante", Storage.FREELANCER, "148");
        Employee employee14 = new Employee("Gaviao Negro", "11121314151", "7142128", "14/03/1942", "gaviaonegro@gmail.com", "02/11/1968", "1900", "Participante", Storage.FREELANCER, "160");
        Employee employee15 = new Employee("Vingador Fantasma", "11213141516", "5101520", "15/04/1944", "vingadorfantasma@gmail.com", "01/12/1966", "2300", "Participante", Storage.FREELANCER, "170");

        Department departament1 = new Department("Liga da Justica Elite");
        Department departament2 = new Department("Liga da Justica Europa");
        Department departament3 = new Department("Liga da Justica Satelite");
 
        departmentRepository.save(departament1);
        departmentRepository.save(departament2);
        departmentRepository.save(departament3);
        
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
        employeeRepository.save(employee5);
        employeeRepository.save(employee6);
        employeeRepository.save(employee7);
        employeeRepository.save(employee8);
        employeeRepository.save(employee9);
        employeeRepository.save(employee10);
        employeeRepository.save(employee11);
        employeeRepository.save(employee12);
        employeeRepository.save(employee13);
        employeeRepository.save(employee14);
        employeeRepository.save(employee15);
        
        
    }

   
   
}

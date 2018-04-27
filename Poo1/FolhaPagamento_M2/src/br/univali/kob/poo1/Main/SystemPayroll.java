/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Main;

import br.univali.kob.poo1.Persistence.Payroll;
import br.univali.kob.poo1.View.DataIn;
import br.univali.kob.poo1.Entity.Employee;
import br.univali.kob.poo1.Entity.Company;
import br.univali.kob.poo1.Persistence.EmployeeRepository;
import br.univali.kob.poo1.Persistence.DepartmentRepository;
import br.univali.kob.poo1.Entity.Controller.Storage;
import br.univali.kob.poo1.View.User_interface;
import java.io.IOException;

/**
 * Classe Sistema da Folha de Pagamento.
 *
 * @author Guilherme Guedes e Daniel Passos
 */
public class SystemPayroll {

    /**
     * Repositório de funcionários.
     */
    private EmployeeRepository employeeRepository;

    /**
     * Repositório de departamentos.
     */
    private DepartmentRepository departmentRepository;

    /**
     * Empresa.
     */
    private Company company;

    /**
     * Folha de Pagamento.
     */
    private Payroll payroll;

    /**
     * Fim
     */
    private boolean end = false;

    /**
     * Inicialização
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void initialyze() throws IOException, ClassNotFoundException {
        employeeRepository = new EmployeeRepository("Relatório de Funcionários.dat");
        departmentRepository = new DepartmentRepository("Relatório de Departamentos.dat");
        //departmentRepository.setArrayOfemployee(repository.getRepository());
        //departmentRepository.setArrayOfemployee(repository.getRepository());
        company = new Company("Liga da Justiça", "ligadajustiça@gmail.com", "12/10/2017");
        payroll = new Payroll("Folha de Pagamento.dat", employeeRepository, company);
        Test test = new Test();
        test.test(employeeRepository, departmentRepository, company, payroll);
        departmentRepository.insertEmployeeOnDepartment(departmentRepository, employeeRepository);
        //System.out.println(departmentRepository);
    }

    /**
     * Insere todos os funcionarios em seus departamentos através do storage 
     * caso o funcionario seja freeLancer nao é alocado em um departamento,
     * nem na folha de pagamento.
     *
     * @param departmentRepository
     * @param repository
     */
    private void insertEmployeeOnDepartment(DepartmentRepository departmentRepository, EmployeeRepository repository) {
        for (int i = 0; i < repository.size(); i++) {
            if (repository.getEmployee(i).getStorage() == Storage.MANAGEMENTER) {
                departmentRepository.getDepartment(0).setEmployee(repository.getEmployee(i));
            } else if (repository.getEmployee(i).getStorage() == Storage.PRODUCTION) {
                departmentRepository.getDepartment(1).setEmployee(repository.getEmployee(i));
            } else if (repository.getEmployee(i).getStorage() == Storage.DIRECTOR) {
                departmentRepository.getDepartment(2).setEmployee(repository.getEmployee(i));
            }
        }
    }

    /**
     * Opções de menu.
     *
     * @throws IOException
     */
    private void menu() throws IOException {
        boolean end = false;
        int option = User_interface.menuOption();
        switch (option) {
            case 1:
                consultEmployee();
                DataIn.waitEnter();

                break;
            case 2:
                insurceEmployee();
                DataIn.waitEnter();
                break;
            case 3:
                editionEmployee();
                DataIn.waitEnter();
                break;
            case 4:
                deleteEmployee();
                DataIn.waitEnter();
                break;
            case 5:
                if (!employeeRepository.isEmpty()) {
                    System.out.println(employeeRepository.betterPaid());
                } else {
                    User_interface.isEmpty();
                }
                DataIn.waitEnter();
                break;
            case 6:
                if (!employeeRepository.isEmpty()) {
                    System.out.println(employeeRepository.report());
                } else {
                    User_interface.isEmpty();
                }
                DataIn.waitEnter();

                break;
            case 7:
                if (!departmentRepository.isEmpty()) {
                    System.out.println(departmentRepository.report());
                    departmentRepository.save(departmentRepository.report());
                } else {
                    User_interface.isEmpty();
                }
                DataIn.waitEnter();
                break;
                case 8:
                if (!employeeRepository.isEmpty()) {
                   upgradePayroll();
                } else {
                    User_interface.isEmpty();
                }
                DataIn.waitEnter();
                break;
            case 9:
                if (!employeeRepository.isEmpty()) {
                    System.out.println(payroll.generatePayroll());
                } else {
                    User_interface.isEmpty();
                }
                DataIn.waitEnter();
                break;
            case 10:
                if (!employeeRepository.isEmpty() && !departmentRepository.isEmpty()) {
                    employeeRepository.clearRepository();
                    departmentRepository.clearRepository();
                     User_interface.clearingRepositorys();
                } else {
                    User_interface.isEmpty();
                }
                payroll.clearRepository();
                DataIn.waitEnter();
                break;
            case 11:
                this.end = true;
        }
    }

    /**
     * Consultar funcionário.
     */
    private void consultEmployee() {
        if (!employeeRepository.isEmpty()) {
            String name = User_interface.ConsultEmployee();
            if (null == employeeRepository.findByName(name)) {
                consultEmployee();

            } else {
                System.out.println("\n" + employeeRepository.findByName(name));
            }
        } else {
            User_interface.isEmpty();
        }
    }

    /**
     * Inserir funcionário.
     *
     * @throws IOException
     */
    private void insurceEmployee() throws IOException {
        employeeRepository.save(User_interface.insurceEmployee());

    }
    
    /**
     * Editar um funcionario existente
     *
     * @throws IOException
     */
    private void editionEmployee() throws IOException {
        if (!employeeRepository.isEmpty()) {
            String name = User_interface.ConsultEmployee();
            int x;
            if (null == employeeRepository.findByName(name)) {
                editionEmployee();

            } else {
                employeeRepository.delete(name);
                insurceEmployee();
            }
            System.out.println(employeeRepository);
        } else {
            User_interface.isEmpty();
        }
    }

    /**
     * Deletar funcionário.
     *
     * @throws IOException
     */
    private void deleteEmployee() throws IOException {
        if (!employeeRepository.isEmpty()) {
            String name = User_interface.ConsultEmployee();
            if (null == employeeRepository.findByName(name)) {
                consultEmployee();

            } else {
                employeeRepository.delete(name);
            }
            User_interface.employeeRemoved();
        } else {
            User_interface.isEmpty();
        }
    }
        
    /**
     * Atualizar a folha de pagamento.
     */
    private void upgradePayroll(){
        Employee employee;
        employee = employeeRepository.findByName(User_interface.ConsultEmployee());
        System.out.println(employee.toString());
        employee.setWorkingHours(User_interface.validateWorkingHours());
    }
    /**
     * Chamada para os métodos.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void run() throws IOException, ClassNotFoundException {
        initialyze();
        while (!end) {
            menu();
        }
    }
}

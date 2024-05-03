package com.acn.nemo;

import com.acn.nemo.dto.EmployeeDto;
import com.acn.nemo.mapper.EmployeeMapper;
import com.acn.nemo.model.Employee;
import com.acn.nemo.model.Job;
import com.acn.nemo.util.HibernateUtil;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.apache.logging.log4j.LogManager.*;


/**
 * The type Employee test.
 */

public class EmployeeTest {
    private static final Logger log = getLogger(EmployeeTest.class);

    private static final String PERSISTENCE_UNIT_NAME = "walletPU";


    private EntityManagerFactory factory ;

    private EntityManager entityManager;

    private Query query;

    private EmployeeDto employeeDto;

    //private Session session = HibernateUtil.getSessionFactory().openSession();
    private EntityTransaction transaction;

    /**
     * Employee test.
     */
    @Before
    public void setUp()  {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        entityManager = factory.createEntityManager();
    }

    /**
     * Test retrive all employees.
     */
    @Test
    public void testRetriveAllEmployees(){
        try {
            log.info("Init testRetriveAllEmployees");
            query = entityManager.createNamedQuery("Employee.findAll");
            List<Employee> employeesList = query.getResultList();
            if(employeesList.isEmpty()){
                log.info("Employee list is empty");
            }else {
                for (Employee employee : employeesList) {
                    employeeDto = EmployeeMapper.MAPPER.toDto(employee);
                    log.info("Employee: " +
                            employeeDto.getId()
                            + " - FirstName: " + employeeDto.getFirstName()
                            + " - LastName: " + employeeDto.getLastName() +
                            " - Email: " + employeeDto.getEmail()
                            + " - PhoneNumber: " + employeeDto.getPhoneNumber()
                            + " - Salary:" + employeeDto.getSalary() +
                            " - Job: " + employeeDto.getJob().getJobTitle() +
                            " - Dept. Name: " + employeeDto.getDepartment().getDepartmentName() +
                            " - City: " + employeeDto.getDepartment().getLocation().getCity()
                    );
                }
            }
        }catch (Exception ex){
            log.error("Error: "+ ex.getMessage());
        }finally {
            entityManager.close();
        }
    }

    /**
     * Retrive employee by id.
     */
    @Test
    public void retriveEmployeeById(){
        try{
            log.info("Init testRetriveEmployeeById");
            query = entityManager.createNamedQuery("Employee.findByIdEquals", Employee.class);
            query.setParameter("id",100);
            Employee employee = (Employee) query.getSingleResult();

            if (Objects.nonNull(employee )){
                employeeDto = EmployeeMapper.MAPPER.toDto(employee);
                log.info("Employee: " +
                        employeeDto.getId() + " - FirstName: " + employeeDto.getFirstName() + " - LastName: " + employeeDto.getLastName() +
                        " - Email: " + employeeDto.getEmail() + " - PhoneNumber: " + employeeDto.getPhoneNumber() + " - Salary:" + employeeDto.getSalary() +
                        " - Job: " + employeeDto.getJob().getJobTitle() +
                        " - Dept. Name: " + employeeDto.getDepartment().getDepartmentName() +
                        " - City: " + employeeDto.getDepartment().getLocation().getCity()
                );
            }else {
                log.info( "Employee not found");
            }
        }catch (Exception ex){
            log.error("Error: "+ ex.getMessage());

        }finally {
            entityManager.close();
        }
        log.info("End testRetriveEmployeeById");
    }

    @Test
    public void retriveEmployeeByLastNameStartsWith(){
        try{
            log.info("Init retriveEmployeeByLastNameStartsWith");
            query = entityManager.createNamedQuery("Employee.findByLastNameStartsWith", Employee.class);
            query.setParameter("lastName","G");
            List<Employee> employeeList =  query.getResultList();
            if(!employeeList.isEmpty()){
                for (Employee employee : employeeList) {
                    employeeDto = EmployeeMapper.MAPPER.toDto(employee);
                    log.info("Employee: " +
                            employeeDto.getId() + " - FirstName: " + employeeDto.getFirstName() + " - LastName: " + employeeDto.getLastName() +
                            " - Email: " + employeeDto.getEmail() + " - PhoneNumber: " + employeeDto.getPhoneNumber() + " - Salary:" + employeeDto.getSalary() +
                            " - Job: " + employeeDto.getJob().getJobTitle() +
                            " - Dept. Name: " + employeeDto.getDepartment().getDepartmentName() +
                            " - City: " + employeeDto.getDepartment().getLocation().getCity()
                    );
                }
            }else {
                log.info( "Employee List empty");
            }
        }catch (Exception ex){
            log.error("Error: "+ ex.getMessage());
        }finally {
            entityManager.close();
        }
        log.info("End retriveEmployeeByLastNameStartsWith");
    }

    @Test
    public void retriveEmployeeByLastNameAndFirstNameStartsWith(){
        try{
            log.info("Init retriveEmployeeByLastNameAndFirstNameStartsWith");
            query = entityManager.createNamedQuery("Employee.findByFirstNameStartsWithIgnoreCaseAndLastNameStartsWithIgnoreCase", Employee.class);
            query.setParameter("firstName","j");
            query.setParameter("lastName","m");
            List<Employee> employeeList =  query.getResultList();
            if(!employeeList.isEmpty()){
                for (Employee employee : employeeList) {
                    employeeDto = EmployeeMapper.MAPPER.toDto(employee);
                    log.info("Employee: " +
                            employeeDto.getId() + " - FirstName: " + employeeDto.getFirstName() + " - LastName: " + employeeDto.getLastName() +
                            " - Email: " + employeeDto.getEmail() + " - PhoneNumber: " + employeeDto.getPhoneNumber() + " - Salary:" + employeeDto.getSalary() +
                            " - Job: " + employeeDto.getJob().getJobTitle() +
                            " - Dept. Name: " + employeeDto.getDepartment().getDepartmentName() +
                            " - City: " + employeeDto.getDepartment().getLocation().getCity()
                    );
                }
            }else {
                log.info( "Employee List empty");
            }
        }catch (Exception ex){
            log.error("Error: "+ ex.getMessage());
        }finally {
            entityManager.close();
        }
        log.info("End retriveEmployeeByLastNameAndFirstNameStartsWith");
    }

    @Test
    public void retriveEmployeeBySalaryAndJobId(){
        try{
            log.info("Init retriveEmployeeBySalaryAndJobId");
            query = entityManager.createNamedQuery("Employee.findBySalaryGreaterThanEqualAndJob_JobIdEqualsIgnoreCase", Employee.class);
            query.setParameter("salary",BigDecimal.valueOf(3500));
            query.setParameter("jobId","sh_clerk");
            List<Employee> employeeList =  query.getResultList();
            if(!employeeList.isEmpty()){
                for (Employee employee : employeeList) {
                    employeeDto = EmployeeMapper.MAPPER.toDto(employee);
                    log.info("Employee: " +
                            employeeDto.getId() + " - FirstName: " + employeeDto.getFirstName() + " - LastName: " + employeeDto.getLastName() +
                            " - Email: " + employeeDto.getEmail() + " - PhoneNumber: " + employeeDto.getPhoneNumber() + " - Salary:" + employeeDto.getSalary() +
                            " - Job: " + employeeDto.getJob().getJobTitle() +
                            " - Dept. Name: " + employeeDto.getDepartment().getDepartmentName() +
                            " - City: " + employeeDto.getDepartment().getLocation().getCity()
                    );
                }
            }else {
                log.info( "Employee List empty");
            }
        }catch (Exception ex){
            log.error("Error: "+ ex.getMessage());
        }finally {
            entityManager.close();
        }
        log.info("End retriveEmployeeBySalaryAndJobId");
    }


    @Test
    public void retriveEmployeeByManagerNull(){
        try{
            log.info("Init retriveEmployeeByManagerNull");
            query = entityManager.createNamedQuery("Employee.findByManager_IdNull", Employee.class);
            List<Employee> employeeList =  query.getResultList();
            if(!employeeList.isEmpty()){
                for (Employee employee : employeeList) {
                    employeeDto = EmployeeMapper.MAPPER.toDto(employee);
                    log.info("Employee: " +
                            employeeDto.getId() + " - FirstName: " + employeeDto.getFirstName() + " - LastName: " + employeeDto.getLastName() +
                            " - Email: " + employeeDto.getEmail() + " - PhoneNumber: " + employeeDto.getPhoneNumber() + " - Salary:" +employeeDto.getSalary() +
                            " - Job: " + employeeDto.getJob().getJobTitle() +
                            " - Dept. Name: " + employeeDto.getDepartment().getDepartmentName() +
                            " - City: " + employeeDto.getDepartment().getLocation().getCity()
                    );
                }
            }else {
                log.info( "Employee List empty");
            }
        }catch (Exception ex){
            log.error("Error: "+ ex.getMessage());
        }finally {
            entityManager.close();
        }
        log.info("End retriveEmployeeByManagerNull");
    }

    @Test
    public void retriveEmployeeByDepartmentEquals(){
        try{
            log.info("Init retriveEmployeeByDepartmentEquals");
            query = entityManager.createNamedQuery("Employee.findByDepartment_IdEquals", Employee.class);
            query.setParameter("id",Short.valueOf("100"));
            List<Employee> employeeList =  query.getResultList();
            if(!employeeList.isEmpty()){

                for (Employee employee : employeeList) {
                    employeeDto = EmployeeMapper.MAPPER.toDto(employee);
                    log.info("Employee: " +
                            employeeDto.getId() + " - FirstName: " + employeeDto.getFirstName() + " - LastName: " + employeeDto.getLastName() +
                            " - Email: " + employeeDto.getEmail() + " - PhoneNumber: " + employeeDto.getPhoneNumber() + " - Salary:" +employeeDto.getSalary()
                            +" - Job: " + employeeDto.getJob().getJobTitle()
                            +" - Dept. Name: " + employeeDto.getDepartment().getDepartmentName()
                            +" - City: " + employeeDto.getDepartment().getLocation().getCity()

                    );
                }
            }else {
                log.info( "Employee List empty");
            }
        }catch (Exception ex){
            log.error("Error: "+ ex.getMessage());
        }finally {
            entityManager.close();
        }
        log.info("End retriveEmployeeByDepartmentEquals");
    }

    @Test
    public void insertEmployee() {
        log.info("Recupero Job per FI_MGR");
        query = entityManager.createNamedQuery("Job.findByJobIdEqualsIgnoreCase", Job.class);
        query.setParameter("jobId","FI_MGR");
        Job job = (Job) query.getSingleResult();

        log.info("Recupero Manager ID");
        query = entityManager.createNamedQuery("Employee.findByJob_JobIdEqualsAndManager_IdNotNull", Employee.class);
        query.setParameter("jobId","FI_MGR");
        Employee results = (Employee) query.getSingleResult();


        Employee employee = Employee.builder()
                .phoneNumber("3471378114")
                .email("massimo.caputo@outlook.com")
                .salary(BigDecimal.valueOf(12000))
                .job(job)
                .manager(results.getManager())
                .department(results.getDepartment())
                .hireDate(LocalDate.of(2001, 04, 15))
                .firstName("Massimo")
                .lastName("Caputo")
                .build();
        log.info("Init Insert");
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
            log.info("End Insert");
        }catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
             log.error("Error: " + e.getMessage());
        }finally {
            entityManager.close();
        }
    }

    @Test
    public void updateEmployeePhone(){

        try{

            log.info("Init Update");
            //transaction = session.beginTransaction();
            transaction = entityManager.getTransaction();
            transaction.begin();
            log.info("Recupero Manager ID");
            query = entityManager.createNamedQuery("Employee.findByIdEquals", Employee.class);
            query.setParameter("id",222);
            Employee results = (Employee) query.getSingleResult();

            results.setPhoneNumber("32222111");
           // results.setHireDate(LocalDate.of(2001, 04, 16));
            entityManager.merge(results);
            //entityManager.flush();
            transaction.commit();
            log.info("End Update");
        }catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("Error: " + e.getMessage());
        }finally {
            entityManager.close();
            factory.close();
        }

    }



    @Test
    public void deleteEmployee(){
        try{
            //Trovo Employee
            Employee e = entityManager.find(Employee.class, 220);
            if(Objects.nonNull(e)){
                transaction = entityManager.getTransaction();
                transaction.begin();
                entityManager.remove(e);
                transaction.commit();

            }else{
                log.info("Employee non trovato");
            }
        }catch (Exception e) {
            log.error("Error: " + e.getMessage());
        }finally {
            entityManager.close();
        }
    }

}

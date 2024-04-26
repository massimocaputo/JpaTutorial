package com.acn.nemo;

import com.acn.nemo.model.Department;
import com.acn.nemo.model.Employee;
import com.acn.nemo.model.Job;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
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

    private EntityTransaction transaction;


    /**
     * Employee test.
     */
    @Before
    public void EmployeeTest() {
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
            Query query = entityManager.createNamedQuery("Employee.findAll");
            log.info("Query: " + query.toString());
            List<Employee> employeesList = query.getResultList();
            for (Employee employee : employeesList) {
                log.info("Employee: " +
                employee.getId() + " - FirstName: " +employee.getFirstName() + " - LastName: " +employee.getLastName() +
                " - Email: "+ employee.getEmail() + " - PhoneNumber: "+ employee.getPhoneNumber() +
                " - Dept. Name: " + employee.getDepartment().getDepartmentName() +
                " - City: " + employee.getDepartment().getLocation().getCity()
                );
         }
        }catch (IllegalArgumentException | IllegalStateException iex){
            log.error("Error: "+ iex.getMessage());
        }finally {
            entityManager.close();
        }
    }

    /**
     * Retrive employee by id.
     */
    @Test
    public void retriveEmployeeById(){
        Employee employee = entityManager.find(Employee.class, 100);

        if (Objects.nonNull(employee )){
            log.info("Employee: " +
                    employee.getId() + " - FirstName: " +employee.getFirstName() + " - LastName: " +employee.getLastName() +
                    " - Email: "+ employee.getEmail() + " - PhoneNumber: "+ employee.getPhoneNumber() +
                    " - Dept. Name: " + employee.getDepartment().getDepartmentName() +
                    " - City: " + employee.getDepartment().getLocation().getCity()
            );
        }else {
            log.info( "Employee not found");
        }
    }

    @Test
    public void insertEmployee() {
        Job job = new Job();
        job.setJobTitle("FI_MGR");

        Employee employee = Employee.builder().
                phoneNumber("3471378114").email("massimocaputo@gmail.com").salary(BigDecimal.valueOf(12000))
                .job(job).hireDate(LocalDate.of(2001, 04, 15))
                .firstName("Massimo").lastName("Caputo").build();
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
    public void deleteEmployee(){
        try{
            //Trovo Employee
            Employee e = entityManager.find(Employee.class, 218);
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

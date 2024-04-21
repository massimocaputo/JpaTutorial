package com.acn.nemo;

import com.acn.nemo.model.Employee;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


/**
 * The type Employee test.
 */
public class EmployeeTest {

    /**
     * The constant ENTITY_MANAGER_FACTORY.
     */
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("walletPU");
    /**
     * The Entity manager.
     */
    private EntityManager entityManager;

    /**
     * Employee test.
     */
    @Before
    public void EmployeeTest() {
        this.entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    /**
     * Test retrive all employees.
     */
    @Test
    public void testRetriveAllEmployees(){
        try {
            Query query = entityManager.createNamedQuery("Employee.findAll");
            List<Employee> employeesList = query.getResultList();
            employeesList.forEach(employee -> System.out.println(
                    "Id: "+employee.getEmployeeId()+" -FirstName: "+employee.getFirstName()+
                            " -LastName: "+employee.getLastName()+ " -Email: "+employee.getEmail()
                    )
            );
        }catch (IllegalArgumentException | IllegalStateException iex){
            iex.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    /**
     * Retrive employee by id.
     */
    @Test
    public void retriveEmployeeById(){
        Employee e = entityManager.find(Employee.class, 100);
        if ( null != e){
            System.out.println( "Employee: "+e.toString());
        }else {
            System.out.println( "Employee not found");
        }
    }
}

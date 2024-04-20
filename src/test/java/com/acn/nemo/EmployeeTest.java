package com.acn.nemo;

import com.acn.nemo.model.Employee;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class EmployeeTest {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("walletPU");
    private EntityManager entityManager;

    @Before
    public void EmployeeTest() {
        this.entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    }

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
}

package com.acn.silvia;

import com.acn.silvia.model.Region;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;


public class TestSingleNamedQuery {
    private static EntityManager entityManager;
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("myPU");

    @Before
    public void setUp() {
        entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    @Test()
    public void testFindAllQuery() {
        try {
            Query query = entityManager.createNamedQuery("Region.findAll");
            List<Region> regions = query.getResultList();
            regions.forEach(region -> System.out.println(region.getRegionId() + " " + region.getRegionName()));
        }catch(NoResultException ex) {
            ex.printStackTrace();
        }finally {
            entityManager.close();
        }
    }


    @Test()
    public void testFindByIdQuery() {
        try {

            Query query = entityManager.createNamedQuery("Region.findById");
            query.setParameter("regionId",Integer.valueOf(1));
            List<Region> regions = query.getResultList();
            regions.forEach(region -> System.out.println(region.getRegionId() + " " + region.getRegionName()));
        }catch(NoResultException ex) {
            ex.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

}

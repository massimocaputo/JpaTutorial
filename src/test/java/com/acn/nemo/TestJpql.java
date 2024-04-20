package com.acn.nemo;

import com.acn.nemo.model.Region;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;

public class TestJpql {
    private static EntityManager entityManager;
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("walletPU");


    @Before
    public void setUp() {
        entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    @Test
    public void getAllRegions() {
        try {
            List<Region> regions = entityManager.createQuery("select r from Region r", Region.class).getResultList();
            regions.forEach(region -> System.out.println(region.getRegionId() + " " + region.getRegionName()));
        }catch(NoResultException ex) {
            ex.printStackTrace();
        }
        finally {
            entityManager.close();
        }
    }

}

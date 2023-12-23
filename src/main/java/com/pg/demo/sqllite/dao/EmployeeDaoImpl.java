package com.pg.demo.sqllite.dao;

import com.pg.demo.sqllite.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EmployeeDaoImpl implements EmployeeDao{

    Logger log = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    @Autowired
    private EntityManagerFactory emf;

    private EntityManager getEntityManager(){
        return this.emf.createEntityManager();
    }

    @Override
    public Employee saveEmployee(Employee emp) {
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
            return emp;
        }
        catch (Exception e){
            log.error("com.pg.demo.sqllite.dao.EmployeeDaoImpl Error : ",e);
            em.getTransaction().rollback();
            return null;
        }
        finally {
            if(em!=null){
                em.close();
            }
        }
    }

    @Override
    public Employee findEmpById(Long id) {
        EntityManager entityManager = null;
        try{
            entityManager = getEntityManager();
            return entityManager.find(Employee.class,id);
        }
        catch(Exception e){
            log.error("com.pg.demo.sqllite.dao.EmployeeDaoImpl Error : ",e);
            return null;
        }
        finally {
            entityManager.close();
        }
    }
}

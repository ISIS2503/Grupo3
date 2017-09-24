/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquisoft.minas.persistance;

/**
 *
 * @author alejandro
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ejb.Stateless;

@Stateless
public class Persistance {
    @PersistenceContext(unitName="mongoDB")
    private EntityManager em;
    
    public List findAll()
    {
        Query q = em.createQuery("select * from temperatura");
        return q.getResultList();
    }
}

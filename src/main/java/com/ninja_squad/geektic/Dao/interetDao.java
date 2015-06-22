package com.ninja_squad.geektic.Dao;
import com.ninja_squad.geektic.model.INTERET;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class interetDao{
    @PersistenceContext
    private EntityManager em;
    public List<INTERET> getAllInteret(){
        String jpql = "Select int from Interet as int";
        TypedQuery<INTERET> query = em.createQuery(jpql,INTERET.class);
        return  query.getResultList();
    }
    public INTERET getInteretById(int id){
        return em.find(INTERET.class,id);
    }

}

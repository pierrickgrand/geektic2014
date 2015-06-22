package com.ninja_squad.geektic.Dao;
import com.ninja_squad.geektic.model.Interet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class interetDao{
    @PersistenceContext
    private EntityManager em;
    public List<Interet> getAllInteret(){
        String jpql = "Select int from Interet as int";
        TypedQuery<Interet> query = em.createQuery(jpql,Interet.class);
        return  query.getResultList();
    }
    public Interet getInteretById(int id){
        return em.find(Interet.class,id);
    }

}

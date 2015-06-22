package com.ninja_squad.geektic.Dao;
import com.ninja_squad.geektic.model.Geek;
import com.ninja_squad.geektic.model.Interet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

/**
 * Created by pierrick on 22/06/2015.
 */
@Repository
public class GeekDao {

    @PersistenceContext
    private EntityManager em;


    public List<Geek> getAllGeeks() {
        String jpql = "SELECT geek FROM Geek as geek ";
        TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
        return query.getResultList();
    }

    public List<Geek> getAllGeek(char sexe) {
        String jpql = "SELECT geek FROM Geek as geek WHERE geek.sexe=:sexe";
        TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
        query.setParameter("sexe", String.valueOf(sexe));
        return query.getResultList();
    }

    public List<Geek> getGeekByInteret(Set<Interet> interets) {
        String jpql = "SELECT geek FROM Geek as geek WHERE geek.interets=:interets";
        TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
        query.setParameter("interets", String.valueOf(interets));
        return query.getResultList();
    }
    public List<Geek> getGeekBySexeAndInteret(char sexe,Set<Interet> interets) {
        String jpql = "SELECT geek FROM Geek as geek WHERE geek.sexe=:sexe and geek.interets=:interets";
        TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
        query.setParameter("sexe", String.valueOf(sexe));
        return query.getResultList();
    }


    public Geek getGeekById(int id) {
        return em.find(Geek.class, id);
    }


}

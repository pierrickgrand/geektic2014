package com.ninja_squad.geektic.Dao;
import com.ninja_squad.geektic.model.Geek;
import com.ninja_squad.geektic.model.Interet;
import org.springframework.stereotype.Repository;

import javax.management.Query;
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
//public List<Geek> getGeekByInteret(Set<Interet> interets) {
    //    String jpql = "SELECT geek FROM Geek as geek WHERE geek.interets=:interets";
    //    TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
    //    query.setParameter("interets", String.valueOf(interets));
    //    return query.getResultList();
    //}
    //public List<Geek> getGeekBySexeAndInteret(String sexe,Set<Interet> interets) {
    //    String jpql = "SELECT geek FROM Geek as geek WHERE geek.sexe=:sexe and geek.interets=:interets";
    //    TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
    //    query.setParameter("sexe", String.valueOf(sexe));
    //    return query.getResultList();
    //}

    public List<Geek> getAllGeeks() {
        String jpql = "SELECT geek FROM Geek as geek ";
        TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
        return query.getResultList();
    }

    public List<Geek> getAllGeek(String sexe) {
        String jpql = "SELECT geek FROM Geek as geek WHERE geek.sexe=:sexe";
        TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
        query.setParameter("sexe", String.valueOf(sexe));
        return query.getResultList();
    }

    public List<Geek> getGeeksByInteret(String interet) {
        //String jpql = "SELECT  geek FROM Geek geek JOIN geek.interets i WHERE i.nom = :interet";
        String param = "%"+interet.toLowerCase()+"%";
        String jpql = "SELECT  geek FROM Geek geek JOIN geek.interets i WHERE LOWER (i.nom) LIKE  :param ";
        TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
        query.setParameter("param", String.valueOf(param));
        return query.getResultList();

    }


    public Geek getGeekById(int id) {

        em.find(Geek.class,id).setNb_vues(em.find(Geek.class,id).getNb_vues()+1);
        return em.find(Geek.class, id);

    }

    


}

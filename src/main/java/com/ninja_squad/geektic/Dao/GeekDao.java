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

}

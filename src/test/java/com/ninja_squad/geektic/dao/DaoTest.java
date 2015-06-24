package com.ninja_squad.geektic.dao;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.Dao.GeekDao;
import com.ninja_squad.geektic.model.Geek;
import com.sun.tools.internal.xjc.reader.dtd.bindinfo.BIConversion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.util.stream.Collectors;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.junit.Assert.assertEquals;




/**
 * Created by pierrick on 22/06/2015.
 */
public class DaoTest extends BaseDaoTest {
    @Autowired
    private GeekDao geekDao;


    @Test
    public void testFindById() throws Exception {
        int expected = 0;
        int response = geekDao.getGeekById(expected).getId();
        assertEquals(expected, response);

    }
    @Test
    public void testFindBySex() {
        List<Integer> expected = Arrays.asList(0, 2, 3); // les utilisateurs dont l'id est 0,2 et 3 sont des hommes

        List<Integer> response = new ArrayList<>();

        List<Geek> liste_geek = geekDao.getAllGeek("HOMME");

        for(Geek geek:liste_geek){
            response.add(geek.getId());
        }

        assertEquals(expected, response);
    }

    @Test
    public void testFindByInterest() {
        List<Integer> expected = Arrays.asList(1, 2, 3); // les utilisateurs dont l'id est 1,2 et 3 aiment le JEE
        List<Integer> response = new ArrayList<>();

        List<Geek> liste_geek = geekDao.getGeeksByInteret("JEE");

        for(Geek geek:liste_geek){
            response.add(geek.getId());
        }

        assertEquals(expected, response);
    }



}

package com.ninja_squad.geektic.dao;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.geektic.Dao.GeekDao;
import com.ninja_squad.geektic.model.Geek;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.ninja_squad.dbsetup.operation.Operation;
import static org.junit.Assert.assertEquals;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;



/**
 * Created by pierrick on 22/06/2015.
 */
public class DaoTest extends BaseDaoTest {
    @Autowired
    private GeekDao geekDao;

    @Before
    public void populateDatabase() { // AVANT CHAQUE TEST ON REMET LA BASE EN ETAT
        Operation operation = sequenceOf(UtilitaireTest.DELETE_ALL,UtilitaireTest.INSERT_REFERENCE_DATA);
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }


    @Test
    public void testGetGeekById() throws Exception { //test si la fonction GetGeekById retourne bien le bon geek
        int expected = 0;
        int response = geekDao.getGeekById(expected).getId();
        assertEquals(expected, response);

    }
    @Test
    public void testGetAllGeek() {  //test si la fonction getAllGeek retourne bien des geeks du bon sexe
        List<Integer> expected = Arrays.asList(0, 2, 3); // les utilisateurs dont l'id est 0,2 et 3 sont des hommes

        List<Integer> response = new ArrayList<>();

        List<Geek> liste_geek = geekDao.getAllGeek("HOMME");

        for(Geek geek:liste_geek){
            response.add(geek.getId());
        }

        assertEquals(expected, response);
    }

    @Test
    public void testGetGeeksByInteret() { //test si la fonction GetGeeksByInteret retourne bien des geeks ayant un interet precis
        List<Integer> expected = Arrays.asList(1, 2, 3); // les utilisateurs dont l'id est 1,2 et 3 aiment le JEE
        List<Integer> response = new ArrayList<>();

        List<Geek> liste_geek = geekDao.getGeeksByInteret("JEE");

        for(Geek geek:liste_geek){
            response.add(geek.getId());
        }

        assertEquals(expected, response);
    }



}

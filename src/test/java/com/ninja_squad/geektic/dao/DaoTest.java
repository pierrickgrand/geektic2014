package com.ninja_squad.geektic.dao;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.Dao.GeekDao;
import com.ninja_squad.geektic.model.Geek;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.List;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

/**
 * Created by pierrick on 22/06/2015.
 */
public class DaoTest extends BaseDaoTest {
    @Autowired
    private GeekDao userDao;

    @Before
    public void populateDatabase() {
        Operation operation =
                UtilitaireTest.INSERT_REFERENCE_DATA;

        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }

    @Test
    public void TESTgetAllGeeks() {


        Geek user1 = new Geek(98,"GRAND","Pierrick","pierrick26","05021994","HOMME",21);
        Geek user2 = new Geek(99,"DURAND","Remi","remi","remi25","HOMME",25);
        List<Geek> expected = new ArrayList<Geek>();
        expected.add(user1);
        expected.add(user2);
        userDao.getAllGeeks();
        Assert.that(userDao.getAllGeeks().contains(user1),"");
    }
}

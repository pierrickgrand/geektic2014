package com.ninja_squad.geektic.dao;
import com.ninja_squad.dbsetup.operation.Operation;
import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

/**
 * Created by pierrick on 23/06/2015.
 */
public class UtilitaireTest {
    //public static final Operation DELETE_ALL = deleteAllFrom("USER");


    public static final Operation INSERT_REFERENCE_DATA =
            sequenceOf(insertInto("PUBLIC.GEEKS")
                            .columns("ID_USER", "NOM", "PRENOM", "MDP","LOGIN","AGE","SEXE")
                            .values(98,"GRAND","Pierrick","pierrick26","05021994","HOMME",21)
                            .values(99,"DURAND","Remi","remi","remi25","HOMME",25)
                            .build());
}




package com.ninja_squad.geektic.dao;
import com.ninja_squad.dbsetup.operation.Operation;
import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

/**
 * Created by pierrick on 23/06/2015.
 */
public class UtilitaireTest {

        // AVANT DE REPEUPLER LA BASE , ON VIDE LES TROIS TABLES POUR NE PAS CREER DE DOUBLONS
    public static final Operation DELETE_ALL = deleteAllFrom("GEEKS","INTERET","RELATION_USER_INTERET");
        // ENSUITE ON REPLEUPLE LES TROIS TABLES DE LA BASE DE DONNEE
    public static final Operation INSERT_REFERENCE_DATA =
            sequenceOf(
                    insertInto("GEEKS") // REMPLISSAGE DE LA TABLE GEEK
                            .columns("ID_USER", "NOM", "PRENOM", "MDP", "LOGIN", "AGE", "SEXE", "NB_VUES")

                            .values("0", "NOM_USER1", "PRENOM_USER1", "MDP_USER1", "LOGIN_USER1", "18", "HOMME", "0")
                            .values("1", "NOM_USER2", "PRENOM_USER2", "MDP_USER2", "LOGIN_USER2", "18", "FEMME", "0")
                            .values("2", "NOM_USER3", "PRENOM_USER3", "MDP_USER3", "LOGIN_USER3", "18", "HOMME", "0")
                            .values("3", "NOM_USER4", "PRENOM_USER4", "MDP_USER4", "LOGIN_USER4", "18", "HOMME", "0")

                            .build(),

                    insertInto("INTERET") // REMPLISSAGE DE LA TABLE INTERET

                            .columns("ID_INTERET", "NOM_INTERET", "DESCRIPTION")
                            .values("0", "Csharp", "langage orienté objet proprietaire microsoft")
                            .values("1", "C++", "langage orienté objet trés utilisé pour le jeux videos")
                            .values("2", "Java", "langage orienté objet")
                            .values("3", "JEE", "langage orienté objet pour les applis web")
                            .values("4", "Assembleur", "langage bas niveau")
                            .values("5", "SQL", "langage de base de donnée")
                            .build(),

                    insertInto("RELATION_USER_INTERET") // REMPLISSAGE DE LA TABLE RELATION_USER_INTERET
                            .columns("ROWID", "ID_GEEK", "ID_INTERET")
                            .values("0", "0", "0")
                            .values("1", "0", "1")
                            .values("2", "1", "1")
                            .values("3", "1", "2")
                            .values("4", "1", "3")
                            .values("5", "2", "3")
                            .values("6", "3", "3")
                            .values("7", "3", "5")
                            .values("8", "4", "1")
                            .values("9", "5", "5")
                            .build()
            );




}




package com.ninja_squad.geektic.model;
import java.util.Set;
import javax.persistence.*;
/**
 * Created by pierrick on 22/06/2015.
 */
@Entity
@SequenceGenerator(name = "ID", sequenceName = "geek_seq")
@Table(name = "GEEK")
public class GEEK {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
    @Column(name = "ID")
        private int ID;
    @Column(name = "NOM")
        private String NOM;
    @Column(name = "PRENOM")
        private String PRENOM;
    @Column(name = "LOGIN")
        private String LOGIN;
    @Column(name = "MDP")
        private String MDP;
    @Column(name = "SEXE")
        private String SEXE;
    @Column(name = "AGE")
        private int AGE;

        public void GEEK(String NOM,String PRENOM,String LOGIN,String MDP,String SEXE,int AGE){
            this.NOM= NOM;
            this.PRENOM= PRENOM;
            this.LOGIN=LOGIN;
            this.MDP=MDP;
            this.SEXE=SEXE;
            this.AGE=AGE;
        }
    /**-----------------------------------____________________--------------------------------------**/
    /************************************[ GETTERS ET SETTERS ]***************************************/

    @ManyToMany(mappedBy = "GEEK")
    private Set<INTERET> interet;

    public Set<INTERET> getInterets() {
        return interet;
    }

    public void setInterets(Set<INTERET> interets) {
        this.interet = interets;
    }


    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public void setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public String getMDP() {
        return MDP;
    }

    public void setMDP(String MDP) {
        this.MDP = MDP;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public String getSEXE() {
        return SEXE;
    }

    public void setSEXE(String SEXE) {
        this.SEXE = SEXE;
    }
}

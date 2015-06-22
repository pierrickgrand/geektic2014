package com.ninja_squad.geektic.model;
import java.util.Set;
import javax.lang.model.element.Name;
import javax.persistence.*;
/**
 * Created by pierrick on 22/06/2015.
 */
@Entity
@SequenceGenerator(name = "id", sequenceName = "geek_seq")
@Table(name = "GEEKS")
public class Geek {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    @Column(name = "ID_USER")
        private int id;
    @Column(name = "NOM")
        private String nom;
    @Column(name = "PRENOM")
        private String prenom;
    @Column(name = "LOGIN")
        private String login;
    @Column(name = "MDP")
        private String mdp;
    @Column(name = "SEXE")
        private String sexe;
    @Column(name = "AGE")
        private int age;

    public Geek() {
    }
        public Geek(String nom,String prenom,String login,String mdp,String sexe,int age){
            this.nom= nom;
            this.prenom= prenom;
            this.login=login;
            this.mdp=mdp;
            this.sexe=sexe;
            this.age=age;
        }
    /**-----------------------------------____________________--------------------------------------**/
    /************************************[ GETTERS ET SETTERS ]***************************************/

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "RELATION_USER_INTERET",joinColumns = @JoinColumn(name = "ID_GEEK"),
            inverseJoinColumns = @JoinColumn(name="ID_INTERET"))
    private Set<Interet> interets;

    public Set<Interet> getInterets() {

        return interets;
    }

    public void setInterets(Set<Interet> interets) {
        this.interets = interets;
    }


    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNOM() {
        return nom;
    }

    public void setNOM(String nom) {
        this.nom = nom;
    }

    public String getPRENOM() {

        return prenom;
    }

    public void setPRENOM(String prenom) {

        this.prenom = prenom;
    }

    public String getLOGIN() {

        return login;
    }

    public void setLOGIN(String login) {

        this.login = login;
    }

    public String getMDP() {

        return mdp;
    }

    public void setMDP(String mdp) {
        this.mdp = mdp;
    }

    public int getAGE() {

        return age;
    }

    public void setAGE(int age) {

        this.age = age;
    }

    public String getSEXE() {

        return sexe;
    }

    public void setSEXE(String sexe) {

        this.sexe = sexe;
    }
}

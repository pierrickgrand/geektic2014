package com.ninja_squad.geektic.model;
import java.util.Set;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "ID", sequenceName = "interet_seq")
@Table(name = "INTERET")
public class INTERET {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
    @Column(name = "ID")
    private int ID;
    @Column(name = "NOM")
    public String NOM;
    @Column(name = "DESCRIPTION")
    public String DESCRIPTION;
    public INTERET(String NOM,String DESCRIPTION){
        this.NOM= NOM;
        this.DESCRIPTION=DESCRIPTION;
    }
    @ManyToMany(mappedBy = "INTERET")
    private Set<GEEK> Geek;


    public INTERET(int id, String nom, String description) {
        this.ID = id;
        this.NOM = nom;
        this.DESCRIPTION = description;
    }
    /**-----------------------------------____________________--------------------------------------**/
    /************************************[ GETTERS ET SETTERS ]***************************************/

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getNom() {
        return NOM;
    }

    public void setNom(String nom) {
        this.NOM = nom;
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public void setDescription(String description) {
        this.DESCRIPTION = description;
    }


}

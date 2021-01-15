/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Djiby DIOP
 */
public abstract class Personne {
    protected int id;
    protected String nomComplet;
    protected String type;
    protected String admin;
    protected String mdp;

    public Personne() {
    }

    public Personne(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public Personne(int id, String nomComplet) {
        this.id = id;
        this.nomComplet = nomComplet;
    }

    public Personne(String admin, String mdp) {
        this.admin = admin;
        this.mdp = mdp;
    }

    public Personne(int id, String admin, String mdp) {
        this.id = id;
        this.admin = admin;
        this.mdp = mdp;
    }
            
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nomComplet=" + nomComplet + '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    
    
    
}

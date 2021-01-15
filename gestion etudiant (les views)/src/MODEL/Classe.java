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
public class Classe {
    private int id;
    private String libellé;
    private String nomComplet;
    private int nbre;
    
    public Classe() {
    }

    public Classe(int id, String libellé, String nomComplet, int nbre) {
        this.id = id;
        this.libellé = libellé;
        this.nomComplet = nomComplet;
        this.nbre = nbre;
    }

    public Classe(String libellé, String nomComplet, int nbre) {
        this.libellé = libellé;
        this.nomComplet = nomComplet;
        this.nbre = nbre;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibellé() {
        return libellé;
    }

    public void setLibellé(String libellé) {
        this.libellé = libellé;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public int getNbre() {
        return nbre;
    }

    public void setNbre(int nbre) {
        this.nbre = nbre;
    }

    @Override
    public String toString() {
        return "Classe{" + "id=" + id + ", libell\u00e9=" + libellé + ", nomComplet=" + nomComplet + ", nbre=" + nbre + '}';
    }

    
   

    
    
    
    
}

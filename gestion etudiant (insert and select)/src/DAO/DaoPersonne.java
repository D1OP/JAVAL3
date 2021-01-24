/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Admin;
import MODEL.Classe;
import MODEL.Convert;
import MODEL.Etudiant;
import MODEL.Personne;
import MODEL.Professeur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Djiby DIOP
 */
public class DaoPersonne implements IDao <Personne> {
    private final String SQL_SELECT_BY_CLASSE="select p.id,nom_complet,tuteur,classe_id,libelle,nbre_etudiant from personne p,classe cl where classe_id=? and cl.id=p.classe_id";    
    private final String SQL_INSERT_ETUDIANT="INSERT INTO `personne` ( `type`, `nom_complet`, `tuteur`,`classe_id`) VALUES (?,?,?,?);";
    private final String SQL_INSERT_PROFESSEUR="INSERT INTO `personne` (`type`, `nom_complet`, `grade`,`modules`,`matricule`) VALUES (?,?,?,?,?);";
    private final String SQL_SELECT_PROFESSEUR="select * from personne where matricule=?";
    private final String SQL_SELECT_ALL_PROFESSEUR="select * from personne where type='Professeur'";
    private final String SQL_SELECT_CONNECT="select * from personne where login=? and pwd=?";
    
    
    
    private DaoMysql mysql;
    
    public DaoPersonne (){
        mysql=new DaoMysql();
    }

    public List<Etudiant> findByClasse(Classe classe){
        List<Etudiant> lEtudiants=new ArrayList<>();
        
         try {    
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_BY_CLASSE);
            System.out.println(classe.getId());
            mysql.getPs().setInt(1,classe.getId());
            
            ResultSet rs=mysql.executeSelect();
       
            while(rs.next()){
                Etudiant etu=new Etudiant();
                etu.setNomComplet(rs.getString("nom_complet"));
                etu.setId(rs.getInt("id"));
                etu.setTuteur(rs.getString("tuteur"));
                
                Classe cl=new Classe();
                cl.setId(rs.getInt("classe_id"));
                cl.setLibelle(rs.getString("libelle"));
                cl.setNbre(rs.getInt("nbre_etudiant"));
                etu.setCl(cl);  
                lEtudiants.add(etu);
            }
            
   
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                mysql.closeConnexion();
            }
                 
        return lEtudiants;
    }
    
    
    public int insertEtudiant(Etudiant etu){
         int nbreLigne=0;
         
         try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_INSERT_ETUDIANT);                    
            mysql.getPs().setString(1,etu.getType());
            mysql.getPs().setString(2,etu.getNomComplet());
            mysql.getPs().setString(3,etu.getTuteur());
            mysql.getPs().setInt(4,etu.getCl().getId());
            
            nbreLigne=mysql.executeMisAJour();                                                            
        } catch (SQLException ex) {
           System.out.println("Erreur");
        }finally{
           mysql.closeConnexion();
       }                                  
        return nbreLigne;
    }
    
    public int insertProfesseur(Professeur pers){
         int nbreLigne=0;
         
         try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_INSERT_PROFESSEUR);                    
            mysql.getPs().setString(1,pers.getNomComplet());
            mysql.getPs().setString(3,pers.getGrade());
            mysql.getPs().setString(7,pers.getMatricule());
            mysql.getPs().setString(4,Convert.listToString(pers.getModules()));
            
            nbreLigne=mysql.executeMisAJour();                                                
            
        } catch (SQLException ex) {
           System.out.println("Erreur d'insertion");
        }finally{
           mysql.closeConnexion();
       }                                  
    return nbreLigne;
     }       
     
     public Professeur findProfesseurByMatricule(String matricule){
        Professeur professeur=null;
        
        try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_PROFESSEUR);
            mysql.getPs().setString(1,matricule);
            
            ResultSet rs=mysql.executeSelect();
        
            if(rs.next()){   
                professeur=new Professeur();
                professeur.setGrade(rs.getString("grade"));
                professeur.setId(rs.getInt("id"));
                professeur.setMatricule(rs.getString("matricule"));
                professeur.setNomComplet(rs.getString("nom_complet"));                
                professeur.setModules(Convert.stringToList(rs.getString("modules")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return professeur;        
    }     
    
     public List<Professeur> findProfesseur(Personne personne){
        List<Professeur> lProfesseurs=new ArrayList<>();
        
        try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_ALL_PROFESSEUR); 
            mysql.getPs().setString(1,((Professeur)personne).getType());
            ResultSet rs=mysql.executeSelect();
            
            while(rs.next()){
                Professeur prof=new Professeur();
                prof.setId(rs.getInt("id"));
                prof.setNomComplet(rs.getString("libelle"));
                prof.setGrade(rs.getString("grade"));
                prof.setMatricule(rs.getString("matricule"));
                prof.setModules(Convert.stringToList(rs.getString("modules")));
                lProfesseurs.add(prof);
            }
        } catch (SQLException ex) {          
        }finally{
            mysql.closeConnexion();
        }         
        return lProfesseurs;
    } 
     
     
    public Personne findUserConect( String login, String pwd){
        Personne pers=null;
         try {
        mysql.ouvrirConnexionBD();
        mysql.preparerRequete(SQL_SELECT_CONNECT);
        mysql.getPs().setString(1,login);
              
            mysql.getPs().setString(2,pwd);
        
        ResultSet rs=mysql.executeSelect();
        if(rs.next()){
                if(rs.getString("type").trim().compareTo("Etudiant")==0){
                pers=new Etudiant(rs.getString("tuteur"));                
            }else{
                if(rs.getString("type").trim().compareTo("Professeur")==0){
                pers=new Professeur();
                ((Professeur)pers).setMatricule(rs.getString("matricule"));
                ((Professeur)pers).setGrade(rs.getString("grade"));                
                ((Professeur)pers).setModules(Convert.stringToList(rs.getString("modules")));
                
            }else{
                  pers=new Admin();
                }
            }                
                pers.setId(rs.getInt("id"));
                pers.setNomComplet(rs.getString("nom_complet"));
                pers.setLogin(rs.getString("login"));
                pers.setPwd(rs.getString("pwd"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }                
        return pers;
    }

    @Override
    public int insert(Personne ojet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
     
}

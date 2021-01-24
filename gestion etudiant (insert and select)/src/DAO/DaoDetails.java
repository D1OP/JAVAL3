/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Classe;
import MODEL.Convert;
import MODEL.Details;
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
public class DaoDetails implements IDao <Details> {
    private final String SQL_INSERT="INSERT INTO `details` (`classe_id`, `professeur_id`, `modules`, `annee`) VALUES (?,?,?,?);";      
    private final String SQL_SELECT_MODULES="select * from details where professeur_id=? and classe_id=?";
    private final String SQL_SELECT_ALL_MODULES="select modules from details"; 

    private DaoMysql mysql;
    
    public DaoDetails (){
        mysql=new DaoMysql();
    }
    
    
    @Override
    public int insert(Details details){
         int nbreLigne=0;  
                  
        try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_INSERT); 
            mysql.getPs().setInt(1,details.getCl().getId());
            mysql.getPs().setInt(2,details.getProfesseur().getId());
            mysql.getPs().setString(3,Convert.listToString(details.getModules()));
            mysql.getPs().setString(4,details.getAnnee());
                 
            nbreLigne=mysql.executeMisAJour();
                           
        } catch (SQLException ex) {
            System.out.println("Erreur");
        }finally{
            mysql.closeConnexion();
        }    
        return nbreLigne;
     }    
  
    
 public List<Details>findModules(Details details){
     List<Details> lModules=new ArrayList();            
     try{
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_MODULES);
            mysql.getPs().setInt(1, details.getCl().getId());
            mysql.getPs().setInt(2, details.getProfesseur().getId());            
            ResultSet rs=mysql.executeSelect();
                while(rs.next()){
                    details.setModules(Convert.stringToList(rs.getString("modules")));
                    Classe cl=new Classe();
                    cl.setId(rs.getInt("classe_id"));
                    cl.setLibelle(rs.getString("libelle"));
                    cl.setNbre(rs.getInt("nbre"));
                    Professeur prof=new Professeur();
                    prof.setId(rs.getInt("classe_id"));
                    prof.setNomComplet(rs.getString("nomComplet"));
                    prof.setGrade(rs.getString("grade"));
                    prof.setMatricule(rs.getString("matricule"));                    
                    details.setProfesseur(prof);
                    details.setCl(cl);
                    lModules.add(details);                    
                }                        
        } catch (SQLException ex) {
           System.out.println("Erreur");
        }finally{
            mysql.closeConnexion();
        }       
     return lModules;
    }
 
    public List<Details>findAllModules(){
         List<Details> lModules=new ArrayList<>();
         try{
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_ALL_MODULES);
            ResultSet rs=mysql.executeSelect();
                
                while(rs.next()){
                    Details details=new Details();
                    details.setModules(Convert.stringToList(rs.getString("modules")));
                    lModules.add(details);
                }
                
           }catch (SQLException ex) {
               System.out.println("Erreur");
           }finally{
           mysql.closeConnexion();
       }      
       return lModules;      
    }
    
    
}



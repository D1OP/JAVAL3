/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Classe;
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
            mysql.getPs().setObject(1,details.getModules());
            mysql.getPs().setObject(2,details.getCl());
            mysql.getPs().setObject(3,details.getProfesseur());
            mysql.getPs().setString(4,details.getAnnee());
                 
            nbreLigne=mysql.executeMisAJour();
                           
        } catch (SQLException ex) {
            System.out.println("Erreur d'insertion");
        }finally{
            mysql.closeConnexion();
        }
    
        return nbreLigne;
     }    
  
    
    
 public List<String>findModules(Details details){
     List<String> lModules=new ArrayList();
     
        try {    
     
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_MODULES);
            
            ResultSet rs=mysql.executeSelect();
                                
            while(rs.next()){
                details.setProfesseur((Professeur) rs.getObject("professeur_id"));
                details.setCl((Classe) rs.getObject("classe_id"));             
                //lModules.add(modules);
            }
        } catch (SQLException ex) {
           System.out.println("Erreur lors de la selection");
        }finally{
            mysql.closeConnexion();
        }
       
     return lModules;
 }
}



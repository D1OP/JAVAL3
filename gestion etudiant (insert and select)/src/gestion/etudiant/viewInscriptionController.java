/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.etudiant;

import METIER.Service;
import MODEL.Classe;
import MODEL.Etudiant;
import MODEL.Personne;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Djiby DIOP
 */
public class viewInscriptionController implements Initializable {

    private Service metier;
    ObservableList<Classe> obClasse;
    
   
    @FXML
    private TextField textTuteur;
    @FXML
    private TextField textNomPrenom;
    @FXML
    private ComboBox<Classe> cmbClasse;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       metier=new Service();
       obClasse=FXCollections.observableArrayList(metier.listerClasse());
       cmbClasse.setItems(obClasse);
    }    


    @FXML
    private void handleCreerPersonne(ActionEvent event) {
        String nom=textNomPrenom.getText();
        String tuteur=textTuteur.getText();
        Classe cl=this.cmbClasse.getValue();
        Etudiant etu=new Etudiant(nom,tuteur);
        etu.setCl(cl);
        if (metier.creerEtudiant(etu)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Etudiant créé avec succès");
            alert.setTitle("Information");
            alert.show();
            obClasse.add(cl);
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur d'insertion");
            alert.setTitle("Erreur");
            alert.show();   
        }
    }
}

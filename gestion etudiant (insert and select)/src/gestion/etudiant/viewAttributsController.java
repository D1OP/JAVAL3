/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.etudiant;

import METIER.Service;
import MODEL.Classe;
import MODEL.Details;
import MODEL.Professeur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Djiby DIOP
 */
public class viewAttributsController implements Initializable {

    private Service METIER;
    ObservableList <Professeur> obProfesseurs;
    ObservableList <Classe> obClasses;
    ObservableList <Details> obModules;
    
    @FXML
    private TextField textMatricule;
    @FXML
    private TextField textNomPrenom;
    @FXML
    private TextField textGrade;
    @FXML
    private ComboBox<Classe> cmbClasses;
    @FXML
    private ComboBox<Details> cmbModules;
    @FXML
    private TableView<Details> tblvModules;
    @FXML
    private TableColumn<Details, String> tblcLibelle;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        METIER=new Service();
        obModules=FXCollections.observableArrayList(METIER.listerModules());
        obClasses=FXCollections.observableArrayList(METIER.listerClasse());
        cmbClasses.setItems(obClasses);
        cmbModules.setItems(obModules);
        
    }

    @FXML
    private void handleCreerProfesseur(ActionEvent event) {
        String matricule=textMatricule.getText();
        String nomComplet=textNomPrenom.getText();
        String grade=textGrade.getText();
        Details details=this.cmbModules.getValue();
        Classe classe=this.cmbClasses.getValue();
        Professeur professeur=new Professeur(matricule,grade,nomComplet);
        details.setProfesseur(professeur);
        if (METIER.creerProfesseur(professeur)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Professeur ajoutée avec succès");
            alert.setTitle("Information");
            alert.show();
            obModules.add(details);
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur d'insertion");
            alert.setTitle("Erreur");
            alert.show();   
        }
        
    }
}

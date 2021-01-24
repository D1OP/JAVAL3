/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.etudiant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

/**
 * FXML Controller class
 *
 * @author Djiby DIOP
 */
public class MenuController implements Initializable {

    @FXML
    private AnchorPane AnchorContent;
   // @FXML
    //private Button handleLoadViewClasse;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadView("viewClasses");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleLoadViewClasse(ActionEvent event) throws IOException {
          loadView("viewClasses");
    }
    @FXML
    private void handleLoadViewInscription(ActionEvent event) throws IOException {
        loadView("viewInscription");
    }
    @FXML
    private void handleLoadViewProfesseurs(ActionEvent event) throws IOException {
        loadView("viewProfesseurs");
    }
    @FXML
    private void handleLoadViewAttributsClasse(ActionEvent event) throws IOException {
        loadView("viewAttributsClasse");
    }
    
    public void loadView(String view) throws IOException{
        AnchorPane viewLoding=FXMLLoader.load(getClass().getResource(view+".fxml"));
        AnchorContent.getChildren().add(viewLoding);
    }

    @FXML
    private void handleDeconnexion(ActionEvent event) throws IOException {
        AnchorContent.getScene().getWindow().hide();
         AnchorPane view= FXMLLoader.load(getClass().getResource("viewMenu.fxml"));
            Scene scene= new Scene(view);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.showAndWait();
    }
    
}

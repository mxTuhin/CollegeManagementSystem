/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author tuhin
 */


public class StudentRegistrationController implements Initializable {
    
    
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/loginfo";
    
    
    @FXML
    private JFXTextField fname;

    @FXML
    private JFXTextField country;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField cellnum;

    @FXML
    private JFXTextField gender;

    @FXML
    private JFXTextField fathersName;

    @FXML
    private JFXTextField mothersOccupation;

    @FXML
    private JFXTextField fathersCellnum;

    @FXML
    private JFXTextField birth;

    @FXML
    private JFXTextField sscGPA;

    @FXML
    private JFXTextField religion;

    @FXML
    private JFXTextField bloodGroup;

    @FXML
    private JFXTextField nationality;

    @FXML
    private JFXTextField mothersCellnum;

    @FXML
    private JFXTextField sscPassYear;

    @FXML
    private JFXTextField district;

    @FXML
    private JFXTextField poBirth;

    @FXML
    private JFXTextField mothersName;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField maritalStatus;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField fathersOccupation;
    

            
    
    
    @FXML
    void Submit(ActionEvent event) throws IOException, SQLException {

        System.out.println(id.getText());
        System.out.println(fname.getText());
        System.out.println(birth.getText());
        
        
        
        Connection conn=null;
            conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");                      
            Statement stmt=(Statement) conn.createStatement();
            System.out.println("Connected2");
            String insert="";
            if(id.getText().isEmpty()| fname.getText().isEmpty() | birth.getText().isEmpty() | maritalStatus.getText().isEmpty() | nationality.getText().isEmpty() | address.getText().isEmpty() | cellnum.getText().isEmpty() | district.getText().isEmpty() | country.getText().isEmpty() | gender.getText().isEmpty() | poBirth.getText().isEmpty() | religion.getText().isEmpty() | email.getText().isEmpty() | bloodGroup.getText().isEmpty() | sscPassYear.getText().isEmpty() | sscGPA.getText().isEmpty() | fathersName.getText().isEmpty() | fathersOccupation.getText().isEmpty() | fathersCellnum.getText().isEmpty() | mothersName.getText().isEmpty() | mothersOccupation.getText().isEmpty() | mothersCellnum.getText().isEmpty() ){
            System.out.println("No ENtry");
            Notifications.create()
                    .title("Warning")
                    .text("You are missing input").darkStyle()
                    .showWarning();
            }
            else
            {
                insert="INSERT INTO studentinformation (id ,fname, birth, maritalStatus, nationality, address, cellnum, district, country, gender, poBirth, religion, email, bloodGroup, sscPassYear, sscGPA, fathersName, fathersOccupation, fathersCellnum, mothersName, mothersOccupation, mothersCellnum) VALUES (' "+id.getText()+"', '"+fname.getText()+"','"+birth.getText()+"', '"+maritalStatus.getText()+"', ' "+nationality.getText()+"', '"+address.getText()+"','"+cellnum.getText()+"', '"+district.getText()+"', ' "+country.getText()+"', '"+gender.getText()+"','"+poBirth.getText()+"', '"+religion.getText()+"', ' "+email.getText()+"', '"+bloodGroup.getText()+"','"+sscPassYear.getText()+"', '"+sscGPA.getText()+"', ' "+fathersName.getText()+"', '"+fathersOccupation.getText()+"','"+fathersCellnum.getText()+"', '"+mothersName.getText()+"','"+mothersOccupation.getText()+"', '"+mothersCellnum.getText()+"' ) ";
                stmt.executeUpdate(insert);
                Notifications.create()
                    .title("Congratulations")
                    .text("You have registered Info for "+id.getText()+" and his name is"+fname.getText()).darkStyle()
                    .showInformation();
                
            }
            
            
            System.out.println(insert);
            
            id.setText("");
            fname.setText("");
            birth.setText("");
            maritalStatus.setText("");
            nationality.setText("");
            address.setText("");
            cellnum.setText("");
            district.setText("");
            country.setText("");
            gender.setText("");
            poBirth.setText("");
            religion.setText("");
            email.setText("");
            bloodGroup.setText("");
            sscPassYear.setText("");
            sscGPA.setText("");
            fathersName.setText("");
            fathersOccupation.setText("");
            fathersCellnum.setText("");
            mothersName.setText("");
            mothersOccupation.setText("");
            mothersCellnum.setText("");
            
            
            
        
        
    }
    
    
    

    @FXML
    void ReturnToApplicationPage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Designs/ApplicationPage.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Students Registration");
    }
    
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

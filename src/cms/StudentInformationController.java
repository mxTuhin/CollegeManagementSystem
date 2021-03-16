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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 *
 * @author tuhin
 */



public class StudentInformationController implements Initializable{
    
        
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
    private JFXTextField searchID;
    
    
    
    @FXML
    void ReturnToApplicationPage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Designs/ApplicationPage.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Students Registration");
    }
            
    
    
    @FXML
    void Submit(ActionEvent event) throws IOException, SQLException {

            System.out.println(searchID.getText());
        
        
        
        Connection conn=null;
            conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");                      
            Statement stmt=(Statement) conn.createStatement();
            System.out.println("Connected2");
            String callBack="";
//            
            String SEARCHID=searchID.getText();
            Statement statement = conn.createStatement();
            System.out.println(statement);
               callBack="select * from studentinformation  where id" + " = " + SEARCHID + "";
            ResultSet resultSet = statement.executeQuery(callBack);
           System.out.println(resultSet);
        
            if(resultSet.next()){

            System.out.println(callBack);
             System.out.println(resultSet);
            
            id.setText(resultSet.getString("id"));
            fname.setText(resultSet.getString("fname"));
            birth.setText(resultSet.getString("birth"));
            maritalStatus.setText(resultSet.getString("maritalStatus"));
            nationality.setText(resultSet.getString("nation"
                    + "ality"));
            address.setText(resultSet.getString("address"));
            cellnum.setText(resultSet.getString("cellnum"));
            district.setText(resultSet.getString("district"));
            country.setText(resultSet.getString("country"));
            gender.setText(resultSet.getString("gender"));
            poBirth.setText(resultSet.getString("poBirth"));
            religion.setText(resultSet.getString("religion"));
            email.setText(resultSet.getString("email"));
            bloodGroup.setText(resultSet.getString("bloodGroup"));
            sscPassYear.setText(resultSet.getString("sscPassYear"));
            sscGPA.setText(resultSet.getString("sscGPA"));
            fathersName.setText(resultSet.getString("fathersName"));
            fathersOccupation.setText(resultSet.getString("fathersOccupation"));
            fathersCellnum.setText(resultSet.getString("fathersCellnum"));
            mothersName.setText(resultSet.getString("mothersName"));
            mothersOccupation.setText(resultSet.getString("mothersOccupation"));
            mothersCellnum.setText(resultSet.getString("mothersCellnum"));
                
               
            }
           
        
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

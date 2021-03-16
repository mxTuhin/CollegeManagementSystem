/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms;

import com.jfoenix.controls.JFXPasswordField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * FXML Controller class
 *
 * @author tuhin
 */


public class SignUpValidatorController implements Initializable {
    
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/loginfo";
    
    @FXML
    private JFXPasswordField validator_password;
    
    @FXML
    void SignIn(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("Designs/SignIn.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Sign In");
    }

    @FXML
    void Validate(ActionEvent event) throws IOException, SQLException {
          
     String username, password;
     
     
     password = validator_password.getText();
     if(password.equals("test") | password.equals("grant"))
     {
         Parent root = FXMLLoader.load(getClass().getResource("Designs/SignUp.fxml"));
//
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Sign Up");
            
            Notifications.create()
                    .title("Congratulations")
                    .text("Password Validated").darkStyle()
                    .showInformation();
     }
     
     else{
         Notifications.create()
                    .title("Warning")
                    .text("Your password is wrong").darkStyle()
                    .showWarning();
     }
     
     

//        username = _username.getText();
//        password = validator_password.getText();
//        Connection conn=null;
//        conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
//
//        Statement statement = conn.createStatement();
//
//        ResultSet resultSet = statement.executeQuery("select * from accesspass where pass = '" + password + "'");
//
//        if (resultSet.next()) {
//            Parent root = FXMLLoader.load(getClass().getResource("Designs/SignUp.fxml"));
//
//            Node node = (Node) event.getSource();
//
//            Stage stage = (Stage) node.getScene().getWindow();
//
//            stage.setScene(new Scene(root));
//            stage.setTitle("Sign Up");
//            
//            Notifications.create()
//                    .title("Congratulations")
//                    .text("Password Validated").darkStyle()
//                    .showInformation();
//    }
//        else
//        {
//            Notifications.create()
//                    .title("Warning")
//                    .text("Your password is wrong").darkStyle()
//                    .showWarning();
//        }
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

    /**
     * Initializes the controller class.
     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
//    
//}


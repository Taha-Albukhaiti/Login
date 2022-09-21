package com.example.login;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private ImageView shieldimageView;
    @FXML
    private Button closeButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField coniformPasswordField;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private Label firstnameLabel;
    @FXML
    private Label lastnameLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label emailLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File fiel = new File("/Users/tahaalbukhaiti/Downloads/MD22/images/logo.png");
        Image setImage = new Image(fiel.toURI().toString());
        shieldimageView.setImage(setImage);
    }

    public void closeButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        //Platform.exit();
    }

    public void registerButtonOnAction(ActionEvent event) {
        boolean ok = registerUserValid();
        if (ok) registrationMessageLabel.setText("User has been registered successfully!");
    }

    public boolean registerUserValid() {
        boolean ok = false;
        if (!firstnameTextField.getText().isEmpty()) {
            if (!lastnameTextField.getText().isEmpty()) {
                if (!emailLabel.getText().isEmpty() && emailLabel.getText().contains("@")) {
                    if (setPasswordField.getText().equals(coniformPasswordField.getText()) && !setPasswordField.getText().isEmpty() && !confirmPasswordLabel.getText().isEmpty()) {
                        confirmPasswordLabel.setText("You are set");
                        ok = true;
                    } else {
                        confirmPasswordLabel.setText("Password does not match!");
                    }
                } else {
                    emailLabel.setText("Invalid");
                }
            } else {
                lastnameLabel.setText("Lastname can't by empty");
            }
        } else {
            firstnameLabel.setText("s empty");
        }
        return ok;
    }
}

package controller.landingPage;

import com.jfoenix.controls.JFXButton;
import holder.PaneHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class AdminLandingPgController {
    @FXML
    private JFXButton btnBookRegistration;

    @FXML
    private JFXButton btnCustomerRegistration;

    @FXML
    void btnBookRegistrationOnAction(ActionEvent event) {
        try {
            URL resource=getClass().getResource("/view/BookRegistration.fxml");
            Parent brRoot=FXMLLoader.load(resource);

            PaneHolder.getPane().getChildren().clear();
            PaneHolder.getPane().getChildren().add(brRoot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnCustomerRegistrationOnAction(ActionEvent event) {
        try {
            URL resource=getClass().getResource("/view/CustomerRegistration.fxml");
            Parent crRoot=FXMLLoader.load(resource);

            PaneHolder.getPane().getChildren().clear();
            PaneHolder.getPane().getChildren().add(crRoot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

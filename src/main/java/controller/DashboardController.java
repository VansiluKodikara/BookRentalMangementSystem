package controller;

import com.jfoenix.controls.JFXButton;
import controller.landingPage.AdminLandingPgController;
import holder.PaneHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

import static holder.PaneHolder.getPane;
import static holder.PaneHolder.getPane;

public class DashboardController {

    @FXML
    private JFXButton btnAdmin;

    @FXML
    private JFXButton btnStaff;

    @FXML
    private AnchorPane dashRoot;

    public void initialize(){
        PaneHolder.setDashRoot(dashRoot);

        System.out.println("Dashboard initialized and Pane Saved!");
    }

    @FXML
    void btnAdminOnAction(ActionEvent event) {

        try {
            URL resource = this.getClass().getResource("/view/AdminLandingPage.fxml");

            assert resource==null;

            Parent parent = FXMLLoader.load(resource);

            PaneHolder.getPane().getChildren().clear();
            PaneHolder.getPane().getChildren().add(parent);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnStaffOnAction(ActionEvent event) {

    }
}

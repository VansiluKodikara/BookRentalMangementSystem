package org.example.controller.customer;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CustomerRegistrationController {

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXComboBox cmbTitle;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtTelNumber;

    @FXML
    private TableColumn colCustId;

    @FXML
    private TableColumn colCustTitle;

    @FXML
    private TableColumn colCustName;

    @FXML
    private TableColumn colCustTelNum;

    @FXML
    private TableView tblCustomer;


    @FXML
     void btnCustBackOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void btnCustRegisterOnAction(ActionEvent actionEvent) {

    }

    private void setTextToValues(){

    }

    public void loadTable() {

    }

    public void btnBackOnAction(ActionEvent actionEvent) {
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
    }
}

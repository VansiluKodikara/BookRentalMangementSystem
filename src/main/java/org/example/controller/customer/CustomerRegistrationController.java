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
import org.example.model.CustomerRegistration;
import org.example.tm.CustomerTM;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CustomerRegistrationController implements Initializable{

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

    public void initialize(URL url, ResourceBundle resourceBundle){

        colCustId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustTitle.setCellValueFactory( new PropertyValueFactory<>("title"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustTelNum.setCellValueFactory(new PropertyValueFactory<>("telNumber"));

        cmbTitle.setItems(
                FXCollections.observableArrayList(
                        Arrays.asList("Mr", "Mrs", "Miss")
                )
        );

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            assert t1 !=null;

            CustomerTM customerTM=(CustomerTM) t1;

            CustomerRegistration customerRegistration=new CustomerRegistration(
                    customerTM.getId(),
                    customerTM.getTitle(),
                    customerTM.getName(),
                    customerTM.getTelNumber()
            );


        });
    }



    public void btnCustBackOnAction(ActionEvent actionEvent) {
    }

    public void btnCustRegisterOnAction(ActionEvent actionEvent) {

    }
}

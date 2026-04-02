package org.example.controller.customer;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.model.tm.CustomerTM;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRegistrationController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnReload;

    @FXML
    private Button btnSearch;

    @FXML
    private JFXComboBox<?> cmbTitle;

    @FXML
    private TableColumn colCustId;

    @FXML
    private TableColumn colCustName;

    @FXML
    private TableColumn colCustTelNum;

    @FXML
    private TableColumn colCustTitle;

    @FXML
    private TableView tblCustomer;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtTelNumber;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        loadTable();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    public void loadTable(){

        colCustId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustTelNum.setCellValueFactory(new PropertyValueFactory<>("telNumber"));
        try {
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookrent", "root", "12345");

            Statement statement=connection.createStatement();

            ResultSet resultSet=statement.executeQuery("SELECT * FROM customer");

            ArrayList<CustomerTM> customerTM=new ArrayList<>();

            while (resultSet.next()){
                CustomerTM tm=new CustomerTM(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                customerTM.add(tm);
            }

            ObservableList<CustomerTM> observableList=FXCollections.observableArrayList(customerTM);

            tblCustomer.setItems(observableList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

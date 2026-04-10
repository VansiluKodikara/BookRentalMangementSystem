package org.example.controller.customer;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.db.DBConnection;
import org.example.model.CustomerRegistration;
import org.example.model.tm.CustomerTM;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CustomerRegistrationController implements Initializable {

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
    private JFXComboBox<String> cmbTitle;

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

        String id = txtId.getText();
        String title = cmbTitle.getValue().toString();
        String name = txtName.getText();
        String telNum = txtTelNumber.getText();

        CustomerRegistration customerRegistration = new CustomerRegistration(id, title,name,telNum);

        System.out.println(customerRegistration);

        try {

            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement psTm = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?)");

            psTm.setString(1, customerRegistration.getId());
            psTm.setString(2, customerRegistration.getTitle());
            psTm.setString(3, customerRegistration.getName());
            psTm.setString(4, customerRegistration.getTelNum());

            if(psTm.executeUpdate()>0){
                new Alert(Alert.AlertType.INFORMATION, "Customer has been registered successfully").show();
                //loadTable();
            }else {
                new Alert(Alert.AlertType.ERROR, "Customer has not been registered successfully").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement psTm = connection.prepareStatement("SELECT * FROM customer WHERE CustID = ?");

            psTm.setString(1, txtId.getText());

            ResultSet resultSet = psTm.executeQuery();

            resultSet.next();

            CustomerRegistration customerRegistration = new CustomerRegistration(
                     resultSet.getString(1),
                     resultSet.getString(2),
                     resultSet.getString(3),
                     resultSet.getString(4)
            );

            setTextToValues(customerRegistration);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void setTextToValues(CustomerRegistration customerRegistration){
        txtId.setText(customerRegistration.getId());
        cmbTitle.setValue(customerRegistration.getTitle());
        txtName.setText(customerRegistration.getName());
        txtTelNumber.setText(customerRegistration.getTelNum());
    }

    public void loadTable(){

        colCustId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustTelNum.setCellValueFactory(new PropertyValueFactory<>("telNum"));
        try {
            Connection connection = DBConnection.getInstance().getConnection();

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        cmbTitle.setItems(FXCollections.observableArrayList(
                Arrays.asList("Mr", "Mrs", "Miss")
        ));

        loadTable();
    }
}

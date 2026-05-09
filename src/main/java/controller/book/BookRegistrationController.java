package controller.book;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import holder.PaneHolder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BookRegistration;
import model.tm.BookTM;
import model.tm.CustomerTM;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookRegistrationController implements Initializable {

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXButton btnReload;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private TableColumn<?, ?> colBookAuthor;

    @FXML
    private TableColumn<?, ?> colBookGenre;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBookPrice;

    @FXML
    private TableColumn<?, ?> colBookTitle;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtGenre;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    private TableView tblBooks;

    @FXML
    void btnBackOnAction(ActionEvent event) {

        try {
            URL resource = this.getClass().getResource("/view/AdminLandingPage.fxml");

            assert resource==null;

            Parent back = FXMLLoader.load(resource);

            PaneHolder.getPane().getChildren().clear();
            PaneHolder.getPane().getChildren().add(back);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

        String id = txtId.getText();
        String title = txtTitle.getText();
        String author = txtAuthor.getText();
        String genre = txtGenre.getText();
        String price = txtPrice.getText();

        BookRegistration bookRegistration = new BookRegistration(id, title, author, genre, price);

        System.out.println(bookRegistration);

        try {

            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement psTm = connection.prepareStatement("INSERT INTO books VALUES (?,?,?,?,?)");

            psTm.setString(1, bookRegistration.getId());
            psTm.setString(2, bookRegistration.getTitle());
            psTm.setString(3, bookRegistration.getAuthor());
            psTm.setString(4, bookRegistration.getGenre());
            psTm.setString(5, bookRegistration.getPrice());

            if(psTm.executeUpdate()>0){
                new Alert(Alert.AlertType.INFORMATION, "Book has been registered successfully").show();
                //loadTable();
            }else {
                new Alert(Alert.AlertType.ERROR, "Book has not been registered successfully").show();
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    public void loadTable(){
        colBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colBookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colBookGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colBookPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

            ArrayList<BookTM> bookTM = new ArrayList<>();

            while (resultSet.next()){
                BookTM tm=new BookTM(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
                bookTM.add(tm);
            }

            ObservableList<BookTM> observableList= FXCollections.observableArrayList(bookTM);

            tblBooks.setItems(observableList);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        loadTable();
    }
}

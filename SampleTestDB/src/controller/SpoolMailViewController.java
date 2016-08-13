package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import pojoclasses.SpoolMail;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import libconnection.DBConnection;

/***
 * 
 * 
 * @author sumitksi
 *
 */
public class SpoolMailViewController extends Application implements
		Initializable {

	@FXML
	private TextField eventid;
	@FXML
	private TableView<SpoolMail> tableView;
	@FXML
	private TableColumn<SpoolMail, Integer> column_eid;
	@FXML
	private TableColumn<SpoolMail, Integer> column_state;

	private static Connection conn;
	private static Statement stmt;
	private ResultSet rs;
	private PreparedStatement prepStmt;
	private ObservableList<SpoolMail> data;
	private String strSql;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		// assert tableView != null :
		// "fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";
		// eid.setCellValueFactory(new PropertyValueFactory<SpoolMail,
		// Integer>("eid"));
		// state.setCellValueFactory(new PropertyValueFactory<SpoolMail,
		// Integer>("state"));
		strSql = "select eid,state from out_messages.spool_mail where eid = 0";

		try {
			DBConnection.setIpAddress("10.201.148.67");
			DBConnection.setPortAddress("7706");
			DBConnection.setDatabaseName("out_messages");
			DBConnection.setUserid("root");
			DBConnection.setPassword("em7admin");
			DBConnection.setUrl();
			conn = DBConnection.getConn();
			// buildData();
			data = FXCollections.observableArrayList();
			rs = conn.createStatement().executeQuery(strSql);
			while (rs.next()) {
				data.add(new SpoolMail(rs.getInt("eid"), rs.getInt("status")));
			}

			column_eid
					.setCellValueFactory(new PropertyValueFactory<SpoolMail, Integer>(
							"eid"));
			column_state
					.setCellValueFactory(new PropertyValueFactory<SpoolMail, Integer>(
							"state"));

			tableView.setItems(null);
			tableView.setItems(data);

		} catch (ClassNotFoundException ce) {

		} catch (SQLException ce) {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getResource(
					"/mailguidesign/SpoolMailView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Application.launch(SpoolMailViewController.class,args);
	}
}

/*
 * 
 * public class SpoolMailViewController extends Application { // SpoolMailVIew.
 * // @FXML private TableView<Person> tableView;
 * 
 * @FXML private TextField eventid;
 * 
 * @FXML private Button getSpoolData;
 * 
 * public SpoolMailViewController() { FXMLLoader fxmlLoader = new
 * FXMLLoader(getClass().getResource( "/mailguidesign/SpoolMailView.fxml"));
 * fxmlLoader.setRoot(this); fxmlLoader.setController(this);
 * 
 * try { fxmlLoader.load(); } catch (IOException exception) { throw new
 * RuntimeException(exception); } }
 * 
 * @FXML protected void addPerson(ActionEvent event) { // ObservableList<Person>
 * data = tableView.getItems(); // data.add(new Person(firstNameField.getText(),
 * // lastNameField.getText(),emailField.getText())); eventid.setText("123456");
 * 
 * }
 * 
 * @Override public void start(Stage primaryStage) throws Exception { try {
 * Parent root = FXMLLoader.load(getClass().getResource(
 * "/mailguidesign/SpoolMailView.fxml")); Scene scene = new Scene(root);
 * scene.getStylesheets().add(
 * getClass().getResource("application.css").toExternalForm());
 * primaryStage.setScene(scene); primaryStage.show();
 * 
 * } catch (Exception e) { e.printStackTrace(); } }
 * 
 * }
 */
package Controller;

import java.awt.TextField;
import java.io.IOException;
import java.sql.Connection;

import Model.ConnectionFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLTelaLoginController {

	@FXML
	private PasswordField txtPassword;
	@FXML
	private TextField txtUser;
	@FXML
	private Button btnEntrar;
	@FXML
	private Button btnFechar;
	@FXML
	private Label labelLogin;

	@FXML
	void fechar(ActionEvent event) {
		Stage stage = (Stage) btnFechar.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void entrar() throws IOException {
//		if (txtUser.getName().equals("admin") && txtPassword.getText().equals("admin")) {
//			labelLogin.setText("Login realizado com sucesso");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaConfig.fxml"));
			Pane root = loader.load();
			FXMLTelaConfigController controll = (FXMLTelaConfigController) loader.getController();
			((Stage) btnEntrar.getScene().getWindow()).hide();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Biblioteca Universitária");				
			stage.setScene(scene);			
			stage.show();
			
			
//		} else {
//			labelLogin.setText("Usuario ou senhar errados");
		
	}
}
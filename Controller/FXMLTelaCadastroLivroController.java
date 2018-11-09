package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLTelaCadastroLivroController {
	

    @FXML private TextField txtNomeLivro;
    @FXML private TextField txtID;
    @FXML private TextField txtAutor;
    @FXML private TextField txtEditora;
    @FXML private DatePicker datePublicacao;
    @FXML private TextField txtEdicao;
    @FXML private TextField txtISBN;
    @FXML private ChoiceBox<?> cbStatus;
    @FXML private Button btnSalvar;
    @FXML private Button btnCancelar;
	
    
  //CANCELAR
    @FXML
    public void cancelar() throws IOException {
    	/*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaConfig.fxml"));
        Pane root = loader.load();
        
        FXMLTelaConfigController controller = (FXMLTelaConfigController) loader.getController();
        ((Stage) btnCancelar.getScene().getWindow()).hide();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setResizable(false);      
        stage.setTitle("Cadastro de Livro");
        stage.setScene(scene);
        stage.show();
        */
    	
    	Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();
    }
    
    //SALVAR 
    public void salvar() {
    	
    }

	
}

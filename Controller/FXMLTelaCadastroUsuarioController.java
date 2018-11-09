package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLTelaCadastroUsuarioController{
	
		@FXML private TextField tctCadAluno;
	    @FXML private TextField txtRG;
	    @FXML private TextField txtCPF;
	    @FXML private TextField txtEmail;
	    @FXML private TextField TxtTelefone;
	    @FXML private TextField txtRua;
	    @FXML private TextField txtNumero;
	    @FXML private TextField txtCEP;
	    @FXML private ComboBox<?> cbCidade;
	    @FXML private TextField txtBairro;
	    @FXML private Button btnSalvar;
	    @FXML private Button btnCancelar;
		
	    //CANCELAR
	    @FXML
	    public void cancelar() throws IOException {

	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaConfig.fxml"));
	        Pane root = loader.load();
	        FXMLTelaConfigController controller = (FXMLTelaConfigController) loader.getController();
	        ((Stage) btnCancelar.getScene().getWindow()).hide();
	        Scene scene = new Scene(root);
	        Stage stage = new Stage();
	        stage.setResizable(false);      
	        stage.setTitle("Cadastro de Aluno");
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	    //SALVAR 
	   public void salvar() {
	    	
	    }
}

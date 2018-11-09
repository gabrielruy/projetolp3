package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLTelaBuscarLivroController {

	
	  	@FXML private TableView<?> grdBuscarLivro;
	    @FXML private Button bntEditar;
	    @FXML private TextField txtBuscarLivro;
	    @FXML private Button bntExcluir;
	    @FXML private RadioButton rbAtivar;
	    @FXML private RadioButton rbblocked;
	    @FXML private Button bntBuscar;
	    @FXML private Button bntAtulaizar;
	    @FXML private Button bntSalvar;
	    @FXML private Button bntCancelar;
		
	    
	  //CANCELAR
	    @FXML
	    public void cancelar() throws IOException {

	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaConfig.fxml"));
	        Pane root = loader.load();
	        FXMLTelaConfigController controller = (FXMLTelaConfigController) loader.getController();
	        ((Stage) bntCancelar.getScene().getWindow()).hide();
	        Scene scene = new Scene(root);
	        Stage stage = new Stage();
	        stage.setResizable(false);      
	        stage.setTitle("Buscar livro");
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	  //EDITAR  
	    @FXML
	    void editar() {
	    	
	    }
	    
	    //SALVAR 
	    @FXML
	    void salvar() {
	    	
	    }
	  //BUSCAR 
	    @FXML
	    void buscar() {
	    	
	    }
	  //ATUALIZAR
	    @FXML
	    void atualizar() {
	    	
	    }
	  //EXCLUIR
	    @FXML
	    void excluir() {
	    	
	    }
}

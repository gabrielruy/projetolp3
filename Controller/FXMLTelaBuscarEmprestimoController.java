package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLTelaBuscarEmprestimoController  {
	
	 	@FXML private Button btnBuscarEmp;
	    @FXML private TextField txtBuscarEmp;
	    @FXML private TableView<?> grdBuscarEmp;
	    @FXML private Button btnDevolverLivro;
	    @FXML private Button btnRelQuitacao;
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
	        stage.setTitle("Buscar emprestimo");
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	  //SALVAR 
	    public void salvar() {
	    	
	    }
	  //BUSCAR 
	    public void buscar() {
	    	
	    }
	  //ATUALIZAR
	    public void quitacao() {
	    	
	    }
	  //DEVOLVER
	    public void devolverlivro() {
	    	
	    }
	
}

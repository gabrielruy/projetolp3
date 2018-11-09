package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLTelaReservaController {
	
	
		@FXML private TableView<?> grdReservaLivro;
	    @FXML private Button bntBuscar;
	    @FXML private TextField txtRaAluno;
	    @FXML private DatePicker dateReserva;
	    @FXML private Button bntEfeturReserva;
	    @FXML private Button btnCancelar;
	    @FXML private TextField txtBuscarLivroReserva;
		
	    
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
	        stage.setTitle("Reserva de livros");
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	    //RESERVA
	    public void reserva() {
	    	
	    }
	  //BUSCAR 
	    public void buscar() {
	    	
	    }
	

}

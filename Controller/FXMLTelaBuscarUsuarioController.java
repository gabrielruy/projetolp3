package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLTelaBuscarUsuarioController implements Initializable {
    
	@FXML
	private Button bntEditar;
	@FXML
	private TextField txtBuscarAluno;
	@FXML
	private Button btnExcluir;
	@FXML
	private Button btnBuscar;
	@FXML
	private Button btnAtualizar;
	@FXML
	private Button btnSalvar;
	@FXML
	private Button btnCancelar;

	@FXML
	private TableView<?> grdBuscarAluno;   
	@FXML
	private TableColumn<?, ?> clmnId;
	@FXML
	private TableColumn<?, ?> clmnNome;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	// Cancelar
	@FXML
	public void cancelar() throws IOException {
		fechaStage();
	}

	// Editar
	public void editar() throws IOException {

	}

	// Salvar
	public void salvar() throws IOException {

	}

	// Buscar
	public void buscar() throws IOException {

	}

	// Atualizar
	public void atualizar() throws IOException {

	}

	// Excluir
	public void excluir() throws IOException {

	}

	private void populaTabela() {

	}

	private void fechaStage() {
		Stage stage = (Stage) txtBuscarAluno.getScene().getWindow();
		stage.close();
	}
}

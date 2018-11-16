package Controller;

import java.io.IOException;

import Model.InfoAlert;
import Model.Livro;
import Model.LivroDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLTelaCadastroLivroController {

	@FXML
    private TextField txtNomeLivro;
    @FXML
    private TextField txtAutor;
    @FXML
    private TextField txtEditora;
    @FXML
    private DatePicker datePublicacao;
    @FXML
    private TextField txtEdicao;
    @FXML
    private TextField txtISBN;
    @FXML
    private ComboBox<String> cbStatus;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnCancelar;
    
    private LivroDAO dao = new LivroDAO();
    
    @FXML
	public void initialize() {
		ObservableList<String> list = listarStatus();
		cbStatus.getItems().removeAll(cbStatus.getItems());
		cbStatus.setItems(list);
	}

	// Cancelar
	@FXML
	public void cancelar() throws IOException {
		fechaStage();
	}

	// Salvar
	@FXML
	public void salvar() {
		Boolean estaPreenchido = estaPreenchido();
		
		if(estaPreenchido) {
			Livro l = getDTO();
			
			if(dao.create(l)) {
				InfoAlert.infoAlert("Livro cadastrado", "Livro cadastrado com sucesso");				
				fechaStage();
			} else
				InfoAlert.errorAlert("Erro ao cadastrar", "Não foi possível cadastrar o Livro");
		} else
			InfoAlert.errorAlert("Erro ao cadastrar", "Preencha todos os campos");
	}
	
	private Livro getDTO() {
		Livro l = new Livro();
		
		l.setNome(txtNomeLivro.getText());
		l.setAutor(txtAutor.getText());
		l.setPublicacao(datePublicacao.getValue());
		l.setEditora(txtEditora.getText());
		l.setNroEdicao(Integer.parseInt(txtEdicao.getText()));
		l.setIsbn(txtISBN.getText());
		l.setSituacao(cbStatus.getValue().toString());
		
		return l;
	}
	
	private Boolean estaPreenchido() {
		if (!txtNomeLivro.getText().isEmpty() &&
				!txtAutor.getText().isEmpty() &&
				!txtEditora.getText().isEmpty() &&
				!txtEdicao.getText().isEmpty() &&
				!txtEdicao.getText().isEmpty() &&
				!txtISBN.getText().isEmpty() &&
				!cbStatus.getSelectionModel().isEmpty() &&
				!datePublicacao.getValue().equals(null))
			return true;
		
		return false;
	}
	
	private ObservableList<String> listarStatus() {
		ObservableList<String> list = 
				FXCollections.observableArrayList("Indisponível", "Disponível");
		return list;
	}
	
	private void fechaStage() {	
		Stage stage = (Stage) txtNomeLivro.getScene().getWindow();
		stage.close();
	}

}

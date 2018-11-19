package Controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Aluno;
import Model.AlunoDAO;
import Model.InfoAlert;
import Model.Livro;
import Model.LivroDAO;
import Model.Reserva;
import Model.ReservaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLTelaReservaController implements Initializable {

    @FXML
    private Button bntBuscar;
    @FXML
    private TextField txtRaAluno;
    @FXML
    private DatePicker dateReserva;
    @FXML
    private Button btnEfetuarReserva;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtBuscarLivroReserva;
    @FXML
    private Button btnVoltar;
    @FXML
    private Label lblNomeAluno;
    
    @FXML
    private TableView<Livro> grdReservaLivro;
    @FXML
    private TableColumn<Livro, Integer> clmnId;
    @FXML
    private TableColumn<Livro, String> clmnNome;
    @FXML
    private TableColumn<Livro, String> clmnAutor;
    @FXML
    private TableColumn<Livro, Integer> clmnEdicao;
    
    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {       	
       	try {
   			populaTabela(null);
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}
    }
    
    // Voltar
    @FXML
    private void voltar() {
    	fechaStage();
    }
    
    // Cancelar
    @FXML
    private void cancelar() throws SQLException {
    	txtRaAluno.clear();
    	lblNomeAluno.setText("");
    	txtBuscarLivroReserva.clear();
    	dateReserva.getEditor().clear();
    	
    	populaTabela(null);
    }
    
    // Buscar
    @FXML
    private void buscar() throws SQLException {
    	if(txtBuscarLivroReserva.getText().trim().isEmpty()) {
			populaTabela(null);
		} else {
			populaTabela(txtBuscarLivroReserva.getText());
		}
    }
    
    // Efetuar reserva
    @FXML
    private void reserva() throws NumberFormatException, SQLException {
    	Boolean estaPreenchido = estaPreenchido();
    	Livro l = grdReservaLivro.getSelectionModel().getSelectedItem();
    	
		if(estaPreenchido) {
			if (l != null) {
				Reserva r = getDTO();
				if(ReservaDAO.create(r) && LivroDAO.update(r.getLivro())) {
					InfoAlert.infoAlert("Reserva cadastrada", "Reserva cadastrada com sucesso");				
					fechaStage();
				} else
					InfoAlert.errorAlert("Erro ao cadastrar", "Não foi possível cadastrar a reserva");
			}				
			else
				InfoAlert.errorAlert("Erro ao cadastrar", "Selecione um livro para efetuar a reserva.");
		} else
			InfoAlert.errorAlert("Erro ao cadastrar", "Preencha todos os campos");
    }

    // Enter no TextField do RA
    @FXML
    private void raInserido() throws NumberFormatException, SQLException {
    	Aluno a = AlunoDAO.readWithRa(Integer.parseInt(txtRaAluno.getText()));
    	if (a != null) {
    		lblNomeAluno.setText(a.getNome().toString());
    	} else {
    		InfoAlert.infoAlert("RA inválido", "O RA inserido não é válido.");
    		txtRaAluno.clear();
    		lblNomeAluno.setText("");
    	}
    }  
    
    private void populaTabela(String filtro) throws SQLException {
		ObservableList<Livro> list = FXCollections.observableArrayList();
		
		grdReservaLivro.getItems().removeAll(grdReservaLivro.getItems());
		
		if	(filtro == null) {
			try {
				list = LivroDAO.listBySituation("Disponível", null);
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} else {
			list = LivroDAO.listBySituation("Disponível", txtBuscarLivroReserva.getText().toString());
		}
				
		clmnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		clmnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		clmnAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		clmnEdicao.setCellValueFactory(new PropertyValueFactory<>("nroEdicao"));
		
		grdReservaLivro.setItems(list);
	}
    
    private Boolean estaPreenchido() {
		if (!txtRaAluno.getText().isEmpty() &&
				dateReserva.getValue() != null)
			return true;
		
		return false;
	}
    
    private Reserva getDTO() throws NumberFormatException, SQLException {
    	Reserva r = new Reserva();
    	
    	Aluno a = AlunoDAO.readWithRa(Integer.parseInt(txtRaAluno.getText()));
    	Livro l = grdReservaLivro.getSelectionModel().getSelectedItem();
    	
    	l.setSituacao("Reservado");
    	
    	r.setAluno(a);
    	r.setLivro(l);
    	r.setDataRetirada(dateReserva.getValue());
    	r.setTipo("Reserva"); // Neste controller estamos cadastrando reserva
    	r.setAtivo(true); // Controla qual reserva está em vigor
    	
    	return r;
    }

    private void fechaStage() {
    	Stage stage = (Stage) txtBuscarLivroReserva.getScene().getWindow();
		stage.close();
    }
}

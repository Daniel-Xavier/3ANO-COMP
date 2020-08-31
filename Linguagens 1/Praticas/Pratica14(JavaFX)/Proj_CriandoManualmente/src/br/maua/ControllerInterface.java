package br.maua;

import br.maua.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ControllerInterface {
    @FXML
    private Label lblSaida;
    @FXML
    private Button btnBotao1, btnSomar, btnPreview, btnCadastrar;
    @FXML
    private TextField txtEntrada, txtNumero1, txtNumero2, txtSenha, txtUrl, txtNome;
    @FXML
    private ImageView imgFoto;

    @FXML
    public void exibirNome(){
        String nome = txtEntrada.getText();
        lblSaida.setText("Saida: " + nome);
    }
    @FXML
    public void Somar(){
        int numero1 = Integer.parseInt(txtNumero1.getText());
        int numero2 = Integer.parseInt(txtNumero2.getText());
        lblSaida.setText("Saida: " + (numero1 + numero2));
    }
    @FXML
    public void cadastrar(){
        Usuario usuario = new Usuario(txtNome.getText(), txtSenha.getText(), txtUrl.getText());
        txtNome.clear();
        txtSenha.clear();
        txtUrl.clear();
        System.out.println("Usuario Cadastrado: " + usuario);
    }
    @FXML
    public void previewFoto(){
        try {
            String url = txtUrl.getText();
            Image image = new Image(url);
            imgFoto.setImage(image);
        }
        catch (IllegalArgumentException exception) {
            txtUrl.clear();
            txtUrl.requestFocus();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("URl Incorreta");
            alert.setHeaderText("Erro!");
            // Para a execução do restante do código do método até ele ser concluído (Alerta)
            alert.showAndWait();
            //Deixa o restante do código ser executado
            //alert.show();
            //System.out.println("Erro!");
        }
    }
}

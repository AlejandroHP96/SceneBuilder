package dad;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

    // model

    // TODO pendiente de modelo

    private StringProperty accion = new SimpleStringProperty();

    // view
    @FXML
    private VBox view;

    @FXML
    private ComboBox<String> accionCombo;

    @FXML
    private Button pulsameButton;

    public Controller() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
        loader.setController(this);
        loader.load();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        accionCombo.getItems().addAll("Saludar", "Despedir");
        accionCombo.getSelectionModel().selectFirst();

        accion.bind(accionCombo.getSelectionModel().selectedItemProperty());


    }

    public VBox getView() {
        return view;
    }

    @FXML
    private void onClick(ActionEvent e) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Accion");

        switch (accion.get()) {
            case "Saludar":
                alert.setHeaderText("Hola");
                break;
            case "Despedir":
                alert.setHeaderText("Adios");
                break;
        
            default:
                break;
        }
    }

}

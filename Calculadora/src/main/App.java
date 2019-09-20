package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Controllers.CalculadoraController;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Calculadora"); //Titulo pantalla inicial
        FXMLLoader obtenerCalculadora = new FXMLLoader(getClass().getResource("Resources/Calculadora.fxml")); //Obtener datos de pantalla

        Pane paneCalculadora = obtenerCalculadora.load(); //Obtenemos los datos

        CalculadoraController claseCalculadora = obtenerCalculadora.getController();

        claseCalculadora.setPrevStage(primaryStage);

        Scene escenaSesion = new Scene(paneCalculadora);
        primaryStage.setResizable(false); //Mover el tamaño
        primaryStage.setScene(escenaSesion); //Subimos la escena
        primaryStage.show(); //Mostramos la pantalla
    }

    public static void main(String[] args) {
        launch(args);

    }
}


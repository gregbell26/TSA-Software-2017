package GUI;
/**
 * //TODO FILE DECRITPTION
 * @music My Chemical Romance
 * @author Gregory Bell
 * @company TriHard Studios
 * @version  1.0.0
 *
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class MainWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){//this creates everything!! Special thanks to google!
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
            AnchorPane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

            primaryStage.getIcons().add(new Image("GUI/Logo.png"));
            primaryStage.setTitle("Encryption");
            primaryStage.show();

        }catch (Exception e){
            System.out.println("ERROR: The GUI failed to generate");
            System.out.println("The error returned is: " + e);

        }

    }









}

package GUI;
/**
 * This is the main file for the GUI. It will draw the GUI from the FXML file then it will hand control over the controller
 *
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
    /**
     * Main. It is overriding the main funct in the backend tester and the is overridden by the Popup Window.
     * @param args does nothing. This program doesn't use arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }


    /**
     * This is the function that is called and does everything.
     * It is called from the main with the tha statement launch. It is overridding an interface method that is in the class
     * Application which this extends
     * @param primaryStage is the main window.
     */
    @Override
    public void start(Stage primaryStage){//this creates everything!! Special thanks to google!
        try {//FXMLLoader, getIcons can throw errors if they don't find the files needed
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FMXL/MainWindow.fxml"));//creates the FXML loader
            AnchorPane root = fxmlLoader.load();//Creates the window. We are using an AnchorPane as the main window.
            Scene scene = new Scene(root);//Creates the setter
            primaryStage.setScene(scene);//Sets the windows content

            primaryStage.getIcons().add(new Image("GUI/Icons/Logo.png"));//Applies the window's icon. It is desinged by Sam Salbia.
            primaryStage.setTitle("Encryption");//Sets Window title.
            primaryStage.show();//Sets as visable

        }catch (Exception ex){
            System.err.println("ERROR: The GUI failed to generate");
            System.err.println("The error returned is: " + ex);

        }

    }









}

package application;
	
import javafx.application.Application;  
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root= FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		primaryStage.setTitle("Калькулятор");
		primaryStage.setScene(new Scene(root, 800, 400));
		primaryStage.setResizable(false);
	    primaryStage.show();
		 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

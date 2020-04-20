import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//Dialog is not resized correctly
			ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
			Dialog<String> dialog = new Dialog<>();
			dialog.setWidth(300);
			dialog.setHeight(300);
			dialog.getDialogPane().getButtonTypes().add(loginButtonType);
			dialog.getDialogPane().setPrefWidth(300);
			dialog.getDialogPane().setPrefHeight(300);
			boolean disabled = false; // computed based on content of text fields, for example
			dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);
			
			dialog.showAndWait()
			.filter(response -> response.equals("OK"))
			.ifPresent(response -> System.out.println("Dialog was used."));
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

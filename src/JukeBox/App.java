package JukeBox;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	@Override public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("fxml/JukeBoxApp.fxml"));

		Scene scene = new Scene(root, 1440, 710);

		stage.setTitle("JukeBox");
		stage.setScene(scene);
		stage.show();
	}

}
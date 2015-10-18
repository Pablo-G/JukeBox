package JukeBox;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class App extends Application{

	@Override public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("fxml/fxmlApp1.fxml"));

		Scene scene = new Scene(root, 1440, 710);

		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
		/*
		String path = new File((System.getProperty("user.home")+"\\FD.mp3").replace('\\','/')).toURI().toString();

		System.out.println(path);
		Media m = new Media(path);
		System.out.println(m.getMetadata());
		MediaPlayer mp = new MediaPlayer(m);
		mp.setVolume(1);
		mp.play();
		*/
	}

}
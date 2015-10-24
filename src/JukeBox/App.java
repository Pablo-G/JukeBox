/**
 *Clase <code>App</code>.
 *Clase que carga el XML y ejecuta la vista.
 *@author <a href="mailto:pablo.t645@hotmail.com">Pablo G.</a>
 *@version 1.0
 *Copyright 2015 Pablo G.
 */
package JukeBox;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class App extends Application{

    /**
     *<code>start</code> Método que carga el XML y genera la ventana de la vista.
     *@param stage tipo <code>Stage</code>: Stage.
     */
	@Override public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("fxml/JukeBoxApp.fxml"));

		Scene scene = new Scene(root, 1440, 710);

		stage.setTitle("JukeBox");
		stage.getIcons().add(new Image("file:./lib/assets/ICON.png"));
		stage.setScene(scene);
		stage.show();
	}

}
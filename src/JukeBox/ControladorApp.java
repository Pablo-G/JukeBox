package JukeBox;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import java.io.File;
import javafx.scene.text.Text;

public class ControladorApp{
	
	ControladorBD cBD;
	File bandaIm;
	File artisIm;
	File albumIm;
	File canciAr;

	public ControladorApp() throws Exception{
		cBD = new ControladorBD();
		bandaIm = null;
		artisIm = null;
		albumIm = null;
		canciAr = null;
	}

	@FXML protected void setbandaIm(ActionEvent event){
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG", "*.jpeg"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG", "*.png"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("SVG", "*.svg"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("GIF", "*.gif"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("BMP", "*.bmp"));
		fc.setTitle("Abrir | Ilustración de Banda...");
		bandaIm = fc.showOpenDialog(null);
	}

	@FXML protected void setartisIm(ActionEvent event){
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG", "*.jpeg"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG", "*.png"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("SVG", "*.svg"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("GIF", "*.gif"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("BMP", "*.bmp"));
		fc.setTitle("Abrir | Ilustración de Artista...");
		artisIm = fc.showOpenDialog(null);
	}

	@FXML protected void setalbumIm(ActionEvent event){
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG", "*.jpeg"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG", "*.png"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("SVG", "*.svg"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("GIF", "*.gif"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("BMP", "*.bmp"));
		fc.setTitle("Abrir | Ilustración de Álbum...");
		albumIm = fc.showOpenDialog(null);
	}

	@FXML protected void setcanciAr(ActionEvent event){
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("MP3", "*.mp3"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("MP4", "*.mp4"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("WAV", "*.wav"));
		fc.setTitle("Abrir | Archivo de Música...");
		canciAr = fc.showOpenDialog(null);
	}

	@FXML private TextField agBaNom;
    @FXML private TextArea agBaBio;
    @FXML private Text agBaErr;

    @FXML protected void agregaBanda(ActionEvent event) throws Exception{
    	if (bandaIm == null || agBaNom.getText().equals("") || agBaBio.getText().equals("")) {
    		agBaErr.setText("Debes llenar todos los campos!");
    		return;
    	}
    	cBD.agregaBanda(agBaNom.getText(), bandaIm.toString(), agBaBio.getText());
    	agBaNom.setText("");
    	agBaBio.setText("");
    	bandaIm = null;
    	agBaErr.setText("");
    }

    @FXML private TextField agCaNom;
    @FXML private TextField agCaAlb;
    @FXML private TextField agCaInt;
    @FXML private TextField agCaCom;
    @FXML private TextField agCaGen;
    @FXML private TextField agCaAno;
    @FXML private TextField agCaCal;
    @FXML private TextField agCaPis;
    @FXML private TextField agCaDis;

    @FXML protected void agregaCancion(ActionEvent event){

	    agCaNom.setText("Dime Ven");
	    agCaAlb.setText("Best Of");
	    agCaInt.setText("Motel");
	    agCaCom.setText("Juan");
	    agCaGen.setText("Pop");
	    agCaAno.setText("2010");
	    agCaCal.setText("5");
	    agCaPis.setText("1");
	    agCaDis.setText("1");

    }

}
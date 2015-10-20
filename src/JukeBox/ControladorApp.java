package JukeBox;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.CheckBox;
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

    @FXML protected void agregaBanda(ActionEvent event){
    	if (bandaIm == null || agBaNom.getText().equals("") || agBaBio.getText().equals("")) {
    		agBaErr.setText("Debes llenar todos los campos!");
    		return;
    	}
    	try{
    		cBD.agregaBanda(agBaNom.getText(), bandaIm.toString(), agBaBio.getText());
    	}catch(Exception e){
    		agBaErr.setText(e.getMessage());
    		agBaNom.setText("");
    		agBaBio.setText("");
    		bandaIm = null;
    		return;
    	}
    	agBaNom.setText("");
    	agBaBio.setText("");
    	bandaIm = null;
    	agBaErr.setText("");
    }

	@FXML private TextField agArNom;
	@FXML private TextField agArInt;
    @FXML private TextArea agArBio;
    @FXML private Text agArErr;

    @FXML protected void agregaArtista(ActionEvent event){
    	if (artisIm == null || agArNom.getText().equals("") || agArInt.getText().equals("") || agArBio.getText().equals("")) {
    		agArErr.setText("Debes llenar todos los campos!");
    		return;
    	}
    	try{
    		cBD.agregaArtista(agArNom.getText(), artisIm.toString(), agArBio.getText(), agArInt.getText());
    	}catch(Exception e){
    		agArErr.setText(e.getMessage());
    		agArNom.setText("");
    		agArInt.setText("");
    		agArBio.setText("");
    		artisIm = null;
    		return;
    	}
    	agArNom.setText("");
    	agArInt.setText("");
    	agArBio.setText("");
    	artisIm = null;
    	agArErr.setText("");
    }

	@FXML private TextField agAlNom;
	@FXML private TextField agAlInt;
	@FXML private TextField agAlAno;
	@FXML private TextField agAlDis;
    @FXML private CheckBox agAlArt;
    @FXML private Text agAlErr;

    @FXML protected void agregaAlbum(ActionEvent event){
    	if (albumIm == null || agAlNom.getText().equals("") || agAlInt.getText().equals("") || agAlAno.getText().equals("") || agAlDis.getText().equals("")) {
    		agAlErr.setText("Debes llenar todos los campos!");
    		return;
    	}
    	try{
    		cBD.agregaAlbum(agAlNom.getText(), albumIm.toString(), agAlInt.getText(), Integer.parseInt(agAlAno.getText()), Integer.parseInt(agAlDis.getText()), agAlArt.isSelected());
    	}catch(Exception e){
    		agAlErr.setText(e.getMessage());
    		agAlNom.setText("");
    		agAlInt.setText("");
    		agAlAno.setText("");
    		agAlDis.setText("");
    		agAlArt.setSelected(false);
    		albumIm = null;
    		return;
    	}
    	agAlNom.setText("");
    	agAlInt.setText("");
    	agAlAno.setText("");
    	agAlDis.setText("");
    	agAlArt.setSelected(false);
    	albumIm = null;
    	agAlErr.setText("");
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
    @FXML private CheckBox agCaSen;
	@FXML private Text agCaErr;

    @FXML protected void agregaCancion(ActionEvent event){
    	if (canciAr == null || agCaNom.getText().equals("") || agCaAlb.getText().equals("") || 
    		agCaInt.getText().equals("") || agCaCom.getText().equals("") ||
    		agCaGen.getText().equals("") || agCaAno.getText().equals("") ||
    		agCaCal.getText().equals("") || agCaPis.getText().equals("") ||
    		agCaDis.getText().equals("")) {
    		agCaErr.setText("Debes llenar todos los campos!");
    		return;
    	}
    	try{
    		cBD.agregaCancion(agCaNom.getText(), agCaAlb.getText(), 
    						  agCaInt.getText(), agCaCom.getText(),
    						  agCaGen.getText(), Integer.parseInt(agCaAno.getText()),
    						  Integer.parseInt(agCaCal.getText()), Integer.parseInt(agCaPis.getText()),
    						  Integer.parseInt(agCaDis.getText()), agCaSen.isSelected(), canciAr.toString());
    	}catch(Exception e){
    		agCaErr.setText(e.getMessage());
    		agCaNom.setText("");
    		agCaAlb.setText("");
    		agCaInt.setText("");
    		agCaCom.setText("");
    		agCaGen.setText("");
    		agCaAno.setText("");
    		agCaCal.setText("");
    		agCaPis.setText("");
    		agCaDis.setText("");
    		agCaSen.setSelected(false);
    		canciAr = null;
    		return;
    	}
    	agCaNom.setText("");
    	agCaAlb.setText("");
   		agCaInt.setText("");
    	agCaCom.setText("");
    	agCaGen.setText("");
   		agCaAno.setText("");
    	agCaCal.setText("");
    	agCaPis.setText("");
   		agCaDis.setText("");
    	agCaSen.setSelected(false);
    	canciAr = null;
    	agCaErr.setText("");
    }

}
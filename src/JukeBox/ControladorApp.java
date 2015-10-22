package JukeBox;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.CheckBox;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import java.io.File;
import javafx.scene.text.Text;
import java.util.LinkedList;
import javafx.collections.*;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class ControladorApp{
	
	ControladorBD cBD;
    ControladorMP cMP;
    LinkedList<Object> colaRep;
	File bandaIm;
	File artisIm;
	File albumIm;
	File canciAr;

	public ControladorApp() throws Exception{
		cBD = new ControladorBD();
        colaRep = new LinkedList<Object>();
        colaRep.add(new Cancion("Ángel", "JB", "JB", 2009, 5, 1, "Hoy", "Local", "C:/Users/Pablo/JukeBox/Proyecto/Elefante/Elefante Exitos/02 Angel.mp3", "Elefante", "Exitos", 0, 0));
        colaRep.add(new Album("Exitos", "Elefante", 2009, 1, 10, "C:/Users/Pablo/JukeBox/Proyecto/Elefante_-_Grandes_Éxitos.jpg"));
        colaRep.add(new Banda("Elefante", "C:/Users/Pablo/JukeBox/Proyecto/Elefante.jpg", "MX | 2000"));
        cMP = null;
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
    		cBD.agregaBanda(agBaNom.getText().trim(), bandaIm.toString().trim(), agBaBio.getText().trim());
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
    	if (artisIm == null || agArNom.getText().equals("") || agArBio.getText().equals("")) {
    		agArErr.setText("Debes llenar todos los campos!");
    		return;
    	}
    	try{
    		cBD.agregaArtista(agArNom.getText().trim(), artisIm.toString().trim(), agArBio.getText().trim(), agArInt.getText().trim());
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
            Integer.parseInt(agAlAno.getText());
            Integer.parseInt(agAlDis.getText());
        }catch(Exception e){
            agAlErr.setText("Formato Invalido en Año|Num.Discos");
            return;            
        }

    	try{
    		cBD.agregaAlbum(agAlNom.getText().trim(), albumIm.toString().trim(), agAlInt.getText().trim(), Integer.parseInt(agAlAno.getText()), Integer.parseInt(agAlDis.getText()), agAlArt.isSelected());
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
        if (!agCaSen.isSelected()) {
        	if (canciAr == null || agCaNom.getText().equals("") || agCaAlb.getText().equals("") || 
        		agCaInt.getText().equals("") || agCaCom.getText().equals("") ||
        		agCaGen.getText().equals("") || agCaAno.getText().equals("") ||
        		agCaCal.getText().equals("") || agCaPis.getText().equals("") ||
        		agCaDis.getText().equals("")) {
        		agCaErr.setText("Debes llenar todos los campos!");
        		return;
        	}    
        }else{
            if (canciAr == null || agCaNom.getText().equals("") || 
                agCaInt.getText().equals("") || agCaCom.getText().equals("") ||
                agCaGen.getText().equals("") || agCaAno.getText().equals("") ||
                agCaCal.getText().equals("")) {
                agCaErr.setText("Debes llenar todos los campos!");
                return;
            }
        }

        try{
            if (!agCaAno.equals("")) {
                Integer.parseInt(agCaAno.getText());
            }
            if (!agCaCal.equals("")) {
                Integer.parseInt(agCaCal.getText());
            }
            if (!agCaSen.isSelected()) {
                Integer.parseInt(agCaPis.getText());
                Integer.parseInt(agCaDis.getText());
            }
        }catch(Exception e){
            agCaErr.setText("Formato Invalido en Año|Calificación|Num.Pista|Disco");
            return;            
        }

    	try{
            if (!agCaSen.isSelected()) {
        		cBD.agregaCancion(agCaNom.getText().trim(), agCaAlb.getText().trim(), 
        						  agCaInt.getText().trim(), agCaCom.getText().trim(),
        						  agCaGen.getText().trim(), Integer.parseInt(agCaAno.getText()),
        						  Integer.parseInt(agCaCal.getText()), Integer.parseInt(agCaPis.getText()),
        						  Integer.parseInt(agCaDis.getText()), agCaSen.isSelected(), canciAr.toString().trim());   
            }else{
                cBD.agregaCancion(agCaNom.getText().trim(), agCaAlb.getText().trim(), 
                                  agCaInt.getText().trim(), agCaCom.getText().trim(),
                                  agCaGen.getText().trim(), Integer.parseInt(agCaAno.getText()),
                                  Integer.parseInt(agCaCal.getText()), 0,
                                  0, agCaSen.isSelected(), canciAr.toString().trim());   
            }
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

    @FXML private TextField buSeNom;
    @FXML private TableView<Cancion> buTaCa;
    @FXML private TableColumn<Cancion, String> buCoCNom;
    @FXML private TableColumn<Cancion, String> buCoCInt;
    @FXML private TableColumn<Cancion, String> buCoCAlb;
    @FXML private TableColumn<Cancion, String> buCoCGen;
    @FXML private TableColumn<Cancion, String> buCoCCom;
    @FXML private TableColumn<Cancion, Number> buCoCAno;
    @FXML private TableColumn<Cancion, Number> buCoCNup;
    @FXML private TableColumn<Cancion, Number> buCoCNud;
    @FXML private TableColumn<Cancion, Number> buCoCCal;
    @FXML private TableColumn<Cancion, Number> buCoCRep;
    @FXML private TableColumn<Cancion, String> buCoCFec;
    @FXML private TableColumn<Cancion, String> buCoCUbi;

    @FXML private TableView<Album> buTaAl;
    @FXML private TableColumn<Album, String> buCoANom;
    @FXML private TableColumn<Album, String> buCoAArt;
    @FXML private TableColumn<Album, Number> buCoAAno;
    @FXML private TableColumn<Album, Number> buCoANud;
    @FXML private TableColumn<Album, Number> buCoANuc;

    @FXML private TableView<Banda> buTaBa;
    @FXML private TableColumn<Banda, String> buCoBNom;

    @FXML private TableView<Artista> buTaAr;
    @FXML private TableColumn<Artista, String> buCoArNom;
    @FXML private TableColumn<Artista, String> buCoArInt;

    @FXML private TableView<Cancion> buTaCaAv;
    @FXML private TableColumn<Cancion, String> buCoCNomAv;
    @FXML private TableColumn<Cancion, String> buCoCIntAv;
    @FXML private TableColumn<Cancion, String> buCoCAlbAv;
    @FXML private TableColumn<Cancion, String> buCoCGenAv;
    @FXML private TableColumn<Cancion, String> buCoCComAv;
    @FXML private TableColumn<Cancion, Number> buCoCAnoAv;
    @FXML private TableColumn<Cancion, Number> buCoCNupAv;
    @FXML private TableColumn<Cancion, Number> buCoCNudAv;
    @FXML private TableColumn<Cancion, Number> buCoCCalAv;
    @FXML private TableColumn<Cancion, Number> buCoCRepAv;
    @FXML private TableColumn<Cancion, String> buCoCFecAv;
    @FXML private TableColumn<Cancion, String> buCoCUbiAv;

    @FXML private TableView<Album> buTaAlAv;
    @FXML private TableColumn<Album, String> buCoANomAv;
    @FXML private TableColumn<Album, String> buCoAArtAv;
    @FXML private TableColumn<Album, Number> buCoAAnoAv;
    @FXML private TableColumn<Album, Number> buCoANudAv;
    @FXML private TableColumn<Album, Number> buCoANucAv;

    @FXML private void initialize() {
        buCoCNom.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        buCoCInt.setCellValueFactory(cellData -> cellData.getValue().getInterprete());
        buCoCAlb.setCellValueFactory(cellData -> cellData.getValue().getAlbum());
        buCoCGen.setCellValueFactory(cellData -> cellData.getValue().getGenero());
        buCoCCom.setCellValueFactory(cellData -> cellData.getValue().getCompositor());
        buCoCAno.setCellValueFactory(cellData -> cellData.getValue().getAno());
        buCoCNup.setCellValueFactory(cellData -> cellData.getValue().getPista());
        buCoCNud.setCellValueFactory(cellData -> cellData.getValue().getDisco());
        buCoCCal.setCellValueFactory(cellData -> cellData.getValue().getCalificacion());
        buCoCRep.setCellValueFactory(cellData -> cellData.getValue().getReproducciones());
        buCoCFec.setCellValueFactory(cellData -> cellData.getValue().getFechaIncl());
        buCoCUbi.setCellValueFactory(cellData -> cellData.getValue().getUbicacion());
        buCoANom.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        buCoAArt.setCellValueFactory(cellData -> cellData.getValue().getArtista());
        buCoAAno.setCellValueFactory(cellData -> cellData.getValue().getAno());
        buCoANud.setCellValueFactory(cellData -> cellData.getValue().getNumdis());
        buCoANuc.setCellValueFactory(cellData -> cellData.getValue().getNumcan());
        buCoBNom.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        buCoArNom.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        buCoArInt.setCellValueFactory(cellData -> cellData.getValue().getIntegrant());
        buCoCNomAv.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        buCoCIntAv.setCellValueFactory(cellData -> cellData.getValue().getInterprete());
        buCoCAlbAv.setCellValueFactory(cellData -> cellData.getValue().getAlbum());
        buCoCGenAv.setCellValueFactory(cellData -> cellData.getValue().getGenero());
        buCoCComAv.setCellValueFactory(cellData -> cellData.getValue().getCompositor());
        buCoCAnoAv.setCellValueFactory(cellData -> cellData.getValue().getAno());
        buCoCNupAv.setCellValueFactory(cellData -> cellData.getValue().getPista());
        buCoCNudAv.setCellValueFactory(cellData -> cellData.getValue().getDisco());
        buCoCCalAv.setCellValueFactory(cellData -> cellData.getValue().getCalificacion());
        buCoCRepAv.setCellValueFactory(cellData -> cellData.getValue().getReproducciones());
        buCoCFecAv.setCellValueFactory(cellData -> cellData.getValue().getFechaIncl());
        buCoCUbiAv.setCellValueFactory(cellData -> cellData.getValue().getUbicacion());
        buCoANomAv.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        buCoAArtAv.setCellValueFactory(cellData -> cellData.getValue().getArtista());
        buCoAAnoAv.setCellValueFactory(cellData -> cellData.getValue().getAno());
        buCoANudAv.setCellValueFactory(cellData -> cellData.getValue().getNumdis());
        buCoANucAv.setCellValueFactory(cellData -> cellData.getValue().getNumcan());
    }

    @SuppressWarnings("unchecked") @FXML protected void buscaSencilla(ActionEvent event){
        buTaCa.setItems(null);
        buTaAl.setItems(null);
        buTaBa.setItems(null);
        buTaAr.setItems(null);
        if (!buSeNom.equals("")) {
            LinkedList<LinkedList> result = new LinkedList<LinkedList>();
            try{
                ControladorBusquedaBD bcan = new ControladorBusquedaBD(result, "Cancion", buSeNom.getText());
                ControladorBusquedaBD balb = new ControladorBusquedaBD(result, "Album", buSeNom.getText());
                ControladorBusquedaBD bban = new ControladorBusquedaBD(result, "Banda", buSeNom.getText());
                ControladorBusquedaBD bart = new ControladorBusquedaBD(result, "Artista", buSeNom.getText());
                new Thread(bcan).start();
                new Thread(balb).start();
                new Thread(bban).start();
                new Thread(bart).start();
            }catch(Exception e){
                //Inalcanzable
            }
            buSeNom.setText("");

            try{
                    synchronized(result){
                        for (int i = 0; i < 4 ; i++) {
                            if (result.size() == 0) {
                                result.wait();
                            }
                            LinkedList l = result.pop();
                            if (l.size() != 0) {
                                Object o = l.pop();
                                l.push(o);
                                switch(o.getClass().toString()){
                                    case "class JukeBox.Cancion":{
                                        LinkedList<Cancion> lC = (LinkedList<Cancion>)l;
                                        ObservableList<Cancion> cD = FXCollections.observableArrayList();
                                        for (Cancion c: lC) {
                                            cD.add(c);
                                        }
                                        buTaCa.setItems(cD);
                                        break;
                                    }
                                    case "class JukeBox.Album":{
                                        LinkedList<Album> lA = (LinkedList<Album>)l;
                                        ObservableList<Album> aD = FXCollections.observableArrayList();
                                        for (Album a: lA) {
                                            aD.add(a);
                                        }
                                        buTaAl.setItems(aD);
                                        break;
                                    }
                                    case "class JukeBox.Banda":{
                                        LinkedList<Banda> lB = (LinkedList<Banda>)l;
                                        ObservableList<Banda> bD = FXCollections.observableArrayList();
                                        for (Banda b: lB) {
                                            bD.add(b);
                                        }
                                        buTaBa.setItems(bD);
                                        break;                     
                                    }
                                    case "class JukeBox.Artista":{
                                        LinkedList<Artista> lA = (LinkedList<Artista>)l;
                                        ObservableList<Artista> aD = FXCollections.observableArrayList();
                                        for (Artista a: lA) {
                                            aD.add(a);
                                        }
                                        buTaAr.setItems(aD);
                                        break;                                          
                                    }
                                }
                            }else{
                                continue;
                            }
                        }
                    }
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
    }

    @FXML private Text reNoCa;
    @FXML private Text reNoAl;
    @FXML private Text reNoAn;
    @FXML private Text reNoAr;
    @FXML private Text reNoBi;
    @FXML private ImageView reImAl;
    @FXML private ImageView reImBa;

    @FXML protected void rePlay(ActionEvent event){
        if (cMP != null) {
            cMP.play();
        }else{
            if (colaRep.size() != 0) {
                Cancion c = (Cancion)colaRep.poll();
                Album a = (Album)colaRep.poll();
                Banda b = (Banda)colaRep.poll();
                cMP = new ControladorMP(c.getRuta().get());
                reNoCa.setText(c.getNombre().get());
                reNoAl.setText(a.getNombre().get());
                reNoAn.setText("" + c.getAno().get());
                reNoAr.setText(b.getNombre().get());
                reNoBi.setText(b.getBiografia().get());
                reImAl.setImage(new Image(new File(a.getIlustra().get()).toURI().toString()));
                reImBa.setImage(new Image(new File(b.getIlustracion().get()).toURI().toString()));
                cMP.play();
            }
        }
    }

    @FXML protected void rePause(ActionEvent event){
        if (cMP != null) {
            cMP.pausa();
        }
    }

    @FXML protected void reReini(ActionEvent event){
        if (cMP != null) {
            cMP.reiniciar();
        }
    }

    @FXML protected void reAvanz(ActionEvent event){
        if (cMP != null) {
            cMP.stop();
        }else{
            if (colaRep.size() != 0) {
                Cancion c = (Cancion)colaRep.poll();
                Album a = (Album)colaRep.poll();
                Banda b = (Banda)colaRep.poll();
                cMP = new ControladorMP(c.getRuta().get());
                reNoCa.setText(c.getNombre().get());
                reNoAl.setText(a.getNombre().get());
                reNoAn.setText("" + c.getAno().get());
                reNoAr.setText(b.getNombre().get());
                reNoBi.setText(b.getBiografia().get());
                reImAl.setImage(new Image(new File(a.getIlustra().get()).toURI().toString()));
                reImBa.setImage(new Image(new File(b.getIlustracion().get()).toURI().toString()));
                cMP.play();
            }
        }
    }

    @FXML private Slider reSli;

    @FXML protected void reVol(MouseEvent event){
        if (cMP != null) {
            cMP.setVolume(reSli.getValue());
        }
    }

    @FXML private TextField buAvCaNom;
    @FXML private TextField buAvCaFei;
    @FXML private TextField buAvCaFef;
    @FXML private TextField buAvCaCai;
    @FXML private TextField buAvCaCaf;
    @FXML private TextField buAvCaRei;
    @FXML private TextField buAvCaRef;
    @FXML private TextField buAvCaInt;
    @FXML private TextField buAvCaBan;
    @FXML private TextField buAvCaCom;
    @FXML private Text buAvCaErr;

    @SuppressWarnings("unchecked") @FXML protected void buscaAvanzadaC(ActionEvent event){
        if (!buAvCaNom.getText().equals("")) {
            if (!(buAvCaInt.getText().equals("")&&buAvCaBan.getText().equals(""))) {
                buAvCaErr.setText("Solo puedes llenar un campo. [Cancion|Interprete|Banda]");
                return;
            }else{
                buTaCaAv.setItems(null);
                LinkedList<LinkedList> result = new LinkedList<LinkedList>();
                try{
                    ControladorBusquedaBD bcan = new ControladorBusquedaBD(result, buAvCaNom.getText(), buAvCaFei.getText(), buAvCaFef.getText(), buAvCaCai.getText(), buAvCaCaf.getText(), buAvCaRei.getText(), buAvCaRef.getText(), null, null, buAvCaCom.getText());
                    new Thread(bcan).start();
                }catch(Exception e){
                    //Inalcanzable
                }
                buAvCaErr.setText("");
                buAvCaNom.setText("");
                buAvCaFei.setText("");
                buAvCaFef.setText("");
                buAvCaCai.setText("");
                buAvCaCaf.setText("");
                buAvCaRei.setText("");
                buAvCaRef.setText("");
                buAvCaInt.setText("");
                buAvCaBan.setText("");
                buAvCaCom.setText("");
                try{
                    synchronized(result){
                        if (result.size() == 0) {
                            result.wait();
                        }
                        LinkedList l = result.pop();
                        if (l.size() != 0) {
                            LinkedList<Cancion> lC = (LinkedList<Cancion>)l;
                            ObservableList<Cancion> cD = FXCollections.observableArrayList();
                            for (Cancion c: lC) {
                                cD.add(c);
                            }
                            buTaCaAv.setItems(cD);
                        }
                    }
                }catch(Exception e){
                        System.err.println(e.getMessage());
                }
            }
        }else if (!buAvCaInt.getText().equals("")) {
            if (!(buAvCaBan.getText().equals("")&&buAvCaNom.getText().equals(""))) {
                buAvCaErr.setText("Solo puedes llenar un campo. [Cancion|Interprete|Banda]");
                return;
            }else{
                buTaCaAv.setItems(null);
                LinkedList<LinkedList> result = new LinkedList<LinkedList>();
                try{
                    ControladorBusquedaBD bcan = new ControladorBusquedaBD(result, null, buAvCaFei.getText(), buAvCaFef.getText(), buAvCaCai.getText(), buAvCaCaf.getText(), buAvCaRei.getText(), buAvCaRef.getText(), buAvCaInt.getText(), null, buAvCaCom.getText());
                    new Thread(bcan).start();
                }catch(Exception e){
                    //Inalcanzable
                }
                buAvCaErr.setText("");
                buAvCaNom.setText("");
                buAvCaFei.setText("");
                buAvCaFef.setText("");
                buAvCaCai.setText("");
                buAvCaCaf.setText("");
                buAvCaRei.setText("");
                buAvCaRef.setText("");
                buAvCaInt.setText("");
                buAvCaBan.setText("");
                buAvCaCom.setText("");
                try{
                    synchronized(result){
                        if (result.size() == 0) {
                            result.wait();
                        }
                        LinkedList l = result.pop();
                        if (l.size() != 0) {
                            LinkedList<Cancion> lC = (LinkedList<Cancion>)l;
                            ObservableList<Cancion> cD = FXCollections.observableArrayList();
                            for (Cancion c: lC) {
                                cD.add(c);
                            }
                            buTaCaAv.setItems(cD);
                        }
                    }
                }catch(Exception e){
                        System.err.println(e.getMessage());
                }                
            }
        }else if (!buAvCaBan.getText().equals("")) {
            if (!(buAvCaNom.getText().equals("")&&buAvCaInt.getText().equals(""))) {
                buAvCaErr.setText("Solo puedes llenar un campo. [Cancion|Interprete|Banda]");
                return;
            }else{
                buTaCaAv.setItems(null);
                LinkedList<LinkedList> result = new LinkedList<LinkedList>();
                try{
                    ControladorBusquedaBD bcan = new ControladorBusquedaBD(result, null, buAvCaFei.getText(), buAvCaFef.getText(), buAvCaCai.getText(), buAvCaCaf.getText(), buAvCaRei.getText(), buAvCaRef.getText(), null, buAvCaBan.getText(), buAvCaCom.getText());
                    new Thread(bcan).start();
                }catch(Exception e){
                    //Inalcanzable
                }
                buAvCaErr.setText("");
                buAvCaNom.setText("");
                buAvCaFei.setText("");
                buAvCaFef.setText("");
                buAvCaCai.setText("");
                buAvCaCaf.setText("");
                buAvCaRei.setText("");
                buAvCaRef.setText("");
                buAvCaInt.setText("");
                buAvCaBan.setText("");
                buAvCaCom.setText("");
                try{
                    synchronized(result){
                        if (result.size() == 0) {
                            result.wait();
                        }
                        LinkedList l = result.pop();
                        if (l.size() != 0) {
                            LinkedList<Cancion> lC = (LinkedList<Cancion>)l;
                            ObservableList<Cancion> cD = FXCollections.observableArrayList();
                            for (Cancion c: lC) {
                                cD.add(c);
                            }
                            buTaCaAv.setItems(cD);
                        }
                    }
                }catch(Exception e){
                        System.err.println(e.getMessage());
                }                
            }
        }else{
                buTaCaAv.setItems(null);
                LinkedList<LinkedList> result = new LinkedList<LinkedList>();
                try{
                    ControladorBusquedaBD bcan = new ControladorBusquedaBD(result, "%", buAvCaFei.getText(), buAvCaFef.getText(), buAvCaCai.getText(), buAvCaCaf.getText(), buAvCaRei.getText(), buAvCaRef.getText(), null, null, buAvCaCom.getText());
                    new Thread(bcan).start();
                }catch(Exception e){
                    //Inalcanzable
                }
                buAvCaErr.setText("");
                buAvCaNom.setText("");
                buAvCaFei.setText("");
                buAvCaFef.setText("");
                buAvCaCai.setText("");
                buAvCaCaf.setText("");
                buAvCaRei.setText("");
                buAvCaRef.setText("");
                buAvCaInt.setText("");
                buAvCaBan.setText("");
                buAvCaCom.setText("");
                try{
                    synchronized(result){
                        if (result.size() == 0) {
                            result.wait();
                        }
                        LinkedList l = result.pop();
                        if (l.size() != 0) {
                            LinkedList<Cancion> lC = (LinkedList<Cancion>)l;
                            ObservableList<Cancion> cD = FXCollections.observableArrayList();
                            for (Cancion c: lC) {
                                cD.add(c);
                            }
                            buTaCaAv.setItems(cD);
                        }
                    }
                }catch(Exception e){
                        System.err.println(e.getMessage());
                }
        }
    }

    @FXML private TextField buAvAlNom;
    @FXML private TextField buAvAlFei;
    @FXML private TextField buAvAlFef;
    @FXML private TextField buAvAlCai;
    @FXML private TextField buAvAlCaf;
    @FXML private TextField buAvAlDii;
    @FXML private TextField buAvAlDif;
    @FXML private TextField buAvAlPer;
    @FXML private Text buAvAlErr;

    @SuppressWarnings("unchecked") @FXML protected void buscaAvanzadaA(ActionEvent event){
        if (!buAvAlNom.getText().equals("")) {
            if (!(buAvAlPer.getText().equals(""))) {
                buAvAlErr.setText("Solo puedes llenar un campo. [Álbum|Artista/Banda]");
                return;
            }else{
                buTaAlAv.setItems(null);
                LinkedList<LinkedList> result = new LinkedList<LinkedList>();
                try{
                    ControladorBusquedaBD bcan = new ControladorBusquedaBD(result, buAvAlNom.getText(), buAvAlFei.getText(), buAvAlFef.getText(), buAvAlCai.getText(), buAvAlCaf.getText(), buAvAlDii.getText(), buAvAlDif.getText(), null);
                    new Thread(bcan).start();
                }catch(Exception e){
                    //Inalcanzable
                }
                buAvAlNom.setText("");
                buAvAlFei.setText("");
                buAvAlFef.setText("");
                buAvAlCai.setText("");
                buAvAlCaf.setText("");
                buAvAlDii.setText("");
                buAvAlDif.setText("");
                buAvAlPer.setText("");
                buAvAlErr.setText("");
                try{
                    synchronized(result){
                        if (result.size() == 0) {
                            result.wait();
                        }
                        LinkedList l = result.pop();
                        if (l.size() != 0) {
                            LinkedList<Album> lC = (LinkedList<Album>)l;
                            ObservableList<Album> cD = FXCollections.observableArrayList();
                            for (Album c: lC) {
                                cD.add(c);
                            }
                            buTaAlAv.setItems(cD);
                        }
                    }
                }catch(Exception e){
                        System.err.println(e.getMessage());
                }                
            }
        }else if (!buAvAlPer.getText().equals("")) {
            if (!(buAvAlNom.getText().equals(""))) {
                buAvAlErr.setText("Solo puedes llenar un campo. [Álbum|Artista/Banda]");
                return;
            }else{
                buTaAlAv.setItems(null);
                LinkedList<LinkedList> result = new LinkedList<LinkedList>();
                try{
                    ControladorBusquedaBD bcan = new ControladorBusquedaBD(result, null, buAvAlFei.getText(), buAvAlFef.getText(), buAvAlCai.getText(), buAvAlCaf.getText(), buAvAlDii.getText(), buAvAlDif.getText(), buAvAlPer.getText());
                    new Thread(bcan).start();
                }catch(Exception e){
                    //Inalcanzable
                }
                buAvAlNom.setText("");
                buAvAlFei.setText("");
                buAvAlFef.setText("");
                buAvAlCai.setText("");
                buAvAlCaf.setText("");
                buAvAlDii.setText("");
                buAvAlDif.setText("");
                buAvAlPer.setText("");
                buAvAlErr.setText("");
                try{
                    synchronized(result){
                        if (result.size() == 0) {
                            result.wait();
                        }
                        LinkedList l = result.pop();
                        if (l.size() != 0) {
                            LinkedList<Album> lC = (LinkedList<Album>)l;
                            ObservableList<Album> cD = FXCollections.observableArrayList();
                            for (Album c: lC) {
                                cD.add(c);
                            }
                            buTaAlAv.setItems(cD);
                        }
                    }
                }catch(Exception e){
                        System.err.println(e.getMessage());
                }                
            }
        }else{
                buTaAlAv.setItems(null);
                LinkedList<LinkedList> result = new LinkedList<LinkedList>();
                try{
                    ControladorBusquedaBD bcan = new ControladorBusquedaBD(result, "%", buAvAlFei.getText(), buAvAlFef.getText(), buAvAlCai.getText(), buAvAlCaf.getText(), buAvAlDii.getText(), buAvAlDif.getText(), null);
                    new Thread(bcan).start();
                }catch(Exception e){
                    //Inalcanzable
                }
                buAvAlNom.setText("");
                buAvAlFei.setText("");
                buAvAlFef.setText("");
                buAvAlCai.setText("");
                buAvAlCaf.setText("");
                buAvAlDii.setText("");
                buAvAlDif.setText("");
                buAvAlPer.setText("");
                buAvAlErr.setText("");
                try{
                    synchronized(result){
                        if (result.size() == 0) {
                            result.wait();
                        }
                        LinkedList l = result.pop();
                        if (l.size() != 0) {
                            LinkedList<Album> lC = (LinkedList<Album>)l;
                            ObservableList<Album> cD = FXCollections.observableArrayList();
                            for (Album c: lC) {
                                cD.add(c);
                            }
                            buTaAlAv.setItems(cD);
                        }
                    }
                }catch(Exception e){
                        System.err.println(e.getMessage());
                }
        }    
    }
}
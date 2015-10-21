package JukeBox;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ControladorMP{

	Media m;
	MediaPlayer mp;

	public ControladorMP(){
		m = null;
		mp = null;
	}

	public ControladorMP(String url){
		m = new Media(url);
		mp = new MediaPlayer(m);
	}


}
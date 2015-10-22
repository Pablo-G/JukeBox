package JukeBox;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class ControladorMP{

	Media m;
	MediaPlayer mp;

	public ControladorMP(String url){
		m = new Media(new File(url).toURI().toString());
		mp = new MediaPlayer(m);
		mp.setAutoPlay(false);
	}

	public void play(){
		mp.play();
	}

	public void pausa(){
		mp.pause();
	}

	public void stop(){
		mp.stop();
	}

	public void reiniciar(){
		mp.seek(mp.getStartTime());
	}

	public void setVolume(double x){
		mp.setVolume(x);
	}

}
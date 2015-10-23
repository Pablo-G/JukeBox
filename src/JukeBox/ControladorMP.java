/**
 *Clase <code>ControladorMP</code>.
 *Clase que contiene un Media Player para reproducir las canciones.
 *@author <a href="mailto:pablo.t645@hotmail.com">Pablo G.</a>
 *@version 1.0
 *Copyright 2015 Pablo G.
 */
package JukeBox;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class ControladorMP{

	Media m;
	MediaPlayer mp;

    /**
     *<code>ControladorMP</code> Constructor.
     *@param url tipo <code>String</code>: Ubicación de la canción a reproducir.
     */
	public ControladorMP(String url){
		m = new Media(new File(url).toURI().toString());
		mp = new MediaPlayer(m);
		mp.setAutoPlay(false);
	}

    /**
     *<code>play</code> Método que pone play al Media Player.
     */
	public void play(){
		mp.play();
	}

    /**
     *<code>pausa</code> Método que pone en pausa al Media Player.
     */
	public void pausa(){
		mp.pause();
	}

    /**
     *<code>stop</code> Método que pone en stop al Media Player.
     */
	public void stop(){
		mp.stop();
	}

    /**
     *<code>reiniciar</code> Método que reinicia la canción.
     */
	public void reiniciar(){
		mp.seek(mp.getStartTime());
	}

    /**
     *<code>setVolume</code> Método que ajusta el volumen del Media Player.
     *@param x tipo <code>double</code>: Ajuste de Volumen [0,1].
     */
	public void setVolume(double x){
		mp.setVolume(x);
	}

}
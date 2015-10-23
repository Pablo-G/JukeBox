/**
 *Clase <code>Artista</code>.
 *Clase que contiene informacion de artistas.
 *@author <a href="mailto:pablo.t645@hotmail.com">Pablo G.</a>
 *@version 1.0
 *Copyright 2015 Pablo G.
 */
package JukeBox;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Artista{
	
	private StringProperty nombre;
	private StringProperty ilustracion;
	private StringProperty biografia;
	private StringProperty inteDe;

    /**
     *<code>Artista</code> Constructor.
     *@param nombre tipo <code>String</code>: Nombre del Artista.
     *@param ilustracion tipo <code>String</code>: Ruta de ilustración del Artista.
     *@param biografia tipo <code>String</code>: Biografia del Artista.
     *@param inteDe tipo <code>String</code>: Bandas a las que pertenece el Artista.
     */
	public Artista(String nombre, String ilustracion, String biografia, String inteDe){
		this.nombre = new SimpleStringProperty(nombre);
		this.ilustracion = new SimpleStringProperty(ilustracion);
		this.biografia = new SimpleStringProperty(biografia);
		this.inteDe = new SimpleStringProperty(inteDe);
	}

    /**
     *<code>getNombre</code> Método que regresa el nombre del artista.
     *@return tipo <code>StringProperty</code>: Nombre del artista.
     */
	public StringProperty getNombre(){
		return this.nombre;
	}

    /**
     *<code>getIlustracion</code> Método que regresa la ruta de la ilustración del artista.
     *@return tipo <code>StringProperty</code>: Ruta de la ilustración del artista.
     */
	public StringProperty getIlustracion(){
		return this.ilustracion;
	}
	
    /**
     *<code>getBiografia</code> Método que regresa la biografía del artista.
     *@return tipo <code>StringProperty</code>: Biografía del artista.
     */
	public StringProperty getBiografia(){
		return this.biografia;
	}

    /**
     *<code>getIntegrant</code> Método que regresa las bandas a las que pertenece el artista.
     *@return tipo <code>StringProperty</code>: Bandas a las que pertenece el artista.
     */
	public StringProperty getIntegrant(){
		return this.inteDe;
	}

    /**
     *<code>getSNombre</code> Método que regresa el nombre del artista.
     *@return tipo <code>String</code>: Nombre del artista.
     */
	public String getSNombre(){
		return this.nombre.get();
	}

    /**
     *<code>setIntegrant</code> Método que cambia las bandas a las que pertenece el artista.
     *@param x tipo <code>String</code>: Nuevas bandas a las que pertenece el artista.
     */
	public void setIntegrant(String x){
		this.inteDe = new SimpleStringProperty(x);
	}

}
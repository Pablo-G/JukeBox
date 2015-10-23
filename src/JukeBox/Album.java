/**
 *Clase <code>Album</code>.
 *Clase que contiene informacion de albumes.
 *@author <a href="mailto:pablo.t645@hotmail.com">Pablo G.</a>
 *@version 1.0
 *Copyright 2015 Pablo G.
 */
package JukeBox;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Album{
	
	private StringProperty nombre;
	private StringProperty artista;
	private IntegerProperty ano;
	private IntegerProperty numdis;
	private IntegerProperty numcan;
	private StringProperty ilustra;

    /**
     *<code>Album</code> Constructor.
     *@param nombre tipo <code>String</code>: Nombre del Álbum.
     *@param artista tipo <code>String</code>: Artista del Álbum.
     *@param ano tipo <code>int</code>: Año del Álbum.
     *@param numdis tipo <code>int</code>: Número de discos del Álbum.
     *@param numcan tipo <code>int</code>: Número de canciones del Álbum.
     *@param ilustra tipo <code>String</code>: Ruta de la ilustración del Álbum.
     */
	public Album(String nombre, String artista, int ano, int numdis, int numcan, String ilustra){
		this.nombre = new SimpleStringProperty(nombre);
		this.artista = new SimpleStringProperty(artista);
		this.ano = new SimpleIntegerProperty(ano);
		this.numdis = new SimpleIntegerProperty(numdis);
		this.numcan = new SimpleIntegerProperty(numcan);
		this.ilustra = new SimpleStringProperty(ilustra);		
	}

    /**
     *<code>getNombre</code> Método que regresa el nombre del álbum.
     *@return tipo <code>StringProperty</code>: Nombre del álbum.
     */
	public StringProperty getNombre(){
		return this.nombre;
	}

    /**
     *<code>getArtista</code> Método que regresa el artista del álbum.
     *@return tipo <code>StringProperty</code>: Artista del álbum.
     */
	public StringProperty getArtista(){
		return this.artista;
	}

    /**
     *<code>getAno</code> Método que regresa el año del álbum.
     *@return tipo <code>IntegerProperty</code>: Año del álbum.
     */
	public IntegerProperty getAno(){
		return this.ano;
	}

    /**
     *<code>getNumdis</code> Método que regresa el número de discos del álbum.
     *@return tipo <code>IntegerProperty</code>: Número de discos del álbum.
     */
	public IntegerProperty getNumdis(){
		return this.numdis;
	}

    /**
     *<code>getNumcan</code> Método que regresa el número de canciones del álbum.
     *@return tipo <code>IntegerProperty</code>: Número de canciones del álbum.
     */
	public IntegerProperty getNumcan(){
		return this.numcan;
	}

    /**
     *<code>getIlustra</code> Método que regresa la ruta de la ilustración del álbum.
     *@return tipo <code>StringProperty</code>: Ruta de la ilustración del álbum.
     */
	public StringProperty getIlustra(){
		return this.ilustra;
	}

    /**
     *<code>getSNombre</code> Método que regresa el nombre del álbum.
     *@return tipo <code>String</code>: Nombre del álbum.
     */
	public String getSNombre(){
		return this.nombre.get();
	}

    /**
     *<code>setArtist</code> Método que cambia el artista del álbum.
     *@param x tipo <code>String</code>: Nuevo artista del álbum.
     */
	public void setArtist(String x){
		this.artista = new SimpleStringProperty(x);
	}

}
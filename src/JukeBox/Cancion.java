/**
 *Clase <code>Cancion</code>.
 *Clase que contiene informacion de las canciones.
 *@author <a href="mailto:pablo.t645@hotmail.com">Pablo G.</a>
 *@version 1.0
 *Copyright 2015 Pablo G.
 */
package JukeBox;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cancion{

	private StringProperty nombre;
	private StringProperty interprete;
	private StringProperty album;
	private StringProperty compositor;
	private StringProperty genero;
	private IntegerProperty numPis;
	private IntegerProperty numDis;
	private IntegerProperty ano;
	private IntegerProperty calificacion;
	private IntegerProperty reproducciones;
	private StringProperty fechaIncl;
	private StringProperty ubicacion;
	private StringProperty ruta;

    /**
     *<code>Cancion</code> Constructor.
     *@param nombre tipo <code>String</code>: Nombre de la Canción.
     *@param compositor tipo <code>String</code>: Compositor de la Canción.
     *@param genero tipo <code>String</code>: Género de la Canción.
     *@param ano tipo <code>int</code>: Año de la Canción.
     *@param calificacion tipo <code>int</code>: Calificación de la Canción.
     *@param reproducciones tipo <code>int</code>: Número de reproducciones de la Canción.
     *@param fechaIncl tipo <code>String</code>: Fecha de Inclusión de la Canción.
     *@param ubicacion tipo <code>String</code>: Ubicación de la Canción.
     *@param ruta tipo <code>String</code>: Ruta de la Canción.
     *@param interprete tipo <code>String</code>: Interprete de la Canción.
     *@param album tipo <code>String</code>: Álbum al que pertenece la Canción.
     *@param numPis tipo <code>int</code>: Número de pista en ese álbum.
     *@param numDis tipo <code>int</code>: Número de discp en ese álbum.
     */
	public Cancion(String nombre, String compositor, String genero, int ano, int calificacion, int reproducciones, String fechaIncl, String ubicacion, String ruta, String interprete, String album, int numPis, int numDis){
		this.nombre = new SimpleStringProperty(nombre);
		this.compositor = new SimpleStringProperty(compositor);
		this.genero = new SimpleStringProperty(genero);
		this.ano = new SimpleIntegerProperty(ano);
		this.calificacion = new SimpleIntegerProperty(calificacion);
		this.reproducciones = new SimpleIntegerProperty(reproducciones);
		this.fechaIncl = new SimpleStringProperty(fechaIncl);
		this.ubicacion = new SimpleStringProperty(ubicacion);
		this.ruta = new SimpleStringProperty(ruta);

		this.interprete = new SimpleStringProperty(interprete);
		this.album = new SimpleStringProperty(album);
		this.numPis = new SimpleIntegerProperty(numPis);
		this.numDis = new SimpleIntegerProperty(numDis);
	}

    /**
     *<code>getNombre</code> Método que regresa el nombre de la Canción.
     *@return tipo <code>StringProperty</code>: Nombre de la Canción.
     */
	public StringProperty getNombre(){
		return this.nombre;
	}

    /**
     *<code>getCompositor</code> Método que regresa el compositor de la Canción.
     *@return tipo <code>StringProperty</code>: Compositor de la Canción.
     */
	public StringProperty getCompositor(){
		return this.compositor;
	}

    /**
     *<code>getGenero</code> Método que regresa el género de la Canción.
     *@return tipo <code>StringProperty</code>: Género de la Canción.
     */
	public StringProperty getGenero(){
		return this.genero;
	}

    /**
     *<code>getAno</code> Método que regresa el año de la Canción.
     *@return tipo <code>IntegerProperty</code>: Año de la Canción.
     */
	public IntegerProperty getAno(){
		return this.ano;
	}

    /**
     *<code>getCalificacion</code> Método que regresa la calificación de la Canción.
     *@return tipo <code>IntegerProperty</code>: Calificación de la Canción.
     */
	public IntegerProperty getCalificacion(){
		return this.calificacion;
	}

    /**
     *<code>getReproducciones</code> Método que regresa el número de reproducciones de la Canción.
     *@return tipo <code>IntegerProperty</code>: Número de reproducciones de la Canción.
     */
	public IntegerProperty getReproducciones(){
		return this.reproducciones;
	}

    /**
     *<code>getFechaIncl</code> Método que regresa la fecha de Inclusión de la Canción.
     *@return tipo <code>StringProperty</code>: Fecha de Inclusión de la Canción.
     */
	public StringProperty getFechaIncl(){
		return this.fechaIncl;
	}

    /**
     *<code>getUbicacion</code> Método que regresa la ubicación de la Canción.
     *@return tipo <code>StringProperty</code>: Ubicación de la Canción.
     */
	public StringProperty getUbicacion(){
		return this.ubicacion;
	}
	
    /**
     *<code>getRuta</code> Método que regresa la ruta de la Canción.
     *@return tipo <code>StringProperty</code>: Ruta de la Canción.
     */
	public StringProperty getRuta(){
		return this.ruta;
	}

    /**
     *<code>getInterprete</code> Método que regresa el interprete de la Canción.
     *@return tipo <code>StringProperty</code>: Interprete de la Canción.
     */
	public StringProperty getInterprete(){
		return this.interprete;
	}

    /**
     *<code>getAlbum</code> Método que regresa el álbum al que pertenece la Canción.
     *@return tipo <code>StringProperty</code>: Álbum al que pertenece la Canción.
     */
	public StringProperty getAlbum(){
		return this.album;
	}

    /**
     *<code>getPista</code> Método que regresa el número de pista en ese álbum.
     *@return tipo <code>IntegerProperty</code>: Número de pista en ese álbum.
     */
	public IntegerProperty getPista(){
		return this.numPis;
	}

    /**
     *<code>getDisco</code> Método que regresa el número de discp en ese álbum.
     *@return tipo <code>IntegerProperty</code>: Número de discp en ese álbum.
     */
	public IntegerProperty getDisco(){
		return this.numDis;
	}
	
    /**
     *<code>setInter</code> Método que modifica el interprete de la Canción.
     *@param x tipo <code>String</code>: Nuevo Interprete de la Canción.
     */
	public void setInter(String x){
		this.interprete = new SimpleStringProperty(x);
	}

    /**
     *<code>setAlbum</code> Método que modifica el álbum al que pertenece la Canción.
     *@param x tipo <code>String</code>: Nuevo Álbum al que pertenece la Canción.
     */
	public void setAlbum(String x){
		this.album = new SimpleStringProperty(x);
	}

    /**
     *<code>setNumPi</code> Método que modifica el número de pista en ese álbum.
     *@param x tipo <code>String</code>: Nuevo Número de pista en ese álbum.
     */
	public void setNumPi(int x){
		this.numPis = new SimpleIntegerProperty(x);
	}

    /**
     *<code>setNumDi</code> Método que modifica el número de disco en ese álbum.
     *@param x tipo <code>String</code>: Nuevo Número de disco en ese álbum.
     */
	public void setNumDi(int x){
		this.numDis = new SimpleIntegerProperty(x);
	}

    /**
     *<code>getSNombre</code> Método que regresa el nombre de la Canción.
     *@return tipo <code>String</code>: Nombre de la Canción.
     */
	public String getSNombre(){
		return this.nombre.get();
	}
	
}
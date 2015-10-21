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

	public StringProperty getNombre(){
		return this.nombre;
	}

	public StringProperty getCompositor(){
		return this.compositor;
	}

	public StringProperty getGenero(){
		return this.genero;
	}

	public IntegerProperty getAno(){
		return this.ano;
	}

	public IntegerProperty getCalificacion(){
		return this.calificacion;
	}

	public IntegerProperty getReproducciones(){
		return this.reproducciones;
	}

	public StringProperty getFechaIncl(){
		return this.fechaIncl;
	}

	public StringProperty getUbicacion(){
		return this.ubicacion;
	}
	
	public StringProperty getRuta(){
		return this.ruta;
	}

	public StringProperty getInterprete(){
		return this.interprete;
	}

	public StringProperty getAlbum(){
		return this.album;
	}

	public IntegerProperty getPista(){
		return this.numPis;
	}

	public IntegerProperty getDisco(){
		return this.numDis;
	}
	
	public void setInter(String x){
		this.interprete = new SimpleStringProperty(x);
	}

	public void setAlbum(String x){
		this.album = new SimpleStringProperty(x);
	}

	public void setNumPi(int x){
		this.numPis = new SimpleIntegerProperty(x);
	}

	public void setNumDi(int x){
		this.numDis = new SimpleIntegerProperty(x);
	}

	public String getSNombre(){
		return this.nombre.get();
	}
}
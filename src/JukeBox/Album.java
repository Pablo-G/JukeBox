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

	public Album(String nombre, String artista, int ano, int numdis, int numcan, String ilustra){
		this.nombre = new SimpleStringProperty(nombre);
		this.artista = new SimpleStringProperty(artista);
		this.ano = new SimpleIntegerProperty(ano);
		this.numdis = new SimpleIntegerProperty(numdis);
		this.numcan = new SimpleIntegerProperty(numcan);
		this.ilustra = new SimpleStringProperty(ilustra);		
	}

	public StringProperty getNombre(){
		return this.nombre;
	}

	public StringProperty getArtista(){
		return this.artista;
	}

	public IntegerProperty getAno(){
		return this.ano;
	}

	public IntegerProperty getNumdis(){
		return this.numdis;
	}

	public IntegerProperty getNumcan(){
		return this.numcan;
	}

	public StringProperty getIlustra(){
		return this.ilustra;
	}

	public String getSNombre(){
		return this.nombre.get();
	}

	public void setArtist(String x){
		this.artista = new SimpleStringProperty(x);
	}

}
package JukeBox;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Artista{
	
	private StringProperty nombre;
	private StringProperty ilustracion;
	private StringProperty biografia;
	private StringProperty inteDe;

	public Artista(String nombre, String ilustracion, String biografia, String inteDe){
		this.nombre = new SimpleStringProperty(nombre);
		this.ilustracion = new SimpleStringProperty(ilustracion);
		this.biografia = new SimpleStringProperty(biografia);
		this.inteDe = new SimpleStringProperty(inteDe);
	}

	public StringProperty getNombre(){
		return this.nombre;
	}

	public StringProperty getIlustracion(){
		return this.ilustracion;
	}
	
	public StringProperty getBiografia(){
		return this.biografia;
	}

	public StringProperty getIntegrant(){
		return this.inteDe;
	}

	public String getSNombre(){
		return this.nombre.get();
	}

	public void setIntegrant(String x){
		this.inteDe = new SimpleStringProperty(x);
	}

}
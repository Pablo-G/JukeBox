package JukeBox;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Banda{
	
	private StringProperty nombre;
	private StringProperty ilustracion;
	private StringProperty biografia;

	public Banda(String nombre, String ilustracion, String biografia){
		this.nombre = new SimpleStringProperty(nombre);
		this.ilustracion = new SimpleStringProperty(ilustracion);
		this.biografia = new SimpleStringProperty(biografia);
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

}
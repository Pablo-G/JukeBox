/**
 *Clase <code>Banda</code>.
 *Clase que contiene informacion de bandas.
 *@author <a href="mailto:pablo.t645@hotmail.com">Pablo G.</a>
 *@version 1.0
 *Copyright 2015 Pablo G.
 */
package JukeBox;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Banda{
	
	private StringProperty nombre;
	private StringProperty ilustracion;
	private StringProperty biografia;

    /**
     *<code>Banda</code> Constructor.
     *@param nombre tipo <code>String</code>: Nombre de la Banda.
     *@param ilustracion tipo <code>String</code>: Ruta de ilustración de la Banda.
     *@param biografia tipo <code>String</code>: Biografia de la Banda.
     */
	public Banda(String nombre, String ilustracion, String biografia){
		this.nombre = new SimpleStringProperty(nombre);
		this.ilustracion = new SimpleStringProperty(ilustracion);
		this.biografia = new SimpleStringProperty(biografia);
	}

    /**
     *<code>getNombre</code> Método que regresa el nombre de la banda.
     *@return tipo <code>StringProperty</code>: Nombre de la banda.
     */
	public StringProperty getNombre(){
		return this.nombre;
	}

    /**
     *<code>getIlustracion</code> Método que regresa la ruta de la ilustración de la banda.
     *@return tipo <code>StringProperty</code>: Ruta de la ilustración de la banda.
     */
	public StringProperty getIlustracion(){
		return this.ilustracion;
	}

    /**
     *<code>getBiografia</code> Método que regresa la biografía de la banda.
     *@return tipo <code>StringProperty</code>: Biografía de la banda.
     */
	public StringProperty getBiografia(){
		return this.biografia;
	}

}
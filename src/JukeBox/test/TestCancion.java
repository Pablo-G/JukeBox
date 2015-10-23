/**
 *Clase <code>TestCancion</code>.
 *Clase para pruebas unitarias de la clase {@link Cancion}.
 *@author <a href="mailto:pablo.t645@hotmail.com">Pablo G.</a>
 *@version 1.0
 *Copyright 2015 Pablo G.
 */
package JukeBox.test;

import org.junit.Assert;
import org.junit.Test;
import JukeBox.Cancion;

public class TestCancion{
	
    /**
     * Prueba unitaria para {@link Cancion#Cancion}.
     */
	@Test public void testConstructor(){
		try{
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(true);
		}catch(Exception e){
			Assert.fail();
		}
	}

    /**
     * Prueba unitaria para {@link Cancion#getNombre}.
     */
	@Test public void testGetNombre(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getNombre().get().equals("Ángel"));
			Assert.assertTrue(b.getNombre().get().equals("Treasured Soul"));
			Assert.assertTrue(c.getNombre().get().equals("Locked Away"));
	}

    /**
     * Prueba unitaria para {@link Cancion#getCompositor}.
     */
	@Test public void testGetCompositor(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getCompositor().get().equals("Elefante"));
			Assert.assertTrue(b.getCompositor().get().equals("Michael Calfan"));
			Assert.assertTrue(c.getCompositor().get().equals("Theron Thomas"));
	}

    /**
     * Prueba unitaria para {@link Cancion#getGenero}.
     */
	@Test public void testGetGenero(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getGenero().get().equals("Latin"));
			Assert.assertTrue(b.getGenero().get().equals("Dance"));
			Assert.assertTrue(c.getGenero().get().equals("Reggae;Pop"));
	}

    /**
     * Prueba unitaria para {@link Cancion#getAno}.
     */
	@Test public void testGetAno(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getAno().get() == 2009);
			Assert.assertTrue(b.getAno().get() == 2015);
			Assert.assertTrue(c.getAno().get() == 2015);
	}

    /**
     * Prueba unitaria para {@link Cancion#getCalificacion}.
     */
	@Test public void testGetCalificacion(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getCalificacion().get() == 10);
			Assert.assertTrue(b.getCalificacion().get() == 9);
			Assert.assertTrue(c.getCalificacion().get() == 8);
	}

    /**
     * Prueba unitaria para {@link Cancion#getReproducciones}.
     */
	@Test public void testGetReproducciones(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getReproducciones().get() == 0);
			Assert.assertTrue(b.getReproducciones().get() == 0);
			Assert.assertTrue(c.getReproducciones().get() == 0);
	}

    /**
     * Prueba unitaria para {@link Cancion#getFechaIncl}.
     */
	@Test public void testGetFechaIncl(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getFechaIncl().get().equals("2015-10-22"));
			Assert.assertTrue(b.getFechaIncl().get().equals("2015-01-01"));
			Assert.assertTrue(c.getFechaIncl().get().equals("2015-08-30"));
	}

    /**
     * Prueba unitaria para {@link Cancion#getUbicacion}.
     */
	@Test public void testGetUbicacion(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getUbicacion().get().equals("Local"));
			Assert.assertTrue(b.getUbicacion().get().equals("Local"));
			Assert.assertTrue(c.getUbicacion().get().equals("Local"));
	}

    /**
     * Prueba unitaria para {@link Cancion#getRuta}.
     */
	@Test public void testGetRuta(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getRuta().get().equals("C:/angel.mp3"));
			Assert.assertTrue(b.getRuta().get().equals("C:/ts.mp3"));
			Assert.assertTrue(c.getRuta().get().equals("C:/la.mp3"));
	}

    /**
     * Prueba unitaria para {@link Cancion#getInterprete}.
     */
	@Test public void testGetInterprete(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getInterprete().get().equals("Elefante"));
			Assert.assertTrue(b.getInterprete().get().equals("Michael Calfan"));
			Assert.assertTrue(c.getInterprete().get().equals("R. City;Adam Levine"));
	}

    /**
     * Prueba unitaria para {@link Cancion#getAlbum}.
     */
	@Test public void testGetAlbum(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getAlbum().get().equals("Exitos"));
			Assert.assertTrue(b.getAlbum().get().equals("Sencillo"));
			Assert.assertTrue(c.getAlbum().get().equals("Sencillo"));
	}

    /**
     * Prueba unitaria para {@link Cancion#getPista}.
     */
	@Test public void testGetPista(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getPista().get() == 2);
			Assert.assertTrue(b.getPista().get() == 0);
			Assert.assertTrue(c.getPista().get() == 0);
	}

    /**
     * Prueba unitaria para {@link Cancion#getDisco}.
     */
	@Test public void testGetDisco(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getDisco().get() == 1);
			Assert.assertTrue(b.getDisco().get() == 0);
			Assert.assertTrue(c.getDisco().get() == 0);
	}

    /**
     * Prueba unitaria para {@link Cancion#setInter}.
     */
	@Test public void testSetInter(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			a.setInter("setInter1");
			b.setInter("setInter2");
			c.setInter("setInter3");
			Assert.assertTrue(a.getInterprete().get().equals("setInter1"));
			Assert.assertTrue(b.getInterprete().get().equals("setInter2"));
			Assert.assertTrue(c.getInterprete().get().equals("setInter3"));
	}

    /**
     * Prueba unitaria para {@link Cancion#setAlbum}.
     */
	@Test public void testSetAlbum(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			a.setAlbum("setAlbum1");
			b.setAlbum("setAlbum2");
			c.setAlbum("setAlbum3");
			Assert.assertTrue(a.getAlbum().get().equals("setAlbum1"));
			Assert.assertTrue(b.getAlbum().get().equals("setAlbum2"));
			Assert.assertTrue(c.getAlbum().get().equals("setAlbum3"));
	}

    /**
     * Prueba unitaria para {@link Cancion#setNumPi}.
     */
	@Test public void testSetNumPi(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			a.setNumPi(51);
			b.setNumPi(75);
			c.setNumPi(12);
			Assert.assertTrue(a.getPista().get() == 51);
			Assert.assertTrue(b.getPista().get() == 75);
			Assert.assertTrue(c.getPista().get() == 12);
	}

    /**
     * Prueba unitaria para {@link Cancion#setNumDi}.
     */
	@Test public void testSetNumDi(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			a.setNumDi(71);
			b.setNumDi(35);
			c.setNumDi(94);
			Assert.assertTrue(a.getDisco().get() == 71);
			Assert.assertTrue(b.getDisco().get() == 35);
			Assert.assertTrue(c.getDisco().get() == 94);
	}

    /**
     * Prueba unitaria para {@link Cancion#getSNombre}.
     */
	@Test public void testGetSNombre(){
			Cancion a = new Cancion("Ángel", "Elefante", "Latin", 2009, 10, 0, "2015-10-22", "Local", "C:/angel.mp3", "Elefante", "Exitos", 2, 1);
			Cancion b = new Cancion("Treasured Soul", "Michael Calfan", "Dance", 2015, 9, 0, "2015-01-01", "Local", "C:/ts.mp3", "Michael Calfan", "Sencillo", 0, 0);
			Cancion c = new Cancion("Locked Away", "Theron Thomas", "Reggae;Pop", 2015, 8, 0, "2015-08-30", "Local", "C:/la.mp3", "R. City;Adam Levine", "Sencillo", 0, 0);
			Assert.assertTrue(a.getSNombre().equals("Ángel"));
			Assert.assertTrue(b.getSNombre().equals("Treasured Soul"));
			Assert.assertTrue(c.getSNombre().equals("Locked Away"));
	}

}
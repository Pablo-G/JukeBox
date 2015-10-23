/**
 *Clase <code>TestBanda</code>.
 *Clase para pruebas unitarias de la clase {@link Banda}.
 *@author <a href="mailto:pablo.t645@hotmail.com">Pablo G.</a>
 *@version 1.0
 *Copyright 2015 Pablo G.
 */
package JukeBox.test;

import org.junit.Assert;
import org.junit.Test;
import JukeBox.Banda;

public class TestBanda{

    /**
     * Prueba unitaria para {@link Banda#Banda}.
     */
	@Test public void testConstructor(){
		try{
			Banda a = new Banda("Simple Plan", "C:/sp.jpg", "CA | 1999 | 5 Members | Pop Punk");
			Banda b = new Banda("Atlas Genius", "C:/ag.jpg", "AU | 2009 | 2 Members | Alternative Rock");
			Banda c = new Banda("The Black Eyed Peas", "C:/tbep.jpg", "US | 1992 | 4 Members | Hip hop");
			Assert.assertTrue(true);
		}catch(Exception e){
			Assert.fail();
		}
	}

    /**
     * Prueba unitaria para {@link Banda#getNombre}.
     */
	@Test public void testGetNombre(){
			Banda a = new Banda("Simple Plan", "C:/sp.jpg", "CA | 1999 | 5 Members | Pop Punk");
			Banda b = new Banda("Atlas Genius", "C:/ag.jpg", "AU | 2009 | 2 Members | Alternative Rock");
			Banda c = new Banda("The Black Eyed Peas", "C:/tbep.jpg", "US | 1992 | 4 Members | Hip hop");
			Assert.assertTrue(a.getNombre().get().equals("Simple Plan"));
			Assert.assertTrue(b.getNombre().get().equals("Atlas Genius"));
			Assert.assertTrue(c.getNombre().get().equals("The Black Eyed Peas"));	
	}

    /**
     * Prueba unitaria para {@link Banda#getIlustracion}.
     */
	@Test public void testGetIlustracion(){
			Banda a = new Banda("Simple Plan", "C:/sp.jpg", "CA | 1999 | 5 Members | Pop Punk");
			Banda b = new Banda("Atlas Genius", "C:/ag.jpg", "AU | 2009 | 2 Members | Alternative Rock");
			Banda c = new Banda("The Black Eyed Peas", "C:/tbep.jpg", "US | 1992 | 4 Members | Hip hop");
			Assert.assertTrue(a.getIlustracion().get().equals("C:/sp.jpg"));
			Assert.assertTrue(b.getIlustracion().get().equals("C:/ag.jpg"));
			Assert.assertTrue(c.getIlustracion().get().equals("C:/tbep.jpg"));	
	}

    /**
     * Prueba unitaria para {@link Banda#getBiografia}.
     */
	@Test public void testGetBiografia(){
			Banda a = new Banda("Simple Plan", "C:/sp.jpg", "CA | 1999 | 5 Members | Pop Punk");
			Banda b = new Banda("Atlas Genius", "C:/ag.jpg", "AU | 2009 | 2 Members | Alternative Rock");
			Banda c = new Banda("The Black Eyed Peas", "C:/tbep.jpg", "US | 1992 | 4 Members | Hip hop");
			Assert.assertTrue(a.getBiografia().get().equals("CA | 1999 | 5 Members | Pop Punk"));
			Assert.assertTrue(b.getBiografia().get().equals("AU | 2009 | 2 Members | Alternative Rock"));
			Assert.assertTrue(c.getBiografia().get().equals("US | 1992 | 4 Members | Hip hop"));	
	}

}
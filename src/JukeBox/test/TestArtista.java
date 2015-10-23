/**
 *Clase <code>TestArtista</code>.
 *Clase para pruebas unitarias de la clase {@link Artista}.
 *@author <a href="mailto:pablo.t645@hotmail.com">Pablo G.</a>
 *@version 1.0
 *Copyright 2015 Pablo G.
 */
package JukeBox.test;

import org.junit.Assert;
import org.junit.Test;
import JukeBox.Artista;

public class TestArtista{

    /**
     * Prueba unitaria para {@link Artista#Artista}.
     */
	@Test public void testConstructor(){
		try{
			Artista a = new Artista("Adam Levine", "C:/al.jpg", "US | 1979", "Maroon 5");
			Artista b = new Artista("Robin Thicke", "C:/rt.jpg", "US | 1977", "-");
			Artista c = new Artista("Chris Martin", "C:/cm.jpg", "EN | 1977", "Coldplay");
			Assert.assertTrue(true);
		}catch(Exception e){
			Assert.fail();
		}
	}

    /**
     * Prueba unitaria para {@link Artista#getNombre}.
     */
	@Test public void testGetNombre(){
			Artista a = new Artista("Adam Levine", "C:/al.jpg", "US | 1979", "Maroon 5");
			Artista b = new Artista("Robin Thicke", "C:/rt.jpg", "US | 1977", "-");
			Artista c = new Artista("Chris Martin", "C:/cm.jpg", "EN | 1977", "Coldplay");
			Assert.assertTrue(a.getNombre().get().equals("Adam Levine"));
			Assert.assertTrue(b.getNombre().get().equals("Robin Thicke"));
			Assert.assertTrue(c.getNombre().get().equals("Chris Martin"));
	}

    /**
     * Prueba unitaria para {@link Artista#getIlustracion}.
     */
	@Test public void testGetIlustracion(){
			Artista a = new Artista("Adam Levine", "C:/al.jpg", "US | 1979", "Maroon 5");
			Artista b = new Artista("Robin Thicke", "C:/rt.jpg", "US | 1977", "-");
			Artista c = new Artista("Chris Martin", "C:/cm.jpg", "EN | 1977", "Coldplay");
			Assert.assertTrue(a.getIlustracion().get().equals("C:/al.jpg"));
			Assert.assertTrue(b.getIlustracion().get().equals("C:/rt.jpg"));
			Assert.assertTrue(c.getIlustracion().get().equals("C:/cm.jpg"));
	}

    /**
     * Prueba unitaria para {@link Artista#getBiografia}.
     */
	@Test public void testGetBiografia(){
			Artista a = new Artista("Adam Levine", "C:/al.jpg", "US | 1979", "Maroon 5");
			Artista b = new Artista("Robin Thicke", "C:/rt.jpg", "US | 1977", "-");
			Artista c = new Artista("Chris Martin", "C:/cm.jpg", "EN | 1977", "Coldplay");
			Assert.assertTrue(a.getBiografia().get().equals("US | 1979"));
			Assert.assertTrue(b.getBiografia().get().equals("US | 1977"));
			Assert.assertTrue(c.getBiografia().get().equals("EN | 1977"));
	}

    /**
     * Prueba unitaria para {@link Artista#getIntegrant}.
     */
	@Test public void testGetIntegrant(){
			Artista a = new Artista("Adam Levine", "C:/al.jpg", "US | 1979", "Maroon 5");
			Artista b = new Artista("Robin Thicke", "C:/rt.jpg", "US | 1977", "");
			Artista c = new Artista("Chris Martin", "C:/cm.jpg", "EN | 1977", "Coldplay");
			Assert.assertTrue(a.getIntegrant().get().equals("Maroon 5"));
			Assert.assertTrue(b.getIntegrant().get().equals(""));
			Assert.assertTrue(c.getIntegrant().get().equals("Coldplay"));
	}

    /**
     * Prueba unitaria para {@link Artista#getSNombre}.
     */
	@Test public void testGetSNombre(){
			Artista a = new Artista("Adam Levine", "C:/al.jpg", "US | 1979", "Maroon 5");
			Artista b = new Artista("Robin Thicke", "C:/rt.jpg", "US | 1977", "-");
			Artista c = new Artista("Chris Martin", "C:/cm.jpg", "EN | 1977", "Coldplay");
			Assert.assertTrue(a.getSNombre().equals("Adam Levine"));
			Assert.assertTrue(b.getSNombre().equals("Robin Thicke"));
			Assert.assertTrue(c.getSNombre().equals("Chris Martin"));
	}

    /**
     * Prueba unitaria para {@link Artista#setIntegrant}.
     */
	@Test public void testSetIntegrant(){
			Artista a = new Artista("Adam Levine", "C:/al.jpg", "US | 1979", "Maroon 5");
			Artista b = new Artista("Robin Thicke", "C:/rt.jpg", "US | 1977", "-");
			Artista c = new Artista("Chris Martin", "C:/cm.jpg", "EN | 1977", "Coldplay");
			a.setIntegrant("setIntegrant1");
			b.setIntegrant("setIntegrant2");
			c.setIntegrant("setIntegrant3");
			Assert.assertTrue(a.getIntegrant().get().equals("setIntegrant1"));
			Assert.assertTrue(b.getIntegrant().get().equals("setIntegrant2"));
			Assert.assertTrue(c.getIntegrant().get().equals("setIntegrant3"));
	}

}
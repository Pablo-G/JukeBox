package JukeBox.test;

import org.junit.Assert;
import org.junit.Test;
import JukeBox.Banda;

public class TestBanda{

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

	@Test public void testGetNombre(){
			Banda a = new Banda("Simple Plan", "C:/sp.jpg", "CA | 1999 | 5 Members | Pop Punk");
			Banda b = new Banda("Atlas Genius", "C:/ag.jpg", "AU | 2009 | 2 Members | Alternative Rock");
			Banda c = new Banda("The Black Eyed Peas", "C:/tbep.jpg", "US | 1992 | 4 Members | Hip hop");
			Assert.assertTrue(a.getNombre().get().equals("Simple Plan"));
			Assert.assertTrue(b.getNombre().get().equals("Atlas Genius"));
			Assert.assertTrue(c.getNombre().get().equals("The Black Eyed Peas"));	
	}

	@Test public void testGetIlustracion(){
			Banda a = new Banda("Simple Plan", "C:/sp.jpg", "CA | 1999 | 5 Members | Pop Punk");
			Banda b = new Banda("Atlas Genius", "C:/ag.jpg", "AU | 2009 | 2 Members | Alternative Rock");
			Banda c = new Banda("The Black Eyed Peas", "C:/tbep.jpg", "US | 1992 | 4 Members | Hip hop");
			Assert.assertTrue(a.getIlustracion().get().equals("C:/sp.jpg"));
			Assert.assertTrue(b.getIlustracion().get().equals("C:/ag.jpg"));
			Assert.assertTrue(c.getIlustracion().get().equals("C:/tbep.jpg"));	
	}

	@Test public void testGetBiografia(){
			Banda a = new Banda("Simple Plan", "C:/sp.jpg", "CA | 1999 | 5 Members | Pop Punk");
			Banda b = new Banda("Atlas Genius", "C:/ag.jpg", "AU | 2009 | 2 Members | Alternative Rock");
			Banda c = new Banda("The Black Eyed Peas", "C:/tbep.jpg", "US | 1992 | 4 Members | Hip hop");
			Assert.assertTrue(a.getBiografia().get().equals("CA | 1999 | 5 Members | Pop Punk"));
			Assert.assertTrue(b.getBiografia().get().equals("AU | 2009 | 2 Members | Alternative Rock"));
			Assert.assertTrue(c.getBiografia().get().equals("US | 1992 | 4 Members | Hip hop"));	
	}

}
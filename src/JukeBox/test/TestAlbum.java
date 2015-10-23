package JukeBox.test;

import org.junit.Assert;
import org.junit.Test;
import JukeBox.Album;

public class TestAlbum{

	@Test public void testConstructor(){
		try{
			Album a = new Album("G I R L", "Pharrell Williams", 2014, 1, 10, "C:/girl.jpg");
			Album b = new Album("Handwritten", "Shawn Mendes", 2015, 1, 12, "C:/hw.jpg");
			Album c = new Album("Partie Traumatic", "Black Kids", 2008, 1, 10, "C:/pt.jpg");
			Assert.assertTrue(true);
		}catch(Exception e){
			Assert.fail();
		}
	}

	@Test public void testGetNombre(){
			Album a = new Album("G I R L", "Pharrell Williams", 2014, 1, 10, "C:/girl.jpg");
			Album b = new Album("Handwritten", "Shawn Mendes", 2015, 1, 12, "C:/hw.jpg");
			Album c = new Album("Partie Traumatic", "Black Kids", 2008, 1, 10, "C:/pt.jpg");
			Assert.assertTrue(a.getNombre().get().equals("G I R L"));
			Assert.assertTrue(b.getNombre().get().equals("Handwritten"));
			Assert.assertTrue(c.getNombre().get().equals("Partie Traumatic"));
	}

	@Test public void testGetArtista(){
			Album a = new Album("G I R L", "Pharrell Williams", 2014, 1, 10, "C:/girl.jpg");
			Album b = new Album("Handwritten", "Shawn Mendes", 2015, 1, 12, "C:/hw.jpg");
			Album c = new Album("Partie Traumatic", "Black Kids", 2008, 1, 10, "C:/pt.jpg");
			Assert.assertTrue(a.getArtista().get().equals("Pharrell Williams"));
			Assert.assertTrue(b.getArtista().get().equals("Shawn Mendes"));
			Assert.assertTrue(c.getArtista().get().equals("Black Kids"));
	}

	@Test public void testGetAno(){
			Album a = new Album("G I R L", "Pharrell Williams", 2014, 1, 10, "C:/girl.jpg");
			Album b = new Album("Handwritten", "Shawn Mendes", 2015, 1, 12, "C:/hw.jpg");
			Album c = new Album("Partie Traumatic", "Black Kids", 2008, 1, 10, "C:/pt.jpg");
			Assert.assertTrue(a.getAno().get() == 2014);
			Assert.assertTrue(b.getAno().get() == 2015);
			Assert.assertTrue(c.getAno().get() == 2008);
	}

	@Test public void testGetNumdis(){
			Album a = new Album("G I R L", "Pharrell Williams", 2014, 1, 10, "C:/girl.jpg");
			Album b = new Album("Handwritten", "Shawn Mendes", 2015, 1, 12, "C:/hw.jpg");
			Album c = new Album("Partie Traumatic", "Black Kids", 2008, 1, 10, "C:/pt.jpg");
			Assert.assertTrue(a.getNumdis().get() == 1);
			Assert.assertTrue(b.getNumdis().get() == 1);
			Assert.assertTrue(c.getNumdis().get() == 1);
	}

	@Test public void testGetNumcan(){
			Album a = new Album("G I R L", "Pharrell Williams", 2014, 1, 10, "C:/girl.jpg");
			Album b = new Album("Handwritten", "Shawn Mendes", 2015, 1, 12, "C:/hw.jpg");
			Album c = new Album("Partie Traumatic", "Black Kids", 2008, 1, 10, "C:/pt.jpg");
			Assert.assertTrue(a.getNumcan().get() == 10);
			Assert.assertTrue(b.getNumcan().get() == 12);
			Assert.assertTrue(c.getNumcan().get() == 10);
	}

	@Test public void testGetIlustra(){
			Album a = new Album("G I R L", "Pharrell Williams", 2014, 1, 10, "C:/girl.jpg");
			Album b = new Album("Handwritten", "Shawn Mendes", 2015, 1, 12, "C:/hw.jpg");
			Album c = new Album("Partie Traumatic", "Black Kids", 2008, 1, 10, "C:/pt.jpg");
			Assert.assertTrue(a.getIlustra().get().equals("C:/girl.jpg"));
			Assert.assertTrue(b.getIlustra().get().equals("C:/hw.jpg"));
			Assert.assertTrue(c.getIlustra().get().equals("C:/pt.jpg"));
	}

	@Test public void testGetSNombre(){
			Album a = new Album("G I R L", "Pharrell Williams", 2014, 1, 10, "C:/girl.jpg");
			Album b = new Album("Handwritten", "Shawn Mendes", 2015, 1, 12, "C:/hw.jpg");
			Album c = new Album("Partie Traumatic", "Black Kids", 2008, 1, 10, "C:/pt.jpg");
			Assert.assertTrue(a.getSNombre().equals("G I R L"));
			Assert.assertTrue(b.getSNombre().equals("Handwritten"));
			Assert.assertTrue(c.getSNombre().equals("Partie Traumatic"));
	}

	@Test public void testSetArtist(){
			Album a = new Album("G I R L", "Pharrell Williams", 2014, 1, 10, "C:/girl.jpg");
			Album b = new Album("Handwritten", "Shawn Mendes", 2015, 1, 12, "C:/hw.jpg");
			Album c = new Album("Partie Traumatic", "Black Kids", 2008, 1, 10, "C:/pt.jpg");
			a.setArtist("setArtist1");
			b.setArtist("setArtist2");
			c.setArtist("setArtist3");
			Assert.assertTrue(a.getArtista().get().equals("setArtist1"));
			Assert.assertTrue(b.getArtista().get().equals("setArtist2"));
			Assert.assertTrue(c.getArtista().get().equals("setArtist3"));
	}

}
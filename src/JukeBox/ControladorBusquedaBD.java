package JukeBox;

import java.sql.*;
import java.io.File;
import java.util.LinkedList;

public class ControladorBusquedaBD implements Runnable {

	private Connection conect;
    private Statement statem;
    private LinkedList listaSinc;
	private String tipo;
	private String criterio;

    public ControladorBusquedaBD(LinkedList<LinkedList> listaSinc, String tipo, String criterio) throws Exception{
		try{
			File archivoPrincipal = new File(System.getProperty("user.home") + "/JukeBox/MiMusica.db");
	    	Class.forName("org.sqlite.JDBC");
	    	conect = DriverManager.getConnection("jdbc:sqlite:" + archivoPrincipal);
		    conect.setAutoCommit(false);
		    statem = conect.createStatement();
		    this.listaSinc = listaSinc;
		    this.tipo = tipo;
		    this.criterio = criterio;
	    }catch(Exception e){
	    	File archivoPrincipal = new File(System.getProperty("user.home") + "/JukeBox/MiMusica.db");
	    	throw new Exception("No se pudo acceder a la base de datos.\nVerifique que JukeBox tiene privilegios de accceso a " + archivoPrincipal);
	    }
	}

	@SuppressWarnings("unchecked") @Override public void run(){
		try{
			switch(tipo){
				case "Cancion":{
					try{
						listaSinc.add(buscaCanciones(criterio));
						synchronized(listaSinc){
							listaSinc.notify();
						}
					}catch(Exception e){
						//Inalcanzable
					}
					break;
				}
				case "Album":{
					try{
						listaSinc.add(buscaAlbumes(criterio));
						synchronized(listaSinc){
							listaSinc.notify();
						}
					}catch(Exception e){
						//Inalcanzable
					}
					break;
				}
				case "Banda":{
					try{
						listaSinc.add(buscaBandas(criterio));
						synchronized(listaSinc){
							listaSinc.notify();
						}
					}catch(Exception e){
						//Inalcanzable
					}
					break;
				}
				case "Artista":{
					try{
						listaSinc.add(buscaArtistas(criterio));
						synchronized(listaSinc){
							listaSinc.notify();
						}
					}catch(Exception e){
						//Inalcanzable
					}
					break;
				}
			}
		}
		finally{
			try{
		    	statem.close();
		    	conect.close();
	    	}catch(Exception e){
	    		//Inalcanzable
	    	}
		}
	}

	private LinkedList<Cancion> buscaCanciones(String like) throws Exception{
		LinkedList<Cancion> lista = new LinkedList<Cancion>();
		ResultSet rs = statem.executeQuery("SELECT * FROM Canciones WHERE Nombre LIKE '%" + like + "%';");
		while (rs.next()) {
	        	String nombre = rs.getString("Nombre");
	        	String compositor = rs.getString("Compositor");
	        	String genero = rs.getString("Genero");
	        	int ano = rs.getInt("Ano");
	        	int calificacion = rs.getInt("Calificacion");
	        	int reproducciones = rs.getInt("Reproducciones");
	        	String  fechaIncl = rs.getString("FechaIncl");
	        	String  ubicacion = rs.getString("Ubicacion");
	        	String  ruta = rs.getString("Ruta");
	        Cancion c = new Cancion(nombre,compositor,genero,ano,calificacion,reproducciones,fechaIncl,ubicacion,ruta,"","",0,0);
	        lista.add(c);
	    }
	    rs.close();
	    for (Cancion c: lista) {
	    	rs = statem.executeQuery("SELECT * FROM InterpretadaPor WHERE CancionNombre LIKE '" + c.getSNombre() + "';");
	        String inter = "";
			while (rs.next()) {
	        	inter = inter + rs.getString("ArtistaNombre") + "; ";
	        }
	        c.setInter(inter);
	    	rs.close();
	    }
	    for (Cancion c: lista) {
	    	rs = statem.executeQuery("SELECT * FROM PerteneceA WHERE CancionNombre LIKE '" + c.getSNombre() + "';");
			while (rs.next()) {
	        	c.setAlbum(rs.getString("AlbumNombre"));
	        	c.setNumPi(rs.getInt("NumPista"));
	        	c.setNumDi(rs.getInt("NumDisco"));
	        }
	    	rs.close();
	    }
	    return lista;
	}

	private LinkedList<Album> buscaAlbumes(String like) throws Exception{
		LinkedList<Album> lista = new LinkedList<Album>();
		ResultSet rs = statem.executeQuery("SELECT * FROM Albumes WHERE Nombre LIKE '%" + like + "%';");
		while (rs.next()) {
	        	String nombre = rs.getString("Nombre");
	        	int ano = rs.getInt("Ano");
	        	int numdis = rs.getInt("NumDiscos");
	        	int numcan = rs.getInt("NumCanciones");
	        	String ilustra = rs.getString("Ilustracion");
	        Album a = new Album(nombre,"",ano,numdis,numcan,ilustra);
	        lista.add(a);
	    }
	    rs.close();
	   	for (Album b: lista) {
	    	rs = statem.executeQuery("SELECT * FROM AlbumDe WHERE AlbumNombre LIKE '" + b.getSNombre() + "';");
			while (rs.next()) {
	        	b.setArtist(rs.getString("ArtistasNombre"));
	        }
	    	rs.close();
	    }
	    return lista;
	}

	private LinkedList<Banda> buscaBandas(String like) throws Exception{
		LinkedList<Banda> lista = new LinkedList<Banda>();
		ResultSet rs = statem.executeQuery("SELECT * FROM Bandas WHERE Nombre LIKE '%" + like + "%';");
		while (rs.next()) {
	        	String nombre = rs.getString("Nombre");
	        	String ilustra = rs.getString("Ilustracion");
	        	String biografia = rs.getString("Biografia");
	        Banda b = new Banda(nombre,ilustra,biografia);
	        lista.add(b);
	    }
	    rs.close();
	    return lista;
	}

	private LinkedList<Artista> buscaArtistas(String like) throws Exception{
		LinkedList<Artista> lista = new LinkedList<Artista>();
		ResultSet rs = statem.executeQuery("SELECT * FROM Artistas WHERE Nombre LIKE '%" + like + "%';");
		while (rs.next()) {
	        	String nombre = rs.getString("Nombre");
	        	String ilustra = rs.getString("Ilustracion");
	        	String biografia = rs.getString("Biografia");
	        Artista a = new Artista(nombre,ilustra,biografia,"");
	        lista.add(a);
	    }
	    rs.close();
	    for (Artista a: lista) {
	    	rs = statem.executeQuery("SELECT * FROM IntegranteDe WHERE ArtistaNombre LIKE '" + a.getSNombre() + "';");
			String inteD = "";
			while (rs.next()) {
				inteD = inteD + rs.getString("BandaNombre") + "; ";
	        }
	        a.setIntegrant(inteD);
	    	rs.close();
	    }
	    return lista;
	}

}
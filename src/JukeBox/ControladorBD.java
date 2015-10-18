package JukeBox;

import java.sql.*;
import java.io.File;

public class ControladorBD{
	
	Connection conect;
    Statement statem;

	public ControladorBD() throws Exception{

		File carpetaPrincipal = new File(System.getProperty("user.home") + "/JukeBox");
		if (!carpetaPrincipal.isDirectory()) {
			carpetaPrincipal.mkdir();
		}

		File archivoPrincipal = new File(System.getProperty("user.home") + "/JukeBox/MiMusica.db");
		boolean existiaArchivoPrincipal = archivoPrincipal.isFile();

		try{
	    	Class.forName("org.sqlite.JDBC");
	    	conect = DriverManager.getConnection("jdbc:sqlite:" + carpetaPrincipal + "/MiMusica.db");
	    }catch(Exception e){
	    	throw new Exception("No se pudo acceder a la base de datos.\nVerifique que JukeBox tiene privilegios de accceso a " + carpetaPrincipal + "/MiMusica.db");
	    }

	    if (!existiaArchivoPrincipal) {
	    	statem = conect.createStatement();
	    	String sql = "CREATE TABLE Canciones" +
                   "(Nombre          TEXT  PRIMARY KEY  NOT NULL," +
                   " Compositor      TEXT               NOT NULL," + 
                   " Genero          TEXT               NOT NULL," + 
                   " Ano             INT                NOT NULL," + 
                   " Calificacion    INT                NOT NULL," + 
                   " Reproducciones  INT                NOT NULL," + 
                   " FechaIncl       DATE               NOT NULL," + 
                   " Ubicacion       TEXT               NOT NULL," + 
                   " Ruta            TEXT               NOT NULL)"; 
      		statem.executeUpdate(sql);
	    	sql = "CREATE TABLE Albumes" +
                   "(Nombre          TEXT  PRIMARY KEY  NOT NULL," +
                   " Ano             INT                NOT NULL," + 
                   " NumDiscos       INT                NOT NULL," + 
                   " NumCanciones    INT                NOT NULL," + 
                   " Ilustracion     TEXT               NOT NULL)"; 
      		statem.executeUpdate(sql);
      		sql = "CREATE TABLE Artistas" +
                   "(Nombre          TEXT  PRIMARY KEY  NOT NULL," +
                   " Ilustracion     TEXT               NOT NULL," + 
                   " Biografia       TEXT               NOT NULL)"; 
      		statem.executeUpdate(sql);
      		sql = "CREATE TABLE Bandas" +
                   "(Nombre          TEXT  PRIMARY KEY  NOT NULL," +
                   " Ilustracion     TEXT               NOT NULL," + 
                   " Biografia       TEXT               NOT NULL)"; 
      		statem.executeUpdate(sql);
      		sql = "CREATE TABLE IntegranteDe" +
                   "(ArtistaNombre   TEXT  NOT NULL," +
                   " BandaNombre     TEXT  NOT NULL, " +
                   " FOREIGN KEY(ArtistaNombre) REFERENCES Artistas(Nombre)" +	
                   " FOREIGN KEY(BandaNombre) REFERENCES Bandas(Nombre))"; 
      		statem.executeUpdate(sql);
      		sql = "CREATE TABLE InterpretadaPor" +
                   "(CancionNombre   TEXT  NOT NULL," +
                   " ArtistaNombre   TEXT  NOT NULL, " +
                   " FOREIGN KEY(CancionNombre) REFERENCES Canciones(Nombre)" +	
                   " FOREIGN KEY(ArtistaNombre) REFERENCES Artistas(Nombre))"; 
      		statem.executeUpdate(sql);
      		sql = "CREATE TABLE AlbumDe" +
                   "(AlbumNombre   TEXT  NOT NULL," +
                   " ArtistasNombre     TEXT  NOT NULL, " +
                   " FOREIGN KEY(AlbumNombre) REFERENCES Albumes(Nombre)" +	
                   " FOREIGN KEY(ArtistasNombre) REFERENCES Artistas(Nombre))"; 
      		statem.executeUpdate(sql);
      		sql = "CREATE TABLE PerteneceA" +
                   "(CancionNombre   TEXT  NOT NULL," +
                   " AlbumNombre     TEXT  NOT NULL, " +
                   " NumPista        INT                NOT NULL," + 
                   " NumDisco        INT                NOT NULL," + 
                   " FOREIGN KEY(CancionNombre) REFERENCES Canciones(Nombre)" +	
                   " FOREIGN KEY(AlbumNombre) REFERENCES Albumes(Nombre))"; 
      		statem.executeUpdate(sql);
	    }

	    conect.setAutoCommit(false);
	    statem = conect.createStatement();
	}

	public void agregaBanda(String nombre, String ilustr, String biogra) throws Exception{
		String sql = "INSERT INTO Bandas (Nombre,Ilustracion,Biografia) " +
        	"VALUES ('" + nombre + "', '" + ilustr + "', '" + biogra + "')"; 

	    statem.executeUpdate(sql);
	    conect.commit();

    	imprimeTablas();
	}

	public void agregaArtista(String nombre, String ilustr, String biogra, String inteDe) throws Exception{

		String sql = "INSERT INTO Artistas (Nombre,Ilustracion,Biografia) " +
        	"VALUES ('" + nombre + "', '" + ilustr + "', '" + biogra + "')"; 

	    statem.executeUpdate(sql);
	    conect.commit();

    	imprimeTablas();
	}

	public void imprimeTablas(){
		try{
			ResultSet rs = statem.executeQuery( "SELECT * FROM Canciones" );
	    	System.out.println("Canciones");
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
	        System.out.println( "Nombre = " + nombre );
	        System.out.println( "Compositor = " + compositor );
	        System.out.println( "Genero = " + genero );
	        System.out.println( "Ano = " + ano );
	        System.out.println( "Calificacion = " + calificacion );
	        System.out.println( "Reproducciones = " + reproducciones );
	        System.out.println( "FechaIncl = " + fechaIncl );
	        System.out.println( "Ubicacion = " + ubicacion );
	        System.out.println( "Ruta = " + ruta );
	        System.out.println();
	    	}
	    	rs.close();
	    	rs = statem.executeQuery( "SELECT * FROM Bandas" );
	    	System.out.println("Bandas");
	    	while (rs.next()) {
	        	String nombreb = rs.getString("Nombre");
	        	String ilustracion = rs.getString("Ilustracion");
	        	String biografia = rs.getString("Biografia");
	        System.out.println( "Nombre = " + nombreb );
	        System.out.println( "Ilustracion = " + ilustracion );
	        System.out.println( "Biografia = " + biografia );
	        System.out.println();
	    	}
	    	rs.close();
	    }catch(Exception e){
	    	System.err.println("No se pudo imprimir la BD!");
	    }
	}

}
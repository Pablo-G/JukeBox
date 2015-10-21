package JukeBox;

import java.sql.*;
import java.io.File;
import java.util.Calendar;

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
                   " FechaIncl       DATETIME           NOT NULL," + 
                   " Ubicacion       TEXT               NOT NULL," + 
                   " Ruta            TEXT               NOT NULL);"; 
      		statem.executeUpdate(sql);
	    	sql = "CREATE TABLE Albumes" +
                   "(Nombre          TEXT  PRIMARY KEY  NOT NULL," +
                   " Ano             INT                NOT NULL," + 
                   " NumDiscos       INT                NOT NULL," + 
                   " NumCanciones    INT                NOT NULL," + 
                   " Ilustracion     TEXT               NOT NULL);"; 
      		statem.executeUpdate(sql);
      		sql = "CREATE TABLE Artistas" +
                   "(Nombre          TEXT  PRIMARY KEY  NOT NULL," +
                   " Ilustracion     TEXT               NOT NULL," + 
                   " Biografia       TEXT               NOT NULL);"; 
      		statem.executeUpdate(sql);
      		sql = "CREATE TABLE Bandas" +
                   "(Nombre          TEXT  PRIMARY KEY  NOT NULL," +
                   " Ilustracion     TEXT               NOT NULL," + 
                   " Biografia       TEXT               NOT NULL);"; 
      		statem.executeUpdate(sql);
      		sql = "CREATE TABLE IntegranteDe" +
                   "(ArtistaNombre   TEXT  NOT NULL," +
                   " BandaNombre     TEXT  NOT NULL, " +
                   " FOREIGN KEY(ArtistaNombre) REFERENCES Artistas(Nombre)" +	
                   " FOREIGN KEY(BandaNombre) REFERENCES Bandas(Nombre));"; 
      		statem.executeUpdate(sql);
      		sql = "CREATE TABLE InterpretadaPor" +
                   "(CancionNombre   TEXT  NOT NULL," +
                   " ArtistaNombre   TEXT  NOT NULL, " +
                   " FOREIGN KEY(CancionNombre) REFERENCES Canciones(Nombre)" +	
                   " FOREIGN KEY(ArtistaNombre) REFERENCES Artistas(Nombre));"; 
      		statem.executeUpdate(sql);
      		sql = "CREATE TABLE AlbumDe" +
                   "(AlbumNombre   TEXT  NOT NULL," +
                   " ArtistasNombre     TEXT  NOT NULL, " +
                   " FOREIGN KEY(AlbumNombre) REFERENCES Albumes(Nombre)" +	
                   " FOREIGN KEY(ArtistasNombre) REFERENCES Artistas(Nombre));"; 
      		statem.executeUpdate(sql);
      		sql = "CREATE TABLE PerteneceA" +
                   "(CancionNombre   TEXT  NOT NULL," +
                   " AlbumNombre     TEXT  NOT NULL, " +
                   " NumPista        INT                NOT NULL," + 
                   " NumDisco        INT                NOT NULL," + 
                   " FOREIGN KEY(CancionNombre) REFERENCES Canciones(Nombre)" +	
                   " FOREIGN KEY(AlbumNombre) REFERENCES Albumes(Nombre));"; 
      		statem.executeUpdate(sql);
	    }

	    conect.setAutoCommit(false);
	    statem = conect.createStatement();
	}

	public void agregaBanda(String nombre, String ilustr, String biogra) throws Exception{
		String sql = "INSERT INTO Bandas (Nombre,Ilustracion,Biografia) " +
        	"VALUES ('" + nombre + "', '" + ilustr + "', '" + biogra + "');"; 

        try{
	    	statem.executeUpdate(sql);
	    }catch(Exception e){
	    	throw new Exception(nombre + " ya se encuentra registrado en la Base de Datos!");
	    }
	    conect.commit();

    	imprimeTablas();
	}

	public void agregaArtista(String nombre, String ilustr, String biogra, String inteDe) throws Exception{

		String[] inteDeA;
		if (!inteDe.equals("")) {
	    	inteDeA = inteDe.split(";");
		}else{
			inteDeA = new String[0];
		}

	    for (String s : inteDeA) {
	    	ResultSet rs = statem.executeQuery("SELECT Nombre FROM Bandas WHERE Nombre LIKE '" + s + "';");
	    	if(!rs.next()){
	    		throw new Exception(s + " no ha sido registrado en la Base de Datos!");
	    	}
	    	rs.close();
	    }

		String sql = "INSERT INTO Artistas (Nombre,Ilustracion,Biografia) " +
        	"VALUES ('" + nombre + "', '" + ilustr + "', '" + biogra + "');"; 

       	try{
	    	statem.executeUpdate(sql);
	    }catch(Exception e){
	    		throw new Exception(nombre + " ya se encuentra registrado en la Base de Datos!");
	    }
	    conect.commit();

	    for (String s : inteDeA) {
			sql = "INSERT INTO IntegranteDe (ArtistaNombre,BandaNombre) " +
	        	"VALUES ('" + nombre + "', '" + s + "')"; 
		    statem.executeUpdate(sql);
		    conect.commit();    	
	    }

    	imprimeTablas();
	}

	public void agregaAlbum(String nombre, String ilustr, String interp, int ano, int dis, boolean artist) throws Exception{

		if (artist) {
	    	ResultSet rs = statem.executeQuery("SELECT Nombre FROM Artistas WHERE Nombre LIKE '" + interp + "';");
	    	if(!rs.next()){
	    		throw new Exception(interp + " no ha sido registrado en la Base de Datos!");
	    	}
	    	rs.close();			
		}else{
	    	ResultSet rs = statem.executeQuery("SELECT Nombre FROM Bandas WHERE Nombre LIKE '" + interp + "';");
	    	if(!rs.next()){
	    		throw new Exception(interp + " no ha sido registrado en la Base de Datos!");
	    	}
	    	rs.close();				
		}


		String sql = "INSERT INTO Albumes (Nombre,Ano,NumDiscos,NumCanciones,Ilustracion) " +
        	"VALUES ('" + nombre + "', " + ano + ", " + dis + ", 0, '" +  ilustr + "');"; 

       	try{
	    	statem.executeUpdate(sql);
	    }catch(Exception e){
	    		throw new Exception(nombre + " ya se encuentra registrado en la Base de Datos!");
	    }
	    conect.commit();

		sql = "INSERT INTO AlbumDe (AlbumNombre,ArtistasNombre) " +
	    	"VALUES ('" + nombre + "', '" + interp + "')"; 
		statem.executeUpdate(sql);
		conect.commit();    	

    	imprimeTablas();
	}

	public void agregaCancion(String nombre, String album, 
    						  String inteDe, String compo,
    						  String genero, int ano,
    						  int califi, int pista,
    						  int disco , boolean sencillo,
    						  String ubica ) throws Exception{
		Calendar calen = Calendar.getInstance();
		String fechaIncl = "'" + calen.YEAR + "-" + calen.MONTH + "-" + calen.DAY_OF_MONTH + " " + calen.HOUR_OF_DAY + ":" + calen.MINUTE + ":00'";

	    String[] inteDeC = inteDe.split(";");

	    for (String s : inteDeC) {
	    	ResultSet rsa = statem.executeQuery("SELECT Nombre FROM Artistas WHERE Nombre LIKE '" + s + "';");
	    	boolean brsa = rsa.next();
	    	rsa.close();
	    	ResultSet rsb = statem.executeQuery("SELECT Nombre FROM Bandas WHERE Nombre LIKE '" + s + "';");
	    	boolean brsb = rsb.next();
	    	rsb.close();

	    	if(!(brsa || brsb)){
	    		throw new Exception(s + " no ha sido registrado en la Base de Datos!");
	    	}
	    }

		if (!sencillo) {
	    	ResultSet rs = statem.executeQuery("SELECT Nombre FROM Albumes WHERE Nombre LIKE '" + album + "';");
	    	if(!rs.next()){
	    		throw new Exception(album + " no ha sido registrado en la Base de Datos!");
	    	}
	    	rs.close();	
		}

		String sql = "INSERT INTO Canciones (Nombre,Compositor,Genero,Ano,Calificacion,Reproducciones,FechaIncl,Ubicacion,Ruta) " +
        	"VALUES ('" + nombre + "', '" + compo + "', '" + genero + "', " + ano + ", " + califi + ", 0, " + fechaIncl + ", 'Local', '" + ubica + "');";

       	try{
	    	statem.executeUpdate(sql);
	    }catch(Exception e){
	    	throw new Exception(nombre + " ya se encuentra registrado en la Base de Datos!");
	    }
	    conect.commit();

	    for (String s : inteDeC) {
			sql = "INSERT INTO InterpretadaPor (CancionNombre,ArtistaNombre) " +
	        	"VALUES ('" + nombre + "', '" + s + "')"; 
		    statem.executeUpdate(sql);
		    conect.commit();    	
	    }

	    if (!sencillo) {
			sql = "INSERT INTO PerteneceA (CancionNombre,AlbumNombre,NumPista,NumDisco) " +
	        	"VALUES ('" + nombre + "', '" + album + "', " + pista + ", " + disco + ")";
		    statem.executeUpdate(sql);
		    conect.commit();

	    	ResultSet rsc = statem.executeQuery("SELECT NumCanciones FROM Albumes WHERE Nombre LIKE '" + album + "';");
	    	int numc = rsc.getInt("NumCanciones");
		    rsc.close();
	    	numc++;

		    sql = "UPDATE Albumes SET NumCanciones = " + numc + " WHERE Nombre='" + album + "';";
		    statem.executeUpdate(sql);
		    conect.commit();
	    }
		
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
	    	rs = statem.executeQuery( "SELECT * FROM Albumes" );
	    	System.out.println("Albumes");
	    	while (rs.next()) {
	        	String nombreal = rs.getString("Nombre");
	        	int anoal = rs.getInt("Ano");
	        	int anodis = rs.getInt("NumDiscos");
	        	int numcan = rs.getInt("NumCanciones");
	        	String ilustral = rs.getString("Ilustracion");
	        System.out.println( "Nombre = " + nombreal );
	        System.out.println( "Ano = " + anoal );
	        System.out.println( "NumDiscos = " + anodis );
	        System.out.println( "NumCanciones = " + numcan );
	        System.out.println( "Ilustracion = " + ilustral );
	        System.out.println();
	    	}
	    	rs.close();
	    	rs = statem.executeQuery( "SELECT * FROM Artistas" );
	    	System.out.println("Artistas");
	    	while (rs.next()) {
	        	String nombrea = rs.getString("Nombre");
	        	String ilustraciona = rs.getString("Ilustracion");
	        	String biografiaa = rs.getString("Biografia");
	        System.out.println( "Nombre = " + nombrea );
	        System.out.println( "Ilustracion = " + ilustraciona );
	        System.out.println( "Biografia = " + biografiaa );
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
	    	rs = statem.executeQuery( "SELECT * FROM IntegranteDe" );
	    	System.out.println("IntegranteDe");
	    	while (rs.next()) {
	        	String nombrear = rs.getString("ArtistaNombre");
	        	String nombreba = rs.getString("BandaNombre");
	        System.out.println( "ArtistaNombre = " + nombrear );
	        System.out.println( "BandaNombre = " + nombreba );
	        System.out.println();
	    	}
	    	rs.close();
	    	rs = statem.executeQuery( "SELECT * FROM AlbumDe" );
	    	System.out.println("AlbumDe");
	    	while (rs.next()) {
	        	String nombrealb = rs.getString("AlbumNombre");
	        	String nombreart = rs.getString("ArtistasNombre");
	        System.out.println( "AlbumNombre = " + nombrealb );
	        System.out.println( "ArtistasNombre = " + nombreart );
	        System.out.println();
	    	}
	    	rs.close();
	    	rs = statem.executeQuery( "SELECT * FROM InterpretadaPor" );
	    	System.out.println("InterpretadaPor");
	    	while (rs.next()) {
	        	String cancionom = rs.getString("CancionNombre");
	        	String artistnom = rs.getString("ArtistaNombre");
	        System.out.println( "CancionNombre = " + cancionom );
	        System.out.println( "ArtistaNombre = " + artistnom );
	        System.out.println();
	    	}
	    	rs.close();
	    	rs = statem.executeQuery( "SELECT * FROM PerteneceA" );
	    	System.out.println("PerteneceA");
	    	while (rs.next()) {
	        	String cancionnom = rs.getString("CancionNombre");
	        	String artistanom = rs.getString("AlbumNombre");
	        	int numpist = rs.getInt("NumPista");
	        	int numdisc = rs.getInt("NumDisco");	        	
	        System.out.println( "CancionNombre = " + cancionnom );
	        System.out.println( "AlbumNombre = " + artistanom );
	       	System.out.println( "NumPista = " + numpist );
	        System.out.println( "NumDisco = " + numdisc );
	        System.out.println();
	    	}
	    	rs.close();
	    }catch(Exception e){
	    	System.err.println("No se pudo imprimir la BD!");
	    }
	}

}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSchnittstelle {
	// Attribute
	private String host;
	private String dbName;
	private String username;
	private String password;
	private Connection conn;

	// Konstruktor
	public DBSchnittstelle(String username, String password) {
		host = "jdbc:mysql://127.0.0.1/";
		dbName = "lager";
		this.username = "Patrick";
		this.password = "12345";
	}
	
	// Methoden
	public String connectToDB() {
		String ergebnis;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host, username, password);
			ergebnis = "Verbindung hergestellt.";
		} catch (ClassNotFoundException e) {
			ergebnis = "Klasse nicht gefunden.";
		} catch (SQLException e) {
			ergebnis = "Datenbank wurde nicht gefunden.";
		}
		return ergebnis;
	}
	
	public void closeConnection() throws SQLException{
	  conn.close();
	  
	}

}

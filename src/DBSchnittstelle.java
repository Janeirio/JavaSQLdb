import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

public class DBSchnittstelle {
	// Attribute
	private String host;
	private String dbName;
	private String username;
	private String password;
	private String ip;
	private String port;
	private Connection conn;
	private java.sql.Statement state;
	private java.sql.ResultSet result;

	// Konstruktor
	public DBSchnittstelle(String username, String password, String ip, String port, String dbName) {
		this.username = username;
		this.password = password;
		this.ip = ip;
		this.port = port;
		this.dbName = dbName;
	}

	// Methoden
	public void connectToDB() {
		try {
			host = "jdbc:mysql://" + ip + ":" + port + "/" + dbName;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host, username, password);
			System.out.println("Verbindung erfolgreich hergestellt.");
		} catch (ClassNotFoundException e) {
			System.out.println("Klasse wurde nicht gefunden.");
		} catch (SQLException e) {
			// System.out.println(e); // wird nur zu testzwecken genutzt
			if (String.valueOf(e).contains("Access denied for user") == true) {
				System.out.println("Benutzername oder Passwort ist falsch.");
			}

			if (String.valueOf(e).contains("Communications link failure") == true) {
				System.out.println("Verbindung konnte nicht hergestellt werden.");
			}

			if (String.valueOf(e).contains("Unknown database") == true) {
				System.out.println("Datenbank ist nicht bekannt.");
			}
		}
	}

	public void closeConnection() throws SQLException {
		conn.close();
	}

	public void selectQuery() {				//http://alvinalexander.com/java/edu/pj/jdbc/jdbc0003
		try{
			state = conn.createStatement();
		}catch(SQLException e){
			
		}
	}
	//test

}

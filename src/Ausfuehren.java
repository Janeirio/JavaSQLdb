
public class Ausfuehren {

	public static void main(String[] args) {
		String username = "Martin";
		String password = "";
		String ip = "localhost";
		String port = "3306";
		String dbName = "test";
		
		DBSchnittstelle db = new DBSchnittstelle(username,password,ip,port,dbName);
		db.connectToDB();
	}

}

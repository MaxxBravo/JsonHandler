import java.util.concurrent.Callable;

public class DBConnector implements Callable<String>{
	public String user, pwd, dbName, serverName, host, port, conector;

	public DBConnector(String user, String pwd, String dbName, String serverName, String host, String port,
			String conector) {
		super();
		this.user = user;
		this.pwd = pwd;
		this.dbName = dbName;
		this.serverName = serverName;
		this.host = host;
		this.port = port;
		this.conector = conector;
	}

	
	//Conector para Sybase
	public DBConnector(String host, String port, String serverName, String dbName, String conector) {
		this.host = host;
		this.port = port;
		this.serverName = serverName;
		this.dbName = dbName;
		this.conector = conector;
	}

	//Conector para MSSQL Server
	public DBConnector(String host, String port, String conector) {
		this.host = host;
		this.port = port;
		this.conector = conector;
	}

	//Conector para Netezza
	public DBConnector(String host, String port, String dbName, String user, String pwd, String conector) {
		this.host = host;
		this.port = port;
		this.dbName = dbName;
		this.user = user;
		this.pwd = pwd;
		this.conector = conector;
	}

	public String makeRequest() {
		//System.out.println(this.host + "," + this.port + "/" + this.conector);
		return this.host + "," + this.port + "/" + this.conector;
	}


	@Override
	public String call() throws Exception {
		return this.makeRequest();
	}

	
}

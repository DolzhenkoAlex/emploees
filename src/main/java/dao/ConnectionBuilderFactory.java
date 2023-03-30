package dao;

// класс-фабрика 
public class ConnectionBuilderFactory {
	// TODO Auto-generated constructor stub
	public static ConnectionBuilder getConnectionBuilder() {
		return new SimpleConnectionBuilder();
	}
}

package dao;

// класс-фабрика соединения с базой данных
public class ConnectionBuilderFactory {
	// TODO Auto-generated constructor stub
	public static ConnectionBuilder getConnectionBuilder() {
		return new SimpleConnectionBuilder();
	}
}

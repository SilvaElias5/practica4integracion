package ConectarseBD;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class Conexion {
	private static BasicDataSource dataSource = null;
	
	private static DataSource getDatasource() {
		if (dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("1914");
			dataSource.setUrl("jdbc:mysql://localhost::3306/practica1");	
		}
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException {
		return getDatasource().getConnection();
	}
}

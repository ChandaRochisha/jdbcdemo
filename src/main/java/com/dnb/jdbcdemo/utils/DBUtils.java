package com.dnb.jdbcdemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
public class DBUtils {
	public DBUtils() {
		
	}
@Autowired
	 DataSource dataSource;
    //private Environment environment;
//	private static Properties properties;// reference just hold the name
//
//	private static Properties getProperties() {
//
//		InputStream inputStream = DBUtils.class.getClassLoader()
//				.getResourceAsStream("application.properties");// read the file
//																												// the
//																												// file
//		try {
//			if (inputStream != null) {
//				properties = new Properties();// create object if file is present
//				properties.load(inputStream);// load contents
//				return properties;
//			}
//			return null;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(inputStream == null);
//		return properties;
//
//	}

	public Optional<Connection> getConnection() {
		//Properties properties = getProperties();
		try {
//			Connection connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
//					properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
			//  Connection connection = DriverManager.getConnection(environment.getProperty("jdbc.url"),environment.getProperty("jdbc.username"),environment.getProperty("password"));
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = dataSource.getConnection();
		
			return Optional.of(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public void closeConnection(Connection connection) {

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static void main(String args[]) {
//		System.out.println(DBUtils.getProperties());
//
//	}
}

package com.alurahotel.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.alurahotel.factory.ConnectionFactory;

public class TestConnectionFactory {
	public static void main(String[] args) {
		try {
			Connection connection = new ConnectionFactory().recoverConnection();
			System.out.println("Abriendo");
			
			connection.close();
			System.out.println("Cerrando");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

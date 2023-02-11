package com.alurahotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.alurahotel.model.Huesped;

public class HuespedDAO {
	private Connection connection;
	
	public HuespedDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void agregar(Huesped huesped) {
		try {
			final PreparedStatement statement = connection.prepareStatement("INSERT INTO tbhuespedes(nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva) VALUES(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setDate(3, Date.valueOf(dateFormat.format(huesped.getFecha_nacimiento())));
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6, huesped.getId_reserva());
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				
				try(resultSet) {
					while (resultSet.next()) {
						huesped.setId(resultSet.getInt(1));
					}
				}
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

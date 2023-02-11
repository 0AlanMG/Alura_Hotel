package com.alurahotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.alurahotel.model.Reserva;

public class ReservaDAO {
	final private Connection connection;
	
	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void agregar(Reserva reserva) {
		try {
			final PreparedStatement statement = connection.prepareStatement("INSERT INTO tbreservas(fecha_entrada, fecha_salida, valor, forma_pago) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			try(statement) {
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				statement.setDate(1, Date.valueOf(dateFormat.format(reserva.getFecha_entrada())));
				statement.setDate(2, Date.valueOf(dateFormat.format(reserva.getFecha_salida())));
				statement.setFloat(3, (float) reserva.getValor());
				statement.setString(4, reserva.getForma_pago());
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				
				try(resultSet) {
					while (resultSet.next()) {
						reserva.setId(resultSet.getInt(1));
					}
				}
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

package com.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alurahotel.model.Usuario;

public class UsuarioDAO {
	final private Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean autentificar(Usuario usuario) {
		try {
			final PreparedStatement statement = connection.prepareStatement("SELECT usuario, contrasenha FROM tbusuarios WHERE usuario = ? AND contrasenha = ?");
			
			try(statement) {
				statement.setString(1, usuario.getUsuario());
				statement.setString(2, usuario.getContrasenha());
				statement.execute();
				
				final ResultSet resultSet = statement.getResultSet();
				
				try(resultSet) {
					if(resultSet.next() == false) {
						return false;
					}else {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

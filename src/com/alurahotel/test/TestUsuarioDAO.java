package com.alurahotel.test;

import com.alurahotel.dao.UsuarioDAO;
import com.alurahotel.factory.ConnectionFactory;
import com.alurahotel.model.Usuario;

public class TestUsuarioDAO {
	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = new UsuarioDAO(new ConnectionFactory().recoverConnection());
		
		Usuario usuario = new Usuario();
		usuario.setUsuario("admin");
		usuario.setContrasenha("admin");
		
		System.out.println(usuarioDAO.autentificar(usuario));
	}
}

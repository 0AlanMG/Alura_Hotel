package com.alurahotel.controller;

import com.alurahotel.dao.UsuarioDAO;
import com.alurahotel.factory.ConnectionFactory;
import com.alurahotel.model.Usuario;

public class UsuarioController {
	private Usuario usuario;
	private UsuarioDAO usuarioDAO;
	
	public UsuarioController() {
		this.usuarioDAO = new UsuarioDAO(new ConnectionFactory().recoverConnection());
	}
	
	public boolean autentificar(String usuario, String contrasenha) {
		this.usuario = new Usuario();
		this.usuario.setUsuario(usuario);
		this.usuario.setContrasenha(contrasenha);
		
		return usuarioDAO.autentificar(this.usuario);
	}
}

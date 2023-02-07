package com.alurahotel.model;

public class Resultado {
	private boolean exito;
	private String mensaje;
	
	public Resultado(boolean exito, String mensaje) {
		this.exito = exito;
		this.mensaje = mensaje;
	}

	public void setExito(boolean exito) {
		this.exito = exito;
	}
	
	public boolean getExito() {
		return exito;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}

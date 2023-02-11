package com.alurahotel.model;

import java.util.Date;

public class Huesped {
	private int id;
	private String nombre;
	private String apellido;
	private Date fecha_nacimiento;
	private String nacionalidad;
	private String telefono;
	private int id_reserva;
	
	public Huesped(String nombre, String apellido, Date fecha_nacimiento, String nacionalidad, String telefono, int id_reserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.id_reserva = id_reserva;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	
	public int getId_reserva() {
		return id_reserva;
	}
}

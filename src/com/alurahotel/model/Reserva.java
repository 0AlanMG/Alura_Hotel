package com.alurahotel.model;

import java.util.Date;

public class Reserva {
	private int id;
	private Date fecha_entrada;
	private Date fecha_salida;
	private double valor;
	private String forma_pago;
	
	public Reserva(Date fecha_entrada, Date fecha_salida, double valor, String forma_pago) {
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.valor = valor;
		this.forma_pago = forma_pago;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}
	
	public Date getFecha_entrada() {
		return fecha_entrada;
	}
	
	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	
	public Date getFecha_salida() {
		return fecha_salida;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}
	
	public String getForma_pago() {
		return forma_pago;
	}
}

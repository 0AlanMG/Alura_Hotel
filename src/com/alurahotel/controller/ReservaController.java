package com.alurahotel.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.alurahotel.model.Resultado;

public class ReservaController {
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private Date hoy;
	private double valorPorDia = 145.5;
	
	public double calcularValorResevar(Date checkIn, Date checkOut) {
		try {
			checkIn = dateFormat.parse(dateFormat.format(checkIn));
			checkOut = dateFormat.parse(dateFormat.format(checkOut));
			
			long timeDiff = Math.abs(checkOut.getTime() - checkIn.getTime());
			long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
			
			if(daysDiff == 0) {
				return valorPorDia;
			}else {
				return daysDiff*valorPorDia;
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Resultado validarDia(Date dia) {
		try {
			hoy = dateFormat.parse(dateFormat.format(new Date()));
			dia = dateFormat.parse(dateFormat.format(dia));
			
			if(dia.getTime() < hoy.getTime()) {
				return new Resultado(false, "Día inválido, por favor seleccione un día a partir de hoy.");
			}
			return new Resultado(true, "");
			
		} catch (Exception e) {
			return new Resultado(false, "Error Inesperado, por favor intente mas tarde.");
		}
	}
	
	public Resultado validarDiasRegistrados(Date checkIn, Date checkOut) {
		try {
			checkIn = dateFormat.parse(dateFormat.format(checkIn));
			checkOut = dateFormat.parse(dateFormat.format(checkOut));
			
			if(checkIn.getTime() > checkOut.getTime()) {
				return new Resultado(false, "Día inválido, existe un error entre los dias de Check In y Check Out.");
			}
			return new Resultado(true, "");
			
		} catch (Exception e) {
			return new Resultado(false, "Error Inesperado, por favor intente mas tarde.");
		}
	}
}

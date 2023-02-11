package com.alurahotel.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.alurahotel.model.Resultado;

public class HuespedeController {

	public Resultado validarFormulario(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono) {
		try {
			// Nombre y Apellido
			if(nombre.length() > 50) {
				return new Resultado(false, "Nombre demasiado largo");
			}
			
			if(apellido.length() > 100) {
				return new Resultado(false, "Apellido demasiado largo");
			}
			
			// Fecha Nacimiento
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			LocalDate ldFechaN = LocalDate.parse(dateFormat.format(fechaN));
			LocalDate hoy = LocalDate.parse(dateFormat.format(new Date()));;
			
			Period period = ldFechaN.until(hoy);
			
			if(period.getYears() < 16) {
				return new Resultado(false, "La edad minima es de 16 años");
			}
			
			// Telefono
			if(String.valueOf(telefono).length() != 10 && !String.valueOf(telefono).matches("[0-9]")) {
				return new Resultado(false, "Formato de teléfono inválido");
			}
			
			return new Resultado(true, "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

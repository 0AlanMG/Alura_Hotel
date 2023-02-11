package com.alurahotel.test;

import java.util.Date;

import com.alurahotel.dao.ReservaDAO;
import com.alurahotel.factory.ConnectionFactory;
import com.alurahotel.model.Reserva;

public class TestReservaDAO {
	public static void main(String[] args) {
		ReservaDAO reservaDAO = new ReservaDAO(new ConnectionFactory().recoverConnection());
		
		reservaDAO.agregar(new Reserva(new Date(), new Date(), 1.01, "Crédito"));
	}
}

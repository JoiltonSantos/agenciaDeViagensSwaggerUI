package com.migrar.services;

import java.util.List;

import com.migrar.model.Reserva;

public interface ReservaService {
	List<Reserva> getAllReservas();

	Reserva getReservaById(Long idReserva);

	Reserva saveReserva(Reserva reserva, Long idCliente, Long idDestino);

	Reserva updateReserva(Long idReserva, Reserva reservaAtualizada, Long idCliente, Long idDestino);

	void deleteReserva(Long idReserva);
}

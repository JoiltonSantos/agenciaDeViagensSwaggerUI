package com.migrar.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.migrar.model.Cliente;
import com.migrar.model.Destino;
import com.migrar.model.Reserva;
import com.migrar.repositories.ReservaRepository;
import com.migrar.services.ClienteService;
import com.migrar.services.DestinoService;
import com.migrar.services.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private DestinoService destinoService;

	@Override
	public List<Reserva> getAllReservas() {
		return reservaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Reserva getReservaById(Long idReserva) {
		return reservaRepository.findById(idReserva).orElse(null);
	}

	@Override
	public Reserva saveReserva(Reserva reserva, Long idCliente, Long idDestino) {
		Cliente cliente = clienteService.getClienteById(idCliente);
		reserva.setCliente(cliente);

		Destino destino = destinoService.getDestinoById(idDestino);
		reserva.setDestino(destino);

		return reservaRepository.save(reserva);
	}

	@Override
	public Reserva updateReserva(Long idReserva, Reserva reservaAtualizada, Long idCliente, Long idDestino) {
		Reserva reservaExistente = reservaRepository.findById(idReserva).orElse(null);

		if (reservaExistente != null) {
			Cliente cliente = clienteService.getClienteById(idCliente);
			reservaExistente.setCliente(cliente);

			Destino destino = destinoService.getDestinoById(idDestino);
			reservaExistente.setDestino(destino);

			reservaExistente.setDataReserva(reservaAtualizada.getDataReserva());
			reservaExistente.setStatusReserva(reservaAtualizada.getStatusReserva());

			return reservaRepository.save(reservaExistente);
		} else {
			throw new RuntimeException("Reserva com o ID " + idReserva + " não encontrada.");
		}
	}

	@Override
	public void deleteReserva(Long idReserva) {
		reservaRepository.deleteById(idReserva);
	}

}

package com.migrar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.migrar.model.Reserva;
import com.migrar.services.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	@GetMapping
	public List<Reserva> listarReservas() {
		return reservaService.getAllReservas();
	}

	@PostMapping("/nova")
	public Reserva saveReserva(@RequestBody Reserva reserva, @RequestParam Long idCliente,
			@RequestParam Long idDestino) {
		return reservaService.saveReserva(reserva, idCliente, idDestino);
	}

	@GetMapping("/exibir/{id}")
	public Reserva getReservaById(@PathVariable Long id) {
		return reservaService.getReservaById(id);
	}

	@PutMapping("/editar/{id}")
	public Reserva updateReserva(@PathVariable Long id, @RequestBody Reserva reserva, @RequestParam Long idCliente,
			@RequestParam Long idDestino) {
		return reservaService.updateReserva(id, reserva, idCliente, idDestino);
	}

	@DeleteMapping("/excluir/{id}")
	public void deleteReserva(@PathVariable Long id) {
		reservaService.deleteReserva(id);
	}
}

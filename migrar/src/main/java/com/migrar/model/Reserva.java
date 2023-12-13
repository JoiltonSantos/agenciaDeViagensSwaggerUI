package com.migrar.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long idReserva;
	private LocalDate dataReserva;

	private enum StatusReserva {
		CONFIRMADA, PENDENTE, CANCELADA
	}
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public StatusReserva statusReserva;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	@JsonIgnore
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "idDestino")
	@JsonIgnore
	private Destino destino;

	public Reserva() {

	}

	public Reserva(Long idReserva, LocalDate dataReserva, Cliente cliente, Destino destino) {
		this.idReserva = idReserva;
		this.dataReserva = dataReserva;
		this.cliente = cliente;
		this.destino = destino;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public String getStatusReserva() {
		return statusReserva.name();
	}

	public void setStatusReserva(String statusReserva) {
		if ("CONFIRMADA".equalsIgnoreCase(statusReserva)) {
			this.statusReserva = StatusReserva.CONFIRMADA;
		} else if ("PENDENTE".equalsIgnoreCase(statusReserva)) {
			this.statusReserva = StatusReserva.PENDENTE;
		} else if ("CANCELADA".equalsIgnoreCase(statusReserva)) {
			this.statusReserva = StatusReserva.CANCELADA;
		} else {
			System.out.println("Valor invalido: " + statusReserva);
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

}

package com.migrar.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Destino {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long idDestino;
	private String localDestino;
	private double valorDestino;

	@OneToMany(mappedBy = "destino", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Reserva> reservas = new ArrayList<>();

	public Destino() {

	}

	public Destino(Long idDestino, String localDestino, double valorDestino, List<Reserva> reservas) {
		this.idDestino = idDestino;
		this.localDestino = localDestino;
		this.valorDestino = valorDestino;
		this.reservas = reservas;
	}

	public Long getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Long idDestino) {
		this.idDestino = idDestino;
	}

	public String getLocalDestino() {
		return localDestino;
	}

	public void setLocalDestino(String localDestino) {
		this.localDestino = localDestino;
	}

	public double getValorDestino() {
		return valorDestino;
	}

	public void setValorDestino(double valorDestino) {
		this.valorDestino = valorDestino;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

}

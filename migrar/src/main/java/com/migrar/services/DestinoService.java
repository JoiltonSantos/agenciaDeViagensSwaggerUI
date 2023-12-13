package com.migrar.services;

import java.util.List;

import com.migrar.model.Destino;

public interface DestinoService {
	List<Destino> getAllDestinos();

	Destino getDestinoById(Long idDestino);

	Destino saveDestino(Destino destino);

	Destino updateDestino(Long idDestino, Destino destinoAtualizado);

	void deleteDestino(Long idDestino);
}

package com.migrar.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.migrar.model.Destino;
import com.migrar.repositories.DestinoRepository;
import com.migrar.services.DestinoService;

@Service
public class DestinoServiceImpl implements DestinoService {

	@Autowired
	private DestinoRepository destinoRepository;

	@Override
	public List<Destino> getAllDestinos() {
		return destinoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Destino getDestinoById(Long idDestino) {
		return destinoRepository.findById(idDestino).orElse(null);
	}

	@Override
	public Destino saveDestino(Destino destino) {
		return destinoRepository.save(destino);
	}

	@Override
	public Destino updateDestino(Long idDestino, Destino destinoAtualizado) {
		Destino destinoExistente = destinoRepository.findById(idDestino).orElse(null);

		if (destinoExistente != null) {
			destinoExistente.setLocalDestino(destinoAtualizado.getLocalDestino());
			destinoExistente.setValorDestino(destinoAtualizado.getValorDestino());

			return destinoRepository.save(destinoExistente);
		} else {
			throw new RuntimeException("Destino com o ID " + idDestino + " não encontrado.");
		}
	}

	@Override
	public void deleteDestino(Long idDestino) {
		destinoRepository.deleteById(idDestino);
	}
}

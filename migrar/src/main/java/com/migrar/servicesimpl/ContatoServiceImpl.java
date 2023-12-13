package com.migrar.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.migrar.model.Contato;
import com.migrar.repositories.ContatoRepository;
import com.migrar.services.ContatoService;

@Service
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	@Override
	public List<Contato> getAllContatos() {
		return contatoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Contato getContatoById(Long idContato) {
		return contatoRepository.findById(idContato).orElse(null);
	}

	@Override
	public Contato saveContato(Contato contato) {
		return contatoRepository.save(contato);
	}

	@Override
	public Contato updateContato(Long idContato, Contato contatoAtualizado) {
		Contato contatoExistente = contatoRepository.findById(idContato).orElse(null);

		if (contatoExistente != null) {
			contatoExistente.setNomeContato(contatoAtualizado.getNomeContato());
			contatoExistente.setEmailContato(contatoAtualizado.getEmailContato());
			contatoExistente.setTelefoneContato(contatoAtualizado.getTelefoneContato());
			contatoExistente.setMensagemContato(contatoAtualizado.getMensagemContato());

			return contatoRepository.save(contatoExistente);
		} else {
			throw new RuntimeException("Contato com o ID " + idContato + " não encontrado.");
		}
	}

	@Override
	public void deleteContato(Long idContato) {
		contatoRepository.deleteById(idContato);
	}
}

package com.migrar.services;

import java.util.List;

import com.migrar.model.Contato;

public interface ContatoService {
	List<Contato> getAllContatos();

	Contato getContatoById(Long idContato);

	Contato saveContato(Contato contato);

	Contato updateContato(Long idContato, Contato contatoAtualizado);

	void deleteContato(Long idContato);
}

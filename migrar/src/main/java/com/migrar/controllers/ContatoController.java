package com.migrar.controllers;

import com.migrar.model.Contato;
import com.migrar.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	@GetMapping
	public List<Contato> listarContatos() {
		return contatoService.getAllContatos();
	}

	@PostMapping("/novo")
	public Contato saveContato(@RequestBody Contato contato) {
		return contatoService.saveContato(contato);
	}

	@GetMapping("/exibir/{id}")
	public Contato getContatoById(@PathVariable Long id) {
		return contatoService.getContatoById(id);
	}

	@PutMapping("/editar/{id}")
	public Contato updateContato(@PathVariable Long id, @RequestBody Contato contatoAtualizado) {
		return contatoService.updateContato(id, contatoAtualizado);
	}

	@DeleteMapping("/excluir/{id}")
	public void deleteContato(@PathVariable Long id) {
		contatoService.deleteContato(id);
	}
}

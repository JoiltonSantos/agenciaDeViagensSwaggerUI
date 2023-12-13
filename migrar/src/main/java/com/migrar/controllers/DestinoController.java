package com.migrar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.migrar.model.Destino;
import com.migrar.services.DestinoService;

import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

	@Autowired
	private DestinoService destinoService;

	@GetMapping
	public List<Destino> listarDestinos() {
		return destinoService.getAllDestinos();
	}

	@PostMapping("/novo")
	public Destino saveDestino(@RequestBody Destino destino) {
		return destinoService.saveDestino(destino);
	}

	@GetMapping("/exibir/{id}")
	public Destino getDestinoById(@PathVariable Long id) {
		return destinoService.getDestinoById(id);
	}

	@PutMapping("/editar/{id}")
	public Destino updateDestino(@PathVariable Long id, @RequestBody Destino destinoAtualizado) {
		return destinoService.updateDestino(id, destinoAtualizado);
	}

	@DeleteMapping("/excluir/{id}")
	public void deleteDestino(@PathVariable Long id) {
		destinoService.deleteDestino(id);
	}
}

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

import com.migrar.model.Cliente;
import com.migrar.services.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> listarClientes() {
		return clienteService.getAllClientes();
	}

	@PostMapping("/novo")
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		return clienteService.saveCliente(cliente);
	}

	@GetMapping("/exibir/{id}")
	public Cliente getClienteById(@PathVariable Long id) {
		return clienteService.getClienteById(id);
	}

	@PutMapping("/editar/{id}")
	public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
		return clienteService.updateCliente(id, clienteAtualizado);
	}

	@DeleteMapping("/excluir/{id}")
	public void deleteCliente(@PathVariable Long id) {
		clienteService.deleteCliente(id);
	}
}

package com.migrar.services;

import java.util.List;

import com.migrar.model.Cliente;

public interface ClienteService {
	List<Cliente> getAllClientes();

	Cliente getClienteById(Long idCliente);

	Cliente saveCliente(Cliente cliente);

	Cliente updateCliente(Long idCliente, Cliente clienteAtualizado);

	void deleteCliente(Long idCliente);
}

package com.migrar.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.migrar.model.Cliente;
import com.migrar.repositories.ClienteRepository;
import com.migrar.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente getClienteById(Long idCliente) {
		return clienteRepository.findById(idCliente).orElse(null);
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente updateCliente(Long idCliente, Cliente clienteAtualizado) {
		Cliente clienteExistente = clienteRepository.findById(idCliente).orElse(null);

		if (clienteExistente != null) {
			clienteExistente.setNomeCliente(clienteAtualizado.getNomeCliente());
			clienteExistente.setCpfCliente(clienteAtualizado.getCpfCliente());
			clienteExistente.setEmailCliente(clienteAtualizado.getEmailCliente());
			clienteExistente.setTelefoneCliente(clienteAtualizado.getTelefoneCliente());

			return clienteRepository.save(clienteExistente);
		} else {
			throw new RuntimeException("Cliente com o ID " + idCliente + " não encontrado.");
		}
	}

	@Override
	public void deleteCliente(Long idCliente) {
		clienteRepository.deleteById(idCliente);
	}
}

package com.api.mecanica.service;

import java.util.List;

import com.api.mecanica.model.Client;
import com.api.mecanica.repository.AddressRepository;
import com.api.mecanica.repository.ClientRepository;
import com.api.mecanica.service.interfaces.ClientServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements ClientServiceInterface {
	
	@Autowired
	ClientRepository repository;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public Client findById(Long id) {
		var client = repository.findById(id);
		if(client.isPresent())
			return client.get();
		return null;
	}

	@Override
	public List<Client> findAll() {
		return repository.findAll();
	}

	@Override
	public Client createClient(Client client) {
		if(!client.getAddress().isEmpty())
			addressRepository.saveAll(client.getAddress());
		else
			System.out.println("Error, endereço obrigatório!");
		Client dbClient = repository.save(client);
		return dbClient;
	}

	@Override
	public Client alterClient(Client client) {
		addressRepository.saveAll(client.getAddress());
		Client dbClient = repository.save(client);
		return dbClient;
	}

	@Override
	public Long countClient() {
		return repository.count();
	}
	
}

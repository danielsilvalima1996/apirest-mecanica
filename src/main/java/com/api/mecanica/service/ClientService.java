package com.api.mecanica.service;

import java.util.List;

import com.api.mecanica.model.Client;
import com.api.mecanica.repository.AddressRepository;
import com.api.mecanica.repository.ClientRepository;
import com.api.mecanica.repository.PhoneRepository;
import com.api.mecanica.service.interfaces.IClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	ClientRepository repository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	PhoneRepository phoneRepository;

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

		if(!client.getPhone().isEmpty())
			phoneRepository.saveAll(client.getPhone());
		else
			System.out.println("Error, phone obrigatório!");
		Client dbClient = repository.save(client);
		return dbClient;
	}

	@Override
	public Client alterClient(Client client) {
		if(!client.getAddress().isEmpty())
			addressRepository.saveAll(client.getAddress());
		else
			System.out.println("Error, endereço obrigatório!");

		if(!client.getPhone().isEmpty())
			phoneRepository.saveAll(client.getPhone());
		else
			System.out.println("Error, phone obrigatório!");
		Client dbClient = repository.save(client);
		return dbClient;
	}

	@Override
	public Long countClient() {
		return repository.count();
	}
	
}

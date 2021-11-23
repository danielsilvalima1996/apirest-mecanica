package com.api.mecanica.service;

import java.util.List;

import com.api.mecanica.model.Client;
import com.api.mecanica.model.Phone;
import com.api.mecanica.repository.AddressRepository;
import com.api.mecanica.repository.ClientRepository;
import com.api.mecanica.repository.ClientVehicleRepository;
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

	@Autowired
	ClientVehicleRepository clientVehicleRepository;

	@Override
	public Client findById(Long id) {
		var client = repository.findById(id);
		if (client.isPresent())
			return client.get();
		return null;
	}

	@Override
	public List<Client> findAll() {
		return repository.findAll();
	}

	@Override
	public Client createClient(Client client) {
		Client dbClient = repository.save(client);

		if (!client.getAddress().isEmpty()) {
			client.getAddress().stream().forEach(fe -> fe.setClient(dbClient));
			addressRepository.saveAll(client.getAddress());
		} else
			System.out.println("Error, endereço obrigatório!");

		if (!client.getPhones().isEmpty()) {
			client.getPhones().stream().forEach(fe -> fe.setClient(dbClient));
			phoneRepository.saveAll(client.getPhones());
			List<Phone> dbPhones = phoneRepository.findByClient(dbClient);
			for (Phone phone : dbPhones) {
				System.out.println(phone);
			}
		} else
			System.out.println("Error, phone obrigatório!");

		if (!client.getClientVehicles().isEmpty()) {
			client.getClientVehicles().stream().forEach(fe -> fe.setClient(dbClient));
			clientVehicleRepository.saveAll(client.getClientVehicles());
		}
		return dbClient;
	}

	@Override
	public Client alterClient(Client client) {
		Client dbClient = repository.findById(client.getId()).get();
		if (dbClient != null) {
			dbClient.setCpfCnpj(client.getCpfCnpj());
			dbClient.setFullName(client.getFullName());
			final Client newClient = repository.save(dbClient);

			if (!client.getAddress().isEmpty()) {
				client.getAddress().stream().forEach(fe -> fe.setClient(newClient));
				addressRepository.saveAll(client.getAddress());
			} else
				System.out.println("Error, endereço obrigatório!");

			if (!client.getPhones().isEmpty()) {
				client.getPhones().stream().forEach(fe -> fe.setClient(newClient));
				phoneRepository.saveAll(client.getPhones());
				List<Phone> dbPhones = phoneRepository.findByClient(newClient);
				for (Phone phone : dbPhones) {
					System.out.println(phone);
				}
			} else
				System.out.println("Error, phone obrigatório!");

			if (!client.getClientVehicles().isEmpty()) {
				client.getClientVehicles().stream().forEach(fe -> fe.setClient(newClient));
				clientVehicleRepository.saveAll(client.getClientVehicles());
			}
			return newClient;
		}
		return null;
	}

	@Override
	public Long countClient() {
		return repository.count();
	}

}

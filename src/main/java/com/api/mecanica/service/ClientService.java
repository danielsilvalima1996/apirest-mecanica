package com.api.mecanica.service;

import java.util.HashSet;
import java.util.List;

import com.api.mecanica.model.Address;
import com.api.mecanica.model.Client;
import com.api.mecanica.model.ClientVehicle;
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
		Client dbClient = repository.save(client);

		if (!client.getAddress().isEmpty()) {
			client.getAddress().stream().forEach(fe -> fe.setClient(dbClient));
			List<Address> listAddress = addressRepository.saveAll(client.getAddress());
			dbClient.setAddress(new HashSet<>(listAddress));
			List<Address> dbAddress = addressRepository.findByClient(dbClient);
			if (dbAddress.size() > listAddress.size()) {
				dbAddress.removeIf(x -> listAddress.contains(x));
				addressRepository.deleteAll(dbAddress);
			}
		} else
			throw new IllegalAccessError("Endereço não pode ser null");

		if (!client.getPhones().isEmpty()) {
			client.getPhones().stream().forEach(fe -> fe.setClient(dbClient));
			List<Phone> listPhones = phoneRepository.saveAll(client.getPhones());
			dbClient.setPhones(new HashSet<>(listPhones));
			List<Phone> dbPhones = phoneRepository.findByClient(dbClient);
			if (dbPhones.size() > listPhones.size()) {
				dbPhones.removeIf(x -> listPhones.contains(x));
				phoneRepository.deleteAll(dbPhones);
			}
		} else
			throw new IllegalAccessError("Telefone não pode ser null");

		if (!client.getClientVehicles().isEmpty()) {
			client.getClientVehicles().stream().forEach(fe -> fe.setClient(dbClient));
			List<ClientVehicle> listClientVehicles = clientVehicleRepository.saveAll(client.getClientVehicles());
			dbClient.setClientVehicles(new HashSet<>(listClientVehicles));
			List<ClientVehicle> dbClientVehicles = clientVehicleRepository.findByClient(dbClient);
			if (dbClientVehicles.size() > listClientVehicles.size()) {
				dbClientVehicles.removeIf(x -> listClientVehicles.contains(x));
				clientVehicleRepository.deleteAll(dbClientVehicles);
			}
		} else
			throw new IllegalAccessError("Veiculo não pode ser null");
		return dbClient;
	}

	@Override
	public Long countClient() {
		return repository.count();
	}

}

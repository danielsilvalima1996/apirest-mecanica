package com.api.mecanica.service.interfaces;

import java.util.List;

import com.api.mecanica.model.Client;

public interface ClientServiceInterface {

    public Client findById(Long id);
    public List<Client> findAll();
    public Client createClient(Client client);
    public Client alterClient(Client client);
    public Long countClient();
    
}

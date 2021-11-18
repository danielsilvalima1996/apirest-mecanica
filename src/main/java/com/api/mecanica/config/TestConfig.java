package com.api.mecanica.config;

import java.util.ArrayList;
import java.util.Arrays;

import com.api.mecanica.model.Address;
import com.api.mecanica.model.User;
import com.api.mecanica.model.enums.TypeAddress;
import com.api.mecanica.repository.AddressRepository;
import com.api.mecanica.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        User user1 = new User(null, "dsl15021996@gmail.com", "Daniel da Silva de Lima", "123456", "", true);
        User user2 = new User(null, "teste@gmail.com", "TESTE TI", "123456", "", true);
        userService.createUser(user1);
        userService.createUser(user2);

        Address address1 = new Address(null, "07142290", "Rua Sebastianópolis do Sul", null, "Jardim Belvedere", "Guarulhos", "SP", "67", TypeAddress.COMMERCIAL);
        Address address2 = new Address(null, "04551060", "Rua Funchal", "Terceiro Andar", "Vila Olímpia", "São Paulo", "SP", "263", TypeAddress.COMMERCIAL);
        addressRepository.saveAll(Arrays.asList(address1, address2));
        System.out.print("Rodando os testes");
    }

}

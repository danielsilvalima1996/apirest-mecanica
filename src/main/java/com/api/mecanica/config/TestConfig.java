package com.api.mecanica.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.api.mecanica.model.Address;
import com.api.mecanica.model.Client;
import com.api.mecanica.model.Phone;
import com.api.mecanica.model.User;
import com.api.mecanica.model.enums.TypeAddress;
import com.api.mecanica.model.enums.TypePhone;
import com.api.mecanica.repository.AddressRepository;
import com.api.mecanica.repository.ClientRepository;
import com.api.mecanica.repository.PhoneRepository;
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

    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        User user1 = new User(null, "dsl15021996@gmail.com", "Daniel da Silva de Lima", "123456", null, true);
        User user2 = new User(null, "teste@gmail.com", "TESTE TI", "123456", null, true);
        userService.createUser(user1);
        userService.createUser(user2);

        Address address1 = new Address(null, "07142290", "Rua Sebastianópolis do Sul", null, "Jardim Belvedere", "Guarulhos", "SP", "67", TypeAddress.COMERCIAL);
        Address address2 = new Address(null, "04551060", "Rua Funchal", "Terceiro Andar", "Vila Olímpia", "São Paulo", "SP", "263", TypeAddress.RESIDENCIAL);
        addressRepository.saveAll(Arrays.asList(address1, address2));

        Phone phone1 = new Phone(null, "11", "986284900", TypePhone.RESIDENCIAL);
        Phone phone2 = new Phone(null, "11", "24569876", TypePhone.COMERCIAL);
        Phone phone3 = new Phone(null, "11", "987302773", TypePhone.CELULAR);
        Phone phone4 = new Phone(null, "11", "33330000", TypePhone.RECADO);
        phoneRepository.saveAll(Arrays.asList(phone1, phone2, phone3, phone4));

        Set<Address> setAddress = new HashSet<>(Arrays.asList(address2));
        Set<Phone> setPhone = new HashSet<>(Arrays.asList(phone1, phone3));
        Client client1 = new Client(null, "Yan Jose", "12345678945", setAddress, setPhone);
       
        setAddress = new HashSet<>(Arrays.asList(address1, address2));
        setPhone = new HashSet<>(Arrays.asList(phone2, phone4));
        Client client2 = new Client(null, "Muryllo", "12345678955", setAddress, setPhone);
        
        clientRepository.saveAll(Arrays.asList(client1, client2));


        System.out.println("Rodando os testes");
    }

}

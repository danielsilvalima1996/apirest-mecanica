package com.api.mecanica.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.api.mecanica.model.Address;
import com.api.mecanica.model.Brand;
import com.api.mecanica.model.Client;
import com.api.mecanica.model.Phone;
import com.api.mecanica.model.User;
import com.api.mecanica.model.enums.TypeAddress;
import com.api.mecanica.model.enums.TypePhone;
import com.api.mecanica.repository.AddressRepository;
import com.api.mecanica.repository.BrandRepository;
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

    @Autowired
    private BrandRepository brandRepository;

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

        Set<Address> setAddress = new HashSet<>(Arrays.asList(address2));
        // Set<Phone> setPhone = new HashSet<>(Arrays.asList(phone1, phone3));
        Client client1 = new Client(null, "Yan Jose", "12345678945", setAddress);
       
        setAddress = new HashSet<>(Arrays.asList(address1, address2));
        // setPhone = new HashSet<>(Arrays.asList(phone2, phone4));
        Client client2 = new Client(null, "Muryllo", "12345678955", setAddress);
        clientRepository.saveAll(Arrays.asList(client1, client2));
        
        Phone phone1 = new Phone(null, "11", "986284900", TypePhone.RESIDENCIAL, clientRepository.findById(1L).get());
        Phone phone2 = new Phone(null, "11", "24569876", TypePhone.COMERCIAL, clientRepository.findById(1L).get());
        Phone phone3 = new Phone(null, "11", "987302773", TypePhone.CELULAR, clientRepository.findById(2L).get());
        Phone phone4 = new Phone(null, "11", "33330000", TypePhone.RECADO, clientRepository.findById(2L).get());
        phoneRepository.saveAll(Arrays.asList(phone1, phone2, phone3, phone4));
        
        Brand brand1 = new Brand(null, "Chevrolet");
        Brand brand2 = new Brand(null, "Fiat");
        Brand brand3 = new Brand(null, "Volkswagen");
        Brand brand4 = new Brand(null, "Ford");
        Brand brand5 = new Brand(null, "BMW");
        Brand brand6 = new Brand(null, "Citroen");
        Brand brand7 = new Brand(null, "Renault");
        Brand brand8 = new Brand(null, "Jeep");
        Brand brand9 = new Brand(null, "Audi");
        Brand brand10 = new Brand(null, "Caoa Chery");
        Brand brand11 = new Brand(null, "Jac Motors");
        brandRepository.saveAll(Arrays.asList(
            brand1, brand2, brand3, brand4, brand5, brand6, brand7, brand8, brand9, brand10, brand11));
        


        System.out.println("Rodando os testes");
    }

}

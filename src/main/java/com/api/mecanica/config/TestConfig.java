package com.api.mecanica.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.api.mecanica.model.Address;
import com.api.mecanica.model.Brand;
import com.api.mecanica.model.Client;
import com.api.mecanica.model.Phone;
import com.api.mecanica.model.User;
import com.api.mecanica.model.VehicleModel;
import com.api.mecanica.model.enums.TypeAddress;
import com.api.mecanica.model.enums.TypePhone;
import com.api.mecanica.repository.AddressRepository;
import com.api.mecanica.repository.BrandRepository;
import com.api.mecanica.repository.ClientRepository;
import com.api.mecanica.repository.PhoneRepository;
import com.api.mecanica.repository.VehicleModelRepository;
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

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        User user1 = new User(null, "dsl15021996@gmail.com", "Daniel da Silva de Lima", "123456", null, true);
        User user2 = new User(null, "teste@gmail.com", "TESTE TI", "123456", null, true);
        userService.createUser(user1);
        userService.createUser(user2);

        Address address1 = new Address(null, "07142290", "Rua Sebastianópolis do Sul", null, "Jardim Belvedere",
                "Guarulhos", "SP", "67", TypeAddress.COMERCIAL);
        Address address2 = new Address(null, "04551060", "Rua Funchal", "Terceiro Andar", "Vila Olímpia", "São Paulo",
                "SP", "263", TypeAddress.RESIDENCIAL);
        addressRepository.saveAll(Arrays.asList(address1, address2));

        Set<Address> setAddress = new HashSet<>(Arrays.asList(address2));
        Client client1 = new Client(null, "Yan Jose", "12345678945", setAddress);

        setAddress = new HashSet<>(Arrays.asList(address1, address2));
        Client client2 = new Client(null, "Muryllo", "12345678955", setAddress);
        clientRepository.saveAll(Arrays.asList(client1, client2));

        Phone phone1 = new Phone(null, "11", "986284900", TypePhone.RESIDENCIAL, clientRepository.findById(1L).get());
        Phone phone2 = new Phone(null, "11", "24569876", TypePhone.COMERCIAL, clientRepository.findById(1L).get());
        Phone phone3 = new Phone(null, "11", "987302773", TypePhone.CELULAR, clientRepository.findById(2L).get());
        Phone phone4 = new Phone(null, "11", "33330000", TypePhone.RECADO, clientRepository.findById(2L).get());
        phoneRepository.saveAll(Arrays.asList(phone1, phone2, phone3, phone4));

        Brand brand1 = new Brand(null, "Chevrolet", true);
        Brand brand2 = new Brand(null, "Fiat", true);
        Brand brand3 = new Brand(null, "Volkswagen", true);
        Brand brand4 = new Brand(null, "Ford", true);
        Brand brand5 = new Brand(null, "BMW", true);
        Brand brand6 = new Brand(null, "Citroen", true);
        Brand brand7 = new Brand(null, "Renault", true);
        Brand brand8 = new Brand(null, "Jeep", true);
        Brand brand9 = new Brand(null, "Audi", true);
        Brand brand10 = new Brand(null, "Caoa Chery", true);
        Brand brand11 = new Brand(null, "Jac Motors", true);
        brandRepository.saveAll(Arrays.asList(brand1, brand2, brand3, brand4, brand5, brand6, brand7, brand8, brand9,
                brand10, brand11));

        VehicleModel vehicleModel1 = new VehicleModel(null, "Onix", true,brandRepository.findById(1L).get());
        VehicleModel vehicleModel2 = new VehicleModel(null, "Argos", true,brandRepository.findById(2L).get());
        VehicleModel vehicleModel3 = new VehicleModel(null, "Gol", true,brandRepository.findById(3L).get());
        VehicleModel vehicleModel4 = new VehicleModel(null, "Ka", true,brandRepository.findById(4L).get());
        VehicleModel vehicleModel5 = new VehicleModel(null, "M3", true,brandRepository.findById(5L).get());
        VehicleModel vehicleModel6 = new VehicleModel(null, "C3", true,brandRepository.findById(6L).get());
        VehicleModel vehicleModel7 = new VehicleModel(null, "Clio", true,brandRepository.findById(7L).get());
        VehicleModel vehicleModel8 = new VehicleModel(null, "Renegade", true,brandRepository.findById(8L).get());
        VehicleModel vehicleModel9 = new VehicleModel(null, "TTs", true,brandRepository.findById(9L).get());
        VehicleModel vehicleModel10 = new VehicleModel(null, "Tiggo 5", true,brandRepository.findById(10L).get());
        VehicleModel vehicleModel11 = new VehicleModel(null, "J3 Turing", true,brandRepository.findById(1L).get());
        vehicleModelRepository.saveAll(Arrays.asList(vehicleModel1, vehicleModel2, vehicleModel3, vehicleModel4, vehicleModel5, vehicleModel6, vehicleModel7, vehicleModel8, vehicleModel9,
        vehicleModel10, vehicleModel11));


        System.out.println("Rodando os testes");
    }

}

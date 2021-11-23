package com.api.mecanica.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.api.mecanica.model.Address;
import com.api.mecanica.model.Brand;
import com.api.mecanica.model.Client;
import com.api.mecanica.model.ClientVehicle;
import com.api.mecanica.model.Phone;
import com.api.mecanica.model.User;
import com.api.mecanica.model.VehicleModel;
import com.api.mecanica.model.enums.TypeAddress;
import com.api.mecanica.model.enums.TypeFuel;
import com.api.mecanica.model.enums.TypePhone;
import com.api.mecanica.repository.AddressRepository;
import com.api.mecanica.repository.BrandRepository;
import com.api.mecanica.repository.ClientRepository;
import com.api.mecanica.repository.ClientVehicleRepository;
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

    @Autowired
    private ClientVehicleRepository clientvehicleRepository;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        User user1 = new User(null, "dsl15021996@gmail.com", "Daniel da Silva de Lima", "123456", null, true);
        User user2 = new User(null, "teste@gmail.com", "TESTE TI", "123456", null, true);
        userService.createUser(user1);
        userService.createUser(user2);

        Client client1 = new Client(null, "Yan Jose", "12345678945");

        Client client2 = new Client(null, "Muryllo", "12345678955");
        client1 = clientRepository.save(client1);
        client2 = clientRepository.save(client2);

        Address address1 = new Address(null, "07142290", "Rua Sebastianópolis do Sul", null, "Jardim Belvedere",
        "Guarulhos", "SP", "67", TypeAddress.COMERCIAL, client1);
        Address address2 = new Address(null, "04551060", "Rua Funchal", "Terceiro Andar", "Vila Olímpia", "São Paulo",
        "SP", "263", TypeAddress.RESIDENCIAL, client2);
        addressRepository.saveAll(Arrays.asList(address1, address2));

        Phone phone1 = new Phone(null, "11", "986284900", TypePhone.RESIDENCIAL, client1);
        Phone phone2 = new Phone(null, "11", "24569876", TypePhone.COMERCIAL, client1);
        Phone phone3 = new Phone(null, "11", "987302773", TypePhone.CELULAR, client2);
        Phone phone4 = new Phone(null, "11", "33330000", TypePhone.RECADO, client2);
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
        VehicleModel vehicleModel4 = new VehicleModel(null, "F-1000", true,brandRepository.findById(4L).get());
        VehicleModel vehicleModel5 = new VehicleModel(null, "M3", true,brandRepository.findById(5L).get());
        VehicleModel vehicleModel6 = new VehicleModel(null, "C3", true,brandRepository.findById(6L).get());
        VehicleModel vehicleModel7 = new VehicleModel(null, "Clio", true,brandRepository.findById(7L).get());
        VehicleModel vehicleModel8 = new VehicleModel(null, "Renegade", true,brandRepository.findById(8L).get());
        VehicleModel vehicleModel9 = new VehicleModel(null, "TTs", true,brandRepository.findById(9L).get());
        VehicleModel vehicleModel10 = new VehicleModel(null, "Tiggo 5", true,brandRepository.findById(10L).get());
        VehicleModel vehicleModel11 = new VehicleModel(null, "J3 Turing", true,brandRepository.findById(1L).get());
        vehicleModelRepository.saveAll(Arrays.asList(vehicleModel1, vehicleModel2, vehicleModel3, vehicleModel4, vehicleModel5, vehicleModel6, vehicleModel7, vehicleModel8, vehicleModel9,
        vehicleModel10, vehicleModel11));

        ClientVehicle clientVehicle1 = new ClientVehicle(null, clientRepository.findById(1L).get(), vehicleModelRepository.findById(1L).get(), 2019, TypeFuel.ELETRIC, "ONI2X69");
        ClientVehicle clientVehicle2 = new ClientVehicle(null, clientRepository.findById(1L).get(), vehicleModelRepository.findById(2L).get(), 2021, TypeFuel.FLEX, "ARG1U00");
        ClientVehicle clientVehicle3 = new ClientVehicle(null, clientRepository.findById(1L).get(), vehicleModelRepository.findById(4L).get(), 1984, TypeFuel.DIESEL, "FRD1000");
        ClientVehicle clientVehicle4 = new ClientVehicle(null, clientRepository.findById(1L).get(), vehicleModelRepository.findById(5L).get(), 1994, TypeFuel.ETHANOL, "BMW3M33");
        ClientVehicle clientVehicle5 = new ClientVehicle(null, clientRepository.findById(2L).get(), vehicleModelRepository.findById(6L).get(), 2021, TypeFuel.HYBRID, "CCC3333");
        ClientVehicle clientVehicle6 = new ClientVehicle(null, clientRepository.findById(2L).get(), vehicleModelRepository.findById(11L).get(), 2021, TypeFuel.GASOLINE, "JAC1J65");
        ClientVehicle clientVehicle7 = new ClientVehicle(null, clientRepository.findById(2L).get(), vehicleModelRepository.findById(3L).get(), 2021, TypeFuel.LPG, "GOL9999");
        clientvehicleRepository.saveAll(Arrays.asList(clientVehicle1, clientVehicle2, clientVehicle3, clientVehicle4, clientVehicle5, clientVehicle6, clientVehicle7));

        System.out.println("Rodando os testes");
    }

}

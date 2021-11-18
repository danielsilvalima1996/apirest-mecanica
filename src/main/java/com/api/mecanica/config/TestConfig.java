package com.api.mecanica.config;

import com.api.mecanica.model.User;
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

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        User user1 = new User(null, "dsl15021996@gmail.com", "Daniel da Silva de Lima", "123456", "", true);
        User user2 = new User(null, "teste@gmail.com", "TESTE TI", "123456", "", true);
        userService.createUser(user1);
        userService.createUser(user2);
        System.out.print("Rodando os testes");
    }

}

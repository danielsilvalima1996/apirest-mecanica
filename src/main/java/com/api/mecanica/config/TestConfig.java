package com.api.mecanica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.api.mecanica.model.Users;

import org.springframework.boot.CommandLineRunner;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        Users user1 = new Users(null, "dsl15021996@gmail.com", "Daniel da Silva de Lima", "123456", "", true);
        System.out.print("Rodando os testes" +  user1.toString());
    }

}

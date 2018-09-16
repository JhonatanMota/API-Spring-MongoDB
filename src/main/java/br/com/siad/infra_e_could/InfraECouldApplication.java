package br.com.siad.infra_e_could;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SpringBootApplication
public class InfraECouldApplication extends SpringBootServletInitializer implements CommandLineRunner{

    @Autowired
    private HeroRepository heroRepository;

    public static void main(String[] args) {
        SpringApplication.run(InfraECouldApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        heroRepository.deleteAll();

        // save a couple of customers
        heroRepository.save(new Hero("Wolwerine"));
        heroRepository.save(new Hero("Homem de Ferro"));
        heroRepository.save(new Hero("Thor"));
        heroRepository.save(new Hero("Homem Aranha"));
        heroRepository.save(new Hero("Thor"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Hero hero : heroRepository.findAll()) {
            System.out.println(hero);
        }

        // fetch an individual customer
        System.out.println("Hero found with Name('Thor'):");
        System.out.println("--------------------------------");
        System.out.println(heroRepository.findHeroByName("Thor"));

    }
}

package org.sid.comptes.bancaires;

import org.sid.comptes.bancaires.entities.Compte;
import org.sid.comptes.bancaires.entities.Customer;
import org.sid.comptes.bancaires.enums.AccountType;
import org.sid.comptes.bancaires.repositories.CompteRepository;
import org.sid.comptes.bancaires.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ComptesBancairesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComptesBancairesApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository comptereRepository, CustomerRepository customerRepository) {
		return args -> {
			Stream.of("Cheikh","Sidi","Salma","Fatima","Khalid").forEach(c->{
				Customer customer=Customer.builder()
						.name(c)
						.build();
				customerRepository.save(customer);

			});
			customerRepository.findAll().forEach(customer -> {
				for(int i =0;i<10;i++){
					Compte compte=Compte.builder()
							.balance(10000+Math.random()*90000)
							.id(UUID.randomUUID().toString())
							.type((Math.random() > 0.5) ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
							.createAt(new Date())
							.currency("MAD")
							.customer(customer)
							.build();
					comptereRepository.save(compte);
				}
			});

		};
	}
}

package org.sid.comptes.bancaires.web;

import org.sid.comptes.bancaires.dto.CompteRequestDTO;
import org.sid.comptes.bancaires.dto.CompteResponseDTO;
import org.sid.comptes.bancaires.entities.Compte;
import org.sid.comptes.bancaires.entities.Customer;
import org.sid.comptes.bancaires.repositories.CompteRepository;
import org.sid.comptes.bancaires.repositories.CustomerRepository;
import org.sid.comptes.bancaires.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;
@Controller
public class ComptegraphqlController {
  private CompteService compteService;
  private CompteRepository compteRepository;
  private CustomerRepository customerRepository;

    public ComptegraphqlController(CompteService compteService, CompteRepository compteRepository, CustomerRepository customerRepository) {
        this.compteService = compteService;
        this.compteRepository = compteRepository;
        this.customerRepository = customerRepository;
    }

    @Controller

    public class AccountgraphQLController {
        private  CompteService accountService;
        @Autowired
        private CompteRepository compteRepository;
        @Autowired
        private CustomerRepository customerRepository;

        public AccountgraphQLController(CompteService accountService) {
            this.accountService = accountService;
        }

        @QueryMapping
        public List<Compte> accountsList(){
            return compteRepository.findAll();
        }
        @QueryMapping
        public Compte compteById(@Argument String id){
            return compteRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found" ,id)));
        }
        @MutationMapping
        public CompteResponseDTO _addCompte(@Argument CompteRequestDTO compte){
            return accountService.addCompte(compte);
        }
        @MutationMapping
        public CompteResponseDTO updateCompte( @Argument String id ,@Argument CompteRequestDTO compte){
            return accountService.updateCompte(id,compte);
        }
        @MutationMapping
        public boolean deleteCompte( @Argument String id ){
            compteRepository.deleteById(id);
            return true;
        }
        @QueryMapping
        public List<Customer> customersList(){
            return customerRepository.findAll();
        }
    @MutationMapping
    public Customer addCustomer(@Argument Customer customer){
        return customerRepository.save(customer);
    }

}
}
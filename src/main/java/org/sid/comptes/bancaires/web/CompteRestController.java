package org.sid.comptes.bancaires.web;

import org.sid.comptes.bancaires.dto.CompteRequestDTO;
import org.sid.comptes.bancaires.dto.CompteResponseDTO;
import org.sid.comptes.bancaires.entities.Compte;
import org.sid.comptes.bancaires.repositories.CompteRepository;
import org.sid.comptes.bancaires.service.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompteRestController {
    private CompteRepository compteRepository;
    private CompteService compteService;

    public CompteRestController(CompteRepository compteRepository, CompteService compteService) {
        this.compteRepository = compteRepository;
        this.compteService = compteService;
    }

    @GetMapping("/comptes")
    public List<Compte>comptes(){
        return compteRepository.findAll();
    }
    @GetMapping("/comptes/{id}")
    public Compte compte(@PathVariable String id){
        return compteRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("compte not found")));
    }
    @PostMapping("/comptes")

    public CompteResponseDTO saveCompte(@RequestBody CompteRequestDTO compteRequestDTO){

        return compteService.addCompte(compteRequestDTO);
    }
    @PutMapping("/comptes/{id}")
    public CompteResponseDTO updateCompte( @PathVariable String id ,@RequestBody CompteRequestDTO compteRequestDTO){

        return compteService.updateCompte(id ,compteRequestDTO);
    }
    @DeleteMapping("/comptes/{id}")
    public boolean deleteCopmte(@PathVariable String id){
        compteService.deleteCompte(id);
        return true;
    }


}

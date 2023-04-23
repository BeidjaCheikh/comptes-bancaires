package org.sid.comptes.bancaires.service;
import org.sid.comptes.bancaires.Mappers.CompteMapper;
import org.sid.comptes.bancaires.dto.CompteRequestDTO;
import org.sid.comptes.bancaires.dto.CompteResponseDTO;
import org.sid.comptes.bancaires.entities.Compte;
import org.sid.comptes.bancaires.repositories.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.UUID;
@Service
@Transactional
public class CompteServiceImpl implements CompteService {

    private CompteRepository compteRepository;
    private  CompteMapper compteMapper;


    public CompteServiceImpl(CompteRepository compteRepository, CompteMapper compteMapper) {
        this.compteRepository = compteRepository;
        this.compteMapper = compteMapper;
    }

    @Override
    public CompteResponseDTO addCompte(CompteRequestDTO compteRequestDTO) {

        Compte compte = Compte.builder()
                .id(UUID.randomUUID().toString())
                .balance(compteRequestDTO.getBalance())
                .createAt(new Date())
                .currency(compteRequestDTO.getCurrency())
                .type(compteRequestDTO.getType())
                .build();

        Compte compteSave = compteRepository.save(compte);
        CompteResponseDTO compteResponseDTO = compteMapper.fromCompte(compteSave);
        return compteResponseDTO;


    }
    @Override
    public CompteResponseDTO updateCompte(String id, CompteRequestDTO compteRequestDTO) {

            Compte compte = Compte.builder()
                    .id(id)
                    .balance(compteRequestDTO.getBalance())
                    .createAt(new Date())
                    .currency(compteRequestDTO.getCurrency())
                    .type(compteRequestDTO.getType())
                    .build();

            Compte compteSave = compteRepository.save(compte);
            CompteResponseDTO compteResponseDTO = compteMapper.fromCompte(compteSave);
            return compteResponseDTO;


    }
    @Override
    public void deleteCompte(String id) {
    compteRepository.deleteById(id);

    }


}

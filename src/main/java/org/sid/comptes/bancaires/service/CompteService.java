package org.sid.comptes.bancaires.service;
import org.sid.comptes.bancaires.dto.CompteRequestDTO;
import org.sid.comptes.bancaires.dto.CompteResponseDTO;

public interface CompteService {
    CompteResponseDTO addCompte(CompteRequestDTO compteRequestDTO);

    CompteResponseDTO updateCompte(String id, CompteRequestDTO compteRequestDTO);


    void deleteCompte(String id);
}

package org.sid.comptes.bancaires.Mappers;

import org.sid.comptes.bancaires.dto.CompteResponseDTO;
import org.sid.comptes.bancaires.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {
   public CompteResponseDTO fromCompte(Compte compte){
        CompteResponseDTO compteResponseDTO =new CompteResponseDTO();
        BeanUtils.copyProperties(compte,compteResponseDTO);
        return compteResponseDTO;
    }
}

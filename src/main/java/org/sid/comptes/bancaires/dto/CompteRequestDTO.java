package org.sid.comptes.bancaires.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.comptes.bancaires.enums.AccountType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CompteRequestDTO {

    private Double balance ;
    private  String currency;
    private AccountType type;


}
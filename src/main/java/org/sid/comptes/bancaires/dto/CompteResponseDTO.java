package org.sid.comptes.bancaires.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.comptes.bancaires.enums.AccountType;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CompteResponseDTO {
    private String id;
    private Date createAt;
    private Double balance ;
    private  String currency;
    private AccountType type;
}

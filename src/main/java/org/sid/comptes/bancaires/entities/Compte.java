package org.sid.comptes.bancaires.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.comptes.bancaires.enums.AccountType;

import java.util.Date;
@Entity @AllArgsConstructor @NoArgsConstructor @Data @Builder
public class Compte {
    @Id
    private String id;
    private Date createAt;
    private Double balance ;
    private  String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne()

    private Customer customer;

}

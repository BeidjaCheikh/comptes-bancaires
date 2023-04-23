package org.sid.comptes.bancaires.repositories;

import org.sid.comptes.bancaires.entities.Compte;
import org.sid.comptes.bancaires.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource

public interface CompteRepository extends JpaRepository<Compte,String> {

    @RestResource(path = "byType")
    List<Compte>findByType(@Param("t") AccountType type);
}


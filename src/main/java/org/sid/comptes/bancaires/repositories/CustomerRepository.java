package org.sid.comptes.bancaires.repositories;

import org.sid.comptes.bancaires.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

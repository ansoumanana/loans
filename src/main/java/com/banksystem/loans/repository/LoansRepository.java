package com.banksystem.loans.repository;

import com.banksystem.loans.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoansRepository extends CrudRepository<Loans,Long> {

    public Optional<List<Loans>> findByCustomerIdOrderByStartDtDesc(int customerId);
}

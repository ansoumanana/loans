package com.banksystem.loans.controller;

import com.banksystem.loans.model.Customer;
import com.banksystem.loans.model.Loans;
import com.banksystem.loans.repository.LoansRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(value = "loans")
public class LoansController {
    private static final Logger logger = LoggerFactory.getLogger(LoansController.class);
    private final LoansRepository loansRepository;

    public LoansController(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    @GetMapping(value = "/{customerId}")
    public Optional<List<Loans>> findByCustomerIdOrderByStartDtDescLoans(@RequestHeader("banksystem-correlation-id") String correlationId,@PathVariable int customerId){
        return loansRepository.findByCustomerIdOrderByStartDtDesc(customerId);
    }

    @GetMapping(value = "/loan")
    public Optional<List<Loans>> findByCustomerIdOrderByStartDtDescLoans(@RequestHeader("banksystem-correlation-id") String correlationId,@RequestBody Customer customer){
        return loansRepository.findByCustomerIdOrderByStartDtDesc(customer.customerId());
    }

    @PostMapping("/myLoans")
    public Optional<List<Loans>>getLoansDetails(@RequestHeader("banksystem-correlation-id") String correlationId,@RequestBody Customer customer) {
        logger.info("Invoking getLoansDetails method started");
       return loansRepository.findByCustomerIdOrderByStartDtDesc(customer.customerId());


    }
}

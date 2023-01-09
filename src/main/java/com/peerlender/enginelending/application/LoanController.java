package com.peerlender.enginelending.application;

import com.peerlender.enginelending.domain.model.LoanRequest;
import com.peerlender.enginelending.domain.repository.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    private LoanRequestRepository loanRequestRepository;

    @PostMapping(value = "/loan/request")
    public void loanRequest(@RequestBody final String user/*LoanRequest loanRequest*/){
        loanRequestRepository.getLoan();
        System.out.println("LOAN REQ Accepted:");

    }

    @PostMapping(value = "/loan/user")
    public void insertUserData(@RequestBody String user){
       Boolean value =  loanRequestRepository.insertUser();
        System.out.println("User Data Inserted : "+ value);
    }
}

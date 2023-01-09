package com.peerlender.enginelending.domain.repository;

import com.peerlender.enginelending.domain.model.LoanUser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import static com.peerlender.enginelending.constant.GET_USER_DATA;

@Component
public class LoanRequestRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public Boolean insertUser(){

        LoanUser user = new LoanUser();
        user.setFirstName("Bason");
        user.setLastName("Miller");
        entityManager.persist(user);

        return Boolean.TRUE;

    }

    @Transactional
    public void getLoan(){

        Query query = entityManager.createNativeQuery(GET_USER_DATA);
        List<Object[]> results = query.getResultList();

        for (Object[] result: results) {
            Object user1 = result[1];
            LoanUser user2 = (LoanUser)result[2];
            System.out.println(user1);
            System.out.println(user2);
        }

    }

}

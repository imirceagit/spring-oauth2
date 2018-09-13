package com.mient.authserver.service;

import com.mient.authserver.domain.DealerDetails;
import com.mient.authserver.domain.User;
import com.mient.authserver.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserDataSetup implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("seller1");
        user.setFirstName("ONE");
        user.setLastName("SELLER");
        user.setPassword("123");
        Set<String> authorities = new HashSet<>();
        authorities.add("Portal.User");
        authorities.add("LeadHub.User");
        authorities.add("OfferManagement.User");
        authorities.add("KundenManager2.User");
        user.setAuthorities(authorities);
        DealerDetails dealerDetails = new DealerDetails();
        dealerDetails.setDealerId("dealer1");
        dealerDetails.setDealerName("DEALER1");
        dealerDetails.setBranchId("branch1");
        dealerDetails.setBranchName("BRANCH1");
        user.setDealerDetails(dealerDetails);
        userRepository.save(user);
    }
}

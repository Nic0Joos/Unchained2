package ch.fhnw.acrm.business.service;

import ch.fhnw.acrm.data.domain.UnchainedUser;

import ch.fhnw.acrm.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.Validator;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    Validator validator;
    @Autowired
    private DistanceCalculatorService distanceCalculatorService;


    public void saveUser(@Valid UnchainedUser unchainedUser) throws Exception {
        if (unchainedUser.getUserId() == null) {
            if (userRepository.findByEmail(unchainedUser.getEmail()) != null ) {
                throw new Exception("User email already exists!");
            }
        }
        unchainedUser.setTravelDistance(distanceCalculatorService.getDistance(unchainedUser.getZipCode()));
        unchainedUser.setPassword(passwordEncoder.encode(unchainedUser.getPassword()));
        unchainedUser.setRole("USER");
        userRepository.save(unchainedUser);
    }

    public UnchainedUser getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(user.getUsername());
    }


}

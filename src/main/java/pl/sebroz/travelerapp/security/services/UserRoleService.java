package pl.sebroz.travelerapp.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sebroz.travelerapp.security.model.User;
import pl.sebroz.travelerapp.security.model.UserRole;
import pl.sebroz.travelerapp.security.repositories.UserRoleRepository;

import java.util.NoSuchElementException;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole findByUser(User user) {
        return userRoleRepository.findByUser(user)
                .orElseThrow(() -> new NoSuchElementException("No user with given username."));
    }

    public void save(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}

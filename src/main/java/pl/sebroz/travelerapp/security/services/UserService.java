package pl.sebroz.travelerapp.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sebroz.travelerapp.security.model.User;
import pl.sebroz.travelerapp.security.model.UserRole;
import pl.sebroz.travelerapp.security.repositories.UserRepository;

import java.util.*;

import static pl.sebroz.travelerapp.security.model.Role.*;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void register(String username, String password) {
        User user = new User(username, passwordEncoder.encode(password));
        user.setRole(new UserRole(user, ROLE_USER));

        userRepository.save(user);
    }

    public List<User> findAllWithoutCurrentUser() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();

        return userRepository.findAllByUsernameIsNotContaining(currentUser.getName());
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No user with given identity number."));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("No user with given username."));
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void saveSettings(User user) {
        user.setRole(user.getRole());

        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void changePassword(Long id, String password) {
        userRepository.findById(id).ifPresent(user -> {
                    user.setPassword(passwordEncoder.encode(password));
                    userRepository.save(user);
                }
        );
    }
}

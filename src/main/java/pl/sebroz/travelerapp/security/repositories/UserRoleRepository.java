package pl.sebroz.travelerapp.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sebroz.travelerapp.security.model.User;
import pl.sebroz.travelerapp.security.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByUser(User user);
}

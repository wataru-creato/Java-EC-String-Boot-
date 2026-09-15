package shop.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByuserName(String username);


}
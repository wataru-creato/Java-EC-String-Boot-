package shop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // これだけで、データの保存（save）や検索（findAll等）の機能が自動で備わります
}
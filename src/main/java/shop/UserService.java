package shop;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    public List<User> getALLUser(){
        return userRepository.findAll();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createALLUser(User user){

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }

    public  User updateALLUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}

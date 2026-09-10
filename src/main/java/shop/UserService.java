package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    public List<User> getALLUser(){
        return userRepository.findAll();
    }

    public User createALLUser(User user){
        return userRepository.save(user);
    }

    public  User updateALLUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}

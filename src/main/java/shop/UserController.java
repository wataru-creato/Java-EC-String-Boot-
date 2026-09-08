package shop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserSevice userSevice;

    @GetMapping
    public List<User> getALLUsers(){
        return userSevice.getALLUser();
    }

    @PostMapping
    public User createALLUsers(@RequestBody User user){
        return userSevice.createALLUser(user);
    }

    @PutMapping
    public User updateALLUsers(@RequestBody User user){
        return userSevice.updateALLUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable Long id){
        userSevice.deleteUser(id);
    }
}

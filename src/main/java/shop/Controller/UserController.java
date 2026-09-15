package shop.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;
import shop.Entity.User;
import shop.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getALLUsers(){
        return userService.getALLUser();
    }

    @PostMapping
    public User createALLUsers(@Valid @RequestBody User user){
        return userService.createALLUser(user);
    }

    @PutMapping("/{id}")
    public User updateALLUsers(@PathVariable Long id,@Valid @RequestBody User user){
        user.id=id;
        return userService.updateALLUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable Long id){
        userService.deleteUser(id);
    }
}

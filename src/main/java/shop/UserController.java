package shop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @GetMapping
    public List<User> getALLUsers(){
        return userService.getALLUser();
    }

    @PostMapping
    public User createALLUsers(@Valid  User user){
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

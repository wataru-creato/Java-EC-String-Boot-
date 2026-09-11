package shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

public class LoginController {

    @GetMapping("/login")
    public String Login(){
        return "login";
    }
}

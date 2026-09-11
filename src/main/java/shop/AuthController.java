package shop;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        //ハッシュ化
        String hashedPassword = passwordEncoder.encode(request.getPassword());


        User user = new User();
        user.setUserId(request.getUserId());
        user.setPassword(hashedPassword); // データベースにはハッシュ化された文字列が入る
        user.setUserName(request.getUserName());
        user.setRole(request.getRole());
        user.setUserEmail(request.getUserEmail());

        // 3. データベースに保存
        userRepository.save(user);

        return "ユーザー登録が成功しました: " + request.getUserId();
    }
}
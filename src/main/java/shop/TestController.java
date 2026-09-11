package shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    // ログイン不要で誰でもアクセスできるエンドポイント
    @GetMapping("/public/hello")
    public String publicEndpoint() {
        return "こんにちは！このAPIは認証なしでアクセスできます。";
    }

    // ログイン（認証）が必須の保護されたエンドポイント
    @GetMapping("/secure/data")
    public String secureEndpoint() {
        return "認証成功！この機密データはログインしたユーザーだけに表示されます。";
    }
}
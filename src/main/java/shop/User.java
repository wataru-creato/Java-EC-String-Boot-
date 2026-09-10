package shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;



@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "ユーザーIDは必須です")
    @Size(min = 4, max = 20, message = "ユーザーIDは4文字以上20文字以内で入力してください")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "ユーザーIDは半角英数字、ハイフン、アンダーバーで入力してください")
    public String user_id;

    @NotBlank(message = "ユーザー名は必須です")
    @Size(max = 50, message = "ユーザー名は50文字以内で入力してください")
    public String user_name;

    @NotBlank(message = "メールアドレスは必須です")
    @Email(message = "有効なメールアドレス形式で入力してください")
    @Size(max = 100, message = "メールアドレスは100文字以内で入力してください")
    public String user_email;

    @NotBlank(message = "パスワードは必須です")
    @Size(min = 8, max = 100, message = "パスワードは8文字以上で入力してください")
    public String password_hash;

    @Size(max = 255, message = "住所は255文字以内で入力してください")
    public String address;

    @Pattern(regexp = "^$|^0\\d{9,10}$", message = "正しい電話番号の形式で入力してください（ハイフンなし）")
    public String phoneNumber;

    public User(){

    }

    public User(String user_id,String user_name,String user_email,String password_hash,String address,String phoneNumber){
        this.user_id=user_id;
        this.user_name=user_name;
        this.user_email=user_email;
        this.password_hash=password_hash;
        this.address=address;
        this.phoneNumber=phoneNumber;
    }

    public String showUserInfo(){
        return "ユーザID："+user_id+",ユーザ名："+user_name+"ユーザメール："+user_email+",パスワード："+password_hash+",住所："+address+",電話番号："+phoneNumber;
    }
}

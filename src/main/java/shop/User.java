package shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.lang.Override;

import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class User implements UserDetails{

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUserId() {
        return userId;
    }

    public void setPassword(String passwordHash){
        this.passwordHash = passwordHash;
    }


    public String getPassword() {
        return passwordHash;
    }


    public void setUserName(String useName) {
        this.userName=useName;
    }


    public String getUserName(){
        return userName;
    }

    public void setUserEmail(String userEmail){
        this.userEmail=userEmail;
    }


    public  String getUserEmail(){
        return userEmail;
    }


//    public String role;

    public void setRole(String role){
        this.role=role;
    }


    public String getRole() {
        return role != null ? role : null;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "ユーザーIDは必須です")
    @Size(min = 4, max = 20, message = "ユーザーIDは4文字以上20文字以内で入力してください")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "ユーザーIDは半角英数字、ハイフン、アンダーバーで入力してください")
    public String userId;

    @NotBlank(message = "ユーザー名は必須です")
    @Size(max = 50, message = "ユーザー名は50文字以内で入力してください")
    public String userName;

    @NotBlank(message = "メールアドレスは必須です")
    @Email(message = "有効なメールアドレス形式で入力してください")
    @Size(max = 100, message = "メールアドレスは100文字以内で入力してください")
    public String userEmail;

    @NotBlank(message = "パスワードは必須です")
    @Size(min = 8, max = 100, message = "パスワードは8文字以上で入力してください")
    public String passwordHash;

    @Size(max = 255, message = "住所は255文字以内で入力してください")
    public String address;

    @Pattern(regexp = "^$|^0\\d{9,10}$", message = "正しい電話番号の形式で入力してください（ハイフンなし）")
    public String phoneNumber;

    @NotNull(message = "権限は必須です")
    public String role;

    public User(){

    }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role));
        }

//        @Override
//        public String getPassword(){
//            return this.passwordHash;
//        }
//
//
//
//        @Override
//        public String getUsername(){
//            return this.userName;
//        }

        @Override
        public String getUsername() {
        return userId; // Spring Securityには「userId」をユーザー名として扱ってもらう
        }

        @Override
        public boolean isAccountNonExpired() { return true; }

        @Override
        public boolean isAccountNonLocked() { return true; }

        @Override
        public boolean isCredentialsNonExpired() { return true; }

        @Override
        public boolean isEnabled() { return true; }




    public User(String userId,String userName,String userEmail,String passwordHash,String address,String phoneNumber,String role){
        this.userId=userId;
        this.userName=userName;
        this.userEmail=userEmail;
        this.passwordHash=passwordHash;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.role=role;
    }





    public String showUserInfo(){
        return "ユーザID："+userId+",ユーザ名："+userName+"ユーザメール："+userEmail+",パスワード："+passwordHash+",住所："+address+",電話番号："+phoneNumber;
    }
}

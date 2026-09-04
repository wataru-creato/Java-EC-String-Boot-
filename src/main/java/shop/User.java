package shop;

public class User {
    public String user_id;
    public String user_name;
    public String user_email;
    public String password_hash;
    public String address;
    public String phoneNumber;

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

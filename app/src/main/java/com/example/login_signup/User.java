package com.example.login_signup;

public class User {

    private String fullName, userName, phone, password;
     public User(){

     };
     public User(String fullName, String phone, String userName, String password){
            this.fullName = fullName;
            this.userName = userName;
            this.phone = phone;
            this.password = password;
     }
    public User(String fullName, String phone, String password){
        this.fullName = fullName;
        this.phone = phone;
        this.password = password;
    }
     public String getFullName(){
         return fullName;
     }
     public String getUserName(){
         return userName;
     }


    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }
}

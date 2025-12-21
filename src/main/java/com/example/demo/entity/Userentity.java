package com.example.demo.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Userentity{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdat;
    public void setId(Long id){
        this.id=id;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setCreatedat(LocalDateTime createdat){
        this.createdat=createdat;
    }
    public Long getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public LocalDateTime getCreatedat(){
        return  createdat;
    }
    public Userentity(){

    }
    public Userentity(Long id,String username,String email,String password,LocalDateTime createdat){
        this.id=id;
        this.username=username;
        this.email=email;
        this.password=password;
        this.createdat=createdat;
    }
}
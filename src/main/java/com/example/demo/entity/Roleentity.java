package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Roleentity{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
public void setId(Long id){
    this.id=id;
}
public void setUsername(String username){
    this.username=username;
}
public Long getId(){
    return id;
}
public String getUsername(){
    return username;
}
public Roleentity(){

}
public Roleentity(Long id,String username){
    this.id=id;
    this.username=username;
}

}
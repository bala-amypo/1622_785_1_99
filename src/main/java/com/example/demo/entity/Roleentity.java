package com.example.demo.entity;

public class Roleentity{
    private Long id;
    private String username;
public void setId(Long id){
    this.id=id;
}
public void setUsername(String username){
    this.username=username;
}
public Roleentity(){

}
public Roleentity(Long id,String username){
    this.id=id;
    this.username=username;
}

}
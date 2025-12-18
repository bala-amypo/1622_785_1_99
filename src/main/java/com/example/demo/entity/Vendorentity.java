package com.example.demo.entity;
import java.time.LocalDateTime;
public class Vendorentity{
    private Long id;
    private String vendorname;
    private String contactemail;
    private String phone;
    private LocalDateTime createdat;
public void setId(Long id){
    this.id=id;
}
public void setVendorname(String vendorname){
    this.vendorname=vendorname;
}
public void setContactemail(String contactemail){
    this.contactemail=contactemail;
}
public void setPhone(String phone){
    this.phone=phone;
}
public void setCreatedat(LocalDateTime createdat){
    this.createdat=createdat;
}
public Long getId(){
    return id;
}
public String getVendorname(){
    return vendorname;
}
public String getContactemail(){
    return contactemail;
}
public String getPhone(){
    return phone;
}
public LocalDateTime getcreatedat(){
    return createdat;
}

}
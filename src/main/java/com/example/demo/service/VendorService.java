package com.example.demo.service;
import com.example.demo.entity.Vendorentity;
import java.util.List;

public interface VendorService {
    Vendorentity postdata(Vendorentity ven);
    List<Vendorentity>getalldata();
    String deletedata(int id);
    Vendorentity getdata(int id);
    Vendorentity putdata(int id,Vendorentity ven);
}
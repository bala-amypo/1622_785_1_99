package com.example.demo.service.Impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.studentservice;
import com.example.demo.entity.studententity;
import com.example.demo.repository.studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class studentserviceimpl implements studentservice{
    @Autowired studentrepo student;
    @Override
   public studententity postdata(studententity stu){
    return student.save(stu);
        }
    @Override
   public List<studententity>getalldata(){
      return student.findAll();
   }
   @Override
   public String deletedata(int id){
      student.deleteById(id);
      return "Deleted Successfully";
   }
   @Override
    public studententity getdata(int id){
       return student.findById(id).orElse(null); 
    }
   @Override
   public studententity putdata(int id,studententity stu){
   if(student.existsById(id)){
     stu.setId(id);
     return student.save(stu);
   }
   return null;
   }
}
package com.example.SpringbootTableRelationshipsMapping.controller;

import com.example.SpringbootTableRelationshipsMapping.model.Address;
import com.example.SpringbootTableRelationshipsMapping.model.Student;
import com.example.SpringbootTableRelationshipsMapping.service.studentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class studentController {

    @Autowired
    studentService studentservice;

    @PostMapping("/student")
    public ResponseEntity<String>addStudent(@RequestBody String student){
        Student newstudent=setStudent(student);
       int studenid= studentservice.addStudent(newstudent);
        return new ResponseEntity<>("user added sussessfully with id "+ studenid, HttpStatus.CREATED);
    }


    public Student setStudent(String student){
        JSONObject json=new JSONObject(student);
        Student newstudent=new Student();

        newstudent.setName(json.getString("name"));
        newstudent.setAge(json.getString("age"));
        newstudent.setPhoneNumber(json.getString("phoneNumber"));
        newstudent.setBranch(json.getString("branch"));
        newstudent.setDepartment(json.getString("department"));
        JSONObject adjson= json.getJSONObject("address");
//        JSONObject adjson=new JSONObject(address);
        Address newaddress=new Address();
        newaddress.setLandmark(adjson.getString("landmark"));
        newaddress.setZipcode(adjson.getString("zipcode"));
        newaddress.setDistrict(adjson.getString("district"));
        newaddress.setState(adjson.getString("state"));
        newaddress.setCountry(adjson.getString("country"));
        newstudent.setAddress(newaddress);

        return newstudent;

    }

    @GetMapping("/getstudents")
    public List<Student> getSTudent(){
        return studentservice.getStudent();
    }

    @GetMapping("/student")
    public Student getstudentbId(@RequestParam Integer id){
        return studentservice.getstudentbyId(id);
    }
    @DeleteMapping("/deletestudent")
    public ResponseEntity<String> deleteStudent(@RequestParam Integer id){

        studentservice.deleteStudent(id);

        return new ResponseEntity<>("Student deleted with id"+id,HttpStatus.OK);
    }

    @PutMapping("/updatestudent")
    public ResponseEntity<String>updateStudent(@RequestParam Integer id,@RequestBody Student student){
        studentservice.updateStudent(id,student);
        return new ResponseEntity<>("student updated with ID "+id,HttpStatus.OK);
    }

}

package com.example.SpringbootTableRelationshipsMapping.controller;

import com.example.SpringbootTableRelationshipsMapping.dao.studentRepository;
import com.example.SpringbootTableRelationshipsMapping.model.Laptop;
import com.example.SpringbootTableRelationshipsMapping.model.Student;
import com.example.SpringbootTableRelationshipsMapping.service.laptopService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class laptopController {
    @Autowired
    laptopService laptopservice;
    @Autowired
    studentRepository studentrepository;

    @PostMapping("addlaptop")
    public ResponseEntity<String>addLaptop(@RequestBody String laptop){
        Laptop newlaptop=setLaptop(laptop);
        int id=laptopservice.addLaptop(newlaptop);
        return new ResponseEntity<>("laptop added with id "+id, HttpStatus.CREATED);
    }

@GetMapping("getlaptops")
public List<Laptop>getLaptops(){
        return laptopservice.getLaptops();
}
    private Laptop setLaptop(String _laptop) {
        JSONObject json=new JSONObject(_laptop);
        Laptop laptop=new Laptop();
        laptop.setName(json.getString("name"));
        laptop.setBrand(json.getString("brand"));
        laptop.setPrice(json.getInt("price"));
        Student student=studentrepository.findById(json.getInt("student")).get();
        laptop.setStudent(student);
        return laptop;

    }

    @PutMapping("updatelaptop")
    public ResponseEntity<String>updateLaptop(@RequestParam int id,@RequestBody String _laptop){
        Laptop laptop=setLaptop(_laptop);
        laptopservice.updateLaptop(id,laptop);
        return new ResponseEntity<>("laptop updated with id= "+id,HttpStatus.OK);
    }

    @DeleteMapping("deletelaptop")
    public ResponseEntity<String>deleteLaptop(@RequestParam int id){
        laptopservice.deleteLaptop(id);
        return new ResponseEntity<>("delete laptop id= "+id,HttpStatus.OK);
    }

}

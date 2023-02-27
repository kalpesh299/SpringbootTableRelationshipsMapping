package com.example.SpringbootTableRelationshipsMapping.service;

import com.example.SpringbootTableRelationshipsMapping.dao.laptopRepository;
import com.example.SpringbootTableRelationshipsMapping.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class laptopService {

    @Autowired
    laptopRepository laptoprepository;
    public int addLaptop(Laptop newlaptop) {
        Laptop laptop=laptoprepository.save(newlaptop);
        return laptop.getID();
    }
    public List<Laptop> getLaptops(){
        return laptoprepository.findAll();
    }

    public void deleteLaptop(int id) {
        laptoprepository.deleteById(id);
    }

    public void updateLaptop(int id, Laptop _laptop) {
        Laptop laptop=laptoprepository.findById(id).get();
        laptop.setName(_laptop.getName());
        laptop.setBrand(_laptop.getBrand());
        laptop.setPrice(_laptop.getPrice());
        laptop.setStudent(_laptop.getStudent());
        laptoprepository.save(laptop);
    }
}

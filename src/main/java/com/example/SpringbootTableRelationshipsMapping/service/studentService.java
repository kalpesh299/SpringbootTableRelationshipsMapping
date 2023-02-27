package com.example.SpringbootTableRelationshipsMapping.service;

import com.example.SpringbootTableRelationshipsMapping.dao.studentRepository;
import com.example.SpringbootTableRelationshipsMapping.model.Address;
import com.example.SpringbootTableRelationshipsMapping.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {
    @Autowired
    studentRepository studentrepository;

    public int addStudent(Student student){

Student savedstudent=studentrepository.save(student);
return savedstudent.getID();

    }

    public List<Student> getStudent(){
        return studentrepository.findAll();
    }
    public void deleteStudent(Integer id){
        studentrepository.deleteById(id);
    }
    public void updateStudent(Integer id,Student student){

        Student studenttobeupdate=studentrepository.findById(id).get();
        studenttobeupdate.setName(student.getName());
        studenttobeupdate.setAge(student.getAge());
        studenttobeupdate.setBranch(student.getBranch());
        studenttobeupdate.setDepartment(student.getDepartment());
        studenttobeupdate.setPhoneNumber(student.getPhoneNumber());
        studenttobeupdate.setAddress(student.getAddress());
        studentrepository.save(studenttobeupdate);


    }

    public Student getstudentbyId(Integer id) {
        return studentrepository.findById(id).get();
    }
}

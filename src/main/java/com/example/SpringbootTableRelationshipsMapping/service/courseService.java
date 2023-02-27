package com.example.SpringbootTableRelationshipsMapping.service;

import com.example.SpringbootTableRelationshipsMapping.dao.courseRepository;
import com.example.SpringbootTableRelationshipsMapping.model.Course;
import com.example.SpringbootTableRelationshipsMapping.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class courseService {
    @Autowired
    courseRepository courserepository;

    @Autowired
    studentService studentservice;
    public int addCourse(Course newcourse) {
         Course course= courserepository.save(newcourse);
          return course.getID();
    }

    public List<Course> getCourses() {
        return courserepository.findAll();
    }

    public void deleteCourse(int id) {
        courserepository.deleteById(id);
    }

    public void studentIntoCourse(Integer studentId, Integer courseId) {
        Optional<Course>optionalCourse=courserepository.findById(courseId);
        Student student=studentservice.getstudentbyId(studentId);
        Course course=optionalCourse.get();
        List<Student>studentList=course.getStudentList();
        studentList.add(student);
        courserepository.save(course);

    }
}

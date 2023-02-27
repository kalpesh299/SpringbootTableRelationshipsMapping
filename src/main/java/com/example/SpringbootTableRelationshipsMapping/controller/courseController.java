package com.example.SpringbootTableRelationshipsMapping.controller;

import com.example.SpringbootTableRelationshipsMapping.model.Course;
import com.example.SpringbootTableRelationshipsMapping.service.courseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class courseController {
    @Autowired
    courseService courseservice;

    @PostMapping("addcourse")
    public ResponseEntity<String>addCourse(@RequestBody String course){
        Course newcourse=setCourse(course);
        int id=courseservice.addCourse(newcourse);

        return new ResponseEntity<>("course added with id"+ id, HttpStatus.CREATED);
    }

    @GetMapping("getcourses")
    public List<Course> getCourses(){
        return courseservice.getCourses();
    }

    public Course setCourse(String _course){
        JSONObject json=new JSONObject(_course);
        Course course=new Course();
        course.setTitle(json.getString("title"));
        course.setDescription(json.getString("description"));
        course.setDuration(json.getString("duration"));

        return course;

    }
    @DeleteMapping("delecourse")
    public ResponseEntity<String>deleteCourse(@RequestParam int id){
        courseservice.deleteCourse(id);
        return new ResponseEntity<>("course deleted with id"+id,HttpStatus.OK);
    }

    @PostMapping("course-student")
public ResponseEntity<String> studentIntoCourse(@RequestParam Integer studentId,@RequestParam Integer courseId){
             courseservice.studentIntoCourse(studentId,courseId);
             return new ResponseEntity<>("student added in course",HttpStatus.OK);
    }

}

package com.nest.Course_backend.controller;

import com.nest.Course_backend.dao.CourseDao;
import com.nest.Course_backend.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseDao dao;
     @CrossOrigin(origins = "*")
    @PostMapping("/")
    public String Homepage(){
        return "welcome to course home page";
    }
    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
    public String AddCourse(@RequestBody Courses c)


    {
        System.out.println(c.getCoursetitle().toString());
        System.out.println(c.getDescription().toString());
        System.out.println(c.getVenue().toString());
        System.out.println(c.getDuration().toString());
        System.out.println(c.getDate().toString());
        dao.save(c);


        return "Course Added Successfully";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewall")
    public List<Courses> ViewAllCourse(){
        return (List<Courses>) dao.findAll()  ;
    }

}

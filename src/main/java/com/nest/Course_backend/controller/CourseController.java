package com.nest.Course_backend.controller;

import com.nest.Course_backend.model.Courses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
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

        return "Course Added Successfully";
    }

}

package com.nest.Course_backend.controller;

import com.nest.Course_backend.dao.CourseDao;
import com.nest.Course_backend.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {
    @Autowired
    private CourseDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
    public Map<String,String> AddCourse(@RequestBody Courses c)


    {
        System.out.println(c.getCoursetitle().toString());
        System.out.println(c.getDescription().toString());
        System.out.println(c.getVenue().toString());
        System.out.println(c.getDuration().toString());
        System.out.println(c.getDate().toString());
        dao.save(c);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;



    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewall")
    public List<Courses> ViewAllCourse(){
        return (List<Courses>) dao.findAll()  ;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/search",consumes ="application/json",produces = "application/json")
    public List<Courses> SearchCourses(@RequestBody  Courses c) {
        String coursetitle = c.getCoursetitle().toString();
        System.out.println(coursetitle);
        return (List<Courses>) dao.SearchCourses(c.getCoursetitle());

    }
}

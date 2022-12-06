package com.nest.Course_backend.dao;

import com.nest.Course_backend.model.Courses;
import org.springframework.data.repository.CrudRepository;

public interface CourseDao extends CrudRepository<Courses,Integer> {
}

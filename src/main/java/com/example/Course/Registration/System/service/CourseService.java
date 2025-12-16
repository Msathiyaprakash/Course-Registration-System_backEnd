package com.example.Course.Registration.System.service;

import com.example.Course.Registration.System.model.Course;
import com.example.Course.Registration.System.model.CourseRegistry;
import com.example.Course.Registration.System.repository.CourseRegistryRepository;
import com.example.Course.Registration.System.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseRegistryRepository courseRegistryRepository;


    public List<Course> availableCourses()
    {
        return courseRepository.findAll();

    }

    public List<CourseRegistry> enrolledStudents()
    {
        return courseRegistryRepository.findAll();

    }

//    public void enrollCourse(String name, String emailId, String courseName){
//        CourseRegistry courseRegistry=new CourseRegistry(name, emailId, courseName);
//        courseRegistryRepository.save(courseRegistry);
//    }

    public void enrollCourse(CourseRegistry courseRegistry)
    {
        courseRegistryRepository.save(courseRegistry);
    }

}

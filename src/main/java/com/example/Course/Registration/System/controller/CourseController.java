package com.example.Course.Registration.System.controller;

import com.example.Course.Registration.System.model.Course;
import com.example.Course.Registration.System.model.CourseRegistry;
import com.example.Course.Registration.System.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")    // *** solves cors api problem , html local host address
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> availableCourses(){
        System.out.println("availableCourses called");
        return courseService.availableCourses();
    }

    @GetMapping("/courses/enrolled")
    public List<CourseRegistry> enrolledStudents(){
        System.out.println("enrolledStudents called");
        return courseService.enrolledStudents();
    }

//    public String enrollCourse(@RequestParam("name") String name,
//                               @RequestParam("emailId") String emailId,
//                               @RequestParam("courseName") String courseName){
//        System.out.println("enrollCourse called");
//        courseService.enrollCourse(name, emailId, courseName);
//        return "Congratulations "+name+" Enrollment successful for "+courseName;
//    }


    // RequestBody - perfect for direct json formats
    // ModelAttribute - perfect for frontend technologies

    @PostMapping("/courses/register")
    public String enrollCourse(@ModelAttribute CourseRegistry courseRegistry){
        System.out.println("enrollCourse called");
        courseService.enrollCourse(courseRegistry);
        String name = courseRegistry.getName();
        String courseName = courseRegistry.getCourseName();
        System.out.println("Congratulations "+name+" Enrollment successful for "+courseName);
        return "Congratulations "+name+" Enrollment successful for "+courseName;
    }



}

package com.chandu.spring.security.controller;

import com.chandu.spring.security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController
{
    List<Student> studentList=new ArrayList<>(List.of(
        new Student(1,"Sai chandu","Java"),
                new Student(2,"Jenny","Python"),
                new Student(3,"Dinesh","DevOps"),
                new Student(4,"Dhanush","ML")
        ));

    @GetMapping("/all")
    public List<Student> getStudents()
    {
        return studentList;
    }

    @PostMapping("/add")
    public void add(@RequestBody Student student)
    {
        studentList.add(student);
    }

    @GetMapping("/csrftoken")
    public CsrfToken getCsrf(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}

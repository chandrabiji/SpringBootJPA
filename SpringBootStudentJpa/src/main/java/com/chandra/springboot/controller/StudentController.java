package com.chandra.springboot.controller;

import com.chandra.springboot.entity.Student;
import com.chandra.springboot.resitory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentRepository repo;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return  repo.save(student);
    }

    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return  (List<Student>) repo.findAll();
    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable String id)
    {
        Optional<Student> dbStdent = repo.findById(id);
        if(dbStdent.isPresent())
            return dbStdent.get();
        return null;
    }
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student)
    {
        return repo.save(student);
    }
    @DeleteMapping("/student/{id}")
    public Student deleteStudent(@PathVariable String id){
        repo.deleteById(id);
        return getStudentById(id);
    }

}

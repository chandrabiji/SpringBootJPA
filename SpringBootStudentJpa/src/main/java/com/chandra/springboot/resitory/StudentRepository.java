package com.chandra.springboot.resitory;
import com.chandra.springboot.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,String> {
}

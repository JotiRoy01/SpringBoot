package bd.learn.curdDTOs.controller;

import bd.learn.curdDTOs.entity.Student;
import bd.learn.curdDTOs.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {

    StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    //create
    public ResponseEntity<Student> create(@RequestBody Student student){
        Student studentResponse =  studentService.creteStudent(student);
        return ResponseEntity.ok(studentResponse);
    }
    //read

    //update

    //update
}

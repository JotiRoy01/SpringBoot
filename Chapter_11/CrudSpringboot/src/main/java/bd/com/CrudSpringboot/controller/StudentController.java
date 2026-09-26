package bd.com.CrudSpringboot.controller;

import bd.com.CrudSpringboot.dto.CreateStudentRequestDTO;
import bd.com.CrudSpringboot.dto.CreateStudentResponseDTO;
import bd.com.CrudSpringboot.dto.UpdateStudentRequestDTO;
import bd.com.CrudSpringboot.entity.Student;
import bd.com.CrudSpringboot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bd.com.CrudSpringboot.dto.UpdateStudentResponseDTO;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // create student
    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDTO> createStudent(
            @Valid @RequestBody CreateStudentRequestDTO createStudentRequestDTO) {
        CreateStudentResponseDTO createStudent = studentService.createStudent(createStudentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createStudent);

    }

    // read student
    @GetMapping("/get/{id}")
    public ResponseEntity<CreateStudentResponseDTO> getStudent(@PathVariable Long id){
        CreateStudentResponseDTO studentResp = studentService.getStudent(id);
//
//        if (studentResp == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
        return ResponseEntity.ok(studentResp);
    }

    // read student
    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudent(){
        List<CreateStudentResponseDTO> studentList = studentService.getAllStudent();
//
//        if (studentList.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok(studentList);
    }

    // update
    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateStudentResponseDTO> updateStudent(@PathVariable Long id, @RequestBody UpdateStudentRequestDTO studentReq){
        UpdateStudentResponseDTO studentResp = studentService.updateStudent(id, studentReq);

//        if (studentResp == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
        return ResponseEntity.ok(studentResp);
    }

    // delete student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        /*Boolean isDelete = */studentService.deleteStudent(id);

//        if(!isDelete){
//           return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok("Record Deleted");
    }

    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id){
        /*Boolean isDeleted = */studentService.deleteStudentSoftly(id);

//        if(!isDeleted){
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok("Record Deleted");
    }
}

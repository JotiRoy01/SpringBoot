package bd.learn.curdDTOs.service;

import bd.learn.curdDTOs.entity.Student;
import bd.learn.curdDTOs.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student creteStudent(Student student){
        return studentRepository.save(student);

    }

}

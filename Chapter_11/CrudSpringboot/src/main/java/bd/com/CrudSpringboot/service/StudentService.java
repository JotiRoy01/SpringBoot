package bd.com.CrudSpringboot.service;

import bd.com.CrudSpringboot.dto.CreateStudentRequestDTO;
import bd.com.CrudSpringboot.dto.CreateStudentResponseDTO;
import bd.com.CrudSpringboot.dto.UpdateStudentRequestDTO;
import bd.com.CrudSpringboot.dto.UpdateStudentResponseDTO;
import bd.com.CrudSpringboot.entity.Student;
import bd.com.CrudSpringboot.exception.DuplicateResourceException;
import bd.com.CrudSpringboot.exception.ResourcNotFoundException;
import bd.com.CrudSpringboot.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO createStudentRequestDTO) {
        Student student = mapToEntity(createStudentRequestDTO);

        if(emailExists(student)){
            throw new DuplicateResourceException("Student with email "+student.getEmail()
                    +" already exists");
        }

        Student studentRes = studentRepository.save(student);

        return mapToDTO(studentRes);
    }

    // get student
    public CreateStudentResponseDTO getStudent(Long id){
        Student studentResp = studentRepository.findById(id)
                        .orElseThrow(() -> new ResourceAccessException("Student with id" + id + "not found"));

        return mapToDTO(studentResp);
    }

    public List<CreateStudentResponseDTO> getAllStudent(){
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        // return list of DTOs
        return studentList.stream()
                .map(this::mapToDTO)
                .toList();
    }

    // Updated Student
    public UpdateStudentResponseDTO updateStudent(Long id, UpdateStudentRequestDTO studentReq){
        // find the student by id
        Student existingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() ->
                        new ResourcNotFoundException("Student with id" + id + "not found"));

//        if (existingStudent.isEmpty()){
//            return null;
//        }
        // pull all database entity
        //Student studentToSave = existingStudent;

        // set the field by new post request information
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setName(studentReq.getName());
        existingStudent.setRoll(studentReq.getRoll());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setUpdatedAt(LocalDateTime.now());
        existingStudent.setDeleted(false);

        Student saveStudent = studentRepository.save(existingStudent);

        return mapToUpdateDTO(saveStudent);

    }

    public void deleteStudent(Long id){
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(() -> new ResourcNotFoundException("Student with id" + id + "not found"));


//        if(!isStudent)
//        {
//            return false;
//        }
//        studentRepository.deleteById(id);
        studentRepository.delete(studentToBeDeleted);

        //return true;
    }

    public void deleteStudentSoftly(Long id){

        Student studentToBeDeleted = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourcNotFoundException("Student with id" + id + "not found"));

//        if(existingStudent.isEmpty()){
//            return false;
//        }

       // Student studentToSave = existingStudent.get();
        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);
        //return true;
    }
    // 1. End point listen (/app/students POST)
    // 2. Business logic
    // 3. Interact with the database (Repository)
    // 4. Return the response to the client

    // This method is used to get the student by id

    private Student mapToEntity(CreateStudentRequestDTO createStudentRequestDTO){
        Student student = new Student();

        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setEmail(createStudentRequestDTO.getEmail());
        student.setSubject(createStudentRequestDTO.getSubject());
        student.setRoll(createStudentRequestDTO.getRoll());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setDeleted(false);
        return student;
    }

    private CreateStudentResponseDTO mapToDTO(Student student){

        CreateStudentResponseDTO responseDTO = new CreateStudentResponseDTO();

        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setRoll(student.getRoll());
        responseDTO.setSubject(student.getSubject());

        responseDTO.setId(student.getId());
        responseDTO.setMessage("Student Save Successfully");
        responseDTO.setCreatedAt(student.getCreatedAt());
        responseDTO.setUpdatedAt(student.getUpdatedAt());

        return responseDTO;
    }

    private UpdateStudentResponseDTO mapToUpdateDTO(Student student){
        UpdateStudentResponseDTO responseDTO = new UpdateStudentResponseDTO();

        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setRoll(student.getRoll());
        responseDTO.setSubject(student.getSubject());

        responseDTO.setId(student.getId());
        responseDTO.setMessage("Student Updated Successfully");
        responseDTO.setUpdatedAt(student.getUpdatedAt());
        return responseDTO;
    }

    private boolean emailExists(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }

}

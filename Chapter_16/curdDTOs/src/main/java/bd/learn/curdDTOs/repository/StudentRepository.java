package bd.learn.curdDTOs.repository;

import bd.learn.curdDTOs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

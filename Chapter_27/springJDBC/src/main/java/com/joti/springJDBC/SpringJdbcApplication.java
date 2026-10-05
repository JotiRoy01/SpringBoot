package com.joti.springJDBC;

import com.joti.springJDBC.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);

		//StudentRepository studentRepository = new StudentRepository();

		//studentRepository.createStudent(new Student("Rohan", "rohan@gmail.com", 21));

//        studentRepository.updateStudent(
//                new Student("Rohit Negi", "rohit@gmail.com", 26), 8L);

		//studentRepository.deleteStudent(9L);

		//studentRepository.getStudent();
	}

}

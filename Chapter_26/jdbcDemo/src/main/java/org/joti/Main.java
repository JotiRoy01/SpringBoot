package org.joti;

import org.joti.model.Student;
import org.joti.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] agrs) {
        System.out.println("joti");

        StudentRepository studentRepository = new StudentRepository();

        studentRepository.createUser(new Student("Tushar", "tushar@gamil.com", 18));

//        studentRepository.updatedUser();

//        studentRepository.getUserById();
//        String url = "jdbc:mysql://localhost:3306/student_db";
//        String username = "root";
//        String password = "mysql";
//
//        try {
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            System.out.println("Database connected successfully");
//            connection.close();
//        }catch (SQLException e){
//            System.out.println("Database connection failed");
//            e.printStackTrace();
//        }
    }
}

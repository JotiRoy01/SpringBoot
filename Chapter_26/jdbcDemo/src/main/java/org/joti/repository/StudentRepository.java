package org.joti.repository;

import org.joti.model.Student;

import java.sql.*;

public class StudentRepository {
    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "mysql";

    Connection connection = null;
    PreparedStatement preparedStatement;

    public void createUser(Student student) {
        try {
            connection = DriverManager.getConnection(url, username, password);

//            Statement statement = connection.createStatement();

//            String sql = """
//            Insert Into student(name, email, age)
//            values ('%s', '%s',%d)
//            """.formatted(student.getName(), student.getEmail(), student.getAge());

            String sql = """
                    insert into student(name, email, age)
                    values(?, ?, ?)
                    """;

            preparedStatement = connection.prepareStatement(sql);

//            int result = statement.executeUpdate(sql);

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected == 1){
                System.out.println("Create Student Successfully");
            }
            else {
                System.out.println("Student create faild");
            }

//            if(result == 1){
//                System.out.println("Create operation successful");
//            }
//            else {
//                System.out.println("Connection Failed");
//            }

            //System.out.println("Database connected successfully");
           // connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
//        finally {
//            try {
//                connection.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//
//            try {
//                connection.close();
//            }
//            catch (SQLException e){
//                e.printStackTrace();
//            }
//        }

    }

//    public void createUser() {
//        try {
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            Statement statement = connection.createStatement();
//
//            String sql = "Insert Into student(name, email, age) values ('Joti', 'joti@gamil.com',27)";
//
//            int result = statement.executeUpdate(sql);
//
//            if(result == 1){
//                System.out.println("Create operation successful");
//            }
//            else {
//                System.out.println("Connection Failed");
//            }
//
//            //System.out.println("Database connected successfully");
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println("Database connection failed");
//            e.printStackTrace();
//        }
//    }


    public void updatedUser() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "UPDATE student set age = 26 where id=1";

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("Update operation successfully run");
            }
            else {
                System.out.println("Connection Failed");
            }

            //System.out.println("Database connected successfully");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    public void getUserById() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "select * from student where id=1";

            ResultSet result = statement.executeQuery(sql);
            result.next();

            Student student = mapRow(result);

            System.out.println(student);

            //System.out.println("Database connected successfully");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    public void completeCRUD() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "select id, name, email,age from student where id=1";

            boolean result = statement.execute(sql);

            if(result){
                ResultSet resultSet = statement.getResultSet();
            }
            else {
                int rowAffected = statement.getUpdateCount();
            }



            //System.out.println("Database connected successfully");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();

        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));

        return student;
    }
}

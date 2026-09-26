package bd.com.CrudSpringboot.dto;


import jakarta.validation.constraints.*;

public class CreateStudentRequestDTO {
    @NotBlank(message = "Name cannot be null/Empty or blank")
    @Size(min = 2, max = 50, message = "Student must within 2 to 50 character long")
    private String name;
    @Email
    private String email;
    @Min(value = 18)
    private int age;
    @NotNull
    private int roll;
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

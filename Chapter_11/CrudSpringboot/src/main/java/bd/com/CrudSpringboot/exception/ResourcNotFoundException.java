package bd.com.CrudSpringboot.exception;

public class ResourcNotFoundException extends RuntimeException{
    public ResourcNotFoundException(String message){
        super(message);
    }
}

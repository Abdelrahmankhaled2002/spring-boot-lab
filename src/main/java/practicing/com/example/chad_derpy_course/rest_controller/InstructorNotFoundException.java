package practicing.com.example.chad_derpy_course.rest_controller;

public class InstructorNotFoundException extends  RuntimeException{

    public InstructorNotFoundException(String message) {
        super(message);
    }

    public InstructorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstructorNotFoundException(Throwable cause) {
        super(cause);
    }
}

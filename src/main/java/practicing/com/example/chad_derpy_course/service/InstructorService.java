package practicing.com.example.chad_derpy_course.service;
import practicing.com.example.chad_derpy_course.entity.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor findById(int id);
    List<Instructor> findAll();
    public Instructor save(Instructor instructor);
    void deleteById(int id);

}

package practicing.com.example.chad_derpy_course.dao;


import practicing.com.example.chad_derpy_course.entity.Instructor;

import java.util.List;

public interface InstructorDAO {
    Instructor findById(int id);
    List<Instructor> findAll();
    public Instructor save(Instructor instructor);
    void deleteById(int id);


}

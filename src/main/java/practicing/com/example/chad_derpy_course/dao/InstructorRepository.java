package practicing.com.example.chad_derpy_course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import practicing.com.example.chad_derpy_course.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {
}

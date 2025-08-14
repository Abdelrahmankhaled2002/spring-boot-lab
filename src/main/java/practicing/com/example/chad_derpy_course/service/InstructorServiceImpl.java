package practicing.com.example.chad_derpy_course.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practicing.com.example.chad_derpy_course.dao.InstructorDAO;
import practicing.com.example.chad_derpy_course.entity.Instructor;
import java.util.List;

@Service
public class InstructorServiceImpl implements  InstructorService{
    InstructorDAO instructorDAO;
    @Autowired
    InstructorServiceImpl(InstructorDAO instructorDAO){
        this.instructorDAO= instructorDAO;
    }

    @Override
    public Instructor findById(int id) {
        return instructorDAO.findById(id);
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDAO.findAll();
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return instructorDAO.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        instructorDAO.deleteById(id);
    }
}

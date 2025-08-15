package practicing.com.example.chad_derpy_course.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practicing.com.example.chad_derpy_course.dao.InstructorRepository;
import practicing.com.example.chad_derpy_course.entity.Instructor;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements  InstructorService{
    InstructorRepository instructorRepository;
    @Autowired
    InstructorServiceImpl(InstructorRepository instructorRepository){
        this.instructorRepository= instructorRepository;
    }

    @Override
    public Instructor findById(int id) {
        Optional<Instructor>instructor=instructorRepository.findById(id);
        Instructor tempInstructor=null;
        if(instructor.isPresent()){
            tempInstructor= instructor.get();
        }
        return tempInstructor;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        instructorRepository.deleteById(id);
    }
}
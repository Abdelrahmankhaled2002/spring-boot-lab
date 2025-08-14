package practicing.com.example.chad_derpy_course.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practicing.com.example.chad_derpy_course.entity.Instructor;

import java.util.List;

@Repository
public class InstructorDAOImpl implements InstructorDAO {
    EntityManager em;
    @Autowired
    InstructorDAOImpl(EntityManager em) {
        this.em = em;
    }



    @Override
    public Instructor findById(int id) {
        return  em.find(Instructor.class,id);
    }

    @Override
    public List<Instructor> findAll() {
        TypedQuery<Instructor>typedQuery = em.createQuery("from Instructor", Instructor.class);
        List<Instructor>instructors = typedQuery.getResultList();
        return instructors;
    }

    @Override
    public Instructor save(Instructor instructor) {
        return em.merge(instructor);
    }

    @Override
    public void deleteById(int id) {
        //find the instructor by
        Instructor theInstructor=em.find(Instructor.class,id);

        //then delete it
        em.remove(theInstructor);
    }


}

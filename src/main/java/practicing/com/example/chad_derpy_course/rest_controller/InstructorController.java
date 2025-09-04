package practicing.com.example.chad_derpy_course.rest_controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practicing.com.example.chad_derpy_course.entity.Instructor;
import practicing.com.example.chad_derpy_course.service.InstructorService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class InstructorController {
    InstructorService instructorService;
    ObjectMapper objectMapper;
    @Autowired
    InstructorController(InstructorService instructorService,ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.instructorService = instructorService;
    }
    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors() {
        return instructorService.findAll();
    }
    @GetMapping("/instructors/{instructorId}")
    public Instructor getInstructor(@PathVariable int instructorId) {
        Instructor instructor = instructorService.findById(instructorId);
        if(instructor == null){
            throw new RuntimeException("instructor id not found:"+ instructorId);
        }else {
            return instructor;
        }
    }

    @PostMapping("/instructors")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
//        instructor.setInsId(0);
        return instructorService.save(instructor);
    }

    @PutMapping("/instructors")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.save(instructor);
    }

    @PatchMapping("/instructors/{instructorId}")
    public Instructor patchInstructor(@RequestBody Map<String,Object> patchPayLoad, @PathVariable int instructorId) {
        Instructor instructorTemp = instructorService.findById(instructorId);
        if(instructorTemp == null){
            throw new InstructorNotFoundException("instructor id not found:"+ instructorId);
        }else if(patchPayLoad.containsKey("insId")){
            throw new RuntimeException("id cannot be ubdated"+ instructorId);
        }else{
            Instructor patchInstructor=apply(patchPayLoad,instructorTemp);
            return instructorService.save(patchInstructor);
        }
    }

    private Instructor apply(Map<String, Object> patchPayLoad, Instructor instructorTemp) {
        ObjectNode InstructorNode=objectMapper.convertValue(instructorTemp, ObjectNode.class);

        ObjectNode patchNode=objectMapper.convertValue(patchPayLoad, ObjectNode.class);

        InstructorNode.setAll(patchNode);
        return  objectMapper.convertValue(InstructorNode,Instructor.class);
    }

    @DeleteMapping("/instructors/{instructorId}")
    public String deleteEmployee(@PathVariable int instructorId) {
        Instructor tempInstructor=instructorService.findById(instructorId);
        if(tempInstructor == null){
            throw new RuntimeException("instructor id not found:"+ instructorId);
        }else{
            instructorService.deleteById(instructorId);
            return "deleted instructor successfully"+instructorId;
        }
    }


}

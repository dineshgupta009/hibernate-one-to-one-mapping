package com.hibernate.Hibernate.one.to.one.mapping.Controller;

import com.hibernate.Hibernate.one.to.one.mapping.Exception.ResourceNotFoundException;
import com.hibernate.Hibernate.one.to.one.mapping.Model.Instructor;
import com.hibernate.Hibernate.one.to.one.mapping.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private InstructorRepository instructorRepository;


    @GetMapping("/instructors")
    public List<Instructor> getInstructors() {
        return instructorRepository.findAll();
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity< Instructor > getInstructorById(
            @PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
        Instructor user = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/instructors")
    public Instructor createUser( @RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @PutMapping("/instructors/{id}")
    public ResponseEntity < Instructor > updateUser(
            @PathVariable(value = "id") Long instructorId,
             @RequestBody Instructor userDetails) throws ResourceNotFoundException {
        Instructor user = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
        user.setEmail(userDetails.getEmail());
        final Instructor updatedUser = instructorRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/instructors/{id}")
    public Map< String, Boolean > deleteUser(
            @PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));

        instructorRepository.delete(instructor);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

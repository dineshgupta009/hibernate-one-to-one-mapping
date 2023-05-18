package com.hibernate.Hibernate.one.to.one.mapping.Repository;

import com.hibernate.Hibernate.one.to.one.mapping.Model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}

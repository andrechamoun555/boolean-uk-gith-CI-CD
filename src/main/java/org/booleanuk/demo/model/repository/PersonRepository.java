package org.booleanuk.demo.model.repository;

import org.booleanuk.demo.model.jpa.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Integer id(int id);
}

package org.booleanuk.demo.controller;

import org.booleanuk.demo.model.jpa.Person;
import org.booleanuk.demo.model.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person findOne(@PathVariable int id){
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public Person update(@RequestBody Person person,  @PathVariable int id){
        return personRepository.findById(id)
                .map(existing -> {
                    existing.setName(person.getName());
                    existing.setEmail(person.getEmail());
                    return personRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @DeleteMapping("/{id}")
    public Person delete(@PathVariable int id){
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        personRepository.delete(person);
        return person;
    }
}

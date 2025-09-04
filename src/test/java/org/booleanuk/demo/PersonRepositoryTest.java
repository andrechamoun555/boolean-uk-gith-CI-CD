package org.booleanuk.demo;

import org.booleanuk.demo.model.jpa.Person;
import org.booleanuk.demo.model.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // force H2
class PersonRepositoryTest {

    @Autowired
    private PersonRepository repo;

    @Test
    void canPersistAndReadBack() {
        Person saved = repo.save(new Person("Andre", "andre@example.com"));
        assertThat(saved.getId()).isNotNull();
        assertThat(repo.findById(saved.getId())).isPresent();
    }
}

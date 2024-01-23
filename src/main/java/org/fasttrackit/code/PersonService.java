package org.fasttrackit.code;

import org.fasttrackit.code.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonService {
    private List<Person> persons;

    public PersonService() {
        this.persons = Arrays.asList(
                Person.builder()
                        .name("Mihai")
                        .age(22)
                        .job("Student")
                        .build(),
                Person.builder()
                        .name("Ana")
                        .age(44)
                        .job("CEO")
                        .build(),
                Person.builder()
                        .name("Ioana")
                        .age(25)
                        .job("Teacher")
                        .build()
        );
    }

    public Optional<Person> findPersonByNameWithOptional(String name) {
        // this is correct but I wanted to show the ofNullable function
//        if(name == null){
//            return Optional.empty();
//        }
        String nameNotNull = Optional.ofNullable(name)
                .orElse("");
        for (Person person : persons) {
            if (nameNotNull.equals(person.name())) {
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }

    public Person findPersonByNameWithoutOptional(String name) {
        for (Person person : persons) {
            if (person.name().equals(name)) {
                return person;
            }
        }
        return null;
    }
}

package org.fasttrackit.code.optional;

import org.fasttrackit.code.PersonService;
import org.fasttrackit.code.model.Person;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        PersonService service = new PersonService();

//        Person foundPerson = service.findPersonByNameWithoutOptional("Jojo");
//        System.out.println(foundPerson.name());

        Optional<Person> optionalOfPerson = service.findPersonByNameWithOptional("Mihai");

        if(optionalOfPerson.isPresent()){
            Person person = optionalOfPerson.get();
            System.out.println(person.name());
        } else {
            System.out.println("No person was found");
        }

        Person person = optionalOfPerson.orElse(Person.builder()
                .name("Default Person")
                .age(1)
                .job("Default Job")
                .build());

        System.out.println(person.name());
        optionalOfPerson.isEmpty();

        String justTheName = optionalOfPerson.map(personFound -> {
            System.out.println("Just the name");
            return personFound.name();
        }).orElse("No name!");

        optionalOfPerson.ifPresent(person1-> System.out.println(person1.age()));

      //  optionalOfPerson.orElseThrow(()-> new RuntimeException());

        service.findPersonByNameWithOptional(null);
    }
}

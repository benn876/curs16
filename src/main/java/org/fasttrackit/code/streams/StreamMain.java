package org.fasttrackit.code.streams;

import org.fasttrackit.code.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
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
                        .name("George")
                        .age(44)
                        .job("CEO")
                        .build(),
                Person.builder()
                        .name("Ioana")
                        .age(25)
                        .job("Teacher")
                        .build()
        );

        Stream<Person> stream = persons.stream();

        List<Person> result = persons.stream()
                .filter(person -> person.age() > 30)
                .filter(person -> person.name().startsWith("A"))
                .toList();
        System.out.println(result);

        List<Integer> namesLength = persons.stream()
                .map(Person::name)
                .map(String::length)
                .toList();

        System.out.println(namesLength);
        System.out.println(persons);

        List<Person> skipElements = persons.stream()
                .skip(2)
                .toList();
        System.out.println(skipElements);

        List<Person> limitPersons = persons.stream()
                .limit(2)
                .toList();
        System.out.println(limitPersons);

        List<Integer> integers = List.of(1, 2, 1, 4, 2, 1, 5, 6, 22, 34, 52, 22);
        List<Integer> distinctIntegers = integers.stream()
                .distinct()
                .toList();
        System.out.println(distinctIntegers);

        Set<Integer> uniqueAge = persons.stream()
                .map(Person::age)
                .collect(Collectors.toSet());
        System.out.println(uniqueAge);

        long count = persons.stream()
                .filter(person -> person.name().startsWith("M"))
                .count();
        System.out.println(count);

        boolean allMajor = persons.stream()
                .allMatch(person -> person.age() > 18);
        System.out.println(allMajor);

        boolean anyMat = persons.stream()
                .anyMatch(person -> person.age() > 30);
        System.out.println(anyMat);

        Optional<Person> optionalPerson = persons.stream()
                .filter(person -> person.age() > 50)
                .findFirst();

        optionalPerson.ifPresent(person-> System.out.println("Person older than 50"));
    }
}

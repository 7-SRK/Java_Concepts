package Java_8;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;


    public Person(String name) {
        this.name = name;
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    public void printMyName() {
        System.out.println("Person's name: " + name);
    }
}

public class MethodReferences {
    public static void main(String[] args) {


        List<Person> personList = Arrays.asList(
                new Person("A", 10),
                new Person("B", 20),
                new Person("C", 30)
        );

        // 1. Method reference to an instance method of an arbitrary object of a particular type
        System.out.println("Printing persons using method reference:");
        personList.forEach(System.out::println);

        // 2. Using map with method reference to get ages
        System.out.println("\nAges of persons:");
        personList.stream()
                .map(Person::getAge)
                .forEach(System.out::println);

        // 3. Constructor reference to create Person objects from names
        List<String> names = Arrays.asList("D", "E", "F");
        List<Person> peopleFromNames = names.stream()
                .map(Person::new)  // Constructor reference
                .collect(Collectors.toList());

        System.out.println("\nPeople created from names:");
        peopleFromNames.forEach(System.out::println);  // Age will be 0 by default

        // 4. Instance method reference of a particular object
        Person specialPerson = new Person("G", 40);
        System.out.println("\nUsing instance method reference of a particular object:");
        names.forEach(name -> specialPerson.printMyName());  // Using lambda
        // Using method reference (calls printMyName() on specialPerson for each element)
        names.forEach(name -> specialPerson.printMyName());  // Same effect, but method reference example:
        // names.forEach(specialPerson::printMyName); // Uncomment to use method reference

    }
}


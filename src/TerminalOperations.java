import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
        List<Person> persons = List.of(new Person("Dennis"), new Person("Anna"), new Person("Zoe"));
        List<String> personNames = persons.stream().map(Person::getName).collect(Collectors.toList());

        System.out.println(personNames); // Dennis, Anna, Zoe

        persons = List.of(new Person("Dennis"), new Person("Anna"), new Person("Zoe"));
        long count = persons.stream().map(Person::getName).filter(p -> p.length() < 5).count();

        System.out.println(count); // 2 (Zoe and Anna fullfill our filter predicate

        persons = List.of(new Person("Dennis"), new Person("Anna"), new Person("Zoe"));
        boolean listContainsDennis = persons.stream().anyMatch(person -> person.getName().contains("Dennis"));

        System.out.println(listContainsDennis); // true

        persons = List.of(new Person("Dennis"), new Person("Anna"), new Person("Zoe"));
        boolean listWithOnlyDennis = persons.stream().allMatch(person -> person.getName().contains("Dennis"));

        System.out.println(listWithOnlyDennis); // false


        persons = List.of(new Person("Dennis"), new Person("Anna"), new Person("Zoe"));
        Optional<Person> reduce = persons.stream().reduce((person, person2) -> new Person(person.getName() + person2.getName()));

        System.out.println(reduce.get().toString()); // false

        persons = List.of(new Person("Dennis", 12), new Person("Anna", 10), new Person("Zoe", 14), new Person("Anna", 10));


        Map<List<Object>, List<Person>> personsGroupByNameAndAge = groupByNameAndAge(persons.stream());
        System.out.println(personsGroupByNameAndAge); // output

    }

    public static Map<List<Object>, List<Person>> groupByNameAndAge(Stream<Person> stream) {
        return stream.collect(Collectors.groupingBy(p -> Arrays.asList(p.getName(), p.getAge())));
    }


}


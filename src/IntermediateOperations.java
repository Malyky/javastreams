import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.lang.String.CASE_INSENSITIVE_ORDER;

public class IntermediateOperations {
    public static void main(String[] args) {
        List<String> names = List.of("Dennis", "Anna", "Zoe");
        List<String> namesWithN = names.stream()
                .filter(predicate -> predicate.contains("n"))
                .collect(Collectors.toList());
        System.out.println(namesWithN); // Producates Dennis and Anna --> Zoe will be filtered out


        List<String> lowerCaseNames = names
                .stream()
                .map(string -> string.toLowerCase(Locale.ROOT))
                .toList();
        System.out.println(lowerCaseNames); // prints out dennis, anna, zoe

        names = List.of("Dennis", "Dennis", "Anna");
        List<String> distinctNames = names
                .stream()
                .distinct()
                .toList();
        System.out.println(distinctNames); // prints out Dennis, Anna

        List<Person> people = List.of(
                new Person("Alice", List.of("555-1234", "555-5678")),
                new Person("Bob", List.of("555-8765", "555-4321")),
                new Person("Charlie", List.of("555-1111", "555-2222")));

        List<String> allPhoneNumbers = people.stream()
                .flatMap(person -> person.getPhoneNumbers().stream())
                .collect(Collectors.toList());

        System.out.println(allPhoneNumbers); // Output: [555-1234, 555-5678, 555-8765, 555-4321, 555-1111, 555-2222]

        List<String> unorderdNames = List.of("Dennis", "Zoe", "Anna");
        List<String> orderedNames = unorderdNames.stream()
                .sorted()
                .toList();
        System.out.println(orderedNames); // prints out Anna, Dennis, Zoe -- in that order

        List<String> peekedNames = List.of("Dennis", "Zoe", "Anna");
        peekedNames.stream()
                .peek(name -> System.out.println("Executed in peek:" + name))
                .toList();
        // output:
        //Executed in peek:Dennis
        //Executed in peek:Zoe
        //Executed in peek:Anna
    }
}

class Person {
    private final String name;
    private final List<String> phoneNumbers;

    public Person(String name, List<String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}

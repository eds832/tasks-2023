import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * We have a class Person(name, nationality, age) it has all getters.
 * Task: Compute average age per nationality. Sample output: {American: 25, German: 27, Polish: 20}
 */
class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Julia", "Polish", 20),
            new Person("Joe", "American", 24),
            new Person("Tom", "American", 26),
            new Person("Robbin", "German", 27)
        );
        System.out.println(getAverageAgePerNationality(people));
    }

    static String getAverageAgePerNationality(List<Person> people) {
        if (people == null) {
            throw new IllegalArgumentException("list of people is null");
        }
        return people.stream().peek(p -> {
                if (p.getAge() < 0 || p.getNationality() == null) {
                    throw new IllegalArgumentException("Incorrect Person data: age below zero or nationality is null");
                }
            })
            .collect(Collectors.groupingBy(Person::getNationality, TreeMap::new,
                Collectors.averagingInt(Person::getAge))).toString().replaceAll("=", ": ").replaceAll("\\.\\d+", "");
    }
}

class Person {
    private final String name;
    private final String nationality;
    private final int age;

    public Person(String name, String nationality, int age) {
        this.name = name;
        this.nationality = nationality;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getAge() {
        return age;
    }
}


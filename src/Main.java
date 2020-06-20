import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        List<Person> listPerson = Arrays.asList(
                new Person("3", "aleja", "lozano", 17),
                new Person("6", "Saray", "garcia", 21),
                new Person("1", "michael", "garcia", 24),
                new Person("2", "dsdsd", "garcia", 21),
                new Person("2", "Daniel", "garcia", 21),
                new Person("4", "andrea", "ramirez", 15),
                new Person("5", "diana", "florez", 16)
        );
        List<Person> listPersonMenoresEdad = new ArrayList<>();
        for (Person persona : listPerson) {
            if (persona.getAge() <= 18) {
                listPersonMenoresEdad.add(persona); //agregamos a la lista, todas las personas menores de edad
            }
        }
        Collections.sort(listPersonMenoresEdad, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        Person personOne = (Person) o1;
                        Person personTwo = (Person) o2;
                        //puede hacer lo que quiera a partir de su implementación
                        return personTwo.getId().compareTo(personOne.getId());
                    }
                }
        );
        List<String> listIdPersonasMenores = new ArrayList<>();
        for (Person person :
                listPersonMenoresEdad) {
            listIdPersonasMenores.add(person.getId());
        }

//        for (String id : listIdPersonasMenores) {
//            System.out.println(id);
//        }

        List<String> listaIds =
                listPerson.stream()
                        .filter(person -> person.getAge() <= 18)
                        .sorted(comparing(Person::getId).reversed())
                        .map(Person::getId) //transformar el filtro y la lista de personas ordenadas en elementos
                        //de un tipo de dato especifico
                        .collect(toList());
        listaIds.forEach(id -> System.out.println(id));

        List<String> listaNombresMayoresEdad =
                listPerson.stream()
                        .filter(t -> t.getAge() >= 18)
                        .map(Person::getName)
                        .collect(toList());
//        listaIds.forEach(id -> System.out.println(id));
//        listaNombresMayoresEdad.forEach(name -> System.out.println(name));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> twoEvenSquares =
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * n)
                        .limit(2)
                        .collect(toList());

//        twoEvenSquares.forEach(squares -> System.out.println(squares));


        boolean expensive =
                listPerson.stream()
                        .allMatch(t -> t.getAge() > 18);
//        System.out.println(expensive);


        Optional<Person> optionalPerson =
                listPerson.stream()
                        .filter(t -> t.getLastName().charAt(0) == 'e')
                        .findFirst();

//        System.out.println(optionalPerson.isPresent());
//        +"\n" + "data : " + optionalPerson.get());

        List<String> words = Arrays.asList("Oracle", "Java", "Magazine");
        List<Integer> wordLengths =
                words.stream()
                        .map(String::length)
                        .collect(toList());
//        wordLengths.forEach(length -> System.out.println(length));
        List<Integer> numbersReduce = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int sum = numbersReduce.stream().reduce(-5, (a, b) -> a + b);
//        System.out.println(sum);


        Long statement =
                listPerson.stream()
                        .filter(person -> person.getAge() > 18)
                        .map(person -> person.getAge())
                        .count();
//        System.out.println(statement);

        int sumAge =
                listPerson.stream()
                        .filter(person -> person.getAge() > 18)
                        .mapToInt(person -> person.getAge())
                        .sum();
//        System.out.println(sumAge);

//        Stream<Integer> numbersFromValues = Stream.of(1, 2, 3, 4);
        int[] numbersArray = {1, 2, 3, 4};
        IntStream numbersFromArray = Arrays.stream(numbersArray);
//        numbersFromArray.sum();
//        System.out.println(numbersFromArray.allMatch(number -> number<1));

//
//        Stream<Integer> numbersTen = Stream.iterate(1, n -> n + 10);
//        Long aLong = numbersTen.count();
//        System.out.println(aLong);

    }
}

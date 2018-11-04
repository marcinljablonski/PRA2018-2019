package pesel;

import lombok.AllArgsConstructor;

import java.util.Scanner;
import java.util.Set;

@AllArgsConstructor
public class CLI {
    private Set<Person> people;

    public void run() throws IllegalArgumentException {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String city;
            String personalias;
            System.out.println("Podaj Miasto");
            city = s.nextLine();
            System.out.println("Podaj PESEL, imię i nazwisko. Rozdziel je tylko spacją");
            personalias = s.nextLine();
            String[] personaliasArr = personalias.split(" ");
            if (personaliasArr.length != 3) {
                throw new IllegalArgumentException();
            }
            Person person;
            person = new Person(city,
                    personaliasArr[0], personaliasArr[1], personaliasArr[2]);
            this.people.add(person);
        }
    }
}


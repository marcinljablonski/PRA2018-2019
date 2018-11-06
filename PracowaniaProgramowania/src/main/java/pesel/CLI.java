package pesel;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

@AllArgsConstructor
public class CLI {
    private List<Person> people;

    public void run() throws IllegalArgumentException {
        Scanner s = new Scanner(System.in).useDelimiter("\n");
        while (true) {
            String city;
            String personalias;
            System.out.println("Podaj Miasto");
            city = s.next();
            if (city.equals(".exit")) {
                return;
            }
            System.out.println("Podaj PESEL, imię i nazwisko. Rozdziel je tylko spacją");
            personalias = s.next();
            String[] personaliasArr = personalias.split(" ");
            if (personaliasArr.length != 3) {
                System.out.println("Spróbuj jeszce raz");
                continue;
            }
            Person person;
            try {
                person = new Person(city,
                        personaliasArr[0], personaliasArr[1], personaliasArr[2]);
                add(person);
            } catch (IllegalArgumentException e) {
                System.out.println("Błędny PESEL. Spróbuj jeszcze raz");
            }
        }
    }

    private void add(Person person) {
        this.people.remove(person);
        this.people.add(person);
    }
}


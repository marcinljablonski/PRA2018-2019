package pesel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;


public class Application {
    private static void run(){
        CLI cli;
        Set<Person> people;
        people = new LinkedHashSet<>();
        cli = new CLI(people);
    }

    public static void main(String ... args) {
        run();
        try {
            FileIO.truncate();
//            FileIO.write("Marcin Jabłoński");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package pesel;

import org.apache.commons.lang3.StringUtils;

import java.nio.CharBuffer;
import java.util.stream.IntStream;

public class Person {
   private String city;
   private String pesel;
   private String firstName;
   private String lastName;

   public Person(String city, String pesel, String firstName, String lastName) throws IllegalArgumentException {
      this.city = city;
      this.pesel = pesel;
      this.firstName = firstName;
      this.lastName = lastName;

      if (!isPESELValid()) {
         throw new IllegalArgumentException();
      }
   }

   private boolean isPESELValid() {
      if (!StringUtils.isNumeric(this.pesel) || this.pesel.length() != 11) {
         return false;
      }
      int[] intPesel =
      CharBuffer.wrap(this.pesel.toCharArray())
              .chars()
              .map(x -> x - '0')
              .toArray();
      int[] multipliers = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};
      int peselSum = IntStream.range(0, 11)
              .map(i -> multipliers[i] * intPesel[i])
              .sum();

      if (peselSum % 10 != 0) {
         return false;
      }
      return true;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }

      if (!Person.class.isAssignableFrom(obj.getClass())) {
        return false;
      }

      final Person other = (Person) obj;

      if (this.pesel != other.pesel) {
         return false;
      }

      return true;
   }

   @Override
   public String toString() {
      return city + pesel + firstName + lastName + "\n";
   }

}

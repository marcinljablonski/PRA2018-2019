package pesel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileIO {
   private static final String FILE_NAME = "odp.txt";
   private static final Path PATH = Paths.get(FILE_NAME);

   public static void truncate() throws IOException {
      Files.write(PATH, new byte[0]);
   }

   public static void write(String data) throws IOException {
      Files.write(PATH, data.getBytes(), StandardOpenOption.APPEND);
   }

}

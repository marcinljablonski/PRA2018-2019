package xd.marcin.hotel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLiner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Start");
  }

}

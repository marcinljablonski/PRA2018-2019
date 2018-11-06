package pesel;

import org.quartz.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SaveToFile implements org.quartz.Job {
    private List<Person> people;

      public void execute(JobExecutionContext context) throws JobExecutionException {
          try {
              this.people = (List<Person>) context.getScheduler().getContext().get("people");
          } catch (SchedulerException e) {
              throw new JobExecutionException();
          }

          try {
              FileIO.truncate();
          } catch (IOException e) {
              throw new JobExecutionException();
          }
          people.stream().sorted(Comparator.comparing(Person::getCity)).forEach(p -> {
              try {
                  FileIO.write(p.toString());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          });
      }
}

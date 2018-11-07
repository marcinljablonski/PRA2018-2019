package pesel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.util.*;

public class TimeLeft implements org.quartz.Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        int hours = LocalDateTime.now().getHour();
        int minutes = LocalDateTime.now().getMinute();
        int minutesAfterMidnight = 60 * hours + minutes;

        List<Ending> endings = new ArrayList<>();
        endings.add(new Ending(true, 585));
        endings.add(new Ending(false, 600));
        endings.add(new Ending(true, 690));
        endings.add(new Ending(false, 705));
        endings.add(new Ending(true, 795));
        endings.add(new Ending(false, 825));
        endings.add(new Ending(true, 915));
        endings.add(new Ending(false, 930));
        endings.add(new Ending(true, 1020));
        endings.add(new Ending(false, 1035));
        endings.add(new Ending(true, 1125));

        if (minutesAfterMidnight > 1125) {
            System.out.println("Już po zajęciach");
        } else {
            Optional<Ending> nearest = endings.stream().filter(x -> x.getEndingTime() > minutesAfterMidnight).findFirst();
            int difference = nearest.get().getEndingTime() - minutesAfterMidnight;
            boolean type = nearest.get().isClassEnding();
            System.out.println("Zostało " + difference + " minut do końca " + (type? "zajęć" : "przerwy"));
        }

    }
    @AllArgsConstructor
    private class Ending {
       @Getter
       boolean classEnding;
       @Getter
       int endingTime;
    }
}

package pesel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.quartz.JobExecutionException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PersonTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restore() {
       System.setOut(System.out);
    }

    @Test
    public void isPESELValidTest() {
        Person p = null;
        try {
            p = new Person("", "72111167552", "", "");
        } catch (Exception e) {}
        Assert.assertNotNull(p);
    }

    @Test
    public void isPESELValidTest2() {
        Person p = null;
        try {
            p = new Person("", "72111167553", "", "");
        } catch (Exception e) {}
        Assert.assertNull(p);
    }

    @Test
    public void isBreakTimeTest() throws JobExecutionException {
        MockedTimeLeftBreak tl = new MockedTimeLeftBreak();
        tl.execute(null);
        String[] out = outContent.toString().split(" ");
        String word = out[out.length - 1];
        Assert.assertEquals("przerwy\n", word);
    }

    @Test
    public void isClassesTimeTest() throws JobExecutionException {
        MockedTimeLeftClasses tl = new MockedTimeLeftClasses();
        tl.execute(null);
        String[] out = outContent.toString().split(" ");
        String word = out[out.length - 1];
        Assert.assertEquals("zajęć\n", word);
    }

    private class MockedTimeLeftBreak extends TimeLeft {
        @Override
        protected int getMinutesAfterMidnight() {
            return 599;
        }
    }

    private class MockedTimeLeftClasses extends TimeLeft {
        @Override
        protected int getMinutesAfterMidnight() {
            return 1111;
        }
    }
}
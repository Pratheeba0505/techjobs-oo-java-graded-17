package org.launchcode.techjobs.oo;

//import jdk.internal.access.JavaLangInvokeAccess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Objects;

import static org.junit.Assert.*;
public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", newJob.getName());
        assertTrue(newJob.getName().equals("Product tester"));

        assertEquals(newJob.getEmployer().getValue(), "ACME");
        assertTrue(newJob.getEmployer() instanceof Employer);

        assertEquals(newJob.getLocation().getValue(), "Desert");
        assertTrue(newJob.getLocation() instanceof Location);

        assertEquals(newJob.getPositionType().getValue(), "Quality control");
        assertTrue(newJob.getPositionType() instanceof PositionType);

        assertEquals(newJob.getCoreCompetency().getValue(), "Persistence");
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test

    public void testJobsForEquality() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job3, job4);
    }


    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job sJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //String newLine = "\n";
        String s = sJob.toString();
        assertEquals(s.charAt(0),'\n');
        assertEquals(s.charAt(s.length()-1),'\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job stringJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newLine = "\n";
        String outPut =  newLine +
                "ID: " + stringJob.getId() + newLine +
                "Name: " + "Product tester" + newLine +
                "Employer: " + "ACME" + newLine +
                "Location: " + "Desert" + newLine +
                "Position Type: " + "Quality control" + newLine +
                "Core Competency: " + "Persistence" + newLine;
        assertEquals(stringJob.toString(),outPut);

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job s1Job = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newLine = "\n";
        String nullOutput = newLine +
                "ID: " + s1Job.getId() + newLine +
                "Name: " + "Product tester" + newLine +
                "Employer: " + "Data not available" + newLine +
                "Location: " + "Desert" + newLine +
                "Position Type: " + "Quality control" + newLine +
                "Core Competency: " + "Persistence" + newLine;
        assertEquals(nullOutput, s1Job.toString());
    }
}
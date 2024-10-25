package edu.ensign.cs460.banking.api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SpringTest {
    
    @Test
    public void testApplicationRuns() {
        assertTrue(MavenRunner.runMavenBuild(Autograder.PROJECT_DIR));
    }

}

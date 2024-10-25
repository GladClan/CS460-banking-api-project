package edu.ensign.cs460.banking.api;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SourceFileTest {

    @Test
    public void testJavaSourceFileExistsAndHasCorrectPackage() throws IOException {
        // Define the expected package and class
        String expectedPackage = "edu.ensign.cs460.banking_api";  // Replace with the expected package
        String expectedClassName = "BankingApiApplication.java";     // Replace with the expected class name

        // Define the path to the Java source file (adjust the path as necessary)
        String filePath = "../src/main/java/edu/ensign/cs460/banking_api/" + expectedClassName; // Adjust the path as needed
        File javaFile = new File(filePath);

        // Assert that the file exists
        assertTrue(javaFile.exists(), "The source file should exist at " + filePath);

        // Check if the file contains the correct package declaration
        try (BufferedReader reader = new BufferedReader(new FileReader(javaFile))) {
            String line;
            boolean packageFound = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("package")) {
                    String packageDeclaration = line.replace("package", "").replace(";", "").trim();
                    assertEquals(expectedPackage, packageDeclaration, "Package declaration should match");
                    packageFound = true;
                    break;
                }
            }

            assertTrue(packageFound, "No package declaration found in the source file.");
        }
    }
}

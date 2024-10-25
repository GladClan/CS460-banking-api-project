package edu.ensign.cs460.banking.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class MavenRunner {

    public static boolean runMavenBuild(File projectDirectory) {
        try {
            // Create the Maven process builder
            ProcessBuilder processBuilder = new ProcessBuilder("mvn", "clean", "install");
            processBuilder.directory(projectDirectory);  // Set student's project directory
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Capture the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to finish and get the exit code
            int exitCode = process.waitFor();

            // Print output
            System.out.println(output);

            // Return whether the build was successful
            return exitCode == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        File projectDirectory = new File("..");
        if (runMavenBuild(projectDirectory)) {
            System.out.println("Maven build succeeded.");
        } else {
            System.out.println("Maven build failed.");
        }
    }
}


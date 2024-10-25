package edu.ensign.cs460.banking.api;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Autograder {

    public static File canonize(File f) {
        try {
            return f.getCanonicalFile();
        } catch (Exception e) {
            return null;
        }
    }

    public static final File PROJECT_DIR = canonize(new File(".."));

    public static Document loadProjectPom() throws SAXException, IOException, ParserConfigurationException {
        File pomFile = new File(Autograder.PROJECT_DIR, "pom.xml");
        try {

            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(pomFile);
            doc.getDocumentElement().normalize();
            return doc;
        } catch (FileNotFoundException ex) {
            fail("The Spring Initializr pom.xml has not be added to the project at " + pomFile
                    + ".\n\t\t  Go to https://start.spring.io/ to start the project", ex);
            return null;
        }
    }

}

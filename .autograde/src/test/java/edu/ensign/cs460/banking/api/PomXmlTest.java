package edu.ensign.cs460.banking.api;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PomXmlTest {

    private String expectedPackage = "edu.ensign.cs460";

    private Document pom;

    private static final int PARENT_ITEM = 0;
    private static final int PROJECT_ITEM = 1;

    @BeforeEach
    public void setupPom() throws SAXException, IOException, ParserConfigurationException {
        pom = Autograder.loadProjectPom();
    }

    @Test
    public void testGroupId() throws Exception {

        String groupId = pom.getElementsByTagName("groupId").item(PROJECT_ITEM).getTextContent();
        assertEquals(expectedPackage, groupId, "Group ID should be '" + expectedPackage + "'");
    }

    @Test
    public void testArtifactId() throws Exception {

        String artifactId = pom.getElementsByTagName("artifactId").item(PROJECT_ITEM).getTextContent();
        assertEquals("banking-api", artifactId, "Artifact ID should be 'banking-application'");
    }

    

    @Test
    public void testSpringBootDevtoolsDependency() throws Exception {
        assertDependencyExists("org.springframework.boot", "spring-boot-devtools");
    }

    @Test
    public void testMysqlConnectorJDependency() throws Exception {
        assertDependencyExists("com.mysql", "mysql-connector-j");
    }

    @Test
    public void testLombokDependency() throws Exception {
        assertDependencyExists("org.projectlombok", "lombok");
    }

    @Test
    public void testSpringBootStarterTestDependency() throws Exception {
        assertDependencyExists("org.springframework.boot", "spring-boot-starter-test");
    }

    @Test
    public void testSpringBootStarterWebDependency() throws Exception {
        assertDependencyExists("org.springframework.boot", "spring-boot-starter-web");
    }

    @Test
    public void testSpringBootStarterJpaDependency() throws Exception {
        assertDependencyExists("org.springframework.boot", "spring-boot-starter-data-jpa");
    }

    @Test
    public void testSpringBootStarterSecurityDependency() throws Exception {
        assertDependencyExists("org.springframework.boot", "spring-boot-starter-security");
    }

    private void assertDependencyExists(String groupId, String artifactId) throws Exception {
        
        NodeList dependencies = pom.getElementsByTagName("dependency");

        boolean found = false;
        for (int i = 0; i < dependencies.getLength(); i++) {
            Node dependency = dependencies.item(i);
            if (dependency.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) dependency;
                String actualGroupId = element.getElementsByTagName("groupId").item(0).getTextContent();
                String actualArtifactId = element.getElementsByTagName("artifactId").item(0).getTextContent();
                if (groupId.equals(actualGroupId) && artifactId.equals(actualArtifactId)) {
                    found = true;
                    break;
                }
            }
        }

        assertTrue(found, "Dependency " + groupId + ":" + artifactId + " should be present in pom.xml");
    }

}

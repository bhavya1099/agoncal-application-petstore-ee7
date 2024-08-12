

package org.agoncal.application.petstore.model;
import org.junit.*;
import static org.junit.Assert.*;
import org.agoncal.application.petstore.constraints.Email;
import org.agoncal.application.petstore.constraints.Login;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.*;

public class CustomerGetFullNameTest {
    private Customer customer;
    @Before
    public void setUp() {
        customer = new Customer();
    }
    @Test
    @Category(Categories.boundary.class)
    public void testEmptyFullName() {
        // Arrange
        customer.setFirstName(null);
        customer.setLastName(null);
        // Act
        String fullName = customer.getFullName();
        // Assert
        assertTrue(fullName.isEmpty());
    }
    @Test
    @Category(Categories.invalid.class)
    public void testNullFirstName() {
        // Arrange
        customer.setFirstName(null);
        customer.setLastName("Doe");
        // Act
        String fullName = customer.getFullName();
        // Assert
        assertEquals("  Doe", fullName);
    }
    @Test
    @Category(Categories.invalid.class)
    public void testNullLastName() {
        // Arrange
        customer.setFirstName("John");
        customer.setLastName(null);
        // Act
        String fullName = customer.getFullName();
        // Assert
        assertEquals("John ", fullName);
    }
    @Test
    @Category(Categories.valid.class)
    public void testNonNullFullName() {
        // Arrange
        customer.setFirstName("John");
        customer.setLastName("Doe");
        // Act
        String fullName = customer.getFullName();
        // Assert
        assertEquals("John Doe", fullName);
    }
    @Test
    @Category(Categories.boundary.class)
    public void testFullNameWithWhitespace() {
        // Arrange
        customer.setFirstName("  John  ");
        customer.setLastName("  Doe  ");
        // Act
        String fullName = customer.getFullName();
        // Assert
        assertEquals("  John   Doe  ", fullName);
    }
    @Test
    @Category(Categories.valid.class)
    public void testFullNameWithSpecialCharacters() {
        // Arrange
        customer.setFirstName("John!");
        customer.setLastName("Doe@");
        // Act
        String fullName = customer.getFullName();
        // Assert
        assertEquals("John! Doe@", fullName);
    }
}
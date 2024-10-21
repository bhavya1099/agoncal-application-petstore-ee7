
// ********RoostGPT********
/*
Test generated by RoostGPT for test java-customannotation-test using AI Type  and AI Model

ROOST_METHOD_HASH=getLastName_026f18c38b
ROOST_METHOD_SIG_HASH=getLastName_4814a2dee7

Here are the JUnit test scenarios for the `getLastName` method of the `Customer` class:

```
Scenario 1: Basic retrieval of the last name

Details:
  TestName: getLastNameBasicTest
  Description: Test to ensure that the `getLastName` method returns the correct last name of the customer as set by the `setLastName` method.
Execution:
  Arrange: Instantiate a Customer object and use `setLastName` to set a known last name.
  Act: Retrieve the last name using `getLastName`.
  Assert: Check that the returned last name matches the expected last name set earlier.
Validation:
  The assertion checks for equality between the set and retrieved last name, ensuring that the class property holds and returns the correct value. This is important to verify the correct behavior of basic getter/setter operations and data integrity.

```

```
Scenario 2: Retrieving lastName when not explicitly set

Details:
  TestName: getLastNameUnsetTest
  Description: Test to confirm that `getLastName` returns null when the lastName has never been explicitly set.
Execution:
  Arrange: Create a new Customer object without setting the lastName.
  Act: Call `getLastName` to retrieve the value.
  Assert: Assert that the return value is null.
Validation:
  This test verifies that the class properly initializes or manages uninitialized string properties as null, reflecting a correct or expected behavior of object properties before any data alteration. The null check further ensures that getter methods handle non-initialized fields safely without unexpected behaviors such as exceptions.

```

```
Scenario 3: Consistency of repeatedly calling getLastName

Details:
  TestName: getLastNameIdempotentTest
  Description: Test to check if multiple calls to `getLastName` consistently return the same value.
Execution:
  Arrange: Create a new Customer object and set a specific lastName.
  Act: Call `getLastName` multiple times.
  Assert: Assert that every call returns the same result.
Validation:
  The validation ensures that the `getLastName` method is idempotent and returns consistent results with repeated calls, which is a key aspect in verifying the immutability of the returned property values with unchanged underlying data. This is particularly significant for ensuring stable behavior in data binding or display logic in applications.

```

These scenarios comprehensively test the `getLastName` method for the `Customer` class under various common situations, ensuring that the behavior of the getter method aligns with expectations in both initialized and uninitialized states.
*/

// ********RoostGPT********

package org.agoncal.application.petstore.model;

import org.junit.Test;
import org.junit.experimental.categories.Category;
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

public class CustomerGetLastNameTest {

	@Test
	@Category(Categories.valid.class)
	public void getLastNameBasicTest() {
		// Arrange
		Customer customer = new Customer();
		customer.setLastName("Doe");
		// Act
		String result = customer.getLastName();
		// Assert
		assertEquals("Doe", result);
	}

	@Test
	@Category(Categories.valid.class)
	public void getLastNameUnsetTest() {
		// Arrange
		Customer customer = new Customer();
		// Act
		String result = customer.getLastName();
		// Assert
		assertNull(result);
	}

	@Test
	@Category(Categories.valid.class)
	public void getLastNameIdempotentTest() {
		// Arrange
		Customer customer = new Customer();
		customer.setLastName("Doe");
		// Act
		String result1 = customer.getLastName();
		String result2 = customer.getLastName();
		// Assert
		assertEquals(result1, result2);
	}

}
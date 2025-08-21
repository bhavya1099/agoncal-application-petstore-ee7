package org.agoncal.application.petstore.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Assertions;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.jupiter.api;
import org.agoncal.application.petstore.constraints.Email;
import org.agoncal.application.petstore.constraints.Login;
import javax.persistence;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util;
import java.util.Base64;
import org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions.assertFalse;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions.assertEquals;

public class Customer875Test {

	/*
	 * ROOST_METHOD_HASH=calculateAge_415a65d013
	 * ROOST_METHOD_SIG_HASH=calculateAge_57aa9cf34c
	 *
	 */public void calculateAgeWithNullDateOfBirth() {

		Customer customer = new Customer();

		customer.dateOfBirth = null;

		customer.calculateAge();

		assertNull(customer.age, "Age must be null when dateOfBirth is null");
	}

	/*
	 * ROOST_METHOD_HASH=calculateAge_415a65d013
	 * ROOST_METHOD_SIG_HASH=calculateAge_57aa9cf34c
	 *
	 */public void calculateAgeWithSameDayAndMonthDifferentYear() {

		Customer customer = new Customer();
		Calendar birthDate = new GregorianCalendar(2000, Calendar.JANUARY, 1);
		customer.dateOfBirth = birthDate.getTime();
		Calendar today = new GregorianCalendar();
		today.set(Calendar.YEAR, 2021);
		today.set(Calendar.MONTH, Calendar.JANUARY);
		today.set(Calendar.DAY_OF_MONTH, 1);

		customer.calculateAge();

		assertEquals(21, (int) customer.age,
				"Age must be correctly calculated for same day and month with different year");
	}

	/*
	 * ROOST_METHOD_HASH=calculateAge_415a65d013
	 * ROOST_METHOD_SIG_HASH=calculateAge_57aa9cf34c
	 *
	 */public void calculateAgeWithDifferentDayAndMonth() {

		Customer customer = new Customer();
		Calendar birthDate = new GregorianCalendar(2000, Calendar.FEBRUARY, 15);
		customer.dateOfBirth = birthDate.getTime();
		Calendar today = new GregorianCalendar();
		today.set(Calendar.YEAR, 2021);
		today.set(Calendar.MONTH, Calendar.JANUARY);
		today.set(Calendar.DAY_OF_MONTH, 20);

		customer.calculateAge();

		assertEquals(20, (int) customer.age,
				"Age must be calculated correctly when month or day prevents incrementing by year");
	}

	/*
	 * ROOST_METHOD_HASH=calculateAge_415a65d013
	 * ROOST_METHOD_SIG_HASH=calculateAge_57aa9cf34c
	 *
	 */public void calculateAgeWithSingleDayBeforeBirthday() {

		Customer customer = new Customer();
		Calendar birthDate = new GregorianCalendar(2000, Calendar.JANUARY, 2);
		customer.dateOfBirth = birthDate.getTime();
		Calendar today = new GregorianCalendar();
		today.set(Calendar.YEAR, 2021);
		today.set(Calendar.MONTH, Calendar.JANUARY);
		today.set(Calendar.DAY_OF_MONTH, 1);

		customer.calculateAge();

		assertEquals(20, (int) customer.age, "Age must be correctly adjusted when one day before birthday");
	}

	/*
	 * ROOST_METHOD_HASH=calculateAge_415a65d013
	 * ROOST_METHOD_SIG_HASH=calculateAge_57aa9cf34c
	 *
	 */public void calculateAgeWithExactBirthdayToday() {

		Customer customer = new Customer();
		Calendar birthDate = new GregorianCalendar(2000, Calendar.MARCH, 1);
		customer.dateOfBirth = birthDate.getTime();
		Calendar today = new GregorianCalendar();
		today.set(Calendar.YEAR, 2021);
		today.set(Calendar.MONTH, Calendar.MARCH);
		today.set(Calendar.DAY_OF_MONTH, 1);

		customer.calculateAge();

		assertEquals(21, (int) customer.age, "Age should be incremented by one year exactly when birthday");
	}

	/*
	 * ROOST_METHOD_HASH=digestPassword_bc44b63c68
	 * ROOST_METHOD_SIG_HASH=digestPassword_874d895601
	 *
	 */public void validateSuccessfulHashingForValidInput() {

		Customer customer = new Customer();
		String plainTextPassword = "Password123";
		String expectedHash;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(plainTextPassword.getBytes("UTF-8"));
			expectedHash = Base64.getEncoder().encodeToString(md.digest());
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to compute expected hash", e);
		}

		String actualHash = customer.digestPassword(plainTextPassword);

		assertEquals(expectedHash, actualHash, "The generated hash should match the expected hash");
	}

	/*
	 * ROOST_METHOD_HASH=digestPassword_bc44b63c68
	 * ROOST_METHOD_SIG_HASH=digestPassword_874d895601
	 *
	 */public void handleEmptyPasswordInput() {

		Customer customer = new Customer();
		String plainTextPassword = "";
		String expectedHash;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(plainTextPassword.getBytes("UTF-8"));
			expectedHash = Base64.getEncoder().encodeToString(md.digest());
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to compute expected hash", e);
		}

		String actualHash = customer.digestPassword(plainTextPassword);

		assertEquals(expectedHash, actualHash, "The hash of an empty string should match the expected hash");
	}

	/*
	 * ROOST_METHOD_HASH=digestPassword_bc44b63c68
	 * ROOST_METHOD_SIG_HASH=digestPassword_874d895601
	 *
	 */public void handleNullPasswordInput() {

		Customer customer = new Customer();

		assertThrows(RuntimeException.class, () -> customer.digestPassword(null),
				"Passing null should throw RuntimeException");
	}

	/*
	 * ROOST_METHOD_HASH=digestPassword_bc44b63c68
	 * ROOST_METHOD_SIG_HASH=digestPassword_874d895601
	 *
	 */public void digestPasswordWithNonUTF8Characters() {

		Customer customer = new Customer();
		String passwordWithSpecialCharacters = "密码123";
		String expectedHash;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(passwordWithSpecialCharacters.getBytes("UTF-8"));
			expectedHash = Base64.getEncoder().encodeToString(md.digest());
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to compute expected hash", e);
		}

		String actualHash = customer.digestPassword(passwordWithSpecialCharacters);

		assertEquals(expectedHash, actualHash, "The generated hash should match the expected hash");
	}

	/*
	 * ROOST_METHOD_HASH=digestPassword_bc44b63c68
	 * ROOST_METHOD_SIG_HASH=digestPassword_874d895601
	 *
	 */public void digestPasswordWithLongInput() {

		Customer customer = new Customer();

		String longPassword = "a".repeat(10000);
		String expectedHash;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(longPassword.getBytes("UTF-8"));
			expectedHash = Base64.getEncoder().encodeToString(md.digest());
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to compute expected hash", e);
		}

		String actualHash = customer.digestPassword(longPassword);

		assertEquals(expectedHash, actualHash, "The hash of a long input should match the expected hash");
	}

	/*
	 * ROOST_METHOD_HASH=digestPassword_bc44b63c68
	 * ROOST_METHOD_SIG_HASH=digestPassword_874d895601
	 *
	 */public void digestPasswordWithSpecialCharacters() {

		Customer customer = new Customer();
		String passwordWithSymbols = "!@#$%^&*()_+";
		String expectedHash;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(passwordWithSymbols.getBytes("UTF-8"));
			expectedHash = Base64.getEncoder().encodeToString(md.digest());
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to compute expected hash", e);
		}

		String actualHash = customer.digestPassword(passwordWithSymbols);

		assertEquals(expectedHash, actualHash, "The generated hash should match the expected hash");
	}

	/*
	 * ROOST_METHOD_HASH=digestPassword_bc44b63c68
	 * ROOST_METHOD_SIG_HASH=digestPassword_874d895601
	 *
	 */public void handleExceptionForUnsupportedEncoding() {

		Customer customer = new Customer();

		assertThrows(RuntimeException.class, () -> {
			String unsupportedEncodingPassword = "Password123";

			customer.digestPassword(unsupportedEncodingPassword);
		}, "Unsupported encoding should throw RuntimeException");
	}

	/*
	 * ROOST_METHOD_HASH=digestPassword_bc44b63c68
	 * ROOST_METHOD_SIG_HASH=digestPassword_874d895601
	 *
	 */public void validateBase64EncodingOfDigest() {

		Customer customer = new Customer();
		String plainTextPassword = "Password123";

		String actualHash = customer.digestPassword(plainTextPassword);

		assertDoesNotThrow(() -> Base64.getDecoder().decode(actualHash),
				"The encoded hash should be a valid Base64 string");
	}

	/*
	 * ROOST_METHOD_HASH=equals_ee1e3b87b4 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsWithSameInstance() {
		Customer customer = new Customer("John", "Doe", "john123", "password", "john@example.com", new Address());
		assertTrue(customer.equals(customer), "Customer should be equal to itself.");
	}

	/*
	 * ROOST_METHOD_HASH=equals_ee1e3b87b4 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsWithEqualLoginValues() {
		Customer customer1 = new Customer("Jane", "Smith", "jane456", "password", "jane@example.com", new Address());
		Customer customer2 = new Customer("Emily", "White", "jane456", "password", "emily@example.com", new Address());
		assertTrue(customer1.equals(customer2), "Customers with equal 'login' values should be equal.");
	}

	/*
	 * ROOST_METHOD_HASH=equals_ee1e3b87b4 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsWithDifferentLoginValues() {
		Customer customer1 = new Customer("Alice", "Adams", "alice789", "password", "alice@example.com", new Address());
		Customer customer2 = new Customer("Anna", "Brown", "anna101", "password", "anna@example.com", new Address());
		assertFalse(customer1.equals(customer2), "Customers with different 'login' values should not be equal.");
	}

	/*
	 * ROOST_METHOD_HASH=equals_ee1e3b87b4 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsWithNullObject() {
		Customer customer = new Customer("Bob", "Green", "bob111", "password", "bob@example.com", new Address());
		assertFalse(customer.equals(null), "Customer should not be equal to a null object.");
	}

	/*
	 * ROOST_METHOD_HASH=equals_ee1e3b87b4 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsWithDifferentClassObject() {
		Customer customer = new Customer("Chris", "Blue", "chris999", "password", "chris@example.com", new Address());
		Object nonCustomerObject = new Object();
		assertFalse(customer.equals(nonCustomerObject),
				"Customer should not be equal to an object of a different class.");
	}

	/*
	 * ROOST_METHOD_HASH=equals_ee1e3b87b4 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsWithTwoDifferentInstancesSameLogin() {
		Customer customer1 = new Customer("David", "Yellow", "david234", "password", "david@example.com",
				new Address());
		Customer customer2 = new Customer("Derek", "Orange", "david234", "password", "derek@example.com",
				new Address());
		assertTrue(customer1.equals(customer2), "Customers with the same 'login' value should be equal.");
	}

	/*
	 * ROOST_METHOD_HASH=equals_ee1e3b87b4 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsWithUninitializedLogin() {

		Customer customer1 = new Customer();

		Customer customer2 = new Customer();
		assertFalse(customer1.equals(customer2), "Customers with uninitialized login values should not be equal.");
	}

	/*
	 * ROOST_METHOD_HASH=toString_d78d331812 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void formatFullNameAndLoginCorrectly() {

		Address address = new Address("Main Street", "CityTown", "12345", new Country());
		Customer customer = new Customer("John", "Doe", "johndoe", "password123", "john.doe@test.com", address);

		String result = customer.toString();

		assertEquals("John Doe (johndoe)", result);
	}

	/*
	 * ROOST_METHOD_HASH=toString_d78d331812 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void handleEmptyFieldsGracefully() {

		Address address = new Address("Main Street", "CityTown", "12345", new Country());
		Customer customer = new Customer("", "", "", "password123", "empty.test@test.com", address);

		String result = customer.toString();

		assertEquals("  ()", result);
	}

	/*
	 * ROOST_METHOD_HASH=toString_d78d331812 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void handleNullValuesCorrectly() {

		Customer customer = new Customer();

		String result = customer.toString();

		assertEquals("null null (null)", result);
	}

	/*
	 * ROOST_METHOD_HASH=toString_d78d331812 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void handleMaxLengthFieldsCorrectly() {

		Address address = new Address("Main Street", "CityTown", "12345", new Country());
		Customer customer = new Customer("MaxNameMaxNameMaxNameMaxName", "LongLastNameMaxLastName", "maxloginuser",
				"password123", "max.longuser@test.com", address);

		String result = customer.toString();

		assertEquals("MaxNameMaxNameMaxNameMaxName LongLastNameMaxLastName (maxloginuser)", result);
	}

	/*
	 * ROOST_METHOD_HASH=toString_d78d331812 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void checkToStringWithValidData() {

		Address address = new Address("Street No. 5", "Capital City", "654321", new Country());
		Customer customer = new Customer("Alice", "Smith", "alicesmith", "securePassword", "alice.smith@test.com",
				address);

		String result = customer.toString();

		assertEquals("Alice Smith (alicesmith)", result);
	}

}
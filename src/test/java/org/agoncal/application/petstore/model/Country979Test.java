package org.agoncal.application.petstore.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api;
import javax.persistence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

public class Country979Test {

	/*
	 * ROOST_METHOD_HASH=equals_cc1252f459 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void testEqualityWithSameObject() {
		Country countryA = new Country("US", "United States", "USA", "USA", "840");
		boolean result = countryA.equals(countryA);
		assertTrue(result, "Expected the same object comparison to return true");
	}

	/*
	 * ROOST_METHOD_HASH=equals_cc1252f459 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void testEqualityWithAnotherObjectOfSameValues() {
		Country countryA = new Country("US", "United States", "USA", "USA", "840");
		Country countryB = new Country("US", "United States", "USA", "USA", "840");
		boolean result = countryA.equals(countryB);
		assertTrue(result, "Expected objects with same isoCode to be equal");
	}

	/*
	 * ROOST_METHOD_HASH=equals_cc1252f459 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void testEqualityWithNullObject() {
		Country countryA = new Country("US", "United States", "USA", "USA", "840");
		boolean result = countryA.equals(null);
		assertFalse(result, "Expected comparison with null to return false");
	}

	/*
	 * ROOST_METHOD_HASH=equals_cc1252f459 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void testEqualityWithDifferentClassObject() {
		Country countryA = new Country("US", "United States", "USA", "USA", "840");
		Object nonCountryObject = "NonCountryObject";
		boolean result = countryA.equals(nonCountryObject);
		assertFalse(result, "Expected comparison with a non-Country object to return false");
	}

	/*
	 * ROOST_METHOD_HASH=equals_cc1252f459 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void testEqualityWithDifferentIsoCode() {
		Country countryA = new Country("US", "United States", "USA", "USA", "840");
		Country countryB = new Country("CA", "Canada", "Canada", "CAN", "124");
		boolean result = countryA.equals(countryB);
		assertFalse(result, "Expected objects with different isoCode to not be equal");
	}

	/*
	 * ROOST_METHOD_HASH=equals_cc1252f459 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void testEqualityWithIsoCodeNullInOneObject() {
		Country countryA = new Country(null, "United States", "USA", "USA", "840");
		Country countryB = new Country("US", "United States", "USA", "USA", "840");
		boolean result = countryA.equals(countryB);
		assertThrows(NullPointerException.class, () -> countryA.equals(countryB),
				"Expected comparison where isoCode of one object is null to throw NullPointerException");
	}

	/*
	 * ROOST_METHOD_HASH=equals_cc1252f459 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void testEqualityWithIsoCodeNullInBothObjects() {
		Country countryA = new Country(null, "United States", "USA", "USA", "840");
		Country countryB = new Country(null, "United States", "USA", "USA", "840");
		boolean result = countryA.equals(countryB);
		assertThrows(NullPointerException.class, () -> countryA.equals(countryB),
				"Expected comparison where isoCode of both objects is null to throw NullPointerException");
	}

	/*
	 * ROOST_METHOD_HASH=toString_0225ad8fbc ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringReturnsNullWhenNameFieldIsNull() {

		Country country = new Country();

		String result = country.toString();

		assertNull(result, "Expected toString() to return null when name field is null.");
	}

	/*
	 * ROOST_METHOD_HASH=toString_0225ad8fbc ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringReturnsNameWhenNameFieldIsNotNull() {

		String testName = "Germany";
		Country country = new Country("DE", testName, "Germany", "DEU", "276");

		String result = country.toString();

		assertEquals((String) testName, result, "Expected toString() to return the value of the 'name' field.");
	}

	/*
	 * ROOST_METHOD_HASH=toString_0225ad8fbc ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringHandlesEdgeCaseWithEmptyString() {

		String testName = "";
		Country country = new Country("US", testName, "United States", "USA", "840");

		String result = country.toString();

		assertEquals((String) testName, result,
				"Expected toString() to return an empty string when the 'name' field is an empty string.");
	}

	/*
	 * ROOST_METHOD_HASH=toString_0225ad8fbc ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringHandlesEdgeCaseWithWhitespaceName() {

		String testName = "   ";
		Country country = new Country("FR", testName, "France", "FRA", "250");

		String result = country.toString();

		assertEquals((String) testName, result,
				"Expected toString() to return the whitespace string as per 'name' field.");
	}

	/*
	 * ROOST_METHOD_HASH=toString_0225ad8fbc ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringHandlesLongNameString() {

		String testName = "ThisIsAnExceedinglyLongCountryNameThatShouldStillWorkProperly";
		Country country = new Country("US", testName, "United States", "USA", "840");

		String result = country.toString();

		assertEquals((String) testName, result,
				"Expected toString() to correctly handle long string values in the 'name' field.");
	}

}
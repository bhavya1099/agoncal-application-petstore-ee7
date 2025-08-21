package org.agoncal.application.petstore.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import org.junit.jupiter.api.Assertions.assertEquals;

public class Address701Test {

	/*
	 * ROOST_METHOD_HASH=equals_54d6b764e7 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsReturnsTrueForSameObject() {

		Country country = new Country();
		Address address = new Address("123 Main St", "Springfield", "12345", country);

		boolean result = address.equals(address);

		assertTrue(result, "Expected equals method to return true when comparing the same object");
	}

	/*
	 * ROOST_METHOD_HASH=equals_54d6b764e7 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsReturnsFalseForNullObject() {

		Country country = new Country();
		Address address = new Address("456 Elm St", "Shelbyville", "67890", country);

		boolean result = address.equals(null);

		assertFalse(result, "Expected equals method to return false when comparing with null");
	}

	/*
	 * ROOST_METHOD_HASH=equals_54d6b764e7 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsReturnsFalseForDifferentClassObject() {

		Country country = new Country();
		Address address = new Address("789 Oak Rd", "Ogdenville", "34567", country);
		Object nonAddressType = new String("Not an Address");

		boolean result = address.equals(nonAddressType);

		assertFalse(result, "Expected equals method to return false when comparing objects of different classes");
	}

	/*
	 * ROOST_METHOD_HASH=equals_54d6b764e7 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsReturnsTrueForObjectsWithSameValues() {

		Country country = new Country();
		Address address1 = new Address("321 Pine Ct", "North Haverbrook", "76432", country);
		Address address2 = new Address("321 Pine Ct", "North Haverbrook", "76432", country);

		boolean result = address1.equals(address2);

		assertTrue(result, "Expected equals method to return true for objects with the same values");
	}

	/*
	 * ROOST_METHOD_HASH=equals_54d6b764e7 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsReturnsFalseForObjectsWithDifferentValues() {

		Country country1 = new Country();

		Country country2 = new Country();
		Address address1 = new Address("654 Maple St", "Hawthorne", "87654", country1);
		Address address2 = new Address("845 Cedar St", "Brookwood", "38765", country2);

		boolean result = address1.equals(address2);

		assertFalse(result, "Expected equals method to return false for objects with different values");
	}

	/*
	 * ROOST_METHOD_HASH=equals_54d6b764e7 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void verifyEqualsAndHashCodeWithEqualsVerifier() {
		EqualsVerifier.forClass(Address.class).withPrefabValues(Country.class, new Country(), new Country()).verify();
	}

	/*
	 * ROOST_METHOD_HASH=toString_fd849bada2 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringForDefaultValues() {

		Address address = new Address();
		Country country = new Country();

		address.setCountry(country);

		String actualOutput = address.toString();

		String expectedOutput = "Address{street1='null', street2='null', city='null', state='null', zipcode='null', country="
				+ country + "}";
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_fd849bada2 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringForPartialValues() {

		Address address = new Address("123 Main Street", "Test City", "123456", null);

		String actualOutput = address.toString();

		String expectedOutput = "Address{street1='123 Main Street', street2='null', city='Test City', state='null', zipcode='123456', country=null}";
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_fd849bada2 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringForFullyInitializedValues() {

		Country country = new Country("ISO123", "CountryName", "PrintableName", "ISO3", "123");
		Address address = new Address("456 Elm Street", "Another City", "987654", country);

		String actualOutput = address.toString();

		String expectedOutput = "Address{street1='456 Elm Street', street2='null', city='Another City', state='null', zipcode='987654', country="
				+ country + "}";
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_fd849bada2 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringForLongStreetName() {

		String longStreetName = "12345678901234567890123456789012345678901234567890";

		Address address = new Address(longStreetName, "Boundary City", "000000", null);

		String actualOutput = address.toString();

		String expectedOutput = "Address{street1='" + longStreetName
				+ "', street2='null', city='Boundary City', state='null', zipcode='000000', country=null}";
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_fd849bada2 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringForNullCountry() {

		Address address = new Address("789 Mixed Road", "NullCountry City", "444444", null);

		String actualOutput = address.toString();

		String expectedOutput = "Address{street1='789 Mixed Road', street2='null', city='NullCountry City', state='null', zipcode='444444', country=null}";
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_fd849bada2 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringForIntegrationWithCountry() {

		Country country = new Country("ISO321", "IntegratedCountry", "PrintableIntegratedCountry", "ISO3213", "321");
		Address address = new Address("800 Cross Section", "Integration City", "222222", country);

		String actualOutput = address.toString();

		String expectedOutput = "Address{street1='800 Cross Section', street2='null', city='Integration City', state='null', zipcode='222222', country="
				+ country + "}";
		assertEquals(expectedOutput, actualOutput);
	}

}
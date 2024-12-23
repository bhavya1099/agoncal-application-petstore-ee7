package org.agoncal.application.petstore.model;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.Assert;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import org.junit.Before;
import org.junit.Assert.assertEquals;
import org.junit.Assert.assertNull;
import org.agoncal.application.petstore.model.Address;
import org.agoncal.application.petstore.model.Country;

public class AddressTest {

	@Test
	@Category(Categories.valid.class)
	public void getStreet1WithValidValue() {
		// Arrange
		Address address = new Address();
		String expectedStreet1 = "123 Main Street";
		address.setStreet1(expectedStreet1);
		// Act
		String actualStreet1 = address.getStreet1();
		// Assert
		assertEquals("The expected street1 value should match the actual value", expectedStreet1, actualStreet1);
	}

	@Test
	@Category(Categories.invalid.class)
	public void getStreet1WithNullValue() {
		// Arrange
		Address address = new Address();
		// Act
		String actualStreet1 = address.getStreet1();
		// Assert
		assertNull("The street1 value should be null", actualStreet1);
	}

	@Test
	@Category(Categories.valid.class)
	public void getStreet1AfterValueChange() {
		// Arrange
		Address address = new Address();
		String initialStreet1 = "123 Main Street";
		String newStreet1 = "456 Elm Street";
		address.setStreet1(initialStreet1);
		address.setStreet1(newStreet1);
		// Act
		String actualStreet1 = address.getStreet1();
		// Assert
		assertEquals("The expected street1 value should match the new value", newStreet1, actualStreet1);
	}

	@Before
	public void setup() {
		address = new Address();
	}

	@Test
	@Category(Categories.valid.class)
	public void testGetStreet2ReturnValue() {
		String testStreet2 = "Test Street 2";
		address.setStreet2(testStreet2);
		String returnedStreet2 = address.getStreet2();
		assertEquals("getStreet2() does not return the correct value", testStreet2, returnedStreet2);
	}

	@Test
	@Category(Categories.valid.class)
	public void testGetStreet2ReturnNull() {
		String returnedStreet2 = address.getStreet2();
		assertNull("getStreet2() should return null when street2 is not set", returnedStreet2);
	}

	@Test
	@Category(Categories.valid.class)
	public void testGetStreet2AfterMultipleSetStreet2() {
		String testStreet2_1 = "Test Street 2 - 1";
		String testStreet2_2 = "Test Street 2 - 2";
		address.setStreet2(testStreet2_1);
		address.setStreet2(testStreet2_2);
		String returnedStreet2 = address.getStreet2();
		assertEquals("getStreet2() does not return the correct value after multiple setStreet2() calls", testStreet2_2,
				returnedStreet2);
	}

	@Test
	@Category(Categories.valid.class)
	public void testGetCityReturnValue() {
		// Arrange
		Address address = new Address();
		String expectedCity = "New York";
		address.setCity(expectedCity);
		// Act
		String actualCity = address.getCity();
		// Assert
		assertEquals(expectedCity, actualCity);
	}

	@Test
	@Category(Categories.valid.class)
	public void testGetCityWhenCityIsNull() {
		// Arrange
		Address address = new Address();
		// Act
		String actualCity = address.getCity();
		// Assert
		assertNull(actualCity);
	}

	@Test
	@Category(Categories.valid.class)
	public void testGetCityAfterCityUpdate() {
		// Arrange
		Address address = new Address();
		String initialCity = "New York";
		address.setCity(initialCity);
		String updatedCity = "Los Angeles";
		address.setCity(updatedCity);
		// Act
		String actualCity = address.getCity();
		// Assert
		assertEquals(updatedCity, actualCity);
	}

	@Test
	@Category(Categories.valid.class)
	public void testGetStateReturnsCorrectState() {
		// Arrange
		String expectedState = "New York";
		address.setState(expectedState);
		// Act
		String returnedState = address.getState();
		// Assert
		assertEquals(expectedState, returnedState);
	}

	@Test
	@Category(Categories.valid.class)
	public void testGetStateReturnsNullWhenNoStateIsSet() {
		// Arrange
		// No state is set.
		// Act
		String returnedState = address.getState();
		// Assert
		assertNull(returnedState);
	}

	@Test
	@Category(Categories.valid.class)
	public void testGetStateReturnsCorrectStateAfterMultipleSetStateCalls() {
		// Arrange
		String firstState = "California";
		String secondState = "Texas";
		String expectedState = "Florida";
		address.setState(firstState);
		address.setState(secondState);
		address.setState(expectedState);
		// Act
		String returnedState = address.getState();
		// Assert
		assertEquals(expectedState, returnedState);
	}

	@Before
	public void setUp() {
		address = new Address();
	}

	@Test
	@Category(Categories.valid.class)
	public void testGetZipcode() {
		String expectedZipcode = "12345";
		address.setZipcode(expectedZipcode);
		String actualZipcode = address.getZipcode();
		assertEquals("The expected zipcode does not match the actual zipcode", expectedZipcode, actualZipcode);
	}

	@Test
	@Category(Categories.valid.class)
	public void testGetZipcodeWhenNotSet() {
		assertNull("The zipcode should be null as it has not been set", address.getZipcode());
	}

	@Test
	@Category(Categories.valid.class)
	public void testGetZipcodeAfterUpdate() {
		String initialZipcode = "12345";
		address.setZipcode(initialZipcode);
		String updatedZipcode = "67890";
		address.setZipcode(updatedZipcode);
		String actualZipcode = address.getZipcode();
		assertEquals("The expected updated zipcode does not match the actual zipcode", updatedZipcode, actualZipcode);
	}

	@Test
	@Category(Categories.valid.class)
	public void getCountryReturnsCorrectCountry() {
		// Arrange
		Address address = new Address();
		Country country = new Country("isoCode", "name", "printableName", "iso3", "numcode");
		address.setCountry(country);
		// Act
		Country returnedCountry = address.getCountry();
		// Assert
		assertSame("The returned country should be the same as the one set", country, returnedCountry);
	}

	@Test
	@Category(Categories.valid.class)
	public void getCountryReturnsNullWhenNoCountrySet() {
		// Arrange
		Address address = new Address();
		// Act
		Country returnedCountry = address.getCountry();
		// Assert
		assertNull("The returned country should be null when no country has been set", returnedCountry);
	}

	@Test
	@Category(Categories.valid.class)
	public void getCountryReturnsLatestSetCountry() {
		// Arrange
		Address address = new Address();
		Country firstCountry = new Country("isoCode1", "name1", "printableName1", "iso31", "numcode1");
		Country secondCountry = new Country("isoCode2", "name2", "printableName2", "iso32", "numcode2");
		address.setCountry(firstCountry);
		address.setCountry(secondCountry);
		// Act
		Country returnedCountry = address.getCountry();
		// Assert
		assertSame("The returned country should be the same as the latest one set", secondCountry, returnedCountry);
	}

	@Test
	@Category(Categories.valid.class)
	public void testEqualsWithSameObjects() {
		Address address1 = new Address("Street 1", "City", "Zipcode", new Country());
		assertTrue(address1.equals(address1));
	}

	@Test
	@Category(Categories.invalid.class)
	public void testEqualsWithDifferentClasses() {
		Address address = new Address("Street 1", "City", "Zipcode", new Country());
		Country country = new Country();
		assertFalse(address.equals(country));
	}

	@Test
	@Category(Categories.invalid.class)
	public void testEqualsWithSameClassDifferentValues() {
		Address address1 = new Address("Street 1", "City", "Zipcode", new Country());
		Address address2 = new Address("Street 2", "City", "Zipcode", new Country());
		assertFalse(address1.equals(address2));
	}

	@Test
	@Category(Categories.valid.class)
	public void testEqualsWithSameClassSameValues() {
		Address address1 = new Address("Street 1", "City", "Zipcode", new Country());
		Address address2 = new Address("Street 1", "City", "Zipcode", new Country());
		assertTrue(address1.equals(address2));
	}

	@Test
	@Category(Categories.valid.class)
	public void testHashCodeWithValidFields() {
		Country country = new Country("isoCode", "name", "printableName", "iso3", "numcode");
		Address address = new Address("street1", "city", "zipcode", country);
		int expectedHash = Objects.hash("street1", "city", "zipcode");
		assertEquals("The hash codes should be equal", expectedHash, address.hashCode());
	}

	@Test
	@Category(Categories.boundary.class)
	public void testHashCodeWithNullFields() {
		Country country = new Country("isoCode", "name", "printableName", "iso3", "numcode");
		Address address = new Address(null, null, "zipcode", country);
		int expectedHash = Objects.hash(null, null, "zipcode");
		assertEquals("The hash codes should be equal even with null fields", expectedHash, address.hashCode());
	}

	@Test
	@Category(Categories.boundary.class)
	public void testHashCodeWithAllNullFields() {
		Address address = new Address();
		int expectedHash = Objects.hash(null, null, null);
		assertEquals("The hash codes should be equal even with all null fields", expectedHash, address.hashCode());
	}

	@Test
	@Category(Categories.valid.class)
	public void testHashCodeWithIdenticalObjects() {
		Country country = new Country("isoCode", "name", "printableName", "iso3", "numcode");
		Address address1 = new Address("street1", "city", "zipcode", country);
		Address address2 = new Address("street1", "city", "zipcode", country);
		assertEquals("The hash codes of two identical objects should be equal", address1.hashCode(),
				address2.hashCode());
	}

	@Category(Categories.valid.class)
	@Test
	public void testToStringOnValidAddressObject() {
		// Arrange
		Country country = new Country("US", "United States", "USA", "US", "840");
		Address address = new Address("Street1", "City", "Zipcode", country);
		address.setStreet2("Street2");
		address.setState("State");
		// Act
		String actualResult = address.toString();
		// Assert
		String expectedResult = "Address{street1='Street1', street2='Street2', city='City', state='State', zipcode='Zipcode', country=United States}";
		assertEquals(expectedResult, actualResult);
	}

	@Category(Categories.invalid.class)
	@Test
	public void testToStringOnAddressObjectWithNullFields() {
		// Arrange
		Address address = new Address();
		// Act
		String actualResult = address.toString();
		// Assert
		String expectedResult = "Address{street1='null', street2='null', city='null', state='null', zipcode='null', country=null}";
		assertEquals(expectedResult, actualResult);
	}

	@Category(Categories.boundary.class)
	@Test
	public void testToStringOnAddressObjectWithEmptyFields() {
		// Arrange
		Country country = new Country("", "", "", "", "");
		Address address = new Address("", "", "", country);
		address.setStreet2("");
		address.setState("");
		// Act
		String actualResult = address.toString();
		// Assert
		String expectedResult = "Address{street1='', street2='', city='', state='', zipcode='', country=}";
		assertEquals(expectedResult, actualResult);
	}

}
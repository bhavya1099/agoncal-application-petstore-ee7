package org.agoncal.application.petstore.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api;
import org.agoncal.application.petstore.constraints.NotEmpty;
import org.agoncal.application.petstore.constraints.Price;
import javax.persistence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;

public class Item480Test {

	/*
	 * ROOST_METHOD_HASH=equals_b0216dec0a ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalObjectsShouldReturnTrue() {

		Item item1 = new Item("ItemName", 10.0f, "path/image.png", "ItemDescription", null);
		Item item2 = new Item("ItemName", 10.0f, "path/image.png", "ItemDescription", null);

		assertTrue(item1.equals(item2));
	}

	/*
	 * ROOST_METHOD_HASH=equals_b0216dec0a ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void comparingWithNullShouldReturnFalse() {

		Item item = new Item("ItemName", 10.0f, "path/image.png", "ItemDescription", null);

		assertFalse(item.equals(null));
	}

	/*
	 * ROOST_METHOD_HASH=equals_b0216dec0a ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void comparingDifferentClassesShouldReturnFalse() {

		Item item = new Item("ItemName", 10.0f, "path/image.png", "ItemDescription", null);
		String differentClassObject = "SomeString";

		assertFalse(item.equals(differentClassObject));
	}

	/*
	 * ROOST_METHOD_HASH=equals_b0216dec0a ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalObjectsWithEmptyNameShouldReturnTrue() {

		Item item1 = new Item("", 10.0f, "path/image.png", "", null);
		Item item2 = new Item("", 10.0f, "path/image.png", "", null);

		assertTrue(item1.equals(item2));
	}

	/*
	 * ROOST_METHOD_HASH=equals_b0216dec0a ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void comparingDifferentNamesShouldReturnFalse() {

		Item item1 = new Item("ItemName1", 10.0f, "path/image.png", "ItemDescription", null);
		Item item2 = new Item("ItemName2", 10.0f, "path/image.png", "ItemDescription", null);

		assertFalse(item1.equals(item2));
	}

	/*
	 * ROOST_METHOD_HASH=equals_b0216dec0a ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void comparingDifferentDescriptionsShouldReturnFalse() {

		Item item1 = new Item("ItemName", 10.0f, "path/image.png", "ItemDescription1", null);
		Item item2 = new Item("ItemName", 10.0f, "path/image.png", "ItemDescription2", null);

		assertFalse(item1.equals(item2));
	}

	/*
	 * ROOST_METHOD_HASH=equals_b0216dec0a ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void selfComparisonShouldReturnTrue() {

		Item item = new Item("ItemName", 10.0f, "path/image.png", "ItemDescription", null);

		assertTrue(item.equals(item));
	}

	/*
	 * ROOST_METHOD_HASH=equals_b0216dec0a ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void comparingPartiallyInitializedFieldsShouldHandleGracefully() {

		Item item1 = new Item(null, 10.0f, "path/image.png", null, null);
		Item item2 = new Item(null, 10.0f, "path/image.png", null, null);

		assertTrue(item1.equals(item2));
	}

	/*
	 * ROOST_METHOD_HASH=equals_b0216dec0a ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void comparingSameStaticFieldsShouldReturnFalse() {

		Item item1 = new Item("ItemName1", 10.0f, "path/image.png", "ItemDescription", null);
		Item item2 = new Item("ItemName2", 10.0f, "path/image.png", "ItemDescription2", null);

		assertFalse(item1.equals(item2));
	}

	/*
	 * ROOST_METHOD_HASH=toString_af9b31aa44 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateDefaultOutputForNullFields() {

		Item item = new Item();

		String actualOutput = item.toString();

		String expectedOutput = "Item{id=null, version=null, name='null', description='null', imagePath='null', unitCost=null, product=null}";
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_af9b31aa44 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateOutputForPopulatedFields() {

		Item item = new Item();

		item.id = 100L;

		item.name = "Laptop";

		item.unitCost = 1299.99f;

		String actualOutput = item.toString();

		String expectedOutput = "Item{id=100, version=null, name='Laptop', description='null', imagePath='null', unitCost=1299.99, product=null}";
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_af9b31aa44 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateOutputWhenProductFieldIsNonNull() {

		Product mockProduct = new Product("Mock Name", "Mock Description", null);
		Item item = new Item();
		item.product = mockProduct;

		String actualOutput = item.toString();

		String expectedOutput = "Item{id=null, version=null, name='null', description='null', imagePath='null', unitCost=null, product="
				+ mockProduct.toString() + "}";
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_af9b31aa44 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateOutputForAllPopulatedFields() {

		Product mockProduct = new Product("Tablet", "A lightweight tablet", null);
		Item item = new Item("Tablet", 499.99f, "/images/tablet.png", "A lightweight tablet", mockProduct);

		item.id = 1L;

		item.version = 1;

		String actualOutput = item.toString();

		String expectedOutput = "Item{id=1, version=1, name='Tablet', description='A lightweight tablet', imagePath='/images/tablet.png', unitCost=499.99, product="
				+ mockProduct.toString() + "}";
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_af9b31aa44 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateOutputForEmptyStringFields() {

		Item item = new Item();

		item.name = "";

		item.description = "";

		String actualOutput = item.toString();

		String expectedOutput = "Item{id=null, version=null, name='', description='', imagePath='null', unitCost=null, product=null}";
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_af9b31aa44 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateOutputForSpecialCharactersInFields() {

		Item item = new Item();

		item.name = "Laptop & Accessories";

		item.description = "Affordable! <Best Buy>";

		String actualOutput = item.toString();

		String expectedOutput = "Item{id=null, version=null, name='Laptop & Accessories', description='Affordable! <Best Buy>', imagePath='null', unitCost=null, product=null}";
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_af9b31aa44 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateOutputForNegativeNumericFields() {

		Item item = new Item();

		item.version = -1;

		item.unitCost = -5.99f;

		String actualOutput = item.toString();

		String expectedOutput = "Item{id=null, version=-1, name='null', description='null', imagePath='null', unitCost=-5.99, product=null}";
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_af9b31aa44 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateOutputForLargeNumericValues() {

		Item item = new Item();

		item.id = 999999999999L;

		item.unitCost = 99999999.99f;

		String actualOutput = item.toString();

		String expectedOutput = "Item{id=999999999999, version=null, name='null', description='null', imagePath='null', unitCost=99999999.99, product=null}";
		assertEquals(expectedOutput, actualOutput);
	}

}
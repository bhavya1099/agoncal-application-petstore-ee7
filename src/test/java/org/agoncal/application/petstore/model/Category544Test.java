package org.agoncal.application.petstore.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import nl.jqno.equalsverifier.EqualsVerifier;
import java.io.Serializable;
import org.junit.jupiter.api;
import javax.persistence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions.assertNotNull;

public class Category544Test {

	/*
	 * ROOST_METHOD_HASH=equals_1dee796967 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void categoryEqualsIdenticalObjects() {
		Category category1 = new Category("Books", null);
		Category category2 = new Category("Books", null);
		boolean result = category1.equals(category2);
		assert result == true : "Expected true for identical Category objects comparison";
	}

	/*
	 * ROOST_METHOD_HASH=equals_1dee796967 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void categoryEqualsDifferentObjects() {
		Category category1 = new Category("Books", null);
		Category category2 = new Category("Music", null);
		boolean result = category1.equals(category2);
		assert result == false : "Expected false for different Category objects comparison";
	}

	/*
	 * ROOST_METHOD_HASH=equals_1dee796967 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void categoryEqualsWithNull() {
		Category category = new Category("Books", null);
		boolean result = category.equals(null);
		assert result == false : "Expected false when comparing with null";
	}

	/*
	 * ROOST_METHOD_HASH=equals_1dee796967 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void categoryEqualsSelfComparison() {
		Category category = new Category("Books", null);
		boolean result = category.equals(category);
		assert result == true : "Expected true for self-comparison of Category object";
	}

	/*
	 * ROOST_METHOD_HASH=equals_1dee796967 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void categoryEqualsDifferentClass() {
		Category category = new Category("Books", null);
		String anotherClassObject = "Books";
		boolean result = category.equals(anotherClassObject);
		assert result == false : "Expected false when comparing with a different class object";
	}

	/*
	 * ROOST_METHOD_HASH=equals_1dee796967 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void categoryEqualsNullNameFields() {
		Category category1 = new Category(null, null);
		Category category2 = new Category(null, null);
		try {
			boolean result = category1.equals(category2);
			assert result == false : "NullPointerException should occur or return false";
		}
		catch (NullPointerException ex) {
			System.out.println("NullPointerException caught correctly");
		}
	}

	/*
	 * ROOST_METHOD_HASH=equals_1dee796967 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void categoryEqualsIrrelevantFields() {
		Category category1 = new Category("Books", "Description 1");
		Category category2 = new Category("Books", "Description 2");
		boolean result = category1.equals(category2);
		assert result == true : "Expected true despite difference in irrelevant fields";
	}

	/*
	 * ROOST_METHOD_HASH=equals_1dee796967 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void categoryEqualsStaticFieldsIgnored() {
		Category category1 = new Category("Books", null);
		Category category2 = new Category("Books", null);

		boolean result = category1.equals(category2);
		assert result == true : "Expected true; static fields should not affect comparison";
	}

	/*
	 * ROOST_METHOD_HASH=equals_1dee796967 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void categoryEqualsEmptyNameFields() {
		Category category1 = new Category("", null);
		Category category2 = new Category("", null);
		boolean result = category1.equals(category2);
		assert result == true : "Expected true for empty name fields";
	}

	/*
	 * ROOST_METHOD_HASH=equals_1dee796967 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void categoryEqualsSpecialCharacterNames() {
		Category category1 = new Category("C@tegory!!", null);
		Category category2 = new Category("C@tegory!!", null);
		boolean result = category1.equals(category2);
		assert result == true : "Expected true for name fields containing special characters";
	}

	/*
	 * ROOST_METHOD_HASH=equals_1dee796967 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void verifyEqualsMethodUsingEqualsVerifier() {
		EqualsVerifier.forClass(Category.class).verify();
	}

	/*
	 * ROOST_METHOD_HASH=toString_0225ad8fbc ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringReturnsNameWhenSetToValidString() {

		Category category = new Category("Electronics", "Category for electronic items");

		String actualName = category.toString();

		assertEquals("Electronics", actualName);
	}

	/*
	 * ROOST_METHOD_HASH=toString_0225ad8fbc ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringHandlesEmptyString() {

		Category category = new Category("", "Category with an empty name");

		String actualName = category.toString();

		assertEquals("", actualName);
	}

	/*
	 * ROOST_METHOD_HASH=toString_0225ad8fbc ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringHandlesNullNameGracefully() {

		Category category = new Category(null, "Category with null name");

		String actualName = category.toString();

		assertNotNull(actualName);

		assertEquals(null, actualName);
	}

}